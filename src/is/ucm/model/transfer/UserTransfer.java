package is.ucm.model.transfer;

/**
 * Value Object containing all the information about a user. 
 * It also allows the client to retrieve the data, not to set it.
 * 
 * @author iFridge team
 */
public class UserTransfer {
	
	
	private String _name = "";
	
	private String _password = "";
	
	private boolean _empty = true;
	
	
	// CONSTRUCTORS
	
	public UserTransfer() {
		_empty = true;
	}
	
	public UserTransfer(String name, String password) {
		_name = name;
		_password = password;
		this._empty = false;
	}
	
	
	// GETTERS
	
	public String getName() {
		return _name;
	}
	
	public String getPassword() {
		return _password;
	}
		
	public boolean isEmpty() {
		return _empty;
	}

}
