package com.studentFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.UsersList.Students;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewResult {

	private JFrame frame;
	private final JTable table = new JTable();
	private ResultSet rs;
	private String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewResult window = new ViewResult();
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
	public ViewResult(ResultSet rs) {
		this.rs = rs;
		initialize();
	}
	
	public ViewResult() {
		initialize();
	}
	
	public ViewResult(String id) {
		this.id = id;
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
		scrollPane.setBounds(10, 49, 416, 96);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewResult.class.getResource("/com/icons/icons8-examination-30.png")));
		lblNewLabel.setBounds(6, 11, 44, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Results:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(43, 17, 162, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(167, 229, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(id);
				Students s = new Students();
				int ids = Integer.parseInt(id);
				ResultSet rs = s.viewresult(ids);
				ResultSetMetaData rsmd;
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int col = rsmd.getColumnCount();
					
					String[] colName = new String[col];
					for(int i = 0; i<col; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					String id, fname, lname;
					while(rs.next()) {
						id = rs.getString(1);
						fname = rs.getString(2);
						lname = rs.getString(3);
						String[] row = {id, fname, lname};
						model.addRow(row);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnView.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnView.setBackground(Color.WHITE);
		btnView.setBounds(190, 22, 89, 23);
		frame.getContentPane().add(btnView);
		
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Students s = new Students();
				s.checkEligible(id);
			}
		});
		btnEnroll.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnEnroll.setBackground(Color.WHITE);
		btnEnroll.setBounds(167, 185, 89, 23);
		frame.getContentPane().add(btnEnroll);
		
		JLabel lblNewLabel_2 = new JLabel("Check if you are eligible to be promoted to next semester:");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(79, 156, 368, 25);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
	}
}
