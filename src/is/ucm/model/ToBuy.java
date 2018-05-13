package is.ucm.model;

public class ToBuy extends FoodContainer{
	
	public void editAmount(Product pro, int amount) {
		_foodList.get(pro.get_category()).get(getIndex(pro)).set_quantity(amount);
	}
}


