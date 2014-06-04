<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/main.css" />
<title>Linux-星星之火博客</title>
</head>
<body>
	<div id="head">
		<jsp:include page="/_piece/head.jsp">
			<jsp:param name="catalog" value="linux"/>
		</jsp:include>
	</div>
	<div id="main">
		<div id="left">
			<ul>
			<%
			int catalog = 1;
			int currentPage = 1;
			int pageSize = 10;
			if(request.getParameter("p") != null){
				currentPage = Integer.parseInt(request.getParameter("p"));
			}
			if(request.getParameter("s") != null){
				pageSize = Integer.parseInt(request.getParameter("s"));
			}
			Page<Blog> blogPage = Blog.ME.search(catalog, currentPage, pageSize);
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
			<div class="page">
				<%
					int totalCount = Blog.ME.count(catalog);
					int totalPage = totalCount/pageSize; 
					if(totalCount % pageSize > 0){
						totalPage = totalPage + 1;
					}
				%>
				<ul>
					<%if(currentPage != 1){ %>
					<li class="pre"><a href="?p=<%=currentPage-1 %>&s=<%=pageSize %>">上一页</a></li>
					<%} %>
					<%if(currentPage>6){ %>
						<li><a href="?p=1&s=<%=pageSize %>">1</a></li>
						<%for(int i = currentPage - 4;i < currentPage;i++){ %>
						<li><a href="?p=<%=i %>&s=<%=pageSize %>"><%=i %></a></li>
						<%} %>
					<%}else{ %>
						<%for(int i = 1;i < currentPage;i++){ %>
						<li><a href="?p=<%=i %>&s=<%=pageSize %>"><%=i %></a></li>
						<%} %>
					<%} %>
					<!-- 当前页 -->
					<li class="current"><a href="?p=<%=currentPage %>&s=<%=pageSize %>"><%=currentPage %></a></li>
					<%if(totalPage - currentPage < 4){ %>
						<%for(int i = currentPage + 1;i <= totalPage;i++){ %>
							<li><a href="?p=<%=i %>&s=<%=pageSize %>"><%=i %></a></li>
						<%} %>
					<%}else{ %>
						<%for(int i = currentPage + 1;i < currentPage + 4;i++){ %>
							<li><a href="?p=<%=i %>&s=<%=pageSize %>"><%=i %></a></li>
						<%} %>
						<li><a href="?p=<%=totalPage %>&s=<%=pageSize %>"><%=totalPage %></a></li>
					<%} %>
					<%if(totalPage - currentPage > 1){ %>
						<li class="next"><a href="?p=<%=currentPage+1 %>&s=<%=pageSize %>">下一页</a></li>
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