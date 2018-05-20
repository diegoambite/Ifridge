package is.ucm.business.model.appservice;

import java.util.List;

import is.ucm.business.model.FoodContainerTransfer;
import is.ucm.business.model.Fridge;
import is.ucm.business.model.ListsObserver;
import is.ucm.business.model.ProductTransfer;
import is.ucm.business.model.ShopList;
import is.ucm.business.model.user.User;
import is.ucm.business.model.user.UserTransfer;
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
	
	public UserTransfer logInUser(String username, String password) {
		return _user.logIn(username, new HashPassword(new BasePassword(password)));
	}
	
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

}
