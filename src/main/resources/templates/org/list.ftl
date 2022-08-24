<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-fluid">
<div class="searchTable" style="padding: 20px">
    <form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label" data-locale="org.org_name">单位名称:</label>
        <div class="layui-input-inline">
            <input class="layui-input" name="org_name" autocomplete="off">
        </div>
        <label class="layui-form-label" data-locale="org.superiorUnit">上级单位:</label>
        <div class="layui-input-inline">
            <input class="layui-input" id="org_pname" inputTree="url:'/sys/org/tree',name:'org_pid'"
                   data-placeholder="org.petSuperiorUnit" />
        </div>
        <div class="layui-input-inline">
            <button class="layui-btn search-btn" lay-submit lay-filter="reload" data-type="reload"><i class="fa fa-search">&nbsp;</i>
                <span data-locale="search">搜索</span>
            </button>
            <button class="layui-btn layui-btn-primary" type="button" data-type="reset"><i class="fa fa-refresh">&nbsp;</i>
                <span data-locale="reset">重置</span>
            </button>
        </div>
    </div>
    </form>
</div>
<div class="layui-btn-group">
    <!--使用shiro标签进行按钮权限验证-->
    <@shiro.hasPermission name="org:add">
        <button class="layui-btn" data-type="add"><i class="fa fa-plus">&nbsp;</i>
            <span data-locale="add">增加</span>
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="org:update">
        <button class="layui-btn" data-type="edit" style="margin-left: 5px!important;"><i class="fa fa-pencil-square-o">&nbsp;</i>
            <span data-locale="edit">修改</span>
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="org:del">
        <button class="layui-btn" data-type="del" style="margin-left: 5px!important;"><i class="fa fa-trash-o">&nbsp;</i>
            <span data-locale="delete">删除</span>
        </button>
    </@shiro.hasPermission>
</div>

<table id="org-list" lay-filter="org-list"></table>
</div>
<script type="text/html" id="switchTpl">
    <!-- checked状态 -->
    <input type="checkbox" disabled name="statue" value="{{d.statue}}" lay-skin="switch" lay-text="使用中|已注销" lay-filter="statue" {{ d.statue == 1 ? 'checked' : '' }}>
</script>
<script src="/org/org.js"></script>
</body>
</html>