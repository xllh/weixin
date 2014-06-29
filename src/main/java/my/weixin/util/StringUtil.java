package my.weixin.util;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
	/**
	 * 截断字符串
	 * @param content
	 * @param length
	 * @return
	 */
	public static String cutContent(String content, int length){
		String result = StringUtils.abbreviate(content, length);
		return result;
	}
}
