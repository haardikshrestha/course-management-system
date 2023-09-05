package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.UsersList.Admins;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class CheckReview {

	private JFrame frame;
	private final JTable table = new JTable();
	Admins a = new Admins();
	ResultSet rs;
	ResultSetMetaData rsmd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckReview window = new CheckReview();
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
	public CheckReview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 65, 386, 150);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Reviews");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel.setBounds(60, 17, 111, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CheckReview.class.getResource("/com/icons/icons8-star-filled-30.png")));
		lblNewLabel_1.setBounds(19, 18, 40, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs =  a.showReviews();
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int col = rsmd.getColumnCount();
					String[] colName = new String[col];
					for(int i = 0; i<col; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					while (rs.next()) {
					    model.addRow(new Object[]{rs.getString("remark"), rs.getInt("rating")});
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(318, 24, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(166, 229, 89, 23);
		frame.getContentPane().add(btnBack);
		frame.setVisible(true);
	}

}
