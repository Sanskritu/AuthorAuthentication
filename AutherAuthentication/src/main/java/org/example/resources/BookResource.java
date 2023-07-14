package org.example.resources;

import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import org.example.dao.BookDao;
import org.example.entity.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookResource {

    private final BookDao bookDao;

    @Inject
    public BookResource(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @GET
    @Path("/findwithauth/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Book> getAllBooksByAuthId(@PathParam("id") Integer id){
        return bookDao.getyId(id);
    }

    @GET
    @Path("/create")
    @UnitOfWork
    public Integer createBook (Book book){
        return bookDao.save(book);
    }

}
