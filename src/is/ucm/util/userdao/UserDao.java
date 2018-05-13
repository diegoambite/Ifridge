package is.ucm.util.userdao;

import java.io.IOException;
import java.util.List;

import is.ucm.model.User;
import is.ucm.util.password.Password;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

public interface UserDao {
	public User getUser(String username) throws IOException, UserNotFoundException;
	public void setNewUser(String username, Password password) throws IOException;
	public List<User> getAllUsers();
	public void updateUser(String username, Password password) throws IOException;
	public void deleteUser(String username);
	public boolean isUser(String username) throws IOException;
}
