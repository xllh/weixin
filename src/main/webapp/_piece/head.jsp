<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>阅读笔记-星星之火博客</title>
</head>
<body>
	<%String catalog = request.getParameter("catalog"); %>
	<div id="logo"><h1>星星博客<small>（星星之火，可以燎原）</small></h1></div>
	<div id="nav">
		<ul class="nav nav-tabs " role="tablist">
			<li <%if(catalog.equalsIgnoreCase("index")){ %>class="active"<%} %>><a href="/">首页</a></li>
			<li <%if(catalog.equalsIgnoreCase("linux")){ %>class="active"<%} %>><a href="/linux">Linux</a></li>
			<li <%if(catalog.equalsIgnoreCase("java")){ %>class="active"<%} %>><a href="/java">Java</a></li>
			<li <%if(catalog.equalsIgnoreCase("devtool")){ %>class="active"<%} %>><a href="/devtool">开发工具</a></li>
			<li <%if(catalog.equalsIgnoreCase("read")){ %>class="active"<%} %>><a href="/read">读书笔记</a></li>
			<li <%if(catalog.equalsIgnoreCase("uncatalog")){ %>class="active"<%} %>><a href="/uncatalog">随笔</a></li>
		</ul>
		<div class="clear"></div>
	</div>
</body>
</html>