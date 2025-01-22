package org.example.backend.Servicio;

import org.example.backend.Modelo.Libro;
import org.example.backend.Repositorio.IGenericoRepositorio;
import org.example.backend.Repositorio.ILibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio extends CRUD<Libro, Integer> implements ILibroServicio {

    @Autowired
    private ILibroRepo repo;

    @Override
    protected IGenericoRepositorio<Libro, Integer> getRepo() {
        return repo;
    }
}
