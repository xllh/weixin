package my.weixin.jfinal.route;

import my.weixin.jfinal.controller.AdminActionController;
import my.weixin.jfinal.controller.AdminController;

import com.jfinal.config.Routes;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		add("/admin", AdminController.class);
		add("/admin/action", AdminActionController.class);
	}
}
