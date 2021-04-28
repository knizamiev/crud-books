package ru.crud.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crud.books.dao.BooksDAO;
import ru.crud.books.model.Books;

@Controller
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private BooksDAO booksDAO;

	@GetMapping("")
	private String books(Model model){
		model.addAttribute("books", booksDAO.findBooks());
		return "books";
	}

	@GetMapping("/{id}")
	private String book(@PathVariable long id, Model model){
		model.addAttribute("book", booksDAO.findBook(id));
		return "book";
	}

	@GetMapping("/new")
	public String mewBook(Model model){
		model.addAttribute("book", new Books());
		return "new";
	}
	@PostMapping("/add")
	public String addBook(@ModelAttribute("books") Books books){
		booksDAO.addBook(books);
		return "redirect:/books";
	}

}
