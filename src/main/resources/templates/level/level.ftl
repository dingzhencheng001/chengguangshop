<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>会员等级</title>
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
				<label class="layui-form-label label-required label-required-next">名称</label>
				<div class="layui-input-block">
					<input name="membersName" lay-filter="membersName" lay-verify="required" required placeholder="请输入名称" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">图标</label>
				<div>
					<button type="button" class="layui-btn" id="uploadPic">
						<i class="layui-icon">&#xe67c;</i>上传图标
					</button>
					<img name="pic" id="upload-img" lay-filter="pic" style="display: none; width: 150px;margin-left: 12px;" src="">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">会员价格</label>
				<div class="layui-input-block">
					<input name="memberPrice" lay-filter="memberPrice" lay-verify="required|number" required placeholder="请输入会员价格" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">佣金比例</label>
				<div class="layui-input-block">
					<input name="commission" lay-filter="commission" lay-verify="required|number" type="number" min="0" step='0.001' required placeholder="请输入佣金比例" value=""
						   class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">最小余额</label>
				<div class="layui-input-block">
					<input name="numMin" lay-filter="numMin" lay-verify="required|number" type="number" min="0" required placeholder="请输入最小余额" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">接单次数</label>
				<div class="layui-input-block">
					<input name="orderNum" lay-filter="orderNum" lay-verify="required|number" required placeholder="请输入接单次数" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">提现次数</label>
				<div class="layui-input-block">
					<input name="withdrawalTimes" lay-filter="withdrawalTimes" lay-verify="required|number" required placeholder="请输入提现次数" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">匹配区间</label>
				<div class="layui-input-inline" style="width: 100px;">
					<input type="number" name="mate_min" placeholder="请输入匹配最小值" lay-verify="required|number" class="layui-input">
				</div>
				<div class="layui-form-mid">-</div>
				<div class="layui-input-inline" style="width: 100px;">
					<input type="number" name="mate_max" placeholder="请输入匹配最大值" lay-verify="required|number" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">提现最小金额</label>
				<div class="layui-input-block">
					<input name="withdrawalMin" lay-filter="withdrawalMin" lay-verify="required|number" required placeholder="请输入提现最小金额" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">提现最大金额</label>
				<div class="layui-input-block">
					<input name="withdrawalMax" lay-filter="withdrawalMax" lay-verify="required|number" required placeholder="请输入提现最大金额" value="" class="layui-input" />
				</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="layui-form-item text-center">
				<button type="button" class="layui-btn" lay-submit lay-filter="createSubmit">提交</button>
				<button type="button" class="layui-btn layui-btn-danger" id="createCancel">取消</button>
			</div>
		</div>
	</form>
</div>

<!--编辑表单-->
<div id="editId" style="display: none">
	<form class="layui-form layui-card" lay-filter="editForm">
		<div class="layui-card-body">
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">名称</label>
				<div class="layui-input-block">
					<input name="membersName" required placeholder="请输入名称" lay-verify="required" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">图片</label>
				<div>
					<button type="button" class="layui-btn" id="updatePic">
						<i class="layui-icon">&#xe67c;</i>上传图片
					</button>
					<img name="pic" id="update-img" style="display: none; width: 150px;margin-left: 12px;" src="">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">会员价格</label>
				<div class="layui-input-block">
					<input name="memberPrice" lay-verify="required|number" required placeholder="请输入会员价格" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">佣金比例</label>
				<div class="layui-input-block">
					<input name="commission" lay-verify="required|number" type="number" min="0" required placeholder="请输入佣金比例" value=""
						   class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">最小余额</label>
				<div class="layui-input-block">
					<input name="numMin" lay-verify="required|number" type="number" min="0" required placeholder="请输入最小余额" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">接单次数</label>
				<div class="layui-input-block">
					<input name="orderNum"   lay-verify="required|number" required placeholder="请输入接单次数" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">提现次数</label>
				<div class="layui-input-block">
					<input name="withdrawalTimes" lay-verify="required|number" required placeholder="请输入提现次数" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">匹配区间</label>
				<div class="layui-input-inline" style="width: 100px;">
					<input type="number" name="mate_min" placeholder="请输入匹配最小值" lay-verify="required|number" class="layui-input">
				</div>
				<div class="layui-form-mid">-</div>
				<div class="layui-input-inline" style="width: 100px;">
					<input type="number" name="mate_max" placeholder="请输入匹配最大值" lay-verify="required|number" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">提现最小金额</label>
				<div class="layui-input-block">
					<input name="withdrawalMin" lay-verify="required|number" required placeholder="请输入提现最小金额" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next">提现最大金额</label>
				<div class="layui-input-block">
					<input name="withdrawalMax" lay-verify="required|number" required placeholder="请输入提现最大金额" value="" class="layui-input" />
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
	<button class="layui-btn" id="createBtn">添加会员等级</button>
</div>

<table id="level" lay-filter="level" style="margin-top: 5px"></table>

<script type="text/html" id="operation">
	<a class="layui-btn layui-btn-xs" style="background-color: green;" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-xs" style="background-color: red;" lay-event="delete">删除</a>
</script>

<!--注册信息-->
<script type="text/html" id="register">
	<div>
		<p>{{ layui.util.toDateString(d.registerTime, 'yyyy-MM-dd HH:mm:ss')}}</p>
		<p>{{ d.registerCountry}}</p>
	</div>
</script>

<script type="text/html" id="pic">
	<div>
		<img src='{{d.pic}}' alt="">
	</div>
</script>

<script src="/level/level.js" ></script>
</body>

</html>