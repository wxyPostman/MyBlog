$.ajax({
    url:"../indexcontentall.do",
    type:"GET",
    async : true, //是否为异步请求
    cache : false, //是否缓存结果
    dataType : "json",

    success:function(data){
      
        $("#ll").empty();

        if(data.list.length>0){
            $("#ll").append(
                "<thead>"+
                "<tr>"+
                "<th>"+"标题"+"</th>"+
                "<th>"+"内容"+"</th>"+
                "<th>"+"语言类型"+"</th>"+
                " <th>"+"操作"+"</th>"+
                "</tr>"+
                "</thead>"
            )
            for(let i=0;i<data.list.length;i++){
                var dateA=data.list[i].pubdate;
                console.log(dateA);
                $("#ll").append(
                    "<tbody>"+
                    "<tr>"+
                    "<td>"+data.list[i].title+"</td>"+
                    "<td>"+ data.list[i].content+"</td>"+
                    "<td>"+ data.list[i].type+"</td>"+
                    "<td>"+ "<button class='btn btn-danger' onclick='sdelete("+data.list[i].ccid+")'>"+"删除"+"</button>"+"</td>"+
                    "</tr>"+
                    "</tbody>"+
                    "<br/>"
                )
            }
            $("#pagingfile").append(
					"<p>" + "当前" + data.pageNum + "页，总" + data.pages + "页，总" + data.total + "条记录" + "</p>" +
					"<li><button class='btn btn-default' onclick=first(" + data.firstPage + ")>" + "第一页" + "</button></li>" +
					"<li><button class='btn btn-default' onclick=previous(" + (data.pageNum - 1) + ")>" + "上一页" + "</button></li>" +
					"<li><button class='btn btn-default' onclick=next(" + (data.pageNum + 1) + ")>" + "下一页" + "</button></li>" +
					"<li><button class='btn btn-default' onclick=last(" + data.lastPage + ")>" + "最后一页" + "</button></li>"
				)
        }else{
            alert("没有查找到数据");
        }
    }
})

//分页
function page(pageNo) {
	$.ajax({
		data : {
			pageNo : pageNo
		},
		url : "../indexcontentall.do",
		type : "POST",
		async : true, //是否为异步请求
		cache : false, //是否缓存结果
		dataType : "json",
		success : function(data) {

	        $("#ll").empty();

	        if(data.list.length>0){
	            $("#ll").append(
	                "<thead>"+
	                "<tr>"+
	                "<th>"+"标题"+"</th>"+
	                "<th>"+"内容"+"</th>"+
	                "<th>"+"语言类型"+"</th>"+
	                " <th>"+"操作"+"</th>"+
	                "</tr>"+
	                "</thead>"
	            )
	            for(let i=0;i<data.list.length;i++){
	                var dateA=data.list[i].pubdate;
	                console.log(dateA);
	                $("#ll").append(
	                    "<tbody>"+
	                    "<tr>"+
	                    "<td>"+data.list[i].title+"</td>"+
	                    "<td>"+ data.list[i].content+"</td>"+
	                    "<td>"+ data.list[i].type+"</td>"+
	                    "<td>"+ "<button class='btn btn-danger' onclick='sdelete("+data.list[i].ccid+")'>"+"删除"+"</button>"+"</td>"+
	                    "</tr>"+
	                    "</tbody>"+
	                    "<br/>"
	                )
	           }

			} else {
				alert("没有查找到数据");
			}
		}
	})

}
function first(t) {
	page(t);
}
function last(t) {
	page(t);
}
function previous(t) {
	page(t);
}
function next(t) {
	page(t);
}
function sdelete(t){
    $.ajax({
        data:{
            ccid:t
        },
        url : "../delcontent.do",
        type : "POST",
        async : true, //是否为异步请求
        cache : false, //是否缓存结果

        success : function(data) {
            alert(data)
            location.reload();
        }
    })
}





