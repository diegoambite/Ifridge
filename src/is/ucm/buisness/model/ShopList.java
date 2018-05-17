package is.ucm.buisness.model;

import java.util.ArrayList;
import java.util.List;

import is.ucm.buisness.model.Observable;
import is.ucm.integration.list.ListDao;
import is.ucm.integration.list.ListDaoImpl;
import is.ucm.model.categories.Category;

public class ShopList implements Observable<ListsObserver> {
		
	private List<ListsObserver> _obs;
	
	private FoodContainerTransfer _food;
	
	private ListDao _dao;

	public ShopList() {
		_obs = new ArrayList<ListsObserver>();
		_dao = new ListDaoImpl("ShopList"); //change the directory
		_food = _dao.getAllProducts();
		for (Category c : _food.getCategories()) {
			for (ProductTransfer p : _food.getList(c)) {
				NotifyAdd(p);
			}
		}
	}
	
	
	
	// OBSERVER MANAGEMENT FUNCTIONS
	
	@Override
	public void addObserver(ListsObserver o) {
		_obs.add(o);
	}
	
	@Override
	public void removeObserver(ListsObserver o) {
		_obs.remove(o);
	}
	
	public void NotifyAdd(ProductTransfer p) {
		for (ListsObserver o : _obs)
			o.onAdd(p);
	}
	
	public void NotifyRemove(ProductTransfer p) {
		for (ListsObserver o : _obs)
			o.onRemove(p);
	}
}


