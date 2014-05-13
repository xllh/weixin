package my.weixin.jfinal.controller;

import my.weixin.jfinal.bean.Blog;

import com.jfinal.core.Controller;

public class AdminActionController extends Controller {
	public void blog_add(){
		Blog blog = new Blog();
		blog.set("title", getPara("title"));
		blog.set("content", getPara("content"));
		blog.set("catalog", getPara("catalog"));
		if(blog.save()){
			redirect("/admin/blog_add");
		}else{
			renderNull();
		}
	}
}
