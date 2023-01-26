package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

}
