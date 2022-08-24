layui.use(['table','form'], function () {
    var table = layui.table
        , $ = layui.$
        , form = layui.form;

    var i18n = new I18n();
    var $t = i18n.$t;
    window.i18n = i18n;
    window.$t = $t;

    table.render({
        elem: '#menu-list'
        , type: 'post'
        , url: '/sys/menu/listData' //数据接口
        , page: true //开启分页
        , cellMinWidth: 100 //全局定义常规单元格的最小宽度
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'menuId', title: $t('menuList.menuId'), sort: true}
            , {field: 'menuName', title: $t('menuList.menuName'), sort: true}
            , {field: 'menuPname', title: $t('menuList.menuPname'), sort: true}
            , {field: 'menuUrl', title: 'Url'}
            , {field: 'menuParm', title: $t('menuList.menuParm')}
            , {field: 'typeName', title: $t('menuList.typeName'), templet: '#typeTpl'}
            , {field: 'menuIcon', title: $t('menuList.menuIcon'), templet: '#iconTpl'}
            , {field: 'menuSort', title: $t('menuList.menuSort'), sort: true}
        ]]
        , id: 'menuTable' // 容器唯一ID
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
                table.reload('menuTable', {
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
                , title: $t('menuList.addText')
                , content: '/sys/menu/add'
                , area: ['700px', '500px']
                , maxmin: true  //开启最大化最小化按钮
            });
        }
        // 修改
        , edit: function () {
            // 获取选中的数据
            var checkStatus = table.checkStatus('menuTable');
            var data = getTableRows(checkStatus, 1);
            if (data) {
                layer.open({
                    type: 2
                    , title: $t('menuList.editText')
                    , content: '/sys/menu/add'
                    , area: ['700px', '500px']
                    , maxmin: true
                    , success: function (layero, index) {
                        // var body = layer.getChildFrame('body', index); // 弹出层ifram的body
                        // body.find('#loginid').val("123"); // 给ifram的form赋值
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
            var checkStatus = table.checkStatus('menuTable');
            var data = getTableRows(checkStatus);
            if (data) {
                layer.confirm($t('deleteConfirmation'), {
                    title: $t('operationConfirmation'),
                    btn: [$t('confirm'), $t('cancel')],
                }, function (index) {
                    $.ajax({
                        type: "POST",
                        url: "/sys/menu/del",
                        data: JSON.stringify(checkStatus.data),
                        dataType: "json",
                        contentType: "application/json",
                        success: function (result) {
                            if (result.code === 0) {
                                layui.table.reload('menuTable',{page: {curr: 1}});
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