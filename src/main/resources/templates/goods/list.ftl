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
                <legend data-locale="conditionalSearch">条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" lay-filter="searchForm" >
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="goodsList.form.goodsName">商品名称</label>
                        <div class="layui-input-inline">
                            <input name="goodsName" value="" data-placeholder="goodsList.form.petGoodsName" placeholder="请输入商品名称" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="goodsList.form.priceRange">价格区间</label>
                        <div class="layui-input-inline">
                            <input type="text" name="minPrice" data-placeholder="goodsList.form.minimum" placeholder="最小" value="" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid">-</div>
                        <div class="layui-input-inline">
                            <input type="text" name="maxPrice" data-placeholder="goodsList.form.maximum" placeholder="最大" value="" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="goodsList.form.classify">分类</label>
                        <div class="layui-input-inline">
                            <select name="goodsSortId" id="classify"></select>
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary" data-locale="search" lay-submit lay-filter="search" type="submit"><i class="layui-icon"></i> 搜 索</button>
                    </div>
                </form>
            </fieldset>

            <div class="layui-btn-container" style="margin-top: 20px;">
                <button class="layui-btn" id="createBtn" data-locale="goodsList.addItem">添加商品</button>
            </div>

            <table id="tableId" lay-filter="tableId" style="margin-top: 5px"></table>
        </div>
    </div>
</div>

<!--添加时间-->
<script type="text/html" id="goodsAddTime">
    <div>{{ layui.util.toDateString(d.goodsAddTime, 'yyyy-MM-dd HH:mm:ss')}}</div>
</script>

<script>
    layui.use(['table', 'form', 'layer'], function () {
        var table = layui.table, $ = layui.$, form = layui.form;
        var layer = layui.layer;
        var where = {};

        console.warn('layer', layer);
        // layer.config({
        //     resize: false,
        //     // btn: ['1', '2'],
        // });

        var i18n = new I18n({
            onRender: function () {
                console.warn('onRender')
            }
        });
        window.i18n = i18n;
        var $t = i18n.$t;
        var editText = $t('edit');
        var deleteText = $t('delete');

        var tableId = 'tableId';
        table.render(Object.assign({}, $.tableRenderConfing, {
            elem: '#tableId',
            url: '/action/goods/list', //数据接口
            // url: 'http://localhost:8080' +'/action/goods/list', // 开发环境使用
            where: where,
            method: 'post',
            contentType: 'application/json',
            // 商品名称	商品价格	店铺名称	添加时间	状态
            cols: [[ //表头
                {field: 'id', title: $t('goodsList.table.goodsId'), sort: true}
                , {field: 'goodsName', title: $t('goodsList.table.goodsName')}
                , {field: 'goodsPrice', title: $t('goodsList.table.goodsPrice')}
                , {field: 'shopName', title: $t('goodsList.table.shopName')}
                , {field: 'classify', title: $t('goodsList.table.classify'), templet: function (d) {
                        return $.findName(goodsClassifyList, d.goodsSortId);
                    }}
                , {field: 'goodsAddTime', title: $t('goodsList.table.goodsAddTime'), width: 180, templet: '#goodsAddTime'}
                , {field: 'status', title: $t('goodsList.table.status'), width: 120, templet: function (d) {
                        // 上架状态 0不上架 1上架
                        var text = $t('goodsList.table.status' + d.status, '');
                        return text
                    }}
                , {field: 'operation', title: $t('goodsList.table.operation'), templet: function (d) {
                        return '<a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit">' + editText +'</a>\n' +
                            '<a class="layui-btn layui-btn-xs" style="background:red;" lay-event="del">'+ deleteText + '</a>'
                    }, fixed: 'right', width: 120}
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
                    title: $t('edit'),
                    content: '/addGoods.html?id=' + data.id,
                    end: function () {
                        console.warn('end');
                        actions.onReloadData();
                    }
                });
            } else if (layEvent === 'del') {
                layer.confirm($t('deleteConfirmation'),
                    {
                        title: $t('operationConfirmation'),
                        btn: [$t('confirm'), $t('cancel')],
                    },
                    function (index) {
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

        // 获取商品分类
        var goodsClassifyList = [];
        var onGoodsClassifyList = function () {
            $.request({
                url: '/action/goods/sort/listAll',
                success: function (result) {
                    goodsClassifyList = (result.data || []).map(function (item) {
                        return { name: item.sortName, value: item.id };
                    });
                    renderGoodsClassifyList();
                    console.log('r', result.data);
                }
            })
        }
        var renderGoodsClassifyList = function () {
            var select = document.querySelector('#classify');
            select.innerHtml = '';
            var o = document.createElement('option');
            o.setAttribute('value', '');
            o.innerText = '所有分类';
            select.appendChild(o);
            goodsClassifyList.forEach(function (item) {
                var o = document.createElement('option');
                o.setAttribute('value', item.value);
                o.innerText = item.name;
                select.appendChild(o);
            })
            form.render('select');
        }
        onGoodsClassifyList();

    });

</script>
</body>
</html>