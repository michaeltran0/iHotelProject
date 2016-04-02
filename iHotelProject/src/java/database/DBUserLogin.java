/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.registry.infomodel.User;
import model.UserLogin;

/**
 *
 * @author hani
 */
public class DBUserLogin {

    //used 
    public static UserLogin getClientByEmail(String email) throws SQLException{
      
        UserLogin userlog = null;
        
        DBConnection.getInstance();
        PreparedStatement ps= DBConnection.conn.prepareStatement("SELECT * from proj_user WHERE email=?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){      
           int userid = rs.getInt("userid");
           String emaill = rs.getString("email");
           String password = rs.getString("password");
           String type = rs.getString("type");
           String phoneNum = rs.getString("phonenumber");
           String name = rs.getString("fname");
           String lname = rs.getString("lname");
          userlog = new UserLogin(userid,emaill,password,type,phoneNum,name,lname);         
        }
        return userlog;    
    }
    // tested it will work
    private static UserLogin getMember(int member_id) {
         UserLogin u = null;
        String sql = "SELECT * FROM proj_user  WHERE userid = " + member_id;
        try {
            ResultSet rs = DBConnection.getStatement().executeQuery(sql);
           if(rs.next()){      
         int userid = rs.getInt("userid");
           String emaill = rs.getString("email");
           String password = rs.getString("password");
           String type = rs.getString("type");
           String phoneNum = rs.getString("phonenumber");
           String name = rs.getString("fname");
           String lname = rs.getString("lname");
           UserLogin user = new UserLogin(userid,emaill,password,type,phoneNum,name,lname);         
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    // tested it will work
     public static UserLogin setMember(int member_id, String email, String pass,String type,String phoneNum, String fname, String lname) throws SQLException {
        UserLogin u = null;
        String sql = "UPDATE proj_user SET "
                + "email = '" + email + "', "
                + "password= '" + pass + "' "
                 + "type= '" + "member" + "' "
                 + "phonenumber= '" + phoneNum + "' "
                 + "fname= '" + fname+ "' "
                 + "lname= '" + lname+ "' "
                + "where userid=" + email;
        try {
            DBConnection.getStatement().executeUpdate(sql);
            u = getMember(member_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }
    
    //its not working
    //public static int insertMember(int memberid,String email, String pass, String _type, String phonenum, String fname, String _lname) throws SQLException {
       // public static int insertMember(int memberid,String email, String pass, String _type, String phonenum, String fname, String _lname) throws SQLException {
         public static void insertMember(UserLogin userlogin) throws SQLException {
       // int member_id = 0;       
        DBConnection.getInstance(); 
        // insert client
        PreparedStatement ps = DBConnection.conn.prepareStatement
        ("insert into proj_user (email,password,type,phonenumber,fname,lname) values(?,?,?,?,?,?,?)");
       // ps.setInt(1, get);//???????
        ps.setString(2,userlogin.getEmail() );
        ps.setString(3, userlogin.getPassword());
        ps.setString(4, "member");
        ps.setString(5, userlogin.getPhone());
        ps.setString(6, userlogin.getfName());
        ps.setString(7, userlogin.getlName());
        
        int insert_row = ps.executeUpdate();
        //if it doesnt insert
        if (insert_row == 0) {
            throw new SQLException("Member is not inserted");
        }
 
        ps.close();
        

    }
    //tested and it will work
        public static int delettMember(int id) throws SQLException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM proj_user WHERE userid = " + id;
        try {
            rowsDeleted = DBConnection.getStatement().executeUpdate(sql);
            if (rowsDeleted == 0) {
                throw new SQLException("Nothing has been deleted: " + sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return rowsDeleted;
 
    }
 

}
