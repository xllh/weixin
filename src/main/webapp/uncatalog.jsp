<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*"%>
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
<title>随笔-星星之火博客</title>
</head>
<body class="container">
	<div id="head" class="row">
		<%@include file="_piece/head.jsp" %>
	</div>
	<div id="main" class="row" style="margin-top:30px;">
		<div id="left" class="col-md-9 col-xs-12">
			<% 
			int currentPage = 1;
			if(request.getParameter("p") != null){
				currentPage = Integer.parseInt(request.getParameter("p"));
			}
			int pageSize = 10;
			if(request.getParameter("s") != null){
				pageSize = Integer.parseInt(request.getParameter("s"));
			}
			%>
			<ol>
			<%
			Page<Think> thinkPage = Think.ME.page(currentPage, pageSize);
			List<Think> thinkList = thinkPage.getList();
			for(Think think:thinkList){
			%>
				<li style="height:30px;line-height:30px;">
					<span class="think"><%=think.get("think") %></span>
					<span class="time"><%=think.get("time") %></span>
				</li>
			<%} %>
			</ol>
			<div class="page">
				<%
					int totalCount = Think.ME.countAll();
					int totalPage = totalCount/pageSize; 
					if(totalCount % pageSize > 0){
						totalPage = totalPage + 1;
					}
				%>
				<ul class="pagination pagination-sm">
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