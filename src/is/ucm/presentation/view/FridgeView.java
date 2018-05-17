package is.ucm.presentation.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import is.ucm.buisness.model.ListsObserver;
import is.ucm.buisness.model.Product;
import is.ucm.model.categories.Category;
import is.ucm.presentation.controller.Controller;

@SuppressWarnings("serial")
public class FridgeView extends JPanel implements ListsObserver {
	
	/**
	 * List of FridgeTablesView(s), one for each category
	 */
	private List<TableView> _fridge;
	private List<Category> _categories;
	
	private Controller _controller;
	
	public FridgeView(Controller controller) {
		_controller = controller;
		_fridge = new ArrayList<TableView>();
		_categories = new ArrayList<Category>();
		_controller.addFridgeObserver(this);
		
		initGUI();
	}
	
	/**
	 * Method that initializes the GUI for the FridgeView
	 */
	public void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(new JScrollPane());
		
		// for each category add a table view to the list
		for (Category c : _categories) {
			TableView table = new TableView(c);
			 _fridge.add(table);
			 this.add(table);
		}
		
	}

	@Override
	public void onRemove(Product p) {
		
		for (TableView t : _fridge) {
			if (t.getCategory().equals(p.get_category())) {
				t.onRemove(p);
			}
		}
		
	}

	@Override
	public void onAdd(Product p) {
		if (!_categories.contains(p.get_category())) {
			_categories.add(p.get_category());
			TableView table = new TableView(p.get_category());
			_fridge.add(table);
			this.add(table);
		}
		for (TableView t : _fridge) {
			if (t.getCategory().equals(p.get_category())) {
				t.onAdd(p);
			}
		}
		
	}

	@Override
	public void onEdit(Product p) {
		// TODO Auto-generated method stub
		
	}

}
