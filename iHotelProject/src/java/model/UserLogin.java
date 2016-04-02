/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author hani
 */
public class UserLogin {
    private int userID;
    private String email;
    private String password;
    private String type;
    private String phone;
    private String fName;
    private String lName;
    private List<Room>roomlist;
    

    public UserLogin(int userID, String email, String password, String type, String phone, String fName, String lName) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.type = type;
        this.phone = phone;
        this.fName = fName;
        this.lName = lName;
    }
    public UserLogin(String email,String pass){
       this.email=email;
        this.password=pass;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public List<Room> getRoomlist() {
        return roomlist;
    }

    public void setRoomlist(List<Room> roomlist) {
        this.roomlist = roomlist;
    }
   
       
}
