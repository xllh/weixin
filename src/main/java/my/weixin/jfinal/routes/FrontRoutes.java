package my.weixin.jfinal.routes;

import my.weixin.jfinal.controller.BlogController;

import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {

	@Override
	public void config() {
		this.add("/blog", BlogController.class);
	}

}
