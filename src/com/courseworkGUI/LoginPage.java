package com.courseworkGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.UsersList.Users;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;

public class LoginPage {

	private JFrame frmLogIn;
	private JTextField emailt;
	private JPasswordField pwt;
	Users u = new Users();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In ");
		frmLogIn.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/com/icons/icons8-classroom-85.png")));
		frmLogIn.setBounds(380, 100, 450, 435);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JPanel loginpanel = new JPanel();
		loginpanel.setBounds(0, 0, 436, 405);
		frmLogIn.getContentPane().add(loginpanel);
		loginpanel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Java College Kathmandu");
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		headerLabel.setBounds(108, 11, 246, 32);
		loginpanel.add(headerLabel);
		
		JLabel headerIcon = new JLabel("");
		headerIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/com/icons/icons8-classroom-85.png")));
		headerIcon.setBounds(174, 43, 90, 85);
		loginpanel.add(headerIcon);
		
		JLabel userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/com/icons/icons8-selfies-80_40x40.png")));
		userIcon.setBounds(108, 164, 49, 32);
		loginpanel.add(userIcon);
		
		JLabel passwordIcon = new JLabel("");
		passwordIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/com/icons/icons8-password-80_40x40.png")));
		passwordIcon.setBounds(108, 221, 40, 40);
		loginpanel.add(passwordIcon);
		
		emailt = new JTextField();
		emailt.setBounds(167, 180, 153, 20);
		loginpanel.add(emailt);
		emailt.setColumns(10);
		
		pwt = new JPasswordField();
		pwt.setBounds(167, 236, 153, 20);
		loginpanel.add(pwt);
		
		JLabel usernameHead = new JLabel("Enter your email:");
		usernameHead.setBounds(167, 163, 153, 14);
		loginpanel.add(usernameHead);
		
		JLabel passwordHead = new JLabel("Enter your password:");
		passwordHead.setBounds(167, 219, 153, 14);
		loginpanel.add(passwordHead);
		
		JLabel roleIcon = new JLabel("");
		roleIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/com/icons/icons8-classroom-80_40x40.png")));
		roleIcon.setBounds(110, 287, 42, 37);
		loginpanel.add(roleIcon);
		
		JComboBox rolec = new JComboBox();
		rolec.setModel(new DefaultComboBoxModel(new String[] {"Select role", "Instructor", "Student", "Admin"}));
		rolec.setBounds(167, 301, 153, 22);
		loginpanel.add(rolec);
		
		JLabel roleHeader = new JLabel("Enter your role:");
		roleHeader.setBounds(167, 284, 153, 14);
		loginpanel.add(roleHeader);
		
		JButton loginBtn = new JButton("Log In");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailt.getText();
				char[] pwarr = pwt.getPassword();
				String pw = new String(pwarr);
				String role = (String) rolec.getSelectedItem();
				ResultSet rs = u.login(email);
				
				try {
					while(rs.next()) {
						String checkemail = rs.getString("u_email");
						String checkpw = rs.getString("u_password");
						String checkrole = rs.getString("u_type");
						if(email.equals(checkemail) && pw.equals(checkpw) && role.equals(checkrole)) {
							if(role.equals("Student")) {
								frmLogIn.setVisible(false);
								new StudentDashboard(email);
								u.saveRecents(checkemail);
							}else if(role.equals("Instructor")) {
								frmLogIn.setVisible(false);
								new InstructorDashboard(email);
								u.saveRecents(checkemail);
							}else if(role.equals("Admin")) {
								frmLogIn.setVisible(false);
								new AdminDashboard(checkemail);
								u.saveRecents(checkemail);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Incorrect Details!");
						}
					}
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		loginBtn.setBounds(108, 351, 89, 23);
		loginpanel.add(loginBtn);
		
		JButton signupBtn = new JButton("Sign Up");
		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogIn.setVisible(false);
				new HomePage();
			}
		});
		signupBtn.setBounds(231, 351, 89, 23);
		loginpanel.add(signupBtn);
		frmLogIn.setVisible(true);
	}
}
