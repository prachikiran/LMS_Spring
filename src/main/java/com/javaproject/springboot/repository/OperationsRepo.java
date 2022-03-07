package com.javaproject.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.springboot.design.BookStack;

@Repository
public interface OperationsRepo extends CrudRepository<BookStack, Integer>{
    
   
}
