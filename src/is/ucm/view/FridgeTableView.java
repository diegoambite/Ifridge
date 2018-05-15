package is.ucm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import is.ucm.model.ListsObserver;
import is.ucm.model.Product;
import is.ucm.model.categories.Category;

@SuppressWarnings("serial")
public class FridgeTableView extends JPanel implements ListsObserver {
	
	public static Border defaultBorder = BorderFactory.createLineBorder(Color.black, 2);

	/**
	 * Inner Class defining the behavior of the TableView
	 * @author iFridge team
	 */
	class FridgeTableModel extends AbstractTableModel {

		private final String[] header = {"Name", "Quantity", "Buy"};
		
		public String getColumnName(int pos) {
			return header[pos];	
		}
		
		@Override
		public int getColumnCount() {
			return header.length;
		}

		@Override
		public int getRowCount() {
			if (_map == null) return 0;
			return _map.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0:	return _map.get(rowIndex).get_name();
				case 1:	return _map.get(rowIndex).get_quantity();
				case 2: return new JButton("hello");
				default: return null;
			}
		}
		
		void refresh() {
			fireTableDataChanged();
		}
		
	}
	
	
	// ATTRIBUTES
	
	/**
	 * Map containing the products of the table
	 */
	private List<Product> _map;
	
	/**
	 * TableModel of the current table
	 */
	private FridgeTableModel _fridgeTableModel;
	
	/**
	 * Table of the current TableView
	 */
	private JTable _t;
	
	/**
	 * Category of the current TableView
	 */
	private Category _c;

	
	// CONSTRUCTOR
	
	public FridgeTableView(Category c){
		_map = null;
		_c = c;
		
		initGUI();
	}
	
	
	/**
	 * Initializing the GUI of the TableView
	 */
	private void initGUI() {
		this.setBorder(new TitledBorder(defaultBorder, _c.getName()));
		this.setLayout(new BorderLayout());
		
		// initializing fridgeTableModel
		_fridgeTableModel = new FridgeTableModel();
		
		// creating the new table
		_t = new JTable(_fridgeTableModel);
		_t.setShowGrid(false);
		
		JScrollPane s = new JScrollPane(_t);
		s.getViewport().setBackground(Color.WHITE);
		
		this.add(s, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	/**
	 * Return the selected products from the TableView
	 * @return
	 */
	public List<Product> getSelected() {
		int[] data =  _t.getSelectedRows();
		List<Product> l = new ArrayList<Product>();
		for (int i = 0; i < data.length; i++) {
			l.add(_map.get(data[i]));
		}
		
		return l;
		
	}

	
	// UPDATES CALLED BY THE OBSERVABLE
	
	@Override
	public void onRemove(List<Product> list, Category c) {
		if (c.getName().equals(_c.getName())) {
			_map = list;
			_fridgeTableModel.refresh();
		}
		
	}

	@Override
	public void onAdd(List<Product> list, Category c) {
		if (c.getName().equals(_c.getName())) {
			_map = list;
			_fridgeTableModel.refresh();
		}
		
	}

	@Override
	public void onEdit(Product p) {
		
	}
}
