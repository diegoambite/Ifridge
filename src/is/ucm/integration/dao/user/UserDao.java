
package is.ucm.integration.dao.user;

import java.io.IOException;
import java.util.List;

import is.ucm.business.model.transfer.UserTransfer;
import is.ucm.exceptions.UserNotFoundException;
import is.ucm.util.password.Password;

public interface UserDao {
	public UserTransfer getUser(String username) throws IOException, UserNotFoundException;
	public UserTransfer setNewUser(String username, Password password) throws IOException;
	public List<UserTransfer> getAllUsers();
	public UserTransfer updateUser(String username, Password password) throws IOException;
	public void deleteUser(String username);
	public boolean isUser(String username) throws IOException;
}
