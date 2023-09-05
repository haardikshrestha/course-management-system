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

public class EditInstructor {

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
					EditInstructor window = new EditInstructor();
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
	public EditInstructor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 257, 237);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 241, 198);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Instructor:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 11, 141, 22);
		panel.add(lblNewLabel);
		
		idt = new JTextField();
		idt.setBounds(91, 52, 96, 20);
		panel.add(idt);
		idt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Instructor ID:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 51, 68, 22);
		panel.add(lblNewLabel_1);
		
		newt = new JTextField();
		newt.setColumns(10);
		newt.setBounds(122, 116, 96, 20);
		panel.add(newt);
		
		JLabel lblNewDetail = new JLabel("New detail:");
		lblNewDetail.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewDetail.setBounds(10, 116, 68, 22);
		panel.add(lblNewDetail);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ins_name", "ins_phone", "mod1", "mod2", "ins_email"}));
		comboBox.setBounds(10, 83, 96, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ids = idt.getText();
				int data = Integer.parseInt(ids);
				String data1 = newt.getText();
				String column = (String) comboBox.getSelectedItem();
				Admins a = new Admins();
				a.editInstructors(data, data1, column);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 157, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
