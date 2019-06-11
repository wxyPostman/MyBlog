var ajax = {
    get: function (url, successCallBack, failCallBack) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", url, true);
        xhr.onreadystatechange = function () {
            //xhr.readyState 的值有0 1 2 3 4
            if (xhr.readyState == 4) {
                //判断xhr.status的响应码
                if (xhr.status == 200 || xhr.status == 304) {
                    //判断successCallBack 是否传递了一个函数
                    if (typeof successCallBack == "function") {
                        //将xhr.responseText的信息交给用户回调函数处理
                        successCallBack(xhr.responseText, xhr);
                    } else if (typeof failCallBack == "function") {
                        //将xhr.responseText的信息交给用户回调函数处理
                        failCallBack(xhr.responseText, xhr);
                    }
                }

            }
        };
        xhr.send(null);
    },
    post: function (url, data, successCallBack, failCallBack) {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", url, true);
        xhr.onreadystatechange = function () {
            //xhr.readyState 的值有0 1 2 3 4
            if (xhr.readyState == 4) {
                //判断xhr.status的响应码
                if (xhr.status == 200 || xhr.status == 304) {
                    //判断successCallBack 是否传递了一个函数
                    if (typeof successCallBack == "function") {
                        //将xhr.responseText的信息交给用户回调函数处理
                        successCallBack(xhr.responseText, xhr);
                    } else if (typeof failCallBack == "function") {
                        //将xhr.responseText的信息交给用户回调函数处理
                        failCallBack(xhr.responseText, xhr);
                    }
                }

            }
        };
        //设置请求头,这行代码,一定要在open之后, send之前调用.
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(data);
    }
};
$(function () {
    $("#chat_btn").click(function () {
        chatRobot();
    })

})

function goPost() {

}

function chatRobot() {
    var paras = "key=fb6b7bcfbe52fccdb7f5d752a3088f75&userid=Fengmaybe&info=" + $("#chatRubber").val().trim();
    if ($("#chatRubber").val().trim() != null && $("#chatRubber").val().trim() != "" && $("#chatRubber").val().trim() != undefined) {
        $("#msg_total").append(
            "<div class='msg_mine clearfix'>" +
            "<img src='images/userimg.jpg' alt='mine' class='pull-right'>" +
            "<p class='pull-right'>" +
            $("#chatRubber").val().trim() +
            "</p>" +
            "</div>"
        );
        $("#chatRubber").val("");
        ajax.post("http://www.tuling123.com/openapi/api", paras, function (content, xhr) {
            var obj = JSON.parse(content);
            $("#msg_total").append(
                "<div class='msg_robot'>" +
                "<div class='chat_box_content_left clearfix'>" +
                "<img src='images/robot.png' alt='robot' class='pull-left'>" +
                " <p>" +
                obj.text +
                "</p>" +
                "</div>" +
                "</div>"
            );
            var msg_total = document.querySelector("#msg_total");
            autoScroll(msg_total);
        });
    }
}
document.onkeydown = function (event) {
    if (event.keyCode == 13) {
        chatRobot();
    }
}
// 让指定的元素自动滚动 
function autoScroll(parentEle) {
    setTimeout(function step() {
        //注意scrollTop不是CSS的属性是js的属性,是没有单位的
        var top = parentEle.scrollTop;
        parentEle.scrollTop += top + 2;
        //设置定时器关闭的条件
        if (top == parentEle.scrollTop) return;
        setTimeout(step, 20);
    }, 0)
}