package is.ucm.model;

public class Category {
	
	public Type _myType;
	
	public enum Type {
	   VEGETABLE, MEAT, FISH, FRUIT, DRINK, FROZEN, DESSERT
	}
	
	public Type getCategory() {
		return _myType;
	}
	
	
}
