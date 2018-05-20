package is.ucm.model.appservice;

import java.util.List;

import is.ucm.model.business.Fridge;
import is.ucm.model.business.ShopList;
import is.ucm.model.business.User;
import is.ucm.model.observer.ListsObserver;
import is.ucm.model.transfer.FoodContainerTransfer;
import is.ucm.model.transfer.ProductTransfer;
import is.ucm.model.transfer.UserTransfer;
import is.ucm.util.password.BasePassword;
import is.ucm.util.password.HashPassword;

public class AppService {
	
	private Fridge _fridge;
	
	private ShopList _shopList;
	
	private User _user;
	
	public AppService() {
		_fridge = new Fridge();
		_shopList = new ShopList();
		_user = new User();
	}
	
	/**
	 * Logs a user into the system
	 * @param username
	 * @param password
	 * @return
	 */
	public UserTransfer logInUser(String username, String password) {
		return _user.logIn(username, new HashPassword(new BasePassword(password)));
	}
	
	/**
	 * Registers a new user into the system
	 * @param username
	 * @param password
	 * @return
	 */
	public UserTransfer registerUser(String username, String password) {
		return _user.registerUser(username, new HashPassword(new BasePassword(password)));
	}
	
	public FoodContainerTransfer loadData(String id) {
		switch(id) {
		case "shopList":
			return _shopList.loadData();
		case "fridge":
			return _fridge.loadData();
		}
		return null;
		
	}

	public void addFridgeObserver(ListsObserver c) {
		_fridge.addObserver(c);
	}

	public void addShopObserver(ListsObserver c) {
		_shopList.addObserver(c);
	}

	public void deleteObjects(List<ProductTransfer> selected, String string) {
		switch(string) {
		case "shopList":
			_shopList.deleteObjects(selected);
			break;
		case "fridge":
			_fridge.deleteObjects(selected);
			break;
		}
		return;
		
	}

	public void addObject(ProductTransfer productTransfer, String string) {
		switch(string) {
		case "shopList":
			_shopList.addObject(productTransfer);
			break;
		case "fridge":
			_fridge.addObject(productTransfer);
			break;
		}
		return;
		
	}

	public void deleteObject(ProductTransfer productTransfer, String string) {
		switch(string) {
		case "shopList":
			_shopList.deleteObject(productTransfer);
			break;
		case "fridge":
			_fridge.deleteObject(productTransfer);
			break;
		}
		return;
		
	}

}
