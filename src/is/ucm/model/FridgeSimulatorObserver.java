package is.ucm.model;

/**
 * Used to connect the fridge simulator with the fridge in order get the items of the fridge.
 */
public interface FridgeSimulatorObserver {
	
	public void onRemove(Product p);
	
	public void onAdd(Product p);
}
