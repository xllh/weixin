package my.weixin.jfinal.controller;

import javax.servlet.http.HttpSession;

import my.weixin.jfinal.bean.User;

import com.jfinal.core.Controller;

public class VisitorActionController extends Controller{
	public void login(){
		String email = getPara("email");
		String password = getPara("password");
		Boolean result = User.ME.validateLogin(email, password);
		if(result){
			HttpSession session = getSession(true);
			User user = User.ME.getByEmail(email);
			session.setAttribute("name", user.get("name"));
			session.setAttribute("email", user.get("email"));
			session.setMaxInactiveInterval(60*60);
			renderJson("status", "/admin/index");
		}else{
			renderJson("status", "fail");
		}
	}
}
