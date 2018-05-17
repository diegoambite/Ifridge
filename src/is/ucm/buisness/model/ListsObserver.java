package is.ucm.buisness.model;

import java.util.List;

import is.ucm.model.categories.Category;

/**
 * Used to connect the fridge and to-buy to the tables on the view
 */
public interface ListsObserver {
	
	/**
	 * Method to be performed when a product is removed
	 * @param list
	 * @param c
	 */
	public void onRemove(Product p);
	
	/**
	 * Method to be performed when a product is added
	 * @param list
	 */
	public void onAdd(Product p);
	
	/**
	 * Method to be performed when a product is edited
	 * @param c
	 */
	public void onEdit(Product p);
}
