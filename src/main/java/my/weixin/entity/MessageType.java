package my.weixin.entity;

public class MessageType {
	//普通消息
	public static final String TEXT = "text";//文本消息
	public static final String IMAGE = "image";//图片消息
	public static final String VOICE = "voice";//语音消息
	public static final String VIDEO = "video";//视频消息
	public static final String LOCATION = "location";//地理位置消息
	public static final String LINK = "link";//链接消息
	//事件推送
	public static final String EVENT = "event";//事件消息
	public static final String EVENT_SUBSCRIBE = "subscribe";//订阅
	public static final String EVENT_UNSUBSCRIBE = "unsubscribe";//取消订阅
	public static final String EVENT_QR_SUBSCRIBE = "subscribe_qrscene_";//关注公众号+扫描二维码
	public static final String EVENT_SCAN = "SCAN";//扫描二维码
	public static final String EVEN_LOCATION = "LOCATION";//上报地理位置
	public static final String EVENT_CLICK = "CLICK";//点击菜单拉取消息
	public static final String EVENT_VIEW = "VIEW";//点击菜单跳转链接
	public static final String EVENT_VOICE_RECOGNITION = "voice_recognition";//语音识别
}
