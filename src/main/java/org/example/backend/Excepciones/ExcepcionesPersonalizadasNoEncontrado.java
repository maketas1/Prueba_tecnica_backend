package org.example.backend.Excepciones;

//Clase que extiende de RuntimeException para generar mensajes de error personalizados
public class ExcepcionesPersonalizadasNoEncontrado extends RuntimeException{
    public ExcepcionesPersonalizadasNoEncontrado(String message) {
        super(message);
    }
}
