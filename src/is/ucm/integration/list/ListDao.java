package is.ucm.integration.list;

import is.ucm.business.model.FoodContainerTransfer;
import is.ucm.business.model.ProductTransfer;

public interface ListDao {
	public ProductTransfer getProduct(String name);
	public boolean saveProduct(ProductTransfer p);
	public FoodContainerTransfer getAllProducts();
	public boolean deleteProduct(ProductTransfer p);
	public boolean changeAmount(ProductTransfer p, int amount);
}
