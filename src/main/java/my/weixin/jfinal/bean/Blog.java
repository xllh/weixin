package my.weixin.jfinal.bean;

import java.sql.Timestamp;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Blog extends Model<Blog>{
	private static final long serialVersionUID = 1L;
	
	public static Blog ME = new Blog();
	public static String TABLE_NAME = "xllh_blog";
	
	public static List<Blog> getAll(){
		return ME.find("SELECT * FROM "+ TABLE_NAME);
	}
	
	public static Blog getById(int id){
		return ME.findById(id);
	}
	
	public int id;
	public String title;
	public String content;
	public Timestamp ctime;
	public int view;
	public int catalog;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCtime() {
		return ctime;
	}
	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getCatalog() {
		return catalog;
	}
	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}
}
