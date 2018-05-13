package is.ucm.model;

import java.util.ArrayList;
import java.util.List;

import is.ucm.model.categories.Category;
import is.ucm.view.Observable;

public class Fridge extends FoodContainer implements Observable<ListsObserver>, FridgeSimulatorObserver{

	private List<ListsObserver> _obs;
	
	public Fridge() {
		_obs = new ArrayList<ListsObserver>();
	}
	
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
	
	public void NotifyAdd(Category c) {
		for (ListsObserver o : _obs) {
			o.onAdd(this._foodList.get(c), c);
		}
	}
	
	public void NotifyRemove(Category c) {
		for (ListsObserver o : _obs) {
			o.onAdd(this._foodList.get(c), c);
		}
	}

	@Override
	public void onRemove(Product p) {
		this.removeProduct(p);
		NotifyRemove(p.get_category());
	}

	@Override
	public void onAdd(Product p) {
		this.addNewProduct(p);
		NotifyAdd(p.get_category());
	}
	
	
}
