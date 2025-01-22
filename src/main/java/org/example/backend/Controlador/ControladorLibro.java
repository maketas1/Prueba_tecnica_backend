package org.example.backend.Controlador;

import org.example.backend.Dto.LibroDto;
import org.example.backend.Modelo.Libro;
import org.example.backend.Servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class ControladorLibro {

    @Autowired
    private LibroServicio servicio;

    @GetMapping
    public ResponseEntity<List<LibroDto>> getLibros() {
        List<Libro> libroBBDD = servicio.obtener();
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> getLibro1(@PathVariable(name = "id") Integer id) {
        Libro libro = servicio.obtenerUno(id);
        return new ResponseEntity<>((new LibroDto()).castLibroADto(libro),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LibroDto> addLibro(@Valid @RequestBody LibroDto libroDto) {
        Libro libro = libroDto.castLibro();
        servicio.insertar(libro);
        return new ResponseEntity<>((new LibroDto()).castLibroADto(libro),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<LibroDto> updateLibro(@Valid @RequestBody LibroDto libroDto) {
        Libro libro = libroDto.castLibro();
        servicio.actualizar(libro);
        return new ResponseEntity<>((new LibroDto()).castLibroADto(libro),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LibroDto> patchLibro(@PathVariable(name = "id") Integer id) {
        Libro libro = servicio.obtenerUno(id);
        if (libro.getReaded().equals("Leido")) {
            libro.setReaded("NoLeido");
        } else {
            libro.setReaded("Leido");
        }
        servicio.actualizar(libro);
        return new ResponseEntity<>((new LibroDto()).castLibroADto(libro),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable(name = "id") Integer id) {
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
