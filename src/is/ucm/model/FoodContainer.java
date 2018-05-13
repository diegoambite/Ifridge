package is.ucm.model;

import java.util.Hashtable;
import java.util.List;

public class FoodContainer  {
	
	protected Hashtable<Category, List<Product>> _foodList;
	
	public FoodContainer() {
		
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
	
}
