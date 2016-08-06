package styleapp.model;

public class StyleContent {
	public long getStyleContentId() {
		return StyleContentId;
	}

	public void setStyleContentId(long styleContentId) {
		StyleContentId = styleContentId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	private long StyleContentId;
	private String Content;

}
