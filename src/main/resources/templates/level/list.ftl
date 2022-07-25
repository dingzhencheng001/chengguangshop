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
		<form class="layui-form layui-card" lay-filter="editForm">
			<div class="layui-card-body">
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">名称</label>
					<div class="layui-input-block">
						<input name="membersName" required placeholder="请输入名称" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">会员价格</label>
					<div class="layui-input-block">
						<input name="memberPrice" required placeholder="请输入会员价格" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">佣金比例</label>
					<div class="layui-input-block">
						<input name="commission" type="number" min="0" required placeholder="请输入佣金比例" value=""
							class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">最小余额</label>
					<div class="layui-input-block">
						<input name="numMin" type="number" min="0" required placeholder="请输入最小余额" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">接单次数</label>
					<div class="layui-input-block">
						<input name="orderNum" required placeholder="请输入接单次数" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">提现次数</label>
					<div class="layui-input-block">
						<input name="withdrawalTimes" required placeholder="请输入提现次数" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">提现最小金额</label>
					<div class="layui-input-block">
						<input name="withdrawalMin" required placeholder="请输入提现最小金额" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">提现最大金额</label>
					<div class="layui-input-block">
						<input name="withdrawalMax" required placeholder="请输入提现最大金额" value="" class="layui-input" />
					</div>
				</div>
				<div class="hr-line-dashed"></div>
				<div class="layui-form-item text-center">
					<button class="layui-btn" lay-submit lay-filter="createSubmit">提交</button>
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
						<input name="membersName" required placeholder="请输入名称" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">会员价格</label>
					<div class="layui-input-block">
						<input name="memberPrice" required placeholder="请输入会员价格" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">佣金比例</label>
					<div class="layui-input-block">
						<input name="commission" type="number" min="0" required placeholder="请输入佣金比例" value=""
							class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">最小余额</label>
					<div class="layui-input-block">
						<input name="numMin" type="number" min="0" required placeholder="请输入最小余额" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">接单次数</label>
					<div class="layui-input-block">
						<input name="orderNum" required placeholder="请输入接单次数" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">提现次数</label>
					<div class="layui-input-block">
						<input name="withdrawalTimes" required placeholder="请输入提现次数" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">提现最小金额</label>
					<div class="layui-input-block">
						<input name="withdrawalMin" required placeholder="请输入提现最小金额" value="" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next">提现最大金额</label>
					<div class="layui-input-block">
						<input name="withdrawalMax" required placeholder="请输入提现最大金额" value="" class="layui-input" />
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
			<span style="display: inline-block">
				<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			</span>
			<span style="display: inline-block">
				<a class="layui-btn layui-btn-xs" lay-event="delete">删除</a>
			</span>
		</script>

	<!--注册信息-->
	<script type="text/html" id="register">
			<div>
				<p>{{ layui.util.toDateString(d.registerTime, 'yyyy-MM-dd')}}</p>
				<p>{{ d.registerCountry}}</p>
			</div>
		</script>

	<script>
		layui.use(['table', 'form', 'util', 'element', 'laydate'], function () {
			var table = layui.table, $ = layui.$, form = layui.form, util = layui.util;

			var editIndex

			// 表格当前选择项
			var tableCurrentItem = {};

			var where = {
				"status": 0,
			};

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
				apiUrl: {
					update: '/levelaction/update/',
					delete: '/levelaction/delete/',
					create: '/levelaction/create'
				},
				// 刷新表格数据
				onReloadData: function () {
					var searchData = form.val('searchForm')
					console.log('searchData', searchData)
					table.reloadData(levelListTableId, { where: Object.assign({}, where, searchData) })
				},
				onUpdateItem: function (id, fields, options) {
					var _options = Object.assign({}, requestDefOptions, options)
					$.ajax({
						url: actions.apiUrl.update + id,
						type: 'post',
						contentType: 'application/json',
						data: JSON.stringify(fields),
						success: function (result, status, xhr) {
							if (result.code === 200) {
								actions.onReloadData()
								layer.msg('操作成功', { icon: 1 })
								_options.success && _options.success(result, status, xhr)
							} else {
								layer.msg(result.msg, { icon: 2 })
								_options.fail && _options.fail(result, status, xhr)
							}
							_options.complete && _options.complete(status, xhr)
						},
						error: function (xhr, status, error) {
							layer.msg('操作失败', { icon: 2 })
							_options.error && _options.error(xhr, status, error)
						}
					})
				},
				onDelete: function (id, options) {
					var _options = Object.assign({}, requestDefOptions, options)
					$.ajax({
						url: actions.apiUrl.delete + id,
						type: 'get',
						success: function (result, status, xhr) {
							if (result.code === 200) {
								actions.onReloadData()
								layer.msg('删除会员等级成功', { icon: 1 })
								_options.success && _options.success(result, status, xhr)
							} else {
								layer.msg(result.msg, { icon: 2 })
								_options.fail && _options.fail(result, status, xhr)
							}
							_options.complete && _options.complete(status, xhr)
						},
						error: function (xhr, status, error) {
							layer.msg('删除会员等级失败', { icon: 2 })
							_options.error && _options.error(xhr, status, error)
						}
					})
				},
				onCreate: function (fields, options) {
					var _options = Object.assign({}, requestDefOptions, options);
					$.ajax({
						url: actions.apiUrl.create,
						type: 'post',
						contentType: 'application/json',
						data: JSON.stringify(fields),
						success: function (result, status, xhr) {
							if (result.code === 200) {
								actions.onReloadData();
								layer.msg('创建会员成功', { icon: 1 });
								_options.success && _options.success(result, status, xhr);
							} else {
								layer.msg(result.msg, { icon: 2 });
								_options.fail && _options.fail(result, status, xhr);
							}
							_options.complete && _options.complete(status, xhr);
						},
						error: function (xhr, status, error) {
							layer.msg('创建会员失败', { icon: 2 });
							_options.error && _options.error(xhr, status, error);
						}
					});
				},
			}

			//单元格工具事件
			table.on('tool(level)', function (obj) {
				// 注：test 是 table 原始标签的属性 lay-filter="对应的值"
				var data = obj.data //获得当前行数据
				var layEvent = obj.event //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				var tr = obj.tr //获得当前行 tr 的 DOM 对象（如果有的话）

				// 设置当前选择项
				tableCurrentItem = Object.assign({}, data)
				// 修改邀请码
				if (layEvent === 'edit') {
					// 编辑菜单
					editIndex = layer.open({
						type: 1,
						title: '编辑菜单',
						area: '800px',
						content: $('#editId'),
						success: function () {
							form.val('editForm', data);
							$('#editId').show()
						},
						cancel: function () {
							$('#editId').hide()
						}
					})
				} else if (layEvent === 'delete') {
					// 删除
					layer.confirm('确定要删除吗?', { title: '操作确认' }, function (index) {
						actions.onDelete(data.id, {
							success: function () {
								layer.close(index)
							}
						})
					})
				}
			})

			var levelListTableId = 'levelListTableId';
			//第一个实例
			table.render({
				elem: '#level',
				height: 312,
				url: '/levelaction/list', //数据接口
				// url: 'http://localhost:8080/levelaction/list?pageNum=1&pageSize=20', //数据接口
				page: true, //开启分页
				cellMinWidth: 100, //全局定义常规单元格的最小宽度
				where: where,
				loading: true,
				request: {
					pageName: 'pageNum', //页码的参数名称，默认：page
					limitName: 'pageSize', //每页数据量的参数名，默认：limit
				},
				cols: [
					[
						//表头
						{ field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left' },
						{ field: 'membersName', title: '名称', width: 80 },
						// { field: 'pic', title: '图标', width: 80, sort: true },
						{ field: 'memberPrice', title: '会员价格', width: 80 },
						{ field: 'commission', title: '佣金比例', width: 177 },
						{ field: 'numMin', title: '最小余额', width: 80 },
						{ field: 'orderNum', title: '接单次数', width: 80 },
						{ field: 'withdrawalTimes', title: '提现次数', width: 80 },
						{ field: 'withdrawalMin', title: '提现最小金额', width: 80 },
						{ field: 'withdrawalMax', title: '提现最大金额', width: 80 },
						{ field: 'registerTime', title: '注册时间', templet: '#register', minWidth: 160 },
						{ field: 'operation', title: '操作', templet: '#operation', fixed: 'right', width: 336 }
					]
				],
				parseData: parseData,
				id: levelListTableId, // 容器唯一IDs
			})

			// 请求回调选项
			var requestDefOptions = {
				// 请求成功，并且code等于200
				success: function (result, status, xhr) {

				},
				// 请求成功，并且code不等于200
				fail: function (result, status, xhr) {

				},
				// 请求失败
				error: function (xhr, status, error) {

				},
				// 请求完成时运行的函数（在请求成功或失败之后均调用，即在 success 和 error 函数之后）。
				complete: function (xhr, status) {

				}
			};

			// 编辑-提交
			form.on('submit(editSubmit)', function (data) {
				actions.onUpdateItem(tableCurrentItem.id, data.field, {
					success: function () {
						console.log('success');
						layer.close(editIndex);
						$('#editId').hide();
					}
				})
				return false;
			});

			// 编辑-取消
			$('#editCancel').click(function () {
				layer.close(editIndex)
			})

			var createIndex;
			$('#createBtn').click(function () {
				createIndex = layer.open({
					type: 1,
					title: '新建会员等级',
					area: '800px',
					content: $('#createId'),
					success: function () {
						$('#createId').show();
					},
					cancel: function () {
						$('#createId').hide();
					}
				});
			})

			// 新建-取消
			$('#createCancel').click(function () {
				layer.close(createIndex);
			});

			// 新建-提交
			form.on('submit(createSubmit)', function (data) {
				actions.onCreate(data.field, {
					success: function () {
						layer.close(createIndex);
					}
				});
				// return false;
			});

		})
	</script>
</body>

</html>