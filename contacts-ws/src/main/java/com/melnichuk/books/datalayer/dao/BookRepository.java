package com.melnichuk.books.datalayer.dao;
import com.melnichuk.books.datalayer.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
