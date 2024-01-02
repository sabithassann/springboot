/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productcrud.dao;

import com.mycompany.productcrud.model.Product;
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
public class ProductDao {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
     public int saveEmp(Product e) {

        String sql = "insert into product(name, price, quantity, brand)"
                + "values('" + e.getName() + "', '" + e.getPrice()+ "', '" + e.getQuantity()+ "','" + e.getBrand()+ "')";

        return jdbcTemplate.update(sql);
    }

    public int deleteEmp(int id) {

        String sql = "delete from product where id=" + id + " ";

        return jdbcTemplate.update(sql);
    }

    public int updateEmp(Product e) {

        String sql = "update  product set name='" + e.getName() + "', price='" + e.getPrice()+ "', quantity='" + e.getQuantity()+ "', brand='" + e.getBrand()+ "' where id='" + e.getId() + "' ";

        return jdbcTemplate.update(sql);
    }

    public List<Product> getAllEmp() {
        return jdbcTemplate.query("select * from product", new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product e = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("quantity"),
                        rs.getString("brand")
                );

                return e;
            }
        });

    }

    public Product getEmpById(int id) {
        String sql = "select * from product where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }
}
