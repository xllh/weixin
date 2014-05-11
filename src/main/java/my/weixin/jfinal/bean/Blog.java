package my.weixin.jfinal.bean;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Blog extends Model<Blog>{
	private static final long serialVersionUID = 7573049414837917151L;
	
	public static Blog ME = new Blog();
	
	public static List<Blog> getAll(){
		return ME.find("SELECT * FROM "+ ME.getTable());
	}
	
	public static Blog getById(int id){
		return ME.findById(id);
	}
	
	public static List<Blog> getNew(int count) {
		return ME.find("SELECT * FROM " + ME.getTable() + " ORDER BY id DESC LIMIT ?", count);
	}
	public String Table = "xllh_blog";
	
	public String getTable() {
		return Table;
	}
	public void setTable(String table) {
		Table = table;
	}
}
