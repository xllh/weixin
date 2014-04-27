package my.weixin.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.binary.Hex;

public class CommonUtil {
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
}
