package is.ucm.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.view.GuiViewObserver;
import is.ucm.controller.Controler;

public class MainView extends JFrame{
	
	private Toolbar _toolbar;
	
	private FridgeTableView _fridge;
	private ToBuyTableView _tobuy;
	
	private Controler _controller;
	
	public MainView(Controler ctrl) {
		super("Traffic Simulator");
		_controller = ctrl;
		//_obs = new ArrayList<GuiViewObserver>();
		initGUI();
	}
	
	
	public void initGUI() {
		
		
	}
	
}
