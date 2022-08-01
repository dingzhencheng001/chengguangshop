layui.use(['table', 'upload', 'form'], function () {
	var table = layui.table,
		form = layui.form,
		upload = layui.upload

	var editIndex

	// 表格当前选择项
	var tableCurrentItem = {}

	var where = {
		// status: 0
	}

	//执行实例
	var uploadIndex
	var uploadInst = upload.render({
		elem: '#uploadPic', //绑定元素
		url: 'http://localhost:8080/action/file/upload', //上传接口
		acceptMime: 'image/*',
		before: function (obj) {
			//obj参数包含的信息，跟 choose回调完全一致，可参见上文。
			uploadIndex = layer.load(1) //上传loading
		},
		done: function (res) {
			layer.close(uploadIndex)
			var data = res.data || []
			var path = data[0].path
			var fileFullPath = $.getFileFullPath(path)
			$('#upload-img').attr('src', fileFullPath).show()
			layer.msg('上传成功', { icon: 1 })
			//上传完毕回调
		},
		error: function (err) {
			console.log('err msg', err.msg)
			$('#upload-img').attr('src', '').hide()
			layer.close(uploadIndex)
			layer.msg(err.msg, { icon: 2 })
			//请求异常回调
		}
	})

	var updateIndex
	var uploadInst_ = upload.render({
		elem: '#updatePic', //绑定元素
		url: 'http://localhost:8080/action/file/upload', //上传接口
		acceptMime: 'image/*',
		before: function (obj) {
			//obj参数包含的信息，跟 choose回调完全一致，可参见上文。
			updateIndex = layer.load(1) //上传loading
		},
		done: function (res) {
			layer.close(updateIndex)
			var data = res.data || []
			var path = data[0].path
			var fileFullPath = $.getFileFullPath(path)
			$('#update-img').attr('src', fileFullPath).show()
			layer.msg('上传成功', { icon: 1 })
			//上传完毕回调
		},
		error: function (err) {
			console.log('err msg', err.msg)
			$('#update-img').attr('src', '').hide()
			layer.close(updateIndex)
			layer.msg(err.msg, { icon: 2 })
			//请求异常回调
		}
	})

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
			// http://localhost:8080/action/notice/list: actions.apiUrl.update + id,
			update: 'http://localhost:8080/action/picture/update/',
			delete: 'http://localhost:8080/action/picture/delete/',
			create: 'http://localhost:8080/action/picture/create'
		},
		// 刷新表格数据
		onReloadData: function () {
			var searchData = form.val('searchForm')
			table.reloadData(levelListTableId, { where: Object.assign({}, where, searchData) })
		},
		onUpdateItem: function (id, fields, options) {
			console.log('fields', fields)
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
						layer.msg('删除图片成功', { icon: 1 })
						_options.success && _options.success(result, status, xhr)
					} else {
						layer.msg(result.msg, { icon: 2 })
						_options.fail && _options.fail(result, status, xhr)
					}
					_options.complete && _options.complete(status, xhr)
				},
				error: function (xhr, status, error) {
					layer.msg('删除图片失败', { icon: 2 })
					_options.error && _options.error(xhr, status, error)
				}
			})
		},
		onCreate: function (fields, options) {
			var _options = Object.assign({}, requestDefOptions, options)
			$.ajax({
				url: actions.apiUrl.create,
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify(fields),
				success: function (result, status, xhr) {
					if (result.code === 200) {
						actions.onReloadData()
						layer.msg('添加图片成功', { icon: 1 })
						_options.success && _options.success(result, status, xhr)
					} else {
						layer.msg(result.msg, { icon: 2 })
						_options.fail && _options.fail(result, status, xhr)
					}
					_options.complete && _options.complete(status, xhr)
				},
				error: function (xhr, status, error) {
					layer.msg('添加图片失败', { icon: 2 })
					_options.error && _options.error(xhr, status, error)
				}
			})
		}
	}

	//单元格工具事件
	table.on('tool(level)', function (obj) {
		// 注：test 是 table 原始标签的属性 lay-filter="对应的值"
		var data = obj.data //获得当前行数据
		var layEvent = obj.event //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		var tr = obj.tr //获得当前行 tr 的 DOM 对象（如果有的话）
		// 设置当前选择项
		tableCurrentItem = Object.assign({}, data)
		console.log('data', data)
		// 修改邀请码
		if (layEvent === 'edit') {
			// 编辑菜单
			editIndex = layer.open({
				type: 1,
				title: '编辑菜单',
				area: '800px',
				content: $('#editId'),
				success: function () {
					form.val('editForm', data)
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

	var levelListTableId = 'levelListTableId'
	//第一个实例
	table.render({
		elem: '#level',
		height: 312,
		url: 'http://localhost:8080/action/picture/list', //数据接口
		page: true, //开启分页
		cellMinWidth: 100, //全局定义常规单元格的最小宽度
		where: where,
		loading: true,
		request: {
			pageName: 'pageNum', //页码的参数名称，默认：page
			limitName: 'pageSize' //每页数据量的参数名，默认：limit
		},
		cols: [
			[
				//表头
				{ field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left' },
				{ field: 'picturePath', title: '图片', templet: '#picturePath', minWidth: 160 },
				{ field: 'showType', title: '展示类型', templet: '#showType', width: 120 },
				{ field: 'title', title: '标题', width: 120 },
				{ field: 'content', title: '描述', minWidth: 160 },
				{ field: 'updateTime', title: '发表时间', templet: '#updateTime', minWidth: 160 },
				{ field: 'operation', title: '操作', templet: '#operation', fixed: 'right', width: 336 }
			]
		],
		parseData: parseData,
		id: levelListTableId // 容器唯一IDs
	})

	// 请求回调选项
	var requestDefOptions = {
		// 请求成功，并且code等于200
		success: function (result, status, xhr) {},
		// 请求成功，并且code不等于200
		fail: function (result, status, xhr) {},
		// 请求失败
		error: function (xhr, status, error) {},
		// 请求完成时运行的函数（在请求成功或失败之后均调用，即在 success 和 error 函数之后）。
		complete: function (xhr, status) {}
	}

	// 编辑-提交
	form.on('submit(editSubmit)', function (data) {
		actions.onUpdateItem(tableCurrentItem.id, data.field, {
			success: function () {
				console.log('success')
				layer.close(editIndex)
				$('#editId').hide()
			}
		})
		return false
	})

	// 编辑-取消
	$('#editCancel').click(function () {
		layer.close(editIndex)
	})

	var createIndex
	$('#createBtn').click(function () {
		createIndex = layer.open({
			type: 1,
			title: '新建会员等级',
			area: '800px',
			content: $('#createId'),
			success: function () {
				$('#createId').show()
			},
			cancel: function () {
				$('#createId').hide()
			}
		})
	})

	// 新建-取消
	$('#createCancel').click(function () {
		layer.close(createIndex)
		form.val('addForm', {
			content: ''
		})
	})

	// 新建-提交
	form.on('submit(createSubmit)', function (data) {
		data.field.picturePath = $('#upload-img').attr('src')
		delete data.field.file
		console.log(data.field)
		actions.onCreate(data.field, {
			success: function () {
				layer.close(createIndex)
				form.val('addForm', {
					content: ''
				})
			}
		})
	})
})
