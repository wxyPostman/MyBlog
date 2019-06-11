$(function() {
	var getId= getQueryString("id");
	var s=$("#title").val();
	console.log(s);
	$.ajax({
		data : {
			id:getId
		},
		url : "../readFile.do",
		type : "GET",
		async : true, //是否为异步请求
		cache : false, //是否缓存结果
		dataType : "html",
		beforeSend : function() {
			$("#base").show();
		},
		success : function(data) {
			$("#getMd_info").html(marked(data));

		},
		error : function(res) {
			console.log(res);
		},
		complete : function() {
			$("#base").hide();
		},
	})

})
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = decodeURI(window.location.search).substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
