<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>图片管理</title>
    <#include "../resource.ftl"/>
</head>

<body>
	<style>
		body {
			margin: 0 20px;
		}
	</style>
	<!--新建会员等级表单-->
	<div id="createId" style="display: none;height:320px">
		<form class="layui-form layui-card" lay-filter="addForm">
			<div class="layui-card-body">

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">轮播图描述</label>
					<div class="layui-input-block">
						<input name="content" lay-filter="content" required placeholder="请输入轮播图描述" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">选择图片类型</label>
					<div class="layui-input-block">
						<select name="showType" lay-verify="required">
							<option value=""></option>
							<option value="1">首页展示</option>
							<option value="2">底部展示</option>
							<option value="3">LOGO</option>
							<option value="4">其他</option>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">图片</label>
					<div>
						<button type="button" class="layui-btn" id="uploadPic">
							<i class="layui-icon">&#xe67c;</i>上传图片
						</button>
						<img name="picturePath"  id="upload-img" style="display: none; width: 150px;margin-left: 12px;" src="">
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
					<label class="layui-form-label label-required label-required-next">轮播图描述</label>
					<div class="layui-input-block">
						<input name="content" required placeholder="请输入轮播图描述" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>

					<div class="layui-form-item">
					<label class="layui-form-label">选择图片类型</label>
					<div class="layui-input-block">
						<select name="showType" lay-verify="required">
							<option value=""></option>
							<option value="1">首页展示</option>
							<option value="2">底部展示</option>
							<option value="3">LOGO</option>	
							<option value="4">其他</option>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">图片</label>
					<div>
						<button type="button" class="layui-btn" id="updatePic">
							<i class="layui-icon">&#xe67c;</i>上传图片
						</button>
						<img name="picturePath" id="update-img" style="display: none; width: 150px;margin-left: 12px;" src="">
					</div>
				</div>

				<div class="hr-line-dashed"></div>
				<div class="layui-form-item text-center">
					<button class="layui-btn" lay-submit lay-filter="editSubmit">提交</button>
					<button type="button" class="layui-btn layui-btn-danger" id="editCancel">取消</button>
				</div>
			</div>
		</form>
	</div>


	<div class="layui-btn-container" style="margin-top: 20px;">
		<button class="layui-btn" id="createBtn">添加图片</button>
	</div>

	<table id="level" lay-filter="level" style="margin-top: 5px"></table>

	<script type="text/html" id="operation">
				<a class="layui-btn layui-btn-xs" style="background-color: green;" lay-event="edit">编辑</a>
				<a class="layui-btn layui-btn-xs" style="background-color: red;" lay-event="delete">删除</a>
		</script>

	<!--注册信息-->
	<script type="text/html" id="picturePath">
		<div>
			<img src='https://sgp1.digitaloceanspaces.com{{d.picturePath}}' alt="">
		</div>
	</script>

	<script type="text/html" id="showType">
	<div>{{#	if (d.showType == 1) {
			return '首页展示'
		} else if (d.showType == 2) {
			return '底部展示'
		} else if (d.showType == 2) {
			return 'LOGO'
		} else if (d.showType == 2) {
			return '其他'
		}}}
	</div>
		
	</script>

	<script type="text/html" id="updateTime">
		<div>{{ layui.util.toDateString(d.goodsAddTime, 'yyyy年MM月dd日 HH:mm:ss')}}</div>
	</script>

<script src='/addSwiper/addSwiper.js'></script>
</body>

</html>