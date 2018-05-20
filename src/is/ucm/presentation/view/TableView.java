package is.ucm.presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import is.ucm.model.business.Category;
import is.ucm.model.transfer.ProductTransfer;

@SuppressWarnings("serial")
public class TableView extends JPanel {
	
	public static Border defaultBorder = BorderFactory.createLineBorder(Color.black, 2);

	/**
	 * Inner Class defining the behavior of the TableView
	 * @author iFridge team
	 */
	class FridgeTableModel extends AbstractTableModel {

		private final String[] header = {"Name", "Quantity"};
		
		public String getColumnName(int pos) {
			return header[pos];	
		}
		
		@Override
		public int getColumnCount() {
			return header.length;
		}

		@Override
		public int getRowCount() {
			if (_list == null) return 0;
			return _list.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0:	return _list.get(rowIndex).getName();
				case 1:	return _list.get(rowIndex).getQuantity();
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
	private List<ProductTransfer> _list;
	
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
	
	public TableView(Category c){
		_list = new ArrayList<ProductTransfer>();
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
	public List<ProductTransfer> getSelected() {
		int[] data =  _t.getSelectedRows();
		List<ProductTransfer> l = new ArrayList<ProductTransfer>();
		for (int i = 0; i < data.length; i++) {
			l.add(_list.get(data[i]));
		}
		
		return l;
		
	}
	
	public Category getCategory() {
		return _c;
	}

	
	// UPDATES CALLED BY THE OBSERVABLE
	
	public void onRemove(ProductTransfer p) {
		_list.remove(p);
		_fridgeTableModel.refresh();
		
	}

	public void onAdd(ProductTransfer p) {
		_list.add(p);
		_fridgeTableModel.refresh();
		
	}

	public void onEdit(ProductTransfer p) {
		for (ProductTransfer t : _list) {
			if (t.getName().equals(p.getName())) {
				t.set_quantity(p.getQuantity() + t.getQuantity());
			}
		}
		_fridgeTableModel.refresh();
	}
}
