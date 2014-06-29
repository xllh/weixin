package my.weixin.jfinal.controller;

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
			render("/detail.jsp?id="+getParaToInt(0));
		}else{
			redirect("/index.jsp");
		}
	}
}
