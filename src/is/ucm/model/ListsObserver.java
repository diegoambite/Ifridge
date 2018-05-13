package is.ucm.model;

public interface ListsObserver {
	public void onRemove(Product p);
	public void onAdd(Product p);
	public void onEdit(Product p);
}
