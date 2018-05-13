
package is.ucm.util.password;

public class HashPassword extends PasswordDecorator {
	
	public HashPassword(Password p) {
		super(p);
	}
	
	@Override
	public String generate() {
		String pass = super.generate();
		int hash = 7;
		for (int i = 0; i < pass.length(); i++) {
		    hash = hash*31 + pass.charAt(i);
		}
		return String.valueOf(hash);
	}

}