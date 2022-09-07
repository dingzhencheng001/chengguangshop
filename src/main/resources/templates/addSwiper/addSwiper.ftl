<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>图片管理</title>
    <#include "../resource.ftl"/>
</head>

<body>
<div class="layui-fluid">
	<div id="createId" style="display: none;height:320px">
		<form class="layui-form layui-card" lay-filter="addForm">
			<div class="layui-card-body">

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.title">图片标题</label>
					<div class="layui-input-block">
						<input name="title" lay-filter="content" required data-placeholder="addSwiper.petTitle" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label" data-locale="addSwiper.selectPictureType">选择图片类型</label>
					<div class="layui-input-block">
						<select class="pictureTypeSelect1" name="pictureType" lay-filter="pictureType" lay-verify="required">
							<option value=""></option>
							<!--							<option value="1" data-locale="addSwiper.pictureType1">首页展示</option>-->
							<!--							<option value="2" data-locale="addSwiper.pictureType2">底部展示</option>-->
							<!--							<option value="3" data-locale="addSwiper.pictureType3">LOGO</option>-->
							<!--							<option value="4" data-locale="addSwiper.pictureType4">其他</option>-->
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.content">图片描述</label>
					<div class="layui-input-block">
						<input name="content" lay-filter="content" required data-placeholder="addSwiper.petContent" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.picture">图片</label>
					<div>
						<button type="button" class="layui-btn" id="uploadPic">
							<i class="layui-icon">&#xe67c;</i>
							<span data-locale="uploadPictures">上传图片</span>
						</button>
						<img name="picturePath"  id="upload-img" style="display: none; width: 150px;margin-left: 12px;" src="">
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
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.title">图片标题</label>
					<div class="layui-input-block">
						<input name="title" lay-filter="content" required data-placeholder="addSwiper.petTitle" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.content">图片描述</label>
					<div class="layui-input-block">
						<input name="content" required data-placeholder="addSwiper.petContent" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label" data-locale="addSwiper.selectPictureType">选择图片类型</label>
					<div class="layui-input-block">
						<select class="pictureTypeSelect2" name="pictureType" lay-verify="required">
							<!--							<option value=""></option>-->
							<!--							<option value="1" data-locale="addSwiper.pictureType1">首页展示</option>-->
							<!--							<option value="2" data-locale="addSwiper.pictureType2">底部展示</option>-->
							<!--							<option value="3" data-locale="addSwiper.pictureType3">LOGO</option>-->
							<!--							<option value="4" data-locale="addSwiper.pictureType4">其他</option>-->
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.picture">图片</label>
					<div>
						<button type="button" class="layui-btn" id="updatePic">
							<i class="layui-icon">&#xe67c;</i>
							<span data-locale="uploadPictures">上传图片</span>
						</button>
						<img name="picturePath" id="update-img" style="display: none; width: 150px;margin-left: 12px;" src="">
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

	<!--	纯文本-->
	<div id="createTextId" style="display: none;height:380px">
		<form class="layui-form layui-card" lay-filter="addTextForm">
			<div class="layui-card-body">

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.textTitle">文本标题</label>
					<div class="layui-input-block">
						<input name="title" lay-filter="title" required data-placeholder="addSwiper.petTextTitle" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.addTextarea">文本描述</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea" data-placeholder="addSwiper.petAddTextarea" name="content" ></textarea>
					</div>
				</div>

				<div class="hr-line-dashed"></div>
				<div class="layui-form-item text-center">
					<button type="button" class="layui-btn" lay-submit lay-filter="createTextSubmit" data-locale="submit">提交</button>
					<button type="button" class="layui-btn layui-btn-danger" id="createTextCancel" data-locale="cancel">取消</button>
				</div>
			</div>
		</form>
	</div>

	<div id="editTextId" style="display: none;height:380px">
		<form class="layui-form layui-card" lay-filter="editTextForm">
			<div class="layui-card-body">

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.textTitle">文本标题</label>
					<div class="layui-input-block">
						<input name="title" lay-filter="title" required data-placeholder="addSwiper.petTextTitle" value="" lay-verify="required" class="layui-input" />
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label label-required label-required-next" data-locale="addSwiper.addTextarea">文本描述</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea" data-placeholder="addSwiper.petAddTextarea" name="content" ></textarea>
					</div>
				</div>

				<div class="hr-line-dashed"></div>
				<div class="layui-form-item text-center">
					<button type="button" class="layui-btn" lay-submit lay-filter="editTextSubmit" data-locale="submit">提交</button>
					<button type="button" class="layui-btn layui-btn-danger" id="editTextCancel" data-locale="cancel">取消</button>
				</div>
			</div>
		</form>
	</div>



	<div class="layui-btn-container" style="margin-top: 20px;">
		<button class="layui-btn" id="createBtn" data-locale="addSwiper.addPicture">添加图片</button>
		<button class="layui-btn" id="createTextBtn" data-locale="addSwiper.addText">添加纯文本</button>
	</div>

	<table id="level" lay-filter="level" style="margin-top: 5px"></table>

	<script type="text/html" id="operation">
		<span>
		{{#  if (d.showType ==1){ }}
			<a class="layui-btn layui-btn-xs" style="background:green;" lay-event="edit">{{$t('edit')}}</a>
			<a class="layui-btn layui-btn-xs" style="background:red;" lay-event="delete">{{$t('delete')}}</a>
			<a class="layui-btn layui-btn-xs" style="background:#00375F;" lay-event="forbidden">{{$t('disable')}}</a>
		{{#  }else{ }}
			<a class="layui-btn layui-btn-xs" style="background:green;" lay-event="forbidden">{{$t('enable')}}</a>
		{{#  } }}
		</span>
	</script>

	<!--注册信息-->
	<script type="text/html" id="picturePath">
		<div>
			<img src='{{d.picturePath}}' alt="">
		</div>
	</script>

</div>



<script>
	layui.use(['table', 'upload', 'form', 'layedit'], function () {
		var table = layui.table,
				form = layui.form,
				upload = layui.upload,
				layedit = layui.layedit;

		var i18n = new I18n();
		var $t = i18n.$t;
		window.i18n = i18n;
		window.$t = $t;

		var pictureTypeOptions = [
			{
				name: '',
				value: '',
			},
			{
				name: $t('addSwiper.pictureType1'),
				value: 1,
			},
			{
				name: $t('addSwiper.pictureType2'),
				value: 2,
			},
			{
				name: $t('addSwiper.pictureType3'),
				value: 3,
			},
		];
		$.renderSelect(document.querySelector('.pictureTypeSelect1'), pictureTypeOptions);
		$.renderSelect(document.querySelector('.pictureTypeSelect2'), pictureTypeOptions);
		form.render('select');

		layedit.set({
			//暴露layupload参数设置接口 --详细查看layupload参数说明
			uploadImage: {
				url: '/Attachment/LayUploadFile',
				accept: 'image',
				acceptMime: 'image/*',
				exts: 'jpg|png|gif|bmp|jpeg',
				size: '10240'
			},
			uploadVideo: {
				url: '/Attachment/LayUploadFile',
				accept: 'video',
				acceptMime: 'video/*',
				exts: 'mp4|flv|avi|rm|rmvb',
				size: '20480'
			},
			//右键删除图片/视频时的回调参数，post到后台删除服务器文件等操作，
			//传递参数：
			//图片： imgpath --图片路径
			//视频： filepath --视频路径 imgpath --封面路径
			calldel: {
				url: '/Attachment/DeleteFile'
			},
			tool: [
				'strong',
				'italic',
				'underline',
				'del',
				'addhr',
				'|',
				'fontFomatt',
				'colorpicker',
				'face',
				'|',
				'left',
				'center',
				'right',
				'|',
				'link',
				'unlink',
				'images',
				'image_alt',
				'video',
				'anchors',
				'|',
				'fullScreen'
			],
			height: '90%'
		})

		var editeditor
		var addeditor

		var createTextIndex

		var editIndex

		var type

		// 表格当前选择项
		var tableCurrentItem = {}

		var where = {
			// status: 0
		}

		//执行实例
		var uploadIndex
		var uploadInst = upload.render({
			elem: '#uploadPic', //绑定元素
			url: '/action/file/upload', //上传接口
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
				layer.msg($t('uploadSucceeded'), { icon: 1 })
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
			url: '/action/file/upload', //上传接口
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
				layer.msg($t('uploadSucceeded'), { icon: 1 })
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

		var actions = {
			apiUrl: {
				// /action/notice/list: actions.apiUrl.update + id,
				update: '/action/picture/update/',
				delete: '/action/picture/delete/',
				create: '/action/picture/create'
			},
			// 刷新表格数据
			onReloadData: function () {
				var searchData = form.val('searchForm')
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
						layer.msg($t('operationSucceeded'), { icon: 1 });
						cb && cb();
					},
					fail: function () {
						layer.msg($t('operationFailed'), { icon: 2 })
					}
				})
			},
			onDelete: function (id, cb) {
				$.request({
					url: actions.apiUrl.delete + id,
					type: 'get',
					showLoading: true,
					success: function (result, status, xhr) {
						actions.onReloadData()
						layer.msg($t('deleteSucceeded'), { icon: 1 });
						cb && cb();
					},
					fail: function (xhr, status, error) {
						layer.msg($t('deleteFailed'), { icon: 2 })
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
						actions.onReloadData()
						if (fields.pictureType == 5) {
							layer.msg($t('addSwiper.addTextSuccess'), { icon: 1 })
						} else {
							layer.msg($t('addSwiper.addPictureSuccess'), { icon: 1 })
						}
						cb && cb();
					},
					fail: function (xhr, status, error) {
						if (fields.pictureType == 5) {
							layer.msg($t('addSwiper.addTextFail'), { icon: 2 })
						} else {
							layer.msg($t('addSwiper.addPictureFail'), { icon: 2 })
						}
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
			// 修改邀请码
			if (layEvent === 'edit') {
				// 编辑菜单
				if (data.pictureType == 5) {
					type = 'edit'
					createTextIndex = layer.open({
						type: 1,
						title: $t('edit'),
						area: '800px',
						content: $('#createTextId'),
						success: function () {
							form.val('addTextForm', data)
							addeditor = layedit.build('addTextarea', {})
							$('#addTextarea').html(data.content)
							$('#createTextId').show()
						},
						cancel: function () {
							$('#createTextId').hide()
						}
					})
				} else {
					editIndex = layer.open({
						type: 1,
						title: $t('edit'),
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
				}
			} else if (layEvent === 'delete') {
				// 删除
				layer.confirm($t('deleteConfirmation'), {
					title: $t('operationConfirmation'),
					btn: [$t('confirm'), $t('cancel')],
				}, function (index) {
					actions.onDelete(data.id, function () {
						layer.close(index)
					})
				})
			} else if (layEvent === 'forbidden') {
				let showType = data.showType
				if (showType == null) {
					showType = 1
				} else {
					showType == 0 ? (showType = 1) : (showType = 0)
				}
				if (showType !== 1) {
					layer.confirm($t('addSwiper.disableConfirmation'), {
						title: $t('operationConfirmation'),
						btn: [$t('confirm'), $t('cancel')],
					}, function (index) {
						actions.onUpdateItem(
								data.id,
								{ showType: showType },
								function () {
									layer.close(index)
								}
						)
					})
				} else {
					layer.confirm($t('addSwiper.enableConfirmation'), {
						title: $t('operationConfirmation'),
						btn: [$t('confirm'), $t('cancel')],
					}, function (index) {
						actions.onUpdateItem(data.id,
								{ showType: showType },
								function () {
									layer.close(index)
								}
						)
					})
				}
			}
		})

		var levelListTableId = 'levelListTableId'
		//第一个实例
		table.render(Object.assign({}, $.tableRenderConfing, {
			elem: '#level',
			url: '/action/picture/list', //数据接口
			// url: 'http://localhost:8080/action/picture/list', //数据接口
			cellMinWidth: 100, //全局定义常规单元格的最小宽度
			where: where,
			cols: [
				[
					//表头
					{ field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left' },
					{ field: 'picturePath', title: $t('addSwiper.picture'), templet: '#picturePath', minWidth: 160 },
					{ field: 'pictureType', title: $t('addSwiper.pictureType'), templet: function (d) {
							return $t('addSwiper.pictureType' + d.pictureType)
						}, width: 120 },
					{ field: 'title', title: $t('title'), width: 120 },
					{ field: 'content', title: $t('addSwiper.describe'), minWidth: 160 },
					{ field: 'updateTime', title: $t('addSwiper.updateTime'), templet: function (d) {
							return layui.util.toDateString(d.goodsAddTime, 'yyyy-MM-dd HH:mm:ss')
						}, minWidth: 160 },
					{ field: 'operation', title: $t('operation'), templet: '#operation', fixed: 'right', width: 180 }
				]
			],
			id: levelListTableId // 容器唯一IDs
		}));

		// 编辑-提交
		form.on('submit(editSubmit)', function (data) {
			actions.onUpdateItem(tableCurrentItem.id, data.field, function () {
				console.log('success')
				layer.close(editIndex)
				$('#editId').hide()
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
				title: $t('addSwiper.addPicture'),
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
			actions.onCreate(data.field, function () {
				layer.close(createIndex)
				form.val('addForm', {
					content: ''
				})
			})
		})

		$('#createTextBtn').click(function () {
			type = 'add'
			createTextIndex = layer.open({
				type: 1,
				title: $t('addSwiper.addText'),
				area: '800px',
				content: $('#createTextId'),
				success: function () {
					$('#createTextId').show()
					addeditor = layedit.build('addTextarea', {})
				},
				cancel: function () {
					$('#createTextId').hide()
				}
			})
		})

		$('#createTextCancel').click(function () {
			layer.close(createTextIndex)
			form.val('addTextForm', {
				content: '',
				title: ''
			})
		})

		form.on('submit(createTextSubmit)', function (data) {
			if (type == 'edit') {
				data.field.content = layedit.getContent(addeditor)
				actions.onUpdateItem(tableCurrentItem.id, data.field, function () {
					layer.close(createTextIndex)
					$('#editId').hide()
				})
				return false
			} else {
				data.field.pictureType = '5'
				data.field.content = layedit.getContent(addeditor)
				actions.onCreate(data.field, function () {
					layer.close(createTextIndex)
					form.val('addTextForm', {
						content: '',
						title: ''
					})
				})
			}
		})
	})
</script>
</body>

</html>