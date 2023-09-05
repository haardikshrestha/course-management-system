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

import com.UsersList.Instructors;
import com.UsersList.Students;
import com.instructorFunctions.AddMarks;
import com.instructorFunctions.giveAppReview;
import java.sql.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class InstructorDashboard {

	private JFrame frmInstructorDashboard;
	CardLayout c;
	private JTable showTable;
	private JTextField searchBar;
	private JTable recentTable;
	private JTable showStudents;
	private JTextField searchStd;
	private JTable showIns;
	private JTextField searchIns;
	private JTextField textField;
	private JTextField namet;
	private JTextField textField_2;
	private JTextField textField_3;
	Instructors i = new Instructors();
	ResultSet rs;
	ResultSetMetaData rsmd;
	private String id;
	private String name;
	private String phone;
	private String email;
	private String mid1;
	private String mid2;
	private String course;
	private String pw;
	private JPasswordField oldpwt;
	private JTextField newpwt;
	private JTextField hwt;
	private JTextField datet;
	private JTextField det;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorDashboard window = new InstructorDashboard();
					window.frmInstructorDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InstructorDashboard() {
		c = new CardLayout();
		initialize();
	}
	
	public InstructorDashboard(String email) {
		this.email = email;
		ResultSet mainrs = i.showinfo(email);
		try {
			while(mainrs.next()) {
				this.name = mainrs.getString("ins_name");
				this.id = mainrs.getString("ins_id");
				this.phone = mainrs.getString("ins_phone");
				this.mid1 = mainrs.getString("mod1");
				this.mid2 = mainrs.getString("mod2");
				this.course = mainrs.getString("course");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		c = new CardLayout();
		ResultSet mainrs1 = i.userinfo(email);
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
		frmInstructorDashboard = new JFrame();
		frmInstructorDashboard.setTitle("Instructor - Dashboard");
		frmInstructorDashboard.setIconImage(Toolkit.getDefaultToolkit().getImage(InstructorDashboard.class.getResource("/com/icons/icons8-classroom-85.png")));
		frmInstructorDashboard.setBounds(100, 100, 850, 433);
		frmInstructorDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInstructorDashboard.getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(null);
		headerPanel.setBackground(new Color(255, 255, 255));
		headerPanel.setBounds(679, 0, 157, 49);
		frmInstructorDashboard.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		String dater = i.getdate();
		JLabel dateHead = new JLabel(dater);
		dateHead.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		dateHead.setBounds(19, 11, 119, 20);
		headerPanel.add(dateHead);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 102));
		panel_2.setBounds(0, 39, 231, 10);
		headerPanel.add(panel_2);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(158, 0, 522, 397);
		frmInstructorDashboard.getContentPane().add(bodyPanel);
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
		coursesShowIcon.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/courses_1_35x35.png")));
		coursesShowIcon.setBounds(6, 52, 35, 35);
		coursesShow.add(coursesShowIcon);
		
		int nocourse = i.noCourses();
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
		tutorsIcon.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/teacher_35x35.png")));
		tutorsIcon.setBounds(4, 53, 35, 35);
		tutorsShow.add(tutorsIcon);
		
		int notut = i.noTutors();
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
		studentIcon.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/school_boy_35x35.png")));
		studentIcon.setBounds(6, 53, 35, 35);
		studentsShow.add(studentIcon);
		
		
		int nostd = i.noStudents();
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
				new giveAppReview();
			}
		});
		reviewBtn.setBackground(new Color(255, 255, 255));
		reviewBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 10));
		reviewBtn.setBounds(7, 67, 97, 23);
		reviewShow.add(reviewBtn);
		
		JLabel reviewIcon = new JLabel("");
		reviewIcon.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-star-filled-30.png")));
		reviewIcon.setBounds(38, 22, 35, 32);
		reviewShow.add(reviewIcon);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 252, 479, 129);
		homePanel.add(scrollPane_1);
		
		recentTable = new JTable();
		scrollPane_1.setViewportView(recentTable);
		
		try {
			ResultSet rsrec = i.showhw();
			ResultSetMetaData rsmdrec = rsrec.getMetaData();
			DefaultTableModel modelr = (DefaultTableModel) recentTable.getModel();
			
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
				  String date = rsrec.getString("date");
				  modelr.addRow(new Object[]{id, modules, details, date});
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_5 = new JLabel("Assignments:");
		lblNewLabel_5.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(21, 233, 260, 14);
		homePanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Post assignment/announcements in google classroom.");
		lblNewLabel_6.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblNewLabel_6.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-google-classroom-35.png")));
		lblNewLabel_6.setBounds(22, 133, 382, 35);
		homePanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_12 = new JLabel("Send a mail.");
		lblNewLabel_12.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblNewLabel_12.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-gmail-logo-35.png")));
		lblNewLabel_12.setBounds(22, 179, 277, 43);
		homePanel.add(lblNewLabel_12);
		
		JPanel coursesPanel = new JPanel();
		bodyPanel.add(coursesPanel, "name_163022190450400");
		coursesPanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 143, 500, 243);
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
		searchBar.setBounds(10, 118, 403, 20);
		coursesPanel.add(searchBar);
		searchBar.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(423, 119, 89, 21);
		coursesPanel.add(searchBtn);
		
		JButton showCoursesBtn = new JButton("Show Courses");
		showCoursesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs;
				rs = i.showCourses(course);
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
		showCoursesBtn.setBounds(6, 61, 122, 32);
		coursesPanel.add(showCoursesBtn);
		
		JButton showModulesBtn = new JButton("Show Modules");
		showModulesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = i.showModules();
				try {
					rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) showTable.getModel();
					
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
				showTable.setModel(new DefaultTableModel());
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
		lblNewLabel_1.setBounds(10, 11, 380, 39);
		coursesPanel.add(lblNewLabel_1);
		
		JButton btnYourModule = new JButton("Your Module");
		btnYourModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(mid1);
				rs = i.yourModules(mid1, mid2);
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
		btnYourModule.setBackground(Color.WHITE);
		btnYourModule.setBounds(392, 62, 122, 32);
		coursesPanel.add(btnYourModule);
		
		JPanel studentsPanel = new JPanel();
		bodyPanel.add(studentsPanel, "name_163023583797900");
		studentsPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 502, 293);
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
		searchStd.setBounds(10, 65, 366, 20);
		studentsPanel.add(searchStd);
		searchStd.setColumns(10);
		
		JButton stdsearchBtn = new JButton("Search");
		stdsearchBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		stdsearchBtn.setBackground(new Color(255, 255, 255));
		stdsearchBtn.setBounds(379, 64, 94, 23);
		studentsPanel.add(stdsearchBtn);
		
		JLabel stdLbl = new JLabel("Students");
		stdLbl.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		stdLbl.setBounds(10, 11, 126, 39);
		studentsPanel.add(stdLbl);
		
		JButton addstdBtn = new JButton("Add Marks");
		addstdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddMarks();
			}
		});
		addstdBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		addstdBtn.setBackground(Color.WHITE);
		addstdBtn.setBounds(400, 11, 112, 32);
		studentsPanel.add(addstdBtn);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(248, 42, 49, 14);
		studentsPanel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-update-left-rotation-10.png")));
		btnNewButton.setBounds(477, 64, 34, 23);
		studentsPanel.add(btnNewButton);
		
		JLabel lblNewLabel_14 = new JLabel("Search for a student using their id:");
		lblNewLabel_14.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_14.setBounds(10, 42, 257, 20);
		studentsPanel.add(lblNewLabel_14);
		
		JButton btnShowStudents = new JButton("Show Students");
		btnShowStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = i.showStudents();
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
		btnShowStudents.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnShowStudents.setBackground(Color.WHITE);
		btnShowStudents.setBounds(200, 11, 127, 32);
		studentsPanel.add(btnShowStudents);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStudents.setModel(new DefaultTableModel());
			}
		});
		btnClear.setHorizontalAlignment(SwingConstants.LEFT);
		btnClear.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(331, 11, 65, 32);
		studentsPanel.add(btnClear);
		
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
		searchInsBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		searchInsBtn.setBounds(423, 70, 89, 23);
		instructorsPanel.add(searchInsBtn);
		
		JLabel insLbl = new JLabel("Instructors");
		insLbl.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		insLbl.setBounds(10, 6, 235, 39);
		instructorsPanel.add(insLbl);
		
		JLabel lblNewLabel_13 = new JLabel("Search for a instructor:");
		lblNewLabel_13.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		lblNewLabel_13.setBounds(12, 51, 378, 14);
		instructorsPanel.add(lblNewLabel_13);
		
		JButton btnShowTutors = new JButton("Show Tutors");
		btnShowTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = i.showTutors();
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
		btnShowTutors.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnShowTutors.setBackground(Color.WHITE);
		btnShowTutors.setBounds(263, 12, 127, 32);
		instructorsPanel.add(btnShowTutors);
		
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIns.setModel(new DefaultTableModel());
			}
		});
		btnClear_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		btnClear_1.setBackground(Color.WHITE);
		btnClear_1.setBounds(395, 12, 117, 32);
		instructorsPanel.add(btnClear_1);
		
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
		panel.setBounds(10, 51, 502, 97);
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
		
		JLabel lblNewLabel_3_1 = new JLabel("Email");
		lblNewLabel_3_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(10, 68, 49, 14);
		panel.add(lblNewLabel_3_1);
		
		textField = new JTextField(email);
		textField.setColumns(10);
		textField.setBounds(57, 65, 177, 20);
		panel.add(textField);
		
		namet = new JTextField(name);
		namet.setColumns(10);
		namet.setBounds(57, 32, 177, 20);
		panel.add(namet);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mod1:");
		lblNewLabel_3_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(262, 34, 49, 14);
		panel.add(lblNewLabel_3_2);
		
		textField_2 = new JTextField(mid1);
		textField_2.setColumns(10);
		textField_2.setBounds(307, 31, 177, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField(mid2);
		textField_3.setColumns(10);
		textField_3.setBounds(307, 65, 177, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Mod2:");
		lblNewLabel_3_3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_3_3.setBounds(262, 68, 49, 14);
		panel.add(lblNewLabel_3_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 156, 502, 121);
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
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] oldpwtarr = oldpwt.getPassword();
				String oldpw = new String(oldpwtarr);
				if(oldpw.equals(pw)) {
					String newpw = newpwt.getText();
					String npw = new String(newpw);
					boolean validatePw = Pattern.matches("[a-zA-z]*[@&][0-9]*", npw);
					if(validatePw) {
						i.changePassword(id, email, npw);
					}else {
						invalidpwlbl.setVisible(true);
					}
				}else {
					wrongpwlbl.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(137, 91, 89, 23);
		panel_1.add(btnNewButton_1);
		
		oldpwt = new JPasswordField();
		oldpwt.setBounds(137, 34, 151, 23);
		panel_1.add(oldpwt);
		
		newpwt = new JTextField();
		newpwt.setBounds(137, 62, 151, 20);
		panel_1.add(newpwt);
		newpwt.setColumns(10);
		
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
		lblNewLabel_10.setBounds(10, 303, 382, 14);
		settingsPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Contact us:");
		lblNewLabel_11.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		lblNewLabel_11.setBounds(10, 333, 79, 14);
		settingsPanel.add(lblNewLabel_11);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(255, 153, 102));
		buttonsPanel.setBounds(0, 0, 157, 397);
		frmInstructorDashboard.getContentPane().add(buttonsPanel);
		
		
		
		
		JButton homeBtn = new JButton("  Home");
		homeBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(bodyPanel, "name_163020295483500");
			}
		});
		homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		homeBtn.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-house-40.png")));
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
		coursesBtn.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/courses_1_35x35.png")));
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
		studentsBtn.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/school_boy_35x35.png")));
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
		instructorsBtn.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/teacher_35x35.png")));
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
		settingsBtn.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-settings-48_35x35.png")));
		settingsBtn.setBounds(10, 295, 137, 39);
		settingsBtn.setBackground(Color.WHITE);
		
		JButton logoutBtn = new JButton("  Log Out");
		logoutBtn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInstructorDashboard.setVisible(false);
				new LoginPage();
				JOptionPane.showMessageDialog(null, "Logged out succesfully!");
			}
		});
		logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
		logoutBtn.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-logout-58_1_30x30.png")));
		logoutBtn.setBounds(10, 340, 137, 39);
		logoutBtn.setBackground(Color.WHITE);
		
		JLabel mainIcon = new JLabel("");
		mainIcon.setBounds(31, -2, 97, 85);
		mainIcon.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-cap-85.png")));
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
		frmInstructorDashboard.getContentPane().add(remindersPanel);
		remindersPanel.setLayout(null);
		
		JLabel reminderHead = new JLabel("Reminders:");
		reminderHead.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		reminderHead.setBounds(48, 10, 93, 19);
		remindersPanel.add(reminderHead);
		
		JLabel reminderIcon = new JLabel("");
		reminderIcon.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/com/icons/icons8-doorbell-48_20x20.png")));
		reminderIcon.setBounds(22, 4, 25, 32);
		remindersPanel.add(reminderIcon);
		
		JPanel reminder1 = new JPanel();
		reminder1.setBounds(10, 49, 137, 291);
		remindersPanel.add(reminder1);
		reminder1.setLayout(null);
		
		hwt = new JTextField();
		hwt.setBounds(10, 64, 117, 23);
		reminder1.add(hwt);
		hwt.setColumns(10);
		
		datet = new JTextField();
		datet.setColumns(10);
		datet.setBounds(11, 118, 117, 23);
		reminder1.add(datet);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String module = hwt.getText();
				String date = datet.getText();
				String detail = det.getText();
				i.addHw(module, date, detail);
			}
		});
		btnNewButton_2.setBounds(40, 241, 51, 23);
		reminder1.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Assignments:");
		lblNewLabel_4.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 11, 103, 23);
		reminder1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_15 = new JLabel("Module:");
		lblNewLabel_15.setBounds(10, 45, 49, 14);
		reminder1.add(lblNewLabel_15);
		
		
		
		JLabel lblNewLabel_15_1 = new JLabel("Date:");
		lblNewLabel_15_1.setBounds(11, 99, 49, 14);
		reminder1.add(lblNewLabel_15_1);
		
		JLabel detialsbll = new JLabel("Details:");
		detialsbll.setBounds(10, 158, 49, 14);
		reminder1.add(detialsbll);
		
		det = new JTextField();
		det.setColumns(10);
		det.setBounds(10, 177, 117, 23);
		reminder1.add(det);
		frmInstructorDashboard.setVisible(true);
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


