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
		<a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-xs" style="background:red;" lay-event="delete">删除</a>
	</script>

	<!--注册信息-->
	<script type="text/html" id="createTime">
				<p>{{ layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</p>
		</script>
	
	<script type="text/html" id="noticeType">
				<p>{{ d.noticeType==1?'首页弹窗':(d.noticeType==2?'公告':'其他') }}</p>
		</script>

	<script>
		layui.use(['table', 'form', 'util', 'element', 'laydate', 'layedit'], function () {
			var table = layui.table, $ = layui.$, form = layui.form, util = layui.util; layedit = layui.layedit;


			layedit.set({
				//暴露layupload参数设置接口 --详细查看layupload参数说明
				uploadImage: {
					url: '/Attachment/LayUploadFile',
					accept: 'image',
					acceptMime: 'image/*',
					exts: 'jpg|png|gif|bmp|jpeg',
					size: '10240'
				}
				, uploadVideo: {
					url: '/Attachment/LayUploadFile',
					accept: 'video',
					acceptMime: 'video/*',
					exts: 'mp4|flv|avi|rm|rmvb',
					size: '20480'
				}
				//右键删除图片/视频时的回调参数，post到后台删除服务器文件等操作，
				//传递参数：
				//图片： imgpath --图片路径
				//视频： filepath --视频路径 imgpath --封面路径
				, calldel: {
					url: '/Attachment/DeleteFile'
				}
				//开发者模式 --默认为false
				, devmode: true
				//插入代码设置
				, codeConfig: {
					hide: true,  //是否显示编码语言选择框
					default: 'javascript' //hide为true时的默认语言格式
				}
				, tool: [
					'html', 'code', 'strong', 'italic', 'underline', 'del', 'addhr', '|', 'fontFomatt', 'colorpicker', 'face'
					, '|', 'left', 'center', 'right', '|', 'link', 'unlink', 'images', 'image_alt', 'video', 'anchors'
					, '|', 'fullScreen'
				]
				, height: '90%'
			});

			var editeditor
			var addeditor

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
					// /action/notice/list: actions.apiUrl.update + id,
					update: '/action/notice/update/',
					delete: '/action/notice/delete/',
					create: '/action/notice/create'
				},
				// 刷新表格数据
				onReloadData: function () {
					var searchData = form.val('searchForm')
					console.log('searchData', searchData)
					table.reloadData(levelListTableId, { where: Object.assign({}, where, searchData) })
				},
				onUpdateItem: function (id, fields, options) {
					console.log('fields', fields);
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
								layer.msg('删除公告成功', { icon: 1 })
								_options.success && _options.success(result, status, xhr)
							} else {
								layer.msg(result.msg, { icon: 2 })
								_options.fail && _options.fail(result, status, xhr)
							}
							_options.complete && _options.complete(status, xhr)
						},
						error: function (xhr, status, error) {
							layer.msg('删除公告失败', { icon: 2 })
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
								layer.msg('添加公告成功', { icon: 1 });
								_options.success && _options.success(result, status, xhr);
							} else {
								layer.msg(result.msg, { icon: 2 });
								_options.fail && _options.fail(result, status, xhr);
							}
							_options.complete && _options.complete(status, xhr);
						},
						error: function (xhr, status, error) {
							layer.msg('添加公告失败', { icon: 2 });
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
				console.log('data', data);
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
							editeditor = layedit.build('editTextarea');
							layedit.setContent(editeditor, data.noticeContent, false);
							$('#editId').show()
						},
						cancel: function () {
							$('#editId').hide()
						}
					})
				} else if (layEvent === 'delete') {
					// 删除
					layer.confirm('确定要删除吗?', { title: '操作确认' }, function (index) {
						actions.onDelete(data.noticeId, {
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
				height: 400,
				url: '/action/notice/list', //数据接口
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
						{ field: 'noticeId', title: 'ID', width: 80, sort: true, fixed: 'left' },
						{ field: 'noticeType', title: '公告类型', templet: '#noticeType',width: 100 },
						{ field: 'noticeTitle', title: '标题', width: 200 },
						{ field: 'createTime', title: '发表时间', templet: '#createTime', minWidth: 160 },
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
				editeditor = layedit.build('editTextarea')
				data.field.noticeContent = layedit.getContent(editeditor);
				actions.onUpdateItem(tableCurrentItem.noticeId, data.field, {
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
					title: '添加公告',
					area: '800px',
					content: $('#createId'),
					success: function () {
						$('#createId').show();
						addeditor = layedit.build('addTextarea');
					},
					cancel: function () {
						$('#createId').hide();
					}
				});
			})

			// 新建-取消
			$('#createCancel').click(function () {
				layer.close(createIndex);
				form.val('addForm', {
					'noticeTitle': ''
				});
			});

			// 新建-提交
			form.on('submit(createSubmit)', function (data) {
				data.field.noticeContent = layedit.getContent(addeditor);
				actions.onCreate(data.field, {
					success: function () {
						layer.close(createIndex);
						form.val('addForm', {
							'noticeTitle': ''
						});
					}
				});
				return false;
			});

		})
	</script>
</body>

</html>