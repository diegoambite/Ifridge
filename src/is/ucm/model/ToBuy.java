package is.ucm.model;

public class ToBuy extends FoodContainer{
	
	public void editAmount(Product pro, int amount) {
		for(int i = 0; i < _foodList.size(); ++i) {
			if (_foodList.get(i) == pro) 
				_foodList.get(i).set_quantity(amount);
		}
	}
}
