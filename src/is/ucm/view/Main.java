package is.ucm.view;

import javax.swing.SwingUtilities;

import is.ucm.controller.Controler;
import is.ucm.model.Model;

public class Main {

	public static void main(String[] args) {
		
		final Model m = new Model();
		final Controler ctr = new Controler(m);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AccessView(ctr);
			}
		});
	}

}