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

//Clase Controlador
@RestController
@RequestMapping("/api/books")
public class ControladorLibro {

    //Constructor de la clase servicio
    @Autowired
    private LibroServicio servicio;

    //Metodo para obtener todos los libros de la base de datos
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

    //Metodo que muestra un libro indicando su id
    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> getLibroById(@PathVariable(name = "id") Integer id) {
        Libro libro = servicio.obtenerUno(id);
        return new ResponseEntity<>((new LibroDto()).castLibroADto(libro),HttpStatus.OK);
    }

    //Metodo para mostrar todos los libros que sean del autor indicado
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

    //Metodo para mostrar todos los libros cuyo autor contenga una palabra en especifico
    //(por ejemplo todos los que contengan el nombre Julio)
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

    //Metodo para mostrar todos los libros que sean del titulo indicado
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

    //Metodo para mostrar todos los libros cuyo titulo contenga una palabra en especifico
    //(Por ejemplo todos los que contengan la palabra Viaje)
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

    //Metodo para mostrar todos los libros que se han leido o no leido
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

    //Metodo para mostrar todos los libros que en el apartado de readed contenga una palabra en especifico
    //(Por ejemplo todos los que contengan la palabra no)
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

    //Metodo para mostrar todos los libros que sean de una fecha en especifico
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

    //Metodo para mostrar todos los libros cuya fecha contenga un numero en especifico
    //(Por ejemplo todos los que contengan el numero 2025)
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

    //Metodo para insertar un libro en la base de datos
    @PostMapping
    public ResponseEntity<LibroDto> addLibro(@Valid @RequestBody LibroDto libroDto) {
        Libro libro = libroDto.castLibro();
        servicio.insertar(libro);
        return new ResponseEntity<>((new LibroDto()).castLibroADto(libro),HttpStatus.OK);
    }

    //Metodo para actualizar un libro de la base de datos
    @PutMapping
    public ResponseEntity<LibroDto> updateLibro(@Valid @RequestBody LibroDto libroDto) {
        Libro libro = libroDto.castLibro();
        servicio.actualizar(libro);
        return new ResponseEntity<>((new LibroDto()).castLibroADto(libro),HttpStatus.OK);
    }

    //Metodo para cambiar un libro a leido o no leido
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

    //Metodo para eliminar un libro por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable(name = "id") Integer id) {
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
