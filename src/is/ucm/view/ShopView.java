package is.ucm.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import is.ucm.controller.Controller;

@SuppressWarnings("serial")
public class ShopView extends JPanel {
	
	/**
	 * Kept with list, in case we'd want to organize the shop by categories
	 */
	private List<ShopTableView> _shop;
	
	private Controller _controller;
	
	public ShopView(Controller controller) {
		_controller = controller;
		_shop = new ArrayList<ShopTableView>();
		
		initGUI();
	}
	
	/**
	 * Method that initializes the GUI for the ShopView
	 */
	public void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(new JScrollPane());
		
		// just one category... add more to better organize the shop
		_shop.add(new ShopTableView());
		
		// for each table view
		for (ShopTableView c : _shop) {
			//_controller.addShopObserver(c);	// add an observer to the shop
			this.add(c);						// add it to the panel
		}
		
	}

}
