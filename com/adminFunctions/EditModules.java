package com.adminFunctions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.UsersList.Admins;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EditModules {

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
					EditModules window = new EditModules();
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
	public EditModules() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 907, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 892, 251);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Module:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 11, 141, 22);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(91, 52, 179, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Module ID:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 51, 68, 22);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 866, 61);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		newtext = new JTextField();
		newtext.setColumns(10);
		newtext.setBounds(85, 191, 274, 20);
		panel.add(newtext);
		
		JLabel lblNewDetail = new JLabel("New detail:");
		lblNewDetail.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewDetail.setBounds(17, 188, 68, 22);
		panel.add(lblNewDetail);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"m_name", "m_status", "m_semester", "m_credits", "m_type"}));
		comboBox.setBounds(14, 154, 96, 22);
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
		            String query = "SELECT * FROM modules WHERE m_id = '"+id+"';";
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
					
					
					while(rs.next()) {
						 model.addRow(new Object[]{rs.getString("m_id"), rs.getString("m_name"), 
						 rs.getInt("c_id"), rs.getString("ins_name"), rs.getString("m_status"), 
						 rs.getInt("m_semester"), rs.getInt("m_credits"), rs.getString("m_type")});
					}
					
		           
		        }catch (SQLException e1) {
		            JOptionPane.showMessageDialog(null, "Error receiving result!");
		        } catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
		        }
			}
		});
		btnSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnSearch.setBounds(277, 51, 89, 23);
		panel.add(btnSearch);
		
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data1 = newtext.getText();
				String column = (String) comboBox.getSelectedItem();
				String data = textField.getText();
				Admins a = new Admins();
				a.editModules(data, data1, column);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton.setBounds(15, 223, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
