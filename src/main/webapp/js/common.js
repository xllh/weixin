function good(id){
	if(id>0){
		$.ajax({
			type:"post",
			url:"/action/blogGood",
			data:"id="+id,success:function(){
				var goodCount = $("#good_count_"+id);
				goodCount.html(parseInt(goodCount.html())+1);
			}
		});
	}
}
function bad(id){
	if(id>0){
		$.ajax({
			type:"post",
			url:"/action/blogBad",
			data:"id="+id,
			success:function(){
				var badCount = $("#bad_count_"+id);
				badCount.html(parseInt(badCount.html())+1);
			}
		});
	}
}