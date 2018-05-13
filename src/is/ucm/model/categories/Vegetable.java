package is.ucm.model.categories;

import is.ucm.model.Product;

public class Vegetable extends Category {

private final static String NAME = "vegetable";
	
	public Vegetable() {
		super(NAME);
	}

	@Override
	public Product execute(String name, int quantity) {
		return new Product(name, quantity, this);
	}

}
