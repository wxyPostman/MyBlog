$(function(){
	$.ajax({
		type : 'GET',
		contentType : false,
		processData : false,
		url : 'https://api.uomg.com/api/rand.avatar?sort=动漫男&format=json',
		dataType : 'json',
		success : function(data) {
			console.log(data.imgurl);
			if (data) {
				$("#authImg").append("<img src='" + data.imgurl + "' alt='user'>");
				$("#getImg").append("<img src='" + data.imgurl + "' alt='user'>" +
						"<i class='fa fa-sort-desc' aria-hidden='true'></i>");
			} else {
				$("#authImg").append("<img src='images/userimg.jpg' alt='user'>");
				$("#getImg").append("<img src='images/userimg.jpg' alt='user'>" +
				"<i class='fa fa-sort-desc' aria-hidden='true'></i>");;
			}
		}
	})
})