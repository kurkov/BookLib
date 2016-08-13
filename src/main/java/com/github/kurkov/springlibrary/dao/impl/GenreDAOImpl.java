package com.github.kurkov.springlibrary.dao.impl;

import com.github.kurkov.springlibrary.dao.interfaces.GenreDAO;
import com.github.kurkov.springlibrary.entities.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Aleksey Kurkov. Created on 13.08.2016
 */
@Component
public class GenreDAOImpl implements GenreDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Genre> getGenres() {
        return sessionFactory.getCurrentSession().createCriteria(Genre.class).list();
    }

}