package salarycalc;

import java.awt.EventQueue;

public class app {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					database db = new database("jdbc:mysql://localhost/salarycalc", "root", "");
					mainLogin frame = new mainLogin(db);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
