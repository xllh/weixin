package my.weixin.servlet;

import com.alibaba.fastjson.JSON;

import my.weixin.entity.ActionInfo;
import my.weixin.entity.QrEntity;
import my.weixin.entity.QrTmpEntity;
import my.weixin.entity.Scene;

public class QrHandler {
	public static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	public static final int TYPE_PERMANENT = 1;
	public static final int TYPE_TEMP = 2;
	
	public int scene_id;
	public int type;
	
	public String createJson(){
		String jsonStr = "";
		switch(getType()){
		case TYPE_PERMANENT:
				Scene scene = new Scene(getScene_id());
				ActionInfo actionInfo = new ActionInfo(scene);
				QrEntity qrEntity = new QrEntity("QR_LIMIT_SCENE", actionInfo);
				jsonStr= JSON.toJSONString(qrEntity);
			break;
		case TYPE_TEMP:
				Scene sceneTmp = new Scene(getScene_id());
				ActionInfo actionInfoTmp = new ActionInfo(sceneTmp);
				QrTmpEntity qrEntityTmp = new QrTmpEntity(QrTmpEntity.DEFAULT_EXPIRE_SECONDS, "QR_SCENE", actionInfoTmp);
				jsonStr= JSON.toJSONString(qrEntityTmp);
			break;
		default:
			return null;
		}
		return jsonStr;
	}
	public static void main(String[] args) {
		QrHandler qrHandler = new QrHandler();
		qrHandler.setScene_id(20140419);
		qrHandler.setType(TYPE_PERMANENT);
		System.out.println(qrHandler.createJson());
	}
	public int getScene_id() {
		return scene_id;
	}
	public void setScene_id(int scene_id) {
		this.scene_id = scene_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
