package com.databases;

import  java.sql.*;

import javax.swing.JOptionPane;
public class ConnectDB {
    static final String url = "jdbc:mysql://localhost";
    static final String urlDB = "jdbc:mysql://localhost/coursework";
    static final String username = "root";
    static final String password = "9880august7";
    static final String database = "coursework";
    
    public static Connection getDbConnection() {
        try{
            String Username = "root";
            String Password = "9880august7";
            String dbName = "coursework";
            String connectionString = "jdbc:mysql://localhost/"+dbName;
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(connectionString, Username,Password);
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Couldn't connect to the database! Please make sure that your database server is active.", "Connection Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
    
    public void createDB(){
        
        connectDB();
        studentTable();
        instructorTable();
        coursesTable();
        modulesTable();
        resultTable();
        userTable();
        reviewApp();
        reviewInstructor();
        reminders();
    }
    
    
    //checks connection
    

    
    //creates database
    public void connectDB(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement state = connection.createStatement();
            String createQuery = "CREATE DATABASE coursework";
            state.execute(createQuery);
            System.out.println("Database successfully created!!");
        } catch (SQLException createE) {
            System.out.println("Database Already Exists!");
        }
    }
    
    
    //returns connection to be used in other classes
    public static Connection con() {
    	try {
    		Connection connection = DriverManager.getConnection(urlDB, username, password);
    		return connection;
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, "Connection error!");
    	}
		return null;
    }
    
    
    //creates student table
    public void studentTable(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createStudentTableQuery = "CREATE TABLE students" +
                    "(std_id int AUTO_INCREMENT," +
                    "std_name varchar(20)," +
                    "std_course varchar(50)," +
                    "std_semester int(11)," +
                    "std_level int," +
                    "std_phone varchar(20)," +
                    "std_email varchar(50) UNIQUE,"+ 
                    "optmod1 varchar(50) DEFAULT 'not selected',"+
                    "optmod2 varchar(50) DEFAULT 'not selected'," +
                    "primary key(std_id));";
            state.executeUpdate(createStudentTableQuery);
            System.out.println("Student table created!");
        } catch (SQLException e) {
            System.out.println("Students error!" + e);
        }
    }

    
    //creates courses table
    public void coursesTable(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createCoursesTableQuery = "CREATE TABLE courses" +
                    "(c_id int AUTO_INCREMENT," +
                    "c_name varchar(100) UNIQUE," +
                    "c_status varchar(20)," +
                    "primary key(c_id));";
            state.executeUpdate(createCoursesTableQuery);
            System.out.println("Courses table created!");
        } catch (SQLException e) {
            System.out.println("Courses error!" + e);
        }
    }
    
    
    //instructor table
    public void instructorTable(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createInstructorTableQuery = "CREATE TABLE instructors" +
                    "(ins_id int AUTO_INCREMENT," +
                    "ins_name varchar(30)," +
                    "ins_phone varchar(20)," +
                    "mod1 varchar(50)," +
                    "mod2 varchar(50),"+
                    "ins_email varchar(50) UNIQUE," +
                    "primary key(ins_id));";
            state.executeUpdate(createInstructorTableQuery);
            System.out.println("Instructor table created!");
        } catch (SQLException e) {
            System.out.println("Instructor error!" + e);
        }
    }
    
    
    //modules table
    public void modulesTable(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createModulesTableQuery = "CREATE TABLE modules" +
                    "(m_id varchar(50)," +
                    "m_name varchar(200) UNIQUE," +
                    "c_id int," +
                    "ins_name varchar(50)," +
                    "m_status varchar(20)," +
                    "m_semester int," +
                    "m_credits int," +
                    "m_type varchar(20),"+
                    "FOREIGN KEY(c_id) REFERENCES courses (c_id)," +
                    "PRIMARY KEY(m_id));";
            state.executeUpdate(createModulesTableQuery);
            System.out.println("Modules table created!");
        } catch (SQLException e) {
            System.out.println("Modules error!" + e);
        }
    }
    
    
    //
    public void resultTable(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createResultTableQuery = "CREATE TABLE result" +
                    "(std_id int," +
                    "m_id varchar(50)," +
                    "marks int," +
                    "remarks varchar(20),"+
                    "FOREIGN KEY(m_id) REFERENCES modules(m_id),"+
                    "FOREIGN KEY(std_id) REFERENCES students(std_id));";
            state.executeUpdate(createResultTableQuery);
            System.out.println("Result table created!");
        } catch (SQLException e) {
            System.out.println("Result error!" + e);
        }
    }

    public void reviewInstructor(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createReviewInstructorQuery = "CREATE TABLE reviewInstructor" +
                    "(ins_id int," +
                    "rating int,"
                    + "remark varchar(20)," +
                    "FOREIGN KEY(ins_id) REFERENCES instructors(ins_id));";
            state.executeUpdate(createReviewInstructorQuery);
            System.out.println("Review Ins table created!");
        } catch (SQLException e) {
            System.out.println("review Ins error!" + e);
        }
    }

    public void reviewApp(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createReviewAppQuery = "CREATE TABLE reviewApp" +
                    "(remark varchar(20)," +
                    "rating int);";
                    
            state.executeUpdate(createReviewAppQuery);
            System.out.println("ReviewApp table created!");
        } catch (SQLException e) {
            System.out.println("reviewApp error!" + e);
        }
    }

    public void userTable(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createReviewTableQuery = "CREATE TABLE users" +
                    "(u_id int AUTO_INCREMENT," +
                    "u_email varchar(50) UNIQUE," +
                    "u_password varchar(20)," +
                    "u_type varchar(20)," +
                    "PRIMARY KEY (u_id));";
            state.executeUpdate(createReviewTableQuery);
            System.out.println("User table created!");
        } catch (SQLException e) {
            System.out.println("User error!" + e);
        }
    }

    public void reminders(){
        try {
            Connection connection = DriverManager.getConnection(urlDB, username, password);
            Statement state = connection.createStatement();
            String createReviewTableQuery = "CREATE TABLE reminders" +
                    "(remind_type varchar(20)," +
                    "remind_module varchar(20)," +
                    "remind_where varchar(50));" ;
            state.executeUpdate(createReviewTableQuery);
            System.out.println("Reminder table created!");
        } catch (SQLException e) {
            System.out.println("Reminder error!" + e);
        }
    }

    public static void main(String[] args) {
        ConnectDB c = new ConnectDB();
        c.createDB();
    }
}

