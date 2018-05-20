package is.ucm.presentation.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import is.ucm.exceptions.UserNotFoundException;
import is.ucm.presentation.controller.Controller;

/**
 * Access View for the application. It's the one in charge of the login.
 */
@SuppressWarnings("serial")
public class AccessView extends JFrame implements ActionListener {

	private Controller _ctr;


	private JTextField tf1;
	private JButton btn1, btn2;
	private JPasswordField p1;
	private JPanel _mainPanel;

	private JFrame _mainView;

	public AccessView(Controller ctr, JFrame mainView) {
		super("Register");
		_ctr = ctr;
		_mainView = mainView;
		initGUI();
	}

	/**
	 * Method that initializes the GUI for the Access View
	 */
	private void initGUI() {

		_mainPanel = new JPanel(new GridLayout(4, 1));
		this.setContentPane(_mainPanel);

		Border b = BorderFactory.createLineBorder(Color.BLACK, 2);
		tf1 = new JTextField("a");
		p1 = new JPasswordField("a");

		JScrollPane user = new JScrollPane(tf1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		user.setBorder(BorderFactory.createTitledBorder(b, "USERNAME"));
		user.getViewport().setBackground(Color.WHITE);
		
		JScrollPane passw = new JScrollPane(p1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		passw.setBorder(BorderFactory.createTitledBorder(b, "PASSWORD"));
		passw.getViewport().setBackground(Color.WHITE);

		btn1 = new JButton("log in");
		btn2 = new JButton("register");

		btn1.setActionCommand("LOGIN");
		btn1.addActionListener(this);

		btn2.setActionCommand("REGISTER");
		btn2.addActionListener(this);


		btn1.setBounds(150, 120, 100, 30);
		btn2.setBounds(150, 170, 100, 30);

		this.add(user);
		this.add(passw);

		this.add(btn1);
		this.add(btn2);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.height * 0.60);
		int width = (int) (screenSize.width * 0.20);
		setPreferredSize(new Dimension(350, 300));

		this.pack();
		this.setLocationRelativeTo(null); 
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()) {

		case "SEND":
			this.setVisible(false);
			break;

		case "REGISTER":
			this._ctr.registerUser(tf1.getText(), new String(p1.getPassword()));
			JOptionPane.showMessageDialog(_mainPanel, "Registered", "Your user is ready to use the Ifridge technology!", JOptionPane.INFORMATION_MESSAGE);

			_mainView.setVisible(true);
			this.dispose();
			break;

		case "LOGIN":
			try {
				if (_ctr.logInUser(tf1.getText(), new String(p1.getPassword()))) {
					//JOptionPane.showMessageDialog(_mainPanel, "Successfully Log in", "Nice job mate", JOptionPane.INFORMATION_MESSAGE);
					_mainView.setVisible(true);
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(_mainPanel, "Woops... Wrong password", "Error Brooo", JOptionPane.ERROR_MESSAGE);

				}
			} catch (IOException | UserNotFoundException e1) {
				JOptionPane.showMessageDialog(_mainPanel, "Error maaaan", e1.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
			break;

		}

	}

}

