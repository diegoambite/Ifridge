package is.ucm.model.categories;

import is.ucm.model.Product;

public class Dessert extends Category {

	private final static String NAME = "dessert";
	
	public Dessert() {
		super(NAME);
	}

	@Override
	public Product execute(String name, int quantity) {
		return new Product(name, quantity, this);
	}
	
}
