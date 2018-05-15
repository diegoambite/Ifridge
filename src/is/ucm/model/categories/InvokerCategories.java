package is.ucm.model.categories;

public class InvokerCategories {
	
	private static Category[] _categories = {
		new Meat(),
		new Vegetable(),
		new Dessert()
	};
	
	public static Category[] getCategories() {
		return _categories;
	}
}
