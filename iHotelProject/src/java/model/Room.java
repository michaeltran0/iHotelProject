/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hani
 */
public class Room {
    private int roomid;
    private int roomNo;
    private int floorNo;
    private String roomType;
    private float price;
    private boolean bathroom;
    private boolean room_availabe;
    private String notes;

    public Room(int roomid, int roomNo, int floorNo, String roomType, float price, boolean bathroom, boolean room_availabe, String notes) {
        this.roomid = roomid;
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.roomType = roomType;
        this.price = price;
        this.bathroom = bathroom;
        this.room_availabe = room_availabe;
        this.notes = notes;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isBathroom() {
        return bathroom;
    }

    public void setBathroom(boolean bathroom) {
        this.bathroom = bathroom;
    }

    public boolean isRoom_availabe() {
        return room_availabe;
    }

    public void setRoom_availabe(boolean room_availabe) {
        this.room_availabe = room_availabe;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String details) {
        this.notes = notes;
    }

    
    
}
