
package is.ucm.integration.dao.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import is.ucm.business.model.transfer.UserTransfer;
import is.ucm.exceptions.UserNotFoundException;
import is.ucm.util.ini.Ini;
import is.ucm.util.ini.IniSection;
import is.ucm.util.password.Password;

public class UserDaoImpl implements UserDao {

	public static final String FILESYSTEM = "resources/users.ini";
	public static final String USER_SECTION = "user";
	private File f;
	
	public UserDaoImpl() {
		f = new File(FILESYSTEM);
		f.getParentFile().mkdirs(); 
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Ini getIniFile() throws IOException {
		FileInputStream input = new FileInputStream(f);
		Ini ini = new Ini(input);
		return ini;
	}
	
	@Override
	public UserTransfer getUser(String username) throws IOException, UserNotFoundException {
		Ini ini = getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				return new UserTransfer(username, section.getValue("password"));
			}
		}
		throw new UserNotFoundException("The user " + username + " could not be found in the filesystem");
	}

	@Override
	public UserTransfer setNewUser(String username, Password password) throws IOException {
		
		if (this.isUser(username)) {
			return this.updateUser(username, password);
		}
		IniSection user = new IniSection(USER_SECTION);
		user.setValue("username", username);
		user.setValue("password", password.generate());
		
		Ini ini = getIniFile();
		ini.addsection(user);
		FileOutputStream s = new FileOutputStream(f);
		ini.store(s);
		
		return new UserTransfer(username, password.generate());
		
	}

	@Override
	public List<UserTransfer> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTransfer updateUser(String username, Password password) throws IOException {
		Ini ini  = this.getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				section.setValue("password", password.generate());
			}
		}
		
		return new UserTransfer(username, password.generate());
		
	}

	@Override
	public void deleteUser(String username) {
		
	}

	@Override
	public boolean isUser(String username) throws IOException {
		Ini ini  = this.getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				return true;
			}
		}
		return false;
	}

}
