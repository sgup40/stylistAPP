package product.search.vo;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails {

	public List<ProductData> results = new ArrayList<>();

	public List<ProductData> getResults() {
		return results;
	}

	public void setResults(List<ProductData> results) {
		this.results = results;
	}
	
}
