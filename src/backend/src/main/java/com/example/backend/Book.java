package com.example.backend;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private double price;
    private int num;
}
