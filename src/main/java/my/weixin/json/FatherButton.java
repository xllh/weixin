package my.weixin.json;

public class FatherButton extends Button{
	public FatherButton(){
		
	}
	public FatherButton(String name, Button[] sub_button){
		this.name = name;
		this.sub_button = sub_button;
	}
	String name;
	Button[] sub_button;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Button[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
