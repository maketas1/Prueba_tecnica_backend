package org.example.backend.Servicio;

import java.util.List;

//Interfaz Crud generico para servicio
public interface ICRUD<T, ID> {
    List<T> obtener();
    T insertar(T t);
    T actualizar(T t);
    T obtenerUno(ID id);
    void eliminar(ID id);
}
