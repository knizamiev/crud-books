package ru.crud.books.dao;

import ru.crud.books.model.Books;

import java.util.List;

public interface BooksDAO {

	List<Books> findBooks();

	Books findBook(long id);

	void addBook(Books books);
//
//	void deleteBook();
//
//	void editBook();
}
