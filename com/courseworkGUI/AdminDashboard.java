package com.courseworkGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.UsersList.Admins;
import com.UsersList.Users;
import com.adminFunctions.Add;
import com.adminFunctions.AddInstructors;
import com.adminFunctions.AddReminder;
import com.adminFunctions.AddStudent;
import com.adminFunctions.CancelCourse;
import com.adminFunctions.CheckReview;
import com.adminFunctions.DeleteCoursesModules;
import com.adminFunctions.DeleteInstructor;
import com.adminFunctions.DeleteStudent;
import com.adminFunctions.Edit;
import com.adminFunctions.EditInstructor;
import com.adminFunctions.EditStudent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class AdminDashboard {

	private JFrame frmAdminDashboard;
	CardLayout c;
	private JTable showTable;
	private JTextField searchBar;
	private JTable recentTable;
	private JTable showStudents;
	private JTextField searchStd;
	private JTable showIns;
	private JTextField searchIns;
	private JTextField textField_3;
	private JTextField newpwt;
	Users u = new Users();
	Admins a = new Admins();
	ResultSet rs;
	ResultSetMetaData rsmd;
	private String email;
	private String pw;
	private JPasswordField oldpwt;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
					window.frmAdminDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminDashboard() {
		c = new CardLayout();
		initialize();
	}
	
	public AdminDashboard(String email) {
		this.email = email;
		ResultSet mainrs1 = a.userinfo(email);
		try {
			while(mainrs1.next()) {
				this.pw = mainrs1.getString("u_password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		c = new CardLayout();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frmAdminDashboard = new JFrame();
		frmAdminDashboard.setTitle("Admin - Dashboard");
		frmAdminDashboard.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminDashboard.class.getResource("/com/icons/icons8-classroom-85.png")));
		frmAdminDashboard.setBounds(100, 100, 850, 433);
		frmAdminDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminDashboard.getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(null);
		headerPanel.setBackground(new Color(255, 255, 255));
		headerPanel.setBounds(679, 0, 157, 49);
		frmAdminDashboard.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		String cdate = a.getdate();
		JLabel dateHead = new JLabel(cdate);
		dateHead.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		dateHead.setBounds(19, 11, 119, 20);
		headerPanel.add(dateHead);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(158, 0, 522, 397);
		frmAdminDashboard.getContentPane().add(bodyPanel);
		bodyPanel.setLayout(c);
		
		JPanel homePanel = new JPanel();
		bodyPanel.add(homePanel, "name_163020295483500");
		homePanel.setLayout(null);
		
		JPanel coursesShow = new JPanel();
		coursesShow.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		coursesShow.setBackground(new Color(255, 255, 255));
		coursesShow.setBounds(22, 11, 110, 96);
		homePanel.add(coursesShow);
		coursesShow.setLayout(null);
		
		JLabel coursesShowIcon = new JLabel("");
		coursesShowIcon.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/courses_1_35x35.png")));
		coursesShowIcon.setBounds(6, 52, 35, 35);
		coursesShow.add(coursesShowIcon);
		
		int nocourse = a.noCourses();
		String cnum = String.valueOf(nocourse);
		JLabel coursesNum = new JLabel(cnum);
		coursesNum.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		coursesNum.setBounds(51, 21, 49, 35);
		coursesShow.add(coursesNum);
		
		JLabel coursesLbl = new JLabel("Courses");
		coursesLbl.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		coursesLbl.setBounds(51, 73, 49, 14);
		coursesShow.add(coursesLbl);
		
		JPanel tutorsShow = new JPanel();
		tutorsShow.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		tutorsShow.setBackground(new Color(255, 255, 255));
		tutorsShow.setBounds(145, 11, 110, 96);
		homePanel.add(tutorsShow);
		tutorsShow.setLayout(null);
		
		JLabel tutorsIcon = new JLabel("");
		tutorsIcon.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/teacher_35x35.png")));
		tutorsIcon.setBounds(4, 53, 35, 35);
		tutorsShow.add(tutorsIcon);
		
		int not = a.noTutors();
		String tnum = String.valueOf(not);
		JLabel tutorsNum = new JLabel(tnum);
		tutorsNum.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		tutorsNum.setBounds(51, 22, 49, 35);
		tutorsShow.add(tutorsNum);
		
		JLabel tutorsLbl = new JLabel("Tutors");
		tutorsLbl.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		tutorsLbl.setBounds(49, 74, 49, 14);
		tutorsShow.add(tutorsLbl);
		
		JPanel studentsShow = new JPanel();
		studentsShow.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		studentsShow.setBackground(new Color(255, 255, 255));
		studentsShow.setBounds(266, 11, 110, 96);
		homePanel.add(studentsShow);
		studentsShow.setLayout(null);
		
		JLabel studentIcon = new JLabel("");
		studentIcon.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/school_boy_35x35.png")));
		studentIcon.setBounds(6, 53, 35, 35);
		studentsShow.add(studentIcon);
		
		int nos = a.noCourses();
		String snum = String.valueOf(nos);
		JLabel studentNum = new JLabel(snum);
		studentNum.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		studentNum.setBounds(51, 22, 49, 35);
		studentsShow.add(studentNum);
		
		JLabel studentLbl = new JLabel("Students");
		studentLbl.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		studentLbl.setBounds(51, 74, 49, 14);
		studentsShow.add(studentLbl);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(387, 11, 110, 96);
		homePanel.add(panel_3);
		panel_3.setLayout(null);
		
		int nor = a.noReviews();
		String rnum = String.valueOf(nor);
		JLabel studentNum_1 = new JLabel(rnum);
		studentNum_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		studentNum_1.setBounds(55, 22, 49, 35);
		panel_3.add(studentNum_1);
		
		JButton btnNewButton_1 = new JButton("Reviews");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckReview();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		btnNewButton_1.setBounds(16, 67, 76, 23);
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/icons8-star-filled-30.png")));
		lblNewLabel_6.setBounds(10, 22, 35, 32);
		panel_3.add(lblNewLabel_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 141, 479, 240);
		homePanel.add(scrollPane_1);
		
		recentTable = new JTable();
		scrollPane_1.setViewportView(recentTable);
		
		JLabel lblNewLabel_5 = new JLabel("Recent Activities:");
		lblNewLabel_5.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(22, 125, 260, 14);
		homePanel.add(lblNewLabel_5);
		
		try {
			ResultSet rsrec = u.showRecents();
			ResultSetMetaData rsmdrec = rsrec.getMetaData();
			DefaultTableModel model = (DefaultTableModel) recentTable.getModel();
			
			int col = rsmdrec.getColumnCount();
			String[] colName = new String[col];
			for(int i = 0; i<col; i++) {
				colName[i] = rsmdrec.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			
			while (rsrec.next()) {
				  String activity = rsrec.getString("activity");
				  Timestamp time_info = rsrec.getTimestamp("time_info");
				  model.addRow(new Object[]{activity, time_info});
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JPanel coursesPanel = new JPanel();
		bodyPanel.add(coursesPanel, "name_163022190450400");
		coursesPanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 143, 407, 243);
		coursesPanel.add(scrollPane_2);
		
		showTable = new JTable();
		scrollPane_2.setViewportView(showTable);
		showTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		
		searchBar = new JTextField();
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = searchBar.getText();
				search(searchString);
			}
		});
		searchBar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		searchBar.setBounds(10, 118, 281, 20);
		coursesPanel.add(searchBar);
		searchBar.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(301, 117, 89, 21);
		coursesPanel.add(searchBtn);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add();
			}
		});
		addBtn.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		addBtn.setBackground(new Color(255, 255, 255));
		addBtn.setBounds(427, 200, 85, 32);
		coursesPanel.add(addBtn);
		
		JButton deleteBtn = new JButton("Delete ");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteCoursesModules();
			}
		});
		deleteBtn.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		deleteBtn.setBackground(new Color(255, 255, 255));
		deleteBtn.setBounds(427, 236, 85, 32);
		coursesPanel.add(deleteBtn);
		
		JButton cancelCBtn = new JButton("Cancel ");
		cancelCBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CancelCourse();
			}
		});
		cancelCBtn.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		cancelCBtn.setBackground(new Color(255, 255, 255));
		cancelCBtn.setBounds(427, 272, 85, 32);
		coursesPanel.add(cancelCBtn);
		
		JButton Editbtn = new JButton("Edit ");
		Editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Edit();
			}
		});
		Editbtn.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		Editbtn.setBackground(Color.WHITE);
		Editbtn.setBounds(427, 309, 85, 32);
		coursesPanel.add(Editbtn);
		
		JButton showCoursesBtn = new JButton("Show Courses");
		showCoursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable.setModel(new DefaultTableModel());
				rs = a.showCourses();
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) showTable.getModel();
					
					int col = rsmd.getColumnCount();
					String[] colName = new String[col];
					for(int i = 0; i<col; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					String id, name, status;
					while(rs.next()) {
						id = rs.getString(1);
						name = rs.getString(2);
						status = rs.getString(3);
						String[] row = {id, name, status};
						model.addRow(row);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		showCoursesBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		showCoursesBtn.setBackground(Color.WHITE);
		showCoursesBtn.setBounds(10, 61, 122, 32);
		coursesPanel.add(showCoursesBtn);
		
		JButton showModulesBtn = new JButton("Show Modules");
		showModulesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable.setModel(new DefaultTableModel());
				rs = a.showModules();
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) showTable.getModel();
					
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
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		showModulesBtn.setBackground(Color.WHITE);
		showModulesBtn.setBounds(138, 61, 122, 32);
		coursesPanel.add(showModulesBtn);
		
		
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable.setModel(new DefaultTableModel());
			}
		});
		clearBtn.setBackground(Color.WHITE);
		clearBtn.setBounds(268, 61, 122, 32);
		coursesPanel.add(clearBtn);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/courses.png")));
		icon.setBounds(427, 41, 89, 100);
		coursesPanel.add(icon);
		
		JLabel searchLbl = new JLabel("Search for a module/course:");
		searchLbl.setBounds(10, 101, 184, 14);
		coursesPanel.add(searchLbl);
		
		JLabel lblNewLabel_1 = new JLabel("Courses - Modules");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 380, 39);
		coursesPanel.add(lblNewLabel_1);
		
		JPanel studentsPanel = new JPanel();
		bodyPanel.add(studentsPanel, "name_163023583797900");
		studentsPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 502, 258);
		studentsPanel.add(scrollPane);
		
		showStudents = new JTable();
		scrollPane.setViewportView(showStudents);
		showStudents.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		searchStd = new JTextField();
		searchStd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = searchStd.getText();
				search(searchString);
			}
		});
		searchStd.setBounds(10, 103, 366, 20);
		studentsPanel.add(searchStd);
		searchStd.setColumns(10);
		
		JButton stdsearchBtn = new JButton("Search");
		stdsearchBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		stdsearchBtn.setBackground(new Color(255, 255, 255));
		stdsearchBtn.setBounds(379, 102, 94, 23);
		studentsPanel.add(stdsearchBtn);
		
		JLabel stdLbl = new JLabel("Students");
		stdLbl.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		stdLbl.setBounds(20, 11, 218, 39);
		studentsPanel.add(stdLbl);
		
		JButton addstdBtn = new JButton("Add Student");
		addstdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStudent();
			}
		});
		addstdBtn.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		addstdBtn.setBackground(Color.WHITE);
		addstdBtn.setBounds(10, 61, 112, 32);
		studentsPanel.add(addstdBtn);
		
		JButton editstdBtn = new JButton("Edit Student");
		editstdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditStudent();
			}
		});
		editstdBtn.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		editstdBtn.setBackground(Color.WHITE);
		editstdBtn.setBounds(141, 61, 112, 32);
		studentsPanel.add(editstdBtn);
		
		JButton delstdBtn = new JButton("Delete Student");
		delstdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStudent();
			}
		});
		delstdBtn.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		delstdBtn.setBackground(Color.WHITE);
		delstdBtn.setBounds(274, 61, 112, 32);
		studentsPanel.add(delstdBtn);
		
		JButton btnResult = new JButton("Create Result");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.createPromoteTable();
			}
		});
		btnResult.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		btnResult.setBackground(Color.WHITE);
		btnResult.setBounds(400, 61, 112, 32);
		studentsPanel.add(btnResult);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(248, 42, 49, 14);
		studentsPanel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/icons8-update-left-rotation-10.png")));
		btnNewButton.setBounds(477, 102, 34, 23);
		studentsPanel.add(btnNewButton);
		
		JButton btnShow_1_1 = new JButton("Show");
		btnShow_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStudents.setModel(new DefaultTableModel());
				rs = a.showStudents();
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) showStudents.getModel();
					
					int col = rsmd.getColumnCount();
					String[] colName = new String[col];
					for(int i = 0; i<col; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					while(rs.next()) {
					    model.addRow(new Object[]{rs.getInt("std_id"), rs.getString("std_name"), 
					    rs.getString("std_course"), rs.getInt("std_semester"), rs.getInt("std_level"), 
					    rs.getString("std_phone"), rs.getString("std_email"), rs.getString("optmod1"), 
					    rs.getString("optmod2")});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShow_1_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		btnShow_1_1.setBackground(Color.WHITE);
		btnShow_1_1.setBounds(329, 24, 89, 32);
		studentsPanel.add(btnShow_1_1);
		
		JButton btnShow_2 = new JButton("Clear");
		btnShow_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStudents.setModel(new DefaultTableModel());
			}
		});
		btnShow_2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		btnShow_2.setBackground(Color.WHITE);
		btnShow_2.setBounds(423, 24, 89, 32);
		studentsPanel.add(btnShow_2);
		
		JPanel instructorsPanel = new JPanel();
		bodyPanel.add(instructorsPanel, "name_163025173866900");
		instructorsPanel.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 116, 502, 270);
		instructorsPanel.add(scrollPane_3);
		
		showIns = new JTable();
		scrollPane_3.setViewportView(showIns);
		showIns.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		searchIns = new JTextField();
		searchIns.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = searchIns.getText();
				search(searchString);
			}
		});
		searchIns.setBounds(10, 90, 403, 20);
		instructorsPanel.add(searchIns);
		searchIns.setColumns(10);
		
		JButton searchInsBtn = new JButton("Search");
		searchInsBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		searchInsBtn.setBounds(423, 89, 89, 23);
		instructorsPanel.add(searchInsBtn);
		
		JButton addIns = new JButton("Add Instructors");
		addIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddInstructors();
			}
		});
		addIns.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		addIns.setBackground(Color.WHITE);
		addIns.setBounds(10, 50, 112, 32);
		instructorsPanel.add(addIns);
		
		JButton editIns = new JButton("Edit Instructors");
		editIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditInstructor();
			}
		});
		editIns.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		editIns.setBackground(Color.WHITE);
		editIns.setBounds(132, 50, 112, 32);
		instructorsPanel.add(editIns);
		
		JButton delIns = new JButton("Delete Instructors");
		delIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteInstructor();
			}
		});
		delIns.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		delIns.setBackground(Color.WHITE);
		delIns.setBounds(254, 50, 130, 32);
		instructorsPanel.add(delIns);
		
		JLabel insLbl = new JLabel("Instructors");
		insLbl.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		insLbl.setBounds(10, 6, 231, 39);
		instructorsPanel.add(insLbl);
		
		JButton btnShow = new JButton("Clear");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIns.setModel(new DefaultTableModel());
			}
		});
		btnShow.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		btnShow.setBackground(Color.WHITE);
		btnShow.setBounds(420, 50, 89, 32);
		instructorsPanel.add(btnShow);
		
		JButton btnShow_1 = new JButton("Show");
		btnShow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIns.setModel(new DefaultTableModel());
				Admins a = new Admins();
				rs = a.showTutors();
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) showIns.getModel();
					
					int col = rsmd.getColumnCount();
					String[] colName = new String[col];
					for(int i = 0; i<col; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					while (rs.next()) {
						model.addRow(new Object[]{rs.getInt("ins_id"), rs.getString("ins_name"),
						rs.getString("ins_phone"), rs.getString("mod1"), rs.getString("mod2"),
						rs.getString("ins_email")});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShow_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		btnShow_1.setBackground(Color.WHITE);
		btnShow_1.setBounds(422, 11, 89, 32);
		instructorsPanel.add(btnShow_1);
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setBorder(null);
		bodyPanel.add(settingsPanel, "name_163026686791100");
		settingsPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Settings");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 109, 29);
		settingsPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 51, 502, 69);
		settingsPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Personal Information:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 9, 129, 14);
		panel.add(lblNewLabel_2);
		
		textField_3 = new JTextField(email);
		textField_3.setColumns(10);
		textField_3.setBounds(55, 34, 177, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Email:");
		lblNewLabel_3_3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_3.setBounds(10, 37, 49, 14);
		panel.add(lblNewLabel_3_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 131, 502, 121);
		settingsPanel.add(panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Security:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(19, 9, 129, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_4 = new JLabel("Old password:");
		lblNewLabel_3_4.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_4.setBounds(19, 34, 115, 14);
		panel_1.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("New Password:");
		lblNewLabel_3_2_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_2_1.setBounds(19, 64, 115, 14);
		panel_1.add(lblNewLabel_3_2_1);
		
		newpwt = new JTextField();
		newpwt.setColumns(10);
		newpwt.setBounds(139, 60, 177, 20);
		panel_1.add(newpwt);
		
		JLabel wrongpwlbl = new JLabel("Wrong Password!");
		wrongpwlbl.setVisible(false);
		wrongpwlbl.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		wrongpwlbl.setForeground(new Color(255, 0, 0));
		wrongpwlbl.setBounds(326, 31, 104, 20);
		panel_1.add(wrongpwlbl);
		
		JLabel invalidpwlbl = new JLabel("Invalid Password!");
		invalidpwlbl.setVisible(false);
		invalidpwlbl.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		invalidpwlbl.setForeground(Color.RED);
		invalidpwlbl.setBounds(326, 63, 104, 14);
		panel_1.add(invalidpwlbl);
		
		JButton btnNewButton_2 = new JButton("Change");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] oldpwtarr = oldpwt.getPassword();
				String oldpw = new String(oldpwtarr);
				if(oldpw.equals(pw)) {
					String newpw = newpwt.getText();
					String npw = new String(newpw);
					boolean validatePw = Pattern.matches("[a-zA-z]*[@&][0-9]*", npw);
					if(validatePw) {
						a.changepw(email, npw);
					}else {
						invalidpwlbl.setVisible(true);
					}
				}else {
					wrongpwlbl.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(186, 87, 89, 23);
		panel_1.add(btnNewButton_2);
		
		oldpwt = new JPasswordField();
		oldpwt.setBounds(141, 32, 175, 23);
		panel_1.add(oldpwt);
		
		JLabel lblNewLabel_8 = new JLabel("Java College Kathmandu, Beverly Hills, Kathmandu");
		lblNewLabel_8.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 351, 305, 17);
		settingsPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("javacollegekathmandu@jck.edu.np    01-4212345");
		lblNewLabel_9.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(10, 369, 305, 17);
		settingsPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("To report any technical issues, please head over to the homepage.");
		lblNewLabel_10.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(10, 288, 382, 14);
		settingsPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Contact us:");
		lblNewLabel_11.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		lblNewLabel_11.setBounds(10, 333, 79, 14);
		settingsPanel.add(lblNewLabel_11);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(255, 153, 102));
		buttonsPanel.setBounds(0, 0, 157, 397);
		frmAdminDashboard.getContentPane().add(buttonsPanel);
		
		
		
		
		JButton homeBtn = new JButton("  Home");
		homeBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(bodyPanel, "name_163020295483500");
			}
		});
		homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		homeBtn.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/icons8-house-40.png")));
		homeBtn.setBounds(10, 115, 137, 39);
		homeBtn.setBackground(new Color(255, 255, 255));
		
		JButton coursesBtn = new JButton(" Courses");
		coursesBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		coursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(bodyPanel, "name_163022190450400");
			}
		});
		coursesBtn.setHorizontalAlignment(SwingConstants.LEFT);
		coursesBtn.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/courses_1_35x35.png")));
		coursesBtn.setBounds(10, 160, 137, 39);
		coursesBtn.setBackground(Color.WHITE);
		
		JButton studentsBtn = new JButton(" Students");
		studentsBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		studentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(bodyPanel, "name_163023583797900");
			}
		});
		studentsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		studentsBtn.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/school_boy_35x35.png")));
		studentsBtn.setBounds(10, 205, 137, 39);
		studentsBtn.setBackground(Color.WHITE);
		
		JButton instructorsBtn = new JButton(" Tutors");
		instructorsBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		instructorsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(bodyPanel, "name_163025173866900");
			}
		});
		instructorsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		instructorsBtn.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/teacher_35x35.png")));
		instructorsBtn.setBounds(10, 250, 137, 39);
		instructorsBtn.setBackground(Color.WHITE);
		
		JButton settingsBtn = new JButton(" Settings");
		settingsBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		settingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(bodyPanel, "name_163026686791100");
			}
		});
		settingsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		settingsBtn.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/icons8-settings-48_35x35.png")));
		settingsBtn.setBounds(10, 295, 137, 39);
		settingsBtn.setBackground(Color.WHITE);
		
		JButton logoutBtn = new JButton("  Log Out");
		logoutBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminDashboard.setVisible(false);
				new LoginPage();
				JOptionPane.showMessageDialog(null, "Logged out succesfully!");
			}
		});
		logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
		logoutBtn.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/icons8-logout-58_1_30x30.png")));
		logoutBtn.setBounds(10, 340, 137, 39);
		logoutBtn.setBackground(Color.WHITE);
		
		JLabel mainIcon = new JLabel("");
		mainIcon.setBounds(31, -2, 97, 85);
		mainIcon.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/icons8-cap-85.png")));
		buttonsPanel.setLayout(null);
		buttonsPanel.add(homeBtn);
		buttonsPanel.add(coursesBtn);
		buttonsPanel.add(studentsBtn);
		buttonsPanel.add(instructorsBtn);
		buttonsPanel.add(settingsBtn);
		buttonsPanel.add(logoutBtn);
		buttonsPanel.add(mainIcon);
		
		JLabel iconName = new JLabel("JCK");
		iconName.setFont(new Font("SansSerif", Font.BOLD, 21));
		iconName.setBounds(54, 75, 57, 26);
		buttonsPanel.add(iconName);
		
		JPanel remindersPanel = new JPanel();
		remindersPanel.setBorder(null);
		remindersPanel.setBackground(new Color(255, 255, 255));
		remindersPanel.setBounds(679, 46, 157, 351);
		frmAdminDashboard.getContentPane().add(remindersPanel);
		remindersPanel.setLayout(null);
		
		JLabel reminderHead = new JLabel("Reminders:");
		reminderHead.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		reminderHead.setBounds(48, 10, 93, 19);
		remindersPanel.add(reminderHead);
		
		JLabel reminderIcon = new JLabel("");
		reminderIcon.setIcon(new ImageIcon(AdminDashboard.class.getResource("/com/icons/icons8-doorbell-48_20x20.png")));
		reminderIcon.setBounds(22, 4, 25, 32);
		remindersPanel.add(reminderIcon);
		
		JButton reminderBtn = new JButton("Add Reminders");
		reminderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddReminder();
			}
		});
		reminderBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		reminderBtn.setBackground(new Color(255, 255, 255));
		reminderBtn.setForeground(new Color(0, 0, 0));
		reminderBtn.setBounds(15, 46, 126, 23);
		remindersPanel.add(reminderBtn);
		
		JPanel reminder1 = new JPanel();
		reminder1.setBounds(10, 89, 137, 76);
		remindersPanel.add(reminder1);
		
		JPanel reminder2 = new JPanel();
		reminder2.setBounds(10, 176, 137, 76);
		remindersPanel.add(reminder2);
		
		JPanel reminder3 = new JPanel();
		reminder3.setBounds(10, 264, 137, 76);
		remindersPanel.add(reminder3);
		frmAdminDashboard.setVisible(true);
	}
	
	public void search(String str) {
		DefaultTableModel model = (DefaultTableModel) showTable.getModel();
		DefaultTableModel model1 = (DefaultTableModel) showStudents.getModel();
		DefaultTableModel model2 = (DefaultTableModel) showIns.getModel();
		
		
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<> ( model);

		TableRowSorter<DefaultTableModel> trs1 = new TableRowSorter<> ( model1);

		TableRowSorter<DefaultTableModel> trs2 = new TableRowSorter<> ( model2);
		showTable.setRowSorter(trs);
		showStudents.setRowSorter(trs1);
		showIns.setRowSorter(trs2);
		trs.setRowFilter(RowFilter.regexFilter(str));
		trs1.setRowFilter(RowFilter.regexFilter(str));
		trs2.setRowFilter(RowFilter.regexFilter(str));
	}
}
