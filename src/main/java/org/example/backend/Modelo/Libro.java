package org.example.backend.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 40)
    private String title;

    @Column(name = "author", length = 40)
    private String author;

    @Column(name = "isRead")
    private Boolean isRead;

    @Column(name = "createdAt")
    private LocalDate createdAt;

}