package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name ="author")
public class Author {
    @Id
    @Column(name ="auid")
    @JsonProperty
    private Integer authId;
    @Column(name = "aname")
    @JsonProperty
    private String name;

    @OneToMany
    @JoinColumn(name ="author_id")
    @JsonProperty
    private List<Book> books;

    public Author(Integer authId, String name){
        this.authId = authId;
        this.name = name;
    }

    public Author(){

    }
}
