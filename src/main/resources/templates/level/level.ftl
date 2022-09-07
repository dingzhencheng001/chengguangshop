<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>会员等级</title>
	<#include "../resource.ftl"/>
</head>

<body>
<div class="layui-fluid">
<!--新建会员等级表单-->
<div id="createId" style="display: none">
	<form class="layui-form layui-card" lay-filter="addForm">
		<div class="layui-card-body">
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.membersName">名称</label>
				<div class="layui-input-block">
					<input name="membersName" lay-filter="membersName" lay-verify="required" required data-placeholder="请输入名称" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.icon">图标</label>
				<div>
					<button type="button" class="layui-btn" id="uploadPic" data-locale="level.uploadPic">
						<i class="layui-icon">&#xe67c;</i>上传图标
					</button>
					<img name="pic" id="upload-img" lay-filter="pic" style="display: none; width: 150px;margin-left: 12px;" src="">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.memberPrice">会员价格</label>
				<div class="layui-input-block">
					<input name="memberPrice" lay-filter="memberPrice" lay-verify="required|number" required data-placeholder="level.petMemberPrice" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.commission">佣金比例</label>
				<div class="layui-input-block">
					<input name="commission" lay-filter="commission" lay-verify="required|number" type="number" min="0" step='0.001' required
						   data-placeholder="level.petCommission" value=""
						   class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.numMin">最小余额</label>
				<div class="layui-input-block">
					<input name="numMin" lay-filter="numMin" lay-verify="required|number" type="number" min="0" required data-placeholder="level.petNumMin" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.orderNum">接单次数</label>
				<div class="layui-input-block">
					<input name="orderNum" lay-filter="orderNum" lay-verify="required|number" required data-placeholder="level.petOrderNum" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.withdrawalTimes">提现次数</label>
				<div class="layui-input-block">
					<input name="withdrawalTimes" lay-filter="withdrawalTimes" lay-verify="required|number" required
						   data-placeholder="level.petWithdrawalTimes" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.mate">匹配区间</label>
				<div class="layui-input-inline" style="width: 100px; margin-right: 4px">
					<input type="number" name="mateMin" min="0" data-placeholder="level.petMateMin" lay-verify="required|number" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">%</div>
				<div class="layui-form-mid">-</div>
				<div class="layui-input-inline" style="width: 100px; margin-right: 4px">
					<input type="number" name="mateMax" min="0" data-placeholder="level.petMateMax" lay-verify="required|number" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">%</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.withdrawalMin">提现最小金额</label>
				<div class="layui-input-block">
					<input name="withdrawalMin" lay-filter="withdrawalMin" lay-verify="required|number" required
						   data-placeholder="level.petWithdrawalMin" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.withdrawalMax">提现最大金额</label>
				<div class="layui-input-block">
					<input name="withdrawalMax" lay-filter="withdrawalMax" lay-verify="required|number" required
						   data-placeholder="level.petWithdrawalMax" value="" class="layui-input" />
				</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="layui-form-item text-center">
				<button type="button" class="layui-btn" lay-submit lay-filter="createSubmit" data-locale="submit">提交</button>
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
				<label class="layui-form-label label-required label-required-next" data-locale="level.membersName">名称</label>
				<div class="layui-input-block">
					<input name="membersName" required data-placeholder="level.petMembersName" lay-verify="required" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.icon">图片</label>
				<div>
					<button type="button" class="layui-btn" id="updatePic" data-locale="level.uploadPic">
						<i class="layui-icon">&#xe67c;</i>上传图片
					</button>
					<img name="pic" id="update-img" style="display: none; width: 100px;margin-left: 12px;" src="">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.memberPrice">会员价格</label>
				<div class="layui-input-block">
					<input name="memberPrice" lay-verify="required|number" required data-placeholder="level.petMemberPrice" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.commission">佣金比例</label>
				<div class="layui-input-block">
					<input name="commission" lay-verify="required|number" type="number" min="0" required data-placeholder="level.petCommission" value=""
						   class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.numMin">最小余额</label>
				<div class="layui-input-block">
					<input name="numMin" lay-verify="required|number" type="number" min="0" required data-placeholder="level.petNumMin" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.orderNum">接单次数</label>
				<div class="layui-input-block">
					<input name="orderNum"   lay-verify="required|number" required data-placeholder="level.petOrderNum" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.withdrawalTimes">提现次数</label>
				<div class="layui-input-block">
					<input name="withdrawalTimes" lay-verify="required|number" required data-placeholder="level.petWithdrawalTimes" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.mate">匹配区间</label>
				<div class="layui-input-inline" style="width: 100px; margin-right: 4px">
					<input type="number" name="mateMin" min="0" data-placeholder="level.petMateMin" lay-verify="required|number" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">%</div>
				<div class="layui-form-mid">-</div>
				<div class="layui-input-inline" style="width: 100px; margin-right: 4px">
					<input type="number" name="mateMax" min="0" data-placeholder="level.petMateMax" lay-verify="required|number" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">%</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.withdrawalMin">提现最小金额</label>
				<div class="layui-input-block">
					<input name="withdrawalMin" lay-verify="required|number" required data-placeholder="level.petWithdrawalMin" value="" class="layui-input" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label label-required label-required-next" data-locale="level.withdrawalMax">提现最大金额</label>
				<div class="layui-input-block">
					<input name="withdrawalMax" lay-verify="required|number" required data-placeholder="level.petWithdrawalMax" value="" class="layui-input" />
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
	<button class="layui-btn" id="createBtn" data-locale="level.add">添加会员等级</button>
</div>

<table id="level" lay-filter="level" style="margin-top: 5px"></table>

</div>

<script type="text/html" id="operation">
	<a class="layui-btn layui-btn-xs" style="background-color: green;" lay-event="edit">{{$t('edit')}}</a>
	<a class="layui-btn layui-btn-xs" style="background-color: red;" lay-event="delete">{{$t('delete')}}</a>
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