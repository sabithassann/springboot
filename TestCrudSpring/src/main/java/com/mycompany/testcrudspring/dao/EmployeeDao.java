/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrudspring.dao;

import com.mycompany.testcrudspring.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author sabit
 */
public class EmployeeDao {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    

    public int saveEmp(Employee e) {

        String sql = "insert into employee(name, gender, salary, designation)"
                + "values('" + e.getName() + "', '" + e.getGender() + "', '" + e.getSalary() + "','" + e.getDesignation() + "')";

        return jdbcTemplate.update(sql);
    }

    public int deleteEmp(int id) {

        String sql = "delete from employee where id=" + id + " ";

        return jdbcTemplate.update(sql);
    }

    public int updateEmp(Employee e) {

        String sql = "update  employee set name='" + e.getName() + "', gender='" + e.getGender() + "', salary='" + e.getSalary() + "', designation='" + e.getDesignation() + "' where id='" + e.getId() + "' ";

        return jdbcTemplate.update(sql);
    }

    public List<Employee> getAllEmp() {
        return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("salary"),
                        rs.getString("designation")
                );

                return e;
            }
        });

    }

    public Employee getEmpById(int id) {
        String sql = "select * from employee where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class));
    }
}
