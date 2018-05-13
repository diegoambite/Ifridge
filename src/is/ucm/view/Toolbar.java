package is.ucm.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{
	
	private JButton _fridgeView, _buyView, _close;

	public Toolbar(){//habra que meterle el controler
		super();	

		//crtl.addObserver(this);
	
		_fridgeView = new JButton();
		_fridgeView.setActionCommand("fridge");
		_fridgeView.setToolTipText("Open fridge list");
		//_fridgeView.addActionListener((ActionListener) frame);

		_fridgeView.setIcon(new ImageIcon(loadImage("resources/icons/fridge.png")));
		this.add(_fridgeView);

		_buyView = new JButton();
		_buyView.setActionCommand("buy");
		_buyView.setToolTipText("Open buy list");
		//_buyView.addActionListener((ActionListener) frame);
		_buyView.setIcon(new ImageIcon(loadImage("resources/icons/shopping-cart.png")));
		this.add(_buyView);
		
		this.addSeparator();

		_close = new JButton();
		_close.setActionCommand("close");
		_close.setToolTipText("Clear Text");
		//_close.addActionListener((ActionListener) frame);
		_close.setIcon(new ImageIcon(loadImage("resources/icons/close.png")));
		this.add(_close);
		
	}
	
	private static Image loadImage(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}	
}
