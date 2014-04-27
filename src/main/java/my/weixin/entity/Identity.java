package my.weixin.entity;

import java.util.List;

import my.weixin.util.CommonUtil;
import my.weixin.util.Properties;

public class Identity {
	public static final String P_SIGNATURE = "signature";
	public static final String P_TIMESTAMP = "timestamp";
	public static final String P_NONCE = "nonce";
	public static final String P_ECHOSTR = "echostr";
	
	public String signature;
	public String timestamp;
	public String nonce;
	public String echostr;
	
	public Identity(String signature, String timestamp, String nonce, String echostr){
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
		this.echostr = echostr;
	}
	
	public boolean recognize(){
		List<String> list = CommonUtil.DictionarySort(Properties.TOKEN, getTimestamp(), getNonce());
		String joinStr = CommonUtil.Join(list);
		joinStr = CommonUtil.encrypt(joinStr);
		if(joinStr.equalsIgnoreCase(getSignature())){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		String str = "[signature : "+this.getSignature()+"]，[timestamp : "+this.getTimestamp()+"]，[nonce : "+this.getNonce()+"]，[echostr : "+this.getEchostr()+"]";
		System.out.println(str);
		return str;
	}

	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
}
