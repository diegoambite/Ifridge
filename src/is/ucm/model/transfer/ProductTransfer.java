package is.ucm.model.transfer;

import java.io.Serializable;

import is.ucm.model.business.Category;

public class ProductTransfer implements Serializable {


	private static final long serialVersionUID = 1L;

	
	private String _name;
	
	private int _quantity;
	
	private Category _category;

	
	// CONSTRUCTOR
	
	public ProductTransfer(String name, int quantity, Category category) {
		_name = name;
		_quantity = quantity;
		_category = category;
	}
	
	
	// GETTERS AND SETTERS
	
	public String getName() {
		return _name;
	}
		
	public int getQuantity() {
		return _quantity;
	}
	
	public Category getCategory() {
		return _category;
	}
	
	
	// UTILITY FUNCTIONS
	
	/**
	 * Overrides the product transfer hash code with the category hash code
	 */
	@Override
	public int hashCode() {
		return _category.hashCode();
	}
	
	/**
	 * String representation of the object
	 */
	@Override
	public String toString() {
		return _name + ": " + _quantity;
	}


	public void set_quantity(int i) {
		this._quantity = i;
		
	}
}