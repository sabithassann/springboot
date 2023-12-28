/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stdcrud.dao;

import com.mycompany.stdcrud.model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author user
 */
public class StudentDao {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    
     public int saveEmp(Student s) {

        String sql = "insert into student(name, department, marks,gender,hobby,dob)"
                + "values('" + s.getName() + "', '" + s.getDepartment() + "', '" + s.getMarks() + "','" + s.getGender()+ "','" + s.getHobby()+ "','" + s.getDob()+ "')";

        return jdbcTemplate.update(sql);
    }
     
      public int deleteEmp(int roll) {

        String sql = "delete from student where roll=" + roll + " ";

        return jdbcTemplate.update(sql);
    }

//    public int updateEmp(Student s) {
//
//        String sql = "update  student set name='" + s.getName() + "', department='" + s.getDepartment() + "', marks='" + s.getMarks()+ "','" + s.getGender()+ "','" + s.getHobby()+ "','" + s.getDob()+ "','" + s.getRoll()+ "' where roll=? ";
//
//        return jdbcTemplate.update(sql);
//    }
      
      public int updateEmp(Student s) {
    String sql = "UPDATE student SET name=?, department=?, marks=?, gender=?, hobby=?, dob=? WHERE roll=?";
    
    return jdbcTemplate.update(
        sql,
        s.getName(),
        s.getDepartment(),
        s.getMarks(),
        s.getGender(),
        s.getHobby(),
        s.getDob(),
        s.getRoll()
    );
}

    
    public List<Student> getAllEmp() {
        return jdbcTemplate.query("select * from student", new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int row) throws SQLException {
                Student s = new Student(
                        rs.getInt("roll"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getInt("marks"),
                        rs.getString("gender"),
                        rs.getString("hobby"),
                        rs.getDate("dob")
                       
                );

                return s;
            }
        });

    }
    
     public Student getEmpById(int roll) {
        String sql = "select * from student where roll=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{roll}, new BeanPropertyRowMapper<>(Student.class));
    }
}
