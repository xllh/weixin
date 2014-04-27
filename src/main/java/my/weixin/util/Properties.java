package my.weixin.util;

public class Properties {
	public static String APPID = "wxe022b0cd168c22f1";
	public static String APPSECRET = "c5dbc3bb9158733b03df21148805491a";
	
	public static String TOKEN = "xllh_blog";
	public static int ACCESSTOKEN_TIMEOUT = 10;//access_token有效期7200秒
	
	public static String URL_GET_ACCESSTOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={1}&secret={2}";

	//菜单相关
	public static String URL_POST_CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={1}";
	public static String URL_GET_SELECT_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token={1}";
}
