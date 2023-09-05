package com.UsersList;


import javax.swing.*;
import java.sql.*;

public class Instructors extends Users{
    String url = super.getUrl();
    String username = super.getUsername();
    String password = super.getPassword();
    
    public int noStudents() {
    	return super.noStudents();
    }
    
    public int noTutors() {
		return super.noTutors();
    }
    
    public int noCourses() {
    	return super.noCourses();
    }
    
    public ResultSet showinfo(String email) {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM instructors WHERE ins_email = '" +email+"';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Student info Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving result!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  void reviewapp(String remark, String rating){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO reviewapp() VALUES(?,?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, remark);
            ps.setString(2, rating);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reviewed!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Reviewing!");
        }
    }

    public  ResultSet showCourses(String course){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM courses WHERE c_status = 'Ongoing' ;";
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

    public  ResultSet yourModules(String id1, String id2){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            
            String query = "SELECT * FROM modules WHERE m_status = 'Ongoing' AND (m_id = '" + id1 + "' OR m_id = '" + id2 + "');";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("your modules Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving modules!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public  ResultSet showModules(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM modules WHERE m_status = 'Ongoing';";
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
    
    public ResultSet showStudents(String course) {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM students WHERE std_course = '"+course+"';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Students Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving students!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet showhw() {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM hw;";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            System.out.println("Student info Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving result!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addHw(String module, String date, String detail) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO hw(module, date, details) VALUES(?,?,?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, module);
            ps.setString(2, date);
            ps.setString(3, detail);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "hw saved!!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error hw!");
            System.out.println(e);
        }
    }
    
    public  void changePassword(String id, String email, String pw) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "UPDATE users SET u_password = '"+pw+"' WHERE u_email = '"+email+"';";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.executeUpdate(queryString);
            JOptionPane.showMessageDialog(null, "Password changed!");
            System.out.println("pw changed");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public ResultSet showTutors() {
    	return super.showTutors();
    }

    public  void giveMarks(String std_id, String m_id, String marks, String remarks){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO result() VALUES(?,?,?,?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, std_id);
            ps.setString(2, m_id);
            ps.setString(3, marks);
            ps.setString(4, remarks);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marks saved!!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Marks!");
        }
    }
    
    public ResultSet showrecents() {
    	return super.showRecents();
    }
    
    public  void changeModule(int id, String module, String select) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "UPDATE instructors SET "+select+" = '"+module+"' WHERE ins_id = "+id+";";
            Statement state =  connection.prepareStatement(queryString);
            state.executeQuery(queryString);
            System.out.println("module changed");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error changing modules!");
        }
    }

    public void addNewTutors(String name, String phone, String mod1, String mod2,String email, String course){
        super.addTutors(name, phone, mod1, mod2, email, course);
    }
    
    
}
