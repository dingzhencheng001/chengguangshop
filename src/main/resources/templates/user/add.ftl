<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../resource.ftl"/>
</head>
<body>
<form class="layui-form" lay-filter="user-add" style="padding: 20px 0">
    <input name="id" hidden>
    <div class="layui-form-item">
        <label class="layui-form-label" data-locale="user.loginid">登录ID：</label>
        <div class="layui-input-inline">
            <input name="loginid" lay-verify="required" autocomplete="off" class="layui-input" type="text">
        </div>
        <label class="layui-form-label" data-locale="user.username">用户名称：</label>
        <div class="layui-input-inline">
            <input name="username" lay-verify="required" autocomplete="off" data-placeholder="user.petUserName" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" data-locale="user.telphone">电话：</label>
        <div class="layui-input-inline">
            <input name="telphone" lay-verify="required|phone" autocomplete="off" data-placeholder="user.petTelphone" class="layui-input" type="text">
        </div>
        <label class="layui-form-label" data-locale="user.email">邮箱：</label>
        <div class="layui-input-inline">
            <input name="email" lay-verify="required|email" autocomplete="off" data-placeholder="petEmail" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" data-locale="user.orgname">所属单位：</label>
        <div class="layui-input-inline">
            <input class="layui-input" id="orgname" name="orgname" data-placeholder="user.petOrgname" inputTree="url:'/sys/org/tree',name:'orgid'" type="text"/>
        </div>
        <label class="layui-form-label" data-locale="user.statue">使用状态：</label>
        <div class="layui-input-inline" combobox = "dicDefine:'isuse'" name="statue" value="1">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" data-locale="user.addr">地址：</label>
        <div class="layui-input-block">
            <input name="addr" lay-verify="" autocomplete="off" data-placeholder="user.petAddr" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label" data-locale="user.memo">备注：</label>
        <div class="layui-input-block">
            <textarea class="layui-textarea" name="memo" autocomplete="off"></textarea>
        </div>
    </div>
    <div class="layui-form-item" align="center">
        <button class="layui-btn" lay-submit lay-filter="save" data-locale="save">保存</button>
        <button type="reset" class="layui-btn layui-btn-primary" data-locale="reset">重置</button>
    </div>
</form>
<script>
layui.use('form', function() {
    var form = layui.form, $ = layui.$;

    var i18n = new I18n();
    var $t = i18n.$t;
    window.i18n = i18n;
    window.$t = $t;

    // 保存
    form.on('submit(save)', function(data){
        var url = data.field.id === '' ? '/sys/user/save' : '/sys/user/update';
        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify(data.field),
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                if (result.code === 0) {
                    layer.msg($t('operationSucceeded'), {icon: 1}
                    , function(){
                        // 关闭窗口并刷新列表
                        var  frameindex= parent.layer.getFrameIndex(window.name);
                        parent.layer.close(frameindex);
                        parent.layui.table.reload('userTable'); // 父页面table容器唯一id
                    });
                } else {
                    layer.msg(result.msg, {icon: 5});
                }
            }
        });
        return false;
    });

    // 获取父页面传递的值并赋值给form
    window.parentParas = function (data) {
        form.val('user-add',JSON.parse(JSON.stringify(data)));
    }
});
</script>
</body>
</html>