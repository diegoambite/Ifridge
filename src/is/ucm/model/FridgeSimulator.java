<<<<<<< HEAD
package is.ucm.model;

import java.io.IOException;
import java.util.Random;

import is.ucm.model.categories.InvokerCategories;
import is.ucm.util.ini.Ini;
import is.ucm.util.ini.IniSection;
import is.ucm.model.categories.Category;

public class FridgeSimulator implements Runnable {
	
	Random _random;
	Ini _data;
	FoodContainer _f;
	
	public FridgeSimulator(String file) throws IOException {
		_data = new Ini(file);
		for (IniSection section : _data.getSections()) {
		
		}
	}
	
	public Product getProductfromSection(IniSection section) {
		for (Category c : InvokerCategories.getCategories()) {
			if (c.getName().equals(section.getTag()) {
				return c.execute(section);
			}
		}
	}

	@Override
	public void run() {
		
	}
	
	
}
=======
package is.ucm.model;

import java.io.IOException;
import java.util.Random;

import is.ucm.model.categories.InvokerCategories;
import is.ucm.util.ini.Ini;
import is.ucm.util.ini.IniSection;
import is.ucm.model.categories.Category;

public class FridgeSimulator implements Runnable {
	
	Random _random;
	Ini _data;
	FoodContainer _f;
	
	public FridgeSimulator(String file) throws IOException {
		_data = new Ini(file);
		for (IniSection section : _data.getSections()) {
		
		}
	}
	
	public Product getProductfromSection(IniSection section) {
		for (Category c : InvokerCategories.getCategories()) {
			if (c.getName().equals(section.getTag()) {
				return c.execute(section);
			}
		}
	}

	@Override
	public void run() {
		
	}
	
	
}
>>>>>>> stash
