package salarycalc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class mainLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JFrame mainFrame = null;
	public database refdb;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public mainLogin(final database db) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.mainFrame = this;
		this.refdb = db;
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel NameLabel = new JLabel("Salary Calculator");
		NameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(0, 0, 195, 65);
		contentPane.add(NameLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 122, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(10, 88, 133, 20);
		contentPane.add(textFieldUsername);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setBounds(10, 63, 66, 14);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 147, 133, 20);
		contentPane.add(passwordField);
		
		final JLabel warninglabel = new JLabel("");
		warninglabel.setBounds(10, 178, 133, 14);
		contentPane.add(warninglabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textFieldUsername.getText();
				@SuppressWarnings("deprecation")
				String passWord = passwordField.getText();
				try {
					boolean success = false;
					ResultSet rs = db.searchQuery("logins", "username", userName);
					System.out.println(rs);
					while (rs.next()) {
						// retrieve and print the values for the current row
						String qpass = rs.getString("password");
						int qlevel = rs.getInt("userlevel");
						System.out.println(qpass);
						System.out.println(passWord);
						if (qpass.equals(passWord)) {
							success = true;
						}
					}
					if(success) {
						overview frame = new overview();
						frame.setVisible(true);
						System.out.println(userName);
						System.out.println(passWord);
						mainFrame.dispose();
					} else {
						warninglabel.setText("Invalid login credentials");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 203, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton forgotpassbut = new JButton("Forgot password");
		forgotpassbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame, "Contact IT department to reset password");
			}
		});
		forgotpassbut.setBounds(10, 234, 133, 23);
		contentPane.add(forgotpassbut);
	}
}
