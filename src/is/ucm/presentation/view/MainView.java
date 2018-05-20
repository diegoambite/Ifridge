package is.ucm.presentation.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import is.ucm.model.business.Category;
import is.ucm.model.transfer.ProductTransfer;
import is.ucm.presentation.controller.Controller;

/**
 * Window using a BorderLayout;
 * 
 * PAGE_START: toolBar, with the main functionalities
 * CENTER: panel with a card layout, used to swap the requested panel (introduction, fridge or shop)
 * PAGE_END: status bar
 * 
 * @author iFridge team
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {
	
	/**
	 * ToolBar of the JFrame
	 */
	private Toolbar _toolbar;

	/**
	 * Card n°2, showing the user's fridge
	 */
	private FridgeView _fridgeView;
	
	/**
	 * Card n°3, showing the shop
	 */
	private ShopView _shopView;
	
	/**
	 * Controller that takes the user input and notifies the model
	 */
	private Controller _controller;
	
	/**
	 * Panel that displays the content of the MainView
	 */
	JPanel _mainPanel;
	
	 
	
	/**
	 * Central Panel, that display the content of the current card (has a CardLayout)
	 */
	JPanel _contentPanel;

	private int _card;
	
	public MainView(Controller ctrl) {
		super();
		_controller = ctrl;
		//_obs = new ArrayList<GuiViewObserver>();
		
		initGUI();
	}
	
	/**
	 * Method that initializes the GUI for the Main View
	 */
	public void initGUI() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(_mainPanel);
		
		// adding the toolbar to the top of the Main Window
		addToolBar();
		
		// initializing the table views contents
		_fridgeView = new FridgeView(_controller);
		_shopView = new ShopView(_controller);
		
		// filling the cards of the content panel
		_contentPanel = new JPanel(new CardLayout());
		_contentPanel.add(new JPanel(), "Card 1");		// actually empty, could be improved (intro or useful panel)
		_contentPanel.add(_fridgeView, "Card 2");
		_contentPanel.add(_shopView, "Card 3");
		_mainPanel.add(_contentPanel, BorderLayout.CENTER);
		showCard(1);
		// adjusting dimensions for the main view
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.height * 0.60);
		int width = (int) (screenSize.width * 0.20);
		setPreferredSize(new Dimension(width, height));
		
		
		
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Method to change the displayed view on the central panel screen
	 * @param s
	 */
	public void setView(String s) {
		
		_card = -1;
		
		switch(s) {
		
		case "FRIDGE":
			_card = 1;
			break;
			
		case "BUY":
			_card = 2;
			break;
			
		default:
			_card = 0;
			break;
			
		}
		
		showCard(_card);
		this.pack();
	}
	
	/**
	 * Method that shows the desired card in the content panel
	 * @param index
	 */
	private void showCard(int index)
	{
		if (index < 0) return;
		
		CardLayout cl = (CardLayout) _contentPanel.getLayout();
		cl.first(_contentPanel);
		
		for(int i = 0 ; i < index; i++)
			cl.next(_contentPanel);
	}
	
	public void logOut() {
		this.setVisible(false);
		new AccessView(_controller, this);
	}
	
	/**
	 * Method that adds a toolbar to the main Panel
	 */
	private void addToolBar() {
		_toolbar = new Toolbar(this, _controller);
		_mainPanel.add(_toolbar, BorderLayout.PAGE_START);
	}

	public void deleteObjects() {
		if (_card == 1)
			_controller.deleteObjects(_fridgeView.getSelected(), "fridge");
		else if (_card == 2)
			_controller.deleteObjects(this._shopView.getSelected(), "shopList");	
	}

	public void moveObjects() {
		_controller.moveObjects(_shopView.getSelected());
		
	}

	

}
