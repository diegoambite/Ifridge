package is.ucm.business.model;

import java.util.ArrayList;
import java.util.List;

import is.ucm.business.model.categories.Category;
import is.ucm.integration.list.ListDao;
import is.ucm.integration.list.ListDaoImpl;

public class ShopList implements Observable<ListsObserver> {
		
private List<ListsObserver> _obs;
	
	private FoodContainerTransfer _food;
	
	private ListDao _dao;
	
	public ShopList() {
		_obs = new ArrayList<ListsObserver>();
		_dao = new ListDaoImpl("resources/ShopList/"); //change the directory
		_dao.saveProduct(new ProductTransfer("venison", 5, new Category("Meat")));
		_dao.saveProduct(new ProductTransfer("tomatoe", 8, new Category("Vegetables")));
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


