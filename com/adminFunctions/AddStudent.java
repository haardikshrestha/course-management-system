package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.UsersList.Admins;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AddStudent {

	private JFrame frame;
	private JTextField namet;
	private JTextField phonet;
	private JTextField emailt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent window = new AddStudent();
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
	public AddStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(83, 75, 49, 14);
		panel.add(lblNewLabel);
		
		namet = new JTextField();
		namet.setBounds(153, 72, 179, 20);
		panel.add(namet);
		namet.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblPhone.setBounds(83, 103, 49, 14);
		panel.add(lblPhone);
		
		phonet = new JTextField();
		phonet.setColumns(10);
		phonet.setBounds(153, 100, 179, 20);
		panel.add(phonet);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblEmail.setBounds(83, 131, 49, 14);
		panel.add(lblEmail);
		
		emailt = new JTextField();
		emailt.setColumns(10);
		emailt.setBounds(153, 128, 179, 20);
		panel.add(emailt);
		
		JLabel lblNewLabel_2_1 = new JLabel("Semester:");
		lblNewLabel_2_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(83, 161, 72, 14);
		panel.add(lblNewLabel_2_1);
		
		JComboBox semc = new JComboBox();
		semc.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		semc.setBounds(153, 159, 179, 20);
		panel.add(semc);
		
		JComboBox levelc = new JComboBox();
		levelc.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
		levelc.setBounds(153, 191, 179, 20);
		panel.add(levelc);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Level:");
		lblNewLabel_2_1_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_2_1_1.setBounds(83, 193, 49, 14);
		panel.add(lblNewLabel_2_1_1);
		
		JComboBox coursec = new JComboBox();
		coursec.setBounds(153, 222, 179, 20);
		panel.add(coursec);
		Admins a = new Admins();
		ResultSet rs = a.courseNames();
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			while(rs.next()) {
				    coursec.addItem(rs.getString("c_name"));
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Course:");
		lblNewLabel_2_1_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_2_1_2.setBounds(83, 224, 49, 14);
		panel.add(lblNewLabel_2_1_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = namet.getText();
				String phone = phonet.getText();
				String email = emailt.getText();
				String sems = (String) semc.getSelectedItem();
				
				String lvls = (String) levelc.getSelectedItem();
				
				String course = (String) coursec.getSelectedItem();
				
				Admins a = new Admins();
				a.addNewStudents(name, course, sems, lvls, phone, email);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(167, 273, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Add new student");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel_1.setBounds(138, 15, 236, 30);
		panel.add(lblNewLabel_1);
		frame.setVisible(true);
	}

}
