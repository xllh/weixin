<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/main.css" />
<title>随笔-星星之火博客</title>
</head>
<body>
	<div id="head">
		<jsp:include page="/_piece/head.jsp">
			<jsp:param name="catalog" value="uncatalog"/>
		</jsp:include>
	</div>
	<div id="main">
		<div id="left">
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
			<ul>
			<%
			Page<Think> thinkPage = Think.ME.page(currentPage, pageSize);
			List<Think> thinkList = thinkPage.getList();
			for(Think think:thinkList){
			%>
				<li>
					<span class="think"><%=think.get("think") %></span>
					<span class="time"><%=think.get("time") %></span>
				</li>
			<%} %>
			</ul>
			<div class="page">
				<%
					int totalCount = Think.ME.countAll();
					int totalPage = totalCount/pageSize + 1;
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