package br.dh.meli.storage02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "author", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("author")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "books_author",
            joinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("authorSet")
    private Set<Book> books;
}
