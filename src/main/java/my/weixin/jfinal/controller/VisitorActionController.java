package my.weixin.jfinal.controller;

import static nl.captcha.Captcha.NAME;

import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.SquigglesBackgroundProducer;
import nl.captcha.noise.CurvedLineNoiseProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import my.weixin.jfinal.bean.User;

import com.jfinal.core.Controller;

public class VisitorActionController extends Controller{
	//登录
	public void login(){
		String email = getPara("email");
		String password = getPara("password");
		String answer = getPara("answer");
		Captcha captcha = (Captcha)getSessionAttr(Captcha.NAME);
		if(!captcha.isCorrect(answer)){
			removeSessionAttr(Captcha.NAME);
			renderJson("status", "answer_wrong");
		}else{
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
	
	//生成验证码
	public void imgCaptcha(){
		int _width = getParaToInt("w", 200);
		int _height = getParaToInt("h", 50);
		Captcha captcha = new Captcha.Builder(_width, _height)
    	.addText()
    	.addBackground(new SquigglesBackgroundProducer())
        .gimp()
        .addNoise(new CurvedLineNoiseProducer())
        .build();
		
		CaptchaServletUtil.writeImage(getResponse(), captcha.getImage());
		setSessionAttr(NAME, captcha);
		renderNull();
	}
}
