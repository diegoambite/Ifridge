package is.ucm.buisness.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import is.ucm.model.categories.Category;

public class FoodContainerTransfer {
	
	
	
	
	/**
	 * Products are arranged in a hashtable, where each collision list is represented by a category
	 */
	private HashMap<Category, List<ProductTransfer>> _foodList;
	private List<Category> _categories;
	
	public FoodContainerTransfer() {
		
		_foodList = new HashMap<Category, List<ProductTransfer>>();
		_categories = new ArrayList<Category>();

	}

	/**
	 * Adds a product to the food list
	 * @param pro
	 */
	public void addNewProduct(ProductTransfer pro) {
		if (!_foodList.containsKey(pro.get_category())) {
			_foodList.put(pro.get_category(), new ArrayList<ProductTransfer>());
			_categories.add(pro.get_category());
		}
		_foodList.get(pro.get_category()).add(pro);
	}
	
	/**
	 * Removes a product from the food list, or decreases the quantity counter by one
	 * @param pro
	 */
	public void removeProduct(ProductTransfer pro){
		 
		// identify the collision list of the product
		List<ProductTransfer> collision_list = _foodList.get(pro.get_category());
		if(collision_list == null) return;
		
		// identify its index inside the collision list
		int index = getIndex(pro);
		if(index == -1) return;
		
		// obtain a reference to the product inside the food list
		ProductTransfer p = collision_list.get(index);
		if(p == null) return;
		
		if (p.get_quantity() > 1) {
			p.set_quantity(p.get_quantity() - 1);
			collision_list.set(index, p);
		}
		else {
			collision_list.remove(index);
			if (_foodList.get(pro.get_category()).isEmpty()) {
				_foodList.remove(pro.get_category());
				_categories.remove(pro.get_category());
			}
		}
	}
	
	public List<ProductTransfer> getList(Category c) {
		return _foodList.get(c);
	}
	
	public List<Category> getCategories() {
		return _categories;
	}
	
	public void addList(List<ProductTransfer> p, Category c) {
		_foodList.put(c, p);
		_categories.add(c);
	}
	
	
	/**
	 * Returns the index of the passed product in the collision list of the hashtable
	 * @param pro
	 * @return
	 */
	public int getIndex(ProductTransfer pro) {
		int index = -1;
		for(int i = 0; i < _foodList.get(pro.get_category()).size(); ++i) {
			if(_foodList.get(pro.get_category()).get(i).get_name().equals(pro.get_name())) {
				index =  i;
				break;
			}
		}
		return index;
	}
	
}
