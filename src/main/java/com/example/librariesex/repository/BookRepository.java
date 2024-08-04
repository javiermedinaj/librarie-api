package com.example.librariesex.repository;

import com.example.librariesex.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthorsContaining(String author);
    List<Book> findByPages(int pages);
    List<Book> findByIsbn(String isbn);
    List<Book> findByYear(int year);
    List<Book> findByPublisher(String publisher);
    List<Book> findByGenre(String genre);
    List<Book> findByPublisherAndYearBetween(String publisher, int startYear, int endYear);
    List<Book> findByTitleContaining(String keyword);
}