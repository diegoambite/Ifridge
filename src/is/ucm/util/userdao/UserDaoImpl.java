package is.ucm.util.userdao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import is.ucm.model.User;
import is.ucm.util.ini.Ini;
import is.ucm.util.ini.IniSection;

public class UserDaoImpl implements UserDao {

	public static final String FILESYSTEM = "resources/users.ini";
	public static final String USER_SECTION = "user";
	private File f;
	
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNewUser(String username, String password) throws IOException {
		f = new File(FILESYSTEM);
		f.getParentFile().mkdirs(); 
		f.createNewFile();
		if (this.isUser(username)) {
			this.updateUser(username, password);
			return;
		}
		IniSection user = new IniSection(USER_SECTION);
		user.setValue("username", username);
		user.setValue("password", password);
		
		FileInputStream input = new FileInputStream(f);
		Ini ini = new Ini(input);
		ini.addsection(user);
		FileOutputStream s = new FileOutputStream(f);
		ini.store(s);
		
		
		
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
