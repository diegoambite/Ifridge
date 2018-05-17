package is.ucm.integration.list;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import is.ucm.buisness.model.FoodContainerTransfer;
import is.ucm.buisness.model.Product;
import is.ucm.model.categories.Category;
import is.ucm.util.filestorage.FileStorage;

public class ListDaoImpl implements ListDao {
	
	private String _directory;
	private HashMap<String, FileStorage> _files;
	private List<String> _filenames;

	
	public ListDaoImpl(String string) {
		_directory = string;
		_filenames = new ArrayList<String>();
		
		File f = new File(string);
		System.out.println(f.getAbsolutePath());
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
	public Product getProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveProduct(Product p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FoodContainerTransfer getAllProducts() {
		FoodContainerTransfer transfer = new FoodContainerTransfer();
		for (String f : _filenames) {
			Category c = new Category(f);
			transfer.addList(_files.get(f).getAllAsArrayList(), c);
		}
		return transfer;
	}

}
