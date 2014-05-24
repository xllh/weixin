<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/main.css" />
<title>首页-星星博客</title>
</head>
<body>
	<div id="head">
		<jsp:include page="/_piece/head.jsp">
			<jsp:param name="catalog" value="index"/>
		</jsp:include>
	</div>
	<div id="main">
		<div id="left">
			<div id="blog_list">
				<ul>
			<%
			int catalog = -1;
			int pageNumber = 1;
			int pageSize = 5;
			Page<Blog> blogPage = Blog.ME.search(catalog, pageNumber, pageSize);
			List<Blog> blogList = blogPage.getList();
			for(Blog blog:blogList){
			%>
				<li>
					<div class="blog_head">
						<div class="blog_title"><%=blog.get("title") %></div>
						<div class="blog_toolbar">
							<span>浏览次数：<%=blog.get("view") %></span>
							<span>发布时间：<%=blog.get("ctime") %></span>
						</div>
					</div>
					<div class="blog_body">
						<%=blog.get("content") %>
					</div>
				</li>
			<%} %>
			</ul>
			</div>
		</div>
		<div id="right">
			<jsp:include page="/_piece/right.jsp" />
		</div>
		<div class="clear"></div>
	</div>
	<div id="foot">
		<jsp:include page="/_piece/foot.jsp" />
	</div>
</body>
</html>