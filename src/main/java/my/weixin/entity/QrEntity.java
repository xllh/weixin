package my.weixin.entity;

public class QrEntity {
	public String action_name;
	public ActionInfo action_info;
	public QrEntity(){
		
	}
	public QrEntity(String action_name, ActionInfo action_info){
		this.action_name = action_name;
		this.action_info = action_info;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public ActionInfo getAction_info() {
		return action_info;
	}
	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}
}