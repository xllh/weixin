package my.weixin.entity;

public class Message {
	public static final String ROOT = "xml";
	public static final String TO_USER_NAME = "ToUserName";
	public static final String FROM_USER_NAME = "FromUserName";
	public static final String CREATE_TIME = "CreateTime";
	public static final String MSGTYPE = "MsgType";
	public static final String CONTENT = "Content";
	public static final String MSGID = "MsgId";
	public static final String PICURL = "PicUrl";
	public static final String MEDIAIMAGE = "Image";
	public static final String FORMAT = "Format";
	public static final String MEDIAID = "MediaId";
	public static final String THUMBMEDIAID = "ThumbMediaId";
	public static final String LOCATION_X = "Location_X";
	public static final String LOCATION_Y = "Location_Y";
	public static final String SCALE = "Scale";
	public static final String LABEL = "Label";
	public static final String TITLE = "Title";
	public static final String DESCRIPTION = "Description";
	public static final String URL = "Url";
	
	public static final String E_EVENT = "Event";
	public static final String E_EVENT_KEY = "EventKey";
	public static final String E_TICKET = "Ticket";
	public static final String E_LATITUDE = "Latitude";
	public static final String E_LONGITUDE = "Longitude";
	public static final String E_PRECISION = "Precision";
	
	public static final String E_VOICE_RECOGNITION = "Recognition";
	
	public String toUserName;
	public String fromUserName;
	public String createTime;
	public String msgType;
	public String content;
	public String msgId;
	public String picUrl;
	public String format;
	public String mediaId;
	public String thumbMediaId;
	public String locationX;
	public String locationY;
	public String scale;
	public String label;
	public String title;
	public String description;
	public String url;
	public String image;
	
	public String event;
	public String eventKey;
	public String ticket;
	public String latitude;
	public String longitude;
	public String precision;
	public String recognition;
	
	public String messageType;

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	//文本消息
	public static String[] TEXT = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		CONTENT
		};
	//图片消息
	public static String[] IMAGE = {
		ROOT, TO_USER_NAME, FROM_USER_NAME,
		CREATE_TIME, MSGTYPE,
		MEDIAIMAGE
		};
	//语音消息
	public static String[] VOICE = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		MEDIAID, FORMAT, MSGID
	};
	//视频消息
	public static String[] VIDEO = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		MEDIAID, THUMBMEDIAID, MSGID
	};
	//地理位置消息
	public static String[] LOCATION = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		LOCATION_X, LOCATION_Y,
		SCALE, LABEL, MSGID
	};
	//链接消息
	public static String[] LINK = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		TITLE, DESCRIPTION, URL, MSGID
	};
	
	//事件：订阅
	public static String[] EVENT_SUBSCRIBE = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE, E_EVENT
	};
	//事件：扫描二维码
	public static String[] EVENT_SCAN = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE, E_EVENT, 
		E_EVENT_KEY, E_TICKET
	};
	//事件：上报地理位置
	public static String[] EVENT_LOCATION = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		E_EVENT, E_EVENT_KEY, E_TICKET
	};
	//事件：自定义菜单-点击菜单拉取消息
	public static String[] EVENT_CLICK = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		E_EVENT, E_EVENT_KEY
	};
	//事件：自定义菜单-点击菜单跳转链接
	public static String[] EVENT_VIEW = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		E_EVENT, E_EVENT_KEY
	};
	//接收语音识别结果
	public static String[] EVENT_VOICE = {
		ROOT, TO_USER_NAME, FROM_USER_NAME, 
		CREATE_TIME, MSGTYPE,
		MEDIAID, FORMAT, E_VOICE_RECOGNITION, MSGID
	};
	
	public static String[] ALL = {
		ROOT, TO_USER_NAME, FROM_USER_NAME,
		CREATE_TIME, MSGTYPE,
		CONTENT, MSGID, PICURL, FORMAT, MEDIAID, THUMBMEDIAID, LOCATION_X,
		LOCATION_Y, SCALE, LABEL, TITLE, DESCRIPTION,
		URL, E_EVENT, E_EVENT_KEY, E_TICKET,
		E_LATITUDE, E_LONGITUDE, E_PRECISION, E_VOICE_RECOGNITION
	};

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String voicRecognition) {
		this.recognition = voicRecognition;
	}

	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
}
