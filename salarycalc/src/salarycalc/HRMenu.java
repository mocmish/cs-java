package salarycalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HRMenu extends JFrame {

	private JPanel contentPane;
	private JTable displayTable;
	private JTextField newNameField;
	private JTextField newScoreField;
	private JTextField newDayField;
	private JTable table;
	public JFrame parentMenu;
	private JFrame selfRef = this;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DataInput frame = new DataInput();
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
	public HRMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		displayTable = new JTable();
		displayTable.setBounds(10, 330, 1124, 318);
		contentPane.add(displayTable);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 74, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Score");
		lblNewLabel_1.setBounds(228, 74, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Days worked");
		lblNewLabel_2.setBounds(446, 74, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Selected Row");
		lblNewLabel_3.setBounds(10, 197, 195, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Create new entry");
		lblNewLabel_4.setBounds(10, 56, 119, 14);
		contentPane.add(lblNewLabel_4);
		
		newNameField = new JTextField();
		newNameField.setBounds(10, 99, 195, 20);
		contentPane.add(newNameField);
		newNameField.setColumns(10);
		
		newScoreField = new JTextField();
		newScoreField.setColumns(10);
		newScoreField.setBounds(228, 99, 195, 20);
		contentPane.add(newScoreField);
		
		newDayField = new JTextField();
		newDayField.setColumns(10);
		newDayField.setBounds(446, 99, 195, 20);
		contentPane.add(newDayField);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(651, 98, 89, 23);
		contentPane.add(addButton);
		
		table = new JTable();
		table.setBounds(10, 222, 1124, 38);
		contentPane.add(table);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(10, 271, 89, 23);
		contentPane.add(updateButton);
		
		JLabel lblNewLabel_5 = new JLabel("Overview, click to select from here");
		lblNewLabel_5.setBounds(10, 305, 207, 14);
		contentPane.add(lblNewLabel_5);
		
		//hides menu and shows main menu
		JButton returnBut = new JButton("Return");
		returnBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selfRef.setVisible(false);
				parentMenu.setVisible(true);
			}
		});
		returnBut.setBounds(1045, 7, 89, 23);
		contentPane.add(returnBut);
		
		JLabel lblNewLabel_6 = new JLabel("Human Resources Menu - Calculation Data for Employees");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(10, 11, 553, 28);
		contentPane.add(lblNewLabel_6);
	}
}
