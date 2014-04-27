package my.weixin.json;

public class Menu extends JsonBase {
	public Menu(){
		
	}
	public Menu(Button[] button){
		this.button = button;
	}
	public Button[] button;
	public Button[] getButton() {
		return button;
	}
	public void setButton(Button[] button) {
		this.button = button;
	}
}

