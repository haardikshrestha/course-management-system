package com.courseworkGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import com.UsersList.Admins;
import com.UsersList.Instructors;
import com.UsersList.Students;
import com.UsersList.Users;

import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HomePage {

	private JFrame frmSignUp;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JPasswordField passwordField;
	private JTextField mod1t;
	private String course;
	private String level;
	private String sem;
	Admins a = new Admins();
	Users u = new Users();
	Students s = new Students();
	Instructors i = new Instructors();
	private JTextField mod2t;
	private JTextField tmod1;
	private JTextField tmod2;
	private String module1;
	private String module2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String url = "jdbc:mysql://localhost/Demo";
		String username = "root";
		String password = "9880august7";

		frmSignUp = new JFrame();
		frmSignUp.setTitle("Sign Up");
		frmSignUp.setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/com/icons/icons8-classroom-85.png")));
		frmSignUp.setBounds(380, 30, 502, 631);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel body = new JPanel();
		body.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frmSignUp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(body, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(body, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
		);
		
		JLabel header = new JLabel("Java College Kathmandu");
		header.setBounds(116, 17, 237, 26);
		header.setFont(new Font("SansSerif", Font.BOLD, 20));
		body.setLayout(null);
		
		JLabel mainIcon = new JLabel("");
		mainIcon.setBounds(191, 51, 89, 77);
		mainIcon.setIcon(new ImageIcon(HomePage.class.getResource("/com/icons/icons8-classroom-85.png")));
		body.add(mainIcon);
		body.add(header);
		
		JLabel userHead = new JLabel("Enter your name:");
		userHead.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		userHead.setBounds(172, 145, 133, 14);
		body.add(userHead);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(171, 164, 182, 20);
		body.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel emailHead = new JLabel("Enter your email:");
		emailHead.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		emailHead.setBounds(172, 197, 133, 14);
		body.add(emailHead);
		
		JLabel phoneHead = new JLabel("Enter your phone number:");
		phoneHead.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		phoneHead.setBounds(172, 253, 181, 14);
		body.add(phoneHead);
		
		JLabel passwordHead = new JLabel("Enter your password:");
		passwordHead.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		passwordHead.setBounds(172, 311, 133, 14);
		body.add(passwordHead);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(171, 217, 182, 20);
		body.add(emailTextField);
		
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(171, 271, 182, 20);
		body.add(phoneTextField);
		
		
		
		JButton loginBtn = new JButton("Log In");
		loginBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSignUp.setVisible(false);
				new LoginPage();
			}
		});
		loginBtn.setBounds(264, 549, 89, 23);
		body.add(loginBtn);
		
		JLabel userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(HomePage.class.getResource("/com/icons/icons8-selfies-80_40x40.png")));
		userIcon.setBounds(116, 145, 44, 39);
		body.add(userIcon);
		
		JLabel emailIcon = new JLabel("");
		emailIcon.setIcon(new ImageIcon(HomePage.class.getResource("/com/icons/icons8-email-sign-80_40x40.png")));
		emailIcon.setBounds(116, 200, 44, 39);
		body.add(emailIcon);
		
		JLabel phoneIcon = new JLabel("");
		phoneIcon.setIcon(new ImageIcon(HomePage.class.getResource("/com/icons/icons8-phone-80_40x40.png")));
		phoneIcon.setBounds(116, 258, 40, 33);
		body.add(phoneIcon);
		
		JLabel passwordIcon = new JLabel("");
		passwordIcon.setIcon(new ImageIcon(HomePage.class.getResource("/com/icons/icons8-password-80_40x40.png")));
		passwordIcon.setBounds(118, 312, 44, 39);
		body.add(passwordIcon);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 330, 183, 20);
		body.add(passwordField);
		
		JComboBox ccombo = new JComboBox();
		ccombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				course =  (String) ccombo.getSelectedItem();
			}
		});
		ccombo.setVisible(false);
		ccombo.setBounds(85, 413, 105, 26);
		body.add(ccombo);
		ResultSet rs = a.courseNames();
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			while(rs.next()) {
				ccombo.addItem(rs.getString("c_name"));
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		JLabel roleHeader = new JLabel("Enter your role:");
		roleHeader.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		roleHeader.setBounds(171, 362, 133, 14);
		body.add(roleHeader);
		
		JLabel roleIcon = new JLabel("");
		roleIcon.setIcon(new ImageIcon(HomePage.class.getResource("/com/icons/icons8-classroom-80_40x40.png")));
		roleIcon.setBounds(116, 365, 44, 39);
		body.add(roleIcon);
		
		JTextPane loginText = new JTextPane();
		loginText.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		loginText.setBackground(new Color(255, 255, 255));
		loginText.setText("Already have an account?");
		loginText.setBounds(116, 552, 150, 20);
		body.add(loginText);
		
		JComboBox scombo = new JComboBox();
		scombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sem = (String) scombo.getSelectedItem();
			}
		});
		scombo.setVisible(false);
		scombo.setModel(new DefaultComboBoxModel(new String[] {"Semester", "1", "2", "3", "4", "5", "6"}));
		scombo.setBounds(200, 413, 105, 26);
		body.add(scombo);
		
		JComboBox lcombo = new JComboBox();
		lcombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = (String) lcombo.getSelectedItem();
			}
		});
		lcombo.setVisible(false);
		lcombo.setModel(new DefaultComboBoxModel(new String[] {"Level", "4", "5", "6"}));
		lcombo.setBounds(315, 413, 105, 26);
		body.add(lcombo);
		
		tmod1 = new JTextField();
		tmod1.setVisible(false);
		tmod1.setBounds(172, 456, 105, 26);
		body.add(tmod1);
		tmod1.setColumns(10);
		
		
		
		tmod2 = new JTextField();
		tmod2.setVisible(false);
		tmod2.setColumns(10);
		tmod2.setBounds(288, 457, 105, 26);
		body.add(tmod2);
		
		
		JLabel modlbl = new JLabel("Modules:");
		modlbl.setVisible(false);
		modlbl.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		modlbl.setBounds(111, 462, 69, 14);
		body.add(modlbl);
		
		JComboBox roleComboBox = new JComboBox();
		roleComboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		roleComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(roleComboBox.getSelectedItem().equals("Student")) {
					tmod1.setVisible(false);
					tmod2.setVisible(false);
					modlbl.setVisible(false);
					ccombo.setVisible(true);
					scombo.setVisible(true);
					lcombo.setVisible(true);
				}else if(roleComboBox.getSelectedItem().equals("Instructor")) {
					ccombo.setVisible(true);
					scombo.setVisible(false);
					lcombo.setVisible(false);
					tmod1.setVisible(true);
					tmod2.setVisible(true);
					modlbl.setVisible(true);
				}
			}
		});
		
		
		
		roleComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select your role", "Student", "Instructor"}));
		roleComboBox.setMaximumRowCount(4);
		roleComboBox.setBounds(171, 380, 184, 22);
		body.add(roleComboBox);
		
		JLabel invalidPw = new JLabel("Invalid!");
		invalidPw.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		invalidPw.setVisible(false);
		invalidPw.setForeground(new Color(255, 0, 0));
		invalidPw.setBounds(363, 334, 49, 14);
		body.add(invalidPw);
		
		JButton signupBtn = new JButton("Sign Up");
		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String module1 = tmod1.getText();
				String module2 = tmod2.getText();
				String name = nameTextField.getText();
				String phone = phoneTextField.getText();
				String role = (String) roleComboBox.getSelectedItem();
				String email = emailTextField.getText();
				char[] pwarr = passwordField.getPassword();
				String pw = new String(pwarr);
				boolean validatePw = Pattern.matches("[a-zA-z]*[@&][0-9]*", pw);
				
				
				if(role.equals("Student")) {
					if(validatePw) {
						
						u.newuser(email, pw, role);
						s.addNewStudent(name, course, sem, level, phone, email);
						JOptionPane.showMessageDialog(null, "Welcome! (●'◡'●)");
						System.out.println("Done!");
						frmSignUp.setVisible(false);
						new LoginPage();
					}else if(!validatePw){
						invalidPw.setVisible(true);
						JOptionPane.showMessageDialog(null, "Invalid Password!");
					}
				}else if(role.equals("Instructor")) {
					if(validatePw) {
						u.newuser(email, pw, role);
						i.addNewTutors(name, phone, module1, module2, email, course);
						System.out.println("Done!");
						JOptionPane.showMessageDialog(null, "Welcome! (●'◡'●)");
						frmSignUp.setVisible(false);
						new LoginPage();
					}else if(!validatePw){
						invalidPw.setVisible(true);
						JOptionPane.showMessageDialog(null, "Invalid Password!");
						new SignUpErrors();
					}
				}
			}
		});
		signupBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		
		signupBtn.setBounds(191, 506, 89, 23);
		body.add(signupBtn);

		frmSignUp.getContentPane().setLayout(groupLayout);
		frmSignUp.setVisible(true);
	}
}
