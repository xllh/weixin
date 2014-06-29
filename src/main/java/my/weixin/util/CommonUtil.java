
package my.weixin.util;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;

public class CommonUtil {
	//验证邮箱的正则表达式
	public static final String EMIAL_REGEX = "^(([a-z0-9A-Z_-]+)\\.?)+@(([a-z0-9A-Z_-]){2,}\\.?){1,}[a-z]{2,}$";
	
	//将字符串按字典序排列
	public static List<String> DictionarySort(String... origins){
		List<String> list  = new ArrayList<String>();
		for(String val : origins){
			list.add(val);
		}
		Collections.sort(list);
		return list;
	}
	//将数组中的字符串合并
	public static String Join(List<String> originList){
		StringBuffer result = new StringBuffer();
		for(String val : originList){
			result.append(val);
		}
		return result.toString();
	}
	//对字符串进行SHA-1加密
	public static String encrypt(String strSrc) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(strSrc.getBytes());
			return String.valueOf(Hex.encodeHex(md.digest())); // to HexString
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 将所有字符串参数，进行字典排序并依次连接，然后最连接字符串进行SHA-1加密
	 * @param origins
	 * @return
	 */
	public static String directorySortAndJoinAndEncrypt(String... origins){
		List<String> originList = DictionarySort(origins);
		String joinStr = Join(originList);
		return encrypt(joinStr);
	}
	
	/**
	 * 正则表达式判断
	 * @param regex 正则表达式
	 * @param str 要分析判断的字符串
	 * @return
	 */
	public static boolean regExp(String regex, String str){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	public static String uuid(int length){
		String uuid = UUID.randomUUID().toString();
		return StringUtils.substring(uuid, 0, length);
	}
	public static void main(String[] args) {
//		System.out.println(CommonUtil.regExp(CommonUtil.EMIAL_REGEX, "buxiang_l-oN.NGg212@oschi_na.adou.qeqrweer"));
//		System.out.println(uuid(8));
//		System.out.println(encrypt("03290817"));
		System.out.println(directorySortAndJoinAndEncrypt("a24fb454335fbf8bc8e39f86f653ada71c207058", "b8a7a297"));
	}
}
