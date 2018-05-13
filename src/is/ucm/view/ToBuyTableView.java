package is.ucm.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import is.ucm.model.FridgeSimulatorObserver;
import is.ucm.model.ListsObserver;
import is.ucm.model.Product;

public class ToBuyTableView extends JPanel implements ListsObserver{
	
	private List<ListsObserver> _obs;
	
	class ToBuyTableModel extends AbstractTableModel{

		private final String[] header = {"Name", "Quantity"};
		
		

		@Override
		public String getColumnName(int pos) {
			return header[pos];
		}
		
		@Override
		public int getColumnCount() {
			return header.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public ToBuyTableView(String bordeId, TableModel<T> modelo){
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createTitledBorder(bordeId));
		this.model = modelo;
		JTable tabla = new JTable(this.model);
		JScrollPane scroll = new JScrollPane(tabla);
		
		scroll.getViewport().setBackground(Color.WHITE);
		this.add(scroll);
	}
	
	
}
