package my.weixin.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import my.weixin.jfinal.bean.Blog;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sina.sae.util.SaeUserInfo;

public class Test {
	public List<Blog> query(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_xllhwx";
		String user = SaeUserInfo.getAccessKey();
		String password = SaeUserInfo.getSecretKey();
		try {
			Class.forName(driver);
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			if(!conn.isClosed())
			System.out.println("Succeeded connecting to the Database!");
			Statement statement = (Statement) conn.createStatement();
			String sql = "select * from xllh_blog";
			ResultSet rs = statement.executeQuery(sql);
			List<Blog> blogList = new ArrayList<Blog>();
			while(rs.next()){
				Blog blog = new Blog();
				blog.setId(rs.getInt("id"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setCtime(rs.getTimestamp("ctime"));
				blog.setView(rs.getInt("view"));
				blog.setCatalog(rs.getInt("catalog"));
				blogList.add(blog);
			}
			return blogList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
