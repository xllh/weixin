package my.weixin.jfinal.route;

import my.weixin.jfinal.controller.IndexController;
import my.weixin.jfinal.controller.VisitorActionController;

import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {
	@Override
	public void config() {
		add("/", IndexController.class);
		add("/action", VisitorActionController.class);
	}
}
