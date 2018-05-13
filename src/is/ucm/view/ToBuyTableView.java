package is.ucm.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ToBuyTableView extends JPanel{
	
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
