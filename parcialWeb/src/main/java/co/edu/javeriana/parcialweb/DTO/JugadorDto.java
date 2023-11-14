package co.edu.javeriana.parcialweb.model.DTO;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link co.edu.javeriana.parcialweb.model.Equipo}
 */
@Value
public class JugadorDto implements Serializable {
    Long id;

    String nombres;

    String apellidos;

    Long numero;

    Long id_equipo;
}