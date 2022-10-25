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
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MainLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JFrame mainFrame = null;
	public Database refdb;
	private int qlevel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainLogin(final Database db) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.mainFrame = this;
		this.refdb = db;
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel NameLabel = new JLabel("Salary Calculator NSCA");
		NameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(0, 0, 565, 65);
		contentPane.add(NameLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(140, 364, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(214, 330, 133, 20);
		contentPane.add(textFieldUsername);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setBounds(140, 333, 66, 14);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 361, 133, 20);
		contentPane.add(passwordField);
		
		final JLabel warninglabel = new JLabel("");
		warninglabel.setBounds(10, 178, 133, 14);
		contentPane.add(warninglabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			private int qlevel;

			public void actionPerformed(ActionEvent e) {
				String userName = textFieldUsername.getText();
				@SuppressWarnings("deprecation")
				String passWord = passwordField.getText();
				//starts with false boolean and checks database if username entry exists with matching password
				// if no entry or wrong password boolean success remains false and program does not start
				try {
					boolean success = false;
					ResultSet rs = db.searchQuery("logins", "username", userName);
					System.out.println(rs);
					while (rs.next()) {
						// retrieve and print the values for the current row
						String qpass = rs.getString("password");
						this.qlevel = rs.getInt("userlevel");
						if (qpass.equals(passWord)) {
							success = true;
						}
					}
					if(success) {
						Overview frame = new Overview(this.qlevel);
						frame.setVisible(true);
						mainFrame.dispose();
					} else {
						warninglabel.setText("Invalid login credentials");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(214, 392, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton forgotpassbut = new JButton("Forgot password");
		forgotpassbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame, "Contact IT department to reset password");
			}
		});
		forgotpassbut.setBounds(214, 426, 133, 23);
		contentPane.add(forgotpassbut);
		
		ImageIcon image= new ImageIcon(getClass().getResource("logo.png"));
		JLabel imageLabel = new JLabel(image);
		contentPane.add(imageLabel);
		imageLabel.setBounds(167, 65, 230, 243);
		
	}
}
