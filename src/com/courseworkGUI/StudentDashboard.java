package com.courseworkGUI;

import java.io.IOException;
import java.net.URISyntaxException;

import com.UsersList.Students;
import com.UsersList.Users;
import com.studentFunctions.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.LayoutStyle.ComponentPlacement;
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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;

public class StudentDashboard {

	private JFrame frmStudentDashboard;
	CardLayout c;
	private JTable coursetable;
	private JTextField searchBar;
	private JTable showStudents;
	private JTextField searchStd;
	private JTable showIns;
	private JTextField searchIns;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String email;
	Students s = new Students();
	ResultSet rs;
	ResultSetMetaData rsmd;
	private String id;
	private String name;
	private String course;
	private String semester;
	private String level;
	private String phone;
	private String opt1;
	private String opt2;
	private JPasswordField oldpwt;
	private JPasswordField newpwt;
	private String pw;
	private char[] newpw;
	private JTable recenttable;
	private JTable etable;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard window = new StudentDashboard();
					window.frmStudentDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentDashboard() {
		c = new CardLayout();
		initialize();
	}
	
	public StudentDashboard(String email) {
		this.email = email;
		c = new CardLayout();
		ResultSet mainrs = s.showInformation(email);
		try {
			while(mainrs.next()) {
				this.name = mainrs.getString("std_name");
				this.course = mainrs.getString("std_course");
				this.level = mainrs.getString("std_level");
				this.id = mainrs.getString("std_id");
				this.semester = mainrs.getString("std_semester");
				this.phone = mainrs.getString("std_phone");
				this.opt1 = mainrs.getString("optmod1");
				this.opt2 = mainrs.getString("optmod2");
				System.out.println("Student info received!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet mainrs1 = s.userinfo(email);
		try {
			while(mainrs1.next()) {
				this.pw = mainrs1.getString("u_password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("Name is"+name);
		frmStudentDashboard = new JFrame();
		frmStudentDashboard.setTitle("Student - Dashboard");
		frmStudentDashboard.setIconImage(Toolkit.getDefaultToolkit().getImage(StudentDashboard.class.getResource("/com/icons/icons8-classroom-85.png")));
		frmStudentDashboard.setBounds(100, 100, 924, 433);
		frmStudentDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentDashboard.getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(null);
		headerPanel.setBackground(new Color(255, 255, 255));
		headerPanel.setBounds(679, 0, 231, 49);
		frmStudentDashboard.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		String date = s.getdate();
		JLabel dateHead = new JLabel(date);
		dateHead.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		dateHead.setBounds(61, 11, 119, 20);
		headerPanel.add(dateHead);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 102));
		panel_2.setBounds(0, 39, 231, 10);
		headerPanel.add(panel_2);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(158, 0, 522, 397);
		frmStudentDashboard.getContentPane().add(bodyPanel);
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
		coursesShowIcon.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/courses_1_35x35.png")));
		coursesShowIcon.setBounds(6, 52, 35, 35);
		coursesShow.add(coursesShowIcon);
		
		int nocourse = s.noCourses();
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
		tutorsIcon.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/teacher_35x35.png")));
		tutorsIcon.setBounds(4, 53, 35, 35);
		tutorsShow.add(tutorsIcon);
		
		int notut = s.noTutors();
		String tnum = String.valueOf(notut);
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
		studentIcon.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/school_boy_35x35.png")));
		studentIcon.setBounds(6, 53, 35, 35);
		studentsShow.add(studentIcon);
		
		int nostd = s.noStudents();
		String stdnum = String.valueOf(nostd);
		JLabel studentNum = new JLabel(stdnum);
		studentNum.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		studentNum.setBounds(51, 22, 49, 35);
		studentsShow.add(studentNum);
		
		JLabel studentLbl = new JLabel("Students");
		studentLbl.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		studentLbl.setBounds(51, 74, 49, 14);
		studentsShow.add(studentLbl);
		
		JPanel reviewShow = new JPanel();
		reviewShow.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		reviewShow.setBackground(new Color(255, 255, 255));
		reviewShow.setBounds(387, 11, 110, 96);
		homePanel.add(reviewShow);
		reviewShow.setLayout(null);
		
		JButton reviewBtn = new JButton("Give Review");
		reviewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GiveReview();
			}
		});
		reviewBtn.setBackground(new Color(255, 255, 255));
		reviewBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		reviewBtn.setBounds(7, 67, 97, 23);
		reviewShow.add(reviewBtn);
		
		JLabel reviewIcon = new JLabel("");
		reviewIcon.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-star-filled-30.png")));
		reviewIcon.setBounds(39, 22, 35, 32);
		reviewShow.add(reviewIcon);
		
		JLabel lblNewLabel_5 = new JLabel("Assignments:");
		lblNewLabel_5.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(21, 233, 260, 14);
		homePanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Check assignment/announcements in google classroom.");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = "https://www.classroom.google.com";
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
				    try {
				        desktop.browse(new URI(url));
				    } catch (IOException | URISyntaxException e1) {
				        e1.printStackTrace();
				    }
				}
			}
		});
		lblNewLabel_6.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblNewLabel_6.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-google-classroom-35.png")));
		lblNewLabel_6.setBounds(22, 133, 404, 35);
		homePanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_12 = new JLabel("Send a mail.");
		lblNewLabel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = "https://www.gmail.com";
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
				    try {
				        desktop.browse(new URI(url));
				    } catch (IOException | URISyntaxException e1) {
				        e1.printStackTrace();
				    }
				}
			}
		});
		lblNewLabel_12.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblNewLabel_12.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-gmail-logo-35.png")));
		lblNewLabel_12.setBounds(22, 179, 277, 43);
		homePanel.add(lblNewLabel_12);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 259, 474, 127);
		homePanel.add(scrollPane_1);
		
		recenttable = new JTable();
		scrollPane_1.setViewportView(recenttable);
		DefaultTableModel model = (DefaultTableModel) recenttable.getModel();
		
		JPanel coursesPanel = new JPanel();
		bodyPanel.add(coursesPanel, "name_163022190450400");
		coursesPanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 143, 500, 243);
		coursesPanel.add(scrollPane_2);
		
		coursetable = new JTable();
		scrollPane_2.setViewportView(coursetable);
		coursetable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		try {
			ResultSet rsrec = s.showhw();
			ResultSetMetaData rsmdrec = rsrec.getMetaData();
			DefaultTableModel modelr = (DefaultTableModel) recenttable.getModel();
			
			int col = rsmdrec.getColumnCount();
			String[] colName = new String[col];
			for(int i = 0; i<col; i++) {
				colName[i] = rsmdrec.getColumnName(i+1);
			}
			modelr.setColumnIdentifiers(colName);
			
			while (rsrec.next()) {
				String id = rsrec.getString("id");
				  String modules = rsrec.getString("module");
				  String details = rsrec.getString("details");
				  String dates = rsrec.getString("date");
				  modelr.addRow(new Object[]{id, modules, details, dates});
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		searchBar = new JTextField();
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = searchBar.getText();
				search(searchString);
			}
		});
		searchBar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		searchBar.setBounds(10, 118, 404, 20);
		coursesPanel.add(searchBar);
		searchBar.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(420, 116, 89, 21);
		coursesPanel.add(searchBtn);
		
		JButton showCoursesBtn = new JButton("Show Courses");
		showCoursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursetable.setModel(new DefaultTableModel());
				rs = s.showCourses();
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) coursetable.getModel();
					
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
		showCoursesBtn.setBounds(6, 61, 122, 32);
		coursesPanel.add(showCoursesBtn);
		
		JButton showModulesBtn = new JButton("Show Modules");
		showModulesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursetable.setModel(new DefaultTableModel());
				rs = s.showModules();
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) coursetable.getModel();
					
					int col = rsmd.getColumnCount();
					String[] colName = new String[col];
					for(int i = 0; i<col; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					String id, name, status, c_id, ins_name, sem, credits, type ;
					while(rs.next()) {
						while(rs.next()) {
						    model.addRow(new Object[]{rs.getString("m_id"), rs.getString("m_name"), 
						    rs.getInt("c_id"), rs.getString("ins_name"), rs.getString("m_status"), 
						    rs.getInt("m_semester"), rs.getInt("m_credits"), rs.getString("m_type")});
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		showModulesBtn.setBackground(Color.WHITE);
		showModulesBtn.setBounds(134, 61, 122, 32);
		coursesPanel.add(showModulesBtn);
		
		
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursetable.setModel(new DefaultTableModel());
			}
		});
		clearBtn.setBackground(Color.WHITE);
		clearBtn.setBounds(264, 61, 122, 32);
		coursesPanel.add(clearBtn);
		
		JLabel searchLbl = new JLabel("Search for a module/course:");
		searchLbl.setBounds(10, 101, 184, 14);
		coursesPanel.add(searchLbl);
		
		JLabel lblNewLabel_1 = new JLabel("Courses - Modules");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblNewLabel_1.setBounds(50, 15, 294, 39);
		coursesPanel.add(lblNewLabel_1);
		
		JButton btnYourModule = new JButton("View Grades");
		btnYourModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewResult(id);
			}
		});
		btnYourModule.setBackground(Color.WHITE);
		btnYourModule.setBounds(392, 62, 122, 32);
		coursesPanel.add(btnYourModule);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/courses_1_35x35.png")));
		lblNewLabel_14.setBounds(10, 3, 46, 48);
		coursesPanel.add(lblNewLabel_14);
		
		JButton btnYourModule_1 = new JButton("Choose Modules");
		btnYourModule_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(level.equals("6")) {
					new ChooseModuleLVL6(id);
				}else {
					JOptionPane.showMessageDialog(null, "Not eligible!");
				}
				
			}
		});
		btnYourModule_1.setBackground(Color.WHITE);
		btnYourModule_1.setBounds(392, 26, 122, 32);
		coursesPanel.add(btnYourModule_1);
		
		JPanel studentsPanel = new JPanel();
		bodyPanel.add(studentsPanel, "name_163023583797900");
		studentsPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 502, 290);
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
		searchStd.setBounds(10, 67, 366, 20);
		studentsPanel.add(searchStd);
		searchStd.setColumns(10);
		
		JButton stdsearchBtn = new JButton("Search");
		stdsearchBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		stdsearchBtn.setBackground(new Color(255, 255, 255));
		stdsearchBtn.setBounds(379, 66, 94, 23);
		studentsPanel.add(stdsearchBtn);
		
		JLabel stdLbl = new JLabel("Students");
		stdLbl.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		stdLbl.setBounds(10, 11, 228, 39);
		studentsPanel.add(stdLbl);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(248, 42, 49, 14);
		studentsPanel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-update-left-rotation-10.png")));
		btnNewButton.setBounds(477, 66, 34, 23);
		studentsPanel.add(btnNewButton);
		
		JLabel lblNewLabel_15 = new JLabel("Search classmates:");
		lblNewLabel_15.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_15.setBounds(10, 49, 352, 14);
		studentsPanel.add(lblNewLabel_15);
		
		JButton btnYourModule_1_1 = new JButton("Show Students");
		btnYourModule_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStudents.setModel(new DefaultTableModel());
				rs = s.showStudents();
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
		btnYourModule_1_1.setBackground(Color.WHITE);
		btnYourModule_1_1.setBounds(260, 23, 122, 32);
		studentsPanel.add(btnYourModule_1_1);
		
		JButton btnYourModule_1_2 = new JButton("Clear");
		btnYourModule_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStudents.setModel(new DefaultTableModel());
			}
		});
		btnYourModule_1_2.setBackground(Color.WHITE);
		btnYourModule_1_2.setBounds(389, 23, 122, 32);
		studentsPanel.add(btnYourModule_1_2);
		
		JPanel instructorsPanel = new JPanel();
		bodyPanel.add(instructorsPanel, "name_163025173866900");
		instructorsPanel.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 99, 502, 287);
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
		searchIns.setBounds(10, 71, 403, 20);
		instructorsPanel.add(searchIns);
		searchIns.setColumns(10);
		
		JButton searchInsBtn = new JButton("Search");
		searchInsBtn.setBackground(new Color(255, 255, 255));
		searchInsBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		searchInsBtn.setBounds(423, 70, 89, 23);
		instructorsPanel.add(searchInsBtn);
		
		JLabel insLbl = new JLabel("Instructors");
		insLbl.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		insLbl.setBounds(10, 6, 156, 39);
		instructorsPanel.add(insLbl);
		
		JLabel lblNewLabel_13 = new JLabel("Search for a instructor:");
		lblNewLabel_13.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_13.setBounds(12, 51, 378, 14);
		instructorsPanel.add(lblNewLabel_13);
		
		JButton btnNewButton_1 = new JButton("Review ");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReviewTutor();
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton_1.setBounds(417, 17, 95, 23);
		instructorsPanel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Show ");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIns.setModel(new DefaultTableModel());
				rs = s.showTutors();
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
		btnNewButton_1_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton_1_1.setBounds(220, 17, 95, 23);
		instructorsPanel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Clear");
		btnNewButton_1_2.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIns.setModel(new DefaultTableModel());
			}
		});
		btnNewButton_1_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnNewButton_1_2.setBounds(318, 17, 95, 23);
		instructorsPanel.add(btnNewButton_1_2);
		
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
		panel.setBounds(10, 44, 502, 119);
		settingsPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Personal Information:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 9, 129, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 34, 49, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Phone:");
		lblNewLabel_3_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(10, 68, 49, 14);
		panel.add(lblNewLabel_3_1);
		
		textField = new JTextField(phone);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(57, 65, 177, 20);
		panel.add(textField);
		
		textField_1 = new JTextField(name);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(57, 32, 177, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Course:");
		lblNewLabel_3_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(262, 34, 49, 14);
		panel.add(lblNewLabel_3_2);
		
		textField_2 = new JTextField(course);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(307, 31, 177, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField(email);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(307, 65, 177, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Email:");
		lblNewLabel_3_3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_3.setBounds(262, 68, 49, 14);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_10_1 = new JLabel("Contact SSD to change your details.");
		lblNewLabel_10_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_10_1.setBounds(10, 94, 382, 17);
		panel.add(lblNewLabel_10_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 170, 502, 129);
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
					newpw = newpwt.getPassword();
					String npw = new String(newpw);
					boolean validatePw = Pattern.matches("[a-zA-z]*[@&][0-9]*", npw);
					if(validatePw) {
						s.changePassword(id, email, npw);
					}else {
						invalidpwlbl.setVisible(true);
					}
				}else {
					wrongpwlbl.setVisible(true);
				}
				
			}
		});
		btnNewButton_2.setBounds(172, 95, 89, 23);
		panel_1.add(btnNewButton_2);
		
		oldpwt = new JPasswordField();
		oldpwt.setBounds(136, 32, 171, 21);
		panel_1.add(oldpwt);
		
		newpwt = new JPasswordField();
		newpwt.setBounds(137, 59, 171, 21);
		panel_1.add(newpwt);
		
		
		
		
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
		lblNewLabel_10.setBounds(10, 305, 382, 17);
		settingsPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Contact us:");
		lblNewLabel_11.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		lblNewLabel_11.setBounds(10, 333, 79, 14);
		settingsPanel.add(lblNewLabel_11);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(255, 153, 102));
		buttonsPanel.setBounds(0, 0, 157, 397);
		frmStudentDashboard.getContentPane().add(buttonsPanel);
		
		
		
		
		JButton homeBtn = new JButton("  Home");
		homeBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(bodyPanel, "name_163020295483500");
			}
		});
		homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		homeBtn.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-house-40.png")));
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
		coursesBtn.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/courses_1_35x35.png")));
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
		studentsBtn.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/school_boy_35x35.png")));
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
		instructorsBtn.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/teacher_35x35.png")));
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
		settingsBtn.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-settings-48_35x35.png")));
		settingsBtn.setBounds(10, 295, 137, 39);
		settingsBtn.setBackground(Color.WHITE);
		
		JButton logoutBtn = new JButton("  Log Out");
		logoutBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStudentDashboard.setVisible(false);
				new LoginPage();
				JOptionPane.showMessageDialog(null, "Logged out succesfully!");
			}
		});
		logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
		logoutBtn.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-logout-58_1_30x30.png")));
		logoutBtn.setBounds(10, 340, 137, 39);
		logoutBtn.setBackground(Color.WHITE);
		
		JLabel mainIcon = new JLabel("");
		mainIcon.setBounds(31, -2, 97, 85);
		mainIcon.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-cap-85.png")));
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
		remindersPanel.setBounds(679, 46, 231, 351);
		frmStudentDashboard.getContentPane().add(remindersPanel);
		remindersPanel.setLayout(null);
		
		JLabel reminderHead = new JLabel("Important!");
		reminderHead.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		reminderHead.setBounds(70, 20, 93, 19);
		remindersPanel.add(reminderHead);
		
		JLabel reminderIcon = new JLabel("");
		reminderIcon.setIcon(new ImageIcon(StudentDashboard.class.getResource("/com/icons/icons8-doorbell-48_20x20.png")));
		reminderIcon.setBounds(44, 14, 25, 32);
		remindersPanel.add(reminderIcon);
		
		JPanel reminder1 = new JPanel();
		reminder1.setBounds(10, 90, 211, 250);
		remindersPanel.add(reminder1);
		reminder1.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 11, 191, 228);
		reminder1.add(scrollPane_4);
		
		etable = new JTable();
		scrollPane_4.setViewportView(etable);
		
		try {
			ResultSet rsrec = s.showexam();
			ResultSetMetaData rsmdrec = rsrec.getMetaData();
			DefaultTableModel modelr = (DefaultTableModel) etable.getModel();
			
			int col = rsmdrec.getColumnCount();
			String[] colName = new String[col];
			for(int i = 0; i<col; i++) {
				colName[i] = rsmdrec.getColumnName(i+1);
			}
			modelr.setColumnIdentifiers(colName);
			
			while (rsrec.next()) {
				  String modules = rsrec.getString("module");
				  String room = rsrec.getString("room");
				  String datee = rsrec.getString("date");
				  modelr.addRow(new Object[]{modules, room, datee});
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_4 = new JLabel("Exams:");
		lblNewLabel_4.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		lblNewLabel_4.setBounds(81, 57, 93, 22);
		remindersPanel.add(lblNewLabel_4);
		frmStudentDashboard.setVisible(true);
	}
	
	public void search(String str) {
		DefaultTableModel model = (DefaultTableModel) coursetable.getModel();
		DefaultTableModel model1 = (DefaultTableModel) showStudents.getModel();
		DefaultTableModel model2 = (DefaultTableModel) showIns.getModel();
		
		
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<> ( model);

		TableRowSorter<DefaultTableModel> trs1 = new TableRowSorter<> ( model1);

		TableRowSorter<DefaultTableModel> trs2 = new TableRowSorter<> ( model2);
		coursetable.setRowSorter(trs);
		showStudents.setRowSorter(trs1);
		showIns.setRowSorter(trs2);
		trs.setRowFilter(RowFilter.regexFilter(str));
		trs1.setRowFilter(RowFilter.regexFilter(str));
		trs2.setRowFilter(RowFilter.regexFilter(str));
	}
}
