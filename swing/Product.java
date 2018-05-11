package swing;

public class Product {

	private int _id;
	private int _quantity;
	private double _calories;
	private String _name;
	private Category _category;
	private State _staye;
	
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public double get_calories() {
		return _calories;
	}
	public void set_calories(double _calories) {
		this._calories = _calories;
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
}
