package my.weixin.jfinal.bean;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.ehcache.CacheKit;

public class Think extends Model<Think> {

	private static final long serialVersionUID = 6498353426561948219L;
	
	public static Think ME = new Think();
	/**
	 * 获取缓存分页
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<Think> page(int pageNumber, int pageSize){
		String sql = "SELECT * FROM " + ME.Table;
		String exceptSql = "";
		Page<Think> thinkList = Think.ME.paginateByCache("#THINK#", "#PAGE#"+pageNumber+"#"+pageSize, pageNumber, pageSize, sql, exceptSql);
		return thinkList;
	}

	/**
	 * 清理所有缓存（暂时）
	 */
	public void clearCache(){
		CacheKit.removeAll("#THINK#");
	}
	public String Table = "xllh_think";
	
	public String getTable() {
		return Table;
	}
	public void setTable(String table) {
		Table = table;
	}
}
