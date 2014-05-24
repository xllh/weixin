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
			<ul>
			<%
			Page<Think> thinkPage = Think.ME.page(1, 10);
			List<Think> thinkList = thinkPage.getList();
			for(Think think:thinkList){
			%>
				<li>
					<span class="think"><%=think.get("think") %></span>
					<span class="time"><%=think.get("time") %></span>
				</li>
			<%} %>
			</ul>
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