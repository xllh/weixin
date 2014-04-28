package my.weixin.jfinal.controller;

import my.weixin.jfinal.extend.MyVelocityRender;

import com.jfinal.core.Controller;
import com.jfinal.render.Render;

public class BlogController extends Controller {
	public void index(){
		Render render = new MyVelocityRender("/blog/index.vm");
		render.render();
	}
}
