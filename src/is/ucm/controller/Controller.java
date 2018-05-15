package is.ucm.controller;

import java.io.IOException;

import is.ucm.model.Fridge;
import is.ucm.model.FridgeSimulator;
import is.ucm.model.ListsObserver;
import is.ucm.model.Model;
import is.ucm.model.ToBuy;
import is.ucm.util.password.BasePassword;
import is.ucm.util.password.HashPassword;
import is.ucm.util.userdao.UserDaoImpl;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

public class Controller {

	private Model _model;
	
	private UserDaoImpl userDao;
	
	private String user, password, mail, file;
	
	private int age;
	
	private FridgeSimulator _s;
	
	private Fridge _f;
	
	private ToBuy _t;
	
	public Controller(Model m) {
		_model = m;
		userDao = new UserDaoImpl();
		_f = new Fridge();
		_t = new ToBuy();
		try {
			_s = new FridgeSimulator("resources/food.ini");
			_s.addObserver(_f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void run() {
		new Thread(_s).start();
	}

	public void quit() {
		
	}
	
	public void registerUser(String username, String password) {
		try {
			userDao.setNewUser(username, new HashPassword(new BasePassword(password)));
		} catch (IOException e) {
			//TODO send message of error to the user
		}
	}
	
	public boolean logInUser(String username, String password) throws IOException, UserNotFoundException {
		return userDao.getUser(username).get_password().equals(new HashPassword(new BasePassword(password)).generate());
	}

	public void addFridgeObserver(ListsObserver o) {
		_f.addObserver(o);
	}

	public void removeFridgeObserver(ListsObserver o) {
		_f.removeObserver(o);
	}
	
	public void addToBuyObserver(ListsObserver o) {
		_t.addObserver(o);
	}

	public void removeToBuyObserver(ListsObserver o) {
		_t.removeObserver(o);
	}

}
