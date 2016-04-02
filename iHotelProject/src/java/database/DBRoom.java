/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Room;
import model.UserLogin;

/**
 *
 * @author hani
 */
public class DBRoom {
    
     PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    // tested and used
 public static List<Room> getRooms() throws SQLException {
      List<Room>roomlist = new ArrayList<>();

        DBConnection.getInstance();
        PreparedStatement ps = DBConnection.conn.prepareStatement("SELECT * FROM room");
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int roomid =  rs.getInt("roomid");
            int room_number = rs.getInt("roomno");
            int floorno =  rs.getInt("floorno");
            String roomType =  rs.getString("room_type");
            float price = rs.getFloat("price");
            Boolean bathroom = rs.getBoolean("bathroom");
            Boolean room_available =rs.getBoolean("room_available");
            String notes  = rs.getString("notes");
            
            Room r = new Room(roomid,room_number,floorno,roomType,price,bathroom,room_available,notes);
            roomlist.add(r);
        }

        return roomlist;
    }
    
 //not used not tested
   public static Room getRoomByID(int id) throws SQLException{
        
        Room r = null;
       PreparedStatement ps = DBConnection.conn.prepareStatement("SELECT * from room where room_id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
             if(rs.next()){
            int roomid =  rs.getInt("roomid");
            int room_number = rs.getInt("roomno");
            int floorno =  rs.getInt("floorno");
            String roomType =  rs.getString("room_type");
            float price = rs.getFloat("price");
            Boolean bathroom = rs.getBoolean("bathroom");
            Boolean room_available =rs.getBoolean("room_available");
            String notes  = rs.getString("notes");
            
           r = new Room(roomid,room_number,floorno,roomType,price,bathroom,room_available,notes);

             }
                return r;
    }
//not used not tested
    public static Room setRoom(int room_id, int room_no, int floor_no, String room_type, float price, String bathroom,String room_available, String notes) throws SQLException {
        Room r = null;
        String sql = "UPDATE room SET "
                + "roomno = '" + room_no + "', "
                + "floorno = '" + floor_no + "' "
                + "room_type = '" + room_type + "' "
                + "price = '" + price + "' "
                + "bathroom = '" + bathroom + "' "
                + "room_available = '" + room_available + "' "
                + "notes= '" + notes + "' "
                + "where f_id=" + room_id;
        try {
            DBConnection.getStatement().executeUpdate(sql);
            r = getRoomByID(room_id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return r;
    }
   
   //not used not tested
    public static int deleteRoom(int id) throws SQLException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM room WHERE roomid = " + id;
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
