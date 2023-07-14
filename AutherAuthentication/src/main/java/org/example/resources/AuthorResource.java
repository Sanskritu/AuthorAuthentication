package org.example.resources;


import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import org.example.dao.AuthorDao;
import org.example.entity.Author;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
//import java.ws.rs.core.MediaType;


@Path("/authors")
public class AuthorResource {

    private final AuthorDao authorDao;

    @Inject
    public AuthorResource(AuthorDao authorDao){
        this.authorDao = authorDao;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Author> getInfo(){
        return authorDao.getAll();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Author getOne(@PathParam("id") Integer id){

        return authorDao.getyid(id);
    }

    @POST
    @Path("/create")
    @UnitOfWork
    public Integer create(Author author){

        return authorDao.save(author);
    }
}
