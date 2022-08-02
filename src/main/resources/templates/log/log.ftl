<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>日志查看</title>
	<#include "../resource.ftl"/>
</head>

<body>

	<div class="layui-fluid member-list-page">

		<div class="think-box-shadow">
			<fieldset>
				<legend>条件搜索</legend>
				<form class="layui-form layui-form-pane form-search" lay-filter="searchForm" action="">
					<div class="layui-form-item layui-inline">
						<label class="layui-form-label">标题</label>
						<div class="layui-input-inline">
							<input name="title" value="" placeholder="请输入日志标题" class="layui-input" />
						</div>
					</div>
					<div class="layui-form-item layui-inline">
						<label class="layui-form-label">内容关键词</label>
						<div class="layui-input-inline">
							<input name="operateContent" value="" placeholder="请输入日志内容关键字" class="layui-input" />
						</div>
					</div>
					<div class="layui-form-item layui-inline">
						<label class="layui-form-label">查询时间</label>
						<div class="layui-input-inline">
							<input type="text" name="time" class="layui-input" id="registrationTime" placeholder="请选择查询时间">
						</div>
					</div>
					<div class="layui-form-item layui-inline">
						<button type="submit" class="layui-btn layui-btn-danger" lay-submit lay-filter="search"><i
								class="layui-icon"></i> 搜 索
						</button>
					</div>
					<div class="layui-form-item layui-inline">
						<button id="reset" type="button" class="layui-btn layui-btn-primary layui-btn-lg ">
							<i class="layui-icon">&#xe669;</i>
							重置</button>
					</div>
				</form>
			</fieldset>
		</div>
		<table id="level" lay-filter="level" style="margin-top: 5px"></table>
	</div>

	<!--注册信息-->
	<script type="text/html" id="createTime">
			<div>
				<p>{{ layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</p>
				<p>{{ d.createTime}}</p>
			</div>
		</script>

	<script src='/log/log.js'></script>
</body>

</html>
