package com.codegym.model;

public class Contact {
    private String phoneNumber;
    private String group; // nhóm danh bạ
    private String name;
    private String sex;
    private String birthDay;
    private String email;
    private String address;

    public Contact() {
    }

    public Contact(String phoneNumber, String group, String name, String sex, String birthDay, String email, String address) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.email = email;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  " phoneNumber= " + phoneNumber + " , " +
                " group= " + group + " , " +
                " name= " + name + " , " +
                " sex= " + sex + " , " +
                " birthDay= " + birthDay + " , " +
                " email= " + email + " , " +
                " address= " + address
                ;
    }
}
