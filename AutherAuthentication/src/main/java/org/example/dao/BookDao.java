package org.example.dao;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.example.entity.Book;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao extends AbstractDAO<Book>{

    SessionFactory factory;

    @Inject
    public BookDao(SessionFactory sessionFactory){
        super (sessionFactory);
    }

    public List<Book> getAll() {

        return query("select B from Book B").list();
    }

    public List<Book> getyId(Integer id) {
        List<Book> books = this.getAll();
        return query("select B from Book B where author_id=" + id).getResultList();
    }

    public Integer save(Book book) {
        return persist(book).getBookId();
    }


}
