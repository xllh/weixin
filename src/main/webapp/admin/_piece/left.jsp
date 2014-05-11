<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航条</title>
<script type="text/javascript" src="/tool/jquery-1.11.1.min.js"></script>
<!-- Semantic UI -->
<script type="text/javascript" src="/tool/semantic/javascript/semantic.min.js"></script>
<link rel="stylesheet" href="/tool/semantic/css/semantic.min.css" />
</head>
<body>
<div id="menu">
	<div class="ui vertical menu">
           <div class="header item">
               <i class="text file outline icon large"></i>
               博客管理
           </div>
            <a href="blog_list" class="item"><i class="list layout icon red"></i>博客列表</a>
            <a href="blog_add" class="item"><i class="add icon red"></i>写博客</a>
           <div class="header item">
               <i class="users icon large"></i>
               用户管理
           </div>
            <a href="user_list" class="item"><i class="list layout icon red"></i>用户列表</a>
            <a href="user_add" class="item"><i class="add icon red"></i>添加用户</a>
           <div class="header item">
               <i class="signal icon large"></i>
               统计管理
           </div>
           <a href="blog_count" class="item">博客访问</a>
       </div>
</div>
</body>
</html>