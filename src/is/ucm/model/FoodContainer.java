package is.ucm.model;

import java.util.List;

public class FoodContainer  {
	
	protected List<Product> _foodList;
	
	public void addNewProduct(Product pro) {
		_foodList.add(pro);
	}
	
	public void removeProduct(Product pro){
		_foodList.remove(pro);
	}
	
}
