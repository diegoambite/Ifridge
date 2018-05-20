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
	
	 private JDialog dialog = new JDialog();
	
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
		
		JPanel bottomPart = new JPanel();
		BoxLayout bottom = new BoxLayout(bottomPart, BoxLayout.X_AXIS);
		bottomPart.setLayout(bottom);
		JButton plus = new JButton("+");
		bottomPart.add(plus);
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.setPreferredSize(new Dimension(320, 240));
			    dialog.add(dialogPanel());
			    dialog.pack();
			    dialog.setTitle("Add an item to the shop list");
			    dialog.setVisible(true);
			}
		});
		
		this.add(bottomPart, BorderLayout.PAGE_END);
		
		this.pack();
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

	private JPanel dialogPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JTextArea areaCategory = new JTextArea();
		
		Border b = BorderFactory.createLineBorder(Color.BLACK, 2);
		JScrollPane category = new JScrollPane(areaCategory, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		category.setBorder(BorderFactory.createTitledBorder(b, "Category"));
		category.getViewport().setBackground(Color.WHITE);
		
		
		JTextArea areaFood = new JTextArea();
		JScrollPane food = new JScrollPane(areaFood, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		food.setBorder(BorderFactory.createTitledBorder(b, "Food"));
		food.getViewport().setBackground(Color.WHITE);
		
		
		JTextArea areaQuantity = new JTextArea();
		
		JScrollPane quantity = new JScrollPane(areaQuantity, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		quantity.setBorder(BorderFactory.createTitledBorder(b, "Quantity"));
		quantity.getViewport().setBackground(Color.WHITE);
		
		panel.add(category);
		panel.add(food);
		panel.add(quantity);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		JButton confirm = new JButton("Confirm");
		JButton cancel = new JButton("Cancel");
		bottomPanel.add(confirm);
		bottomPanel.add(cancel);
		panel.add(bottomPanel);
		
		return panel;
	}

}
