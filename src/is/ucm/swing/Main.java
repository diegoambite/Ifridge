package is.ucm.swing;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		final Model m = new Model();
		final Controler ctr = new Controler(m);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AccessView(m, ctr);
			}
		});
	}

}
