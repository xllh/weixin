<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.db.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<%
		Test test = new Test();
		List<Blog> blogList = test.query();
		if(blogList != null){
			for(Blog blog : blogList){
	%>
	<tr>
		<td><%=blog.getTitle() %></td>
		<td><%=blog.getContent() %></td>
	</tr>
	<%}} %>
	</table>
</body>
</html>