package org.example.backend.Repositorio;

import org.example.backend.Modelo.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Interfaz de Libro con consultas adicionales
public interface ILibroRepo extends IGenericoRepositorio<Libro,Integer>{

    //Getters personalizados para la columna title
    @Query(value = "Select l From Libro l where l.title = :title")
    List<Libro> buscarLibrosPorTitle(@Param("title") String title);
    List<Libro> findLibrosByTitleContaining(String titulo);

    //Getters personalizados para la columna author
    @Query(value = "Select l From Libro l where l.author = :author")
    List<Libro> buscarLibrosPorAuthor(@Param("author") String author);
    List<Libro> findLibrosByAuthorContaining(String author);

    //Getters personalizados para la columna readed
    @Query(value = "Select l From Libro l where l.readed = :readed")
    List<Libro> buscarLibrosPorLeido(@Param("readed") String readed);
    List<Libro> findLibrosByReadedContaining(String readed);

    //Getters personalizados para la columna created
    @Query(value = "Select l From Libro l where l.created = :created")
    List<Libro> buscarLibrosPorCreated(@Param("created") String created);
    List<Libro> findLibrosByCreatedContaining(String created);
}
