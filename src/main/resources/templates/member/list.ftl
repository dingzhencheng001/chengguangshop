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
                        <input name="keyword" value="" placeholder="请输入用户名称,手机号码,IP" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">注册时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="time" class="layui-input" id="registrationTime" placeholder="请选择注册时间">
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
                        <input type="text" name="inviteCode" required id="newInviteCode" lay-verify="required"
                               placeholder="请输入邀请码" autocomplete="off" class="layui-input">
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
        <form class="layui-form layui-card" lay-filter="deductionForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">金额</label>
                    <div class="layui-input-block">
                        <input type="number" name="operaMount" lay-verify="number" placeholder="请输入金额"
                               autocomplete="off"
                               class="layui-input">
                        <p class="help-block">正表示加，负表示扣</p>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">备注</label>
                    <div class="layui-input-block">
                        <input type="text" name="remank" placeholder="请输入备注" autocomplete="off" class="layui-input">
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

    <!--编辑菜单-->
    <div id="editId" style="display: none">
        <form class="layui-form layui-card" lay-filter="editForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">用户名称</label>
                    <div class="layui-input-block">
                        <input name="userAccount" lay-verify="required" placeholder="请输入用户名称" value=""
                               class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">手机号码</label>
                    <div class="layui-input-block">
                        <input name="phoneNumber" lay-verify="phone" placeholder="请输入手机号码" value=""
                               class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">账号余额</label>
                    <div class="layui-input-block">
                        <input name="balance" type="number" min="0" placeholder="请输入账号余额" lay-verify="number"
                               class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">冻结金额</label>
                    <div class="layui-input-block">
                        <input name="freezeBalance" type="number" min="0" placeholder="冻结金额" value=""
                               class="layui-input" disabled>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required">设定金额</label>
                    <div class="layui-input-block">
                        <input name="limitAmount" type="number" lay-verify="limitAmount" min="100" placeholder="请输入设定金额，不能小于100" value=""
                               class="layui-input" />
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
                        <select id="memberLevelSelect" name="memberLevelId" lay-verify="required">
                            <!--                            <option value="1" selected="">1</option>-->
                            <!--                            <option value="2">2</option>-->
                            <!--                            <option value="3">3</option>-->
                            <!--                            <option value="4">4</option>-->
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
        <form class="layui-form layui-card" lay-filter="addressInfoForm" autocomplete="off">
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
                        <input name="tel" lay-verify="phone" value="" placeholder="请输入收货手机" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">详细地址</label>
                    <div class="layui-input-block">
                        <input name="address" lay-verify="required" value="" placeholder="请输入详细地址" class="layui-input"/>
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
        <form class="layui-form layui-card" lay-filter="createForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">用户名称</label>
                    <div class="layui-input-block">
                        <input name="userAccount" placeholder="请输入用户名" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">手机号码</label>
                    <div class="layui-input-block">
                        <input name="phoneNumber" lay-verify="phone" placeholder="请输入手机号码" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">登录密码</label>
                    <div class="layui-input-block">
                        <input name="password" lay-verify="required" placeholder="请输入登录密码" class="layui-input"/>
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

    <!--    发送消息-->
    <div id="sendMessageId" style="display: none">
        <form class="layui-form layui-card" lay-filter="sendMessageForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">标题</label>
                    <div class="layui-input-block">
                        <input name="noticeTitle" placeholder="请输入标题" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">内容</label>
                    <div class="layui-input-block">
                        <input name="noticeContent" placeholder="请输入内容" lay-verify="required" class="layui-input"/>
                    </div>
                </div>

                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center">
                    <button class="layui-btn" type="button" lay-submit lay-filter="sendMessageSubmit">提交</button>
                    <button class="layui-btn layui-btn-danger" type="button" data-close="" id="sendMessageCancel">取消
                    </button>
                </div>
            </div>
        </form>
    </div>

    <!--银行卡信息-->
    <div id="bankCardInfoId" style="display: none">
        <form class="layui-form layui-card" lay-filter="bankCardInfoForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">开户名</label>
                    <div class="layui-input-block">
                        <input name="accountName" placeholder="请输入开户名" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">银行名称</label>
                    <div class="layui-input-block">
                        <input name="bankName" placeholder="请输入银行名称" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">银行编号</label>
                    <div class="layui-input-block">
                        <input name="bankNumber" placeholder="请输入银行编号" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">银行卡号</label>
                    <div class="layui-input-block">
                        <input name="cardNum" type="number" placeholder="请输入银行卡号" lay-verify="required"
                               class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next">银行所在国家</label>
                    <div class="layui-input-block">
                        <input name="bankCountry" placeholder="请输入银行所在国家" lay-verify="required" class="layui-input"/>
                    </div>
                </div>

                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center">
                    <button class="layui-btn" type="button" lay-submit lay-filter="bankCardInfoSubmit">提交</button>
                    <button class="layui-btn layui-btn-danger" type="button" data-close="" id="bankCardInfoCancel">取消
                    </button>
                </div>
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
        <div>{{$.findName(memberLevelOptions, d.memberLevelId)}}</div>
        <div style="color: red">0% - 0%</div>
    </div>
</script>

<!--账户余额-->
<!--缺少利息宝金额-->
<script type="text/html" id="balance">
    <div>
        <div>账户余额:{{$.financial(d.balance)}}</div>
        <div>冻结金额:{{$.financial(d.freezeBalance)}}</div>
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
        <p>{{ d.registerCountry}}{{ d.registerIp ? '(' + d.registerIp +')' : ''}}</p>
    </div>
</script>

<!--操作-->
<script type="text/html" id="operation">
    <div class="layui-btn-container">
        <a class="layui-btn layui-btn-xs" lay-event="deduction">扣款</a>
        <a class="layui-btn layui-btn-xs" lay-event="dispatch">派单</a>
        <a class="layui-btn layui-btn-xs" lay-event="bankCardInfo">银行卡信息</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs" lay-event="toggleState">{{=d.status === 1 ? '启用' : '禁用'}}</a>
        <a class="layui-btn layui-btn-xs" lay-event="drawalStatus">{{=d.drawalStatus === 1 ? '正常提现' : '禁止提现'}}</a>
        <a class="layui-btn layui-btn-xs" lay-event="sendMessage">发送消息</a>
        <!--    </span>-->
        <!--    <span style="display: inline-block">-->
        <a class="layui-btn layui-btn-xs" lay-event="addressInfo">地址信息</a>
        <a class="layui-btn layui-btn-xs" lay-event="viewTeam" style="margin-bottom: 0">查看团队</a>
        <a class="layui-btn layui-btn-xs" lay-event="accountChange" style="margin-bottom: 0">帐变</a>
        <a class="layui-btn layui-btn-xs" lay-event="realPerson" style="margin-bottom: 0">设为{{=d.memberStatus === 1 ? '假人' : '真人'}}</a>
        <a class="layui-btn layui-btn-xs" lay-event="delete" style="margin-bottom: 0">删除</a>
    </div>
</script>

<script src="/member/member.js"></script>

</body>
</html>