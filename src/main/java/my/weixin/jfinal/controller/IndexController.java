package my.weixin.jfinal.controller;

import my.weixin.jfinal.bean.Blog;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index(){
		setAttr("catalog", "index");
		render("/index.jsp");
	}
	public void linux(){
		setAttr("catalog", "linux");
		render("/index.jsp");
	}
	public void java(){
		setAttr("catalog", "java");
		render("/index.jsp");
	}
	public void devtool(){
		setAttr("catalog", "devtool");
		render("/index.jsp");
	}
	public void read(){
		setAttr("catalog", "read");
		render("/index.jsp");
	}
	public void uncatalog(){
		setAttr("catalog", "uncatalog");
		render("/uncatalog.jsp");
	}
	public void detail(){
		if(getParaToInt(0) != null){
			int blogId = getParaToInt(0);
			//浏览数统计
			Blog blog = Blog.getById(blogId);
			blog.set("view", blog.getInt("view")+1).update();
			render("/detail.jsp?id="+blogId);
		}else{
			redirect("/index.jsp");
		}
	}
}
