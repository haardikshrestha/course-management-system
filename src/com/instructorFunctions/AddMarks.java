package com.instructorFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import com.UsersList.Instructors;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMarks {

	private JFrame frame;
	private JTextField stdid_txt;
	private JTextField mid_txt;
	private JTextField marks_txt;
	private JLabel lblNewLabel;
	private JLabel lblModuleId;
	private JLabel lblMarksObtained;
	private JLabel lblRemarks;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	Instructors i = new Instructors();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarks window = new AddMarks();
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
	public AddMarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 367, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 348, 252);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		stdid_txt = new JTextField();
		stdid_txt.setBounds(163, 74, 142, 20);
		panel.add(stdid_txt);
		stdid_txt.setColumns(10);
		
		mid_txt = new JTextField();
		mid_txt.setColumns(10);
		mid_txt.setBounds(163, 105, 142, 20);
		panel.add(mid_txt);
		
		marks_txt = new JTextField();
		marks_txt.setColumns(10);
		marks_txt.setBounds(163, 136, 142, 20);
		panel.add(marks_txt);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Excellent", "Very Good", "Good", "Satisfactory", "Try Harder", "Fail"}));
		comboBox.setBounds(163, 172, 142, 22);
		panel.add(comboBox);
		
		lblNewLabel = new JLabel("Student ID:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(44, 77, 94, 17);
		panel.add(lblNewLabel);
		
		lblModuleId = new JLabel("Module ID:");
		lblModuleId.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblModuleId.setBounds(44, 108, 94, 17);
		panel.add(lblModuleId);
		
		lblMarksObtained = new JLabel("Marks Obtained:");
		lblMarksObtained.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblMarksObtained.setBounds(44, 139, 94, 17);
		panel.add(lblMarksObtained);
		
		lblRemarks = new JLabel("Remarks:");
		lblRemarks.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblRemarks.setBounds(44, 172, 69, 18);
		panel.add(lblRemarks);
		
		btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String std_id = stdid_txt.getText();
				String m_id = mid_txt.getText();
				String marks = marks_txt.getText();
				String remarks = (String) comboBox.getSelectedItem();
				i.giveMarks(std_id, m_id, marks, remarks);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(125, 218, 89, 23);
		panel.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Add Marks:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(118, 23, 130, 31);
		panel.add(lblNewLabel_1);
		frame.setVisible(true);
	}

}
