package is.ucm.model.categories;

import java.io.Serializable;

public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	@Override
	public String toString() {
		return _name;
	}
	
	@Override
	public boolean equals(Object c) {
		return this.toString().equals(c.toString());
	}
	
}
