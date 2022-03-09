package com.javaproject.springboot.services;

import java.util.*;

import com.javaproject.springboot.design.BookStack;

public interface LibServiceInterface {

	public List<BookStack> getBookList();

	public void insertBook(BookStack book);

	public BookStack updateBook(BookStack book);

	public BookStack getId(int bookId);

	public void removeBook(int bookId);

	public List<BookStack> getByKeyword(String keyword);

}