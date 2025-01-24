package org.example.backend.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

//Objto creado apartid de la tabla libro por hibernate
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
    //Pattern para que el string solo hacepte los valores de Leido o NoLeido
    @Pattern(regexp = "^(Leido|NoLeido)$", message = "Solo se permiten las plabras Leido o NoLeido")
    private String readed;

    @Size(max = 40)
    @Column(name = "created", length = 40)
    //Pattern para el string solo pueda recibir datos en forma de fecha (año-mes-dia)
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String created;

}