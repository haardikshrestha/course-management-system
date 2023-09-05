package com.studentFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

import com.UsersList.Students;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewTutor {

	private JFrame frmStudentGive;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewTutor window = new ReviewTutor();
					window.frmStudentGive.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReviewTutor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentGive = new JFrame();
		frmStudentGive.setIconImage(Toolkit.getDefaultToolkit().getImage(ReviewTutor.class.getResource("/com/icons/icons8-classroom-85.png")));
		frmStudentGive.setTitle("Student - Give Review");
		frmStudentGive.setBounds(100, 100, 272, 290);
		frmStudentGive.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentGive.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 243, 240);
		frmStudentGive.getContentPane().add(panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "4", "3", "2", "1"}));
		comboBox.setBounds(116, 126, 96, 22);
		String rate = (String) comboBox.getSelectedItem();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(90, 11, 49, 30);
		lblNewLabel.setIcon(new ImageIcon(ReviewTutor.class.getResource("/com/icons/icons8-star-filled-30.png")));
		panel.setLayout(null);
		panel.add(comboBox);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Review your Instructor:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(47, 52, 146, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rate:");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(29, 130, 49, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Remarks:");
		lblNewLabel_2_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(29, 171, 62, 14);
		panel.add(lblNewLabel_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Excellent", "Very Good", "Friendly", "Lousy", "Boring", "Rude"}));
		comboBox_1.setBounds(116, 167, 96, 22);
		panel.add(comboBox_1);
		
		
		JLabel lblNewLabel_2_2 = new JLabel("Instructor ID:");
		lblNewLabel_2_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(29, 89, 82, 14);
		panel.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setBounds(116, 85, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Students s = new Students();
				String remark = (String) comboBox_1.getSelectedItem();
				String text = textField.getText();
				String rate = (String) comboBox.getSelectedItem();
				s.reviewInstructor(text, remark, rate);
				frmStudentGive.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(78, 208, 89, 23);
		panel.add(btnNewButton);
		
		
		
		
		frmStudentGive.setVisible(true);
	}
}
