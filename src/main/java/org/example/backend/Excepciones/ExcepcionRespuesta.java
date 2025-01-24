package org.example.backend.Excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Objeto con los datos para mandar al salir un error de tipo 400, 404, 405 y 500
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExcepcionRespuesta {
    private LocalDateTime fechaHora;

    private String mensaje;

    private String descripcion;
}
