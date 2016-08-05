package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import styleapp.service.Content.ContentService;

@RestController
public class ContentController {

	ContentService contentService = new ContentService();

	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String content(@RequestParam(value = "userID") Integer userID) {

		return contentService.getContent(userID);
	}

}
