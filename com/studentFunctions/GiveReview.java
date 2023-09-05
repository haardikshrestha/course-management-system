package com.studentFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.UsersList.Students;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiveReview {

	private JFrame frmStudentGive;
	private String remark;
	private int rating;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiveReview window = new GiveReview();
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
	public GiveReview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentGive = new JFrame();
		frmStudentGive.setIconImage(Toolkit.getDefaultToolkit().getImage(GiveReview.class.getResource("/com/icons/icons8-classroom-85.png")));
		frmStudentGive.setTitle("Student - Give Review");
		frmStudentGive.setBounds(100, 100, 260, 264);
		frmStudentGive.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentGive.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 225, 205);
		frmStudentGive.getContentPane().add(panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "4", "3", "2", "1"}));
		comboBox.setBounds(103, 91, 96, 22);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(90, 11, 49, 30);
		lblNewLabel.setIcon(new ImageIcon(GiveReview.class.getResource("/com/icons/icons8-star-filled-30.png")));
		panel.setLayout(null);
		panel.add(comboBox);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Give feedbacks about our app:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 52, 178, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rate:");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(31, 95, 49, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Remarks:");
		lblNewLabel_2_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(31, 136, 62, 14);
		panel.add(lblNewLabel_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Good", "UI changes", "Add Features"}));
		comboBox_1.setBounds(103, 132, 96, 22);
		panel.add(comboBox_1);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String remark = (String) comboBox_1.getSelectedItem();
				System.out.println(remark);
				Students s = new Students();
				String rating = (String) comboBox.getSelectedItem();
				System.out.println(rating);
				s.reviewapp(remark, rating);
				frmStudentGive.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(68, 173, 89, 23);
		panel.add(btnNewButton);
		frmStudentGive.setVisible(true);
	}
}
