package is.ucm.model;

public class ToBuy extends FoodContainer{
	
	public void editAmount(String piece, int amount) {
		for(int i = 0; i < _foodList.size(); ++i) {
			if (_foodList.get(i).get_name().equals(piece)) 
				_foodList.get(i).set_quantity(amount);
		}
	}
}
