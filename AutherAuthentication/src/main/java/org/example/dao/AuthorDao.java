package org.example.dao;

import  com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.example.entity.Author;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorDao extends AbstractDAO<Author>{
    SessionFactory factory;

    @Inject
    public AuthorDao(SessionFactory sessionFactory){
        super(sessionFactory);
        this.factory = sessionFactory;
    }

    public List<Author> getAll(){
        return query("Select A from Author A").list();
    }

    public Author getyid(Integer id){
        return get(id);
    }

    public Integer save(Author author){
        return persist(author).getAuthId();
    }

}
