package is.ucm.presentation.controller;

import java.io.IOException;
import java.util.List;

import is.ucm.buisness.model.FoodContainerTransfer;
import is.ucm.buisness.model.ListsObserver;
import is.ucm.buisness.model.ProductTransfer;
import is.ucm.buisness.model.ShopList;
import is.ucm.buisness.model.appservice.AppService;
import is.ucm.buisness.model.user.UserTransfer;
import is.ucm.integration.user.UserDaoImpl;
import is.ucm.presentation.view.ShopTableView;
import is.ucm.presentation.view.TableView;
import is.ucm.util.password.BasePassword;
import is.ucm.util.password.HashPassword;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

public class Controller {
	
	private String user, password, mail, file;
	
	private int age;
	
	private AppService _appservice;
	
	
	public Controller() {
		_appservice = new AppService();
		
	}
	
	public boolean registerUser(String username, String password) {
		return !_appservice.registerUser(username, password).isEmpty();
	}
	
	public boolean logInUser(String username, String password) throws IOException, UserNotFoundException {
		return !_appservice.logInUser(username, password).isEmpty();
	}

	public void addFridgeObserver(ListsObserver c) {
		_appservice.addFridgeObserver(c);
		
	}

	public void addShopObserver(ListsObserver c) {
		_appservice.addShopObserver(c);
		
	}

	public FoodContainerTransfer loadData(String id) {
		return _appservice.loadData(id);
	}

	public void deleteObjects(List<ProductTransfer> selected, String string) {
		_appservice.deleteObjects(selected, string);
		
	}

	

}
