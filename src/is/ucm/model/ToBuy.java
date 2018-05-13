package is.ucm.model;

import java.util.List;

import is.ucm.view.Observable;

public class ToBuy extends FoodContainer implements Observable<ListsObserver>{
	
	private List<ListsObserver> _obs;
	
	public void editAmount(Product pro, int amount) {
		_foodList.get(pro.get_category()).get(getIndex(pro)).set_quantity(amount);
	}

	@Override
	public void addObserver(ListsObserver o) {
		_obs.add(o);
	}

	@Override
	public void removeObserver(ListsObserver o) {
		_obs.remove(o);
	}
}


