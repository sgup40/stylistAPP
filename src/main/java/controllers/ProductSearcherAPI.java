package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import product.search.vo.ProductData;
import product.search.vo.ProductDetails;
import product.search.vo.SearchResults;


@RestController
public class ProductSearcherAPI {

	private static final Logger logger = LoggerFactory.getLogger(ProductSearcherAPI.class);
	
	@RequestMapping("/product")
	public ProductDetails getProductDetails(@RequestParam(value = "term", defaultValue = "clothing") String name) {
		final String methodName = "getProductDetails";
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://commerce-api.stage.marksandspencer.com/shop-search-api/"
				+ "v1/search?searchTerm=jeans&resultsPerPage=5";
		logger.info(methodName + "Url Getting invoked = " + url);
		SearchResults searchResult = restTemplate.getForObject(url, SearchResults.class);
		return processSearchResults(searchResult);
	}

	private ProductDetails processSearchResults(SearchResults searchResult) {
		ProductDetails prodDetails = new ProductDetails();
		searchResult.getResults().forEach(result -> {
			ProductData productData = new ProductData();
			productData.setTitle(result.getTitle());
			productData.setPrice(result.getPrice().getCurrent().getValue());
			productData.setProductMainImage(result.getProductMainImage());
			productData.setRatings(result.getRatings().getScoreText());
			productData.setAltText(result.getAltText());
			productData.setProductPartNumber(result.getProductPartNumber());
			productData.setProductDescription(result.getProductDescription());
			prodDetails.getResults().add(productData);
		});
		return prodDetails;
	}

}
