package com.github.kurkov.springlibrary.objects;

import com.github.kurkov.springlibrary.entities.Genre;
import com.github.kurkov.springlibrary.enums.SearchType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Aleksey Kurkov. Created on 20.08.2016
 */
@Component
@Scope("singleton")
public class SearchCriteria implements Serializable {

    private String text;

    private SearchType searchType = SearchType.TITLE; // default value

    private Character letter;

    private Genre genre;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
