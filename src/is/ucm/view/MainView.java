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

public class MainView extends JFrame implements FridgeSimulatorObserver {
	
	private Toolbar _toolbar;
	
	private FridgeTableView _fridge;
	private ToBuyTableView _tobuy;
	
	private Controler _controller;
	
	public MainView(Controler ctrl) {
		super();
		_controller = ctrl;
		//_obs = new ArrayList<GuiViewObserver>();
		initGUI();
	}
	
	
	public void initGUI() {
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//this.addWindowListener(new WindowListener() {//when exit ask for confirmation
		
		JPanel mainPanel = this.createMainPanel();
		this.setContentPane(mainPanel);
	
		this.addToolBar(mainPanel);
		
		this.addList(mainPanel);
		
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.height * 0.60);
		int width = (int) (screenSize.width * 0.20);
		setPreferredSize(new Dimension(width, height));
      
		this.pack();
		this.setVisible(true);
	
	}

	
	private void addList(JPanel mainPanel) {
		_fridge = new FridgeTableView();
		mainPanel.add(_fridge);
		
	}


	private void addToolBar(JPanel mainPanel) {
		_toolbar = new Toolbar();//habra que meterle argumentos
		mainPanel.add(_toolbar, BorderLayout.PAGE_START);
		
	}


	private JPanel createMainPanel() {
		return new JPanel( new BorderLayout() );
	}


	@Override
	public void onRemove(Product p) {
		
	}
	
}
