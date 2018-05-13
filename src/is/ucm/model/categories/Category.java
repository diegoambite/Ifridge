package is.ucm.model.categories;

import is.ucm.model.Product;

public abstract class Category {
	private String _name;
	
	public Category(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public abstract Product exectute();
	
}
