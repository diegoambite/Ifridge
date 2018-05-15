package is.ucm.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import is.ucm.controller.Controller;
import is.ucm.model.categories.Category;
import is.ucm.model.categories.InvokerCategories;

@SuppressWarnings("serial")
public class FridgeView extends JPanel {
	
	/**
	 * List of FridgeTablesView(s), one for each category
	 */
	private List<FridgeTableView> _fridge;
	
	private Controller _controller;
	
	public FridgeView(Controller controller) {
		_controller = controller;
		_fridge = new ArrayList<FridgeTableView>();
		
		initGUI();
	}
	
	/**
	 * Method that initializes the GUI for the FridgeView
	 */
	public void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(new JScrollPane());
		
		// for each category add a table view to the list
		for (Category c : InvokerCategories.getCategories())
			 _fridge.add(new FridgeTableView(c));
		
		// for each table view
		for (FridgeTableView c : _fridge) {
			_controller.addFridgeObserver(c);	// add an observer to the fridge
			this.add(c);						// add it to the panel
		}
		
	}

}
