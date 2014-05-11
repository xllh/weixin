<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>阅读笔记-星星之火博客</title>
</head>
<body>
	<%String catalog = request.getParameter("catalog"); %>
	<div id="logo">星星博客</div>
	<div id="nav">
		<ul>
			<li <%if(catalog.equalsIgnoreCase("index")){ %>class="current"<%} %>><a href="/">首页</a></li>
			<li <%if(catalog.equalsIgnoreCase("linux")){ %>class="current"<%} %>><a href="/linux">Linux</a></li>
			<li <%if(catalog.equalsIgnoreCase("java")){ %>class="current"<%} %>><a href="/java">Java</a></li>
			<li <%if(catalog.equalsIgnoreCase("devtool")){ %>class="current"<%} %>><a href="/devtool">开发工具</a></li>
			<li <%if(catalog.equalsIgnoreCase("read")){ %>class="current"<%} %>><a href="/read">读书笔记</a></li>
			<li <%if(catalog.equalsIgnoreCase("uncatalog")){ %>class="current"<%} %>><a href="/uncatalog">随笔</a></li>
		</ul>
		<div class="clear"></div>
	</div>
</body>
</html>