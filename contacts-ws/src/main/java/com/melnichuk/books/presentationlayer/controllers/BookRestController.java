package com.melnichuk.books.presentationlayer.controllers;

import com.melnichuk.books.businesslyer.services.BookService;
import com.melnichuk.books.datalayer.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService){ this.bookService = bookService;}

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllBook(

                @RequestParam(name="_page", defaultValue = "1") Integer pageNum,
                @RequestParam(name="_limit", defaultValue = "10") Integer pageSize
    ) {
        try {
            Page<Book> page = bookService.getAllBooks(pageNum, pageSize);
            List<Book> bookList = page.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("books", bookList);
            response.put("currentPage", page.getNumber());
            response.put("totalItems", page.getTotalElements());
            response.put("totalPages", page.getTotalPages());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {

        try {
            Book b = bookService.getBookById(id);

            return ResponseEntity.ok(b);

        } catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
    @PostMapping
    public ResponseEntity<?> addNewBook(@RequestBody Book book){

        try{
            Book b = bookService.addNewBook(book);
            return ResponseEntity.ok(b);
        }
        catch (Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book){

        try {
            book.setId(id);
            Book b = bookService.updateBook(book);
            return ResponseEntity.ok(b);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(null);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id){
        try {
            Book b = bookService.getBookById(id);
            bookService.deleteBook(b);
            return ResponseEntity.ok(b);
        } catch (Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }


}
