package com.melnichuk.books.datalayer.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="books")
@NoArgsConstructor
@Setter
@Getter

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String book_name;
    private String author_first_name;
    private String author_last_name;
    private String publishing_year;
    private String genre;
    private String publisher;
}
