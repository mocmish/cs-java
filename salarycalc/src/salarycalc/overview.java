package salarycalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class overview extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					overview frame = new overview();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public overview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 547, 192);
		contentPane.add(panel);
		
		JButton dataenterstart = new JButton("Set revenue data");
		dataenterstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(dataenterstart);
		
		JButton Calculate = new JButton("HR set employee data");
		panel.add(Calculate);
		
		JButton btnNewButton_1 = new JButton("Set Revenue Advanced");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quarter and annual bonuses");
		panel.add(btnNewButton_2);
	}
}
