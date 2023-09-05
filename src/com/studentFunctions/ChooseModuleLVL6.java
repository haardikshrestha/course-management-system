package com.studentFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.UsersList.Students;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseModuleLVL6 {

	private JFrame frame;
	private String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseModuleLVL6 window = new ChooseModuleLVL6();
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
	public ChooseModuleLVL6() {
		initialize();
	}
	
	public ChooseModuleLVL6(String id) {
		this.id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 249, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 231, 203);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChooseModuleLVL6.class.getResource("/com/icons/courses_1_35x35.png")));
		lblNewLabel.setBounds(31, 11, 41, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose module:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(78, 30, 143, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Robotics", "Game Development"}));
		comboBox.setBounds(31, 83, 157, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Augmented Reality", "Natural Language Processing"}));
		comboBox_1.setBounds(31, 130, 157, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Optional 1");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(33, 68, 81, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Optional 2");
		lblNewLabel_2_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(34, 115, 80, 14);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Students s = new Students();
				String opt1 = (String) comboBox.getSelectedItem();
				String opt2 = (String) comboBox_1.getSelectedItem();
				s.chooseModules(id, opt1, opt2);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(74, 165, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
