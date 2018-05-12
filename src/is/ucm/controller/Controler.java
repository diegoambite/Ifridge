package is.ucm.controller;

import java.io.IOException;

import is.ucm.model.Model;
import is.ucm.util.userdao.UserDaoImpl;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

public class Controler {

	private Model _model;
	private UserDaoImpl userdao;
	
	private String user, passsword, mail, file;
	private int age;
	
	public Controler(Model m) {
		_model = m;
		userdao = new UserDaoImpl();
	}

	public void quit() {
		
	}
	
	public void registerUser(String username, String password) {
		try {
			userdao.setNewUser(username, password);
		} catch (IOException e) {
			//TODO send message of error to the user
		}
	}
	
	public boolean logInUser(String username, String password) throws IOException, UserNotFoundException {
		return userdao.getUser(username).get_password().equals(password);
	}

}
