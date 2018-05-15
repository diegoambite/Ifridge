package is.ucm.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import is.ucm.model.categories.Category;
import is.ucm.model.categories.InvokerCategories;

public class FoodContainer {
	
	/**
	 * Products are arranged in a hashtable, where each collision list is represented by a category
	 */
	protected Hashtable<Category, List<Product>> _foodList;
	
	public FoodContainer() {
		
		_foodList = new Hashtable<Category, List<Product>>();
		
		// add a collision list for every category of the fridge
		for (Category c : InvokerCategories.getCategories())
			_foodList.put(c, new ArrayList<Product>());

	}

	/**
	 * Adds a product to the food list
	 * @param pro
	 */
	public void addNewProduct(Product pro) {
		
		_foodList.get(pro.get_category()).add(pro);
	}
	
	/**
	 * Removes a product from the food list, or decreases the quantity counter by one
	 * @param pro
	 */
	public void removeProduct(Product pro){
		 
		// identify the collision list of the product
		List<Product> collision_list = _foodList.get(pro.get_category());
		if(collision_list == null) return;
		
		// identify its index inside the collision list
		int index = getIndex(pro);
		if(index == -1) return;
		
		// obtain a reference to the product inside the food list
		Product p = collision_list.get(index);
		if(p == null) return;
		
		if (p.get_quantity() > 1) {
			p.set_quantity(p.get_quantity() - 1);
			collision_list.set(index, p);
		}
		else
			collision_list.remove(index);
	}
	
	/**
	 * Returns the index of the passed product in the collision list of the hashtable
	 * @param pro
	 * @return
	 */
	public int getIndex(Product pro) {
		int index = -1;
		for(int i = 0; i < _foodList.get(pro.get_category()).size(); ++i) {
			if(_foodList.get(pro.get_category()).get(i).get_name().equals(pro.get_name())) {
				index =  i;
				break;
			}
		}
		return index;
	}
	
	public Product removeRandomProduct() {
		try {
			Random rand = new Random();
			int table = rand.nextInt(_foodList.size());
			Category c = InvokerCategories.getCategories()[table];
			int list = rand.nextInt(_foodList.get(c).size());
			Product p = _foodList.get(c).get(list);
			if (p.get_quantity() > 1) {
				p.set_quantity(p.get_quantity() - 1);
				_foodList.get(c).set(list, p);
				return p;
			}
			else {
				_foodList.get(c).remove(list);
			}
			return p;
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
}
