layui.use(['form', 'layer', 'dropdown'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;
    var dropdown = layui.dropdown;

    var i18n = new I18n({
        // 渲染时改变title
        onRender: function (othis) {
            document.title = othis.$t('userLogin');
        },
    });
    window.i18n = i18n;
    var loginSucceeded = i18n.$t('loginSucceeded');

    dropdown.render({
        elem: '#language' //可绑定在任意元素中，此处以上述按钮为例
        ,data: [
            {
                title: 'english',
                value: 'en',
            },
            {
                title: '简体中文',
                value: 'cn',
            },
        ]
        ,id: 'language'
        //菜单被点击的事件
        ,click: function(obj) {
            i18n.onChangeLanguage(obj.value);
        }
    });

    var onSubmit = $.debounce(function (data) {
        var params = "username=" + data.field.username + "&password=" + data.field.password + "&captcha=" + data.field.captcha;
        $('#loginBtn').addClass('layui-btn-disabled');
        $('#loginBtn').attr('disabled', true);
        $.ajax({
            type: "POST",
            url: "/sys/login",
            data: params,
            dataType: "json",
            success: function (result) {
                if (result.code === 0) {
                    layer.msg(loginSucceeded, {
                        icon: 1
                        , time: 1000
                    }, function () {
                        location.href = '/index'; //后台主页
                    });
                } else {
                    layer.msg(result.msg, {icon: 5});
                    refreshCode();
                }
            },
            complete: function () {
                $('#loginBtn').removeClass('layui-btn-disabled');
                $('#loginBtn').attr('disabled', false);
            },
        });
    }, 300, true);

    //登录按钮事件
    form.on("submit(login)", function (data) {
        onSubmit(data);
        return false;
    });
});
function refreshCode(){
    var captcha = document.getElementById("captcha");
    captcha.src = "/captcha.jpg?t=" + new Date().getTime();
}
