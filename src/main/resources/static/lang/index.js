

// 默认语言
// var locale = 'en';

// 英文
window.lang_en = {
    login: 'Login',
    userLogin: 'User login',
    backgroundLogin: 'Background login',
    userName: 'user name',
    password: 'password',
    verificationCode: 'Verification Code',
};

// 中文
window.lang_cn = {
    // 登录页
    login: '登录',
    userLogin: '用户登录',
    backgroundLogin: '后台登录',
    userName: '用户名',
    password: '密码',
    verificationCode: '验证码',
};

/**
 *
 * @param options
 * @param {String} [options.locale=en] // 默认语言
 * @param {Function} [options.onChange] // 改变语言时执行
 * @param {Function} [options.onRender]
 * @constructor
 */
function I18n (options) {
    this.locale = options.locale || 'en';

    // 英文
    this.lang_en = {
        language: 'language',
        login: 'Login',
        userLogin: 'User login',
        backgroundLogin: 'Background login',
        userName: 'user name',
        password: 'password',
        verificationCode: 'Verification Code',
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
    };

    // this.k = 'lang_' + this.locale;
    this.getDataMap = function () {
        var k = 'lang_' + this.locale;
        return this[k];
    };


    this.$t = function (key) {
        try {
            var dataMap = this.getDataMap();
            var keys = (key || '').split('.');
            var text = keys.reduce(function (previousValue, currentValue) {
                return previousValue[currentValue];
            }, dataMap);
            return text || key;
        } catch (e) {
            return key;
        }
    }
    this.onRender = function () {
        var data = this.getDataMap();
        var d = document.querySelectorAll('[data-locale]')
        var p = document.querySelectorAll('[data-placeholder]')
        d.forEach(function (d) {
            var key = d.dataset['locale'];
            var value = data[key];
            d.innerText = value;
            console.log('key', key, value);
        });
        p.forEach(function (d) {
            var key = d.dataset['placeholder'];
            var value = data[key];
            d.setAttribute('placeholder', value);
            console.log('key', key, value);
        });
        console.log('onRender', data);
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
        this.onRender();
        options.onChange && options.onChange(this.locale)
    }

    // this.onLoadScript = function (cb) {
    //     var k = 'lang_' + this.locale;
    //     // if (window[k]) {
    //     //     cb && cb(true);
    //     //     return;
    //     // }
    //     var d = document.createElement('script');
    //     var url = '/lang/' + this.locale + '.js?_=' + Date.now();
    //     d.src = location.hostname === 'localhost' ? ('http://localhost:8080' + url) : url;
    //     d.onload = function (e) {
    //         // console.log('onload', e)
    //         cb(true);
    //         // document.removeChild(d);
    //     }
    //     d.onerror = function (e) {
    //         console.log('onerror', e);
    //         cb(false);
    //     }
    //     console.log('document.body.appendChild', d)
    //     document.body.appendChild(d);
    // }

    // this.onLoadScript(function (v) {
    //     if (v) this.onRender();
    // }.bind(this));
}

// window.addEventListener('load', function () {
//     var i18n = new I18n({});
//     window.i18n = i18n;
// })

