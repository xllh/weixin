<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>随笔</title>
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
			<div class="tip"><%if(session.getAttribute("tip")!=null){%><%=session.getAttribute("tip") %><%} %></div>
			<form action="action/think_add" method="post">
				<textarea name="think" id="think" cols="50" rows="5"></textarea>
				<br />
				<input type="submit" value="发表" />
			</form>
		</div>
	</div>
	<div id="foot">
		<jsp:include page="/admin/_piece/foot.jsp" />
	</div>
</body>
</html>