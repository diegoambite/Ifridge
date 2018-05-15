package is.ucm.model;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Model {
	
	private String _user, _password, _mail, _file;
	
	private int _age;
	
	public void saveData(String user, String psw, String mail, String file, int age) {
		_user = user;
		_password = psw;
		_mail = mail;
		_file = file;
		_age = age;
	}
	
	public void saveFile() {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("c:/" + _file + ".txt");
            pw = new PrintWriter(fichero);

            pw.println("user: " + _user + " password: " + _password  + " mail: " + _mail + " file: " + _file);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}

}
