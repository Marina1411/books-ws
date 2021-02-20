package com.melnichuk.books.businesslyer.services;

import com.melnichuk.books.datalayer.entities.Book;
import org.springframework.data.domain.Page;

public interface BookService {

    public Page<Book> getAllBooks(Integer pageNum, Integer pageSize);

    public Book getBookById(Integer id);

    public Book addNewBook(Book book);

    public Book updateBook(Book book);

    public void deleteBook(Book book);
}
