package salarycalc;

import java.awt.EventQueue;

public class app {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database db = new Database("jdbc:mysql://localhost/salarycalc", "root", "");
					MainLogin frame = new MainLogin(db);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
