package is.ucm.buisness.model;

import java.util.ArrayList;
import java.util.List;

import is.ucm.buisness.model.Observable;
import is.ucm.integration.list.ListDao;
import is.ucm.integration.list.ListDaoImpl;
import is.ucm.model.categories.Category;

public class Fridge implements Observable<ListsObserver> {

	private List<ListsObserver> _obs;
	
	private FoodContainerTransfer _food;
	
	private ListDao _dao;
	
	public Fridge() {
		_obs = new ArrayList<ListsObserver>();
		_dao = new ListDaoImpl("resources/fridge/"); //change the directory
		
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



	public FoodContainerTransfer loadData() {
		return _dao.getAllProducts();
	}



	public void deleteObjects(List<ProductTransfer> selected) {
		for (ProductTransfer t : selected) {
			if (_dao.deleteProduct(t)) {
				NotifyRemove(t);
			}
			
		}
		
	}
}
