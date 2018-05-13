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
		_f = new FoodContainer();
		_random = new Random();
		for (IniSection section : _data.getSections()) {
			_f.addNewProduct(getProductfromSection(section));
		}
	}
	
	public Product getProductfromSection(IniSection section) {
		for (Category c : InvokerCategories.getCategories()) {
			if (c.getName().equals(section.getTag())) {
				return c.execute(section.getValue("name"),
						Category.parseNonNegInt(section, "quantity", 0));
			}
		}
		return null;
	}
	
	public FoodContainer getFoodContainer() {
		return _f;
	}

	@Override
	public void run() {
		while(_random.nextInt() < 5) {
			_f.removeRandomProduct();
		}
	}
	
	
}
