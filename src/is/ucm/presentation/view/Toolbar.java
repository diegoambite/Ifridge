package is.ucm.presentation.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import is.ucm.presentation.controller.Controller;

@SuppressWarnings("serial")
public class Toolbar extends JToolBar implements ActionListener{
	
	private JButton _fridgeView, _buyView, _close, _delete;
	
	private MainView _main;
	private Controller _controller;

	public Toolbar(MainView main, Controller controller){//habra que meterle el controler
		super();	
		_main = main;
		_controller = controller;
		//crtl.addObserver(this);
		this.addSeparator();

		// Fridge button
		addToolbarButton(_fridgeView, "FRIDGE", "Open fridge list", "resources/icons/fridge.png");
		this.addSeparator();

		// Buy button
		addToolbarButton(_buyView, "BUY", "Open buy list", "resources/icons/shopping-cart.png");
		this.addSeparator();
		
		addToolbarButton(_delete, "DELETE", "Deletes the selected items from the list", "resources/icons/shopping-cart.png");
		
		// Separator to the end of the toolbar
		this.add(Box.createHorizontalGlue());
		
		// Fridge button
		addToolbarButton(_close, "EXIT", "Clear Text", "resources/icons/exit.png");
	}
	
	/**
	 * Shortcut method to add a button to the toolbar, passing the correct parameters
	 */
	private void addToolbarButton(JButton button, String actionCommand, String toolTip, String path) {
		button = new JButton();
		button.setToolTipText(toolTip);
		button.setActionCommand(actionCommand);
		button.setIcon(new ImageIcon(loadImage(path)));
		button.addActionListener(this);
		this.add(button);
	}
	
	/**
	 * Method return an Image from a resource path
	 * @param path
	 * @return
	 */
	private static Image loadImage(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		
		case "FRIDGE":
			_main.setView("FRIDGE");
			break;
			
		case "BUY":
			_main.setView("BUY");
			break;
		
		case "EXIT":
			_main.logOut();
			break;
		case "DELETE":
			_main.deleteObjects();
			break;
		}
	
	}

}
