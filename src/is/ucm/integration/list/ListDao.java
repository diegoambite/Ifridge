package is.ucm.integration.list;

import java.util.Hashtable;
import java.util.List;

import is.ucm.buisness.model.FoodContainerTransfer;
import is.ucm.buisness.model.Product;
import is.ucm.model.categories.Category;

public interface ListDao {
	public Product getProduct(String name);
	public boolean saveProduct(Product p);
	public FoodContainerTransfer getAllProducts();
}
