package org.example.backend.Servicio;

import org.example.backend.Modelo.Libro;

import java.util.List;

//Interfaz con las consultas personalizadas para usarlas en el servicio
public interface ILibroServicio extends ICRUD<Libro,Integer> {
    List<Libro> buscarLibrosPorAuthor(String author);
    List<Libro> buscarLibrosPorTitle(String title);
    List<Libro> buscarLibrosPorLeido(String readed);
    List<Libro> buscarLibrosPorCreated(String created);
    List<Libro> findLibrosByTitleContaining(String title);
    List<Libro> findLibrosByAuthorContaining(String author);
    List<Libro> findLibrosByReadedContaining(String readed);
    List<Libro> findLibrosByCreatedContaining(String created);
}
