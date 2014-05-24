package my.weixin.jfinal.bean;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

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
	
	public Page<Blog> search(int catalog, int pageNumber, int pageSize){
		String sql = "SELECT * ";
		StringBuffer exceptSql = new StringBuffer();
		exceptSql.append(" FROM " + getTable());
		List<Object> paramList = new ArrayList<Object>();
		if(catalog>0){
			exceptSql.append(" WHERE catalog = ? ");
			paramList.add(catalog);
		}
		if(pageNumber<0){
			pageNumber = 1;
		}
		if(pageSize<=0){
			pageSize = 20;
		}
		Page<Blog> blogList = Blog.ME.paginateByCache("#BLOG#", "#PAGE#"+catalog+"#"+pageNumber+"#"+pageSize, pageNumber, pageSize, sql, exceptSql.toString(), paramList.toArray());
		return blogList;
	}
}
