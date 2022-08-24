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
			<legend data-locale="conditionalSearch">条件搜索</legend>
			<form class="layui-form layui-form-pane form-search" lay-filter="searchForm" action="">
				<div class="layui-form-item layui-inline">
					<label class="layui-form-label" data-locale="title">标题</label>
					<div class="layui-input-inline">
						<input name="title" value="" data-placeholder="log.petTitle" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item layui-inline">
					<label class="layui-form-label" data-locale="log.operateContent">内容关键词</label>
					<div class="layui-input-inline">
						<input name="operateContent" value="" data-placeholder="log.petOperateContent" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item layui-inline">
					<label class="layui-form-label" data-locale="log.time">查询时间</label>
					<div class="layui-input-inline">
						<input type="text" name="time" class="layui-input" id="registrationTime" data-placeholder="log.petTime">
					</div>
				</div>
				<div class="layui-form-item layui-inline">
					<button type="submit" class="layui-btn layui-btn-danger" lay-submit lay-filter="search"><i
								class="layui-icon"></i>
						<span data-locale="search">搜 索</span>
					</button>
				</div>
				<div class="layui-form-item layui-inline">
					<button id="reset" type="button" class="layui-btn layui-btn-primary layui-btn-lg ">
						<i class="layui-icon">&#xe669;</i>
						<span data-locale="reset">重置</span>
					</button>
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

<script>
	layui.use(['table', 'form', 'util', 'laydate'], function () {
		var table = layui.table,
				$ = layui.$,
				form = layui.form,
				util = layui.util,
				laydate = layui.laydate

		var i18n = new I18n();
		var $t = i18n.$t;
		window.i18n = i18n;
		window.$t = $t;

		// 表格当前选择项
		var tableCurrentItem = {}

		var where = {
			pageNum: 1,
			pageSize: 20,
			selectBeginTime: '',
			selectEndTime: '',
			title: '',
			operateContent: ''
		}

		laydate.render({
			elem: '#registrationTime',
			range: true, //或 range: '~' 来自定义分割字符
			lang: i18n.locale === 'cn' ? 'cn' : 'en',
		})

		var actions = {
			// 刷新表格数据
			onReloadData: function () {
				table.reloadData(levelListTableId, { where: Object.assign({}, where, onGetSearchParams()) })
			}
		}

		var levelListTableId = 'levelListTableId'
		//第一个实例
		table.render(Object.assign({}, $.tableRenderConfing, {
			elem: '#level',
			url: '/action/operate/list', //数据接口
			// url: 'http://localhost:8080/action/operate/list', //数据接口
			page: true, //开启分页
			cellMinWidth: 100, //全局定义常规单元格的最小宽度
			method: 'post',
			where: where,
			contentType: 'application/json',
			cols: [
				[
					{ field: 'id', title: 'ID', width: 60, sort: true, fixed: 'left' },
					{ field: 'title', title: $t('title'), minWidth: 200 },
					{ field: 'operateContent', title: $t('log.content'), minWidth: 160 },
					{ field: 'createBy', title: $t('log.createBy'), minWidth: 100 },
					{ field: 'createTime', title: $t('log.createTime'), templet: '#createTime', minWidth: 120 },
					{ field: 'remark', title: $t('log.remark'), minWidth: 250 }
				]
			],
			id: levelListTableId // 容器唯一IDs
		}));

		// 搜索
		form.on('submit(search)', function () {
			actions.onReloadData()
			return false
		})

		$('#reset').click(function () {
			form.val('searchForm', {
				time: '',
				selectBeginTime: '',
				selectEndTime: '',
				title: '',
				operateContent: ''
			})
			actions.onReloadData()
			return false
		})

		// 获取搜索参数
		var onGetSearchParams = function () {
			var searchData = form.val('searchForm')
			var times = $.getRangeTime(searchData.time)
			searchData.memberStatus = Number(searchData.memberStatus) || null
			searchData.selectBeginTime = times[0]
			searchData.selectEndTime = times[1]
			delete searchData.time
			return searchData
		}
	})
</script>
</body>

</html>
