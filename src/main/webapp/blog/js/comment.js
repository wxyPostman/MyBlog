$(function() {

	//创建评论文本框
	var E = window.wangEditor
	var editor = new E('#editor');
	//	editor.customConfig.menus = [
	//		'emoticon',
	//	];
	editor.create();

	//点击评论事件
	var getId = getQueryString("id");
	document.getElementById('getComment').addEventListener('click', function() {
		inputComment();
	}, false);

	function inputComment() {
		$.ajax({
			url : "../exita.do",
			type : "GET",
			dataType : "json",
			success : function(data) {
				console.log(data);
				if (data) {
					var username = data.username;
					console.log(username);
					userComment(username);
				} else {
					alert("请先登录!");
				}
			}
		});
	}
	function userComment(username) {
		$.ajax({
			url : "../getComment.do",
			type : "POST",
			async : true, //是否为异步请求
			cache : false, //是否缓存结果
			data : {
				html : editor.txt.html(),
				id : getId,
				username : username
			},
			success : function(data) {
				console.log(data);
				if (data == 200) {
					//清楚文本框内容
					editor.txt.clear();
					alert("评论成功!");
					findAllComment();
				} else {
					console.log("评论失败!");
				}
			},
		})
	}

	findAllComment();
	//加载时,获取评论部分
	function findAllComment() {
		$("#userSay_box").empty();
		$.ajax({
			url : "../findAllComment.do",
			type : "GET",
			async : true, //是否为异步请求
			cache : false, //是否缓存结果
			data : {
				id : getId
			},
			dataType : "json",
			success : function(data) {
				console.log(data);
				console.log(data.length);
				for (var i = 0; i < data.length; i++) {
					$("#userSay_box").prepend(
						"<div class='userSay_comment clearfix'>" +
						"<div class='userImg pull-left'>" +
						"<img src= images/" + Math.floor(Math.random() * 10) +".png alt='user'>" +
						"</div>" +
						"<div class='userSay_userName pull-left'>" +
						"<p>" + data[i].username + "</p>" +
						"<p class='gettime'>" + data[i].titleType + "</p>" +
						"</div>" +
						"</div> " +
						"<div class='userSay_title'>" +
						"<p>" + data[i].content + "</p>" +
						"<hr>" +
						"</div> "
					);
				}
			},
		})
	}
})