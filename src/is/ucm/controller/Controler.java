package is.ucm.controller;

import java.io.IOException;

import is.ucm.model.Model;
import is.ucm.util.userdao.UserDaoImpl;

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

}
