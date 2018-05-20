package is.ucm.model.transfer;

import java.util.HashMap;
import java.util.List;

import is.ucm.model.business.Category;

/**
 * Value object that carries all the information about a food container (fridge or shop list). 
 * @author iFridge team
 */
public class FoodContainerTransfer {
	
	
	/**
	 * Products are arranged in a hashtable, where each collision list is represented by a category
	 */
	private HashMap<Category, List<ProductTransfer>> _foodList;
	
	private List<Category> _categories;
	
	
	// CONSTRUCTOR
	
	public FoodContainerTransfer(HashMap<Category, List<ProductTransfer>> _foodList, List<Category> _categories) {
		this._foodList = _foodList;
		this._categories = _categories;
	}

	
	// GETTERS
	
	public List<ProductTransfer> getList(Category c) {
		return _foodList.get(c);
	}
	
	public List<Category> getCategories() {
		return _categories;
	}

}
