package my.weixin.jfinal.controller;

import org.apache.commons.lang.StringUtils;

import my.weixin.jfinal.bean.Blog;
import my.weixin.jfinal.bean.Think;

import com.jfinal.core.Controller;

public class AdminActionController extends Controller {
	public void blog_add(){
		Blog blog = new Blog();
		blog.set("title", getPara("title"));
		blog.set("content", getPara("content"));
		blog.set("catalog", getPara("catalog"));
		if(blog.save()){
			setSessionAttr("tip", "success");
			redirect("/admin/blog_add");
		}else{
			setSessionAttr("tip", "fail");
			renderNull();
		}
	}
	public void think_add(){
		String think = getPara("think");
		if(StringUtils.isNotBlank(think)){
			if(Think.ME.set("think", think).save()){
				setSessionAttr("tip", "success");
				redirect("/admin/think_add");
				Think.ME.clearCache();
			}
		}else{
			setSessionAttr("tip", "fail");
			renderNull();
		}
	}
}
