<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-card layui-bg-gray">
    <!--    <div class="layui-card-header layui-anim layui-anim-fadein notselect"><span-->
    <!--            class="layui-icon layui-icon-next font-s10 color-desc margin-right-5"></span>商品管理-->
    <!--        <div class="pull-right">-->
    <!--            <button data-open="/admin/deal/add_goods.html" data-title="添加公告" class="layui-btn">添加商品</button>-->
    <!--        </div>-->
    <!--    </div>-->
    <div class="layui-card-body layui-anim layui-anim-upbit">
        <div class="think-box-shadow">
            <fieldset>
                <legend>条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" lay-filter="searchForm" >
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">商品名称</label>
                        <div class="layui-input-inline">
                            <input name="goodsName" value="" placeholder="请输入商品名称" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">价格区间</label>
                        <div class="layui-input-inline">
                            <input type="text" name="minPrice" placeholder="最小" value="" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid">-</div>
                        <div class="layui-input-inline">
                            <input type="text" name="maxPrice" placeholder="最大" value="" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">分类</label>
                        <div class="layui-input-inline">
                            <select name="cid" id="selectList">
                                <option value="">所有分类</option>
                                <option value="2">TaoBao</option>
                                <option value="3">Tmall</option>
                                <option value="4">JD</option>
                                <option value="1">Pinduoduo</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary" lay-submit lay-filter="search" type="submit"><i class="layui-icon"></i> 搜 索</button>
                    </div>
                </form>
            </fieldset>

            <div class="layui-btn-container" style="margin-top: 20px;">
                <button class="layui-btn" id="createBtn">添加商品</button>
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
            url: '/action/goods/list', //数据接口
            where: where,
            // 商品名称	商品价格	店铺名称	添加时间	状态
            cols: [[ //表头
                {field: 'id', title: '商品ID', sort: true}
                , {field: 'goodsName', title: '商品名称'}
                , {field: 'goodsPrice', title: '商品价格'}
                , {field: 'shopName', title: '店铺名称'}
                , {field: 'goodsAddTime', title: '添加时间', width: 180, templet: '#goodsAddTime'}
                , {field: 'status', title: '状态', width: 120, templet: function (d) {
                        // 上架状态 0不上架 1上架
                        return d.status === 0 ? '不上架' : '上架'
                    }}
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
            // tableCurrentItem = Object.assign({}, data);

            if (layEvent === 'edit') {
                layer.open({
                    type: 2,
                    area: ['800px', '500px'],
                    content: '/addGoods.html?id=' + data.id,
                    end: function () {
                        actions.onReloadData();
                    }
                });
            } else if (layEvent === 'del') {
                layer.confirm('确定要删除吗?', {title: '操作确认'}, function (index) {
                    $.request({
                        url: '/action/goods/delete/' + data.id,
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
                area: ['800px', '500px'],
                content: '/addGoods.html',
                end: function () {
                    console.warn('end');
                    actions.onReloadData();
                }
            });
            // window.parent.layui.tab.tabAdd({
            //     id: 'addGoods',
            //     title: '添加商品',
            //     icon: 'fa-file',
            //     url: '/addGoods.html'
            // })
        })

    });

</script>
</body>
</html>