<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新博客</title>
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
			<%
				int blogId = Integer.parseInt(request.getParameter("id"));
				Blog blog = Blog.ME.findById(blogId);
			%>
			<form action="action/blog_update" method="post">
				<table>
					<tr>
						<td>题目<input type="hidden" name="id" value="<%=blog.get("id") %>" /></td>
						<td><input type="text" name="title" value="<%=blog.get("title") %>" /></td>
					</tr>
					<tr>
						<td>分类</td>
						<td>
							<select name="catalog" id="blog_catalog">
							  <%int catalog = blog.getInt("catalog"); %>
							  <option value ="1" <%if(catalog==1){ %>selected<%} %>>Linux</option>
							  <option value ="2" <%if(catalog==2){ %>selected<%} %>>Java</option>
							  <option value ="3" <%if(catalog==3){ %>selected<%} %>>开发工具</option>
							  <option value ="4" <%if(catalog==4){ %>selected<%} %>>读书笔记</option>
							  <option value ="5" <%if(catalog==5){ %>selected<%} %>>随笔</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>内容</td>
						<td><textarea id="ckeditor_blog" name="content" cols="80" rows="10"><%=blog.get("content") %></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="保存"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="foot">
		<jsp:include page="/admin/_piece/foot.jsp" />
	</div>
	<ckeditor:replace replace="ckeditor_blog" basePath="/admin/tool/ckeditor/"></ckeditor:replace>
</body>
</html>