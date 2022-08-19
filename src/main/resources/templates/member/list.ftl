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
            <legend data-locale="conditionalSearch">条件搜索</legend>
            <form class="layui-form layui-form-pane form-search" lay-filter="searchForm" action="">
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label" data-locale="keyword">关键词</label>
                    <div class="layui-input-inline">
                        <input name="keyword" value="" data-placeholder="member.petKeyword" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label" data-locale="member.registrationTime">注册时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="time" class="layui-input" id="registrationTime"
                               data-placeholder="member.petRegistrationTime">
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label" data-locale="member.status">状态</label>
                    <div class="layui-input-inline">
                        <select name="memberStatus">
                            <option value="">所有状态</option>
                            <option value="1" data-locale="member.status1">真人</option>
                            <option value="2" data-locale="member.status2">假人</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <button type="submit" class="layui-btn layui-btn-danger" lay-submit lay-filter="search"
                            data-locale="search"><i
                                class="layui-icon"></i> 搜 索
                    </button>
                </div>
            </form>
        </fieldset>

    </div>

    <div class="layui-btn-container" style="margin-top: 20px;">
        <button class="layui-btn" id="createBtn" data-locale="member.addMember">添加会员</button>
    </div>

    <table id="member-list" lay-filter="member-list" style="margin-top: 5px"></table>

    <!--修改邀请码表单-->
    <div id="upInviteCodeId" style="display: none">
        <form class="layui-form layui-card" action="">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.invitationCode">邀请码</label>
                    <div class="layui-input-block">
                        <input type="text" name="inviteCode" required id="newInviteCode" lay-verify="required"
                               data-placeholder="member.petInvitationCode" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center" style="text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="upInviteCodeSubmit" data-locale="submit">提交</button>
                    <button type="reset" class="layui-btn layui-btn-danger" id="dupInviteCodeCancel" data-locale="cancel">取消</button>
                </div>
            </div>
        </form>
    </div>

    <!--扣款表单-->
    <div id="deductionId" style="display: none">
        <form class="layui-form layui-card" lay-filter="deductionForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.operaMount">金额</label>
                    <div class="layui-input-block">
                        <input type="number" name="operaMount" lay-verify="number" data-placeholder="member.petOperaMount"
                               autocomplete="off"
                               class="layui-input">
                        <p class="help-block" data-locale="member.operaMountHelp">正表示加，负表示扣</p>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="member.remarks">备注</label>
                    <div class="layui-input-block">
                        <input type="text" name="remank" data-placeholder="member.petRemarks" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center" style="text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="deductionSubmit" data-locale="submit">提交</button>
                    <button type="reset" class="layui-btn layui-btn-danger" id="deductionCancel" data-locale="cancel">取消</button>
                </div>
            </div>
        </form>
    </div>

    <!--编辑菜单-->
    <div id="editId" style="display: none">
        <form class="layui-form layui-card" lay-filter="editForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.userName">用户名称</label>
                    <div class="layui-input-block">
                        <input name="userAccount" lay-verify="required" data-placeholder="member.petUserName" value="" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.phoneNumber">手机号码</label>
                    <div class="layui-input-block">
                        <input name="phoneNumber" lay-verify="phone" data-placeholder="member.petPhoneNumber" value="" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="member.balance">账号余额</label>
                    <div class="layui-input-block">
                        <input name="balance" type="number" min="0" data-placeholder="member.petBalance" lay-verify="number" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="member.freezeBalance">冻结金额</label>
                    <div class="layui-input-block">
                        <input name="freezeBalance" type="number" min="0" data-placeholder="member.petFreezeBalance" value="" class="layui-input" disabled>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required" data-locale="member.limitAmount">设定金额</label>
                    <div class="layui-input-block">
                        <input name="limitAmount" type="number" lay-verify="limitAmount" min="100"
                               data-placeholder="member.petLimitAmount" value="" class="layui-input"/>
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
                    <label class="layui-form-label label-required" data-locale="member.memberLevel">会员等级</label>
                    <div class="layui-input-block">
                        <select id="memberLevelSelect" name="memberLevelId" lay-verify="required"></select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="member.password">登录密码</label>
                    <div class="layui-input-block">
                        <input name="password" data-placeholder="member.petPassword" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="member.parentUserId">上级ID</label>
                    <div class="layui-input-block">
                        <input name="parentUserId" data-placeholder="member.petParentUserId" value="0" class="layui-input"/>
                    </div>
                </div>
                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center" style="text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="editSubmit" data-locale="submit">提交</button>
                    <button type="reset" class="layui-btn layui-btn-danger" id="editCancel" data-locale="cancel">取消</button>
                </div>
            </div>
        </form>
    </div>

    <!--地址信息-->
    <div id="addressInfoId" style="display: none">
        <form class="layui-form layui-card" lay-filter="addressInfoForm" autocomplete="off">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="member.address.name">收货姓名</label>
                    <div class="layui-input-block">
                        <input name="name" data-placeholder="member.address.petName" value="" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.address.tel">收货手机</label>
                    <div class="layui-input-block">
                        <input name="tel" lay-verify="phone" value="" data-placeholder="member.address.petTel" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.address.address">详细地址</label>
                    <div class="layui-input-block">
                        <input name="address" lay-verify="required" value="" data-placeholder="member.address.petAddress" class="layui-input"/>
                    </div>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="layui-form-item text-center" style="text-align: center;">
                <button class="layui-btn" lay-submit lay-filter="addressInfoSubmit" data-locale="submit">提交</button>
                <button type="reset" class="layui-btn layui-btn-danger" id="addressInfoCancel" data-locale="cancel">取消</button>
            </div>
        </form>
    </div>

    <!--    创建会员-->
    <div id="createId" style="display: none">
        <form class="layui-form layui-card" lay-filter="createForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.userName">用户名称</label>
                    <div class="layui-input-block">
                        <input name="userAccount" data-placeholder="member.petUserName" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.phoneNumber">手机号码</label>
                    <div class="layui-input-block">
                        <input name="phoneNumber" lay-verify="phone" data-placeholder="member.petPhoneNumber" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.password">登录密码</label>
                    <div class="layui-input-block">
                        <input name="password" lay-verify="required" data-placeholder="member.petPassword2" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" data-locale="member.parentUserId">上级ID</label>
                    <div class="layui-input-block">
                        <input name="parentUserId" data-placeholder="member.petParentUserId" class="layui-input"/>
                    </div>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="layui-form-item text-center">
                <button class="layui-btn" type="button" lay-submit lay-filter="createSubmit" data-locale="submit">提交</button>
                <button class="layui-btn layui-btn-danger" type="button" id="createCancel" data-locale="cancel">取消</button>
            </div>
        </form>
    </div>

    <!--    发送消息-->
    <div id="sendMessageId" style="display: none">
        <form class="layui-form layui-card" lay-filter="sendMessageForm">
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.noticeTitle">标题</label>
                    <div class="layui-input-block">
                        <input name="noticeTitle" data-placeholder="member.petNoticeTitle" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.noticeContent">内容</label>
                    <div class="layui-input-block">
                        <input name="noticeContent" data-placeholder="member.petNoticeContent" lay-verify="required" class="layui-input"/>
                    </div>
                </div>

                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center">
                    <button class="layui-btn" type="button" lay-submit lay-filter="sendMessageSubmit" data-locale="submit">提交</button>
                    <button class="layui-btn layui-btn-danger" type="button" data-close="" id="sendMessageCancel" data-locale="cancel">取消
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
                    <label class="layui-form-label label-required label-required-next" data-locale="member.accountName">开户名</label>
                    <div class="layui-input-block">
                        <input name="accountName" data-placeholder="member.petAccountName" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.bankName">银行名称</label>
                    <div class="layui-input-block">
                        <input name="bankName" data-placeholder="member.petBankName" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.bankNumber">银行编号</label>
                    <div class="layui-input-block">
                        <input name="bankNumber" data-placeholder="member.petBankNumber" lay-verify="required" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.cardNum">银行卡号</label>
                    <div class="layui-input-block">
                        <input name="cardNum" type="number" data-placeholder="member.petCardNum" lay-verify="required"
                               class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label-required label-required-next" data-locale="member.bankCountry">银行所在国家</label>
                    <div class="layui-input-block">
                        <input name="bankCountry" data-placeholder="member.petBankCountry" lay-verify="required" class="layui-input"/>
                    </div>
                </div>

                <div class="hr-line-dashed"></div>
                <div class="layui-form-item text-center">
                    <button class="layui-btn" type="button" lay-submit lay-filter="bankCardInfoSubmit" data-locale="submit">提交</button>
                    <button class="layui-btn layui-btn-danger" type="button" id="bankCardInfoCancel" data-locale="cancel">取消
                    </button>
                </div>
            </div>
        </form>
    </div>

</div>

<!--账号-->
<script type="text/html" id="userAccount">
    <div>
        <div>{{$t('member.phoneNumber')}}：{{=d.phoneNumber}}</div>
        <div>{{$t('member.userName')}}：{{=d.userAccount}}</div>
        <div class="layui-btn layui-btn-xs layui-btn-normal">{{=d.memberStatus === 1 ? $t('member.status1') : $t('member.status2')}}</div>
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
        <div>{{$t('member.balance')}}:{{$.financial(d.balance)}}</div>
        <div>{{$t('member.freezeBalance')}}:{{$.financial(d.freezeBalance)}}</div>
        <!--        <div>利息宝金额:</div>-->
    </div>
</script>

<!--邀请码-->
<script type="text/html" id="inviteCode">
    <div>
        <div class="layui-btn layui-btn-sm" lay-event="upInviteCode">{{$t('modify')}}</div>
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


<style>
    .member-btn-container .layui-btn {
        margin-right: 4px;
    }
</style>
<!--操作-->
<script type="text/html" id="operation">
    <div class="layui-btn-container member-btn-container">
        <a class="layui-btn layui-btn-xs" lay-event="deduction">{{ $t('member.deduction') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="dispatch">{{ $t('member.dispatch') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="bankCardInfo">{{ $t('member.bankCardInfo') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">{{ $t('edit') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="toggleState">{{ d.status === 1 ? $t('enable') : $t('disable') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="drawalStatus">{{=d.drawalStatus === 1 ? $t('member.normalWithdrawal') : $t('member.noWithdrawal')}}</a>
        <a class="layui-btn layui-btn-xs" lay-event="sendMessage">{{ $t('member.sendMessage') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="addressInfo">{{ $t('member.addressInfo') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="viewPassword">{{ $t('member.viewPassword') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="viewTeam" style="margin-bottom: 0">{{ $t('member.viewTeam') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="accountChange" style="margin-bottom: 0">{{ $t('member.accountChange') }}</a>
        <a class="layui-btn layui-btn-xs" lay-event="realPerson" style="margin-bottom: 0">{{=d.memberStatus === 1 ? $t('member.setAsDummy') : $t('member.setAsRealPerson')}}</a>
        <a class="layui-btn layui-btn-xs" lay-event="delete" style="margin-bottom: 0">{{ $t('delete') }}</a>
    </div>
</script>

<script src="/member/member.js"></script>

</body>
</html>