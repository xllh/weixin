package my.weixin.jfinal.controller;

import org.apache.commons.lang.StringUtils;

import my.weixin.jfinal.bean.Blog;
import my.weixin.jfinal.bean.Think;

import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheKit;

public class AdminActionController extends Controller {
	public void blog_add(){
		Blog blog = new Blog();
		blog.set("title", getPara("title"));
		blog.set("content", getPara("content"));
		blog.set("catalog", getPara("catalog"));
		if(blog.save()){
			setSessionAttr("tip", "success");
			//更新缓存
			CacheKit.removeAll(Blog.CACHE_NAME);
			redirect("/admin/blog_add");
		}else{
			setSessionAttr("tip", "fail");
			renderNull();
		}
	}
	public void blog_update(){
		Blog blog = Blog.ME.findById(getPara("id"));
		blog.set("title", getPara("title"));
		blog.set("content", getPara("content"));
		blog.set("catalog", getPara("catalog"));
		if(blog.update()){
			setSessionAttr("tip", "success");
			//更新缓存
			CacheKit.removeAll(Blog.CACHE_NAME);
			redirect("/admin/blog_update?id="+blog.getInt("id"));
		}else{
			setSessionAttr("tip", "fail");
			renderNull();
		}
	}
	
	public void blog_delete(){
		int blogId = getParaToInt("id");
		Blog blog = Blog.ME.findById(blogId);
		if(blog != null){
			if(blog.delete()){
				setSessionAttr("tip", "删除成功！");
				//更新缓存
				CacheKit.removeAll(Blog.CACHE_NAME);
				redirect("/admin/blog_list");
			}else{
				setSessionAttr("tip", "删除失败，请重试！");
				renderNull();
			}
		}else{
			setSessionAttr("tip", "博客不存在!");
			redirect("/admin/blog_list");
		}
	}
	public void think_add(){
		String think = getPara("think");
		if(StringUtils.isNotBlank(think)){
			if(new Think().set("think", think).save()){
				setSessionAttr("tip", "success");
				redirect("/admin/think_add");
				//更新缓存
				CacheKit.removeAll(Think.CACHE_NAME);
			}
		}else{
			setSessionAttr("tip", "fail");
			renderNull();
		}
	}
	
	public void think_delete(){
		int thinkId = getParaToInt("id");
		Think think = Think.ME.findById(thinkId);
		if(think != null){
			if(think.delete()){
				setSessionAttr("tip", "删除成功！");
				//更新缓存
				CacheKit.removeAll(Think.CACHE_NAME);
				redirect("/admin/think_list");
			}else{
				setSessionAttr("tip", "删除失败，请重试！");
				renderNull();
			}
		}else{
			setSessionAttr("tip", "随笔不存在!");
			redirect("/admin/think_list");
		}
	}
}
