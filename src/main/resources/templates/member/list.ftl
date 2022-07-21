<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>会员列表</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-fluid member-list-page">

    <div class="think-box-shadow">
        <fieldset>
            <legend>条件搜索</legend>
            <form class="layui-form layui-form-pane form-search" lay-filter="searchForm" action="">
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">关键词</label>
                    <div class="layui-input-inline">
                        <input name="phoneNumber" value="" placeholder="请输入用户名称,手机号码,IP" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">注册时间</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="registrationTime" placeholder="请选择注册时间">
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-inline">
                        <select name="memberStatus">
                            <option value="">所有状态</option>
                            <option value="1">真人</option>
                            <option value="2">假人</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <button type="submit" class="layui-btn layui-btn-danger" lay-submit lay-filter="search"><i
                                class="layui-icon"></i> 搜 索
                    </button>
                    <!--                    <a href="#" class="layui-btn layui-btn-danger"><i class="layui-icon"></i> 导 出</a>-->
                </div>
            </form>

            <!--            <div class="layui-form-item">-->
            <!--                <div class="layui-input-inline">-->
            <!--                    <input id="dazhen_per" name="dazhen_per" value="" placeholder="请输入打针幅度"-->
            <!--                           class="layui-input"/>-->
            <!--                </div>-->
            <!--                <div class="layui-input-inline" style="margin-left: 8px;">-->
            <!--                    <input id="dazhen_ci" name="dazhen_per" value=""-->
            <!--                           placeholder="打针单数(不填代表每次)"-->
            <!--                           class="layui-input"/>-->
            <!--                </div>-->
            <!--                <button style="margin-left: 8px;" id="dazhen" class="layui-btn layui-btn-danger">-->
            <!--                    <i class="layui-icon"></i>-->
            <!--                    批量打针-->
            <!--                </button>-->
            <!--            </div>-->
        </fieldset>
        <!--        <script>-->
        <!--            var test = "0";-->
        <!--            $("#selectList").find("option[value=" + test + "]").prop("selected", true);-->
        <!--            form.render()-->
        <!--        </script>-->

    </div>

    <div class="layui-btn-container" style="margin-top: 20px;">
        <button class="layui-btn" id="createBtn">添加会员</button>
    </div>

    <table id="member-list" lay-filter="member-list" style="margin-top: 5px"></table>

    <!--修改邀请码表单-->
    <div id="upInviteCodeId" style="display: none">
        <form class="layui-form layui-card" action="">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">邀请码</label>
                    <div class="layui-input-block">
                        <input type="text" name="inviteCode" required
                               id="newInviteCode"
                               lay-verify="required" placeholder="请输入邀请码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center" style="text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="upInviteCodeSubmit">提交</button>
                    <button type="reset" class="layui-btn layui-btn-danger" id="dupInviteCodeCancel">取消</button>
                </div>
            </div>
        </form>
    </div>

    <!--扣款表单-->
    <div id="deductionId" style="display: none">
        <form class="layui-form layui-card" action="">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">金额</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" required lay-verify="required" placeholder="请输入金额"
                               autocomplete="off" class="layui-input">
                        <p class="help-block">正表示加，负表示扣</p>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">备注</label>
                    <div class="layui-input-block">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入备注"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center" style="text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="deductionSubmit">提交</button>
                    <button type="reset" class="layui-btn layui-btn-danger" id="deductionCancel">取消</button>
                </div>
            </div>
        </form>
    </div>

    <!--派单-->
    <div id="dispatchId" style="display: none">
        <form class="layui-form layui-card" action="">
            <h3 style="padding: 10px 0 0 45px; color: red;"> 该用户今日已抢单：0单 ## 卡单起始单数 1</h3>
            <h3 style="padding: 10px 0 0 45px; color: red;"> 说明：卡单 设置完毕后 大于卡单起始单数的 卡单 将被一起推送给用户</h3>
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label">1: 第几单</label>
                    <div class="layui-input-block J_div">
                        <input name="id_num[0]" placeholder="第几单" value=""
                               class="layui-input J_id_num"
                               style="display: inline; width: 10%;"/> min(元):
                        <input
                                name="min[0]" value="" placeholder="请输入min" class="layui-input J_min"
                                style="display: inline; width: 20%;"> max(元):
                        <input name="max[0]" value=""
                               placeholder="请输入max"
                               class="layui-input J_max"
                               style="display: inline; width: 20%;">卡单:
                        <input type="checkbox" name="lock[0]" value="1" class="layui-input J_sign" lay-filter="lock">
                        <div class="layui-unselect layui-form-checkbox"><i class="layui-icon layui-icon-ok"></i></div>
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center" style="text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="dispatchSubmit">提交</button>
                    <button type="reset" class="layui-btn layui-btn-danger" id="dispatchCancel">取消</button>
                </div>
            </div>
        </form>
    </div>

    <!--编辑菜单-->
    <div id="editId" style="display: none">
        <form class="layui-form layui-card" lay-filter="editForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">用户名称</label>
                    <div class="layui-input-block">
                        <input name="userAccount" required="" placeholder="请输入用户名称" value="" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">手机号码</label>
                    <div class="layui-input-block">
                        <input name="phoneNumber" required="" placeholder="请输入手机号码" value="" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">账号余额</label>
                    <div class="layui-input-block">
                        <input name="balance" type="number" min="0" required="" placeholder="请输入账号余额" value=""
                               class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">冻结金额</label>
                    <div class="layui-input-block">
                        <input name="freezeBalance" type="number" min="0" required="" placeholder="冻结金额" value=""
                               class="layui-input">
                    </div>
                </div>
                <!--                <div class="layui-form-item">-->
                <!--                    <div class="layui-inline">-->
                <!--                        <label class="layui-form-label label-required">匹配区间</label>-->
                <!--                        <div class="layui-input-inline"-->
                <!--                             style="width: 100px;display:flex;flex-direction: row;align-items: center;">-->
                <!--                            <input type="text" name="match_min" placeholder="最小" value="0" autocomplete="off"-->
                <!--                                   class="layui-input"/>-->
                <!--                            <span> %</span>-->
                <!--                        </div>-->
                <!--                        <div class="layui-form-mid">-</div>-->
                <!--                        <div class="layui-input-inline"-->
                <!--                             style="width: 100px;display:flex;flex-direction: row;align-items: center;">-->
                <!--                            <input-->
                <!--                                    type="text" name="match_max" placeholder="最大" value="0" autocomplete="off"-->
                <!--                                    class="layui-input"/>-->
                <!--                            <span> %</span>-->
                <!--                        </div>-->
                <!--                    </div>-->
                <!--                </div>-->
                <div class="layui-form-item">
                    <label class="layui-form-label label-required">会员等级</label>
                    <div class="layui-input-block">
                        <select name="memberLevelId">
                            <option value="1" selected="">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>
                </div>
                <!--                <div class="layui-form-item">-->
                <!--                    <label class="layui-form-label label-required">交易状态</label>-->
                <!--                    <div class="layui-input-block">-->
                <!--                        <select name="deal_status" id="deal_status">-->
                <!--                            <option value="1" selected="">正常</option>-->
                <!--                            <option value="0">冻结</option>-->
                <!--                        </select>-->
                <!--                    </div>-->
                <!--                </div>-->
                <div class="layui-form-item">
                    <label class="layui-form-label">登录密码</label>
                    <div class="layui-input-block">
                        <input name="password" placeholder="留空不修改密码" class="layui-input">
                    </div>
                </div>
                <!--                <div class="layui-form-item">-->
                <!--                    <label class="layui-form-label">交易密码</label>-->
                <!--                    <div class="layui-input-block">-->
                <!--                        <input name="pwd2" placeholder="留空不修改交易密码" class="layui-input">-->
                <!--                    </div>-->
                <!--                </div>-->
                <div class="layui-form-item">
                    <label class="layui-form-label">上级ID</label>
                    <div class="layui-input-block">
                        <input name="parentUserId" placeholder="请输入上级ID" value="0" class="layui-input"/>
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center" style="text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="editSubmit">提交</button>
                    <button type="reset" class="layui-btn layui-btn-danger" id="editCancel">取消</button>
                </div>
            </div>
        </form>
    </div>

    <!--地址信息-->
    <div id="addressInfoId" style="display: none">
        <form class="layui-form layui-card" action="">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label">收货姓名</label>
                    <div class="layui-input-block">
                        <input name="name" placeholder="请输入收货姓名" value="" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">收货手机</label>
                    <div class="layui-input-block">
                        <input name="tel" required="" value="" placeholder="请输入收货手机" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">详细地址</label>
                    <div class="layui-input-block">
                        <input name="address" required="" value="" placeholder="请输入详细地址" class="layui-input"/>
                    </div>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="layui-form-item text-center" style="text-align: center;">
                <button class="layui-btn" lay-submit lay-filter="addressInfoSubmit">提交</button>
                <button type="reset" class="layui-btn layui-btn-danger" id="addressInfoCancel">取消</button>
            </div>
        </form>
    </div>

    <!--    创建会员-->
    <div id="createId" style="display: none">
        <form class="layui-form layui-card" action=""
              data-auto="true"
              method="post"
              autocomplete="off"
              data-listen="true" novalidate="novalidate">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">用户名称</label>
                    <div class="layui-input-block">
                        <input name="userAccount" placeholder="请输入用户名" required=""
                               class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">手机号码</label>
                    <div class="layui-input-block">
                        <input name="phoneNumber" required="" placeholder="请输入手机号码" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">登录密码</label>
                    <div class="layui-input-block">
                        <input name="password" required="" placeholder="请输入登录密码" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上级ID</label>
                    <div class="layui-input-block">
                        <input name="parentUserId" placeholder="请输入上级ID" class="layui-input"/>
                    </div>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="layui-form-item text-center">
                <button class="layui-btn" type="button" lay-submit lay-filter="createSubmit">提交</button>
                <button class="layui-btn layui-btn-danger" type="button" data-close="" id="createCancel">取消</button>
            </div>
        </form>
    </div>
</div>

<!--账号-->
<script type="text/html" id="userAccount">
    <div>
        <div>手机号：{{=d.phoneNumber}}</div>
        <div>用户名：{{=d.userAccount}}</div>
        <div class="layui-btn layui-btn-xs layui-btn-normal">{{=d.memberStatus === 1 ? '真人' : '假人'}}</div>
    </div>
</script>

<!--会员等级-->
<script type="text/html" id="memberLevelId">
    <div>
        <div>{{=d.memberLevelId}}</div>
        <div style="color: red">0% - 0%</div>
    </div>
</script>

<!--账户余额-->
<!--缺少利息宝金额-->
<script type="text/html" id="balance">
    <div>
        <div>账户余额:{{=d.balance}}</div>
        <div>冻结金额:{{=d.freezeBalance}}</div>
        <div>利息宝金额:</div>
    </div>
</script>

<!--邀请码-->
<script type="text/html" id="inviteCode">
    <div>
        <div class="layui-btn layui-btn-sm" lay-event="upInviteCode">修改</div>
        <span>{{=d.inviteCode}}</span>
    </div>
</script>

<!--注册信息-->
<script type="text/html" id="register">
    <div>
        <p>{{ layui.util.toDateString(d.registrationTime, 'yyyy-MM-dd')}}</p>
        <p>{{ d.registerCountry}}</p>
    </div>
</script>

<!--操作-->
<script type="text/html" id="operation">
    <span style="display: inline-block">
        <a class="layui-btn layui-btn-xs" lay-event="deduction">扣款</a>
        <a class="layui-btn layui-btn-xs" lay-event="dispatch">派单</a>
        <a class="layui-btn layui-btn-xs" lay-event="bankCardInfo">银行卡信息</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs" lay-event="toggleState">{{=d.status === 1 ? '启用' : '禁用'}}</a>
    </span>
    <span style="display: inline-block">
        <a class="layui-btn layui-btn-xs" lay-event="addressInfo">地址信息</a>
        <a class="layui-btn layui-btn-xs" lay-event="viewTeam">查看团队</a>
        <a class="layui-btn layui-btn-xs" lay-event="accountChange">帐变</a>
        <a class="layui-btn layui-btn-xs" lay-event="realPerson">设为{{=d.memberStatus === 1 ? '假人' : '真人'}}</a>
        <a class="layui-btn layui-btn-xs" lay-event="delete">删除</a>
    </span>
</script>

<script>
    layui.use(['table', 'form', 'util', 'element', 'laydate'], function () {
        var table = layui.table, $ = layui.$, form = layui.form, util = layui.util;
        var element = layui.element;
        var laydate = layui.laydate;

        // 表格当前选择项
        var tableCurrentItem = {};

        // 扣款弹窗Index
        var deductionIndex;
        // 修改邀请码弹窗Index
        var upInviteCodeIndex;
        // 派单弹窗Index
        var dispatchIndex;
        var editIndex;
        var addressInfoIndex;

        laydate.render({
            elem: '#registrationTime',
            range: true //或 range: '~' 来自定义分割字符
        });


        var where = {
            // "agentLevel": 0,
            // "balance": 0,
            // "companyId": 0,
            // "createBy": "string",
            // "createTime": "2022-07-18T09:18:19.191Z",
            // "deductionNum": 0,
            // "delFlag": 0,
            // "depositNum": 0,
            // "email": "string",
            // "freezeBalance": 0,
            // "id": 0,
            // "inviteCode": "string",
            // "isAgent": 0,
            // "loginDate": "2022-07-18T09:18:19.191Z",
            // "loginIp": "string",
            // "matching": "string",
            // "memberLevelId": 0,
            // "memberStatus": 0,
            // "parentUserId": 0,
            // "parentUserName": "string",
            // "password": "string",
            // "phoneNumber": "string",
            // "rechargeNum": 0,
            // "registerCountry": "string",
            // "registerIp": "string",
            // "registrationTime": "2022-07-18T09:18:19.191Z",
            // "remark": "string",
            "status": 0,
            // "totalCommission": 0,
            // "userAccount": "string"
        };
        var parseData = function (res) {
            console.log('res', res)
            var msg;
            var code;
            var count;
            var data;
            if (res.code === 200) {
                code = 0;
                msg = res.message;
                count = res.data.total;
                data = res.data.list;
            } else {
                code = res.code;
                msg = res.msg;
                count = 0;
                data = [];
            }
            return {
                "code": code, //解析接口状态
                "msg": msg, //解析提示文本
                "count": count, //解析数据长度
                "data": data //解析数据列表
            };
        };

        var memberListTableId = 'memberListTable';
        table.render({
            elem: '#member-list',
            method: 'post',
            url: 'http://localhost:8080/memberaction/list', //数据接口
            page: true, //开启分页
            cellMinWidth: 100, //全局定义常规单元格的最小宽度
            contentType: 'application/json',
            where: where,
            loading: true,
            request: {
                pageName: 'pageNum', //页码的参数名称，默认：page
                limitName: 'pageSize', //每页数据量的参数名，默认：limit
            },
            lineStyle: 'height: 100px;',
            // ID	账号	会员等级	账户余额	提现	冻结金额	上级用户	邀请码	注册信息	操作
            cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID', sort: true}
                , {field: 'userAccount', title: '账号', templet: '#userAccount', width: 180}
                , {field: 'memberLevelId', title: '会员等级', templet: '#memberLevelId', sort: true, width: 110}
                , {field: 'balance', title: '账户余额', templet: '#balance', sort: true, width: 180}
                , {field: 'depositNum', title: '提现', sort: true, minWidth: 120}
                , {field: 'freezeBalance', title: '冻结金额', sort: true, minWidth: 120}
                , {field: 'parentUserName', title: '上级用户', sort: true, minWidth: 120}
                , {field: 'inviteCode', title: '邀请码', templet: '#inviteCode', sort: true, minWidth: 160}
                , {field: 'registerId', title: '注册信息', templet: '#register', sort: true, minWidth: 160}
                , {field: 'operation', title: '操作', templet: '#operation', fixed: 'right', width: 336}
            ]],
            parseData: parseData,
            id: memberListTableId, // 容器唯一ID
        });


        // 请求回调选项
        var requestDefOptions = {
            // 请求成功，并且code等于200
            success: function (result,status,xhr) {

            },
            // 请求成功，并且code不等于200
            fail: function (result,status,xhr) {

            },
            // 请求失败
            error: function (xhr,status,error) {

            },
            // 请求完成时运行的函数（在请求成功或失败之后均调用，即在 success 和 error 函数之后）。
            complete: function (xhr,status) {

            }
        };

        var actions = {
            apiUrl: {
                update: '/memberaction/update/',
                delete: '/memberaction/delete/',
                create: '/memberaction/create',
            },
            // 刷新表格数据
            onReloadData: function () {
                var searchData = form.val('searchForm');
                console.log('searchData', searchData);
                table.reloadData(memberListTableId, { where: Object.assign({ }, where, searchData) });
            },
            onUpdateItem: function (id, fields, options) {
                var _options = Object.assign({}, requestDefOptions, options);
                $.ajax({
                    url: actions.apiUrl.update + id,
                    type: 'post',
                    contentType: 'application/json',
                    data: JSON.stringify(fields),
                    success: function (result, status, xhr) {
                        if (result.code === 200) {
                            actions.onReloadData();
                            layer.msg('操作成功', {icon: 1});
                            _options.success && _options.success(result, status, xhr);
                        } else {
                            layer.msg(result.msg, {icon: 2});
                            _options.fail && _options.fail(result, status, xhr);
                        }
                        _options.complete && _options.complete(status, xhr);
                    },
                    error: function (xhr, status, error) {
                        layer.msg('操作失败', {icon: 2});
                        _options.error && _options.error(xhr, status, error);
                    }
                });
            },
            onDelete: function (id, options) {
                var _options = Object.assign({}, requestDefOptions, options);
                $.ajax({
                    url: actions.apiUrl.delete + id,
                    type: 'get',
                    success: function (result, status, xhr) {
                        if (result.code === 200) {
                            actions.onReloadData();
                            layer.msg('删除会员成功', {icon: 1});
                            _options.success && _options.success(result, status, xhr);
                        } else {
                            layer.msg(result.msg, {icon: 2});
                            _options.fail && _options.fail(result, status, xhr);
                        }
                        _options.complete && _options.complete(status, xhr);
                    },
                    error: function (xhr,status,error) {
                        layer.msg('删除会员失败', {icon: 2});
                        _options.error && _options.error(xhr, status, error);
                    }
                });
            },
            onCreate: function (fields, options) {
                var _options = Object.assign({}, requestDefOptions, options);
                $.ajax({
                    url: actions.apiUrl.create,
                    type: 'post',
                    contentType: 'application/json',
                    data: JSON.stringify(fields),
                    success: function (result, status, xhr) {
                        if (result.code === 200) {
                            actions.onReloadData();
                            layer.msg('创建会员成功', {icon: 1});
                            _options.success && _options.success(result, status, xhr);
                        } else {
                            layer.msg(result.msg, {icon: 2});
                            _options.fail && _options.fail(result, status, xhr);
                        }
                        _options.complete && _options.complete(status, xhr);
                    },
                    error: function (xhr,status,error) {
                        layer.msg('创建会员失败', {icon: 2});
                        _options.error && _options.error(xhr, status, error);
                    }
                });
            },
        }

        //单元格工具事件
        table.on('tool(member-list)', function (obj) { // 注：test 是 table 原始标签的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            // 设置当前选择项
            tableCurrentItem = Object.assign({}, data);

            // 修改邀请码
            if (layEvent === 'upInviteCode') {
                upInviteCodeIndex = layer.open({
                    type: 1,
                    // value: data.inviteCode,
                    title: '修改邀请码',
                    area: '800px',
                    content: $('#upInviteCodeId'),
                    success: function () {
                        $('#newInviteCode').val(data.inviteCode);
                        $('#upInviteCodeId').show();
                    },
                    cancel: function () {
                        $('#upInviteCodeId').hide();
                    }
                });
                // function(value, index, elem){
                //        if (!value) {
                //            layer.msg('请输入邀请码');
                //            // alert('请输入邀请码');
                //            return;
                //        }
                //        layer.close(index);
                //    }
            } else if (layEvent === 'deduction') { // 扣款
                deductionIndex = layer.open({
                    type: 1,
                    title: '扣款',
                    area: '800px',
                    content: $('#deductionId'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                    success: function () {
                        $('#deductionId').show();
                    },
                    cancel: function () {
                        $('#deductionId').hide();
                    }
                });
            } else if (layEvent === 'dispatch') { // 派单
                dispatchIndex = layer.open({
                    type: 1,
                    title: '派单',
                    area: '800px',
                    content: $('#dispatchId'),
                    success: function () {
                        $('#dispatchId').show();
                    },
                    cancel: function () {
                        $('#dispatchId').hide();
                    }
                });
            } else if (layEvent === 'edit') { // 编辑菜单
                editIndex = layer.open({
                    type: 1,
                    title: '编辑菜单',
                    area: '800px',
                    content: $('#editId'),
                    success: function () {
                        form.val('editForm', data);
                        $('#editId').show();
                    },
                    cancel: function () {
                        $('#editId').hide();
                    }
                });
            } else if (layEvent === 'bankCardInfo') { // 银行卡信息
                layer.msg('没有数据', {icon: 2});
            } else if (layEvent === 'toggleState') { //状态切换
                // 帐号状态（0正常 1停用）
                actions.onUpdateItem(tableCurrentItem.id, { status: data.status === 0 ? 1 : 0 })
            } else if (layEvent === 'addressInfo') { // 地址信息
                $.request({
                    url: '/address/getmemberaddress/' + tableCurrentItem.id,
                    type: 'get',
                    success: function (result, status, xhr) {
                        console.log('result', result);
                        addressInfoIndex = layer.open({
                            type: 1,
                            title: '地址信息',
                            area: '800px',
                            content: $('#addressInfoId'),
                            success: function () {
                                $('#addressInfoId').show();
                            },
                            cancel: function () {
                                $('#addressInfoId').hide();
                            }
                        });
                    },
                })

            } else if (layEvent === 'viewTeam') { // 查看团队
                window.location.href = './viewTeam.html';
            } else if (layEvent === 'accountChange') { // 帐变
            } else if (layEvent === 'realPerson') { // 设为真人
                // 状态:1.真人2.假人
                actions.onUpdateItem(tableCurrentItem.id, { memberStatus: data.memberStatus === 1 ? 2 : 1 })
            } else if (layEvent === 'delete') { // 删除
                layer.confirm('确定要删除吗?', {title: '操作确认'}, function (index) {
                    actions.onDelete(data.id, {
                        success: function () {
                            layer.close(index);
                        }
                    });
                });
            }

        });

        // 搜索
        form.on('submit(search)', function (data) {
            console.log(data.field);
            actions.onReloadData();
            return false;
        });

        // 邀请码-提交
        form.on('submit(upInviteCodeSubmit)', function (formData) {
            actions.onUpdateItem(tableCurrentItem.id, formData.field, {
                success: function () {
                    layer.close(upInviteCodeIndex);
                    $('#upInviteCodeId').hide();
                }
            });
            return false;
        });
        // 邀请码-取消
        $('#dupInviteCodeCancel').click(function () {
            layer.close(upInviteCodeIndex);
        });

        // 扣款-提交
        form.on('submit(deductionSubmit)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
        // 扣款-取消
        $('#deductionCancel').click(function () {
            layer.close(deductionIndex);
        });


        // 派单-提交
        form.on('submit(dispatchSubmit)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
        // 派单-取消
        $('#dispatchCancel').click(function () {
            layer.close(dispatchIndex);
        });


        // 编辑-提交
        form.on('submit(editSubmit)', function (data) {
            // layer.msg(JSON.stringify(data.field));
            actions.onUpdateItem(tableCurrentItem.id, data.field, {
                success: function () {
                    layer.close(editIndex);
                    $('#editId').hide();
                }
            } )
            return false;
        });
        // 编辑-取消
        $('#editCancel').click(function () {
            layer.close(editIndex);
        });

        // 地址信息-提交
        form.on('submit(addressInfoSubmit)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
        // 地址信息-取消
        $('#addressInfoCancel').click(function () {
            layer.close(addressInfoIndex);
        });

        // 创建会员-提交
        form.on('submit(createSubmit)', function (data) {
            actions.onCreate(data.field, {
                success: function () {
                    layer.close(createIndex);
                }
            });
            // return false;
        });
        // 创建会员-取消
        $('#createCancel').click(function () {
            layer.close(createIndex);
        });

        var createIndex;
        $('#createBtn').click(function () {
            createIndex = layer.open({
                type: 1,
                title: '创建会员',
                area: '800px',
                content: $('#createId'),
                success: function () {
                    $('#createId').show();
                },
                cancel: function () {
                    $('#createId').hide();
                }
            });
        })

    });
</script>

</body>
</html>