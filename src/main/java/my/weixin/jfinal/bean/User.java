package my.weixin.jfinal.bean;

import java.util.List;

import my.weixin.util.CommonUtil;

import org.apache.commons.lang.StringUtils;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
	private static final long serialVersionUID = 5205451852072564051L;
	
	public static User ME = new User();
	
	/**
	 * 根据邮箱查询用户
	 * @param email
	 * @return
	 */
	public User getByEmail(String email){
		String sql = "SELECT * FROM " + getTable()+ " WHERE email = ?";
		List<User> userList = ME.find(sql, email);
		if(userList != null){
			return userList.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 用户登录验证
	 * @return
	 */
	public boolean validateLogin(String postEmail, String postPassword){
		if(StringUtils.isBlank(postEmail)||StringUtils.isBlank(postPassword)){
			return false;
		}
		if(!CommonUtil.regExp(CommonUtil.EMIAL_REGEX, postEmail)){
			return false;
		}
		User user = ME.findFirst("SELECT * FROM " + ME.getTable() + " WHERE email = ?", postEmail);
		if(user == null){
			return false;
		}
		//数据库盐
		String sault = user.getStr("sault");
		//字典序排列并连接
		String pass = CommonUtil.directorySortAndJoinAndEncrypt(postPassword, sault);
		//比较数据库密码和code是否相等
		if(StringUtils.equals(user.getStr("password"), pass)){
			return true;
		}
		return false;
	}
	/**
	 * 添加新用户
	 * @param email 邮箱
	 * @param pass 密码
	 * @param name 昵称
	 * @return
	 */
	public boolean addUser(String email, String pass, String name){
		String sault = CommonUtil.uuid(8);
		String password = CommonUtil.directorySortAndJoinAndEncrypt(pass, sault);
		boolean result = User.ME.set("email", email).set("password", password)
			.set("name", name).set("sault", sault)
			.save();
		return result;
	}
	public String Table = "xllh_user";

	public String getTable() {
		return Table;
	}
	public void setTable(String table) {
		Table = table;
	}
}
