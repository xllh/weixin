<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/admin/css/main.css" />
<title>Insert title here</title>
<script type="text/javascript">
	function logout(){
		if(window.confirm("确定注销登录么？")){
			window.location.href = "/admin/logOut";
		}else{
			return false;
		}
	}
</script>
</head>
<body>
		<%	String email = request.getSession().getAttribute("email").toString();
			User user = User.ME.getByEmail(email); %>
		<span class="toolbar">
		管理员：<a href="javascript:void(0);" title="<%=email%>"><%=user.get("name") %></a>&nbsp;|&nbsp;
			  <a href="javascript:void(0);" onclick="logout()">注销</a>
		</span>
		<h1>博客管理后台</h1>
		<span class="clear"></span>
</body>
</html>