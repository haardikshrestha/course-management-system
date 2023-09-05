package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.UsersList.Admins;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EditCourse {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField newtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCourse window = new EditCourse();
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
	public EditCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 849, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 825, 266);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course ID:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(11, 59, 78, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(81, 57, 175, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 805, 48);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		newtext = new JTextField();
		newtext.setColumns(10);
		newtext.setBounds(99, 199, 96, 20);
		panel.add(newtext);
		
		JLabel lblNewLabel_1_2 = new JLabel("New details:");
		lblNewLabel_1_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(11, 201, 78, 14);
		panel.add(lblNewLabel_1_2);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Edit Courses");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 11, 155, 36);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"c_name", "c_status"}));
		comboBox.setBounds(10, 170, 149, 20);
		panel.add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String url = "jdbc:mysql://localhost/coursework";
			    String username = "root";
			    String password = "9880august7";
				try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection(url,username,password);
		            String query = "SELECT * FROM courses WHERE  c_id = '"+id+"';";
		            Statement st = con.createStatement();
		            ResultSet rs = st.executeQuery(query);
		            ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int col = rsmd.getColumnCount();
					String[] colName = new String[col];
					for(int i = 0; i<col; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					String name, status;
					while(rs.next()) {
						id = rs.getString(1);
						name = rs.getString(2);
						status = rs.getString(3);
						String[] row = {id, name, status};
						model.addRow(row);
					}
		            System.out.println("Courses Received!");
		            
		        }catch (SQLException e1) {
		            JOptionPane.showMessageDialog(null, "Error receiving result!");
		        } catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
		        }
			}
		});
		btnSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnSearch.setBounds(261, 56, 96, 23);
		panel.add(btnSearch);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data1 = newtext.getText();
				String column = (String) comboBox.getSelectedItem();
				String s = textField.getText();
				int data = Integer.parseInt(s);
				Admins a = new Admins();
				a.editCourses(data, data1, column);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(11, 230, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}
}
