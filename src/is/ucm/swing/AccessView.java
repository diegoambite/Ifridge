package is.ucm.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class AccessView extends JFrame implements ActionListener {

	private Model _model;
	private Controler _ctr;
	
	 private JLabel l1, l2;
	 private JTextField tf1;
	 private JButton btn1, btn2;
	 private JPasswordField p1;
	 
	public AccessView(Model model, Controler ctr) {
		super("Register");
		_model = model;
		_ctr = ctr;
		initGUI();
	}

	private void initGUI() {

		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		
		  l1 = new JLabel("Username");
	      l2 = new JLabel("Password");
	     
	      tf1 = new JTextField();
	      p1 = new JPasswordField();
	     
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
	      this.add(l2);
	      
	      this.add(tf1);
	      this.add(p1);
	      
	      this.add(btn1);
	      this.add(btn2);
	      
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = (int) (screenSize.height * 0.30);
	      int width = (int) (screenSize.width * 0.35);
	      setPreferredSize(new Dimension(width, height));
		
	      this.setSize(1000, 1000);
	      this.setLayout(null);
	      this.pack();
	      this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("SEND".equals(e.getActionCommand())){
			this.setVisible(false);
			
		}
		
	}

}

