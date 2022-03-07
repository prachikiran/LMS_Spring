package com.javaproject.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.javaproject.springboot.design.BookStack;

public interface BookListRepo extends CrudRepository<BookStack, Integer>{

}
