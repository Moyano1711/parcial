package co.edu.javeriana.parcialweb.model.DTO;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link co.edu.javeriana.parcialweb.model.Equipo}
 */
@Value
public class EquipoDto implements Serializable {
    Long id;
    String nombre;
    String ciudad;
    Integer copasInternacionales;
}