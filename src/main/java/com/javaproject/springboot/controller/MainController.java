package com.javaproject.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.springboot.design.BookStack;
import com.javaproject.springboot.services.ServiceClass;

import java.util.List;

@RestController
@RequestMapping("/library")
public class MainController {

    @Autowired
    private ServiceClass libService;

    @GetMapping("/book/display")
    public ResponseEntity<List<BookStack>> displayList() {

        List<BookStack> bookList = libService.getBookList();
        return new ResponseEntity<List<BookStack>>(bookList, HttpStatus.OK);
    }

    @PostMapping(value = "/book/insert")
    public BookStack insertBook(@ModelAttribute("book") BookStack book) {
        libService.insertBook(book);
        return book;
    }

    @GetMapping(value = "/book/{id}")
    public BookStack getBookByID(@PathVariable("id") int bookID) {
        BookStack book = libService.getId(bookID);
        return book;
    }

    @PutMapping(value = "/book/update")
    public BookStack updateBook(@ModelAttribute("Book") BookStack book) {
        libService.updateBook(book);
        return book;
    }

    @DeleteMapping("/book/delete")
    public String deleteBook(@RequestParam int bookID) {
        BookStack book = libService.getId(bookID);
        String bookTitle = book.getTitle();
        libService.removeBook(bookID);

        return "Book #" + bookID + " " + bookTitle + " is successfully removed from the Library";
    }
}