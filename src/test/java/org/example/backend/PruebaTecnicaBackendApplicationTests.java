package org.example.backend;

import org.example.backend.Controlador.ControladorLibro;
import org.example.backend.Dto.LibroDto;
import org.example.backend.Modelo.Libro;
import org.example.backend.Servicio.LibroServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PruebaTecnicaBackendApplicationTests {

    @InjectMocks
    private ControladorLibro controladorLibro;

    @Mock
    private LibroServicio libroServicio;

    private Libro libro;
    private LibroDto libroDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        libro = new Libro();
        libro.setId(1);
        libro.setReaded("NoLeido");

        libroDto = new LibroDto();
        libroDto.setId(1);
        libroDto.setReaded("NoLeido");
    }

    @Test
    void testGetLibros() {
        when(libroServicio.obtener()).thenReturn(Arrays.asList(libro));
        ResponseEntity<List<LibroDto>> response = controladorLibro.getLibros();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetLibro1() {
        when(libroServicio.obtenerUno(1)).thenReturn(libro);
        ResponseEntity<LibroDto> response = controladorLibro.getLibroById(1);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testAddLibro() {
        when(libroServicio.insertar(any(Libro.class))).thenReturn(libro);
        ResponseEntity<LibroDto> response = controladorLibro.addLibro(libroDto);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testUpdateLibro() {
        when(libroServicio.actualizar(any(Libro.class))).thenReturn(libro);
        ResponseEntity<LibroDto> response = controladorLibro.updateLibro(libroDto);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testPatchLibro() {
        when(libroServicio.obtenerUno(1)).thenReturn(libro);
        when(libroServicio.actualizar(any(Libro.class))).thenReturn(libro);
        ResponseEntity<LibroDto> response = controladorLibro.patchLibro(1);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Leido", response.getBody().getReaded());
    }

    @Test
    void testDeleteLibro() {
        doNothing().when(libroServicio).eliminar(1);
        ResponseEntity<Void> response = controladorLibro.deleteLibro(1);
        assertEquals(204, response.getStatusCodeValue());
    }
}
