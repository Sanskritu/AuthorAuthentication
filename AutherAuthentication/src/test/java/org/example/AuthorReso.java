package org.example;

import com.google.common.collect.ImmutableList;
import org.example.dao.AuthorDao;
import org.example.entity.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

public class AuthorReso {
    AuthorDao authorDao = mock(AuthorDao.class);

    Author author = mock(Author.class);

    @Test
    public void getAllAuth() {
        ImmutableList<Author> authors = ImmutableList.of(author);
        Mockito.<List<Author>>when(authorDao.getAll()).thenReturn(authors);
        List<Author> authorList = authorDao.getAll();
        Assertions.assertEquals(authorList, authors);
    }

    @Test
    public void findById() {
        Mockito.when(authorDao.getyid(22)).thenReturn(author);
        Assertions.assertEquals(authorDao.getyid(22), author);
    }


    @Test

    public void saveAuthor() {
        Mockito.when(authorDao.save(author)).thenReturn(23);
        Assertions.assertEquals(authorDao.save(author), 23);
    }
}
