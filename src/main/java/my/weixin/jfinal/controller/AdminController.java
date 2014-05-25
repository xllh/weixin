package my.weixin.jfinal.controller;

import org.apache.commons.lang.StringUtils;

import my.weixin.jfinal.bean.User;
import my.weixin.jfinal.interceptor.AuthInterceptor;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(AuthInterceptor.class)
public class AdminController extends Controller {
	public void index(){
		render("/admin/index.jsp");
	}
	//用户
	public void user_add(){
		render("/admin/user/add.jsp");
	}
	public void user_list(){
		render("/admin/user/list.jsp");
	}
	//博客
	public void blog_add(){
		render("/admin/blog/add.jsp");
	}
	public void blog_update(){
		render("/admin/blog/update.jsp?id="+getPara("id"));
	}
	public void blog_list(){
		render("/admin/blog/list.jsp");
	}
	public void blog_count(){
		render("/admin/blog/count.jsp");
	}
	//随笔
	public void think_add(){
		render("/admin/think/add.jsp");
	}
	public void think_list(){
		render("/admin/think/list.jsp");
	}
	//注销登录
	public void logOut(){
		if(StringUtils.isNotBlank(getSessionAttr("email").toString())){
			removeSessionAttr("email");
		}
		redirect("/");
	}
	//添加管理员
	public void addUser(){
		String email = getPara("email");
		String pass = getPara("password");
		String name = getPara("name");
		if(User.ME.addUser(email, pass, name)){
			renderJson("success");
		}else{
			renderJson("fail");
		}
	}
}
