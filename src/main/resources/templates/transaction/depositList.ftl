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
                <legend data-locale="conditionalSearch">条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" lay-filter="searchForm" autocomplete="off">
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="deposit.orderNo">订单号</label>
                        <div class="layui-input-inline">
                            <input name="orderNo" value="" data-placeholder="deposit.petOrderNo" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="deposit.userAccount">用户名称</label>
                        <div class="layui-input-inline">
                            <input name="userAccount" value="" data-placeholder="deposit.petUserAccount" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="deposit.phoneNumber">手机号码</label>
                        <div class="layui-input-inline">
                            <input name="phoneNumber" value="" data-placeholder="deposit.petPhoneNumber" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="deposit.addTime">添加时间</label>
                        <div class="layui-input-inline">
                            <input id="time" name="time" value="" data-placeholder="deposit.petAddTime" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary" lay-submit lay-filter="search" type="submit" data-locale="search">
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
    <div>{{ layui.util.toDateString(d.goodsAddTime, 'yyyy-MM-dd HH:mm:ss')}}</div>
</script>

<script>
    layui.use(['table', 'form'], function () {
        var table = layui.table, $ = layui.$, form = layui.form;
        var laydate = layui.laydate;

        var i18n = new I18n();
        var $t = i18n.$t;
        window.i18n = i18n;
        window.$t = $t;

        laydate.render({
            elem: '#time',
            range: true,
            lang: i18n.locale === 'cn' ? 'cn' : 'en',
        });

        var where = {};

        var tableId = 'tableId';
        table.render(Object.assign({}, $.tableRenderConfing, {
            elem: '#tableId',
            url: '/action/deposit/list', //数据接口
            // url: 'http://localhost:8080/action/deposit/list', //数据接口
            where: where,
            method: 'post',
            contentType: 'application/json',
            // 订单号	用户名	上级用户	手机号	真实姓名	交易数额	添加时间	支付方式	类型	处理时间	操作
            cols: [[ //表头
                {field: 'orderNo', title: $t('deposit.orderNo'), sort: true}
                , {field: 'userAccount', title: $t('deposit.userAccount')}
                , {field: 'updateBy', title: $t('deposit.updateBy')}
                , {field: 'phoneNumber', title: $t('deposit.phoneNumber')}
                , {field: 'realName', title: $t('deposit.realName')}
                , {field: 'operaMount', title: $t('deposit.operaMount'), sort: true}
                , {field: 'createTime', title: $t('deposit.createTime'), width: 180, templet: '#goodsAddTime'}
                , {field: 'xxx', title: $t('deposit.paymentMethod')} // 支付方式
                , {
                    field: 'operaType', title: $t('deposit.operaType'), width: 120, templet: function (d) {
                        var map = {
                            1: $t('deposit.operaType1'),
                            2: $t('deposit.operaType2'),
                            3: $t('deposit.operaType3'),
                            4: $t('deposit.operaType4'),
                        }
                        return map[d.operaType] || ''
                    }
                }
                , { // 处理时间
                    field: 'createTime', title: $t('deposit.processingTime'), width: 180, templet: function (d) {
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