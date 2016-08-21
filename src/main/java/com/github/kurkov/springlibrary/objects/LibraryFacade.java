package com.github.kurkov.springlibrary.objects;

import com.github.kurkov.springlibrary.dao.interfaces.BookDAO;
import com.github.kurkov.springlibrary.entities.Author;
import com.github.kurkov.springlibrary.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aleksey Kurkov. Created on 19.08.2016
 */
@Component("libraryFacade")
@Scope("singleton")
public class LibraryFacade {

    private static final String FIELD_CONTENT = "content";

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private SearchCriteria searchCriteria;

    private List<Book> books;

    public List<Book> getBooks() {
        if (books == null) {
            books = bookDAO.getBooks();
        }
        return books;
    }

    public void searchBooksByLetter() {
        books = bookDAO.getBooks(searchCriteria.getLetter());
    }

    public void searchBooksByGenre() {
        books = bookDAO.getBooks(searchCriteria.getGenre());
    }

    public void searchBooksByText() {

        switch (searchCriteria.getSearchType()) {
            case TITLE:
                books = bookDAO.getBooks(searchCriteria.getText());
                break;
            case AUTHOR:
                books = bookDAO.getBooks(new Author(searchCriteria.getText()));
                break;
        }
    }

    public byte[] getContent(long id) {
        return (byte[]) bookDAO.getFieldValue(id, FIELD_CONTENT);
    }
}