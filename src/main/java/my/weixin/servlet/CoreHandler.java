package my.weixin.servlet;

import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import my.weixin.entity.Message;
import my.weixin.entity.MessageType;
import my.weixin.util.XmlUtil;

public class CoreHandler {
	protected final Log log = LogFactory.getLog(getClass());
	public InputStream is = null;
	public CoreHandler(InputStream is){
		this.is = is;
	}
	public Message process(){
		if(getIs() == null){
			return null;
		}
		Message userMsg = XmlUtil.parse(getIs());
		Message responseMsg = new Message();
		responseMsg.setFromUserName(userMsg.getToUserName());
		responseMsg.setToUserName(userMsg.getFromUserName());
		responseMsg.setCreateTime(Long.toString(System.currentTimeMillis()));
		if(StringUtils.equalsIgnoreCase(userMsg.getMsgType(), MessageType.TEXT)){//文字消息
			responseMsg.setMsgType(MessageType.TEXT);
			responseMsg.setContent("您发送信息为："+userMsg.getContent());
		}else if(StringUtils.equalsIgnoreCase(userMsg.getMsgType(), MessageType.IMAGE)){//图片信息
			responseMsg.setMsgType(MessageType.IMAGE);
			responseMsg.setImage("<MediaId>"+userMsg.getMediaId()+"</MediaId>");
		}else if(StringUtils.equalsIgnoreCase(userMsg.getMsgType(), MessageType.VOICE)&&StringUtils.isBlank(userMsg.getRecognition())){//语音消息
			
		}else if(StringUtils.equalsIgnoreCase(userMsg.getMsgType(), MessageType.VIDEO)){//视频
			
		}else if(StringUtils.equalsIgnoreCase(userMsg.getMsgType(), MessageType.LOCATION)){//地理位置
			responseMsg.setMsgType(MessageType.TEXT);
			responseMsg.setContent("您的位置为："+userMsg.getLabel()+"。");
		}else if(StringUtils.equalsIgnoreCase(userMsg.getMsgType(), MessageType.LINK)){//链接
			
		}else if(StringUtils.equalsIgnoreCase(userMsg.getMsgType(), MessageType.EVENT)){//事件
			if(StringUtils.equalsIgnoreCase(userMsg.getEvent(), MessageType.EVENT_SUBSCRIBE)&&StringUtils.isBlank(userMsg.getEventKey())){//订阅事件
				
			}else if(StringUtils.equalsIgnoreCase(userMsg.getEvent(), MessageType.EVENT_UNSUBSCRIBE)){//取消关注事件
				
			}else if(StringUtils.equalsIgnoreCase(userMsg.getEvent(), MessageType.EVENT_SUBSCRIBE)&&StringUtils.isNotBlank(userMsg.getEventKey())){//订阅，扫描二维码
				
			}else if(StringUtils.equalsIgnoreCase(userMsg.getEvent(), MessageType.EVENT_SCAN)){//扫描二维码事件
				
			}else if(StringUtils.equalsIgnoreCase(userMsg.getEvent(), MessageType.LOCATION)){//上报地理位置事件
				
			}else if(StringUtils.equalsIgnoreCase(userMsg.getEvent(), MessageType.EVENT_CLICK)){//点击菜单拉取消息事件
				responseMsg.setMsgType(MessageType.TEXT);
				responseMsg.setContent("这是一个狂拽库选掉炸天的服务号。");
			}else if(StringUtils.equalsIgnoreCase(userMsg.getEvent(), MessageType.EVENT_VIEW)){//点击菜单跳转链接事件
				log.info("访问页面：" + userMsg.getEventKey());
			}
		}else if(StringUtils.equalsIgnoreCase(userMsg.getMsgType(), MessageType.VOICE)&&StringUtils.isNotBlank(userMsg.getRecognition())){//语音识别
			responseMsg.setMsgType(MessageType.TEXT);
			responseMsg.setContent("你是说：" + userMsg.getRecognition()+"?");
		}else{
			return null;
		}
		return responseMsg;
	}
	public InputStream response(Message responseMsg){
		InputStream responseXml = null;
		if(StringUtils.equalsIgnoreCase(responseMsg.getMsgType(), MessageType.TEXT)){//文字消息
			String[] values = {"", responseMsg.getToUserName(), responseMsg.getFromUserName(), responseMsg.getCreateTime(), responseMsg.getMsgType(), responseMsg.getContent()};
			responseXml= XmlUtil.create(Message.TEXT, values);
		}else if(StringUtils.equalsIgnoreCase(responseMsg.getMsgType(), MessageType.IMAGE)){//图片信息
			String[] values = {"", responseMsg.getToUserName(), responseMsg.getFromUserName(), responseMsg.getCreateTime(), responseMsg.getMsgType(), responseMsg.getImage()};
			responseXml= XmlUtil.create(Message.IMAGE, values);
		}else if(StringUtils.equalsIgnoreCase(responseMsg.getMsgType(), MessageType.VOICE)&&StringUtils.isBlank(responseMsg.getRecognition())){//语音消息
			
		}else if(StringUtils.equalsIgnoreCase(responseMsg.getMsgType(), MessageType.VIDEO)){//视频
			
		}else if(StringUtils.equalsIgnoreCase(responseMsg.getMsgType(), MessageType.LOCATION)){//地理位置
			
		}else if(StringUtils.equalsIgnoreCase(responseMsg.getMsgType(), MessageType.LINK)){//链接
			
		}else if(StringUtils.equalsIgnoreCase(responseMsg.getMsgType(), MessageType.EVENT)){//事件
			if(StringUtils.endsWithIgnoreCase(responseMsg.getEvent(), MessageType.EVENT_SUBSCRIBE)&&StringUtils.isBlank(responseMsg.getEventKey())){//订阅事件
				
			}else if(StringUtils.endsWithIgnoreCase(responseMsg.getEvent(), MessageType.EVENT_UNSUBSCRIBE)){//取消关注事件
				
			}else if(StringUtils.endsWithIgnoreCase(responseMsg.getEvent(), MessageType.EVENT_SUBSCRIBE)&&StringUtils.isNotBlank(responseMsg.getEventKey())){//订阅，扫描二维码
				
			}else if(StringUtils.endsWithIgnoreCase(responseMsg.getEvent(), MessageType.EVENT_SCAN)){//扫描二维码事件
				
			}else if(StringUtils.endsWithIgnoreCase(responseMsg.getEvent(), MessageType.LOCATION)){//上报地理位置事件
				
			}else if(StringUtils.endsWithIgnoreCase(responseMsg.getEvent(), MessageType.EVENT_CLICK)){//点击菜单拉取消息事件
				
			}else if(StringUtils.endsWithIgnoreCase(responseMsg.getEvent(), MessageType.EVENT_VIEW)){//点击菜单跳转链接事件
				
			}
		}else if(StringUtils.endsWithIgnoreCase(responseMsg.getEvent(), MessageType.VOICE)&&StringUtils.isNotBlank(responseMsg.getRecognition())){//语音识别
			
		}else{
			return null;
		}
		return responseXml;
	}
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
}
