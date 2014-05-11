<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<script type="text/javascript" src="/tool/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/tool/jquery.form.js"></script>
<script type="text/javascript" src="/tool/sha1.js"></script>
</head>
<body>
	<div id="head">
		<jsp:include page="/admin/_piece/head.jsp" />
	</div>
	<div id="main">
		<div id="left">
			<jsp:include page="/admin/_piece/left.jsp" />
		</div>
		<div id="right">
			<form id="addUserForm">
				<table>
					<tr>
						<td>邮箱：</td>
						<td><input type="text" name="email" value="" /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password" value="" /></td>
					</tr>
					<tr>
						<td>昵称：</td>
						<td><input type="text" name="name" value="豆" /></td>
					</tr>
					<tr>
						<td><input type="reset" value="重置"/></td>
						<td><input type="submit" value="添加"/></td>
					</tr>
					<tr>
						<td colspan="2"><span id="tips"></span></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="foot">
		<jsp:include page="/admin/_piece/foot.jsp" />
	</div>
<script type="text/javascript"> 
    $(document).ready(function(){
    	var options = {
    		url: "/admin/addUser",
    		type: "post",
    		dataType: "json",
    		target: "#tips",
    		beforeSubmit:function(formData, jqForm, options){
    			var email = $("input[name=email]").val();
    			var password = $("input[name=password]").val();
    			var tips = $("#tips");
    			if(email == ""){
    				tips.html("请输入邮箱");
    				return false;
    			}
    			if(password == ""){
    				tips.html("请输入密码");
    				return false;
    			}
    			for(var i=0; i < formData.length; i++){
    				if(formData[i].name == "password"){
    					formData[i].value = CryptoJS.SHA1(password);
    				}
    			}
    			var RegExp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    			if(!RegExp.test(email)){
    				tips.html("邮箱格式错误");
    				return false;
    			}
    			return true;
    		},
    		success: function(responseText,statusText){
 	   			alert(statusText+"-"+responseText);
    		}
    	};
        $('#addUserForm').ajaxForm(options); 
    }); 
</script>
</body>
</html>