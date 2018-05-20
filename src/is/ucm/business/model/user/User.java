package is.ucm.business.model.user;

import java.io.IOException;

import is.ucm.exceptions.UserNotFoundException;
import is.ucm.integration.user.UserDao;
import is.ucm.integration.user.UserDaoImpl;
import is.ucm.util.password.Password;

public class User {
	
	/**
	 * User DTO, to retrieve all the information of a user from the storage system
	 */
	private UserTransfer _user;

	/**
	 * User DAO, to interact with the storage system
	 */
	private UserDao _dao;
	
	
	// CONSTRUCTOR
	
	public User() {
		_dao = new UserDaoImpl();
		_user = new UserTransfer();
	}
	
	
	// USER'S ACTIONS
	
	/**
	 * Logs a user into the system
	 * @param username
	 * @param password
	 * @return
	 */
	public UserTransfer logIn(String username, Password password) {
		try {
			_user = _dao.getUser(username);
			if (!password.generate().equals(_user.get_password())) {
				_user = new UserTransfer();
			}
		} catch (IOException | UserNotFoundException e) {
		}
		
		return _user;
	}
	
	/**
	 * Registers a user into the system
	 * @param username
	 * @param password
	 * @return
	 */
	public UserTransfer registerUser(String username, Password password) {
		try {
			_user = _dao.setNewUser(username, password);
		} catch (IOException e) {
			_user = new UserTransfer();
		}
		
		return _user;
	}
	
}
