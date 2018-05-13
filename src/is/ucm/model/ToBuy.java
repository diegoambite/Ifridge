package is.ucm.model;

import is.ucm.view.Observable;

public class ToBuy extends FoodContainer implements Observable<ListsObserver>{
	
	public void editAmount(Product pro, int amount) {
		_foodList.get(pro.get_category()).get(getIndex(pro)).set_quantity(amount);
	}

	@Override
	public void addObserver(ListsObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(ListsObserver o) {
		// TODO Auto-generated method stub
		
	}
}


