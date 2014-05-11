package my.weixin.jfinal.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index(){
		render("/index.jsp");
	}
	
	public void linux(){
		render("/linux.jsp");
	}
	
	public void java(){
		render("/java.jsp");
	}
	
	public void devtool(){
		render("/devtool.jsp");
	}
	
	public void read(){
		render("/read.jsp");
	}
	
	public void uncatalog(){
		render("/uncatalog.jsp");
	}
}
