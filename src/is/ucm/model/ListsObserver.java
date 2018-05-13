package is.ucm.model;

import java.util.List;

public interface ListsObserver {
	public void onRemove(List<Product> list);
	public void onAdd(List<Product> list);
	public void onEdit(Product p);
}
