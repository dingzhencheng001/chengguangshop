<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>公告管理</title>
	<#include "../resource.ftl"/>
</head>


<body>
<div class="layui-fluid">
<div id="createId" style="display: none">
	<form class="layui-form layui-card" lay-filter="addForm">
		<div class="layui-card-body">
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="notice.noticeTitle">公告标题</label>
				<div class="layui-input-block">
					<input name="noticeTitle" required data-placeholder="notice.petNoticeTitle" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="notice.noticeContent">公告内容</label>
				<div class="layui-input-block">
					<textarea id="addTextarea" name="noticeContent" lay-verify="content"></textarea>
				</div>
			</div>

			<div class="hr-line-dashed"></div>
			<div class="layui-form-item text-center">
				<button class="layui-btn" lay-submit lay-filter="createSubmit" data-locale="submit">提交</button>
				<button type="button" class="layui-btn layui-btn-danger" id="createCancel" data-locale="cancel">取消</button>
			</div>
		</div>
	</form>
</div>

<!--编辑表单-->
<div id="editId" style="display: none">
	<form class="layui-form layui-card" lay-filter="editForm">
		<div class="layui-card-body">
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="notice.noticeTitle">公告标题</label>
				<div class="layui-input-block">
					<input name="noticeTitle" required data-placeholder="notice.petNoticeTitle" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="notice.noticeContent">公告内容</label>
				<div class="layui-input-block">
					<textarea id="editTextarea" name="noticeContent" lay-verify="content"></textarea>
				</div>
			</div>

			<div class="hr-line-dashed"></div>
			<div class="layui-form-item text-center">
				<button class="layui-btn" lay-submit lay-filter="editSubmit" data-locale="submit">提交</button>
				<button type="button" class="layui-btn layui-btn-danger" id="editCancel" data-locale="cancel">取消</button>
			</div>
		</div>
	</form>
</div>


<div class="layui-btn-container" style="margin-top: 20px;">
	<button class="layui-btn" id="createBtn" data-locale="notice.createBtn">添加公告</button>
</div>

<table id="level" lay-filter="level" style="margin-top: 5px"></table>

<script type="text/html" id="operation">
	<span style="display: inline-block">
				<a class="layui-btn layui-btn-xs" lay-event="edit">{{$t('edit')}}</a>
			</span>
	<span style="display: inline-block">
				<a class="layui-btn layui-btn-xs" lay-event="delete">{{$t('delete')}}</a>
			</span>
</script>

<!--注册信息-->
<script type="text/html" id="createTime">
	<div>
		<p>{{ layui.util.toDateString(d.createTime, 'yyyy-MM-dd')}}</p>
		<p>{{ d.createTime}}</p>
	</div>
</script>

</div>

<script src='/notice/notice.js'></script>
</body>

</html>