package is.ucm.main;

import is.ucm.presentation.controller.Controller;
import is.ucm.presentation.view.AccessView;
import is.ucm.presentation.view.MainView;

public class Main {

	public static void main(String[] args) {
		
		Controller ctrl = new Controller();
		MainView view = new MainView(ctrl);
		new AccessView(ctrl, view);
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
			}
		});*/
		
		
	}

}
