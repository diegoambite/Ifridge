package is.ucm.presentation.controller;

import java.io.IOException;
import java.util.List;

import is.ucm.exceptions.UserNotFoundException;
import is.ucm.model.appservice.AppService;
import is.ucm.model.observer.ListsObserver;
import is.ucm.model.transfer.FoodContainerTransfer;
import is.ucm.model.transfer.ProductTransfer;

public class Controller {

	
	private AppService _appservice;
	
	
	// CONSTRUCTOR
	
	public Controller() {
		_appservice = new AppService();
		
	}
	
	
	// COMMANDS
	
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


	public void addObject(ProductTransfer productTransfer, String string) {
		_appservice.addObject(productTransfer, string);
		
	}
	
	public void deleteObject(ProductTransfer productTransfer, String string) {
		_appservice.deleteObject(productTransfer, string);
		
	}


	public void moveObjects(List<ProductTransfer> selected) {
		for (ProductTransfer t : selected) {
			_appservice.addObject(t, "fridge");
			_appservice.deleteObject(t, "shopList");
		}
		
	}
	
}
