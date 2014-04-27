package my.weixin.xml;

public class VoiceXML extends XMLBase {
	public Voice voice;

	public Voice getVoice() {
		return voice;
	}
	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}

class Voice{
	public String mediaId;

	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
