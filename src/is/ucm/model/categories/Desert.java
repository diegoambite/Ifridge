package is.ucm.model.categories;

import is.ucm.model.Product;

public class Desert extends Category {

	private final static String NAME = "desert";
	
	public Desert() {
		super(NAME);
	}

	@Override
	public Product execute(String name, int quantity) {
		return new Product(name, quantity, this);
	}
	
}
