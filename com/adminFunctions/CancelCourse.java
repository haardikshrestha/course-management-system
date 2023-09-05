package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.UsersList.Admins;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelCourse {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelCourse window = new CancelCourse();
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
	public CancelCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 278, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 184);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the course/module ID:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(65, 82, 189, 20);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(88, 113, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cancel Course");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(88, 11, 96, 20);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Course", "Module"}));
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		comboBox.setBounds(88, 49, 96, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String choice = (String) comboBox.getSelectedItem();
				Admins a = new Admins();
				String s = textField.getText();
				if(choice.equals("Course")) {
					int data = Integer.parseInt(s);
					a.cancelCourse(data);
					frame.setVisible(false);
				}else if(choice.equals("Module")) {
					a.cancelModule(s);
					frame.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(88, 150, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
