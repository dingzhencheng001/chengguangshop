<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品分类</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-card layui-bg-gray">
    <div class="layui-card-body layui-anim layui-anim-upbit">
        <div class="think-box-shadow">
            <div class="layui-btn-container" style="margin-top: 20px;">
                <button class="layui-btn" id="createBtn" data-locale="goodsClassify.add">添加分类</button>
            </div>

            <table id="tableId" lay-filter="tableId" style="margin-top: 5px"></table>
        </div>
    </div>
</div>

<!--添加时间-->
<script type="text/html" id="goodsAddTime">
    <div>{{ layui.util.toDateString(d.goodsAddTime, 'yyyy-MM-dd HH:mm:ss')}}</div>
</script>

<!--操作-->
<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit" data-locale="edit">编辑</a>
    <a class="layui-btn layui-btn-xs" style="background:red;" lay-event="del">删除</a>
</script>

<script>
    layui.use(['table', 'form'], function () {
        var table = layui.table, $ = layui.$, form = layui.form;

        var i18n = new I18n();
        window.i18n = i18n;
        var $t = i18n.$t;
        var editText = $t('edit');
        var deleteText = $t('delete');

        var where = {};

        var tableId = 'tableId';
        table.render(Object.assign({}, $.tableRenderConfing, {
            elem: '#tableId',
            url: '/action/goods/sort/list', //数据接口
            // url: 'http://localhost:8080' +'/action/goods/sort/list', // 开发环境使用
            where: where,
            method: 'post',
            contentType: 'application/json',
            // 分类ID	分类名称	比例	简介	添加时间
            cols: [[ //表头
                {field: 'id', title: $t('goodsClassify.table.id'), sort: true}
                , {field: 'sortName', title: $t('goodsClassify.table.sortName')}
                , {field: 'commissionRate', title: $t('goodsClassify.table.commissionRate'), sort: true}
                , {field: 'explainSimple', title: $t('goodsClassify.table.explainSimple')}
                , {field: 'minAmount', title: $t('goodsClassify.table.minAmount'), sort: true}
                , {field: 'goodsAddTime', title: $t('goodsClassify.table.goodsAddTime'), width: 180, templet: '#goodsAddTime'}
                , {field: 'operation', title: $t('goodsClassify.table.operation'), templet: function () {
                        return '<a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit">'+ editText +'</a>\n' +
                            '<a class="layui-btn layui-btn-xs" style="background:red;" lay-event="del">' + deleteText +'</a>'
                    }, fixed: 'right', width: 120}
            ]],
            id: tableId, // 容器唯一ID
        } ));

        var actions = {
            onReloadData: function () {
                table.reloadData(tableId, {where: Object.assign({}, where)});
            },
        }

        //单元格工具事件
        table.on('tool(tableId)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            // var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            // 设置当前选择项
            // tableCurrentItem = Object.assign({}, data);

            if (layEvent === 'edit') {
                layer.open({
                    type: 2,
                    title: $t('edit'),
                    area: ['800px', '500px'],
                    content: '/addClassify.html?id=' + data.id,
                    end: function () {
                        actions.onReloadData();
                    }
                });
            } else if (layEvent === 'del') {
                layer.confirm($t('deleteConfirmation'), {title: $t('operationConfirmation')}, function (index) {
                    $.request({
                        url: '/action/goods/sort/delete/' + data.id,
                        success: function () {
                            layer.close(index);
                            layer.msg($t('deleteSucceeded'), {icon: 1});
                            actions.onReloadData();
                        }
                    })
                });
            }

        });

        // 添加分类
        $('#createBtn').click(function () {
            layer.open({
                type: 2,
                title: $t('add'),
                area: ['800px', '500px'],
                content: '/addClassify.html',
                end: function () {
                    actions.onReloadData();
                }
            });
        })

    });

</script>
</body>
</html>