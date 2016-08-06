package styleapp.service.Content;

import java.util.ArrayList;
import java.util.List;

import styleapp.model.Product;

public class LoveListService {

	List<Product> productList = new ArrayList<Product>();

	public List<Product> getLoveList() {
		return getLoveListMock();
	}

	// This need to be chnage with original DB
	private List<Product> getLoveListMock() {
		Product p1 = new Product();
		p1.setPartnumber("firstpart");
		p1.setImageUrl("isdsd");
		productList.add(p1);
		return productList;

	}

}
