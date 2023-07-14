package org.example.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @Column(name ="book")
    @JsonProperty
    private Integer bookId;

    @Column(name="book_name")
    @JsonProperty
    private String bookName;

    public Book(){

    }
}
