package is.ucm.presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

import is.ucm.model.business.Category;
import is.ucm.model.observer.ListsObserver;
import is.ucm.model.transfer.FoodContainerTransfer;
import is.ucm.model.transfer.ProductTransfer;
import is.ucm.presentation.controller.Controller;

@SuppressWarnings("serial")
public class ShopView extends JPanel implements ListsObserver {
	
	/**
	 * Kept with list, in case we'd want to organize the shop by categories
	 */
	private List<ShopTableView> _shop;
	
	private Controller _controller;

	private TableView _table;
	
	 private JDialog dialog = new JDialog();
	
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
		
		
		JPanel bottomPart = new JPanel();
		BoxLayout bottom = new BoxLayout(bottomPart, BoxLayout.X_AXIS);
		bottomPart.setLayout(bottom);
		JButton plus = new JButton("+");
		bottomPart.add(plus);
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.setPreferredSize(new Dimension(320, 240));
			    dialog.add(dialogPanel());
			    dialog.pack();
			    dialog.setTitle("Add an item to the shop list");
			    dialog.setVisible(true);
				
			}
		});
		
		this.add(bottomPart);
	}

	private JPanel dialogPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JTextArea areaCategory = new JTextArea();
		
		Border b = BorderFactory.createLineBorder(Color.BLACK, 2);
		JScrollPane category = new JScrollPane(areaCategory, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		category.setBorder(BorderFactory.createTitledBorder(b, "Category"));
		category.getViewport().setBackground(Color.WHITE);
		
		
		JTextArea areaFood = new JTextArea();
		JScrollPane food = new JScrollPane(areaFood, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		food.setBorder(BorderFactory.createTitledBorder(b, "Food"));
		food.getViewport().setBackground(Color.WHITE);
		
		
		JTextArea areaQuantity = new JTextArea();
		
		JScrollPane quantity = new JScrollPane(areaQuantity, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		quantity.setBorder(BorderFactory.createTitledBorder(b, "Quantity"));
		quantity.getViewport().setBackground(Color.WHITE);
		
		panel.add(category);
		panel.add(food);
		panel.add(quantity);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		JButton confirm = new JButton("Confirm");
		JButton cancel = new JButton("Cancel");
		bottomPanel.add(confirm);
		bottomPanel.add(cancel);
		panel.add(bottomPanel);
		
		return panel;
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
