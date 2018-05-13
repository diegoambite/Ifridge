package is.ucm.model;

import java.util.List;

import is.ucm.model.categories.Category;

public interface ListsObserver {
	public void onRemove(List<Product> list, Category c);
	public void onAdd(List<Product> list, Category c);
	public void onEdit(Product p);
}
