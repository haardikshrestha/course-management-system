package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.UsersList.Admins;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddInstructors {

	private JFrame frame;
	private JTextField namet;
	private JTextField phonet;
	private JTextField emailt;
	private JTextField mod1t;
	private JTextField mod2t;
	private JTextField ct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInstructors window = new AddInstructors();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddInstructors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 302, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 283, 279);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(37, 73, 49, 14);
		panel.add(lblNewLabel);
		
		namet = new JTextField();
		namet.setBounds(111, 70, 126, 20);
		panel.add(namet);
		namet.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblPhone.setBounds(37, 101, 49, 14);
		panel.add(lblPhone);
		
		phonet = new JTextField();
		phonet.setColumns(10);
		phonet.setBounds(111, 98, 126, 20);
		panel.add(phonet);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblEmail.setBounds(37, 129, 49, 14);
		panel.add(lblEmail);
		
		emailt = new JTextField();
		emailt.setColumns(10);
		emailt.setBounds(111, 126, 126, 20);
		panel.add(emailt);
		
		JLabel lblModule = new JLabel("Module 1:");
		lblModule.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblModule.setBounds(37, 157, 77, 14);
		panel.add(lblModule);
		
		mod1t = new JTextField();
		mod1t.setColumns(10);
		mod1t.setBounds(111, 154, 126, 20);
		panel.add(mod1t);
		
		JLabel lblModule_1 = new JLabel("Module 2:");
		lblModule_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblModule_1.setBounds(37, 185, 77, 14);
		panel.add(lblModule_1);
		
		mod2t = new JTextField();
		mod2t.setColumns(10);
		mod2t.setBounds(111, 182, 126, 20);
		panel.add(mod2t);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = namet.getText();
				String phone = phonet.getText();
				String email = emailt.getText();
				String mod1 = mod1t.getText();
				String mod2 = mod2t.getText();
				String course = ct.getText();
				
				Admins a = new Admins();
				a.addNewTutors(name, phone, mod1, mod2, email, course);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(102, 245, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Add Instructor:");
		lblNewLabel_5.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel_5.setBounds(78, 22, 174, 27);
		panel.add(lblNewLabel_5);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblCourse.setBounds(37, 213, 77, 14);
		panel.add(lblCourse);
		
		ct = new JTextField();
		ct.setColumns(10);
		ct.setBounds(111, 210, 126, 20);
		panel.add(ct);
		frame.setVisible(true);
	}
}
