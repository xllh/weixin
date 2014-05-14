<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<script type="text/javascript" src="/tool/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/tool/jquery.form.js"></script>
<script type="text/javascript" src="/tool/sha1.js"></script>
<style>
	*{font-family:微软雅黑, Verdana, sans-serif, 宋体;font-size:12pt;padding:0;margin:0;}
	#form{position:absolute;left:50%;top:50%;margin-left:-171px;margin-top:-136px;width:265px;border:1px solid #666;padding:10px 20px;}
	#form table caption{text-align:left;padding:10px 0;font-size:14pt;}
	#form input[type="submit"]{padding:4px 10px;width:100%;}
	#tips{display:inline-block;line-height:26px;margin-top:10px;color:red;}
	img#captcha{width:120px;height:35px;margin-left:66px;}
	a#freshCaptcha{cursor:pointer;color:#FFC50E;text-align:right;margin-left:8px;}
	a#freshCaptcha:hover{color:#FFA80E;}
	table tr{height:30px;line-height:30px;}
</style>
</head>
<body>
<div id="form">
	<form id="loginForm">
		<table>
			<caption>博客登录</caption>
			<tr>
				<td>邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="answer" /></td>
			</tr>
			<tr>
				<td colspan="2"><img id="captcha" src="/action/imgCaptcha" /><a id="freshCaptcha" onclick="freshCaptcha()">换一张</a></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录" /><span id="tips"></span></td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
	function freshCaptcha(){
		$("#captcha").attr("src", "/action/imgCaptcha");
	}
    $(document).ready(function(){
    	var options = {
    		url: "/action/login",
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
    			var RegExp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    			if(!RegExp.test(email)){
    				tips.html("邮箱格式错误");
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
    				}else if(responseText.status == "answer_wrong"){
    					tips.html("验证码错误！");
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