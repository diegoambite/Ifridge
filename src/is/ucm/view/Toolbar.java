package is.ucm.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar implements ActionListener{
	
	private JButton _fridgeView, _buyView, _close;

	public Toolbar(){//habra que meterle el controler
		super();	

		//crtl.addObserver(this);
		this.addSeparator();

		_fridgeView = new JButton();
		_fridgeView.setActionCommand("fridge");
		_fridgeView.setToolTipText("Open fridge list");
		_fridgeView.setActionCommand("FRIDGE");
		_fridgeView.addActionListener(this);
		_fridgeView.setIcon(new ImageIcon(loadImage("resources/icons/fridge.png")));
		this.add(_fridgeView);
		
		this.addSeparator();

		_buyView = new JButton();
		_buyView.setActionCommand("buy");
		_buyView.setToolTipText("Open buy list");
		_buyView.setActionCommand("BUY");
		_buyView.addActionListener(this);
		_buyView.setIcon(new ImageIcon(loadImage("resources/icons/shopping-cart.png")));
		this.add(_buyView);
		
		//Made by Alessio 
		for(int i = 0; i <= 20; i++)
			this.addSeparator();

		_close = new JButton();
		_close.setActionCommand("close");
		_close.setToolTipText("Clear Text");
		_close.setActionCommand("EXIT");
		_close.addActionListener(this);
		_close.setIcon(new ImageIcon(loadImage("resources/icons/exit.png")));
		this.add(_close);
		
	}
	
	private static Image loadImage(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}	
}
