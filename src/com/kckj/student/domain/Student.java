package com.kckj.student.domain;

//一名科创空间的成员信息
public class Student {
    private int id;
    private String name;
    private String gender;
    private String major;
    private String phone;
    private String state;

    public Student(int id, String name, String gender, String major, String phone, String state) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.phone = phone;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id+
                "\t\t"+name+
                "\t\t"+gender+
                "\t\t"+major+
                "\t\t"+phone+
                "\t\t"+state;
    }
}