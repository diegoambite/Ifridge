
package is.ucm.util.password;

public class PasswordDecorator implements Password {

	private Password _p;
	
	public PasswordDecorator(Password p) {
		_p = p;
	}
	
	@Override
	public String generate() {
		return _p.generate();
	}
	
	@Override
	public String toString() {
		return this.generate();
	}

}