layui.use(['table', 'form', 'util', 'element', 'laydate'], function () {
    var table = layui.table, $ = layui.$, form = layui.form, util = layui.util;
    var element = layui.element;
    var laydate = layui.laydate;

    // 表格当前选择项
    var tableCurrentItem = {};
    var currentAddressInfoItem = {};
    var currentBankCardInfoItem = {};

    // 扣款弹窗Index
    var deductionIndex;
    // 修改邀请码弹窗Index
    var upInviteCodeIndex;
    // 派单弹窗Index
    var dispatchIndex;
    var editIndex;
    var addressInfoIndex;
    var bankCardInfoIndex;
    var sendMessageIndex;

    laydate.render({
        elem: '#registrationTime',
        range: true //或 range: '~' 来自定义分割字符
    });


    var where = {
        // "agentLevel": 0,
        // "balance": 0,
        // "companyId": 0,
        // "createBy": "string",
        // "createTime": "2022-07-18T09:18:19.191Z",
        // "deductionNum": 0,
        // "delFlag": 0,
        // "depositNum": 0,
        // "email": "string",
        // "freezeBalance": 0,
        // "id": 0,
        // "inviteCode": "string",
        // "isAgent": 0,
        // "loginDate": "2022-07-18T09:18:19.191Z",
        // "loginIp": "string",
        // "matching": "string",
        // "memberLevelId": 0,
        // "memberStatus": 0,
        // "parentUserId": 0,
        // "parentUserName": "string",
        // "password": "string",
        // "phoneNumber": "string",
        // "rechargeNum": 0,
        // "registerCountry": "string",
        // "registerIp": "string",
        // "registrationTime": "2022-07-18T09:18:19.191Z",
        // "remark": "string",
        "status": 0,
        // "totalCommission": 0,
        // "userAccount": "string"
    };

    var memberListTableId = 'memberListTable';
    table.render(Object.assign({}, $.tableRenderConfing, {
        elem: '#member-list',
        url: '/action/member/list', //数据接口
        cellMinWidth: 100, //全局定义常规单元格的最小宽度
        method: 'post',
        contentType: 'application/json',
        page: true, //开启分页
        where: where,
        lineStyle: 'height: 100px;',
        // ID	账号	会员等级	账户余额	提现	冻结金额	上级用户	邀请码	注册信息	操作
        cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', title: 'ID', sort: true}
            , {field: 'userAccount', title: '账号', templet: '#userAccount', width: 180}
            , {field: 'memberLevelId', title: '会员等级', templet: '#memberLevelId', sort: true, width: 110}
            , {field: 'balance', title: '账户余额', templet: '#balance', sort: true, width: 180}
            , {field: 'depositNum', title: '提现', sort: true, minWidth: 120}
            , {field: 'freezeBalance', title: '冻结金额', sort: true, minWidth: 120}
            , {field: 'parentUserName', title: '上级用户', sort: true, minWidth: 120}
            , {field: 'inviteCode', title: '邀请码', templet: '#inviteCode', sort: true, minWidth: 160}
            , {field: 'registerId', title: '注册信息', templet: '#register', sort: true, minWidth: 160}
            , {field: 'operation', title: '操作', templet: '#operation', fixed: 'right', width: 336}
        ]],
        id: memberListTableId, // 容器唯一ID
    }));

    var actions = {
        apiUrl: {
            update: '/action/member/update/',
            delete: '/action/member/delete/',
            create: '/action/member/create',
        },
        // 刷新表格数据
        onReloadData: function () {
            var searchData = form.val('searchForm');
            console.log('searchData', searchData);
            table.reloadData(memberListTableId, {where: Object.assign({}, where, searchData)});
        },
        onUpdateItem: function (id, fields, cb) {
            $.request({
                url: actions.apiUrl.update + id,
                type: 'post',
                contentType: 'application/json',
                data: fields,
                success: function () {
                    actions.onReloadData();
                    layer.msg('操作成功', {icon: 1});
                    cb && cb();
                }
            })
        },
        onDelete: function (id, cb) {
            $.request({
                url: actions.apiUrl.delete + id,
                type: 'get',
                success: function () {
                    actions.onReloadData();
                    layer.msg('删除会员成功', {icon: 1});
                    cb && cb();
                },
                fail: function () {
                    layer.msg('删除会员失败', {icon: 2});
                }
            });
        },
        onCreate: function (fields, cb) {
            $.request({
                url: actions.apiUrl.create,
                type: 'post',
                contentType: 'application/json',
                data: fields,
                success: function () {
                    actions.onReloadData();
                    layer.msg('创建会员成功', {icon: 1});
                    cb && cb();
                },
                fail: function () {
                    layer.msg('创建会员失败', {icon: 2});
                }
            });
        },
    }

    //单元格工具事件
    table.on('tool(member-list)', function (obj) { // 注：test 是 table 原始标签的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

        // 设置当前选择项
        tableCurrentItem = Object.assign({}, data);

        // 修改邀请码
        if (layEvent === 'upInviteCode') {
            upInviteCodeIndex = layer.open({
                type: 1,
                // value: data.inviteCode,
                title: '修改邀请码',
                area: '800px',
                content: $('#upInviteCodeId'),
                success: function () {
                    $('#newInviteCode').val(data.inviteCode);
                    $('#upInviteCodeId').show();
                },
                cancel: function () {
                    $('#upInviteCodeId').hide();
                }
            });
            // function(value, index, elem){
            //        if (!value) {
            //            layer.msg('请输入邀请码');
            //            // alert('请输入邀请码');
            //            return;
            //        }
            //        layer.close(index);
            //    }
        } else if (layEvent === 'deduction') { // 扣款
            deductionIndex = layer.open({
                type: 1,
                title: '扣款',
                area: '800px',
                content: $('#deductionId'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                success: function () {
                    $('#deductionId').show();
                },
                cancel: function () {
                    $('#deductionId').hide();
                }
            });
        } else if (layEvent === 'dispatch') { // 派单
            dispatchIndex = layer.open({
                type: 1,
                title: '派单',
                area: '800px',
                content: $('#dispatchId'),
                success: function () {
                    $('#dispatchId').show();
                },
                cancel: function () {
                    $('#dispatchId').hide();
                }
            });
        } else if (layEvent === 'edit') { // 编辑菜单
            editIndex = layer.open({
                type: 1,
                title: '编辑菜单',
                area: '800px',
                content: $('#editId'),
                success: function () {
                    form.val('editForm', data);
                    $('#editId').show();
                },
                cancel: function () {
                    $('#editId').hide();
                }
            });
        } else if (layEvent === 'bankCardInfo') { // 银行卡信息
            $.request({
                url: '/action/bank/getmemberbank/' + tableCurrentItem.id,
                type: 'get',
                success: function (result) {
                    // if (!result.data) {
                    //     layer.msg('没有数据', {icon: 2});
                    //     return;
                    // }
                    currentBankCardInfoItem = result.data;
                    bankCardInfoIndex = layer.open({
                        type: 1,
                        title: '银行卡信息',
                        area: '800px',
                        content: $('#bankCardInfoId'),
                        success: function () {
                            $('#bankCardInfoId').show();
                        },
                        cancel: function () {
                            $('#bankCardInfoId').hide();
                        }
                    });
                },
            })

            // layer.msg('没有数据', {icon: 2});
        } else if (layEvent === 'toggleState') { //状态切换
            // 帐号状态（0正常 1停用）
            actions.onUpdateItem(tableCurrentItem.id, {status: data.status === 0 ? 1 : 0})
        } else if (layEvent === 'addressInfo') { // 地址信息
            $.request({
                url: '/action/address/getmemberaddress/' + tableCurrentItem.id,
                type: 'get',
                success: function (result) {
                    currentAddressInfoItem = result.data;
                    form.val('addressInfoForm', result.data);
                    addressInfoIndex = layer.open({
                        type: 1,
                        title: '地址信息',
                        area: '800px',
                        content: $('#addressInfoId'),
                        success: function () {
                            $('#addressInfoId').show();
                        },
                        cancel: function () {
                            $('#addressInfoId').hide();
                        }
                    });
                },
            })

        } else if (layEvent === 'viewTeam') { // 查看团队
            window.parent.layui.tab.tabAdd({
                id: new Date().getTime(),
                title: '查看团队',
                icon: 'fa-file',
                url: '/viewTeam.html?id=' + data.id
            })
            // window.location.href = './viewTeam.html';
        } else if (layEvent === 'accountChange') { // 帐变
            window.parent.layui.tab.tabAdd({
                id: 'caiwu_' + data.id,
                title: '帐变',
                icon: 'fa-file',
                url: '/caiwu.html?id=' + data.id,
            })
        } else if (layEvent === 'realPerson') { // 设为真人
            // 状态:1.真人2.假人
            actions.onUpdateItem(tableCurrentItem.id, {memberStatus: data.memberStatus === 1 ? 2 : 1})
        } else if (layEvent === 'sendMessage') { // 发送消息
            sendMessageIndex = layer.open({
                type: 1,
                title: '发送消息',
                area: '800px',
                content: $('#sendMessageId'),
                success: function () {
                    $('#sendMessageId').show();
                },
                cancel: function () {
                    $('#sendMessageId').hide();
                }
            });

        } else if (layEvent === 'delete') { // 删除
            layer.confirm('确定要删除吗?', {title: '操作确认'}, function (index) {
                actions.onDelete(data.id, function () {
                    layer.close(index);
                });
            });
        }

    });

    // 搜索
    form.on('submit(search)', function (data) {
        console.log(data.field);
        actions.onReloadData();
        return false;
    });

    // 邀请码-提交
    form.on('submit(upInviteCodeSubmit)', function (formData) {
        actions.onUpdateItem(tableCurrentItem.id, formData.field, function () {
            layer.close(upInviteCodeIndex);
            $('#upInviteCodeId').hide();
        });
        return false;
    });
    // 邀请码-取消
    $('#dupInviteCodeCancel').click(function () {
        layer.close(upInviteCodeIndex);
    });

    // 扣款-提交
    form.on('submit(deductionSubmit)', function (data) {
        layer.msg(JSON.stringify(data.field));
        return false;
    });
    // 扣款-取消
    $('#deductionCancel').click(function () {
        layer.close(deductionIndex);
    });


    // 派单-提交
    form.on('submit(dispatchSubmit)', function (data) {
        layer.msg(JSON.stringify(data.field));
        return false;
    });
    // 派单-取消
    $('#dispatchCancel').click(function () {
        layer.close(dispatchIndex);
    });


    // 编辑-提交
    form.on('submit(editSubmit)', function (data) {
        // layer.msg(JSON.stringify(data.field));
        actions.onUpdateItem(tableCurrentItem.id, data.field, function () {
            layer.close(editIndex);
            $('#editId').hide();
        })
        return false;
    });
    // 编辑-取消
    $('#editCancel').click(function () {
        layer.close(editIndex);
    });

    // 地址信息-提交
    form.on('submit(addressInfoSubmit)', function (data) {
        $.request({
            url: '/action/address/save',
            type: 'post',
            data: Object.assign({}, currentAddressInfoItem, data.field, {memberId: tableCurrentItem.id}),
            success: function () {
                layer.close(addressInfoIndex);
                actions.onReloadData();
                layer.msg('地址信息修改成功', {icon: 1});
            }
        })
        return false;
    });
    // 地址信息-取消
    $('#addressInfoCancel').click(function () {
        layer.close(addressInfoIndex);
    });

    // 银行卡-提交
    form.on('submit(bankCardInfoSubmit)', function (data) {
        $.request({
            url: '/action/bank/save',
            type: 'post',
            data: Object.assign({}, currentBankCardInfoItem, data.field, {memberId: tableCurrentItem.id}),
            success: function () {
                layer.close(bankCardInfoIndex);
                actions.onReloadData();
                layer.msg('银行卡信息修改成功', {icon: 1});
            }
        })
        return false;
    });
    // 银行卡-取消
    $('#bankCardInfoCancel').click(function () {
        layer.close(bankCardInfoIndex);
    });

    // 创建会员-提交
    form.on('submit(createSubmit)', function (data) {
        actions.onCreate(data.field, {
            success: function () {
                layer.close(createIndex);
            }
        });
        // return false;
    });
    // 创建会员-取消
    $('#createCancel').click(function () {
        layer.close(createIndex);
    });

    var createIndex;
    $('#createBtn').click(function () {
        createIndex = layer.open({
            type: 1,
            title: '创建会员',
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


    // 发送消息-提交
    form.on('submit(sendMessageSubmit)', function (data) {
        var fd = Object.assign({
            noticeClasses: 2, // 个人通知
            noticeType: 1, // 公告类型（1通知 2公告）
        }, data.field);
        $.request({
            url: '/action/notice/create',
            type: 'post',
            data: fd,
            success: function () {
                layer.close(sendMessageIndex);
                onSendMessageCancel();
                layer.msg('发送消息成功', {icon: 1});
            },
        })
    });
    var onSendMessageCancel = function () {
        layer.close(sendMessageIndex);
        $('#sendMessageId').hide();
        form.val('sendMessageForm', {
            noticeTitle: '',
            noticeContent: '',
        })
    }
    $('#sendMessageCancel').click(onSendMessageCancel)

});