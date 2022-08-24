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
                <legend data-locale="conditionalSearch">条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" lay-filter="searchForm">
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="cs.userName">用户名称</label>
                        <div class="layui-input-inline">
                            <input name="userName" value="" data-placeholder="cs.petUserName" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="cs.phoneNumber">手机号码</label>
                        <div class="layui-input-inline">
                            <input name="phoneNumber" value="" data-placeholder="cs.petPhoneNumber" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline"><label class="layui-form-label" data-locale="cs.registrationTime">注册时间</label>
                        <div class="layui-input-inline">
                            <input data-date-range="" name="time" value="" id="timeInput"
                                   data-placeholder="cs.petRegistrationTime" class="layui-input"
                                   autocomplete="off">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary" lay-submit lay-filter="search" type="submit"><i
                                    class="layui-icon"></i>
                            <span data-locale="search">搜 索</span>
                        </button>
                    </div>
                </form>
            </fieldset>

            <div class="layui-btn-container" style="margin-top: 20px;">
                <button class="layui-btn" id="createBtn" data-locale="cs.addText">添加客服</button>
            </div>

            <table id="tableId" lay-filter="tableId" style="margin-top: 5px"></table>
        </div>
    </div>


    <div id="formBodyId" style="display: none">
        <form class="layui-form layui-card" autocomplete="off"  lay-filter="form">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="cs.userName">用户名称</label>
                    <div class="layui-input-block">
                        <input name="userName" lay-verify="required" data-placeholder="cs.petUserName" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="cs.phoneNumber">手机号码</label>
                    <div class="layui-input-block">
                        <input name="phoneNumber" lay-verify="phone" data-placeholder="cs.petPhoneNumber" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" id="pwdItem">
                    <label class="layui-form-label" data-locale="cs.password">登录密码</label>
                    <div class="layui-input-block">
                        <input name="password" id="pwd" data-placeholder="cs.petPassword" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ</label>
                    <div class="layui-input-block">
                        <input name="qq" data-placeholder="cs.petQQ" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="cs.url">链接</label>
                    <div class="layui-input-block">
                        <input name="url" data-placeholder="cs.petUrl" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="cs.wechat">微信</label>
                    <div class="layui-input-block">
                        <input name="wechat" data-placeholder="cs.petWechat" value="" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="cs.qrCode">二维码</label>
                    <div>
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>
                            <span data-locale="uploadPictures">上传图片</span>
                        </button>
                        <img  id="upload-img" style="display: none; width: 150px;margin-left: 12px;" src="">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label" data-locale="cs.timeFrame">时间范围</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="time" id="time" value="" data-placeholder="cs.petTimeFrame">
                    </div>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="layui-form-item text-center">
                <button class="layui-btn" type="submit" lay-submit lay-filter="formSubmit" data-locale="submit">提交</button>
                <button class="layui-btn layui-btn-danger" type="button" id="closeBtn" data-locale="cancel">取消</button>
            </div>
        </form>
    </div>

</div>

<!--操作-->
<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit">{{$t('edit')}}</a>
    {{#  if(d.status === 1){ }}
    <a class="layui-btn layui-btn-xs" style="background:green;" lay-event="toggleState">{{$t('enable')}}</a>
    {{#  } else { }}
    <a class="layui-btn layui-btn-xs" style="background:red;" lay-event="toggleState">{{$t('disable')}}</a>
    {{#  } }}

</script>

<script>
    layui.use(['table', 'form', 'laydate', 'upload'], function () {
        var table = layui.table, $ = layui.$, form = layui.form, laydate = layui.laydate;
        var upload = layui.upload;

        var i18n = new I18n();
        var $t = i18n.$t;
        window.i18n = i18n;
        window.$t = $t;

        // var params = $.getUrlVars();
        laydate.render({
            elem: '#time'
            ,range: true
            ,type: 'time'
            ,lang: i18n.locale === 'cn' ? 'cn' : 'en'
        });
        laydate.render({
            elem: '#timeInput',
            range: true, //或 range: '~' 来自定义分割字符
            lang: i18n.locale === 'cn' ? 'cn' : 'en'
        });
        var operationType = 'add'; // add || edit

        form.verify({
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            pass: [
                /^[\S]{6,12}$/
                ,$t('cs.passVerify')
            ]
        });
        var where = {};

        var tableCurrentItem = {};
        var tableId = 'tableId';
        table.render(Object.assign({}, $.tableRenderConfing, {
            elem: '#tableId',
            url: '/action/customer/list', //数据接口
            // url: 'http://localhost:8080/action/customer/list', //数据接口
            where: where,
            method: 'post',
            contentType: 'application/json',
            // ID 用户名 手机号 QQ 链接 微信 微信二维码 添加时间
            cols: [[ //表头
                {field: 'id', title: 'ID', width: 60, sort: true}
                , {field: 'userName', title: $t('cs.userName')}
                , {field: 'phoneNumber', title: $t('cs.phoneNumber'), width: 110}
                , {field: 'qq', title: 'QQ', width: 120 }
                , {field: 'url', title: $t('cs.url')}
                , {field: 'wechat', title: $t('cs.wechat')}
                , {field: 'qrCode', title: $t('cs.qrCode')}
                , {field: 'createTime', title: $t('cs.addTime'), width: 180, templet: function (d) {
                        return layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')
                    }}
                , {field: 'operation', title: $t('operation'), templet: '#operation', fixed: 'right', width: 120}
            ]],
            id: tableId, // 容器唯一ID
        }));

        var actions = {
            onReloadData: function () {
                table.reloadData(tableId, {where: Object.assign({}, where, onGetSearchParams())});
            },
            onUpdateItem: function (id, fields, cb) {
                $.request({
                    url: '/action/customer/update/' + id,
                    type: 'post',
                    contentType: 'application/json',
                    data: fields,
                    showLoading: true,
                    success: function () {
                        actions.onReloadData();
                        cb && cb();
                    }
                })
            },
        }

        // 搜索
        form.on('submit(search)', function () {
            actions.onReloadData();
            return false;
        });

        // 获取搜索参数
        var onGetSearchParams = function () {
            var searchData = form.val('searchForm');
            var times = $.getRangeTime(searchData.time);
            // searchData.status = Number(searchData.status) || null;
            // searchData.memberStatus = Number(searchData.memberStatus) || null;
            searchData.selectBeginTime = times[0];
            searchData.selectEndTime = times[1];
            delete searchData.time;
            return searchData;
        }

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
                $('#pwd').attr('placeholder', $t('cs.petPassword2'));
                $('#pwd').attr('lay-verify', '');
                formIndex = layer.open({
                    type: 1,
                    title: $t('cs.editText'),
                    area: '800px',
                    content: $('#formBodyId'),
                    success: function () {
                        $('#formBodyId').show();
                        $('#upload-img').attr('src', tableCurrentItem.qrCode);
                        var time = tableCurrentItem.beginTime ? (tableCurrentItem.beginTime + ' - ' + tableCurrentItem.endTime) : ''
                        form.val('form', Object.assign({}, tableCurrentItem, {
                            time,
                            // item: ' - '
                        }));
                    },
                    cancel: function () {
                        onFormClose();
                    },
                });
            } else if (layEvent === 'toggleState') {
                console.log('toggleState', data);
                actions.onUpdateItem(data.id, {status: data.status === 1 ? 0 : 1}, function () {
                    layer.msg($t('operationSucceeded'), {icon: 1});
                });
                <!--    status	integer($int32)-->
                <!--    帐号状态（0正常 1停用）-->
            }

        });

        var formIndex;
        // 添加
        $('#createBtn').click(function () {
            operationType = 'add';
            $('#pwdItem .layui-form-label').addClass('label-required');
            $('#pwd').attr('placeholder', $t('cs.petPassword'));
            $('#pwd').attr('lay-verify', 'pass');
            formIndex = layer.open({
                type: 1,
                title: $t('cs.addText'),
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
                    layer.msg($t('createSucceeded'), {icon: 1});
                    onFormClose();
                    actions.onReloadData();
                },
            });
        }
        var onEdit = function () {
            var fd = Object.assign({}, tableCurrentItem, form.val('form'), {
                qrCode: $('#upload-img').attr('src')
            });
            var times = $.getRangeTime(fd.time);
            fd.beginTime = times[0];
            fd.endTime = times[1];
            delete fd.file;
            delete fd.time;
            actions.onUpdateItem(tableCurrentItem.id, fd, function () {
                layer.msg($t('editSucceeded'), {icon: 1});
                onFormClose();
            })
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
                layer.msg($t('uploadSucceeded'), {icon: 1});
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