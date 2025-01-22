package org.example.backend.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 40)
    @Column(name = "title", length = 40)
    private String title;

    @Size(max = 40)
    @Column(name = "author", length = 40)
    private String author;

    @ColumnDefault("'NoLeido'")
    @Lob
    @Column(name = "readed")
    private String readed;

    @Size(max = 40)
    @Column(name = "created", length = 40)
    private String created;

}