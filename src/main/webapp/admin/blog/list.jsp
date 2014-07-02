<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客列表</title>
</head>
<body>
	<div id="head">
		<jsp:include page="/admin/_piece/head.jsp" />
	</div>
	<div id="main">
		<div id="right">
			<jsp:include page="/admin/_piece/left.jsp" />
		</div>
		<div id="right">
			<%
				int catalog = -1;
				int pageNumber = 1;
				int pageSize = 10;
				if(request.getParameter("c") != null){
					catalog = Integer.parseInt(request.getParameter("c"));
				}
				if(request.getParameter("p") != null){
					pageNumber = Integer.parseInt(request.getParameter("p"));
				}
				if(request.getParameter("s") != null){
					pageSize = Integer.parseInt(request.getParameter("s"));
				}
			%>
			<ul class="catalog">
				<li<%if(catalog==-1){ %> class="current" <%} %>><a href="/admin/blog_list">所有</a></li>
				<%List<BlogCatalog> blogCatalogList = BlogCatalog.getBlogCatalogList();
				for(BlogCatalog blogCatalog : blogCatalogList){ %>
				<li<%if(catalog==blogCatalog.getInt("id")){ %> class="current" <%} %>><a href="?c=<%=blogCatalog.getInt("id") %>"><%=blogCatalog.get("name") %></a></li>
				<%} %>
			</ul>
			<span class="clear"></span>
			<table class="list">
			<tr>
				<td>编号</td>
				<td>标题</td>
				<td>发表时间</td>
				<td>浏览次数</td>
				<td>操作</td>
			</tr>
			<%
			BlogCatalog blogCatalog = BlogCatalog.getById(catalog);
			String catalogIdent = "";
			if(blogCatalog!=null){
				catalogIdent = blogCatalog.get("ident").toString();
			}
			Page<Blog> blogPage = Blog.ME.search(catalogIdent, pageNumber, pageSize);
			List<Blog> blogList = blogPage.getList();
			for(Blog blog:blogList){
			%>
				<tr>
					<td><%=blog.get("id") %></td>
					<td><%=blog.get("title") %></td>
					<td><%=blog.get("ctime") %></td>
					<td><%=blog.get("view") %></td>
					<td>
						<a href="/admin/action/blog_delete?id=<%=blog.get("id") %>">删除</a>
						<a href="/admin/blog_update?id=<%=blog.get("id") %>">编辑</a>
					</td>
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