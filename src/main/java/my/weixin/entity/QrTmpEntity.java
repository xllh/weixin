package my.weixin.entity;

public class QrTmpEntity extends QrEntity{
	public static final int DEFAULT_EXPIRE_SECONDS = 1800;
	
	public int expire_seconds;
	
	public QrTmpEntity(){
		
	}
	public QrTmpEntity(int expire_seconds, String action_name, ActionInfo action_info){
		this.expire_seconds = expire_seconds;
		this.action_name = action_name;
		this.action_info = action_info;
	}
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
}
