package is.ucm.presentation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import is.ucm.business.model.Category;
import is.ucm.business.model.FoodContainerTransfer;
import is.ucm.business.model.ListsObserver;
import is.ucm.business.model.ProductTransfer;
import is.ucm.presentation.controller.Controller;

@SuppressWarnings("serial")
public class ShopView extends JPanel implements ListsObserver {
	
	/**
	 * Kept with list, in case we'd want to organize the shop by categories
	 */
	private List<ShopTableView> _shop;
	
	private Controller _controller;

	private TableView _table;
	
	
	// CONSTRUCTOR
	
	public ShopView(Controller controller) {
		_controller = controller;
		_shop = new ArrayList<ShopTableView>();
		_controller.addShopObserver(this);
		initGUI();
	}
	
	
	// GETTERS AND SETTERS
	
	public List<ProductTransfer> getSelected() {
		return _table.getSelected();
	}

	
	// GRAPHIC METHODS
	
	/**
	 * Method that initializes the GUI for the ShopView
	 */
	public void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(new JScrollPane());
		
		// just one category... add more to better organize the shop
		_table = new TableView(new Category("Shop List"));
		FoodContainerTransfer food = _controller.loadData("shopList");
		this.add(_table);
		for (Category c : food.getCategories()) {
			for (ProductTransfer p : food.getList(c)) {
				_table.onAdd(p);
			}
		}
		
		JPanel bottomPart = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		
	}

	
	// EVENT OBSERVER METHODS
	
	@Override
	public void onRemove(ProductTransfer p) {
		_table.onRemove(p);
	}

	@Override
	public void onAdd(ProductTransfer p) {
		_table.onAdd(p);
	}

	@Override
	public void onEdit(ProductTransfer p) {
		// TODO Auto-generated method stub
	}

}
