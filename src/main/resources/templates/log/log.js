layui.use(['table', 'form', 'util', 'laydate'], function () {
	var table = layui.table,
		$ = layui.$,
		form = layui.form,
		util = layui.util,
		laydate = layui.laydate

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
		range: true //或 range: '~' 来自定义分割字符
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
		// 刷新表格数据
		onReloadData: function () {
			table.reloadData(levelListTableId, { where: Object.assign({}, where, onGetSearchParams()) })
		}
	}

	var levelListTableId = 'levelListTableId'
	//第一个实例
	table.render({
		elem: '#level',
		height: 312,
		url: '/action/operate/list', //数据接口
		page: true, //开启分页
		cellMinWidth: 100, //全局定义常规单元格的最小宽度
		method: 'post',
		where: where,
		contentType: 'application/json',
		loading: true,
		request: {
			pageName: 'pageNum', //页码的参数名称，默认：page
			limitName: 'pageSize' //每页数据量的参数名，默认：limit
		},
		cols: [
			[
				//表头
				{ field: 'id', title: 'ID', width: 60, sort: true, fixed: 'left' },
				{ field: 'title', title: '标题', width: 100 },
				{ field: 'operateContent', title: '内容', minWidth: 160 },
				{ field: 'createBy', title: '创建人', width: 100 },
				{ field: 'createTime', title: '创建时间', templet: '#createTime', width: 80 },
				{ field: 'remark', title: '备注', width: 250 }
			]
		],
		parseData: parseData,
		id: levelListTableId // 容器唯一IDs
	})

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
