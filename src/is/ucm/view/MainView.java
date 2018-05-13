package is.ucm.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import is.ucm.controller.Controler;
import is.ucm.model.FridgeSimulatorObserver;
import is.ucm.model.Product;
import is.ucm.model.categories.Category;
import is.ucm.model.categories.InvokerCategories;
import is.ucm.model.categories.Meat;

public class MainView extends JFrame {
	
	private Toolbar _toolbar;
	
	private FridgeTableView _fridge;
	private ToBuyTableView _tobuy;
	private FridgeView _fridgeView;
	
	private Controler _controller;
	
	public MainView(Controler ctrl) {
		super();
		_controller = ctrl;
		//_obs = new ArrayList<GuiViewObserver>();
		initGUI();
	}
	
	
	public void initGUI() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JPanel mainPanel = this.createMainPanel();
		this.setContentPane(mainPanel);
	
		//this.addToolBar(mainPanel);
		
		//this.addList(mainPanel);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.height * 0.60);
		int width = (int) (screenSize.width * 0.20);
		setPreferredSize(new Dimension(width, height));
      
		
		
		this.pack();
		this.setVisible(false);
	
	}
	
	public void setView(String s) {
		switch(s) {
		case "FRIDGE":
			this.setContentPane(_fridgeView);
		}
	}

	
	private void addList(JPanel mainPanel) {
		
		
		
		_tobuy = new ToBuyTableView();
		mainPanel.add(_tobuy);
		_tobuy.setVisible(false);
		mainPanel.add(new FridgeTableView(new Meat()));
	}


	


	private JPanel createMainPanel() {
		_fridgeView = new FridgeView(this, _controller);
		return _fridgeView;
	}



}
