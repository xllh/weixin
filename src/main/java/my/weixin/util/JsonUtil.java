package my.weixin.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {
	/**
	 * 将对象转换成json字符串
	 * @param obj
	 * @return
	 */
	public static String getJson(Object obj){
		return JSON.toJSONString(obj);
	}
	
	/**
	 * 将json字符串解析成java对象
	 * @param jsonStr
	 * @return
	 */
	public static Object parseJson(String jsonStr){
		return JSON.parse(jsonStr);
	}
}
