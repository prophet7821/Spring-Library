package com.aesir.library.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="Book")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="Book_Name",nullable=false)
    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
}
