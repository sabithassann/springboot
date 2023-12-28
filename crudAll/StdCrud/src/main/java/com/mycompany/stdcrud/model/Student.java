/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stdcrud.model;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Student {
     private int roll;
     private String name;
    private String department;
    private int marks;
    private String gender;
    private String hobby;
    private Date dob;

    public Student() {
    }

    public Student(int roll, String name, String department, int marks, String gender, String hobby, Date dob) {
        this.roll = roll;
        this.name = name;
        this.department = department;
        this.marks = marks;
        this.gender = gender;
        this.hobby = hobby;
        this.dob = dob;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" + "roll=" + roll + ", name=" + name + ", department=" + department + ", marks=" + marks + ", gender=" + gender + ", hobby=" + hobby + ", dob=" + dob + '}';
    }



    
    
    
    
    
    
}
