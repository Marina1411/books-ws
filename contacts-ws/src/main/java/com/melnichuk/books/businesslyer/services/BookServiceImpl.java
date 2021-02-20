package com.melnichuk.books.businesslyer.services;

import com.melnichuk.books.datalayer.dao.BookRepository;
import com.melnichuk.books.datalayer.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository repo;

    public BookServiceImpl(BookRepository repo){
        this.repo = repo;
    }

    @Override
    public Page<Book> getAllBooks(Integer pageNum, Integer pageSize) {

        Pageable p = PageRequest.of(pageNum-1, pageSize);

        return repo.findAll(p);
    }

    @Override
    public Book getBookById(Integer id){
        Book b = repo.findById(id).get();
        return b;
    }

    @Override
    public Book addNewBook(Book book) {
        Book b = repo.save(book);
        return b;
    }

    @Override
    public Book updateBook(Book book) {
        Book b = repo.save(book);
        return b;
    }

    @Override
    public void deleteBook(Book book) {
        repo.delete(book);
    }
}
