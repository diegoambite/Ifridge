package is.ucm.business.model;

/**
 * Used to connect the fridge and to-buy to the tables on the view
 */
public interface ListsObserver {
	
	/**
	 * Method to be performed when a product is removed
	 * @param list
	 * @param c
	 */
	public void onRemove(ProductTransfer p);
	
	/**
	 * Method to be performed when a product is added
	 * @param list
	 */
	public void onAdd(ProductTransfer p);
	
	/**
	 * Method to be performed when a product is edited
	 * @param c
	 */
	public void onEdit(ProductTransfer p);
}
