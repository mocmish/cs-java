package salarycalc;

import java.awt.EventQueue;
import salarycalc.HRMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Overview extends JFrame {

	private JFrame selfRef = this;
	private JPanel contentPane;
	public HRMenu hrMenu;

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
	public Overview(int qlevel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 277);
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
		
		//button events that make menus visible
		JButton hrdataenterstart = new JButton("HR set employee data");
		hrdataenterstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selfRef.setVisible(false);
				hrMenu.setVisible(true);
				hrMenu.parentMenu = selfRef;
			}
		});
		panel.add(hrdataenterstart);
		
		JButton advancedreventer = new JButton("Set Revenue Advanced");
		panel.add(advancedreventer);
		
		JButton bonusesstart = new JButton("Quarter and annual bonuses");
		panel.add(bonusesstart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(567, 27, 284, 192);
		contentPane.add(panel_1);
		
		//opens other menus but hides them until menu buttons are pressed
		try {
			hrMenu = new HRMenu();
			hrMenu.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
