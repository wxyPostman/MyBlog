$(document).ready(function() {
	
	$("#userinfo_btn").click(function() {
		var userinfo_title = $("#userinfo_title").val().trim();
		var textContent = $("#textContent").val().trim();
		var userinfo_language = $("#userinfo_language").val().trim();
		var upFiles = document.getElementById("userinfo_file").files;
		var params = new FormData();
		params.append('file', upFiles[0]);
		params.append('userinfo_title', userinfo_title);
		params.append('textContent', textContent);
		params.append('userinfo_language', userinfo_language);
		$.ajax({
			type : 'POST',
			contentType : false,
			processData : false,
			url : '../upload.do',
			dataType : "text",
			data : params,
			success : function(data) {
				if (data == "ok") {
					alert("上传成功!");
					vall();
				}
			},
			error : function() {
				alert("上传失败!");
			}
		})
	})
})

function vall() {
	$("#userinfo_title").val("");
	$("#textContent").val("");
	$("#userinfo_language").val("");
}