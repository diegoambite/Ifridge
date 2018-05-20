package is.ucm.exceptions;

/**
 * Exception thrown by the UserDAO when trying to retrieve a User from the database and fail.
 * @author iFridge team
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
