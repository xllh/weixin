package my.weixin.util;

import java.io.InputStream;

import my.weixin.entity.AccessToken;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

public class WeixinUtil {
	public static AccessToken access_token;
	public static long create_time;	//access_token创建的系统时间
	
	/**
	 * 获取有效的AccessToken对象，参考过期时间
	 * @return
	 */
	public static AccessToken getAccessToken(){
		if(checkTimeout()){
			return refreshAccessToken();
		}else{
			return access_token;
		}
	}
	
	/**
	 * 立即更新AccessToken对象
	 * @return
	 */
	public static AccessToken refreshAccessToken(){
		String[] searchList = {"{1}", "{2}"};
		String[] replacementList = {Properties.APPID, Properties.APPSECRET};
		String url = StringUtils.replaceEachRepeatedly(Properties.URL_GET_ACCESSTOKEN,
				searchList, replacementList);
		try {
			create_time = System.currentTimeMillis();
			InputStream is = HttpUtil.get(url);
			access_token = (AccessToken)JSON.parseObject(IOUtils.toString(is), AccessToken.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return access_token;
	}
	
	/**
	 * 检查AccessToken是否超时
	 * @return
	 */
	protected static boolean checkTimeout(){
		if(create_time==0){//如果尚未创建，返回超时
			return true;
		}
		long interval = System.currentTimeMillis() - create_time;
		int out_time = access_token.getExpires_in()==0?Properties.ACCESSTOKEN_TIMEOUT:access_token.getExpires_in();
		if(out_time*1000 <= interval){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 测试主函数
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		while(true){
			Thread.sleep(1000);
			AccessToken at= WeixinUtil.getAccessToken();
			System.out.println(at.getAccess_token());
		}
	}
}
