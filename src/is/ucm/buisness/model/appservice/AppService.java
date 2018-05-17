package is.ucm.buisness.model.appservice;

import is.ucm.buisness.model.Fridge;
import is.ucm.buisness.model.ListsObserver;
import is.ucm.buisness.model.ShopList;
import is.ucm.buisness.model.user.User;
import is.ucm.buisness.model.user.UserTransfer;
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

	public void addFridgeObserver(ListsObserver c) {
		_fridge.addObserver(c);
		
	}

	public void addShopObserver(ListsObserver c) {
		_shopList.addObserver(c);
		
	}
}
