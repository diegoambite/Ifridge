package is.ucm.business.model.user;

public class UserTransfer {
	
	private String _name = "";
	private String _password = "";
	private boolean _empty = true;
	
	
	public UserTransfer() {
		_empty = true;
	}
	
	public UserTransfer(String name, String password) {
		_name = name;
		_password = password;
		this._empty = false;
	}
	
	public String get_name() {
		return _name;
	}
	
	public void set_name(String _name) {
		this._name = _name;
		this._empty = false;
	}

	public String get_password() {
		return _password;
	}
	
	public void set_password(String _password) {
		this._password = _password;
	}
	
	public boolean isEmpty() {
		return _empty;
	}

	
	
}
