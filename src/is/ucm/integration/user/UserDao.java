
package is.ucm.integration.user;

import java.io.IOException;
import java.util.List;

import is.ucm.buisness.model.user.UserTransfer;
import is.ucm.util.password.Password;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

public interface UserDao {
	public UserTransfer getUser(String username) throws IOException, UserNotFoundException;
	public UserTransfer setNewUser(String username, Password password) throws IOException;
	public List<UserTransfer> getAllUsers();
	public UserTransfer updateUser(String username, Password password) throws IOException;
	public void deleteUser(String username);
	public boolean isUser(String username) throws IOException;
}
