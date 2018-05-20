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

import is.ucm.business.model.observer.ListsObserver;
import is.ucm.business.model.transfer.ProductTransfer;

@SuppressWarnings("serial")
public class ShopTableView extends JPanel implements ListsObserver {
		
	public static Border defaultBorder = BorderFactory.createLineBorder(Color.black, 2);

	/**
	 * Inner Class defining the behavior of the TableView
	 * @author iFridge team
	 */
	class ShopTableModel extends AbstractTableModel {

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
				case 0:	return _list.get(rowIndex).get_name();
				case 1:	return _list.get(rowIndex).get_quantity();
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
	private ShopTableModel _shopTableModel;
	
	/**
	 * Table of the current TableView
	 */
	private JTable _t;

	
	// CONSTRUCTOR
	
	public ShopTableView(){
		_list = null;
		
		initGUI();
	}
	
	
	private void initGUI() {
		this.setBorder(new TitledBorder(defaultBorder, "Shop List"));
		this.setLayout(new BorderLayout());
		
		_shopTableModel = new ShopTableModel();
		
		_t = new JTable(_shopTableModel);
		_t.setShowGrid(false);
		JScrollPane s = new JScrollPane(_t);
		s.getViewport().setBackground(Color.WHITE);
		this.add(s, BorderLayout.CENTER); //check
		this.setVisible(true);
	}
	
	public List<ProductTransfer> getSelected() {
		int[] data =  _t.getSelectedRows();
		List<ProductTransfer> l = new ArrayList<ProductTransfer>();
		for (int i = 0; i < data.length; i++) {
			l.add(_list.get(data[i]));
		}
		
		return l;
		
	}

	
	// UPDATES CALLED BY THE OBSERVABLE
	
	@Override
	public void onRemove(ProductTransfer p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdd(ProductTransfer p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEdit(ProductTransfer p) {
		// TODO Auto-generated method stub
		
	}

}
