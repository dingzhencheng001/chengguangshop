// 判断table选中值
function getTableRows(obj, arr) {
    if (arr === 1) {
        if (obj.data.length === 0 || obj.data.length > 1) {
            layer.msg("请选择一条数据!", {icon: 5});
            return false;
        }
    } else {
        if (obj.data.length === 0) {
            layer.msg("请选择一条数据!", {icon: 5});
            return false;
        }
    }
    return obj.data[0];
}
// 定义全局变量 文件下载
jQuery.download = function (url, method, id) {
    jQuery('<form action="' + url + '" method="' + (method || 'post') + '">' +
        '<input type="text" name="id" value="' + id + '"/>' +
        '</form>')
        .appendTo('body').submit().remove();
};



/**
 * 请求成功时的回调
 * @callback successCallback
 * @param {Object} result
 * @param {Number} status
 * @param {Object} xhr
 */

/**
 * 请求错误时的回调
 * @callback errorCallback
 * @param {Object} xhr
 * @param {Number} status
 * @param {Error} error
 */

/**
 * 请求结束时
 * @callback completeCallback
 * @param {Object} xhr
 * @param {Number} status
 */

/**
 * 根据接口约定 修改了success、error、complete、fail方法
 * @param {Object} options
 * @param {String} options.url - 接口地址
 * @param {String} [options.type=get] - 请求类型 get | post
 * @param {Object} [options.data={}] - 请求时携带的数据
 * @param {successCallback} [options.success] - 请求成功，并且code等于200
 * @param {successCallback} [options.fail] - 请求成功，并且code不等于200
 * @param {errorCallback} [options.error] - 请求失败
 * @param {completeCallback} [options.complete] - 请求完成时运行的函数
 * @param {String} [options.contentType=application/json] - contentType
 */
jQuery.request = function (options) {
    var data = typeof options.data === 'object' ? JSON.stringify(options.data) : options.data;
    return $.ajax(Object.assign({}, options, {
        // url: options.url,
        url: 'http://localhost:8080' + options.url, // 开发环境使用
        type: options.type || 'get',
        data: data,
        contentType: options.contentType || 'application/json',
        success: function (result, status, xhr) {
            if (result.code === 200) {
                options.success && options.success(result, status, xhr);
            } else {
                if (options.fail) {
                    options.fail(result, status, xhr);
                } else {
                    layer.msg(result.message || result.msg, {icon: 2});
                }
            }
            options.complete && options.complete(status, xhr);
        },
        error: function (xhr,status,error) {
            if (options.error) {
                options.error(xhr, status, error);
            } else {
                layer.msg('请求错误', {icon: 2});
            }
        }
    }))
};

/**
 * 获取url上的参数
 * @param [strUrl] - window.location.href
 * @returns {{}}
 */
$.getUrlVars = function (strUrl) {
    var vars = {};
    var hash;
    var url = strUrl || window.location.href;
    if (url.indexOf('?') === -1) return vars;
    var str = url.split('?')[1];
    var hashes = str.split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        var key = hash[0];
        var value = '';
        try {
            value = decodeURIComponent(hash[1]);
        } catch (e) {
            // ！！！如果有非法字符 那么先使用encodeURIComponent
            value = '';
        }
        if (value && value.indexOf('[') >= 0 && value.indexOf(']') >= 0) {
            try {
                vars[key] = JSON.parse(value);
            } catch (e) {
                // console.error('getUrlVars err：', e);
            }
        } else {
            vars[key] = value;
        }
    }
    return vars;
};

$.tableRenderConfing = {
    loading: true, // 开启loading
    request: {
        pageName: 'pageNum', //页码的参数名称，默认：page
        limitName: 'pageSize', //每页数据量的参数名，默认：limit
    },
    parseData: function (res) {
        var msg, code, count, data;
        if (res.code === 200) {
            code = 0;
            msg = res.message;
            count = res.data.total;
            data = res.data.list;
        } else {
            code = res.code;
            msg = res.msg;
            count = 0;
            data = [];
        }
        return {
            "code": code, //解析接口状态
            "msg": msg, //解析提示文本
            "count": count, //解析数据长度
            "data": data //解析数据列表
        };
    }
}