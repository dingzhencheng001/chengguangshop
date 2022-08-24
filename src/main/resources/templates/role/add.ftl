<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../resource.ftl"/>
</head>
<body>
<form class="layui-form" lay-filter="role-add" style="padding: 20px 0">
    <input name="roleId" hidden>
    <div class="layui-form-item">
        <label class="layui-form-label" data-locale="role.roleName">角色名称：</label>
        <div class="layui-input-inline">
            <input name="roleName" lay-verify="required" autocomplete="off" data-placeholder="role.petRoleName" class="layui-input" type="text">
        </div>
        <label class="layui-form-label" data-locale="role.roleCode">角色编码：</label>
        <div class="layui-input-inline">
            <input name="roleCode" lay-verify="required" autocomplete="off" data-placeholder="role.petRoleCode" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" data-locale="role.roleStatus">使用状态：</label>
        <div class="layui-input-inline" combobox = "dicDefine:'isuse'" name="roleStatus" value="1">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" data-locale="role.roleUser">用户授权：</label>
            <div class="layui-input-inline">
                <select name="roleUser" xm-select="roleUser" xm-select-show-count="1">
                    <option value="" data-locale="role.petUser">请选择用户</option>
                </select>
            </div>
        <label class="layui-form-label" data-locale="role.menuGrant">菜单授权：</label>
        <div class="layui-input-inline">
            <input class="layui-input" id="roleMenuName" name="roleMenuName" data-placeholder="role.petMenu" inputTree="url:'/sys/role/menu',name:'roleMenu',check:'true'" type="text"/>
        </div>
        </div>
    </div>
    <div class="layui-form-item" align="center">
        <button class="layui-btn" lay-submit lay-filter="save" data-locale="save">保存</button>
        <button type="reset" class="layui-btn layui-btn-primary" data-locale="reset">重置</button>
    </div>
</form>
<script>
layui.use('form', function() {
    var form = layui.form
        , $ = layui.$
        , formSelects = layui.formSelects;

    var i18n = new I18n();
    var $t = i18n.$t;
    window.i18n = i18n;
    window.$t = $t;

    // 保存
    form.on('submit(save)', function(data){
        var url = data.field.roleId === '' ? '/sys/role/save' : '/sys/role/update';
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
                        parent.layui.table.reload('roleTable'); // 父页面table容器唯一id
                    });
                } else {
                    layer.msg(result.msg, {icon: 5});
                }
            }
        });
        return false;
    });

    var parentData;
    // 获取父页面传递的值并赋值给form
    window.parentParas = function (data) {
        parentData = data;
        form.val('role-add',JSON.parse(JSON.stringify(data)));
    }


    // 多选下拉框 获取用户信息
    formSelects.data('roleUser', 'server', {
        url: '/sys/role/user',
        beforeSuccess: function(id, url, searchVal, result){
            return result.data;
        }
        , success:function () {
            // 样式设置
            formSelects.btns('roleUser', ['select', 'remove'], {show: '', space: '10px'});
            // 赋值
            if (parentData != undefined) {
                formSelects.value('roleUser',parentData.roleUser.split(","));
            }
        }
    });
});
</script>
</body>
</html>