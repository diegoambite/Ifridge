package is.ucm.view;

import java.io.IOException;

import javax.swing.SwingUtilities;

import is.ucm.controller.Controler;
import is.ucm.model.FridgeSimulator;
import is.ucm.model.Model;

public class Main {

	public static void main(String[] args) {
		
		final Model m = new Model();
		Controler ctr = new Controler(m);
		MainView view = new MainView(ctr);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AccessView(ctr, view);
			}
		});
		
		
	}

}
