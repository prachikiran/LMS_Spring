package com.javaproject.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javaproject.springboot.design.BookStack;
import com.javaproject.springboot.services.ServiceClass;

@Controller
public class WebController {

    @Autowired
    private ServiceClass libService;

    @GetMapping(value = "/")
    public String homePage(Model model) {
        model.addAttribute("bookList", libService.getBookList());
        return "index";
    }

    @RequestMapping(value = "/addBook")
    public String addBook(Model model) {
        model.addAttribute("newBook", new BookStack());
        return "InsertBook";
    }
    
//
//    public String insertBookList() {
//     ModelAndView mv = new ModelAndView();
//     mv.setViewName("InsertBook.html");
//     return mv;
//     
//    }

    @PostMapping(value = "/library/book/insert_new")
    public String insertBook(@ModelAttribute("newBook") BookStack newBook) {
        libService.insertBook(newBook);
        return "redirect:/";
    }

    @GetMapping(value = "/book/search_list")
    public String searchOP() {
        
        return "searchPage";
    }


    @GetMapping("/book/update/{bookID}")
    public String updateOP(@PathVariable int id, Model model) {
        BookStack book = libService.getId(id);
        model.addAttribute("Updatedbook", book);
        return "update_book";
    }

    @GetMapping("/book/remove/{book_ID}")
    public String deleteBook(@PathVariable(value = "booKID") int id) {
        this.libService.removeBook(id);
        return "redirect:/";
    }
}
