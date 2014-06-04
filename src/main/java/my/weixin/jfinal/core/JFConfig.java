package my.weixin.jfinal.core;

import my.weixin.jfinal.bean.Blog;
import my.weixin.jfinal.bean.Think;
import my.weixin.jfinal.bean.User;
import my.weixin.jfinal.route.AdminRoutes;
import my.weixin.jfinal.route.FrontRoutes;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.cache.EhCache;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
import com.sina.sae.util.SaeUserInfo;

public class JFConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants constants) {
		constants.setDevMode(true);
		constants.setViewType(ViewType.JSP);
	}

	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors me) {

	}

	@Override
	public void configPlugin(Plugins me) {
		//缓存相关
		me.add(new EhCachePlugin());
		
		//数据库访问相关
//		String user = SaeUserInfo.getAccessKey();
//		String password = SaeUserInfo.getSecretKey();
//		C3p0Plugin c3p0 = new C3p0Plugin("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_xllhwx", user, password);
		String user = "root";
		String password = "root";
		C3p0Plugin c3p0 = new C3p0Plugin("jdbc:mysql://localhost:3306/app_xllh", user, password);
		me.add(c3p0);
		
		ActiveRecordPlugin arpMysql = new ActiveRecordPlugin("mysql", c3p0);
		me.add(arpMysql);
		arpMysql.setCache(new EhCache());
		arpMysql.addMapping("xllh_blog", "id", Blog.class);
		arpMysql.addMapping("xllh_user", "id", User.class);
		arpMysql.addMapping("xllh_think", "id", Think.class);
	}

	@Override
	public void configRoute(Routes routes) {
		routes.add(new FrontRoutes());
		routes.add(new AdminRoutes());
	}
	
	public void afterJFinalStart()
    {
		System.out.println("应用启动成功！");
    }

    public void beforeJFinalStop()
    {
    	System.out.println("应用即将关闭！");
    }
}
