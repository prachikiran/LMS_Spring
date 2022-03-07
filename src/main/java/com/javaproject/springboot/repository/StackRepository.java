package com.javaproject.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaproject.springboot.design.BookStack;

@Repository
public interface StackRepository extends JpaRepository<BookStack, Integer> {

    @Query(value = "SELECT * FROM library_operation "
            + " where bookID like %:keyword% or title like %:keyword% or author like %:keyword%", nativeQuery = true)
    List<BookStack> findByKeyword(@Param("keyword") String keyword);
}