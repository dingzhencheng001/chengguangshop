<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-card layui-bg-gray">
<#--    <div class="layui-card-header layui-anim layui-anim-fadein notselect"><span-->
<#--                class="layui-icon layui-icon-next font-s10 color-desc margin-right-5"></span>商品管理-->
<#--        <div class="pull-right">-->
<#--            <button data-open="/admin/deal/add_goods.html" data-title="添加公告" class="layui-btn">添加商品</button>-->
<#--        </div>-->
<#--    </div>-->
    <div class="layui-card-body layui-anim layui-anim-upbit">
        <div class="think-box-shadow">
            <fieldset>
                <legend>条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" action="/admin/deal/goods_list.html?spm=m-69-70-71"
                      onsubmit="return false" method="get" autocomplete="off">
                    <div class="layui-form-item layui-inline"><label class="layui-form-label">商品名称</label>
                        <div class="layui-input-inline"><input name="title" value="" placeholder="请输入商品名称"
                                                               class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline"><label class="layui-form-label">价格区间</label>
                        <div class="layui-input-inline"><input type="text" name="min_price" placeholder="最小" value=""
                                                               autocomplete="off" class="layui-input"></div>
                        <div class="layui-form-mid">-</div>
                        <div class="layui-input-inline"><input type="text" name="max_price" placeholder="最大" value=""
                                                               autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline"><label class="layui-form-label">分类</label>
                        <div class="layui-input-inline"><select name="cid" id="selectList">
                                <option value="">所有分类</option>
                                <option value="2">TaoBao</option>
                                <option value="3">Tmall</option>
                                <option value="4">JD</option>
                                <option value="1">Pinduoduo</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary"><i class="layui-icon"></i> 搜 索</button>
                    </div>
                </form>
            </fieldset>
            <table id="tableId" lay-filter="tableId" style="margin-top: 5px"></table>
        </div>
        <script>
            function del_goods(id) {
                layer.confirm("确认要删除吗，删除后不能恢复", {title: "删除确认"}, function (index) {
                    $.ajax({
                        type: 'POST',
                        url: "/admin/deal/del_goods.html",
                        data: {
                            'id': id,
                            '_csrf_': "62da64056832f"
                        },
                        success: function (res) {
                            layer.msg(res.info, {time: 2500});
                            location.reload();
                        }
                    });
                }, function () {
                });
            }
        </script>
    </div>
</div>

<script>
    layui.use(['table', 'form', 'util', 'element', 'laydate'], function () {
        var table = layui.table, $ = layui.$, form = layui.form, util = layui.util;
        var element = layui.element;
        var laydate = layui.laydate;


    });
    // tableId
</script>
</body>
</html>