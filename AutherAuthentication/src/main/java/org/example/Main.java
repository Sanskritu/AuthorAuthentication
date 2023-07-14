package org.example;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
//import org.omg.CORBA.Environment;
//import jdk.nashorn.internal.runtime.linker.Bootstrap;
import org.example.config.MyConfiguration;
import org.example.dao.AuthorDao;
import org.example.dao.BookDao;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.resources.AuthorResource;
import org.example.resources.BookResource;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application<MyConfiguration> {
    public static void main(String[] args) {
        try{
            new Main().run(args);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(MyConfiguration myConfiguration, Environment environment) throws  Exception{
        final AuthorDao authorDao = new AuthorDao((hibernateAuthor.getSessionFactory()));
        environment.jersey().register(new AuthorResource(authorDao));
        final BookDao bookDao = new BookDao(hibernateAuthor.getSessionFactory());
        environment.jersey().register(new BookResource(bookDao));
    }


    private final HibernateBundle<MyConfiguration> hibernateAuthor = new HibernateBundle<MyConfiguration>(Author.class, Book.class){

        @Override
        public DataSourceFactory getDataSourceFactory (MyConfiguration configuration){
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap){
        bootstrap.addBundle(hibernateAuthor);
    }
}