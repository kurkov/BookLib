package com.github.kurkov.springlibrary.dao.interfaces;

import com.github.kurkov.springlibrary.entities.Genre;

import java.util.List;

/**
 * @author Aleksey Kurkov. Created on 13.08.2016
 */
public interface GenreDAO {

    List<Genre> getGenres();

}
