package org.example;


import com.google.common.collect.ImmutableList;
import org.example.dao.BookDao;
import org.example.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

public class BookReso {

    BookDao bookDao = mock(BookDao.class);

    Book book = mock(Book.class);
    ImmutableList<Book> books = ImmutableList.of(book);

    @Test
    void getAllBookTest() {
        Mockito.when(bookDao.getAll()).thenReturn(books);
        List<Book> list = bookDao.getAll();
        Assertions.assertEquals(list, books);
    }

    @Test
    void getAllBooksByAuthIdTest() {
        Mockito.when(bookDao.getyId(93)).thenReturn(books);
        List<Book> list = bookDao.getyId(93);
        Assertions.assertEquals(list, books);

    }

    @Test
    void createBookTest() {
        Mockito.when(bookDao.save(book)).thenReturn(23);
        Integer exceId = bookDao.save(book);
        Assertions.assertEquals(exceId, 23);

    }


}
