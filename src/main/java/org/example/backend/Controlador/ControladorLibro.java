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
@RequestMapping("/api/books")
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
    public ResponseEntity<LibroDto> getLibroById(@PathVariable(name = "id") Integer id) {
        Libro libro = servicio.obtenerUno(id);
        return new ResponseEntity<>((new LibroDto()).castLibroADto(libro),HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<LibroDto>> getLibroByAuthor(@PathVariable(name = "author") String author) {
        List<Libro> libroBBDD = servicio.buscarLibrosPorAuthor(author);
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
    }

    @GetMapping("/author/containing/{author}")
    public ResponseEntity<List<LibroDto>> getLibroByAuthorContaining(@PathVariable(name = "author") String author) {
        List<Libro> libroBBDD = servicio.findLibrosByAuthorContaining(author);
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<LibroDto>> getLibroByTitle(@PathVariable(name = "title") String title) {
        List<Libro> libroBBDD = servicio.buscarLibrosPorTitle(title);
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
    }

    @GetMapping("/title/containing/{title}")
    public ResponseEntity<List<LibroDto>> getLibroByTitleContaining(@PathVariable(name = "title") String title) {
        List<Libro> libroBBDD = servicio.findLibrosByTitleContaining(title);
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
    }

    @GetMapping("/readed/{readed}")
    public ResponseEntity<List<LibroDto>> getLibroByReaded(@PathVariable(name = "readed") String readed) {
        List<Libro> libroBBDD = servicio.buscarLibrosPorLeido(readed);
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
    }

    @GetMapping("/readed/containing/{readed}")
    public ResponseEntity<List<LibroDto>> getLibroByReadedContaining(@PathVariable(name = "readed") String readed) {
        List<Libro> libroBBDD = servicio.findLibrosByReadedContaining(readed);
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
    }

    @GetMapping("/created/{created}")
    public ResponseEntity<List<LibroDto>> getLibroByCreated(@PathVariable(name = "created") String created) {
        List<Libro> libroBBDD = servicio.buscarLibrosPorCreated(created);
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
    }

    @GetMapping("/created/containing/{created}")
    public ResponseEntity<List<LibroDto>> getLibroByCreatedContaining(@PathVariable(name = "created") String created) {
        List<Libro> libroBBDD = servicio.findLibrosByCreatedContaining(created);
        List<LibroDto> listaLibroDto = new ArrayList<>();

        for (Libro libro : libroBBDD) {
            LibroDto libroDto = new LibroDto();
            listaLibroDto.add(libroDto.castLibroADto(libro));
        }

        return new ResponseEntity<>(listaLibroDto, HttpStatus.OK);
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
