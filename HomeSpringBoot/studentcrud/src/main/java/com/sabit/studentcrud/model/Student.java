package com.sabit.studentcrud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="students")
@Data   //  to generate getters, setters, toString, equals, and hashCode
@NoArgsConstructor //  to generate a no-argument constructor
@AllArgsConstructor  //  to generate an all-argument constructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;
}
