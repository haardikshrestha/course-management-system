package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.UsersList.Admins;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AddReminder {

	private JFrame frame;
	private JTextField mod;
	private JTextField datet;
	private JTextField roomt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReminder window = new AddReminder();
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
	public AddReminder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 314, 276);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 295, 235);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		mod = new JTextField();
		mod.setBounds(166, 111, 96, 20);
		panel.add(mod);
		mod.setColumns(10);
		
		datet = new JTextField();
		datet.setColumns(10);
		datet.setBounds(166, 144, 96, 20);
		panel.add(datet);
		
		JLabel lblNewLabel = new JLabel("Room:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(38, 82, 108, 14);
		panel.add(lblNewLabel);
		
		JLabel lblModule = new JLabel("Module:");
		lblModule.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblModule.setBounds(38, 114, 108, 14);
		panel.add(lblModule);
		
		JLabel da = new JLabel("Date:");
		da.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		da.setBounds(38, 147, 118, 14);
		panel.add(da);
		
		JLabel lblNewLabel_1 = new JLabel("Reminders");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel_1.setBounds(112, 11, 127, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AddReminder.class.getResource("/com/icons/icons8-doorbell-48_20x20.png")));
		lblNewLabel_2.setBounds(76, 11, 26, 31);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Post");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admins a = new Admins();
				String room = (String) roomt.getText();
				String module = mod.getText();
				String date = datet.getText();
				a.addReminder(module, room, date);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(101, 201, 89, 23);
		panel.add(btnNewButton);
		
		roomt = new JTextField();
		roomt.setColumns(10);
		roomt.setBounds(166, 80, 96, 20);
		panel.add(roomt);
		frame.setVisible(true);
	}

}
