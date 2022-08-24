layui.use(['table','form'], function () {
    var table = layui.table
        , $ = layui.$
        , form = layui.form;

    var i18n = new I18n();
    var $t = i18n.$t;
    window.i18n = i18n;
    window.$t = $t;

    table.render({
        elem: '#role-list'
        , type: 'post'
        , url: '/sys/role/listData' //数据接口
        , page: true //开启分页
        , cellMinWidth: 100 //全局定义常规单元格的最小宽度
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'roleName', title: $t('role.roleName'), sort: true}
            , {field: 'roleCode', title: $t('role.roleCode'), sort: true}
            , {field: 'roleStatus', title: $t('role.roleStatus'), sort: true, templet: '#switchTpl'}
            , {field: 'createTime', title: $t('role.createTime')}
            , {field: 'createUser', title: $t('role.createUser')}
            , {field: '', off: true, title: $t('operation'), align: 'center', toolbar: '#barDemo'}
        ]]
        , id: 'roleTable' // 容器唯一ID
    });

    //  监听工具条
    table.on('tool(role-list)', function (obj) {
        var data = obj.data;
        if (obj.event === 'userGrant') {
            layer.open({
                type : 2
                , title: $t('role.userGrant')
                , content: '/sys/role/grant?roleType=1&roleMenuTemp=&roleUserTemp=' + data.roleUser
                , area: ['350px', '500px']
                , maxmin: true
                , btn: [$t('confirm'), $t('cancel')]
                , yes: function (index, layero) {
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    var flag = iframeWin.roleGrent(data, 'user');
                    if (!flag) {
                        layer.close(index);
                    }
                }
            });
        } else if (obj.event === 'menuGrant') {
            layer.open({
                type : 2
                , title: $t('role.menuGrant')
                , content: '/sys/role/grant?roleType=2&roleUserTemp=&roleMenuTemp=' + data.roleMenu
                , area: ['350px', '500px']
                , maxmin: true
                , btn: [$t('confirm'), $t('cancel')]
                , yes: function (index, layero) {
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    var flag = iframeWin.roleGrent(data, 'menu');
                    if (!flag) {
                        layer.close(index);
                    }
                }
            });
        }
    });
    //  搜索按钮事件
    $('.layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    var active = {
        // 执行重载
        reload: function () {
            form.on('submit(reload)', function (data) {
                // 查询条件
                table.reload('roleTable', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: data.field
                });
                return false;
            })
        }
        //  重置
        , reset: function () {
            $(this).parents(".searchTable").find("input").val("");
            $(this).parents(".searchTable").find("select").val("");
        }
        // 新增
        , add: function () {
            layer.open({
                type: 2 //type：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                , title: $t('role.addText')
                , content: '/sys/role/add'
                , area: ['700px', '520px']
                , maxmin: true  //开启最大化最小化按钮
            });
        }
        // 修改
        , edit: function () {
            // 获取选中的数据
            var checkStatus = table.checkStatus('roleTable');
            var data = getTableRows(checkStatus, 1);
            if (data) {
                layer.open({
                    type: 2
                    , title: $t('role.editText')
                    , content: '/sys/role/add'
                    , area: ['700px', '520px']
                    , maxmin: true
                    , success: function (layero, index) {
                        // var body = layer.getChildFrame('body', index); // 弹出层ifram的body
                        // body.find('#loginid').val("123"); // 给ifram的form赋值
                        // var ifr = layero.find('iframe');
                        // console.log('ifr', ifr);
                        setTimeout(function () {
                            var iframeWin = window[layero.find('iframe')[0]['name']]; // 得到iframe页的窗口对象
                            iframeWin.parentParas(data);// 给ifram传值
                        }, 10)
                    }
                })
            }
        }
        // 删除
        , del: function () {
            // 获取选中的数据
            var checkStatus = table.checkStatus('roleTable');
            var data = getTableRows(checkStatus);
            if (data) {
                layer.confirm($t('deleteConfirmation'), {
                    title: $t('operationConfirmation'),
                    btn: [$t('confirm'), $t('cancel')],
                }, function (index) {
                    $.ajax({
                        type: "POST",
                        url: "/sys/role/del",
                        data: JSON.stringify(checkStatus.data),
                        dataType: "json",
                        contentType: "application/json",
                        success: function (result) {
                            if (result.code === 0) {
                                layui.table.reload('roleTable',{page: {curr: 1}});
                                layer.msg($t('operationSucceeded'), {icon: 1});
                            } else {
                                layer.msg(result.msg, {icon: 5});
                            }
                        }
                    });
                });
            }
        }
    };

});