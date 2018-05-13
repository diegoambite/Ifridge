package is.ucm.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import is.ucm.model.categories.Category;
import is.ucm.model.categories.InvokerCategories;

public class FoodContainer  {
	
	protected Hashtable<Category, List<Product>> _foodList;
	
	public FoodContainer() {
		_foodList = new Hashtable<Category, List<Product>>();
		for (Category c : InvokerCategories.getCategories()) {
			_foodList.put(c, new ArrayList<Product>());
		}
	}
	 
	public void addNewProduct(Product pro) {
		_foodList.get(pro.get_category()).add(pro);
		
	}
	
	public void removeProduct(Product pro){
		_foodList.get(pro.get_category()).remove(pro);
	}
	
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
			_foodList.get(c).remove(list);
			return p;
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
}
