package com.example.librariesex.service;

import com.example.librariesex.model.Book;
import com.example.librariesex.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> findBookById(UUID id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(UUID id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDetails.getTitle());
        book.setAuthors(bookDetails.getAuthors());
        book.setPages(bookDetails.getPages());
        book.setIsbn(bookDetails.getIsbn());
        book.setYear(bookDetails.getYear());
        book.setPublisher(bookDetails.getPublisher());
        book.setGenre(bookDetails.getGenre());

        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorsContaining(author);
    }

    public List<Book> getBooksByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    public List<Book> getBooksByPublisherAndYearRange(String publisher, int startYear, int endYear) {
        return bookRepository.findByPublisherAndYearBetween(publisher, startYear, endYear);
    }

    public List<Book> getBooksByYear(int year) {
        return bookRepository.findByYear(year);
    }

    public List<Book> getBooksByTitleKeyword(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }
}