package my.weixin.util;

import java.io.InputStream;

import my.weixin.entity.AccessToken;
import my.weixin.json.Button;
import my.weixin.json.FatherButton;
import my.weixin.json.Menu;

import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

public class MenuUtil {
	public static void createMenu(Menu menu){
		
	}
	
	public static void main(String[] args) throws Exception {
		Button bt1 = new Button("view", "博客", null, "http://pages.adouteam.com/");
		Button bt2 = new Button("click", "简介", "WX_01_INTRODUCE", null);
		Button bt3_1 = new Button("view", "开源中国", null, "http://www.oschina.net/");
		Button bt3_2 = new Button("view", "GitHub", null, "https://github.com/");
		Button bt3_3 = new Button("view", "酷壳CoolShell", null, "http://coolshell.cn/");
		Button[] bt3Array = {bt3_1, bt3_2, bt3_3};
		FatherButton bt3 = new FatherButton("友情链接", bt3Array);
		Button[] btArray = {bt1, bt2, bt3};
		Menu menu = new Menu(btArray);
		String jsonStr = JSON.toJSONString(menu);
		System.out.println(jsonStr);
		
		AccessToken access_token = WeixinUtil.getAccessToken();
		String url = StringUtils.replace(Properties.URL_POST_CREATE_MENU, "{1}", access_token.getAccess_token());
		InputStreamRequestEntity isre = new InputStreamRequestEntity(IOUtils.toInputStream(jsonStr), "application/json");
		
		InputStream stream = HttpUtil.post(url, isre);
		System.out.println(IOUtils.toString(stream));
		
		String url_search = StringUtils.replace(Properties.URL_GET_SELECT_MENU, "{1}", access_token.getAccess_token());
		stream = HttpUtil.get(url_search);
		System.out.println(IOUtils.toString(stream));
	}
//	/**
//	 * 测试主函数
//	 * @param args
//	 * @throws Exception
//	 */
//	public static void main(String[] args) throws Exception {
//		InputStream is = new FileInputStream(new File("/home/buxianglong/eclipseworkspace/WeiXin/template/json/menu.vm"));
//		AccessToken access_token = WeixinUtil.getAccessToken();
//		String url = StringUtils.replace(Properties.URL_POST_CREATE_MENU, "{1}", access_token.getAccess_token());
//		InputStreamRequestEntity isre = new InputStreamRequestEntity(is, "application/json");
//		
//		InputStream stream = HttpUtil.post(url, isre);
//		System.out.println(IOUtils.toString(stream));
//		
//		String url_search = StringUtils.replace(Properties.URL_GET_SELECT_MENU, "{1}", access_token.getAccess_token());
//		stream = HttpUtil.get(url_search);
//		System.out.println(IOUtils.toString(stream));
//	}
}
