<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8" import="my.weixin.jfinal.bean.*,com.jfinal.plugin.activerecord.Page,java.util.*,my.weixin.util.*"%>
<%String catalog = "index"; %>
<%if(request.getAttribute("catalog")!=null){
	catalog = request.getAttribute("catalog").toString();
} %>
<div id="logo"><h1>星星博客<small>（星星之火，可以燎原）</small></h1></div>
<div id="nav">
	<ul class="nav nav-tabs " role="tablist">
		<li <%if(catalog.equalsIgnoreCase("index")){ %>class="active"<%} %>><a href="/"><span class="glyphicon glyphicon-home"></span>&nbsp;首页</a></li>
		<li <%if(catalog.equalsIgnoreCase("linux")){ %>class="active"<%} %>><a href="/linux">Linux</a></li>
		<li <%if(catalog.equalsIgnoreCase("java")){ %>class="active"<%} %>><a href="/java">Java</a></li>
		<li <%if(catalog.equalsIgnoreCase("devtool")){ %>class="active"<%} %>><a href="/devtool">开发工具</a></li>
		<li <%if(catalog.equalsIgnoreCase("read")){ %>class="active"<%} %>><a href="/read">读书笔记</a></li>
		<li <%if(catalog.equalsIgnoreCase("uncatalog")){ %>class="active"<%} %>><a href="/uncatalog">随笔</a></li>
	</ul>
	<div class="clear"></div>
</div>