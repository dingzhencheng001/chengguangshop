<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>充值列表</title>
    <#include "../resource.ftl"/>
</head>
<body>

<div class="layui-card layui-bg-gray">
    <div class="layui-card-body layui-anim layui-anim-upbit">
        <div class="think-box-shadow">
            <fieldset>
                <legend>条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" lay-filter="searchForm" autocomplete="off">
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">订单号</label>
                        <div class="layui-input-inline">
                            <input name="orderNo" value="" placeholder="请输入订单号" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">用户名称</label>
                        <div class="layui-input-inline">
                            <input name="userAccount" value="" placeholder="请输入用户名称" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">手机号码</label>
                        <div class="layui-input-inline">
                            <input name="phoneNumber" value="" placeholder="请输入手机号码" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">添加时间</label>
                        <div class="layui-input-inline">
                            <input id="time" name="time" value="" placeholder="请选择添加时间" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary" lay-submit lay-filter="search" type="submit"><i class="layui-icon"></i> 搜 索</button>
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
            url: '/action/deposit/list', //数据接口
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
                , {
                    field: 'xxx', title: '处理时间', width: 180, templet: function (d) {
                        return layui.util.toDateString(d.goodsAddTime, 'yyyy-MM-dd')
                    }
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