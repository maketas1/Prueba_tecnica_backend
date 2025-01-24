package org.example.backend.Excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

//Controlador Excepciones (
@RestController
@ControllerAdvice
public class ControladorExcepciones extends ResponseEntityExceptionHandler {

    //Metodo para resultados 400
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String mensaje = ex.getBindingResult().getAllErrors().stream().map(e -> {
            return e.getDefaultMessage().concat(", ");
        }).collect(Collectors.joining());

        ExcepcionRespuesta e1 = new ExcepcionRespuesta(LocalDateTime.now(),
                mensaje,
                request.getDescription(false));
        return new ResponseEntity<>(e1, HttpStatus.BAD_REQUEST);
    }

    //Metodo para resultados 404
    @ExceptionHandler(ExcepcionesPersonalizadasNoEncontrado.class)
    public ResponseEntity<ExcepcionRespuesta> catchDeNoEncontrado(ExcepcionesPersonalizadasNoEncontrado ex, WebRequest peticion) {
        ExcepcionRespuesta e1 = new ExcepcionRespuesta(LocalDateTime.now(), ex.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e1, HttpStatus.NOT_FOUND);
    }

    //Metodo para resultados 405
    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<ExcepcionRespuesta> handleMethodNotAllowed(MethodNotAllowedException ex, WebRequest peticion) {
        ExcepcionRespuesta e1 = new ExcepcionRespuesta(LocalDateTime.now(), ex.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e1, HttpStatus.METHOD_NOT_ALLOWED);
    }

    //Metodo para resultados 500
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcepcionRespuesta> catchTodasLasExcepciones(Exception ex, WebRequest peticion) {
        ExcepcionRespuesta e1 = new ExcepcionRespuesta(LocalDateTime.now(), ex.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e1, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
