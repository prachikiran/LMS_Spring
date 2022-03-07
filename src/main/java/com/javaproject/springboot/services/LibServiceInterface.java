package com.javaproject.springboot.services;

import java.util.*;

import com.javaproject.springboot.design.BookStack;

public interface LibServiceInterface {

	public List<BookStack> getBookList();

	public void insertBook(BookStack bookName);

	public BookStack updateBook(BookStack bookName);

	public BookStack getId(int bookId);

	public void removeBook(int bookId);

	public List<BookStack> getByKeyword(String keyword);

}