package com.UsersList;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Users{

    private static String url = "jdbc:mysql://localhost/coursework";
    private static String username = "root";
    private static String password = "9880august7";
    
    public void saveRecents(String email) {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "INSERT INTO recents(activity, time_info) VALUES (?, NOW());";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.setString(1, email+ "logged in");
            state.executeUpdate();
            System.out.println("reccents Inserted");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public  ResultSet userinfo(String email){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM users WHERE u_email = '" +email+"';";
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
    
    public ResultSet login(String email) {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM users WHERE u_email ='"+email+"';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("info Received!");
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving info!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return null;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getdate() {
    	try {
    	      Class.forName("com.mysql.jdbc.Driver");
    	      Connection conn = DriverManager.getConnection(url,username,password);    	      
    	      Statement stmt = conn.createStatement();
    	      ResultSet rs = stmt.executeQuery("SELECT CURRENT_DATE();");
    	      if (rs.next()) {
    	        java.sql.Date sqlDate = rs.getDate(1);
    	        Date utilDate = new Date(sqlDate.getTime());

    	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	        String dateString = dateFormat.format(utilDate);
    	        return dateString;
    	      }
    	      conn.close();
    	    } catch (Exception e) {
    	      e.printStackTrace();
    	    }
		return null;
    }
    
    public static ResultSet showRecents() {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM recents;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.isBeforeFirst()) {
            	System.out.println("Empty recents");
            }
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving recents!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return null;
    }
    
    public static void newuser(String email, String password, String type){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "INSERT INTO users(u_email, u_password, u_type) VALUES (?,?,?);";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.setString(1, email);
            state.setString(2, password);
            state.setString(3, type);
            state.executeUpdate();
            System.out.println("New use data Inserted");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void addStudents(String name, String course, String sem, String level, String phone, String email){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO students(std_name, std_course, std_semester, std_level, std_phone, std_email) " +
                    "VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, sem);
            ps.setString(4, level);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "new student set!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error new student!");
        }
    }

    public void addTutors(String name, String phone, String mod1, String mod2,String email, String course){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO instructors(ins_name, ins_phone, mod1, mod2, ins_email, course) " +
                    "VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, mod1);
            ps.setString(4, mod2);
            ps.setString(5, email);
            ps.setString(6, course);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "new instructor set!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error new instructor!");
        }
    }

    public static void cancel(String table, String column, String condition, String data) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "UPDATE "+table+" SET "+column+" = 'Cancelled' WHERE "+condition+" = '"+data+"';";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.executeUpdate(queryString);
            JOptionPane.showMessageDialog(null, "Cancelled!");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
        	JOptionPane.showMessageDialog(null, "Error Cancelling!");
        	System.out.println(e);
        }
    }

    public static void cancel(String table, String column, String condition, int data) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "UPDATE "+table+" SET "+column+" = 'Cancelled' WHERE "+condition+" = "+data+";";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.executeUpdate(queryString);
            JOptionPane.showMessageDialog(null, "Cancelled!");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
        	JOptionPane.showMessageDialog(null, "Error Cancelling!");
            System.out.println(e);
        }
    }

    public static void delete(String table, String condition, int data){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
      
            String deleteModulesQuery = "DELETE FROM modules WHERE c_id = '" + data + "';";
            String deleteCoursesQuery = "DELETE FROM courses WHERE c_id = '" + data + "';";

            PreparedStatement ps = con.prepareStatement(deleteModulesQuery);
            PreparedStatement ps1 = con.prepareStatement(deleteCoursesQuery);
            ps.executeUpdate();
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "delete error");
            System.out.println(e);
        }
    }
    
    public static void deletes(String table, String condition, int data){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
      
            String result = "DELETE FROM result WHERE std_id = '" + data + "';";
            String students = "DELETE FROM students WHERE std_id = '" + data + "';";

            PreparedStatement ps = con.prepareStatement(result);
            PreparedStatement ps1 = con.prepareStatement(students);
            ps.executeUpdate();
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted!");
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "delete error");
            System.out.println(e);
        }
    }

    public static void delete(String table, String condition, String data){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "DELETE FROM " + table + " WHERE " + condition + " = '" + data +"';";
            PreparedStatement ps = con.prepareStatement(query);
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

    public static void edit(String table, String column, String condition, int data, String data1) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "UPDATE "+table+" SET "+column+" = '"+ data1 +"' WHERE "+condition+" = "+data+";";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.executeUpdate(queryString);
            JOptionPane.showMessageDialog(null, "Updated!");
            System.out.println("changed");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
        	JOptionPane.showMessageDialog(null, "Error changing !");
            System.out.println("Error changing !");
        }
    }

    public static void edit(String table, String column, String condition, String data, String data1) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);

            String queryString = "UPDATE "+table+" SET "+column+" = '"+ data1 +"' WHERE "+condition+" = '"+data+"';";
            PreparedStatement state =  connection.prepareStatement(queryString);
            state.executeUpdate(queryString);
            JOptionPane.showMessageDialog(null, "Updated!");
            System.out.println("changed");
            connection.close();
        }catch (ClassNotFoundException | SQLException e) {
        	JOptionPane.showMessageDialog(null, "Error changing !");
            System.out.println("Error changing !" + e);
        }
    }
    
    public ResultSet showTutors(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM instructors;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error receiving tutors!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet showStudents(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * FROM students;";
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
    
    public int noCourses(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "SELECT COUNT(*) FROM courses;";
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
    
    public int noTutors(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "SELECT COUNT(*) FROM instructors;";
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

    public int noStudents(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            String queryString = "SELECT COUNT(*) FROM students;";
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
}
