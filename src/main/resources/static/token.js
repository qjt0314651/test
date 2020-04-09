var token_get = function (url, callback) {
    $.ajax({
        type: "GET",
        url: url,
        beforeSend: function (request) {
            request.setRequestHeader("TOKEN", cookie.get("token"));
        },
        success: callback
    });
};
var token_post = function (url, param, callback) {
    $.ajax({
        type: "POST",
        url: url,
        data: param,
        beforeSend: function (request) {
            request.setRequestHeader("TOKEN", cookie.get("token"));
        },
        success: callback
    });
};

// 设置登录的cookie信息
var set_login = function (TOKEN, NICK_NAME) {
    cookie.set("token", TOKEN, 1);
    cookie.set("nickname", NICK_NAME, 1);
}
// 验证是否登陆
var check_login = function () {
    if (cookie.get("token") != undefined && cookie.get("nickname") != undefined) {
        return true;
    }
    return false;
};
var logout = function () {
    // cookie.delete("TOKEN");
    // cookie.delete("NICK_NAME");
    cookie.clear();
    toLogin();
}

function getToken() {
    return cookie.get("token");
}

// 去主页面
function toLogin() {
    layer.open({
        type:2,
        content : "<%=request.getContextPath()%>/user/toLogin",
        title : '登录',
        shade : 0.6
    });
}

// Ajax请求 返回拦截
$.ajaxSetup({
    type: "POST",
    error: function (jqXHR, textStatus, errorMsg) {  // 出错时默认的处理函数
        // jqXHR 是经过jQuery封装的XMLHttpRequest对象
        // textStatus 可能为： null、"timeout"、"error"、"abort"或"parsererror"
        // errorMsg 可能为： "Not Found"、"Internal Server Error"等
        switch (jqXHR.status) {
            case(500):
                alert("服务器系统内部错误");
                break;
            case(401):
                alert("未登录");
                logout();
                break;
            case(403):
                alert("当前用户没有权限");
                break;
            case(408):
                alert("请求超时");
                break;
            default:
                alert("未知错误");
        }
    }
});

