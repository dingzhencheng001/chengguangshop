<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>公告管理</title>
	<#include "../resource.ftl"/>
</head>

<body>
	<style>
		body {
			margin: 0 20px;
		}
	</style>
	<!--新建会员等级表单-->
	<div id="createId" style="display: none">
		<form class="layui-form layui-card" lay-filter="addForm">
			<div class="layui-card-body">
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">公告标题</label>
					<div class="layui-input-block">
						<input name="noticeTitle" lay-filter="noticeTitle" required placeholder="请输入公告标题" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label abel-required label-required-next">公告类型</label>
					<div class="layui-input-block">
						<select name="noticeType" lay-verify="required">
							<option value="">请选择公告类型</option>
							<option value="1">首页弹窗</option>
							<option value="2">公告</option>
							<option value="3">其他</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">公告内容</label>
					<div class="layui-input-block">
						<textarea id="addTextarea" placeholder="请输入内容" name="noticeContent" ></textarea>
					</div>
				</div>

				<div class="hr-line-dashed"></div>
				<div class="layui-form-item text-center">
					<button type="button" class="layui-btn" lay-submit lay-filter="createSubmit">提交</button>
					<button type="button" class="layui-btn layui-btn-danger" id="createCancel">取消</button>
				</div>
			</div>
	</div>
	</form>
	</div>

	<!--编辑表单-->
	<div id="editId" style="display: none">
		<form class="layui-form layui-card" lay-filter="editForm">
			<div class="layui-card-body">
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">公告标题</label>
					<div class="layui-input-block">
						<input name="noticeTitle" required placeholder="请输入公告标题" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>
					<div class="layui-form-item">
					<label class="layui-form-label abel-required label-required-next">公告类型</label>
					<div class="layui-input-block">
						<select name="noticeType" lay-verify="required">
							<option value="">请选择公告类型</option>
							<option value="1">首页弹窗</option>
							<option value="2">公告</option>
							<option value="3">其他</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">公告内容</label>
					<div class="layui-input-block">
						<textarea id="editTextarea" placeholder="请输入内容" name="noticeContent" ></textarea>
					</div>
				</div>

				<div class="hr-line-dashed"></div>
				<div class="layui-form-item text-center">
					<button type="button" class="layui-btn" lay-submit lay-filter="editSubmit">提交</button>
					<button type="button" class="layui-btn layui-btn-danger" id="editCancel">取消</button>
				</div>
			</div>
		</form>
	</div>


	<div class="layui-btn-container" style="margin-top: 20px;">
		<button class="layui-btn" id="createBtn">添加公告</button>
	</div>

	<table id="level" lay-filter="level" style="margin-top: 5px"></table>

	<script type="text/html" id="operation">
	<span>
		{{#  if (d.status ==1){ }}
    <a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-xs" style="background:red;" lay-event="delete">删除</a>
		<a class="layui-btn layui-btn-xs" style="background:#00375F;" lay-event="forbidden">禁用</a>
  	{{#  }else{ }}
		 <a class="layui-btn layui-btn-xs" style="background:green;" lay-event="forbidden">启用</a>
  	{{#  } }}
	</span>

	</script>

	<!--注册信息-->
	<script type="text/html" id="createTime">
				<p>{{ layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</p>
		</script>

	<script type="text/html" id="noticeType">
				<p>{{ d.noticeType==1?'首页弹窗':(d.noticeType==2?'公告':'其他') }}</p>
		</script>

	<script src='/notice/notice.js'></script>
</body>

</html>