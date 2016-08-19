package com.github.kurkov.springlibrary.objects;

import com.github.kurkov.springlibrary.dao.interfaces.BookDAO;
import com.github.kurkov.springlibrary.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aleksey Kurkov. Created on 19.08.2016
 */
@Component
public class LibraryFacade {


    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        books = bookDAO.getBooks();
    }

    private List<Book> books;


    public List<Book> getBooks() {
        return books;
    }
}