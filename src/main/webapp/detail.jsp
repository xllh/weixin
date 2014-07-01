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
<script src="/js/common.js"></script>
<title>-博客</title>
</head>
<body class="container">
	<%
		int blogId = Integer.parseInt(request.getParameter("id"));
		Blog blog = Blog.getById(blogId);
		if(blog != null){
	%>
	<div id="head" class="row">
		<%@include file="_piece/head.jsp" %>
	</div>
	<div id="main" class="row" style="margin-top:30px;">
		<div id="left" class="col-md-9 col-xs-12">
		<div class="blog_head">
			<div class="blog_title"><%=blog.get("title") %></div>
			<div class="blog_toolbar">
				<span class="view_count"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;<span class="badge"><%=blog.get("view") %></span></span>
				<span class="pub_time"></span><span class="glyphicon glyphicon-time"></span>&nbsp;<span class="badge"><%=blog.get("ctime") %></span></span>
				<span class="good"><span class="glyphicon glyphicon-thumbs-up" onclick="good(<%=blog.get("id")%>)"></span>&nbsp;<span class="badge" id="good_count_<%=blog.get("id")%>"><%=blog.get("good") %></span></span>
				<span class="bad"><span class="glyphicon glyphicon-thumbs-down" onclick="bad(<%=blog.get("id")%>)"></span>&nbsp;<span class="badge" id="bad_count_<%=blog.get("id")%>"><%=blog.get("bad") %></span></span>
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
			<%@include file="_piece/right.jsp" %>
		</div>
		<div class="clear"></div>
	</div>
	<div id="foot" class="row">
		<%@include file="_piece/foot.jsp" %>
	</div>
</body>
</html>