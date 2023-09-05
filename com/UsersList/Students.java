package com.UsersList;

import javax.swing.*;

import com.Exceptions.DetailsNotFoundException;

import java.sql.*;

public class Students extends Users{
    String url = super.getUrl();
    String username = super.getUsername();
    String password = super.getPassword();
    
    public void addNewStudents(String name, String course, String sem, String level, String phone, String email){
        super.addStudents(name, course, sem, level, phone, email);
    }
    public  void reviewapp(String remark, String rating){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO reviewapp() VALUES(?,?)";
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

    //rs will be passes to viewResults class
    public  ResultSet viewresult(int std_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM result WHERE std_id = "+ std_id +";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Result Received!");
            if(rs.isBeforeFirst()) {
            	throw new DetailsNotFoundException();
            }
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving result!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DetailsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    public  void reviewInstructor(String text, String remark, String rate) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "INSERT INTO reviewinstructor(ins_id, rating, remark) VALUES (?,?,?)";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.setString(1, text);
            state.setString(2, rate);
            state.setString(3, remark);
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reviewed!");
            System.out.println("Data Inserted");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public  ResultSet showCourses(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM courses WHERE c_status = 'Ongoing';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Courses Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving result!");
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
            JOptionPane.showMessageDialog(null, "Error receiving result!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet showStudents() {
    	return super.showStudents();
    }
    
    public ResultSet showTutors() {
    	return super.showTutors();
    }
    
    public ResultSet showrecents() {
    	return super.showRecents();
    }
    
    public ResultSet userinfo(String email) {
    	return super.userinfo(email);
    }

    public  void chooseModules(String id, String opt1, String opt2) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "UPDATE students SET optmod1 = ?, optmod2 = ? WHERE std_id = ?;";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.setString(1, opt1);
            state.setString(2, opt2);
            state.setString(3, id);
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
            System.out.println("op module Inserted");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
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
    
    public ResultSet showexam() {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM exams;";
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
    
    public  ResultSet showInformation(String email){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM students WHERE std_email = '" +email+"';";
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

    public  ResultSet showReminders(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM reminders;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Reminders Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error getting reminders!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNewStudent(String name, String course, String sem, String level, String phone, String email){
        super.addStudents(name, course, sem, level, phone, email);
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
    
    public void checkEligible(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            
            String query = "SELECT result FROM promote where std_id = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String condition = rs.getString("result");
                if(condition.equals("pass")) {
                    String getstd = "SELECT * FROM students where std_id = ?";
                    PreparedStatement st1 = con.prepareStatement(getstd);
                    st1.setString(1, id);
                    ResultSet rs1 = st1.executeQuery();
                    if (rs1.next()) {
                        String levels = rs1.getString("std_level");
                        int level = Integer.parseInt(levels);
                        level = level + 1;
                        String newlvl = String.valueOf(level);
                        System.out.println("You have passed!");
                        String passquery = "UPDATE students SET std_level = ? WHERE std_id = ?";
                        PreparedStatement st2 = con.prepareStatement(passquery);
                        st2.setInt(1, level);
                        st2.setString(2, id);
                        st2.executeUpdate();
                        System.out.println("You have passed!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No result found!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error getting result!");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }

}
