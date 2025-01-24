package org.example.backend.Servicio;

import org.example.backend.Modelo.Libro;
import org.example.backend.Repositorio.IGenericoRepositorio;
import org.example.backend.Repositorio.ILibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicio extends CRUD<Libro, Integer> implements ILibroServicio {

    @Autowired
    private ILibroRepo repo;

    @Override
    protected IGenericoRepositorio<Libro, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Libro> buscarLibrosPorAuthor(String author) {
        return repo.buscarLibrosPorAuthor(author);
    }

    @Override
    public List<Libro> buscarLibrosPorTitle(String title) {
        return repo.buscarLibrosPorTitle(title);
    }

    @Override
    public List<Libro> buscarLibrosPorLeido(String readed) {
        return repo.buscarLibrosPorLeido(readed);
    }

    @Override
    public List<Libro> buscarLibrosPorCreated(String created) {
        return repo.buscarLibrosPorCreated(created);
    }

    @Override
    public List<Libro> findLibrosByTitleContaining(String title) {
        return repo.findLibrosByTitleContaining(title);
    }

    @Override
    public List<Libro> findLibrosByAuthorContaining(String author) {
        return repo.findLibrosByAuthorContaining(author);
    }

    @Override
    public List<Libro> findLibrosByReadedContaining(String readed) {
        return repo.findLibrosByReadedContaining(readed);
    }

    @Override
    public List<Libro> findLibrosByCreatedContaining(String created) {
        return repo.findLibrosByCreatedContaining(created);
    }
}
