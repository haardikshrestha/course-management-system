package com.UsersList;

import javax.swing.*;
import java.sql.*;

public class Admins extends Users{
    String url = super.getUrl();
    String username = super.getUsername();
    String password = super.getPassword();
    
    public void changepw(String email, String newpw) {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "UPDATE users SET u_password = '"+newpw+"' WHERE u_email = '"+email+"';";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.executeUpdate(queryString);
            JOptionPane.showMessageDialog(null, "Password changed!");
            System.out.println("pw changed");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public int noReviews(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "SELECT COUNT(*) FROM reviewapp;";
            PreparedStatement state =  connection.prepareStatement(queryString);
            ResultSet rs = state.executeQuery(queryString);
            while (rs.next()) {
                int count = rs.getInt(1);
                return count;
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    
    public ResultSet showStudents() {
    	return super.showStudents();
    }
    
    public ResultSet showTutors() {
    	return super.showTutors();
    }
    
    public  ResultSet showCourses(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM courses;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Courses Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving courses!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public  ResultSet showModules(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM modules;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Modules Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving modules!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void addNewStudents(String name, String course, String sem, String level, String phone, String email){
        super.addStudents(name, course, sem, level, phone, email);
    }

    public void addNewTutors(String name, String phone, String mod1, String mod2,String email, String course){
        super.addTutors(name, phone, mod1, mod2, email, course);
    }

    public void addModules(String mid, String name, String c_id, String ins_name,String status, String sem, String credits, String type){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO modules(m_id, m_name, c_id, ins_name, m_status, m_semester, m_credits, m_type) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?,?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, mid);
            ps.setString(2, name);
            ps.setString(3, c_id);
            ps.setString(4, ins_name);
            ps.setString(5, status);
            ps.setString(6, sem);
            ps.setString(7, credits);
            ps.setString(8, type);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "new module set!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error new module!");
            System.out.println(e);
        }
    }
    
    public ResultSet courseNames(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT c_name FROM courses;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Reviews Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving reviews!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet showReviews(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM reviewapp;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Reviews Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving reviews!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  void addReminder(String module, String room, String date){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = " INSERT INTO exams (module, room, date) VALUES (?,?,?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, module);
            ps.setString(2, room);
            ps.setString(3, date);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reminder set!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error reminding!");
            System.out.println(e);
        }
    }

    public  void addCourses(String name){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO courses(c_name) VALUES(?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course set!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error setting course!");
        }
    }

    public void cancelCourse(int data) {
        cancel("courses", "c_status", "c_id", data);
    }

    public void cancelModule(String data){
        cancel("modules", "m_status", "m_id", data);
    }

    public void deleteStudent(int data){
        deletes("students", "std_id", data);
    }

    public void deleteInstructor(int data){
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
      
            String deleteModulesQuery = "DELETE FROM instructors WHERE ins_id = " + data + ";";
       

            PreparedStatement ps = con.prepareStatement(deleteModulesQuery);
           
            ps.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Deleted!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "delete error");
            System.out.println(e);
        }
    }
    
    public int noStudents() {
    	return super.noStudents();
    }
    
    public int noTutors() {
		return super.noTutors();
    }
    
    public int noCourses() {
    	return super.noCourses();
    }


    public void deleteModule(String data){
        delete("modules", "m_id", data);
    }

    public void editStudents(int data, String data1, String column){
        edit("students", column, "std_id", data, data1);
    }

    public void editInstructors(int data, String data1, String column){
        edit("instructors", column, "ins_id", data, data1);
    }

    public void editCourses(int data, String data1, String column){
        edit("courses", column, "c_id", data, data1);
    }

    public void editModules(String data, String data1, String column){
        edit("modules", column, "m_id", data, data1);
    }

	public void deleteCourse(int data) {
		delete("courses", "c_id", data);
	}

    public void createPromoteTable(){
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO promote (std_id, m_id, result) " + 
                    "SELECT std_id, m_id, " + 
                    "CASE " + 
                        "WHEN marks >= 40 THEN 'pass' " + 
                        "ELSE 'fail' " + 
                    "END AS result " + 
                    "FROM result;";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.executeUpdate();
            System.out.println("Final Results!");
            JOptionPane.showMessageDialog(null, "Created!");
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error final result!");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
   
}
