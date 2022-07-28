<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单列表</title>
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
                <form class="layui-form layui-form-pane form-search" autocomplete="off" lay-filter="searchForm" >
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">订单号</label>
                        <div class="layui-input-inline">
                            <input name="oid" value="" placeholder="请输入订单号" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">用户名称</label>
                        <div class="layui-input-inline">
                            <input name="username" value="" placeholder="请输入用户名称" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">下单时间</label>
                        <div class="layui-input-inline">
                            <input id="time" name="time" value="" placeholder="请选择添加时间" class="layui-input" ></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary" lay-submit lay-filter="search" type="submit">
                            <i class="layui-icon"></i> 搜 索</button>
                    </div>
                </form>
            </fieldset>

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
        var laydate = layui.laydate;

        laydate.render({
            elem: '#time',
            range: true,
        });

        var where = {};

        var tableId = 'tableId';
        table.render(Object.assign({}, $.tableRenderConfing, {
            elem: '#tableId',
            url: '/action/convey/list', //数据接口
            where: where,
            method: 'post',
            contentType: 'application/json',
            // 订单号	用户名	上级用户	手机号	真实姓名	交易数额	添加时间	支付方式	类型	处理时间	操作
            cols: [[ //表头
                {field: 'orderNo', title: '订单号', sort: true}
                , {field: 'userAccount', title: '用户名'}
                , {field: 'xxx', title: '上级用户'}
                , {field: 'phoneNumber', title: '手机号'}
                , {field: 'realName', title: '真实姓名'}
                , {field: 'operaMount', title: '交易数额', sort: true}
                , {field: 'updateTime', title: '添加时间', width: 180, templet: '#goodsAddTime'}
                , {field: 'xxx', title: '支付方式'}
                , {
                    field: 'operaType', title: '类型', width: 120, templet: function (d) {
                        var map = {
                            1: '充值',
                            2: '减少',
                            3: '冻结',
                            4: '提取',
                        }
                        return map[d.operaType] || ''
                    }
                }
                , {field: 'xxx', title: '处理时间', width: 180, templet: '#goodsAddTime'}
                , {
                    field: 'operation', title: '操作', templet: function () {
                        return 'xxx'
                    }, width: 120
                }
            ]],
            id: tableId, // 容器唯一ID
        }));

        var actions = {
            onReloadData: function () {
                table.reloadData(tableId, {where: Object.assign({}, where, onGetSearchParams())});
            },
        }

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

        });

    });

</script>
</body>
</html>