package is.ucm.model.categories;

import is.ucm.util.ini.IniSection;
import is.ucm.model.Product;

public abstract class Category {
	
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
	
	/**
	 * Method that returns a complete usable Product
	 * @param productName
	 * @param i
	 * @return The returned Product
	 */
	public abstract Product execute(String productName, int quantity);
	
	public static int parseNonNegInt(IniSection section, String key, int i) {
		
		String tempTime = section.getValue(key);
		
		if (tempTime == null)
			return i;
		
		try {
			return Integer.parseUnsignedInt(tempTime);
		} catch (NumberFormatException e) {
			return i;
		}
	}
	
}
