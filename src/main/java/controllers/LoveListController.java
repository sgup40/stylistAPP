package controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import styleapp.model.Product;
import styleapp.service.Content.LoveListService;

@RestController
public class LoveListController {

	LoveListService loveListService = new LoveListService();

	@RequestMapping(value = "/LoveList", method = RequestMethod.GET)
	public List<Product> loveList() {

		return loveListService.getLoveList();
	}

	
}
