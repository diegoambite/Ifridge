package is.ucm.view;

import javax.swing.SwingUtilities;

import is.ucm.controller.Controller;
import is.ucm.model.Model;

public class Main {

	public static void main(String[] args) {
		
		final Model m = new Model();
		Controller ctrl = new Controller(m);
		MainView view = new MainView(ctrl);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AccessView(ctrl, view);
			}
		});
		
		
	}

}
