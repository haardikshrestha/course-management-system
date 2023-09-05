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

public class DeleteInstructor {

	private JFrame frame;
	private JTextField idt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteInstructor window = new DeleteInstructor();
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
	public DeleteInstructor() {
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
		
		JLabel lblNewLabel = new JLabel("Delete Instructor");
		lblNewLabel.setBounds(10, 11, 89, 14);
		panel.add(lblNewLabel);
		
		idt = new JTextField();
		idt.setBounds(130, 42, 96, 20);
		panel.add(idt);
		idt.setColumns(10);
		
		JLabel lblEnterStudentId = new JLabel("Enter Instructor ID:");
		lblEnterStudentId.setBounds(20, 45, 100, 14);
		panel.add(lblEnterStudentId);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ids = idt.getText();
				int id = Integer.parseInt(ids);
				Admins a = new Admins();
				a.deleteInstructor(id);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(90, 90, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
