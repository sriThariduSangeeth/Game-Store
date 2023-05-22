package com.store.game.models;

public class User {

    private int id;
    private String email;
    private String fname;
    private String lname;
    private String psw;
    private String mobile;
    private String address;
    private String city;
    private String PostalCode;
    private String Birthday;

    public User(int id, String email, String fname, String lname, String mobile, String address, String city, String postalCode) {
        this.id = id;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.psw = psw;
        this.mobile = mobile;
        this.address = address;
        this.city = city;
        this.PostalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }


}
