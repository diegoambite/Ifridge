package is.ucm.model.transfer;

import java.io.Serializable;

import is.ucm.model.business.Category;

public class ProductTransfer implements Serializable {


	private static final long serialVersionUID = 1L;

	
	/**
	 * Name of the product (Unique).
	 */
	private String _name;
	
	private int _quantity;
	
	private Category _category;

	
	// CONSTRUCTOR
	
	public ProductTransfer(String name, int quantity, is.ucm.model.business.Category category) {
		_name = name;
		_quantity = quantity;
		_category = category;
	}
	
	
	// GETTERS AND SETTERS
	
	public String get_name() {
		return _name;
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
	
	
	// UTILITY FUNCTIONS
	
	/**
	 * Returns a hash code for the object based on the product category
	 */
	@Override
	public int hashCode() {
		return _category.hashCode();
	}
	
	@Override
	public String toString() {
		return _name + ": " + _quantity;
	}
}