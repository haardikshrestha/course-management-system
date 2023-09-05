package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.UsersList.Admins;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditStudent {

	private JFrame frame;
	private JTextField idt;
	private JTextField newt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent window = new EditStudent();
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
	public EditStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 287, 264);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 277, 223);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Student:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 11, 141, 22);
		panel.add(lblNewLabel);
		
		idt = new JTextField();
		idt.setBounds(91, 52, 96, 20);
		panel.add(idt);
		idt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 51, 68, 22);
		panel.add(lblNewLabel_1);
		
		newt = new JTextField();
		newt.setColumns(10);
		newt.setBounds(87, 138, 96, 20);
		panel.add(newt);
		
		JLabel lblNewDetail = new JLabel("New detail:");
		lblNewDetail.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewDetail.setBounds(14, 132, 68, 22);
		panel.add(lblNewDetail);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"std_name", "std_course", "std_semester", "std_level", "std_email", "std_phone"}));
		comboBox.setBounds(13, 96, 96, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ids = idt.getText();
				int id = Integer.parseInt(ids);
				String data = newt.getText();
				String condition = (String) comboBox.getSelectedItem();
				Admins a = new Admins();
				a.editStudents(id, data, condition);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(13, 171, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
