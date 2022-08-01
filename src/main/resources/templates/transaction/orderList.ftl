<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单列表</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-card layui-bg-gray">
    <div class="layui-card-body layui-anim layui-anim-upbit">
        <div class="think-box-shadow">
            <fieldset>
                <legend>条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" autocomplete="off" lay-filter="searchForm" >
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">订单号</label>
                        <div class="layui-input-inline">
                            <input name="lno" value="" placeholder="请输入订单号" class="layui-input"></div>
                    </div>
                    <!--                    <div class="layui-form-item layui-inline">-->
                    <!--                        <label class="layui-form-label">用户名称</label>-->
                    <!--                        <div class="layui-input-inline">-->
                    <!--                            <input name="username" value="" placeholder="请输入用户名称" class="layui-input">-->
                    <!--                        </div>-->
                    <!--                    </div>-->
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
            cols: [[ //表头
                {field: 'lno', title: '订单号', width: 150, sort: true}
                // , {field: 'userAccount', title: '用户名'}
                // , {field: 'xxx', title: '上级用户'}
                , {field: 'goodsName', title: '商品名称'}
                , {field: 'goodsCount', title: '商品数量', sort: true}
                , {field: 'shopName', title: '商店名称'}
                , {field: 'balance', title: '余额', sort: true}
                , {field: 'amount', title: '交易金额', sort: true}
                , {field: 'addtime', title: '下单时间', width: 180, templet: function (d) {
                        return layui.util.toDateString(d.addtime, 'yyyy年MM月dd日 HH:mm:ss')
                    } }
                , {field: 'endtime', title: '完成交易时间', width: 180, templet: function (d) {
                        return layui.util.toDateString(d.endtime, 'yyyy年MM月dd日 HH:mm:ss')
                    }}
                , {field: 'shopName', title: '商店名称'}
                , {field: 'status', title: '状态', templet: function (d) {
                        // 订单状态 0待付款 1交易完成 2用户取消 3强制完成 4强制取消 5交易冻结
                        var map = {
                            0: '待付款',
                            1: '交易完成',
                            2: '用户取消',
                            3: '强制完成',
                            4: '强制取消',
                            5: '交易冻结',
                        }
                        return map[d.status] || ''
                    }}
                , {field: 'qiang', title: '抢单数', sort: true }
                , {field: 'sign', title: '是否卡单', templet: function (d) {
                        // string 0不卡卡1卡单
                        return d.sign === '1' ? '卡单' : '不卡单'
                    }}
                , {field: 'cStatus', title: '佣金发放状态', width: 120, templet: function (d) {
                        // 	string 佣金发放状态 0未发放 1已发放 2账号冻结
                        switch (d.cStatus) {
                            case '0':
                                return '未发放';
                            case '1':
                                return '已发放';
                            case '2':
                                return '账号冻结';
                            default:
                                return ''
                        }
                    }}
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