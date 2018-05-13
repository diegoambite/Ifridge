package is.ucm.view;

import java.io.IOException;

import javax.swing.SwingUtilities;

import is.ucm.controller.Controler;
import is.ucm.model.FridgeSimulator;
import is.ucm.model.Model;

public class Main {

	public static void main(String[] args) {
		
		final Model m = new Model();
		final Controler ctr = new Controler(m);
		MainView view = new MainView(ctr);
		FridgeSimulator s;
		try {
			s = new FridgeSimulator("resources/food.ini");
			new Thread(s).start();
			s.addObserver(view);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AccessView(ctr, view);
			}
		});
		
		
	}

}
