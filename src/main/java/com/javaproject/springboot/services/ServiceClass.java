package com.javaproject.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.springboot.design.BookStack;
import com.javaproject.springboot.repository.StackRepository;

@Service
public class ServiceClass implements LibServiceInterface {

    @Autowired
    private StackRepository libRepository;

    @Override
    public List<BookStack> getBookList() {

        return (List<BookStack>) libRepository.findAll();
    }

    @Override
    public void insertBook(BookStack book) {
        this.libRepository.save(book);
    }

    @Override
    public BookStack updateBook(BookStack book) {
        return libRepository.save(book);
    }

    @Override
    public BookStack getId(int bookId) {
        return libRepository.findById(bookId).get();
    }

    @Override
    public void removeBook(int bookId) {
        libRepository.deleteById(bookId);
    }

    @Override
    public List<BookStack> getByKeyword(String keyword) {
        return (List<BookStack>) libRepository.findByKeyword(keyword);
    }

}
