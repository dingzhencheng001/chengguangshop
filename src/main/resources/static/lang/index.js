

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
        language: 'language',
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
        theme: 'theme',
        default: 'default',
        orange: 'orange',
        green: 'green',
        pink: 'pink',
        blue: 'blue',
        red: 'red',
        basicInfo: 'Basic info',
        modifyPassword: 'Modify Password',
        logout: 'logout',
        home: 'home',
        operation: 'operation',
        refreshCurrentTab: 'Refresh Current Tab',
        closeCurrentTab: 'Close Current Tab',
        closeOtherTab: 'Close Other Tab',
        closeAllTab: 'Close All Tab',

        //
        edit: 'edit',
        delete: 'delete',
        search: 'search',
        conditionalSearch: 'conditional search',
        // goodsId: 'Goods ID',
        // productName: 'Product Name',
        pleaseEnterThe: 'Please Enter The',
        pleaseSelectThe: 'Please Select The',
        operationConfirmation: 'Operation confirmation',
        deleteConfirmation: 'Are you sure you want to delete?',
        confirm: 'confirm',
        cancel: 'cancel',
        deleteSucceeded: 'Delete succeeded',

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
        search: '搜索',
        conditionalSearch: '条件搜索',
        pleaseEnterThe: '请输入',
        pleaseSelectThe: '请选择',
        operationConfirmation: '操作确认',
        deleteConfirmation: '确定要删除吗?',
        confirm: '确定',
        cancel: '取消',
        deleteSucceeded: '删除成功',

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
