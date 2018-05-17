package is.ucm.model.categories;

import is.ucm.buisness.model.Product;
import is.ucm.util.ini.IniSection;

public class Category {
	
	/**
	 * The name of the category element
	 */
	private String _name;
	
	public Category(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	
}
