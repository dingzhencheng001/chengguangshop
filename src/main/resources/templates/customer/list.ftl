<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客服管理</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-card layui-bg-gray">
    <div class="layui-card-body layui-anim layui-anim-upbit">
        <div class="think-box-shadow">
            <fieldset>
                <legend>条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" lay-filter="searchForm">
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">用户名称</label>
                        <div class="layui-input-inline">
                            <input name="userName" value="" placeholder="请输入用户名称" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">手机号码</label>
                        <div class="layui-input-inline">
                            <input name="phoneNumber" value="" placeholder="请输入手机号码" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline"><label class="layui-form-label">注册时间</label>
                        <div class="layui-input-inline">
                            <input data-date-range="" name="time" value="" id="timeInput"
                                   placeholder="请选择注册时间" class="layui-input"
                                   autocomplete="off">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary" lay-submit lay-filter="search" type="submit"><i
                                    class="layui-icon"></i> 搜 索
                        </button>
                    </div>
                </form>
            </fieldset>

            <div class="layui-btn-container" style="margin-top: 20px;">
                <button class="layui-btn" id="createBtn">添加客服</button>
            </div>

            <table id="tableId" lay-filter="tableId" style="margin-top: 5px"></table>
        </div>
    </div>


    <div id="formBodyId" style="display: none">
        <form class="layui-form layui-card" autocomplete="off"  lay-filter="form">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">用户名称</label>
                    <div class="layui-input-block">
                        <input name="userName" lay-verify="required" placeholder="请输入用户名称" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">手机号码</label>
                    <div class="layui-input-block">
                        <input name="phoneNumber" lay-verify="phone" placeholder="请输入手机号码" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" id="pwdItem">
                    <label class="layui-form-label">登录密码</label>
                    <div class="layui-input-block">
                        <input name="password" id="pwd" placeholder="留空则不更改密码" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ</label>
                    <div class="layui-input-block">
                        <input name="qq" placeholder="请输入QQ号" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">链接</label>
                    <div class="layui-input-block">
                        <input name="url" placeholder="请输入链接" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">微信</label>
                    <div class="layui-input-block">
                        <input name="wechat" placeholder="请输入微信" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">二维码</label>
                    <div>
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>上传图片
                        </button>
                        <img  id="upload-img" style="display: none; width: 150px;margin-left: 12px;" src="">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">时间范围</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="time" id="time" value="" placeholder="请选择时间范围">
                    </div>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="layui-form-item text-center">
                <button class="layui-btn" type="submit" lay-submit lay-filter="formSubmit">提交</button>
                <button class="layui-btn layui-btn-danger" type="button" id="closeBtn">取消</button>
            </div>
        </form>
    </div>

</div>

<!--操作-->
<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs" style="background:red;" lay-event="toggleState">{{=d.status === 1 ? '启用' :
        '禁用'}}</a>
</script>

<script>
    layui.use(['table', 'form', 'laydate', 'upload'], function () {
        var table = layui.table, $ = layui.$, form = layui.form, laydate = layui.laydate;
        var upload = layui.upload;
        // var params = $.getUrlVars();
        laydate.render({
            elem: '#time'
            ,range: true
            ,type: 'time'
        });
        laydate.render({
            elem: '#timeInput',
            range: true //或 range: '~' 来自定义分割字符
        });
        var operationType = 'add'; // add || edit
        var detailsData = {};

        form.verify({
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });

        // 查询详情数据
        var onGetDetails = function (id) {
            $.request({
                url: '/action/goods/sort/select/' + id,
                showLoading: true,
                success: function (result) {
                    detailsData = result.data;
                    $('#upload-img').attr('src', detailsData.qrCode);
                    form.val('form', detailsData);
                }
            })
        }
        var where = {};

        var tableCurrentItem = {};
        var tableId = 'tableId';
        table.render(Object.assign({}, $.tableRenderConfing, {
            elem: '#tableId',
            url: '/action/customer/list', //数据接口
            where: where,
            method: 'post',
            contentType: 'application/json',
            // ID 用户名 手机号 QQ 链接 微信 微信二维码 添加时间
            cols: [[ //表头
                {field: 'id', title: 'ID', width: 60, sort: true}
                , {field: 'userName', title: '用户名'}
                , {field: 'phoneNumber', title: '手机号', width: 110}
                , {field: 'qq', title: 'QQ', width: 120 }
                , {field: 'url', title: '链接'}
                , {field: 'wechat', title: '微信'}
                , {field: 'qrCode', title: '微信二维码'}
                , {field: 'createTime', title: '添加时间', width: 180, templet: function (d) {
                        return layui.util.toDateString(d.createTime, 'yyyy年MM月dd日 HH:mm:ss')
                    }}
                , {field: 'operation', title: '操作', templet: '#operation', fixed: 'right', width: 120}
            ]],
            id: tableId, // 容器唯一ID
        }));

        var actions = {
            onReloadData: function () {
                var searchData = form.val('searchForm');
                console.log('searchData', searchData);
                table.reloadData(tableId, {where: Object.assign({}, where, searchData)});
            },
        }

        // 搜索
        form.on('submit(search)', function () {
            actions.onReloadData();
            return false;
        });

        //单元格工具事件
        table.on('tool(tableId)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            // var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            // 设置当前选择项
            tableCurrentItem = Object.assign({}, data);

            if (layEvent === 'edit') {
                operationType = 'edit';
                $('#pwdItem .layui-form-label').removeClass('label-required');
                $('#pwd').attr('placeholder', '留空则不更改密码');
                $('#pwd').attr('lay-verify', '');
                formIndex = layer.open({
                    type: 1,
                    title: '编辑客服',
                    area: '800px',
                    content: $('#formBodyId'),
                    success: function () {
                        $('#formBodyId').show();
                        $('#upload-img').attr('src', tableCurrentItem.qrCode);
                        var time = tableCurrentItem.beginTime;
                        form.val('form', Object.assign({}, tableCurrentItem, {
                            item: ' - '
                        }));
                    },
                    cancel: function () {
                        onFormClose();
                    },
                });
            } else if (layEvent === 'toggleState') {
                console.log('toggleState', data);
                <!--    status	integer($int32)-->
                <!--    帐号状态（0正常 1停用）-->
            }

        });

        var formIndex;
        // 添加
        $('#createBtn').click(function () {
            operationType = 'add';
            $('#pwdItem .layui-form-label').addClass('label-required');
            $('#pwd').attr('placeholder', '请输入6-12位密码');
            $('#pwd').attr('lay-verify', 'pass');
            formIndex = layer.open({
                type: 1,
                title: '添加客服',
                area: '800px',
                content: $('#formBodyId'),
                success: function () {
                    $('#formBodyId').show();
                },
                cancel: function () {
                    onFormClose();
                },
            });
        });


        var onAdd = function () {
            var fd = Object.assign({}, form.val('form'), {
                qrCode: $('#upload-img').attr('src')
            });
            var times = $.getRangeTime(fd.time);
            fd.beginTime = times[0];
            fd.endTime = times[1];
            delete fd.file;
            delete fd.time;
            $.request({
                url: '/action/customer/create',
                type: 'post',
                data: fd,
                showLoading: true,
                success: function (result) {
                    layer.msg('创建成功', {icon: 1});
                    onFormClose();
                    actions.onReloadData();
                },
            });
        }
        var onEdit = function () {
            var fd = Object.assign({}, detailsData, form.val('form'), {
                qrCode: $('#upload-img').attr('src')
            });
            $.request({
                url: '/action/xxx',
                type: 'post',
                data: fd,
                showLoading: true,
                success: function (result) {
                    layer.msg('编辑成功', {icon: 1});
                    onFormClose();
                    actions.onReloadData();
                },
            });
        }

        form.on('submit(formSubmit)', function (data) {
            if (operationType === 'edit') {
                onEdit();
            } else {
                onAdd();
            }
            console.log('formSubmit', data.field);
            return false;
        });
        var onFormClose = function () {
            form.val('form', {
                userName: '',
                phoneNumber: '',
                password: '',
                qq: '',
                url: '',
                wechat: '',
                qrCode: '',
                time: '',
            });
            $('#upload-img').attr('src', '')
            $('#formBodyId').hide();
            layer.close(formIndex);
        }
        $('#closeBtn').click(onFormClose);

        var uploadIndex;
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            , url: '/action/file/upload' //上传接口
            , acceptMime: 'image/*'
            , before: function (obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
                uploadIndex = layer.load(1); //上传loading
            }
            , done: function (res) {
                layer.close(uploadIndex);
                var data = res.data || [];
                var path = data[0].path;
                var fileFullPath = $.getFileFullPath(path);
                $('#upload-img').attr('src', fileFullPath).show();
                layer.msg('上传成功', {icon: 1});
                //上传完毕回调
            }
            , error: function (err) {
                $('#upload-img').attr('src', '').hide();
                layer.close(uploadIndex);
                layer.msg(err.msg, {icon: 2});
                //请求异常回调
            }
        });

    });

</script>
</body>
</html>