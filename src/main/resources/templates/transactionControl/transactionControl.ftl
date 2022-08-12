<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>交易控制</title>
	<#include "../resource.ftl"/>
</head>

<body>
	<div class="layui-fluid member-list-page">
		<div class="layui-tab">
			<ul class="layui-tab-title">
				<li class="layui-this">基础设置</li>
				<!-- <li>权限分配</li>
				<li>商品管理</li>
				<li>订单管理</li> -->
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<form class="layui-form layui-card" lay-filter="editForm">
						<div class="layui-card-body padding-40 layui-col-md8">
							<label class="layui-form-item block relative label-required-prev">
								<span class="color-green margin-right-10">TRC20地址</span>
								<input name="trc" required="" value="" placeholder="请输入TRC20地址" class="layui-input" />
							</label>
							<label class="layui-form-item block relative label-required-prev">
								<span class="color-green margin-right-10">ERC20地址</span>
								<input name="erc" required="" value="" placeholder="请输入ERC20地址" class="layui-input" /></label>
							<label class="layui-form-item block relative label-required-prev">
								<span class="color-green margin-right-10">USDT</span>
								<input name="usdt" required="" placeholder="请输入USDT" class="layui-input" />
							</label>
							<hr />
<#--							<label class="layui-form-item block relative label-required-prev"><span-->
<#--									class="color-green margin-right-10">交易所需余额</span>-->
<#--								<input name="dealAmount" required="" value="" class="layui-input" />-->
<#--								<p class="help-block">交易所需余额</p>-->
<#--							</label>-->
							<label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">未订单的支付等待时长（秒）</span>
								<input name="wait" required="" placeholder="请输入订单支付等待时长" value="" class="layui-input" />
								<p class="help-block">订单支付等待时长，新下订单未在此时间内容完成支付将会被自动取消</p>
							</label>
<#--							<label class="layui-form-item margin-top-20 block relative"><span-->
<#--									class="color-green margin-right-10">匹配范围</span>-->
<#--								<!-- <span class="nowrap color-desc">OrderClearTime</span> &ndash;&gt;-->
<#--								<div id="deal_rule" style="position:relative; margin: 10px 0px;" class="demo-slider">-->
<#--									<div class="layui-slider ">-->
<#--										<div class="layui-slider-tips"></div>-->
<#--										<div class="layui-slider-bar" style="background:#009688; width:82%;left:0%;"></div>-->
<#--										<div class="layui-slider-wrap" style="left:0%;">-->
<#--											<div class="layui-slider-wrap-btn" style="border: 2px solid #009688;"></div>-->
<#--										</div>-->
<#--										<div class="layui-slider-wrap" style="left:82%;">-->
<#--											<div class="layui-slider-wrap-btn" style="border: 2px solid #009688;"></div>-->
<#--										</div>-->
<#--									</div>-->
<#--								</div>-->
<#--								<div id="test-slider-tips2" style="position:relative; margin: 10px 0px;" class="help-block">匹配范围：0% ~-->
<#--									100%</div><input type="hidden" name="startRang" id="min" value=""><input type="hidden" name="endRang"-->
<#--									id="max" value="">-->
<#--							</label>-->
<#--							<label class="layui-form-item margin-top-20 block relative label-required-prev"><span-->
<#--									class="color-green margin-right-10">当日交易次数限制</span><input name="tradeNum" required="" value=""-->
<#--									class="layui-input" />-->
<#--								<p class="help-block">当日交易次数限制</p>-->
<#--							</label>-->
<#--							<label class="layui-form-item margin-top-20 block relative label-required-prev"><span-->
<#--									class="color-green margin-right-10">奖励交易次数</span><input name="rewardNum" required="" value=""-->
<#--									class="layui-input" />-->
<#--								<p class="help-block">奖励交易次数</p>-->
<#--							</label>-->
							<label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">普通会员交易佣金</span>
								<input name="generalCommission" max="1" min="0" step="0.01" required="" value="0." type="number"
									class="layui-input" /><span style="
											padding-right: 12px;
											color: rgb(169, 68, 66);
											position: absolute;
											right: 0px;
											font-size: 12px;
											z-index: 2;
											display: block;
											width: 30px;
											text-align: center;
											pointer-events: none;
											top: 24px;
											padding-bottom: 0px;
											line-height: 38px;
										"></span>
								<p class="help-block">交易佣金</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">上一级会员交易佣金</span>
								<input name="upOneCommission" max="1" min="0" step="0.01" required="" value="" type="number"
									class="layui-input" />
								<p class="help-block">交易佣金</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">上二级会员交易佣金</span>
								<input name="upTwoCommission" max="1" min="0" step="0.01" required="" value="" type="number"
									class="layui-input" />
								<p class="help-block">交易佣金</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">上三级会员交易佣金</span>
								<input name="upThreeCommission" max="1" min="0" step="0.01" required="" value="" type="number"
									class="layui-input" />
								<p class="help-block">交易佣金</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">上四级会员交易佣金</span>
								<input name="upFourCommission" max="1" min="0" step="0.01" required="" value="" type="number"
									class="layui-input" />
								<p class="help-block">交易佣金</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">上五级会员交易佣金</span>
								<input name="upFiveCommission" max="1" min="0" step="0.01" required="" value="" type="number"
									class="layui-input" />
								<p class="help-block">交易佣金</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">冻结时间</span>
								<input name="freeze" required="" value="" class="layui-input" /><span style="
											padding-right: 12px;
											color: rgb(169, 68, 66);
											position: absolute;
											right: 0px;
											font-size: 12px;
											z-index: 2;
											display: block;
											width: 30px;
											text-align: center;
											pointer-events: none;
											top: 24px;
											padding-bottom: 0px;
											line-height: 38px;
										"></span>
								<p class="help-block">冻结时间</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">允许违规次数</span><input name="violate" required=""
									placeholder="请输入已发货订单自动确认收货时长" value="0" class="layui-input" />
								<p class="help-block">允许违规次数</p>
							</label><label class="layui-form-item margin-top-20 block relative"><span
									class="color-green margin-right-10">提交订单延时时间(单位/秒)</span>
								<p>
									远程主机分配时间:
									<input name="distributeTime" style="width: 100px; display: inline-block" required="" placeholder=""
										value="1" class="layui-input" />
									等待商家响应时间
									<input name="responseTime" style="width: 100px; display: inline-block" required="" placeholder=""
										value="1" class="layui-input" />
								</p>
								<p class="help-block">时间由2部分组成,默认都是5秒,总共10秒</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">app下载地址</span><input name="appAdress" required=""
									placeholder="请输入app下载地址" value="" class="layui-input" />
								<p class="help-block">app下载地址</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">版本号</span><input name="version" required="" placeholder="请输入版本"
									value="" class="layui-input" />
								<p class="help-block">版本号</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">提现时间</span><input style="width: 120px; display: inline-block"
									name="startWithdraw" required="" placeholder="提现开始时间" value="00" class="layui-input" /><span style="
											padding-right: 12px;
											color: rgb(169, 68, 66);
											position: absolute;
											right: 0px;
											font-size: 12px;
											z-index: 2;
											display: block;
											width: 30px;
											text-align: center;
											pointer-events: none;
											top: 0px;
											padding-bottom: 0px;
											line-height: 38px;
										"></span>
								-
								<input style="width: 120px; display: inline-block" name="endWithdraw" required placeholder="提现结束时间"
									value="" class="layui-input" />
								<p class="help-block">只支持整点, 如08:00-20:00,请直接输入 8 - 20</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">充值时间</span><input style="width: 120px; display: inline-block"
									name="startDeposit" required="" placeholder="充值开始时间" value="" class="layui-input" /><span style="
											padding-right: 12px;
											color: rgb(169, 68, 66);
											position: absolute;
											right: 0px;
											font-size: 12px;
											z-index: 2;
											display: block;
											width: 30px;
											text-align: center;
											pointer-events: none;
											top: 0px;
											padding-bottom: 0px;
											line-height: 38px;
										"></span>
								-
								<input style="width: 120px; display: inline-block" name="endDeposit" required="" placeholder="充值结束时间"
									value="" class="layui-input" />
								<p class="help-block">只支持整点, 如08:00-20:00,请直接输入 8 - 20</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">抢单时间</span><input style="width: 120px; display: inline-block"
									name="startConvey" required="" placeholder="抢单开始时间" value="" class="layui-input" />
								-
								<input style="width: 120px; display: inline-block" name="endConvey" required="" placeholder="抢单结束时间"
									value="" class="layui-input" />
								<p class="help-block">只支持整点, 如08:00-20:00,请直接输入 8 - 20</p>
							</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10">商城状态</span><input style="width: 120px; display: inline-block"
									name="shopStatus" required="" placeholder="商城状态" value="" class="layui-input" />
								<p class="help-block">商城状态: 1开启 0关闭</p>
							</label>
						</div>
						<div class="layui-form-item text-center margin-top-20">
							<button class="layui-btn" type="submit" lay-submit lay-filter="editSubmit">保存配置</button>
						</div>
					</form>
				</div>
				<div class="layui-tab-item">内容2</div>
				<div class="layui-tab-item">内容3</div>
				<div class="layui-tab-item">内容4</div>
				<div class="layui-tab-item">内容5</div>
			</div>
		</div>

		<table id="level" lay-filter="level" style="margin-top: 5px"></table>
	</div>

	<script>
		layui.use(['form', 'slider'], function () {
			var form = layui.form,
				slider = layui.slider,
				$ = layui.$,
				startRang, endRang,
				_startRang, _endRang

			$(document).ready(function () {
				console.log('页面加载')
				$.ajax({
					url: '/action/control/select',
					type: 'POST',
					success: function (res) {
						// startRang = res.data.startRang, endRang = res.data.endRang
						// slider.render({
						// 	elem: '#deal_rule'
						// 	, value: [startRang, endRang] //初始值
						// 	, range: true //范围选择
						// 	, change: function (vals) {
						// 		$('#test-slider-tips2').html('匹配范围：' + vals[0] + '% ~ ' + vals[1] + '%');
						// 		$('#min').val(vals[0]);
						// 		$('#max').val(vals[1]);
						// 	}
						// });
						form.val('editForm', res.data)
						// $('#test-slider-tips2').html('匹配范围：' + startRang + '% ~ ' + endRang + '%');
					},
					error: function () {
						alert('出错啦...')
					}
				})
			})

			form.on('submit(editSubmit)', function (data) {
				data.field.startRang = $('#min').val();
				data.field.endRang = $('#max').val();
				$.ajax({
					url: '/action/control/save',
					type: 'POST',
					data: JSON.stringify(data.field),
					dataType: "json",
					contentType: "application/json",
					success: function (res) {
						layer.msg('保存成功', { icon: 1 })
						console.log('res', res)
					},
					error: function () {
						alert('出错啦...')
					}
				})
				return false
			})
		})
	</script>
</body>

</html>