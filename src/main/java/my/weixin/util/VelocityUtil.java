package my.weixin.util;

import java.io.StringWriter;

import my.weixin.xml.TextXML;
import my.weixin.xml.XMLBase;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityUtil {
	/**
	 * 获取XML格式字符串
	 * @param Velocity文件名称
	 * @param Velocity模板中引用Java对象的key
	 * @param Velocity模板中将会用到的Java对象
	 * @return XML格式字符串
	 */
	public static String getXml(String fileName, String key, XMLBase xml){
		Velocity.setProperty("file.resource.loader.path", VelocityUtil.class.getResource("/").getPath()+"xml/");
		Velocity.setProperty("file.resource.loader.cache", "true");
		Velocity.setProperty("file.resource.loader.modificationCheckInterval", "60");
		Velocity.init();
		VelocityContext context = new VelocityContext();
		context.put(key, xml);
		StringWriter w = new StringWriter();
		Template t = Velocity.getTemplate(fileName);
		t.merge(context, w);
		return w.toString();
	}
	/**
	 * 主函数，测试示例
	 * @param args
	 */
	public static void main(String[] args) {
		TextXML text = new TextXML();
		text.setToUserName("abc");
		text.setFromUserName("xyz");
		text.setCreateTime("3745230162846");
		text.setMsgType("text");
		text.setContent("呵呵");
		System.out.println(VelocityUtil.getXml("text.vm", "TextXML", text));
	}
}
