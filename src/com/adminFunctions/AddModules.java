package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.UsersList.Admins;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddModules {

	private JFrame frame;
	private JTextField mname;
	private JTextField course;
	private JTextField ins;
	private JTextField credits;
	private JTextField mid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddModules window = new AddModules();
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
	public AddModules() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 329, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 312, 329);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Module:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel.setBounds(86, 24, 158, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(27, 88, 49, 14);
		panel.add(lblNewLabel_1);
		
		mname = new JTextField();
		mname.setBounds(96, 85, 171, 17);
		panel.add(mname);
		mname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course id:");
		lblNewLabel_1_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(27, 115, 75, 14);
		panel.add(lblNewLabel_1_1);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(96, 112, 171, 17);
		panel.add(course);
		
		JLabel lblNewLabel_1_2 = new JLabel("Instructor:");
		lblNewLabel_1_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(27, 143, 75, 14);
		panel.add(lblNewLabel_1_2);
		
		ins = new JTextField();
		ins.setColumns(10);
		ins.setBounds(96, 140, 171, 17);
		panel.add(ins);
		
		JLabel lblNewLabel_1_3 = new JLabel("Semester:");
		lblNewLabel_1_3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(27, 171, 75, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Credits:");
		lblNewLabel_1_4.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_4.setBounds(27, 201, 49, 14);
		panel.add(lblNewLabel_1_4);
		
		credits = new JTextField();
		credits.setColumns(10);
		credits.setBounds(96, 198, 171, 17);
		panel.add(credits);
		
		JLabel lblNewLabel_1_5 = new JLabel("Type:");
		lblNewLabel_1_5.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_5.setBounds(27, 229, 49, 14);
		panel.add(lblNewLabel_1_5);
		
		JComboBox sem = new JComboBox();
		sem.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		sem.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		sem.setBounds(96, 168, 171, 18);
		panel.add(sem);
		
		JComboBox types = new JComboBox();
		types.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		types.setModel(new DefaultComboBoxModel(new String[] {"Compulsory", "Optional"}));
		types.setBounds(96, 223, 171, 26);
		panel.add(types);
		
		JComboBox state = new JComboBox();
		state.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		state.setModel(new DefaultComboBoxModel(new String[] {"Ongoing", "Cancelled"}));
		state.setBounds(96, 255, 171, 26);
		panel.add(state);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Status:");
		lblNewLabel_1_5_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_5_1.setBounds(27, 257, 49, 14);
		panel.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_6 = new JLabel("ID:");
		lblNewLabel_1_6.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_6.setBounds(27, 63, 49, 14);
		panel.add(lblNewLabel_1_6);
		
		mid = new JTextField();
		mid.setColumns(10);
		mid.setBounds(96, 60, 171, 17);
		panel.add(mid);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admins a = new Admins();
				String name = mname.getText();
				String cid = course.getText();
				String ins_name = ins.getText();
				String status = (String) state.getSelectedItem();
				String cred = credits.getText();
				String type = (String) types.getSelectedItem();
				String sems = (String) sem.getSelectedItem();
				String m_id = mid.getText();
				a.addModules(m_id, name, cid, ins_name, status, sems, cred, type);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(108, 295, 89, 23);
		panel.add(btnNewButton);
		
		
		
		
		frame.setVisible(true);
	}

}
