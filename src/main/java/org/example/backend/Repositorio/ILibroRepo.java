package org.example.backend.Repositorio;

import org.example.backend.Modelo.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILibroRepo extends IGenericoRepositorio<Libro,Integer>{

    @Query(value = "Select l From Libro l where l.title = :title")
    List<Libro> buscarLibrosPorTitle(@Param("title") String title);

    @Query(value = "Select l From Libro l where l.author = :author")
    List<Libro> buscarLibrosPorAuthor(@Param("author") String author);

    @Query(value = "Select l From Libro l where l.readed = :readed")
    List<Libro> buscarLibrosPorLeido(@Param("readed") String readed);

    @Query(value = "Select l From Libro l where l.created = :created")
    List<Libro> buscarLibrosPorCreated(@Param("created") String created);
}
