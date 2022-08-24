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
        <label class="layui-form-label" data-locale="menuList.menu_name">菜单名:</label>
        <div class="layui-input-inline">
            <input class="layui-input" name="menu_name" autocomplete="off">
        </div>
        <label class="layui-form-label" data-locale="menuList.menu_type">菜单类型:</label>
        <div class="layui-input-inline" name="menu_type" combobox = "dicDefine:'menuType',filter:'menuType'">
        </div>
        <div class="layui-input-inline">
            <button class="layui-btn search-btn" lay-submit lay-filter="reload" data-type="reload">
                <i class="fa fa-search">&nbsp;</i>
                <span data-locale="search">搜索</span>
            </button>
            <button class="layui-btn layui-btn-primary" type="button" data-type="reset">
                <i class="fa fa-refresh">&nbsp;</i>
                <span data-locale="reset">重置</span>
            </button>
        </div>
    </div>
    </form>
</div>
<div class="layui-btn-group">
    <!--使用shiro标签进行按钮权限验证-->
    <@shiro.hasPermission name="menu:add">
        <button class="layui-btn" data-type="add">
            <i class="fa fa-plus">&nbsp;</i>
            <span data-locale="add">增加</span>
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="menu:update">
        <button class="layui-btn" data-type="edit" style="margin-left: 5px!important;">
            <i class="fa fa-pencil-square-o">&nbsp;</i>
            <span data-locale="edit">修改</span>
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="menu:del">
        <button class="layui-btn" data-type="del" style="margin-left: 5px!important;">
            <i class="fa fa-trash-o">&nbsp;</i>
            <span data-locale="delete">删除</span>
        </button>
    </@shiro.hasPermission>
</div>

<table id="menu-list" lay-filter="menu-list"></table>
</div>
<script type="text/html" id="typeTpl">
    {{# if(d.menuType === '0'){ }}
        <span class="layui-btn layui-btn-xs">{{$t('menuList.catalogue')}}</span>
    {{# } else if(d.menuType === '1'){ }}
        <span class="layui-btn layui-btn-warm layui-btn-xs">{{$t('menuList.menu')}}</span>
    {{# } else if(d.menuType === '2'){ }}
        <span class="layui-btn layui-btn-danger layui-btn-xs">{{$t('menuList.button')}}</span>
    {{# } }}
</script>
<script type="text/html" id="iconTpl">
    {{#  if(d.menuIcon != null){ }}
    {{#  if(d.menuIcon.indexOf("fa-") !== -1){ }}
        <i class="fa {{d.menuIcon}}"></i>
    {{# }else{ }}
        <i class="layui-icon">{{d.menuIcon}}</i>
    {{#  } } else { '' } }}
</script>
<script src="/menu/menu.js"></script>
</body>
</html>
