package com.javaproject.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaproject.springboot.design.BookStack;
import com.javaproject.springboot.services.ServiceClass;

@Controller
public class ThymeleafController {

    @Autowired
    private ServiceClass libService;

    @GetMapping(value = "/home")
    public String homePage(Model model) {
        model.addAttribute("bookList", libService.getBookList());
        return "index";
    }

    @GetMapping(value = "/book/insert")
    public String addOP(Model model) {
        BookStack newBook = new BookStack();
        model.addAttribute("Book", newBook);
        return "newBook";
    }

    @GetMapping(value = "/book/search_list")
    public String searchOP() {
        return "searchPage";
    }

    @GetMapping(value = "/book/search")
    public String searchBook(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("FoundBook", libService.getByKeyword(keyword));
        } else {
            return "searchPage";
        }
        return "searchPage";
    }

    @SuppressWarnings("null")
    @PostMapping(value = "/book/store")
    public String storeBook(@ModelAttribute("BookStack") BookStack book) {
        libService.insertBook(book);
        return "redirect:/";
    }

    @GetMapping("/book/update/{book_ID}")
    public String updateOP(@PathVariable int id, Model model) {
        BookStack book = libService.getId(id);
        model.addAttribute("Updatedbook", book);
        return "update_book";
    }

    @GetMapping("/book/delete/{book_ID}")
    public String deleteBook(@PathVariable(value = "booKID") int id) {
        this.libService.removeBook(id);
        return "redirect:/";
    }
}
