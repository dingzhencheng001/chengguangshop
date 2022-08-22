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
                <legend data-locale="conditionalSearch">条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" autocomplete="off" lay-filter="searchForm" >
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="orderList.lno">订单号</label>
                        <div class="layui-input-inline">
                            <input name="lno" value="" data-placeholder="orderList.petLno" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="orderList.memberId">会员ID</label>
                        <div class="layui-input-inline">
                            <input name="memberId" value="" data-placeholder="orderList.petMemberId" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="orderList.phoneNumber">手机号</label>
                        <div class="layui-input-inline">
                            <input name="phoneNumber" value="" data-placeholder="orderList.petPhoneNumber" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="orderList.time">下单时间</label>
                        <div class="layui-input-inline">
                            <input id="time" name="time" value="" data-placeholder="orderList.petTime" class="layui-input" ></div>
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
            lang: i18n.locale === 'cn' ? 'cn' : 'en'
        });

        var where = {};

        var tableId = 'tableId';
        table.render(Object.assign({}, $.tableRenderConfing, {
            elem: '#tableId',
            // url: 'http://localhost:8080/action/convey/list', //数据接口
            url: '/action/convey/list', //数据接口
            where: where,
            method: 'post',
            contentType: 'application/json',
            cols: [[ //表头
                {field: 'memberId', title: $t('orderList.memberId'), width: 120, sort: true},
                {field: 'lno', title: $t('orderList.lno'), width: 150, sort: true}
                // , {field: 'userAccount', title: '用户名'}
                // , {field: 'xxx', title: '上级用户'}
                , {field: 'goodsName', title: $t('orderList.goodsName')}
                , {field: 'goodsCount', title: $t('orderList.goodsCount'), sort: true}
                , {field: 'shopName', title: $t('orderList.shopName')}
                , {field: 'balance', title: $t('orderList.balance'), templet: function (d) {
                        return $.financial(d.balance)
                    }, sort: true}
                , {field: 'amount', title: $t('orderList.amount'), templet: function (d) {
                        return $.financial(d.amount)
                    }, sort: true}
                , {field: 'commission', title: $t('orderList.commission'), templet: function (d) {
                        return $.financial(d.commission)
                    }, sort: true}
                , {field: 'amountAfterTransaction', title: $t('orderList.amountAfterTransaction'), templet: function (d) {
                        return $.financial(d.balance + d.commission)
                    }, width: 120, sort: true}
                , {field: 'addtime', title: $t('orderList.addtime'), width: 180, templet: function (d) {
                        return layui.util.toDateString(d.addtime, 'yyyy-MM-dd HH:mm:ss')
                    } }
                , {field: 'endtime', title: $t('orderList.endtime'), width: 180, templet: function (d) {
                        return layui.util.toDateString(d.endtime, 'yyyy-MM-dd HH:mm:ss')
                    }}
                , {field: 'status', title: $t('orderList.status'), templet: function (d) {
                        // 订单状态 0待付款 1交易完成 2用户取消 3强制完成 4强制取消 5交易冻结
                        var map = {
                            0: $t('orderList.status0'),
                            1: $t('orderList.status1'),
                            2: $t('orderList.status2'),
                            3: $t('orderList.status3'),
                            4: $t('orderList.status4'),
                            5: $t('orderList.status5'),
                        }
                        return map[d.status] || ''
                    }}
                , {field: 'qiang', title: $t('orderList.qiang'), sort: true }
                , {field: 'sign', title: $t('orderList.sign'), templet: function (d) {
                        // string 0不卡卡1卡单
                        return d.sign === '1' ? $t('orderList.sign1') : $t('orderList.sign0')
                    }}
                , {field: 'cStatus', title: $t('orderList.cStatus'), width: 120, templet: function (d) {
                        // 	string 佣金发放状态 0未发放 1已发放 2账号冻结
                        switch (d.cStatus) {
                            case '0':
                                return $t('orderList.cStatus0');
                            case '1':
                                return $t('orderList.cStatus1');
                            case '2':
                                return $t('orderList.cStatus2');
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