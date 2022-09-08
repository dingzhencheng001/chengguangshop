<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>提现管理</title>
    <#include "../resource.ftl"/>
</head>


<body>
<div class="layui-card layui-bg-gray">
    <div class="layui-card-body layui-anim layui-anim-upbit">
        <div class="think-box-shadow">

            <fieldset>
                <legend data-locale="conditionalSearch">条件搜索</legend>
                <form class="layui-form layui-form-pane form-search" lay-filter="searchForm" autocomplete="off">
                    <div class="layui-form-item layui-inline" style="margin-right: 10px">
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-danger" id="agree" data-locale="withdrawal.batchPass">批量通过</button>
                        <button type="button" class="layui-btn layui-btn-sm layui-btn-warning" id="refuse" data-locale="withdrawal.batchRejection">批量拒绝</button>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="withdrawal.orderNo">订单号</label>
                        <div class="layui-input-inline">
                            <input name="orderNo" value="" data-placeholder="withdrawal.petOrderNo" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="withdrawal.userAccount">用户名称</label>
                        <div class="layui-input-inline">
                            <input name="userAccount" value="" data-placeholder="withdrawal.petUserAccount" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label" data-locale="withdrawal.startTime">发起时间</label>
                        <div class="layui-input-inline">
                            <input id="time" name="time" value="" data-placeholder="withdrawal.petStartTime" class="layui-input" >
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <button class="layui-btn layui-btn-primary" lay-submit lay-filter="search" type="submit" data-locale="search"><i class="layui-icon"></i> 搜 索</button>
                        <!--                        <a class="layui-btn layui-btn-danger">-->
                        <!--                            <i class="layui-icon"></i>-->
                        <!--                            导 出</a>-->
                    </div>
                </form>
            </fieldset>

            <table id="tableId" lay-filter="tableId" style="margin-top: 5px"></table>
        </div>
    </div>
</div>

<!--操作-->
<script type="text/html" id="operation">
    <!--    status	integer($int32) 操作类型【1.待审核 2.已驳回 3.已打款 】-->
    {{#  if(d.status === 1){ }}
    <a class="layui-btn layui-btn-xs" style="background:green;" lay-event="adopt">{{$t('withdrawal.adopt')}}</a>
    <a class="layui-btn layui-btn-xs" style="background:red;" lay-event="reject">{{$t('withdrawal.reject')}}</a>
    {{#  } else if (d.status === 2) {  }}
    {{$t('withdrawal.status2')}}
    {{#  } else if (d.status === 3) {  }}
    {{$t('withdrawal.status3')}}
    {{# } }}
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
            url: '/action/withdrawal/list', //数据接口
            // url: 'http://localhost:8080/action/withdrawal/list', //数据接口
            where: where,
            method: 'post',
            contentType: 'application/json',
            // 订单号	提现用户	上级用户	提现金额	手续费	实际到账	收款信息	联系电话	发起时间	处理时间	状态	订单状态	备注
            cols: [[ //表头
                { field: 'id', type: 'checkbox'}
                , {field: 'orderNo', title: $t('withdrawal.orderNo'), sort: true}
                , {field: 'userAccount', title: $t('withdrawal.withdrawalUser')}
                // , {field: 'xxx', title: $t('withdrawal.superiorUser')}
                , {field: 'operaMount', title: $t('withdrawal.operaMount'), templet: function (d) {
                        return $.financial(d.operaMount)
                    },}
                // , {field: 'withdrawalTimes', width: 120, title: $t('withdrawal.withdrawalTimes')}
                // , {field: 'xxx', title: $t('withdrawal.serviceCharge')}
                // , {field: 'xxx', title: $t('withdrawal.actualArrival'), sort: true}
                // , {field: 'xxx', title: $t('withdrawal.collectionInfo'), sort: true}
                , {field: 'phoneNumber', title: $t('withdrawal.phoneNumber'), sort: true}
                , {field: 'createTime', title: $t('withdrawal.startTime'), width: 180, templet: function (d) {
                        return layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')
                    }}
                // ,
                // {field: 'dealTime', title: $t('withdrawal.dealTime'), width: 180, templet: function (d) {
                //         return layui.util.toDateString(d.dealTime, 'yyyy-MM-dd日 HH:mm:ss')
                //     }}

                , {field: 'status', title: $t('withdrawal.status'), templet: function (d) {
                        // status	integer($int32) 操作类型【1.待审核 2.已驳回 3.已打款 】
                        var map = {
                            1: $t('withdrawal.status1'),
                            2: $t('withdrawal.status2'),
                            3: $t('withdrawal.status3'),
                        }
                        return map[d.status] || ''
                    }}
                // , {field: 'xxx', title: $t('withdrawal.orderStatus'), sort: true}
                , {field: 'remark', title: $t('withdrawal.remark')}
                , {
                    field: 'operation', title: $t('operation'), templet: '#operation', fixed: 'right', width: 140
                }
            ]],
            id: tableId, // 容器唯一ID
        }));

        table.on('checkbox(tableId)', function(obj){
            console.log(obj)
        });

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

            if (layEvent === 'adopt') { // 单个通过
                layer.confirm($t('withdrawal.adoptConfirmation'), {
                    title: $t('operationConfirmation'),
                    btn: [$t('confirm'), $t('cancel')],
                }, function (index) {
                    var ids = [data.id]
                    $.request({
                        url: '/action/withdrawal/approval/batch',
                        data: {
                            ids: ids,
                            // status	integer($int32) 操作类型【1.待审核 2.已驳回 3.已打款 】
                            status: 3,
                        },
                        type: 'post',
                        showLoading: true,
                        success: function () {
                            layer.close(index);
                            layer.msg($t('withdrawal.passed'), {icon: 1});
                            actions.onReloadData();
                        }
                    })
                });
            } else if (layEvent === 'reject') { //  单个驳回
                layer.prompt({
                    formType: 2,
                    value: '',
                    title: $t('withdrawal.reasonForRejection'),
                    area: ['400px', '100px'], //自定义文本域宽高
                }, function(value, index){
                    // layer.close(index);
                    $.request({
                        url: '/action/withdrawal/reject',
                        type: 'post',
                        data: {
                            id: data.id,
                            remark: value
                        },
                        showLoading: true,
                        success: function () {
                            layer.close(index);
                            layer.msg($t('withdrawal.rejected'), {icon: 1});
                            actions.onReloadData();
                        }
                    })
                });
            }

        });

        // 通过
        var onAgree = function () {
            var checkStatus = table.checkStatus(tableId);
            var ids = checkStatus.data.map(function (item) {
                return item.id;
            });
            if (ids.length === 0) {
                layer.msg($t('pleaseSelectItem'), {icon: 2});
                return false;
            }
            $.request({
                url: '/action/withdrawal/approval/batch',
                data: {
                    ids: ids,
                    // status	integer($int32) 操作类型【1.待审核 2.已驳回 3.已打款 】
                    status: 3,
                },
                type: 'post',
                showLoading: true,
                success: function () {
                    actions.onReloadData();
                    layer.msg($t('withdrawal.batchPassSuccess'), {icon: 1});
                }
            });
            return false;
        }
        $('#agree').click(onAgree);

        // 拒绝
        var onRefuse = function () {
            var checkStatus = table.checkStatus(tableId);
            var ids = checkStatus.data.map(function (item) {
                return item.id;
            });
            if (ids.length === 0) {
                layer.msg($t('pleaseSelectItem'), {icon: 2});
                return false;
            }
            $.request({
                url: '/action/withdrawal/approval/batch',
                data: {
                    ids: ids,
                    // status	integer($int32) 操作类型【1.待审核 2.已驳回 3.已打款 】
                    status: 2,
                },
                type: 'post',
                showLoading: true,
                success: function () {
                    actions.onReloadData();
                    layer.msg($t('withdrawal.batchRejectionSuccess'), {icon: 1});
                }
            });
            return false;
        }
        $('#refuse').click(onRefuse);

    });

</script>
</body>

</html>