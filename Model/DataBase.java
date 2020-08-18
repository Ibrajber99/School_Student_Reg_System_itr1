/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * ALL The Data base connection types
 * all operations of updates,insert, delete and select
 * are here
 */
public class DataBase {

    private boolean flagSuccess = true;

    public boolean connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=javaApp;user=IBRAHIM;password=12345";
            Connection con = DriverManager.getConnection(url);
            String sql = "Select * From javaLogin where username =? and password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            flagSuccess = false;
            System.out.println(e);
            return flagSuccess;
        }
        return flagSuccess;
    }

    public boolean login(String userName, String passWord) {
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "Select * From ADMINSTRATORS where UserName =? and PassWord=?";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            pst.setString(1, userName);//setting the values where there is ? in the query 
            pst.setString(2, passWord);//setting the values where there is ? in the query 
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                JOptionPane.showMessageDialog(null, "Username and Password matched");
                return true;
            } else {//if the data is not macthing it will return false 
                JOptionPane.showMessageDialog(null, "Username or password are not correct");
                flagSuccess = false;
            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);
            flagSuccess = false;
            System.out.println(e);
            return flagSuccess;

        }
        return flagSuccess;//return result
    }

    public boolean retrieveStudentInfo(JTable t) {
        ArrayList<Student> histroyData = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String query1 = "SELECT * FROM STUDENTS";//Sql query
            PreparedStatement pst = con.prepareStatement(query1);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//Excuting the query
            while (rs.next()) {//while there is connection and results in the table
                //we instantiate an arrya list of userSearchHistory class and grab the vlaues from the table column by column by the help also of the memebr methods in userSearchHistory class
                Student c = new Student();
                c.setStudentID(rs.getInt("STUDENT_ID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setDOB(rs.getString("Date_of_Birth"));
                c.setGender(rs.getString("Gender"));
                c.setProgram(rs.getString("Program"));
                c.setGPA(rs.getFloat("GPA"));

                histroyData.add(c);
            }
            if (histroyData.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Data to Show Convert words first to see Data");
            }

            DefaultTableModel model = (DefaultTableModel) t.getModel();//DefaultTableModel to get the model to popultev our JTable
            Vector<Object> row = new Vector<Object>();//tmeporary vector to hold the values
            for (int i = 0; i < histroyData.size(); i++) {
                row = new Vector<Object>();
                row.add(histroyData.get(i).getFirstName());
                row.add(histroyData.get(i).getLastName());
                row.add(histroyData.get(i).getDOB());
                row.add(histroyData.get(i).getGender());
                row.add(histroyData.get(i).getProgram());
                row.add(histroyData.get(i).getGPA());
                row.add(histroyData.get(i).getStudentID());
                model.addRow(row);//adding the rows ot our table
            }
            
            con.close();
        } catch (Exception e) {//throw an exception if the extraction or the connection is failed
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean retrieveStudentInfoMale(JTable t) {
        ArrayList<Student> histroyData = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String query1 = "SELECT * FROM STUDENTS WHERE Gender='M' ";//Sql query
            PreparedStatement pst = con.prepareStatement(query1);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//Excuting the query
            while (rs.next()) {//while there is connection and results in the table
                //we instantiate an arrya list of userSearchHistory class and grab the vlaues from the table column by column by the help also of the memebr methods in userSearchHistory class
                Student c = new Student();
                c.setStudentID(rs.getInt("STUDENT_ID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setDOB(rs.getString("Date_of_Birth"));
                c.setGender(rs.getString("Gender"));
                c.setProgram(rs.getString("Program"));
                c.setGPA(rs.getFloat("GPA"));

                histroyData.add(c);
            }
            if (histroyData.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Data to Show Convert words first to see Data");
            }

            DefaultTableModel model = (DefaultTableModel) t.getModel();//DefaultTableModel to get the model to popultev our JTable
            Vector<Object> row = new Vector<Object>();//tmeporary vector to hold the values
            for (int i = 0; i < histroyData.size(); i++) {
                row = new Vector<Object>();
                row.add(histroyData.get(i).getFirstName());
                row.add(histroyData.get(i).getLastName());
                row.add(histroyData.get(i).getDOB());
                row.add(histroyData.get(i).getGender());
                row.add(histroyData.get(i).getProgram());
                row.add(histroyData.get(i).getGPA());
                row.add(histroyData.get(i).getStudentID());
                model.addRow(row);//adding the rows ot our table
            }
            
            con.close();
        } catch (Exception e) {//throw an exception if the extraction or the connection is failed
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean retrieveStudentInfoFemale(JTable t) {
        ArrayList<Student> histroyData = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String query1 = "SELECT * FROM STUDENTS WHERE GENDER ='F'";//Sql query
            PreparedStatement pst = con.prepareStatement(query1);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//Excuting the query
            while (rs.next()) {//while there is connection and results in the table
                //we instantiate an arrya list of userSearchHistory class and grab the vlaues from the table column by column by the help also of the memebr methods in userSearchHistory class
                Student c = new Student();
                c.setStudentID(rs.getInt("STUDENT_ID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setDOB(rs.getString("Date_of_Birth"));
                c.setGender(rs.getString("Gender"));
                c.setProgram(rs.getString("Program"));
                c.setGPA(rs.getFloat("GPA"));

                histroyData.add(c);
            }
            if (histroyData.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Data to Show Convert words first to see Data");
            }

            DefaultTableModel model = (DefaultTableModel) t.getModel();//DefaultTableModel to get the model to popultev our JTable
            Vector<Object> row = new Vector<Object>();//tmeporary vector to hold the values
            for (int i = 0; i < histroyData.size(); i++) {
                row = new Vector<Object>();
                row.add(histroyData.get(i).getFirstName());
                row.add(histroyData.get(i).getLastName());
                row.add(histroyData.get(i).getDOB());
                row.add(histroyData.get(i).getGender());
                row.add(histroyData.get(i).getProgram());
                row.add(histroyData.get(i).getGPA());
                row.add(histroyData.get(i).getStudentID());
                model.addRow(row);//adding the rows ot our table
            }
            
            con.close();
        } catch (Exception e) {//throw an exception if the extraction or the connection is failed
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean retrieveStudentInfoCS(JTable t) {
        ArrayList<Student> histroyData = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String query1 = "SELECT * FROM STUDENTS WHERE PROGRAM ='CS' ";//Sql query
            PreparedStatement pst = con.prepareStatement(query1);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//Excuting the query
            while (rs.next()) {//while there is connection and results in the table
                //we instantiate an arrya list of userSearchHistory class and grab the vlaues from the table column by column by the help also of the memebr methods in userSearchHistory class
                Student c = new Student();
                c.setStudentID(rs.getInt("STUDENT_ID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setDOB(rs.getString("Date_of_Birth"));
                c.setGender(rs.getString("Gender"));
                c.setProgram(rs.getString("Program"));
                c.setGPA(rs.getFloat("GPA"));

                histroyData.add(c);
            }
            if (histroyData.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Data to Show Convert words first to see Data");
            }

            DefaultTableModel model = (DefaultTableModel) t.getModel();//DefaultTableModel to get the model to popultev our JTable
            Vector<Object> row = new Vector<Object>();//tmeporary vector to hold the values
            for (int i = 0; i < histroyData.size(); i++) {
                row = new Vector<Object>();
                row.add(histroyData.get(i).getFirstName());
                row.add(histroyData.get(i).getLastName());
                row.add(histroyData.get(i).getDOB());
                row.add(histroyData.get(i).getGender());
                row.add(histroyData.get(i).getProgram());
                row.add(histroyData.get(i).getGPA());
                row.add(histroyData.get(i).getStudentID());
                model.addRow(row);//adding the rows ot our table
            }
            
            con.close();
        } catch (Exception e) {//throw an exception if the extraction or the connection is failed
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean retrieveStudentInfoBio(JTable t) {
        ArrayList<Student> histroyData = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String query1 = "SELECT * FROM STUDENTS WHERE PROGRAM ='Bio' ";//Sql query
            PreparedStatement pst = con.prepareStatement(query1);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//Excuting the query
            while (rs.next()) {//while there is connection and results in the table
                //we instantiate an arrya list of userSearchHistory class and grab the vlaues from the table column by column by the help also of the memebr methods in userSearchHistory class
                Student c = new Student();
                c.setStudentID(rs.getInt("STUDENT_ID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setDOB(rs.getString("Date_of_Birth"));
                c.setGender(rs.getString("Gender"));
                c.setProgram(rs.getString("Program"));
                c.setGPA(rs.getFloat("GPA"));

                histroyData.add(c);
            }
            if (histroyData.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Data to Show Convert words first to see Data");
            }

            DefaultTableModel model = (DefaultTableModel) t.getModel();//DefaultTableModel to get the model to popultev our JTable
            Vector<Object> row = new Vector<Object>();//tmeporary vector to hold the values
            for (int i = 0; i < histroyData.size(); i++) {
                row = new Vector<Object>();
                row.add(histroyData.get(i).getFirstName());
                row.add(histroyData.get(i).getLastName());
                row.add(histroyData.get(i).getDOB());
                row.add(histroyData.get(i).getGender());
                row.add(histroyData.get(i).getProgram());
                row.add(histroyData.get(i).getGPA());
                row.add(histroyData.get(i).getStudentID());
                model.addRow(row);//adding the rows ot our table
            }
            
            con.close();
        } catch (Exception e) {//throw an exception if the extraction or the connection is failed
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean retrieveStudentInfobuiss(JTable t) {
        ArrayList<Student> histroyData = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String query1 = "SELECT * FROM STUDENTS WHERE PROGRAM ='buiss' ";//Sql query
            PreparedStatement pst = con.prepareStatement(query1);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//Excuting the query
            while (rs.next()) {//while there is connection and results in the table
                //we instantiate an arrya list of userSearchHistory class and grab the vlaues from the table column by column by the help also of the memebr methods in userSearchHistory class
                Student c = new Student();
                c.setStudentID(rs.getInt("STUDENT_ID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setDOB(rs.getString("Date_of_Birth"));
                c.setGender(rs.getString("Gender"));
                c.setProgram(rs.getString("Program"));
                c.setGPA(rs.getFloat("GPA"));

                histroyData.add(c);
            }
            if (histroyData.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Data to Show Convert words first to see Data");
            }

            DefaultTableModel model = (DefaultTableModel) t.getModel();//DefaultTableModel to get the model to popultev our JTable
            Vector<Object> row = new Vector<Object>();//tmeporary vector to hold the values
            for (int i = 0; i < histroyData.size(); i++) {
                row = new Vector<Object>();
                row.add(histroyData.get(i).getFirstName());
                row.add(histroyData.get(i).getLastName());
                row.add(histroyData.get(i).getDOB());
                row.add(histroyData.get(i).getGender());
                row.add(histroyData.get(i).getProgram());
                row.add(histroyData.get(i).getGPA());
                row.add(histroyData.get(i).getStudentID());
                model.addRow(row);//adding the rows ot our table
            }
           
            con.close();
        } catch (Exception e) {//throw an exception if the extraction or the connection is failed
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean retrieveArchivedStudents(JTable t){
        ArrayList<Student> histroyData = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String query1 = "SELECT * FROM STUDENT_ARCHIVE";//Sql query
            PreparedStatement pst = con.prepareStatement(query1);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//Excuting the query
            while (rs.next()) {//while there is connection and results in the table
                //we instantiate an arrya list of userSearchHistory class and grab the vlaues from the table column by column by the help also of the memebr methods in userSearchHistory class
                Student c = new Student();
                c.setStudentID(rs.getInt("STUDENT_ID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setDOB(rs.getString("Date_of_Birth"));
                c.setGender(rs.getString("Gender"));
                c.setProgram(rs.getString("Program"));
                c.setGPA(rs.getFloat("GPA"));

                histroyData.add(c);
            }
            if (histroyData.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Data to Show Convert words first to see Data");
            }

            DefaultTableModel model = (DefaultTableModel) t.getModel();//DefaultTableModel to get the model to popultev our JTable
            Vector<Object> row = new Vector<Object>();//tmeporary vector to hold the values
            for (int i = 0; i < histroyData.size(); i++) {
                row = new Vector<Object>();
                row.add(histroyData.get(i).getFirstName());
                row.add(histroyData.get(i).getLastName());
                row.add(histroyData.get(i).getDOB());
                row.add(histroyData.get(i).getGender());
                row.add(histroyData.get(i).getProgram());
                row.add(histroyData.get(i).getGPA());
                row.add(histroyData.get(i).getStudentID());
                model.addRow(row);//adding the rows ot our table
            }
           
            con.close();
        } catch (Exception e) {//throw an exception if the extraction or the connection is failed
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean insertNewStudent(Student s) {//More Args for this one
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "EXEC addStudent ?,?,?,?,?,?;";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            //if the field are not empty
            pst.setString(1, s.getFirstName());
            pst.setString(2, s.getLastName());
            pst.setString(3, s.getDOB());
            pst.setString(4, s.getGender());
            pst.setString(5, s.getProgram());
            pst.setString(6, Float.toString(s.getGPA()));

            pst.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
        return flagSuccess;
    }
    
    public boolean retrieveStudent(Student s){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "EXEC RETRIEVE_STUDENTS ?,?,?,?,?,?,?;";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            //if the field are not empty
            pst.setInt(1, s.getStudentID());
            pst.setString(2, s.getFirstName());
            pst.setString(3, s.getLastName());
            pst.setString(4, s.getDOB());
            pst.setString(5, s.getGender());
            pst.setString(6, s.getProgram());
            pst.setString(7, Float.toString(s.getGPA()));

            pst.execute();
            con.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
             return false;
        }
       
    }

    public void searchForStudent() {//Further args needed

    }

    public boolean updateStudentInfo(int id, float GPA, String program) {//Further Args Needed
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "Update  STUDENTS set GPA = ?,program =?\n"
                    + "where STUDENT_ID = ?";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            pst.setString(1, Float.toString(GPA));
            pst.setString(2, program);
            pst.setString(3, Integer.toString(id));

            pst.executeUpdate();//executes the query

            con.close();
            return true;
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);
           
            System.out.println(e);
            return false;
        }
    }

    public String adminImg(String UserName, String password) {
        String tmp = "";
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "Select profilePic From ADMINSTRATORS where UserName =? and PassWord=?";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            pst.setString(1, UserName);//setting the values where there is ? in the query 
            pst.setString(2, password);//setting the values where there is ? in the query 
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                tmp = rs.getString("profilePic");
            } else {//if the data is not macthing it will return false 
                JOptionPane.showMessageDialog(null, "Username or password are not correct");

            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);

        }
        return tmp;
    }

    public int enrolledNumber() {
        int sum = 0;
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "Select count(*) AS enrolled From STUDENTS";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                sum = rs.getInt("enrolled");
            } else {//if the data is not macthing it will return false 

            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);

        }
        return sum;
    }

    public int femaleEnrolled() {
        int sum = 0;
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "SELECT COUNT(Gender) AS genderSum FROM STUDENTS\n"
                    + "WHERE Gender LIKE 'F'";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                sum = rs.getInt("genderSum");
            } else {//if the data is not macthing it will return false 

            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);

        }
        return sum;
    }

    public int maleEnrolled() {
        int sum = 0;
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "SELECT COUNT(Gender) AS genderSum FROM STUDENTS\n"
                    + "WHERE Gender LIKE 'M'";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                sum = rs.getInt("genderSum");
            } else {//if the data is not macthing it will return false 

            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);

        }
        return sum;
    }

    public int csEnrolled() {
        int sum = 0;
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "SELECT COUNT(Program) AS sumPro FROM STUDENTS WHERE Program LIKE 'CS'";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                sum = rs.getInt("sumPro");
            } else {//if the data is not macthing it will return false 

            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);

        }
        return sum;
    }

    public int buissinessEnrolled() {
        int sum = 0;
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "SELECT COUNT(Program) AS sumPro FROM STUDENTS WHERE Program LIKE 'Buiss'";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                sum = rs.getInt("sumPro");
            } else {//if the data is not macthing it will return false 

            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);

        }
        return sum;
    }

    public int BioEnrolled() {
        int sum = 0;
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "SELECT COUNT(Program) AS sumPro FROM STUDENTS WHERE Program LIKE 'Bio'";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                sum = rs.getInt("sumPro");
            } else {//if the data is not macthing it will return false 

            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);

        }
        return sum;
    }
    
    public int archivedStudents(){
         int sum = 0;
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "SELECT COUNT(*) AS sumPro FROM STUDENT_ARCHIVE ";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                sum = rs.getInt("sumPro");
            } else {//if the data is not macthing it will return false 

            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);

        }
        return sum;
    }

    public String studentImageSearch(int id) {
        String pathName = "";
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "Select * From STUDENT_IMAGE where STUDENT_ID=?";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            pst.setInt(1, id);//setting the values where there is ? in the query 
            ResultSet rs = pst.executeQuery();//executes the query
            if (rs.next()) {//if connection has been established and the data has been validated it will return true
                pathName = rs.getString("PathDir");
            } else {//if the data is not macthing it will return false 
            }
            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);
            flagSuccess = false;
            System.out.println(e);

        }
        return pathName;
    }

    public void updateStudentPic(int id, String pathName) {
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "Update  STUDENT_IMAGE set PathDir = ?\n"
                    + "where STUDENT_ID = ?";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            pst.setString(1, pathName);
            pst.setString(2, Integer.toString(id));
            pst.executeUpdate();//executes the query

            con.close();
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);
            
            System.out.println(e);
        }
    }
    
    public boolean archiveStudent(int id){
                
        try {
            //trying to establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//grabbing the connection URL
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SCHOOL;user=IBRAHIM;password=12345";//fillign the connection details
            Connection con = DriverManager.getConnection(url);//connection object that tries to establish the connection
            String sql = "EXEC ARCHIVE_STUDENTS ?";//Sql query
            PreparedStatement pst = con.prepareStatement(sql);//preprared stmt that tries to execute the query
            
            pst.setInt(1, id); 
            pst.execute();
            con.close();
             return true;
        } catch (Exception e) {//exception handling
            JOptionPane.showMessageDialog(null, e);

            System.out.println(e);
            return false;
        }
        
    }
}
