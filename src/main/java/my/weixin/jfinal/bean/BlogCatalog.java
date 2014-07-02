package my.weixin.jfinal.bean;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class BlogCatalog extends Model<BlogCatalog> {
	private static final long serialVersionUID = 2048470385886380416L;
	
	public static BlogCatalog ME = new BlogCatalog();
	
	public static String CACHE_NAME = "#BLOGCATALOG#";
	public String Table = "xllh_blog_catalog";
	
	/**
	 * 根据博客ident获取博客分类信息
	 * @param ident
	 * @return
	 */
	public static BlogCatalog getByIdent(String ident){
		return ME.findFirst("SELECT * FROM " + ME.getTable() + " WHERE ident = ?", ident);
	}
	
	/**
	 * 根据博客id获取博客分类信息
	 * @param id
	 * @return
	 */
	public static BlogCatalog getById(int id){
		return ME.findFirst("SELECT * FROM " + ME.getTable() + " WHERE id = ?", id);
	}
	
	/**
	 * 获取所有软件分类
	 * @return
	 */
	public static List<BlogCatalog> getBlogCatalogList(){
		return ME.find("SELECT * FROM " + ME.getTable() + " ");
	}
	
	public String getTable() {
		return Table;
	}
	public void setTable(String table) {
		Table = table;
	}
}
