package is.ucm.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import is.ucm.controller.Controller;

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
		
		// adjusting dimensions for the main view
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.height * 0.60);
		int width = (int) (screenSize.width * 0.20);
		setPreferredSize(new Dimension(width, height));
		
		this.pack();
	}
	
	/**
	 * Method to change the displayed view on the central panel screen
	 * @param s
	 */
	public void setView(String s) {
		
		int card = -1;
		
		switch(s) {
		
		case "FRIDGE":
			card = 1;
			break;
			
		case "BUY":
			card = 2;
			break;
			
		default:
			card = 0;
			break;
			
		}
		
		showCard(card);
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
	
	/**
	 * Method that adds a toolbar to the main Panel
	 */
	private void addToolBar() {
		_toolbar = new Toolbar(this);
		_mainPanel.add(_toolbar, BorderLayout.PAGE_START);
	}

}
