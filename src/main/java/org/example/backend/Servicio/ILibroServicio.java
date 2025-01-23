package org.example.backend.Servicio;

import org.example.backend.Modelo.Libro;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILibroServicio extends ICRUD<Libro,Integer> {
    List<Libro> buscarLibrosPorAuthor(String author);
    List<Libro> buscarLibrosPorTitle(String title);
    List<Libro> buscarLibrosPorLeido(@Param("readed") String readed);
    List<Libro> buscarLibrosPorCreated(@Param("created") String created);
}
