

// 默认语言
// var locale = 'en';

/**
 *
 * @param {Object} [options]
 * @param {String} [options.locale=en] // 默认语言
 * @param {Function} [options.onChange] // 改变语言时执行
 * @param {Function} [options.onRender]
 * @constructor
 */
function I18n (options) {
    if (!options) options = {};

    this.localKey = 'admin_lang';


    this.onLang = function () {
        var lang = window.localStorage.getItem(this.localKey);
        return lang || 'en';
    }
    this.locale = options.locale || this.onLang();

    // 英文
    this.lang_en = {
        language: 'Language',
        login: 'Login',
        userLogin: 'User login',
        backgroundLogin: 'Background login',
        userName: 'user name',
        password: 'password',
        verificationCode: 'Verification code',
        loginSucceeded: 'Login succeeded',

        menu: {
            systemAdmin: 'System admin',
            userAdmin: 'User admin',
            menuAdmin: 'Menu admin',
            roleAdmin: 'Role admin',
            companyAdmin: 'Company admin',
            dictionariesAdmin: 'Dictionaries admin',
            commodityAdmin: 'Commodity admin',
            commodityList: 'Product list',
            commodityClassify: 'Commodity classify',
            memberAdmin: 'Member admin',
            memberList: 'Member list',
            memberLevel: 'Membership level',
            transactionAdmin: 'Transaction admin',
            orderList: 'Order list',
            rechargeAdmin: 'Recharge admin',
            withdrawalAdmin: 'Withdrawal admin',
            transactionControl: 'Transaction control',
            textAdmin: 'Text admin',
            announcementAdmin: 'Announcement admin',
            pictureAdmin: 'Picture admin',
            customerServiceAdmin: 'Customer service admin',
            customerServiceList: 'Customer service list',
            operationLog: 'Operation log',
            logView: 'Log view',
        },

        appName: 'Background management system',

        // index
        console: 'Console',
        commodityAdmin: 'Commodity admin',
        otherSystems: 'Other systems',
        mailAdmin: 'Mail admin',
        newsAdmin: 'News admin',
        authorizationAdmin: 'Authorization admin',
        theme: 'Theme',
        default: 'default',
        orange: 'orange',
        green: 'green',
        pink: 'pink',
        blue: 'blue',
        red: 'red',
        basicInfo: 'Basic info',
        modifyPassword: 'Modify Password',
        logout: 'Logout',
        home: 'Home',
        operation: 'Operation',
        refreshCurrentTab: 'Refresh Current Tab',
        closeCurrentTab: 'Close Current Tab',
        closeOtherTab: 'Close Other Tab',
        closeAllTab: 'Close All Tab',

        //
        edit: 'Edit',
        delete: 'Delete',
        search: 'Search',
        conditionalSearch: 'Conditional Search',
        keyword: 'key word',
        pleaseEnterThe: 'Please Enter The',
        pleaseSelectThe: 'Please Select The',
        operationConfirmation: 'Operation confirmation',
        deleteConfirmation: 'Are you sure you want to delete?',
        confirm: 'Confirm',
        cancel: 'Cancel',
        deleteSucceeded: 'Delete succeeded',
        uploadPictures: 'Upload pictures',
        enable: 'Enable',
        disable: 'Disable',
        modify: 'Modify',
        submit: 'Submit',
        operationSucceeded: 'Operation succeeded',
        //
        operationFailed: 'Operation failed',
        deleteFailed: 'Delete failed',
        createSucceeded: 'Created successfully',
        createFailed: 'Creation failed',
        pleaseSelectItem: 'Please select a data item',
        savedSuccessfully: 'Saved successfully',

        // 商品列表
        goodsList: {
            form: {
                goodsName: 'Goods name',
                petGoodsName: 'Please enter the goods name',
                priceRange: 'Price range',
                maximum: 'Maximum',
                minimum: 'Minimum',
                classify: 'Classify',
            },
            addItem: 'Add Item',
            table: {
                goodsId: 'Goods ID',
                goodsName: 'Goods Name',
                goodsPrice: 'Goods Price',
                shopName: 'Shop Name',
                classify: 'Classify',
                goodsAddTime: 'Goods Add Time',
                status: 'Status',
                status0: 'Not on the shelf',
                status1: 'Already on the shelf',
                operation: 'Operation',
            },
        },
        // 添加商品
        addGoods: {
            createItem: 'Create item',
            saveItem: 'Save item',
            uploadSucceeded: 'Upload succeeded',
            createSucceeded: 'Created successfully',
            saveSucceeded: 'Saved successfully',
            goodsName: 'Goods Name',
            petGoodsName: 'Please enter the goods name',
            shopName: 'Shop Name',
            petShopName: 'Please enter the shop name',
            goodsPrice: 'Goods Price',
            petGoodsPrice: 'Please enter the goods price',
            goodsSort: 'Goods classification',
            goodsPicText: 'Product logo and rotation display pictures',
            uploadPictures: 'Upload pictures',
            goodsInfo: 'Product details',
        },

        goodsClassify: {
            add: 'Add',
            table: {
                id: 'Classify ID',
                sortName: 'Sort Name',
                commissionRate: 'Commission Rate',
                explainSimple: 'Explain Simple',
                minAmount: 'Min Amount',
                goodsAddTime: 'Goods Add Time',
                operation: 'Operation',
            },
        },

        addClassify: {
            createClassify: 'Create classify',
            saveClassify: 'Save classify',
            bindLevel: 'Bind member level',
            petBindLevel: 'Please enter the membership level',
            createdSuccessfully: 'Created successfully',
            savedSuccessfully: 'Saved successfully',
            uploadSucceeded: 'Upload succeeded',

            sortName: 'Classify Name',
            petSortName: 'Please enter the Classify name',
            commissionRate: 'Commission proportion (don\'t set percentage, write 0.01 directly)',
            petCommissionRate: 'Please enter the Commission proportion',
            explainSimple: 'Introduction to classification',
            petExplainSimple: 'Please enter the classification introduction',
            minAmount: 'Minimum amount limit',
            petMinAmount: 'Please enter the minimum amount limit',
            sortLogo: 'Classification logo (no modification)',
        },

        member: {
            petKeyword: 'Please enter the user name, mobile phone number and IP',
            registrationTime: 'Registration time',
            petRegistrationTime: 'Please select the registration time',
            status: 'Status',
            status1: 'Real person',
            status2: 'Dummy',
            addMember: 'Add member',

            userAccount: 'account number',
            memberLevelId: 'Membership level',
            balance: 'Account balance',
            depositNum: 'Withdrawal',
            freezeBalance: 'Frozen amount',
            parentUserName: 'Superior user',
            inviteCode: 'Invitation code',
            registerInfo: 'Registration info',
            operation: 'Operation',

            deduction: 'Deduction',
            dispatch: 'Dispatch',
            bankCardInfo: 'Bank card info',
            sendMessage: 'Send message',
            normalWithdrawal: 'Normal withdrawal',
            noWithdrawal: 'No withdrawal',
            setAsRealPerson: 'Set as real person',
            setAsDummy: 'Set as dummy',
            addressInfo: 'Address info',
            viewPassword: 'View password',
            viewTeam: 'View team',
            accountChange: 'Account change',
            //
            petBalance: 'Please enter the account balance',
            petFreezeBalance: 'Frozen amount',

            modifyInvitationCode: 'Modify invitation code',
            invitationCode: 'Invitation code',
            petInvitationCode: 'Please enter the invitation code',
            phoneNumber: 'Phone number',
            petPhoneNumber: 'Please enter your mobile phone number',
            userName: 'User name',
            petUserName: 'Please enter the user name',
            operaMount: 'amount of money',
            petOperaMount: 'Please enter the amount',
            operaMountHelp: 'Positive means plus, negative means minus',
            remarks: 'Remarks',
            petRemarks: 'Please enter comments',
            accountName: 'Account Name',
            petAccountName: 'Please enter the account name',
            bankName: 'Bank Name',
            petBankName: 'Please enter the bank name',
            bankNumber: 'Bank No',
            petBankNumber: 'Please enter the bank number',
            cardNum: 'Bank card number',
            petCardNum: 'Please enter the bank card number',
            bankCountry: 'Country of Bank',
            petBankCountry: 'Please enter the country where the bank is located',
            noticeTitle: 'Title',
            petNoticeTitle: 'Please enter a title',
            noticeContent: 'Content',
            petNoticeContent: 'Please enter the content',
            limitAmount: 'Set amount',
            petLimitAmount: 'Please enter the set amount, which cannot be less than 100',
            memberLevel: 'Membership level',
            password: 'Login password',
            petPassword: 'Leave blank and do not change password',
            petPassword2: 'Please enter the login password',
            parentUserId: 'Superior ID',
            petParentUserId: 'Please enter the superior ID',
            createMember: 'Create member',

            address: {
                name: 'Receiving name',
                petName: 'Please enter the receiving name',
                tel: 'Receiving mobile phone',
                petTel: 'Please enter the receiving mobile phone',
                address: 'Detailed address',
                petAddress: 'Please enter the detailed address',
            },

            verify: {
                text1: 'Set amount cannot be empty',
                text2: 'Set amount cannot be less than 100',
            }

        },

        level: {
            add: 'Add member level',
            membersName: 'Name',
            petMembersName: 'Please enter a name',
            icon: 'Icon',
            uploadPic: 'Upload Icon',
            memberPrice: 'Member price',
            petMemberPrice: 'Please enter the member price',
            commission: 'commission rate',
            petCommission: 'Please enter the Commission proportion',
            numMin: 'Minimum balance',
            petNumMin: 'Please enter the minimum balance',
            orderNum: 'Number of orders received',
            petOrderNum: 'Please enter the number of orders received',
            withdrawalTimes: 'Withdrawal times',
            petWithdrawalTimes: 'Please enter the withdrawal times',
            mate: 'Matching interval',
            petMateMin: 'Please enter the matching minimum value',
            petMateMax: 'Please enter the maximum matching value',
            withdrawalMin: 'Minimum withdrawal amount',
            petWithdrawalMin: 'Please enter the minimum withdrawal amount',
            withdrawalMax: 'Maximum withdrawal amount',
            petWithdrawalMax: 'Please enter the maximum withdrawal amount',
            uploadSucceeded: 'Upload succeeded',
            registerTime: 'Registration time',
            addTitle: 'New member level',
        },

        orderList: {
            lno: 'Order number',
            petLno: 'Please enter the order number',
            memberId: 'Member ID',
            petMemberId: 'Please enter the member ID',
            phoneNumber: 'Phone number',
            petPhoneNumber: 'Please enter your mobile phone number',
            time: 'Order time',
            petTime: 'Please select the time to add',
            goodsName: 'Goods name',
            goodsCount: 'Goods count',
            shopName: 'Shop name',
            balance: 'Balance',
            amount: 'Transaction amount',
            commission: 'Commission',
            amountAfterTransaction: 'Amount after transaction',
            addtime: 'Order time',
            endtime: 'Completion time',
            status: 'Status',
            // 订单状态 0待付款 1交易完成 2用户取消 3强制完成 4强制取消 5交易冻结
            status0: 'To be paid',
            status1: 'Transaction completion',
            status2: 'User cancel',
            status3: 'Forced completion',
            status4: 'Forced cancellation',
            status5: 'Transaction freeze',
            qiang: 'Scramble for orders',
            sign: 'Card slip',
            sign0: 'Yes',
            sign1: 'No',
            cStatus: 'Commission payment status',
            // 佣金发放状态 0未发放 1已发放 2账号冻结
            cStatus0: 'Unissued',
            cStatus1: 'Issued',
            cStatus2: 'Account number freeze',
        },

        // 充值管理
        deposit: {
            orderNo: 'Order number',
            petOrderNo: 'Please enter the order number',
            userAccount: 'User name',
            petUserAccount: 'Please enter the user name',
            phoneNumber: 'Phone number',
            petPhoneNumber: 'Please enter your mobile phone number',
            addTime: 'Add time',
            petAddTime: 'Please select the time to add',
            updateBy: 'Superior user',
            realName: 'Real name',
            operaMount: 'Transaction amount',
            createTime: 'Add time',
            paymentMethod: 'Payment method',
            operaType: 'Type',
            operaType1: 'recharge',
            operaType2: 'reduce',
            operaType3: 'frozen',
            operaType4: 'extract',
            processingTime: 'Processing time',
        },

        withdrawal: {
            batchPass: 'Batch pass',
            batchPassSuccess: 'Batch passed successfully',
            batchRejection: 'Batch rejection',
            batchRejectionSuccess: 'Batch rejection succeeded',
            orderNo: 'Order number',
            petOrderNo: 'Please enter the order number',
            userAccount: 'User name',
            petUserAccount: 'Please enter the user name',
            startTime: 'Start time',
            petStartTime: 'Please select the initiation time',
            status1: 'To be reviewed',
            status2: 'Rejected',
            status3: 'Paid',
            adopt: 'Adopt',
            reject: 'Reject',
            withdrawalUser: 'Withdrawal user',
            superiorUser: 'Superior user',
            operaMount: 'Withdrawal amount',
            withdrawalTimes: 'Withdrawal times of the day',
            serviceCharge: 'Service Charge',
            actualArrival: 'Actual arrival',
            collectionInfo: 'Collection information',
            phoneNumber: 'Phone number',
            dealTime: 'Deal time',
            status: 'Status',
            orderStatus: 'Order status',
            remark: 'Remark',
            adoptConfirmation: 'Are you sure you want to pass?',
            passed: 'Passed',
            reasonForRejection: 'Reason for rejection',
            rejected: 'Rejected',
        },

        tc: {
            basicSettings: 'Basic settings',
            trc: 'TRC20 address',
            petTrc: 'Please enter TRC20 address',
            erc: 'ERC20 address',
            petErc: 'Please enter ERC20 address',
            usdt: 'USDT',
            petUsdt: 'Please enter USDT',
            wait: 'Waiting time for payment without order (seconds)',
            petWait: 'Please enter the order payment waiting time',
            waitHelp: 'The waiting time for order payment is long. If the new order is not completed within this time, the payment will be automatically canceled',
            generalCommission: 'Trading Commission of ordinary members',
            generalCommissionHelp: 'Transaction commission',
            upOneCommission: 'Transaction commission of upper level member',
            upTwoCommission: 'Transaction commission of upper level 2 members',
            upThreeCommission: 'Transaction commission of upper three level members',
            upFourCommission: 'Transaction commission of upper level 4 members',
            upFiveCommission: 'Trading Commission of upper five members',
            freeze: 'Freezing time',
            violate: 'Number of violations allowed',
            petViolate: 'Please enter the delivery order automatic confirmation receipt time',
            distributeTime: 'Order submission delay time (unit/s)',
            distributeTimeText1: ' Remote host allocation time:',
            distributeTimeText2: ' Waiting for merchant response time',
            distributeTimeHelp: 'The time is composed of 2 parts, and the default is 5 seconds, a total of 10 seconds',
            appAdress: 'App download address',
            petAppAdress: 'Please enter the app download address',
            version: 'Version number',
            petVersion: 'Please enter version',
            withdraw: 'Withdrawal time',
            petWithdraw: 'Please select the withdrawal time range',
            deposit: 'Recharge time',
            petDeposit: 'Please select the recharge time range',
            convey: 'Order grabbing time',
            petConvey: 'Please select the time range for order grabbing',
            shopStatus: 'Mall status',
            petShopStatus: 'Mall status: 1open 0closed',
            saveText: 'Save configuration',

        },

    };

    // 中文
    this.lang_cn = {
        // 登录页
        language: '语言',
        login: '登录',
        userLogin: '用户登录',
        backgroundLogin: '后台登录',
        userName: '用户名',
        password: '密码',
        verificationCode: '验证码',
        loginSucceeded: '登录成功',

        // 菜单
        menu: {
            systemAdmin: '系统管理',
            userAdmin: '用户管理',
            menuAdmin: '菜单管理',
            roleAdmin: '角色管理',
            companyAdmin: '单位管理',
            dictionariesAdmin: '字典管理',
            commodityAdmin: '商品管理',
            commodityList: '商品列表',
            commodityClassify: '商品分类',
            memberAdmin: '会员管理',
            memberList: '会员列表',
            memberLevel: '会员等级',
            transactionAdmin: '交易管理',
            orderList: '订单列表',
            rechargeAdmin: '充值管理',
            withdrawalAdmin: '提现管理',
            transactionControl: '交易控制',
            textAdmin: '文本管理',
            announcementAdmin: '公告管理',
            pictureAdmin: '图片管理',
            customerServiceAdmin: '客服管理',
            customerServiceList: '客服列表',
            operationLog: '操作日志',
            logView: '日志查看',
        },

        // 项目名称
        appName: '后台管理系统',

        // index页面
        console: '控制台',
        commodityAdmin: '商品管理',
        otherSystems: '其它系统',
        mailAdmin: '邮件管理',
        newsAdmin: '消息管理',
        authorizationAdmin: '授权管理',
        theme: '皮肤',
        default: '默认',
        orange: '橘子橙',
        green: '原谅绿',
        pink: '少女粉',
        blue: '天空蓝',
        red: '枫叶红',
        basicInfo: '基本资料',
        modifyPassword: '密码修改',
        logout: '注销',
        home: '主页',
        operation: '操作',
        refreshCurrentTab: '刷新当前选项卡',
        closeCurrentTab: '关闭当前选项卡',
        closeOtherTab: '关闭其它选项卡',
        closeAllTab: '关闭所有选项卡',

        //
        edit: '编辑',
        delete: '删除',
        search: '搜 索',
        conditionalSearch: '条件搜索',
        keyword: '关键字',
        pleaseEnterThe: '请输入',
        pleaseSelectThe: '请选择',
        operationConfirmation: '操作确认',
        deleteConfirmation: '确定要删除吗?',
        confirm: '确定',
        cancel: '取消',
        deleteSucceeded: '删除成功',
        uploadPictures: '上传图片',
        enable: '启用',
        disable: '禁用',
        modify: '修改',
        submit: '提交',
        operationSucceeded: '操作成功',
        operationFailed: '操作失败',
        deleteFailed: '删除失败',
        createSucceeded: '创建成功',
        createFailed: '创建失败',
        pleaseSelectItem: '请选择数据项',
        savedSuccessfully: '保存成功',

        // 商品列表
        goodsList: {
            form: {
                productName: '商品名称',
                petProductName: '请输入商品名称',
                priceRange: '价格区间',
                maximum: '最大',
                minimum: '最小',
                classify: '分类',
            },
            addItem: '添加商品',
            table: {
                goodsId: '商品ID',
                goodsName: '商品名称',
                goodsPrice: '商品价格',
                shopName: '店铺名称',
                classify: '商品分类',
                goodsAddTime: '添加时间',
                status: '状态',
                status0: '未上架',
                status1: '上架',
                operation: '操作',
            },
        },

        // 添加商品
        addGoods: {
            createItem: '创建商品',
            saveItem: '保存商品',
            uploadSucceeded: '上传成功',
            createSucceeded: '创建成功',
            saveSucceeded: '保存成功',
            goodsName: '商品名称',
            petGoodsName: '请输入商品名称',
            shopName: '店铺名称',
            petShopName: '请输入店铺名称',
            goodsPrice: '商品单价',
            petGoodsPrice: '请输入商品单价',
            goodsSort: '商品分类',
            goodsPicText: '商品LOGO及轮播展示图片',
            uploadPictures: '上传图片',
            goodsInfo: '商品详细内容',
        },

        // 商品分类
        goodsClassify: {
            add: '添加分类',
            table: {
                id: '分类ID',
                sortName: '分类名称',
                commissionRate: '比例',
                explainSimple: '简介',
                minAmount: '最低金额',
                goodsAddTime: '添加时间',
                operation: '操作',
            },
        },

        // 创建分类
        addClassify: {
            createClassify: '创建分类',
            saveClassify: '保存分类',
            bindLevel: '绑定会员等级',
            petBindLevel: '请输入会员等级',
            createdSuccessfully: '创建成功',
            savedSuccessfully: '保存成功',
            uploadSucceeded: '上传成功',

            sortName: '分类名称',
            petSortName: '请输入分类名称',
            commissionRate: '佣金比例(不要设置百分比直接写0.01)',
            petCommissionRate: '请输入佣金比例',
            explainSimple: '分类简介',
            petExplainSimple: '请输入分类简介',
            minAmount: '最低金额限制',
            petMinAmount: '请输入最低金额限制',
            sortLogo: '分类LOGO(不用修改)',
        },

        member: {
            petKeyword: '请输入用户名称,手机号码,IP',
            registrationTime: '注册时间',
            petRegistrationTime: '请选择注册时间',
            status: '状态',
            status1: '真人',
            status2: '假人',
            addMember: '添加会员',

            userAccount: '账号',
            memberLevelId: '会员等级',
            balance: '账户余额',
            petBalance: '请输入账户余额',
            depositNum: '提现',
            freezeBalance: '冻结金额',
            petFreezeBalance: '冻结金额',
            parentUserName: '上级用户',
            inviteCode: '邀请码',
            registerInfo: '注册信息',
            operation: '操作',

            deduction: '扣款',
            dispatch: '派单',
            bankCardInfo: '银行卡信息',
            sendMessage: '发送消息',
            normalWithdrawal: '正常提现',
            noWithdrawal: '禁止提现',
            setAsRealPerson: '设为真人',
            setAsDummy: '设为假人',
            addressInfo: '地址信息',
            viewPassword: '查看密码',
            viewTeam: '查看团队',
            accountChange: '帐变',

            modifyInvitationCode: '修改邀请码',
            invitationCode: '邀请码',
            petInvitationCode: '请输入邀请码',
            phoneNumber: '手机号码',
            petPhoneNumber: '请输入手机号码',
            userName: '用户名称',
            petUserName: '请输入用户名称',
            operaMount: '金额',
            petOperaMount: '请输入金额',
            operaMountHelp: '正表示加，负表示扣',
            remarks: '备注',
            petRemarks: '请输入备注',
            accountName: '开户名',
            petAccountName: '请输入开户名',
            bankName: '银行名称',
            petBankName: '请输入银行名称',
            bankNumber: '银行编号',
            petBankNumber: '请输入银行编号',
            cardNum: '银行卡号',
            petCardNum: '请输入银行卡号',
            bankCountry: '银行所在国家',
            petBankCountry: '请输入银行所在国家',
            noticeTitle: '标题',
            petNoticeTitle: '请输入标题',
            noticeContent: '内容',
            petNoticeContent: '请输入内容',
            limitAmount: '设定金额',
            petLimitAmount: '请输入设定金额，不能小于100',
            memberLevel: '会员等级',
            password: '登录密码',
            petPassword: '留空不修改密码',
            petPassword2: '请输入登录密码',
            parentUserId: '上级ID',
            petParentUserId: '请输入上级ID',
            createMember: '创建会员',

            address: {
                name: '收货姓名',
                petName: '请输入收货姓名',
                tel: '收货手机',
                petTel: '请输入收货手机',
                address: '详细地址',
                petAddress: '请输入详细地址',
            },

            verify: {
                text1: '设定金额不能为空',
                text2: '设定金额不能小于100',
            }

        },

        level: {
            add: '添加会员等级',
            membersName: '名称',
            petMembersName: '请输入名称',
            icon: '图标',
            uploadPic: '上传图标',
            memberPrice: '会员价格',
            petMemberPrice: '请输入会员价格',
            commission: '佣金比例',
            petCommission: '请输入佣金比例',
            numMin: '最小余额',
            petNumMin: '请输入最小余额',
            orderNum: '接单次数',
            petOrderNum: '请输入接单次数',
            withdrawalTimes: '提现次数',
            petWithdrawalTimes: '请输入提现次数',
            mate: '匹配区间',
            petMateMin: '请输入匹配最小值',
            petMateMax: '请输入匹配最大值',
            withdrawalMin: '提现最小金额',
            petWithdrawalMin: '请输入提现最小金额',
            withdrawalMax: '提现最大金额',
            petWithdrawalMax: '请输入提现最大金额',
            uploadSucceeded: '上传成功',
            registerTime: '注册时间',
            addTitle: '新建会员等级',
        },

        orderList: {
            lno: '订单号',
            petLno: '请输入订单号',
            memberId: '会员ID',
            petMemberId: '请输入会员ID',
            phoneNumber: '手机号',
            petPhoneNumber: '请输入手机号',
            time: '下单时间',
            petTime: '请选择添加时间',
            goodsName: '商品名称',
            goodsCount: '商品数量',
            shopName: '商店名称',
            balance: '余额',
            amount: '交易金额',
            commission: '佣金',
            amountAfterTransaction: '交易后金额',
            addtime: '下单时间',
            endtime: '完成交易时间',
            status: '状态',
            // 订单状态 0待付款 1交易完成 2用户取消 3强制完成 4强制取消 5交易冻结
            status0: '待付款',
            status1: '交易完成',
            status2: '用户取消',
            status3: '强制完成',
            status4: '强制取消',
            status5: '交易冻结',
            qiang: '抢单数',
            sign: '是否卡单',
            sign0: '不卡单',
            sign1: '卡单',
            cStatus: '佣金发放状态',
            // 佣金发放状态 0未发放 1已发放 2账号冻结
            cStatus0: '未发放',
            cStatus1: '已发放',
            cStatus2: '账号冻结',
        },

        // 充值管理
        deposit: {
            orderNo: '订单号',
            petOrderNo: '请输入订单号',
            userAccount: '用户名称',
            petUserAccount: '请输入用户名称',
            phoneNumber: '手机号码',
            petPhoneNumber: '请输入手机号码',
            addTime: '添加时间',
            petAddTime: '请选择添加时间',
            updateBy: '上级用户',
            realName: '真实姓名',
            operaMount: '交易数额',
            createTime: '添加时间',
            paymentMethod: '支付方式',
            operaType: '类型',
            operaType1: '充值',
            operaType2: '减少',
            operaType3: '冻结',
            operaType4: '提取',
            processingTime: '处理时间',
        },

        // 提现管理
        withdrawal: {
            batchPass: '批量通过',
            batchPassSuccess: '批量通过成功',
            batchRejection: '批量拒绝',
            batchRejectionSuccess: '批量拒绝成功',
            orderNo: '订单号',
            petOrderNo: '请输入订单号',
            userAccount: '用户名称',
            petUserAccount: '请输入用户名称',
            startTime: '发起时间',
            petStartTime: '请选择发起时间',
            status1: '待审核',
            status2: '已驳回',
            status3: '已打款',
            adopt: '通过',
            reject: '驳回',
            withdrawalUser: '提现用户',
            superiorUser: '上级用户',
            operaMount: '提现金额',
            withdrawalTimes: '当日提现次数',
            serviceCharge: '手续费',
            actualArrival: '实际到账',
            collectionInfo: '收款信息',
            phoneNumber: '联系电话',
            dealTime: '处理时间',
            status: '状态',
            orderStatus: '订单状态',
            remark: '备注',
            adoptConfirmation: '确定要通过吗?',
            passed: '已通过',
            reasonForRejection: '驳回原因',
            rejected: '已驳回',
        },

        //  交易控制
        tc: {
            basicSettings: '基础设置',
            trc: 'TRC20地址',
            petTrc: '请输入TRC20地址',
            erc: 'ERC20地址',
            petErc: '请输入ERC20地址',
            usdt: 'USDT',
            petUsdt: '请输入USDT',
            wait: '未订单的支付等待时长（秒）',
            petWait: '请输入订单支付等待时长',
            waitHelp: '订单支付等待时长，新下订单未在此时间内容完成支付将会被自动取消',
            generalCommission: '普通会员交易佣金',
            generalCommissionHelp: '交易佣金',
            upOneCommission: '上一级会员交易佣金',
            upTwoCommission: '上二级会员交易佣金',
            upThreeCommission: '上三级会员交易佣金',
            upFourCommission: '上四级会员交易佣金',
            upFiveCommission: '上五级会员交易佣金',
            freeze: '冻结时间',
            violate: '允许违规次数',
            petViolate: '请输入已发货订单自动确认收货时长',
            distributeTime: '提交订单延时时间(单位/秒)',
            distributeTimeText1: ' 远程主机分配时间:',
            distributeTimeText2: ' 等待商家响应时间',
            distributeTimeHelp: '时间由2部分组成,默认都是5秒,总共10秒',
            appAdress: 'app下载地址',
            petAppAdress: '请输入app下载地址',
            version: '版本号',
            petVersion: '请输入版本',
            withdraw: '提现时间',
            petWithdraw: '请选择提现时间范围',
            deposit: '充值时间',
            petDeposit: '请选择充值时间范围',
            convey: '抢单时间',
            petConvey: '请选择抢单时间范围',
            shopStatus: '商城状态',
            petShopStatus: '商城状态: 1开启 0关闭',
            saveText: '保存配置',

        },

    };

    this.getDataMap = function () {
        var k = 'lang_' + this.locale;
        return this[k];
    };


    /**
     * 国际化方法
     * @param {string} key
     * @param {string} [defaultValue]
     */
    this.$t = function (key, defaultValue) {
        var _defaultValue = defaultValue || '';
        try {
            var dataMap = this.getDataMap();
            var keys = (key || '').split('.');
            var text = keys.reduce(function (previousValue, currentValue) {
                return previousValue[currentValue];
            }, dataMap);
            return text || _defaultValue;
        } catch (e) {
            console.warn('$t:', e);
            return _defaultValue;
        }
    }.bind(this)

    this.onRender = function () {
        // var data = this.getDataMap();
        var d = document.querySelectorAll('[data-locale]');
        var p = document.querySelectorAll('[data-placeholder]');
        var $t = this.$t;
        d.forEach(function (d) {
            var key = d.dataset['locale'];
            var value = $t(key);
            d.innerText = value;
            // console.log('key', key, value);
        });
        p.forEach(function (d) {
            var key = d.dataset['placeholder'];
            var value = $t(key);
            d.setAttribute('placeholder', value);
            // console.log('key', key, value);
        });
        // console.log('onRender', data);
        options.onRender && options.onRender(this);
    }

    this.onRender();

    /**
     * 改变语言
     * @param {string} [language=en] 默认英文
     */
    this.onChangeLanguage = function (language) {
        var locale = language || 'en';
        if (this.locale === locale) return;
        this.locale = locale;
        window.localStorage.setItem(this.localKey, locale);

        window.location.reload();
        // this.onRender();
        options.onChange && options.onChange(this.locale)
    }

}

// window.addEventListener('load', function () {
//     var i18n = new I18n({});
//     window.i18n = i18n;
// })

