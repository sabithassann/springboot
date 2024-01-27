package com.sabit.testangular.model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String authorName;
    private String title;
}
