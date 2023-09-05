package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.UsersList.Admins;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteStudent {

	private JFrame frame;
	private JTextField t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent window = new DeleteStudent();
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
	public DeleteStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 298, 191);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 275, 150);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Student");
		lblNewLabel.setBounds(10, 11, 89, 14);
		panel.add(lblNewLabel);
		
		t = new JTextField();
		t.setBounds(130, 42, 96, 20);
		panel.add(t);
		t.setColumns(10);
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID:");
		lblEnterStudentId.setBounds(20, 45, 100, 14);
		panel.add(lblEnterStudentId);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String datas = t.getText();
				int data = Integer.parseInt(datas);
				Admins a = new Admins();
				a.deleteStudent(data);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(90, 90, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
