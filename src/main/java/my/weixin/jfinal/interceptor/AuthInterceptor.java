package my.weixin.jfinal.interceptor;

import org.apache.commons.lang.StringUtils;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

public class AuthInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		//登录检查
		String xxzh= controller.getSessionAttr("email");
		if(StringUtils.isNotBlank(xxzh)){
			ai.invoke();
		}else{
			controller.redirect("/login.jsp");
		}
	}

}
