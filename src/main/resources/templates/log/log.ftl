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

	<script>
		layui.use(['table', 'form', 'util', 'laydate'], function () {
			var table = layui.table, $ = layui.$, form = layui.form, util = layui.util, laydate = layui.laydate;

			// 表格当前选择项
			var tableCurrentItem = {};

			var where = {
				"pageNum": 1,
				"pageSize": 20,
				"selectBeginTime": "",
				"selectEndTime": "",
				"title": "",
				"operateContent": "",
			};

			laydate.render({
				elem: '#registrationTime',
				range: true //或 range: '~' 来自定义分割字符
			});

			var parseData = function (res) {
				var msg
				var code
				var count
				var data
				if (res.code === 200) {
					code = 0
					msg = res.message
					count = res.data.total
					data = res.data.list
				} else {
					code = res.code
					msg = res.msg
					count = 0
					data = []
				}
				return {
					code: code, //解析接口状态
					msg: msg, //解析提示文本
					count: count, //解析数据长度
					data: data //解析数据列表
				}
			}

			var actions = {
				// 刷新表格数据
				onReloadData: function () {
					table.reloadData(levelListTableId, { where: Object.assign({}, where, onGetSearchParams()) })
				},
			}

			var levelListTableId = 'levelListTableId';
			//第一个实例
			table.render({
				elem: '#level',
				height: 312,
				url: '/action/operate/list', //数据接口
				page: true, //开启分页
				cellMinWidth: 100, //全局定义常规单元格的最小宽度
				method: 'post',
				where: where,
				"contentType": "application/json",
				loading: true,
				request: {
					pageName: 'pageNum', //页码的参数名称，默认：page
					limitName: 'pageSize', //每页数据量的参数名，默认：limit
				},
				cols: [
					[
						//表头
						{ field: 'id', title: 'ID', width: 60, sort: true, fixed: 'left' },
						{ field: 'title', title: '标题', width: 100 },
						{ field: 'operateContent', title: '内容', minWidth: 160 },
						{ field: 'createBy', title: '创建人', width: 100 },
						{ field: 'createTime', title: '创建时间', templet: '#createTime', width: 80 },
						{ field: 'remark', title: '备注', width: 250 },
					]
				],
				parseData: parseData,
				id: levelListTableId, // 容器唯一IDs
			})

			// 搜索
			form.on('submit(search)', function () {
				actions.onReloadData();
				return false;
			});

			$('#reset').click(function () {
				form.val('searchForm', {
					time: '',
					selectBeginTime: "",
					selectEndTime: "",
					title: "",
					operateContent: "",
				});
				actions.onReloadData();
				return false;
			})

			// 获取搜索参数
			var onGetSearchParams = function () {
				var searchData = form.val('searchForm');
				var times = $.getRangeTime(searchData.time);
				searchData.memberStatus = Number(searchData.memberStatus) || null;
				searchData.selectBeginTime = times[0];
				searchData.selectEndTime = times[1];
				delete searchData.time;
				return searchData;
			}
		})


	</script>
</body>

</html>