<<<<<<< HEAD
<<<<<<< HEAD
package is.ucm.util.password;

public class BasePassword implements Password {

	private String _password;
	
	public BasePassword(String password) {
		_password = password;
	}
	
	@Override
	public String generate() {
		return _password;
	}
	
	@Override
	public String toString() {
		return this.generate();
	}
	
}
=======
package is.ucm.util.password;

public class BasePassword implements Password {

	private String _password;
	
	public BasePassword(String password) {
		_password = password;
	}
	
	@Override
	public String generate() {
		return _password;
	}
	
	@Override
	public String toString() {
		return this.generate();
	}
	
}
>>>>>>> stash
=======
package is.ucm.util.password;

public class BasePassword implements Password {

	private String _password;
	
	public BasePassword(String password) {
		_password = password;
	}
	
	@Override
	public String generate() {
		return _password;
	}
	
	@Override
	public String toString() {
		return this.generate();
	}
	
}
>>>>>>> refs/remotes/origin/master
