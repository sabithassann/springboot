/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stdcrud.model;

/**
 *
 * @author user
 */
public class Student {
     private int roll;
     private String name;
    private String department;
    private int marks;

    public Student() {
    }

    public Student(int roll, String name, String department, int marks) {
        this.roll = roll;
        this.name = name;
        this.department = department;
        this.marks = marks;
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

    @Override
    public String toString() {
        return "Student{" + "roll=" + roll + ", name=" + name + ", department=" + department + ", marks=" + marks + '}';
    }
    
    
    
    
}
