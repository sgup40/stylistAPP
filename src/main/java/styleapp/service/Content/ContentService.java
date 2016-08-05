package styleapp.service.Content;

import styleapp.model.Content;

public class ContentService {

	Content content = new Content();

	public String getContent(Integer userId) {
		return getContentMock(userId);
	}

	//This need to be chnage with original DB
	private String getContentMock(Integer userId) {
		if (12345 == userId) {
			return "test case method";
		}

		return "Stylist Content";
	}

}
