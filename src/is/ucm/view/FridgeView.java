package is.ucm.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import is.ucm.controller.Controler;
import is.ucm.model.categories.Category;
import is.ucm.model.categories.InvokerCategories;

public class FridgeView extends JPanel {

	private Toolbar _toolbar;
	private MainView _main;
	private List<FridgeTableView> _fridge;
	private Controler _controller;
	
	public FridgeView(MainView main, Controler controller) {
		_main = main;
		_controller = controller;
		_fridge = new ArrayList<FridgeTableView>();
		initGUI();
		
	}
	
	public void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.addToolBar(this);
		this.add(new JScrollPane());
		
		
		
		for (Category c : InvokerCategories.getCategories()) {
			 _fridge.add(new FridgeTableView(c));
		}
		for (FridgeTableView c : _fridge) {
			_controller.addFridgeObserver(c);
			this.add(c);
		}
	}
	
	private void addToolBar(JPanel mainPanel) {
		_toolbar = new Toolbar(_main);
		mainPanel.add(_toolbar, BorderLayout.PAGE_START);
		
	}
}
