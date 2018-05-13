package is.ucm.model;

public class Product {

	private String _name;
	private int _quantity;
	private Category _category;

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
