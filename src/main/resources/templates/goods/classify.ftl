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
                <button class="layui-btn" id="createBtn">添加分类</button>
            </div>

            <table id="tableId" lay-filter="tableId" style="margin-top: 5px"></table>
        </div>
    </div>
</div>

<!--添加时间-->
<script type="text/html" id="goodsAddTime">
    <div>{{ layui.util.toDateString(d.goodsAddTime, 'yyyy年MM月dd日 HH:mm:ss')}}</div>
</script>

<!--操作-->
<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs" style="background:red;" lay-event="del">删除</a>
</script>

<script>
    layui.use(['table', 'form'], function () {
        var table = layui.table, $ = layui.$, form = layui.form;
        var where = {};

        var tableId = 'tableId';
        table.render(Object.assign({}, $.tableRenderConfing, {
            elem: '#tableId',
            url: '/action/goods/sort/list', //数据接口
            where: where,
            method: 'post',
            contentType: 'application/json',
            // 分类ID	分类名称	比例	简介	添加时间
            cols: [[ //表头
                {field: 'id', title: '分类ID', sort: true}
                , {field: 'sortName', title: '分类名称'}
                , {field: 'commissionRate', title: '比例'}
                , {field: 'explainSimple', title: '简介'}
                , {field: 'goodsAddTime', title: '添加时间', width: 180, templet: '#goodsAddTime'}
                , {field: 'operation', title: '操作', templet: '#operation', fixed: 'right', width: 120}
            ]],
            id: tableId, // 容器唯一ID
        } ));

        var actions = {
            onReloadData: function () {
                var searchData = form.val('searchForm');
                console.log('searchData', searchData);
                table.reloadData(tableId, {where: Object.assign({}, where, searchData)});
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
                    area: ['800px', '400px'],
                    content: '/addClassify.html?id=' + data.id,
                    end: function () {
                        console.warn('end');
                        actions.onReloadData();
                    }
                });
            } else if (layEvent === 'del') {
                layer.confirm('确定要删除吗?', {title: '操作确认'}, function (index) {
                    $.request({
                        url: '/action/goods/sort/delete/' + data.id,
                        success: function () {
                            layer.close(index);
                            layer.msg('删除成功', {icon: 1});
                            actions.onReloadData();
                        }
                    })
                });
            }

        });

        // 添加商品
        $('#createBtn').click(function () {
            layer.open({
                type: 2,
                area: ['800px', '400px'],
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