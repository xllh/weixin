package my.weixin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import my.weixin.entity.Message;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtil {
	public static final String BASEPATH = XmlUtil.class.getClassLoader().getResource("").getPath() + "weixin-response" + File.pathSeparator;
	public static String rootNodeName;
	/**
	 * 将字符流转换成Document
	 * @param is
	 * @return
	 * @throws DocumentException
	 */
	public static Document read(InputStream is) {
		if(is == null){
			return null;
		}
		Document doc = DocumentHelper.createDocument();
		try {
			doc = new SAXReader().read(is);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	/**
	 * 获取Document某一节点内容
	 * @param doc
	 * @param node
	 * @return
	 */
	public static String getElement(Document doc, String node){
		try{
		Element rootElt = doc.getRootElement();
		if(StringUtils.isBlank(rootNodeName)){
			setRootNodeName(rootElt.getName());
		}
		Iterator<?> iters = rootElt.elementIterator();
		while(iters.hasNext()){
			Element elt = (Element) iters.next();
			if(StringUtils.equalsIgnoreCase(elt.getName(), node)){
				return elt.getText();
			}
		}
		return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取Document所有节点内容，保存到Message中
	 * @param doc
	 * @param nodes
	 * @return
	 */
	public static Message parse(Document doc){
		Message message = new Message();
		try{
			Element rootElt = doc.getRootElement();
			if(StringUtils.isBlank(rootNodeName)){
				setRootNodeName(rootElt.getName());
			}
			Iterator<?> iters = rootElt.elementIterator();
			while(iters.hasNext()){
				Element elt = (Element) iters.next();
				if(ArrayUtils.contains(Message.ALL, elt.getName())){
					BeanUtils.setProperty(message, StringUtils.uncapitalize(elt.getName()), elt.getText());
				}
			}
			return message;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}
	public static Message parse(InputStream is){
		if(is == null){
			return null;
		}
		Document doc = read(is);
		return parse(doc);
		
	}
	public static InputStream create(String[] format, String[] values) {
		File file = new File(BASEPATH + "text.xml");
		try{
			Document doc = DocumentHelper.createDocument();
			Element rootElt = doc.addElement(format[0]);
			for(int i=1;i<format.length;i++){
				Element childElt = rootElt.addElement(format[i]);
				childElt.setText(values[i]);
			}
			Writer fileWriter = new FileWriter(file);
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(doc);
			xmlWriter.close();
			InputStream is = new FileInputStream(file);
			return is;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws DocumentException, IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String[] values = {"", "123456", "654321", "20140411", "text", "很不错"};
		InputStream isa = XmlUtil.create(Message.TEXT, values);
		System.out.println(IOUtils.toString(isa));
	}

	public static String getRootNodeName() {
		return rootNodeName;
	}

	public static void setRootNodeName(String rootNodeName) {
		XmlUtil.rootNodeName = rootNodeName;
	}
}
