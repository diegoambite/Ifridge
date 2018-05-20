package is.ucm.presentation.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import is.ucm.model.business.Category;
import is.ucm.model.observer.ListsObserver;
import is.ucm.model.transfer.FoodContainerTransfer;
import is.ucm.model.transfer.ProductTransfer;
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
		FoodContainerTransfer food = _controller.loadData("fridge");
		// for each category add a table view to the list
		for (Category c : food.getCategories()) {
			TableView table = new TableView(c);
			 _fridge.add(table);
			 this.add(table);
			 for (ProductTransfer p : food.getList(c)) {
				 table.onAdd(p);
			 }
		}
		
	}

	@Override
	public void onRemove(ProductTransfer p) {
		for (TableView t : _fridge) {
			if (t.getCategory().equals(p.getCategory())) {
				t.onRemove(p);
			}
		}
		
	}

	public void onAdd(ProductTransfer p) {
		if (!_categories.contains(p.getCategory())) {
			_categories.add(p.getCategory());
			TableView table = new TableView(p.getCategory());
			_fridge.add(table);
			this.add(table);
			table.onAdd(p);
			return;
		}
		for (TableView t : _fridge) {
			if (t.getCategory().equals(p.getCategory())) {
				
				t.onAdd(p);
			}
		}
		
	}

	@Override
	public void onEdit(ProductTransfer p) {
		for (TableView t : _fridge) {
			if (t.getCategory().equals(p.getCategory())) {
				
				t.onEdit(p);
			}
		}
		
	}

	public List<ProductTransfer> getSelected() {
		List<ProductTransfer> selected = new ArrayList<ProductTransfer>();
		for (TableView t : _fridge) {
			selected.addAll(t.getSelected());
		}
		return selected;
	}

}
