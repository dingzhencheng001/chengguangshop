
layui.use(['table', 'form', 'util', 'element', 'laydate', 'layedit'], function () {
	var table = layui.table, $ = layui.$, form = layui.form, util = layui.util; layedit = layui.layedit;


	var i18n = new I18n();
	var $t = i18n.$t;
	window.i18n = i18n;
	window.$t = $t;

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
	var editeditor = layedit.build('editTextarea');
	var addeditor = layedit.build('addTextarea');

	var editIndex

	// 表格当前选择项
	var tableCurrentItem = {};

	var where = {
		"status": 0,
	};

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
		onUpdateItem: function (id, fields, cb) {
			$.request({
				url: actions.apiUrl.update + id,
				type: 'post',
				contentType: 'application/json',
				data: fields,
				showLoading: true,
				success: function (result, status, xhr) {
					actions.onReloadData()
					layer.msg($t('operationSucceeded'), { icon: 1 })
					cb && cb(result, status, xhr)
				}
			})
		},
		onDelete: function (id, cb) {
			$.request({
				url: actions.apiUrl.delete + id,
				type: 'get',
				showLoading: true,
				success: function (result) {
					actions.onReloadData()
					layer.msg($('deleteSucceeded'), { icon: 1 })
					cb && cb(result)
				}
			})
		},
		onCreate: function (fields, cb) {
			$.request({
				url: actions.apiUrl.create,
				type: 'post',
				contentType: 'application/json',
				data: fields,
				showLoading: true,
				success: function (result, status, xhr) {
					actions.onReloadData();
					layer.msg($('createSucceeded'), { icon: 1 });
					cb && cb(result, status, xhr);
				},
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
				title: $t('edit'),
				area: '800px',
				content: $('#editId'),
				success: function () {
					form.val('editForm', data);
					layedit.setContent(editeditor, data.noticeContent, false);
					$('#editId').show()
				},
				cancel: function () {
					$('#editId').hide()
				}
			})
		} else if (layEvent === 'delete') {
			// 删除
			layer.confirm($t('deleteConfirmation'), {
				title: $t('operationConfirmation'),
				btn: [$t('confirm'), $t('cancel')],
			}, function (index) {
				actions.onDelete(data.noticeId, function () {
					layer.close(index)
				})
			})
		}
	})

	var levelListTableId = 'levelListTableId';
	//第一个实例
	table.render(Object.assign({}, $.tableRenderConfing, {
		elem: '#level',
		// height: 312,
		url: '/action/notice/list', //数据接口
		// url: 'http://localhost:8080/action/notice/list', //数据接口
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
				{ field: 'noticeTitle', title: $t('notice.noticeTitle') },
				{ field: 'createTime', title: $t('notice.createTime'), templet: '#createTime' },
				{ field: 'operation', title: $t('operation'), templet: '#operation', fixed: 'right', width: 120 }
			]
		],
		id: levelListTableId, // 容器唯一IDs
	}));

	// 编辑-提交
	form.on('submit(editSubmit)', function (data) {
		data.field.noticeContent = layedit.getContent(editeditor);
		actions.onUpdateItem(tableCurrentItem.noticeId, data.field, function () {
			console.log('success');
			layer.close(editIndex);
			$('#editId').hide();
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
			title: $t('notice.createTitle'),
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
		data.field.noticeContent = layedit.getContent(addeditor);
		actions.onCreate(data.field, function () {
			layer.close(createIndex);
		});
	});

})