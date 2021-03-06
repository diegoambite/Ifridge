package is.ucm.model.business;

import java.util.ArrayList;
import java.util.List;

import is.ucm.integration.dao.list.ListDao;
import is.ucm.integration.dao.list.ListDaoImpl;
import is.ucm.model.observer.ListsObserver;
import is.ucm.model.observer.Observable;
import is.ucm.model.transfer.FoodContainerTransfer;
import is.ucm.model.transfer.ProductTransfer;

public class ShopList implements Observable<ListsObserver> {
	
	
	private List<ListsObserver> _obs;
		
	private ListDao _dao;
	
	
	// CONSTRUCTOR
	
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

	
	// FUNCTIONAL METHODS
	
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


	public void addObject(ProductTransfer productTransfer) {
		if (_dao.saveProduct(productTransfer)) {
			NotifyAdd(productTransfer);
		}
		
	}


	public void deleteObject(ProductTransfer productTransfer) {
		if (_dao.deleteProduct(productTransfer)) {
			NotifyRemove(productTransfer);
		}
	}
}


