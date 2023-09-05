package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
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
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 274, 241);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 5, 260, 199);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Add.class.getResource("/com/icons/courses_1_35x35.png")));
		lblNewLabel.setBounds(44, 73, 46, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add courses/modules");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel_1.setBounds(22, 11, 229, 30);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Course", "Module"}));
		comboBox.setBounds(86, 92, 121, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Choose");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(88, 74, 49, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
				if(c.equals("Course")) {
					frame.setVisible(false);
					new AddCourses();
					
				}else if (c.equals("Module")) {
					frame.setVisible(false);
					new AddModules();
				}
			    }
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(86, 153, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}
}
