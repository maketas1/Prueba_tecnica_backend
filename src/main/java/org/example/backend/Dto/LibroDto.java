package org.example.backend.Dto;

import lombok.*;
import org.example.backend.Modelo.Libro;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibroDto {

    private Integer id;
    private String title;
    private String author;
    private Boolean isRead;
    private LocalDate createdAt;

    public Libro castLibro() {
        Libro libro = new Libro();
        libro.setId(id);
        libro.setTitle(title);
        libro.setAuthor(author);
        libro.setIsRead(isRead);
        libro.setCreatedAt(createdAt);
        return libro;
    }

    public LibroDto castLibroADto(Libro libro) {
        id = libro.getId();
        title = libro.getTitle();
        author = libro.getAuthor();
        isRead = libro.getIsRead();
        createdAt = libro.getCreatedAt();
        return this;
    }
}
