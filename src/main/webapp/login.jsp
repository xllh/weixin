<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="/tool/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="/tool/jquery.form.js"></script>
<script type="text/javascript" src="/tool/sha1.js"></script>
</head>
<body class="container">
<div id="form" class="row">
	<form id="loginForm" class="col-md-4 col-md-offset-4" role="form">
		<h1>博客登录</h1>
		<div class="form-group">
			<span id="tips" style="color:red;"></span>
		</div>
		<div class="form-group has-feedback">
			<label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
			<input type="text" name="email" class="form-control" id="email" />
			<span class="glyphicon form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
			<label for="passwrod">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
			<input type="password" name="password" class="form-control" id="password" />
			<span class="glyphicon form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
				<label for="answer">验证码：</label>
				<input type="text" name="answer" class="form-control" id="answer" />
				<span class="glyphicon form-control-feedback"></span>
		</div>
		<div class="form-group" class="row">
			<img id="captcha" class="col-md-6" src="/action/imgCaptcha" /><label id="freshCaptcha" class="col-md-6" onclick="freshCaptcha()">换一张</label>
		</div>
		<div class="form-group" class="row">
			<input type="submit" class="btn btn-default col-md-12" value="登录" />
		</div>
	</form>
</div>
<script type="text/javascript">
	function freshCaptcha(){
		$("#captcha").attr("src", "/action/imgCaptcha");
	}
    $(document).ready(function(){
    	$("#email").focus();
    	var options = {
    		url: "/action/login",
    		type: "post",
    		dataType: "json",
    		target: "#tips",
    		beforeSubmit:function(formData, jqForm, options){
    			var email = $("input[name=email]").val();
    			var password = $("input[name=password]").val();
    			var answer = $("input[name=answer]").val();
    			var tips = $("#tips");
    			$("#email").parent().removeClass("has-warning has-success has-error");
				$("#email").next(".glyphicon").removeClass("glyphicon-ok glyphicon-warning-sign glyphicon-remove");
				$("#password").parent().removeClass("has-warning has-success has-error");
				$("#password").next(".glyphicon").removeClass("glyphicon-ok glyphicon-warning-sign glyphicon-remove");
				$("#answer").parent().removeClass("has-warning has-success has-error");
				$("#answer").next(".glyphicon").removeClass("glyphicon-ok glyphicon-warning-sign glyphicon-remove");
    			if(email == ""){
    				tips.html("请输入邮箱");
    				$("#email").focus();
    				$("#email").parent().addClass("has-warning");
    				$("#email").next(".glyphicon").addClass("glyphicon-warning-sign");
    				return false;
    			}
    			if(password == ""){
    				tips.html("请输入密码");
    				$("#password").focus();
    				$("#password").parent().addClass("has-warning");
    				$("#password").next(".glyphicon").addClass("glyphicon-warning-sign");
    				return false;
    			}
    			if(answer == ""){
    				tips.html("请输入验证码");
    				$("#answer").focus();
    				$("#answer").parent().addClass("has-warning");
    				$("#answer").next(".glyphicon").addClass("glyphicon-warning-sign");
    				return false;
    			}
    			var RegExp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    			if(!RegExp.test(email)){
    				tips.html("邮箱格式错误");
    				$("#email").focus();
    				$("#email").parent().addClass("has-warning");
    				$("#email").next(".glyphicon").addClass("glyphicon-warning-sign");
    				return false;
    			}
    			for(var i=0; i < formData.length; i++){
    				if(formData[i].name == "password"){
    					formData[i].value = CryptoJS.SHA1(password);
    				}
    			}
    			return true;
    		},
    		success: function(responseText,statusText){
    			var tips = $("#tips");
    			if(statusText == "success"){
    				if(responseText.status == "fail"){
    					tips.html("邮箱或密码错误！");
    					$("#email").val("");
    					$("#password").val("");
    					$("#email").focus();
        				$("#email").parent().addClass("has-error");
        				$("#email").next(".glyphicon").addClass("glyphicon-remove");
        				$("#password").parent().addClass("has-error");
        				$("#password").next(".glyphicon").addClass("glyphicon-remove");
    				}else if(responseText.status == "answer_wrong"){
    					tips.html("验证码错误！");
    					$("#answer").focus();
        				$("#answer").parent().addClass("has-error");
        				$("#answer").next(".glyphicon").addClass("glyphicon-remove");
    				}else{
    					window.location.href = responseText.status;
    				}
    			}else{
    				tips.html("网络出错！请重试！");
    			}
    			//刷新验证码
    			freshCaptcha();
    		}
    	};
        $('#loginForm').ajaxForm(options); 
    });
</script>
</body>
</html>