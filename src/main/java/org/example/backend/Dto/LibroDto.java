package org.example.backend.Dto;

import lombok.*;
import org.example.backend.Modelo.Libro;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibroDto {

    private Integer id;
    private String title;
    private String author;
    private String readed;
    private String created;

    public Libro castLibro() {
        Libro libro = new Libro();
        libro.setId(id);
        libro.setTitle(title);
        libro.setAuthor(author);
        libro.setReaded(readed);
        libro.setCreated(created);
        return libro;
    }

    public LibroDto castLibroADto(Libro libro) {
        id = libro.getId();
        title = libro.getTitle();
        author = libro.getAuthor();
        readed = libro.getReaded();
        created = libro.getCreated();
        return this;
    }
}
