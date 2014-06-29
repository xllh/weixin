<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<title>-博客</title>
</head>
<body class="container">
	<%
		int blogId = Integer.parseInt(request.getParameter("id"));
		Blog blog = Blog.getById(blogId);
		if(blog != null){
	%>
	<div id="head" class="row">
		<%
			int catalog = -1;
			catalog = blog.getInt("catalog");
			BlogCatalog blogCatalog = BlogCatalog.getById(catalog);
			String catalogIdent = blogCatalog.get("ident");
		%>
		<div id="logo"><h1>星星博客<small>（星星之火，可以燎原）</small></h1></div>
		<div id="nav">
			<ul class="nav nav-tabs " role="tablist">
				<li <%if(catalogIdent.equalsIgnoreCase("index")){ %>class="active"<%} %>><a href="/"><span class="glyphicon glyphicon-home"></span>&nbsp;首页</a></li>
				<li <%if(catalogIdent.equalsIgnoreCase("linux")){ %>class="active"<%} %>><a href="/linux">Linux</a></li>
				<li <%if(catalogIdent.equalsIgnoreCase("java")){ %>class="active"<%} %>><a href="/java">Java</a></li>
				<li <%if(catalogIdent.equalsIgnoreCase("devtool")){ %>class="active"<%} %>><a href="/devtool">开发工具</a></li>
				<li <%if(catalogIdent.equalsIgnoreCase("read")){ %>class="active"<%} %>><a href="/read">读书笔记</a></li>
				<li <%if(catalogIdent.equalsIgnoreCase("uncatalog")){ %>class="active"<%} %>><a href="/uncatalog">随笔</a></li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	<div id="main" class="row" style="margin-top:30px;">
		<div id="left" class="col-md-9 col-xs-12">
		<div class="blog_head">
			<div class="blog_title"><%=blog.get("title") %></div>
			<div class="blog_toolbar">
				<span class="view_count"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;<span class="badge"><%=blog.get("view") %></span></span>
				<span class="pub_time"></span><span class="glyphicon glyphicon-time"></span>&nbsp;<span class="badge"><%=blog.get("ctime") %></span></span>
				<span class="good"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<span class="badge">0</span></span>
				<span class="bad"><span class="glyphicon glyphicon-thumbs-down"></span>&nbsp;<span class="badge">0</span></span>
			</div>
		</div>
		<div class="blog_body">
			<%=blog.get("content") %>
		</div>
		<%}else{%>
				<div class="tips">未找到该博客！</div>
		<%}%>
		</div>
		<div id="right" class="col-md-3 col-xs-12">
			<jsp:include page="/_piece/right.jsp" />
		</div>
		<div class="clear"></div>
	</div>
	<div id="foot" class="row">
		<jsp:include page="/_piece/foot.jsp" />
	</div>
</body>
</html>