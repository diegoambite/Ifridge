package is.ucm.integration.dao.list;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import is.ucm.model.business.Category;
import is.ucm.model.transfer.FoodContainerTransfer;
import is.ucm.model.transfer.ProductTransfer;
import is.ucm.util.filestorage.FileStorage;

/**
 * DAO class, that operates with the food storage systems.
 * @author iFridge team
 */
public class ListDaoImpl implements ListDao {
	
	private String _directory;
	
	private HashMap<String, FileStorage> _files;
	
	private List<String> _filenames;

	
	// CONSTRUCTOR
	
	public ListDaoImpl(String string) {
		_directory = string;
		_filenames = new ArrayList<String>();
		_files = new HashMap<String, FileStorage>();
		File f = new File(string);
		File[] paths = f.listFiles();
		if (paths == null) return;
		for (File file : paths) {
			try {
				_filenames.add(file.getName());
				_files.put(file.getName(), new FileStorage(file));
			} catch (IllegalArgumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public ProductTransfer getProduct(String name) {
		return null;
	}

	@Override
	public boolean saveProduct(ProductTransfer p) {
		try {
			if (!_files.containsKey(p.get_category().toString())) {
				_files.put(p.get_category().toString(), new FileStorage(new File(_directory + "/" + p.get_category())));
				_filenames.add(p.get_category().toString());
			}
			_files.get(p.get_category().toString()).store(p.get_name(), p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public FoodContainerTransfer getAllProducts() {
		HashMap<Category, List<ProductTransfer>> foodList = new HashMap<>();
		List<Category> categories = new ArrayList<>();
		
		for (String f : _filenames) {
			Category c = new Category(f);
			try {
				foodList.put(c, _files.get(f).getAllAsArrayList());
				categories.add(c);
			} catch (NullPointerException e) {
				
			}
		}
		
		return new FoodContainerTransfer(foodList, categories);
	}

	@Override
	public boolean deleteProduct(ProductTransfer p) {
		if (!_files.containsKey(p.get_category().toString())) return false;
		try {
			ProductTransfer k = _files.get(p.get_category().toString()).get(p.get_name());
			if (k.get_quantity() > p.get_quantity()) {
				changeAmount(p, k.get_quantity() - p.get_quantity());
				return true;
			}
			_files.get(p.get_category().toString()).remove(p.get_name());
			_filenames.remove(p.get_category().toString());
			new File(_directory + "/" + p.get_category().toString()).delete();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	/**
	 * Changed the amount of the desired product in the storage system
	 */
	@Override
	public boolean changeAmount(ProductTransfer p, int amount) {
		
		// if _files doesn't contain the corresponding category
		if (!_files.containsKey(p.get_category().toString())) 
			return false;
		
		try {
			
			// try to get the actual parameters of the selected product
			ProductTransfer k = _files.get(p.get_category().toString()).get(p.get_name());
			
			// set the new parameters for the product (eventual NullPointerException is thrown)
			ProductTransfer r = new ProductTransfer(k.get_name(), amount, k.get_category());
			
			// replace the product
			_files.get(p.get_category().toString()).store(p.get_name(), r);
			
		} catch (IOException | NullPointerException e) {
			return false;
		}
		return true;
	}

}
