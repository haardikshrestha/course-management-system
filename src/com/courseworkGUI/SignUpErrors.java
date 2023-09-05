package com.courseworkGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpErrors {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpErrors window = new SignUpErrors();
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
	public SignUpErrors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 404, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 370, 200);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(156, 177, 59, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Invalid Input!");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(10, 11, 111, 28);
		panel.add(lblNewLabel);
		
		JTextPane txtpnPleaseMakeSure = new JTextPane();
		txtpnPleaseMakeSure.setEditable(false);
		txtpnPleaseMakeSure.setText("Please make sure the inputs match the following:\r\n• The password should be atleast 6 characters long and should be the combination of letters and numbers with a special character in between. (hey@11)\r\n• Username should be atleast 6 characters long with the same conditions.\r\n• Phone number should be 10 digits long.");
		txtpnPleaseMakeSure.setBackground(UIManager.getColor("Button.background"));
		txtpnPleaseMakeSure.setBounds(10, 43, 350, 131);
		panel.add(txtpnPleaseMakeSure);
		frame.setVisible(true);
	}
}
