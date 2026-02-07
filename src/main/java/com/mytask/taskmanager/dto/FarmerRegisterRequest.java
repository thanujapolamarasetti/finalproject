package com.mytask.taskmanager.dto;

public class FarmerRegisterRequest {

    private String username;
    private String password;
    private String phoneNumber;
    private String location;

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getLocation() { return location; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setLocation(String location) { this.location = location; }
}
