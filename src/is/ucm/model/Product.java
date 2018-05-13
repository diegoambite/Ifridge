package is.ucm.model;

import is.ucm.model.categories.Category;

public class Product {

	private String _name;
	private int _quantity;
	private Category _category;

	public Product(String name, int quantity, is.ucm.model.categories.Category category) {
		_name = name;
		_quantity = quantity;
		_category = category;
	}
	
	public String get_name() {
		return _name;
	}
	
	public void set_name(String _name) {
		this._name = _name;
	}
	
	public int get_quantity() {
		return _quantity;
	}
	
	public void set_quantity(int _quantity) {
		this._quantity = _quantity;
	}
	
	public Category get_category() {
		return _category;
	}
	
	@Override
	public int hashCode() {
		return _category.hashCode();
		
	}
}
