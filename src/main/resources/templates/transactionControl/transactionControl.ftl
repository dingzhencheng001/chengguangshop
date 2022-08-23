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
			<li class="layui-this" data-locale="tc.basicSettings">基础设置</li>
			<!-- <li>权限分配</li>
            <li>商品管理</li>
            <li>订单管理</li> -->
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<form class="layui-form layui-card" lay-filter="editForm">
					<div class="layui-card-body padding-40 layui-col-md8">
						<label class="layui-form-item block relative label-required-prev">
							<span class="color-green margin-right-10" data-locale="tc.trc">TRC20地址</span>
							<input name="trc" lay-verify="required" value="" data-placeholder="tc.petTrc" class="layui-input"/>
						</label>
						<label class="layui-form-item block relative label-required-prev">
							<span class="color-green margin-right-10" data-locale="tc.erc">ERC20地址</span>
							<input name="erc" lay-verify="required" value="" data-placeholder="tc.petErc"
								   class="layui-input"/></label>
						<label class="layui-form-item block relative label-required-prev">
							<span class="color-green margin-right-10" data-locale="tc.usdt">USDT</span>
							<input name="usdt" lay-verify="required" data-placeholder="tc.petUsdt" class="layui-input"/>
						</label>
						<hr/>
						<label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.wait">未订单的支付等待时长（秒）</span>
							<input name="wait" lay-verify="required" data-placeholder="tc.petWait" value="" class="layui-input"/>
							<p class="help-block" data-locale="tc.waitHelp">订单支付等待时长，新下订单未在此时间内容完成支付将会被自动取消</p>
						</label>
						<label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.generalCommission">普通会员交易佣金</span>
							<input name="generalCommission" max="1" min="0" step="0.01" required="" value="0."
								   type="number"
								   class="layui-input"/><span style="
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
							<p class="help-block" data-locale="tc.generalCommissionHelp">交易佣金</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.upOneCommission">上一级会员交易佣金</span>
							<input name="upOneCommission" max="1" min="0" step="0.01" required="" value="" type="number"
								   class="layui-input"/>
							<p class="help-block" data-locale="tc.generalCommissionHelp">交易佣金</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.upTwoCommission">上二级会员交易佣金</span>
							<input name="upTwoCommission" max="1" min="0" step="0.01" required="" value="" type="number"
								   class="layui-input"/>
							<p class="help-block" data-locale="tc.generalCommissionHelp">交易佣金</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.upThreeCommission">上三级会员交易佣金</span>
							<input name="upThreeCommission" max="1" min="0" step="0.01" required="" value="" type="number"
								   class="layui-input"/>
							<p class="help-block" data-locale="tc.generalCommissionHelp">交易佣金</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.upFourCommission">上四级会员交易佣金</span>
							<input name="upFourCommission" max="1" min="0" step="0.01" required="" value="" type="number"
								   class="layui-input"/>
							<p class="help-block" data-locale="tc.generalCommissionHelp">交易佣金</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.upFiveCommission">上五级会员交易佣金</span>
							<input name="upFiveCommission" max="1" min="0" step="0.01" required="" value="" type="number"
								   class="layui-input"/>
							<p class="help-block" data-locale="tc.generalCommissionHelp">交易佣金</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.freeze">冻结时间</span>
							<input name="freeze" required="" value="" class="layui-input"/><span style="
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
							<p class="help-block" data-locale="tc.freeze">冻结时间</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.violate">允许违规次数</span><input name="violate" required=""
																													 data-placeholder="tc.petViolate"
																													 value="0" class="layui-input"/>
							<p class="help-block" data-locale="tc.violate">允许违规次数</p>
						</label><label class="layui-form-item margin-top-20 block relative"><span
									class="color-green margin-right-10" data-locale="tc.distributeTime">提交订单延时时间(单位/秒)</span>
							<p>
								<span data-locale="tc.distributeTimeText1">远程主机分配时间:</span>
								<input name="distributeTime" style="width: 100px; display: inline-block" required=""
									   placeholder=""
									   value="1" class="layui-input"/>
								<span data-locale="tc.distributeTimeText2">等待商家响应时间</span>
								<input name="responseTime" style="width: 100px; display: inline-block" required=""
									   placeholder=""
									   value="1" class="layui-input"/>
							</p>
							<p class="help-block" data-locale="tc.distributeTimeHelp">时间由2部分组成,默认都是5秒,总共10秒</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.appAdress">app下载地址</span><input name="appAdress" required=""
																														data-placeholder="tc.petAppAdress" value=""
																														class="layui-input"/>
							<p class="help-block" data-locale="tc.appAdress">app下载地址</p>
						</label><label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.version">版本号</span><input name="version" required=""
																												  data-placeholder="tc.petVersion"
																												  value="" class="layui-input"/>
							<p class="help-block" data-locale="tc.version">版本号</p>
						</label>
						<label class="layui-form-item margin-top-20 block relative label-required-prev">
							<span class="color-green margin-right-10" data-locale="tc.withdraw">提现时间</span>
							<input type="text" class="layui-input" lay-verify="required" name="withdraw" id="wthdraw" value=""
								   data-placeholder="tc.petWithdraw">
						</label>
						<label class="layui-form-item margin-top-20 block relative label-required-prev">
							<span class="color-green margin-right-10" data-locale="tc.deposit">充值时间</span>
							<input type="text" class="layui-input" lay-verify="required" name="deposit" id="deposit" value=""
								   data-placeholder="tc.petDeposit">
							<!--                            <input style="width: 120px; display: inline-block"-->
							<!--                                   name="startDeposit" required="" placeholder="充值开始时间" value=""-->
							<!--                                   class="layui-input"/><span style="-->
							<!--											padding-right: 12px;-->
							<!--											color: rgb(169, 68, 66);-->
							<!--											position: absolute;-->
							<!--											right: 0px;-->
							<!--											font-size: 12px;-->
							<!--											z-index: 2;-->
							<!--											display: block;-->
							<!--											width: 30px;-->
							<!--											text-align: center;-->
							<!--											pointer-events: none;-->
							<!--											top: 0px;-->
							<!--											padding-bottom: 0px;-->
							<!--											line-height: 38px;-->
							<!--										"></span>-->
							<!--                            - -->
							<!--                            <input style="width: 120px; display: inline-block" name="endDeposit" required=""-->
							<!--                                   placeholder="充值结束时间"-->
							<!--                                   value="" class="layui-input"/>-->
							<!--                            <p class="help-block">只支持整点, 如08:00-20:00,请直接输入 8 - 20</p>-->
						</label>
						<label class="layui-form-item margin-top-20 block relative label-required-prev">
							<span class="color-green margin-right-10" data-locale="tc.convey">抢单时间</span>

							<input type="text" class="layui-input" lay-verify="required" name="convey" id="convey" value=""
								   data-placeholder="tc.petConvey">
							<!--                            <input-->
							<!--                                style="width: 120px; display: inline-block"-->
							<!--                                name="startConvey" required="" placeholder="抢单开始时间" value="" class="layui-input"/>-->
							<!--                            - -->
							<!--                            <input style="width: 120px; display: inline-block" name="endConvey" required=""-->
							<!--                                   placeholder="抢单结束时间"-->
							<!--                                   value="" class="layui-input"/>-->
							<!--                            <p class="help-block">只支持整点, 如08:00-20:00,请直接输入 8 - 20</p>-->
						</label>
						<label class="layui-form-item margin-top-20 block relative label-required-prev"><span
									class="color-green margin-right-10" data-locale="tc.shopStatus">商城状态</span><input
									style="width: 120px; display: inline-block"
									name="shopStatus" required="" data-placeholder="tc.shopStatus" value="" class="layui-input"/>
							<p class="help-block" data-locale="tc.petShopStatus">商城状态: 1开启 0关闭</p>
						</label>
					</div>
					<div class="layui-form-item text-center margin-top-20">
						<button class="layui-btn" type="submit" lay-submit lay-filter="editSubmit" data-locale="tc.saveText">保存配置</button>
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
	layui.use(['form', 'slider', 'laydate'], function () {
		var form = layui.form,
				slider = layui.slider,
				laydate = layui.laydate,
				$ = layui.$;

		var i18n = new I18n();
		var $t = i18n.$t;
		window.i18n = i18n;
		window.$t = $t;

		laydate.render({
			elem: '#wthdraw'
			, range: true
			, type: 'time',
			lang: i18n.locale === 'cn' ? 'cn' : 'en',
		});

		laydate.render({
			elem: '#deposit'
			, range: true
			, type: 'time',
			lang: i18n.locale === 'cn' ? 'cn' : 'en',
		});

		laydate.render({
			elem: '#convey'
			, range: true
			, type: 'time',
			lang: i18n.locale === 'cn' ? 'cn' : 'en',
		});

		$(document).ready(function () {
			$.request({
				url: '/action/control/select',
				type: 'post',
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
					var fd = Object.assign({}, res.data);
					var withdraw = fd.startWithdraw ? fd.startWithdraw + ' - ' + fd.endWithdraw : '';
					var deposit = fd.startDeposit ? fd.startDeposit + ' - ' + fd.endDeposit : '';
					var convey = fd.startConvey ? fd.startConvey + ' - ' + fd.endConvey : '';
					console.log('withdraw', withdraw);
					fd.withdraw = withdraw;
					fd.deposit = deposit;
					fd.convey = convey;
					form.val('editForm', fd)
					// $('#test-slider-tips2').html('匹配范围：' + startRang + '% ~ ' + endRang + '%');
				},
			})
		})

		form.on('submit(editSubmit)', function (data) {
			data.field.startRang = $('#min').val();
			data.field.endRang = $('#max').val();
			var fd = Object.assign({}, data.field);
			var withdraw = $.getRangeTime(fd.withdraw);
			var startWithdraw = withdraw[0];
			var endWithdraw = withdraw[1];
			fd.startWithdraw = startWithdraw;
			fd.endWithdraw = endWithdraw;
			delete fd.withdraw;
			var deposit = $.getRangeTime(fd.deposit);
			var startDeposit = deposit[0];
			var endDeposit = deposit[1];
			fd.startDeposit = startDeposit;
			fd.endDeposit = endDeposit;
			delete fd.deposit;
			var convey = $.getRangeTime(fd.convey);
			var startConvey = convey[0];
			var endConvey = convey[1];
			fd.startConvey = startConvey;
			fd.endConvey = endConvey;
			delete fd.convey;
			console.log('fd', fd);
			$.request({
				url: '/action/control/save',
				type: 'post',
				data: fd,
				dataType: "json",
				showLoading: true,
				contentType: "application/json",
				success: function (res) {
					layer.msg($t('savedSuccessfully'), { icon: 1 })
					console.log('res', res)
				},
				fail: function () {
					layer.msg($t('operationFailed'), { icon: 2 })
					// alert('出错啦...')
				}
			})
			return false
		})
	})
</script>
</body>

</html>