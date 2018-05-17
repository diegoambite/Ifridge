package is.ucm.integration.list;

import java.util.Hashtable;
import java.util.List;

import is.ucm.buisness.model.FoodContainerTransfer;
import is.ucm.buisness.model.ProductTransfer;
import is.ucm.model.categories.Category;

public interface ListDao {
	public ProductTransfer getProduct(String name);
	public boolean saveProduct(ProductTransfer p);
	public FoodContainerTransfer getAllProducts();
	public boolean deleteProduct(ProductTransfer p);
	public boolean changeAmount(ProductTransfer p, int amount);
}
