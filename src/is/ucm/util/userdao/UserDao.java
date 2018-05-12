package is.ucm.util.userdao;

import java.io.IOException;
import java.util.List;

import is.ucm.model.User;

public interface UserDao {
	public User getUser(String username);
	public void setNewUser(String username, String password) throws IOException;
	public List<User> getAllUsers();
	public void updateUser(String username, String password);
	public void deleteUser(String username);
	public boolean isUser(String username);
}
