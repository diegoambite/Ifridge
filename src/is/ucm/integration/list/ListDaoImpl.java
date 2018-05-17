package is.ucm.integration.list;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import is.ucm.buisness.model.FoodContainerTransfer;
import is.ucm.buisness.model.ProductTransfer;
import is.ucm.model.categories.Category;
import is.ucm.util.filestorage.FileStorage;

public class ListDaoImpl implements ListDao {
	
	private String _directory;
	private HashMap<String, FileStorage> _files;
	private List<String> _filenames;

	
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
				_files.put(f.getName(), new FileStorage(file));
			} catch (IllegalArgumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ProductTransfer getProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveProduct(ProductTransfer p) {
		try {
			if (_files.containsKey(p.get_category())) {
				_files.get(p.get_category().toString()).store(p.get_name(), p);
			}
		} catch (IOException e) {
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public FoodContainerTransfer getAllProducts() {
		FoodContainerTransfer transfer = new FoodContainerTransfer();
		for (String f : _filenames) {
			Category c = new Category(f);
			try {
				transfer.addList(_files.get(f).getAllAsArrayList(), c);
			} catch (NullPointerException e) {
				
			}
		}
		return transfer;
	}

}
