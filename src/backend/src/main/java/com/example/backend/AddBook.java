package com.example.backend;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddBook {
    public void save(Book book);
    public List<Book> query(String title);
}
