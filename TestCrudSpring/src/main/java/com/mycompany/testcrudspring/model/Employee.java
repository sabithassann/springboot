/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrudspring.model;

/**
 *
 * @author sabit
 */
public class Employee {
    private int id;
    private String name;
    private String gender;
    private String salary;
    private String designation;

    public Employee() {
    }

    public Employee(int id, String name, String gender, String salary, String designation) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.designation = designation;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", designation=" + designation + '}';
    }
}
