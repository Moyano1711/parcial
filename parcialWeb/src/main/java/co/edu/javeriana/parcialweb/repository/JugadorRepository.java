package co.edu.javeriana.parcialweb.repository;

import co.edu.javeriana.parcialweb.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}