package is.ucm.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import is.ucm.controller.Controler;
import is.ucm.model.Model;
import is.ucm.util.userdao.exceptions.UserNotFoundException;



@SuppressWarnings("serial")
public class AccessView extends JFrame implements ActionListener {
	
	private Controler _ctr;
	
	 private JLabel l1, l2;
	 private JTextField tf1;
	 private JButton btn1, btn2;
	 private JPasswordField p1;
	 private JPanel _mainPanel;
	 
	 private JFrame _mainView;
	 
	public AccessView(Controler ctr, JFrame mainView) {
		super("Register");
		_ctr = ctr;
		_mainView = mainView;
		initGUI();
	}

	private void initGUI() {

		_mainPanel = new JPanel(new GridLayout(6, 1));
		this.setContentPane(_mainPanel);
		
		  l1 = new JLabel("Username");
	      l2 = new JLabel("Password");
	     
	      tf1 = new JTextField("a");
	      p1 = new JPasswordField("a");
	     
	      btn1 = new JButton("log in");
	      btn2 = new JButton("register");
	      
	      btn1.setActionCommand("LOGIN");
	      btn1.addActionListener(this);
	      
	      btn2.setActionCommand("REGISTER");
	      btn2.addActionListener(this);
	     	     
	      l1.setBounds(80, 30, 400, 30);
	      l2.setBounds(80, 70, 200, 30);
	      
	      tf1.setBounds(200, 30, 200, 30);
	      p1.setBounds(200, 70, 200, 30);
	      
	      btn1.setBounds(150, 120, 100, 30);
	      btn2.setBounds(150, 170, 100, 30);
	       
	      this.add(l1);
	      
	      this.add(tf1);
	      
	      this.add(l2);
	      this.add(p1);
	      
	      this.add(btn1);
	      this.add(btn2);
	      
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = (int) (screenSize.height * 0.60);
	      int width = (int) (screenSize.width * 0.20);
	      setPreferredSize(new Dimension(width, height));
	      
	      this.pack();
	      this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("SEND".equals(e.getActionCommand())){
			this.setVisible(false);
			
		}
		else if ("REGISTER".equals(e.getActionCommand())) {
			this._ctr.registerUser(tf1.getText(), new String(p1.getPassword()));
			JOptionPane.showMessageDialog(_mainPanel, "Registered", "Your user is ready to use the Ifridge technology!", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			_mainView.setVisible(true);
		}
		else if ("LOGIN".equals(e.getActionCommand())) {
			try {
				if (_ctr.logInUser(tf1.getText(), new String(p1.getPassword()))) {
					//JOptionPane.showMessageDialog(_mainPanel, "Succesfull Log in", "Nice job mate", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					_mainView.setVisible(true);
					_ctr.run();
				}
				else {
					JOptionPane.showMessageDialog(_mainPanel, "Woops... Wrong password", "Error Brooo", JOptionPane.ERROR_MESSAGE);

				}
			} catch (IOException | UserNotFoundException e1) {
				JOptionPane.showMessageDialog(_mainPanel, "Error maaaan", e1.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}

