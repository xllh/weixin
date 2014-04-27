package my.weixin.entity;

public class ActionInfo {
	public Scene scene;
	public ActionInfo(){}
	public ActionInfo(Scene scene){
		this.scene = scene;
	}
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
