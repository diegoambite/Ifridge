package is.ucm.buisness.model.user;

import java.io.IOException;

import is.ucm.integration.user.UserDao;
import is.ucm.integration.user.UserDaoImpl;
import is.ucm.util.password.Password;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

public class User {
	
	private UserTransfer _user;

	private UserDao _dao;
	
	public User() {
		_dao = new UserDaoImpl();
		_user = new UserTransfer();
	}
	
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
	
	public UserTransfer registerUser(String username, Password password) {
		try {
			_user = _dao.setNewUser(username, password);
		} catch (IOException e) {
			_user = new UserTransfer();
		}
		
		return _user;
	}
	
}
