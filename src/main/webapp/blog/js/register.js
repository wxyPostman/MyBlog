//倒计时
var countdown = 60;

function sendemail() {
	var obj = $("#get_phone_num");
	settime(obj);
}
function settime(obj) { //发送验证码倒计时
	if(countdown == 0) {
		obj.attr('disabled', false);
		//obj.removeattr("disabled"); 
		obj.val("免费获取验证码");
		countdown = 60;
		return;
	} else {
		obj.attr('disabled', true);
		obj.val("重新发送(" + countdown + ")");
		countdown--;
	}
	setTimeout(function() {
		settime(obj)
	}, 1000)
}

$("#register_username").blur(function() {
	var register_username = $("#register_username").val();
	if (!/^[a-zA-Z0-9\u4e00-\u9fa5]{2,6}$/.test($("#register_username").val())) {
		$("#usernameTip").text("用户名为 2-6 位");
		$("#usernameTip").css("display", "block");

	} else {
		$.ajax({
			data : {
				username : register_username
			},
			url : "../check.do",
			type : "POST",
			dataType : "json",
			async : true, //是否为异步请求
			cache : false, //是否缓存结果
			success : function(data) {
				$("#usernameTip").text(data);
				$("#usernameTip").css("display", "block");
			}
		})
	}
});
$("#register_password").blur(function() {
	var register_password = $("#register_password").val();
	if (!/^[a-zA-Z0-9]{6,16}$/.test($("#register_password").val())) {
		$("#passwordTip").text("密码为 6-16 位");
		$("#passwordTip").css("display", "block");

	} else {
		$("#passwordTip").text("");
		$("#passwordTip").css("display", "block");
	}
});
var phoness = "";
$("#register_phone").blur(function() {
	var register_phone = $("#register_phone").val();
	if (!/^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/.test($("#register_phone").val())) {
		$("#phoneTip").text("电话号码不正确");
		$("#phoneTip").css("display", "block");
	} else {
		$.ajax({
			data : {
				phone : register_phone,
				op : "check_phone"
			},
			url : "../phone.do",
			type : "POST",
			dataType : "json",
			async : true, //是否为异步请求
			cache : false, //是否缓存结果
			success : function(data) {
				if (data ==200) {
					phoness = data;
					$("#phoneTip").text("");
					$("#phoneTip").css("display", "block");
				} else {
					phoness = data;
					$("#phoneTip").text("手机号码被占用，请更换!");
					$("#phoneTip").css("display", "block");
				}
			}
		})
	}
});
$("#get_phone_num").click(function() {
	if (phoness==400) {
		$("#phoneTip").text(phoness);
		$("#phoneTip").css("display", "block");
	} else {
		Captcha();
		sendemail();
	}
});
var cap = "";
function Captcha() {
	var phone = $("#register_phone").val();
	$.ajax({
		data : {
			phone : phone,
		},
		url : "../captcha.do",
		type : "POST",
		success : function(data) {
			//alert("发送成功！")
			cap = data;
			
		}
	})
	return cap;
}
function register(){
	var username = $("#register_username").val();
	var password = $("#register_password").val();
	var phone = $("#register_phone").val();
	var captcha = $("#captcha").val();
	var id = 0;
	if ((username == "undefined" || username == null || username == "") ||
		(password == "undefined" || password == null || password == "") ||
		(phone == "undefined" || phone == null || phone == "") ||
		(captcha == "undefined" || captcha == null || captcha == "")
	) {
		if (username == "undefined" || username == null || username == "") {
			$("#usernameTip").text("用户名不能为空！");
			$("#usernameTip").css("display", "block");
		} else {
			$("#usernameTip").text("");
		//$("#usernameTip").css("display","none");
		}
		if (password == "undefined" || password == null || password == "") {
			$("#passwordTip").text("密码不能为空！");
			$("#passwordTip").css("display", "block");
		} else {
			$("#passwordTip").text("");
		}
		if (phone == "undefined" || phone == null || phone == "") {
			$("#phoneTip").text("手机号不能为空！");
			$("#phoneTip").css("display", "block");
		} else {
			$("#phoneTip").text("");
			$("#phoneTip").css("display", "none");
		}
		if (captcha == "undefined" || captcha == null || captcha == "") {
			$("#captchaTip").text("请输入验证码！");
			$("#captchaTip").css("display", "block");
		} else {
			$("#captchaTip").text("");
		}
	} else {
		
		if (captcha != cap) {
			$("#captchaTip").text("请输入正确的验证码！");
			$("#captchaTip").css("display", "block");
		} else {
			$.ajax({
				data : {
					id : id,
					username : username,
					password : password,
					phone : phone
				},
				url : "../reg.do",
				type : "POST",
				dataType : "json",
				success : function(data) {
					alert(data);
					setValNull()
					$("#registerModel").modal("hide");
				}
			});
		}
	}
}
$("#register_btn").click(function() {
	register()
});
$("#captcha").keypress(function(event) {
	var keynum = (event.keyCode ? event.keyCode : event.which);
	if (keynum == '13') {
		register()
	} 
})
function setValNull() {
	$("#register_username").val("");
	$("#register_password").val("");
	$("#register_phone").val("");
	$("#captcha").val("");
}

//登录

function login(){
	var phone = $("#login_phone").val();
	var password = $("#login_password").val();
	if (!/^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/.test(phone)) {
		$("#loginTip").text("电话号码不正确");
		$("#loginTip").css("display", "block");
	} else {
		$("#loginTip").text("");
		$("#loginTip").css("display", "block");
		if (!/^[a-zA-Z0-9]{6,16}$/.test(password)) {
			$("#loginpasseordTip").text("密码为 6-16 位");
			$("#loginpasseordTip").css("display", "block");
		} else {
			$("#loginpasseordTip").text("");
			$("#loginpasseordTip").css("display", "block");
			$.ajax({
				data : {
					phone : phone,
					password : password
				},
				url : "../login.do",
				type : "POST",
				dataType : "json",
				success : function(data) {
					//console.log(data);
					if (data == 200) {
						$("#loginModel").modal("hide");
						$("#login_success").css("display","none");
						alert("登录成功");
						$("#login_register").css("display","block");
						LoginsetValNull();
					} else if (data == 500) {
						alert("没有该账号,请前往注册!")
						$("#loginModel").modal("hide");
					} else {
						$("#loginTip").text("电话号码或密码错误！");
						$("#loginTip").css("display", "block");
					}
				}
			})
		}
	}
}
$("#login_btn").click(function() {
	login()
})
$("#login_password").keypress(function(event) {
	var keynum = (event.keyCode ? event.keyCode : event.which);
	if (keynum == '13') {
		login()
	} 
})
function LoginsetValNull() {
	$("login_phone").val("");
	$("login_password").val("");
}


