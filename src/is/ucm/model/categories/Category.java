package is.ucm.model.categories;


import is.ucm.model.Product;

public abstract class Category {
	private String _name;
	
	public Category(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	

	public abstract Product execute(String value, int i);
	
	
	public static int parseNonNegInt(is.ucm.util.ini.IniSection section, String key, int i) {
		String tempTime = section.getValue(key);
		if (tempTime == null) {
			return i;
		}
		try {
			return Integer.parseUnsignedInt(tempTime);
		} catch (NumberFormatException e) {
			return i;
		}
	}
}
