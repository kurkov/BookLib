package com.github.kurkov.springlibrary.dao.interfaces;

import com.github.kurkov.springlibrary.entities.Author;
import com.github.kurkov.springlibrary.entities.Book;
import com.github.kurkov.springlibrary.entities.Genre;

import java.util.List;

/**
 * @author Aleksey Kurkov. Created on 13.08.2016
 */
public interface BookDAO {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);

    Object getFieldValue(Long id, String fieldName);
}
