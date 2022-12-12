package com.aesir.library.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Author")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="Author_Name",nullable = false)
    @NonNull
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="author")
    List<Book> writtenBooks = new ArrayList<>();
}
