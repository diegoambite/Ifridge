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
			if (!_files.containsKey(p.getCategory().toString())) {
				_files.put(p.getCategory().toString(), new FileStorage(new File(_directory + "/" + p.getCategory())));
				_filenames.add(p.getCategory().toString());
			}
			_files.get(p.getCategory().toString()).store(p.getName(), p);
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
		if (!_files.containsKey(p.getCategory().toString())) return false;
		try {
			ProductTransfer k = _files.get(p.getCategory().toString()).get(p.getName());
			if (k.getQuantity() > p.getQuantity()) {
				changeAmount(p, k.getQuantity() - p.getQuantity());
				return true;
			}
			_files.get(p.getCategory().toString()).remove(p.getName());
			_filenames.remove(p.getCategory().toString());
			new File(_directory + "/" + p.getCategory().toString()).delete();
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
		if (!_files.containsKey(p.getCategory().toString())) 
			return false;
		
		try {
			
			// try to get the actual parameters of the selected product
			ProductTransfer k = _files.get(p.getCategory().toString()).get(p.getName());
			
			// set the new parameters for the product (eventual NullPointerException is thrown)
			ProductTransfer r = new ProductTransfer(k.getName(), amount, k.getCategory());
			
			// replace the product
			_files.get(p.getCategory().toString()).store(p.getName(), r);
			
		} catch (IOException | NullPointerException e) {
			return false;
		}
		return true;
	}

}
