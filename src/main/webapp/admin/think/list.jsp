<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>随笔列表</title>
</head>
<body>
	<div id="head">
		<jsp:include page="/admin/_piece/head.jsp" />
	</div>
	<div id="main">
		<div id="left">
			<jsp:include page="/admin/_piece/left.jsp" />
		</div>
		<div id="right">
			<table>
			<%
			Page<Think> thinkPage = Think.ME.page(1, 10);
			List<Think> thinkList = thinkPage.getList();
			for(Think think:thinkList){
			%>
				<tr>
					<td><%=think.get("id") %></td>
					<td><%=think.get("think") %></td>
					<td><%=think.get("time") %></td>
				</tr>
			<%} %>
			</table>
		</div>
	</div>
	<div id="foot">
		<jsp:include page="/admin/_piece/foot.jsp" />
	</div>
</body>
</html>