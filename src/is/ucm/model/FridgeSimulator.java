package is.ucm.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import is.ucm.model.categories.InvokerCategories;
import is.ucm.util.ini.Ini;
import is.ucm.util.ini.IniSection;
import is.ucm.model.Observable;
import is.ucm.model.categories.Category;

public class FridgeSimulator implements Runnable, Observable<FridgeSimulatorObserver>  {
	
	Random _random;
	
	Ini _data;
	
	FoodContainer _f;
	
	List<FridgeSimulatorObserver> _obs;
	
	public FridgeSimulator(String file) throws IOException {
		_data = new Ini(file);
		_f = new FoodContainer();
		_random = new Random();
		_obs = new ArrayList<FridgeSimulatorObserver>();
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
		
		// parses all the meals from the ini section
		for (IniSection section : _data.getSections()) {
			Product p = getProductfromSection(section);
			_f.addNewProduct(p);
			NotifyAdd(p);
		}
		
		// keep trying to remove random products
		while(true) {
			if(_random.nextInt(100) < 5)
				NotifyRemove(_f.removeRandomProduct());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
	
	
	// OBSERVER MANAGEMENT FUNCTIONS
	
	public void NotifyRemove(Product p) {
		for (FridgeSimulatorObserver o : _obs) {
			synchronized(o) {
				o.onRemove(p);
			}
			
		}
	}
	
	public void NotifyAdd(Product p) {
		for (FridgeSimulatorObserver o : _obs) {
			synchronized(o) {
				o.onAdd(p);
			}
		}
	}

	@Override
	public void addObserver(FridgeSimulatorObserver o) {
		_obs.add(o);
	}

	@Override
	public void removeObserver(FridgeSimulatorObserver o) {
		_obs.remove(o);
		
	}
	
}