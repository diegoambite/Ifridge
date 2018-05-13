package is.ucm.model.categories;

import is.ucm.model.Product;

public class Meat extends Category {

	private final static String NAME = "meat";
	
	public Meat() {
		super(NAME);
	}

	@Override
	public Product execute(String name, int quantity) {
		return new Product(name, quantity, this);
	}


	
}
