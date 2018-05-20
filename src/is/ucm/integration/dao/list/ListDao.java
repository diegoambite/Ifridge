package is.ucm.integration.dao.list;

import is.ucm.model.transfer.FoodContainerTransfer;
import is.ucm.model.transfer.ProductTransfer;

public interface ListDao {
	public ProductTransfer getProduct(String name);
	public boolean saveProduct(ProductTransfer p);
	public FoodContainerTransfer getAllProducts();
	public boolean deleteProduct(ProductTransfer p);
	public boolean changeAmount(ProductTransfer p, int amount);
}
