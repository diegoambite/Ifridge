<<<<<<< HEAD
<<<<<<< HEAD
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
import is.ucm.util.password.Password;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

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
	public User getUser(String username) throws IOException, UserNotFoundException {
		Ini ini = getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				return new User(username, section.getValue("password"));
			}
		}
		throw new UserNotFoundException("The user " + username + " could not be found in the filesystem");
	}

	@Override
	public void setNewUser(String username, Password password) throws IOException {
		
		if (this.isUser(username)) {
			this.updateUser(username, password);
			return;
		}
		IniSection user = new IniSection(USER_SECTION);
		user.setValue("username", username);
		user.setValue("password", password);
		
		Ini ini = getIniFile();
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
	public void updateUser(String username, Password password) throws IOException {
		Ini ini  = this.getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				section.setValue("password", password);
			}
		}
		
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
=======
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
import is.ucm.util.password.Password;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

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
	public User getUser(String username) throws IOException, UserNotFoundException {
		Ini ini = getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				return new User(username, section.getValue("password"));
			}
		}
		throw new UserNotFoundException("The user " + username + " could not be found in the filesystem");
	}

	@Override
	public void setNewUser(String username, Password password) throws IOException {
		
		if (this.isUser(username)) {
			this.updateUser(username, password);
			return;
		}
		IniSection user = new IniSection(USER_SECTION);
		user.setValue("username", username);
		user.setValue("password", password);
		
		Ini ini = getIniFile();
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
	public void updateUser(String username, Password password) throws IOException {
		Ini ini  = this.getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				section.setValue("password", password);
			}
		}
		
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
>>>>>>> stash
=======
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
import is.ucm.util.password.Password;
import is.ucm.util.userdao.exceptions.UserNotFoundException;

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
	public User getUser(String username) throws IOException, UserNotFoundException {
		Ini ini = getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				return new User(username, section.getValue("password"));
			}
		}
		throw new UserNotFoundException("The user " + username + " could not be found in the filesystem");
	}

	@Override
	public void setNewUser(String username, Password password) throws IOException {
		
		if (this.isUser(username)) {
			this.updateUser(username, password);
			return;
		}
		IniSection user = new IniSection(USER_SECTION);
		user.setValue("username", username);
		user.setValue("password", password);
		
		Ini ini = getIniFile();
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
	public void updateUser(String username, Password password) throws IOException {
		Ini ini  = this.getIniFile();
		for (IniSection section : ini.getSections()) {
			if (section.getValue("username").equals(username)) {
				section.setValue("password", password);
			}
		}
		
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
>>>>>>> refs/remotes/origin/master
