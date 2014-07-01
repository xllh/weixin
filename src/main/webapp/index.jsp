<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*,my.weixin.util.*"%>
<!DOCTYPE html>
<html lang="zh-CN">
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
<title>首页-星星博客</title>
</head>
<body class="container">
	<div id="head" class="row">
		<%@include file="_piece/head.jsp" %>
	</div>
	<div id="main" class="row">
		<div id="left" class="col-md-9 col-xs-12">
			<div id="blog_list">
				<ul>
					<%
					int currentPage = 1;
					if(request.getParameter("p") != null){
						currentPage = Integer.parseInt(request.getParameter("p"));
					}
					int pageSize = 10;
					if(request.getParameter("s") != null){
						pageSize = Integer.parseInt(request.getParameter("s"));
					}
					Page<Blog> blogPage = Blog.ME.search(catalog, currentPage, pageSize);
					List<Blog> blogList = blogPage.getList();
					for(Blog blog:blogList){
					%>
					<li style="border-bottom:1px solid #ccc;list-style:none;padding:10px 0 20px 0;">
						<div class="blog_head">
							<div class="blog_title"><h2><%=blog.get("title") %></h2></div>
							<div class="blog_toolbar">
								<span class="view_count"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;<span class="badge"><%=blog.get("view") %></span></span>
								<span class="pub_time"></span><span class="glyphicon glyphicon-time"></span>&nbsp;<span class="badge"><%=blog.get("ctime") %></span></span>
								<span class="good"><span class="glyphicon glyphicon-thumbs-up" onclick="good(<%=blog.get("id")%>)"></span>&nbsp;<span class="badge" id="good_count_<%=blog.get("id")%>"><%=blog.get("good") %></span></span>
								<span class="bad"><span class="glyphicon glyphicon-thumbs-down" onclick="bad(<%=blog.get("id")%>)"></span>&nbsp;<span class="badge" id="bad_count_<%=blog.get("id")%>"><%=blog.get("bad") %></span></span>
							</div>
						</div>
						<div class="blog_body" style="margin-bottom:20px;">
							<%=StringUtil.cutContent(blog.get("content").toString(), 100) %>
						</div>
						<div class="toolbar"><span class="detail"><a href="detail/<%=blog.get("id")%>"><span class="glyphicon glyphicon-share-alt">&nbsp;详情</span></a><span class="share"><span class="glyphicon glyphicon-share"></span>&nbsp;分享</span></span></div>
					</li>
					<%} %>
				</ul>
			<div class="page row">
				<%
					int totalCount = Blog.getAll().size();
					int totalPage = totalCount/pageSize; 
					if(totalCount % pageSize > 0){
						totalPage = totalPage + 1;
					}
				%>
				<ul class="pagination pagination-sm col-md-10 col-md-offset-2">
					<%if(currentPage != 1){ %>
					<li class="pre"><a href="?p=<%=currentPage-1 %>&s=<%=pageSize %>">&laquo;</a></li>
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
					<li class="active"><a href="?p=<%=currentPage %>&s=<%=pageSize %>"><%=currentPage %></a></li>
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
						<li class="next"><a href="?p=<%=currentPage+1 %>&s=<%=pageSize %>">&raquo;</a></li>
					<%} %>
				</ul>
			</div>
			</div>
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