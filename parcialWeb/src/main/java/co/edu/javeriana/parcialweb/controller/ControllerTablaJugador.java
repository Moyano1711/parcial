package co.edu.javeriana.parcialweb.controller;


import co.edu.javeriana.parcialweb.model.Jugador;
import co.edu.javeriana.parcialweb.repository.JugadorRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcialWeb/api/jugador/")
public class ControllerTablaJugador {

    JugadorRepository jugadorRepository;

    @CrossOrigin()
    @GetMapping()
    private ResponseEntity<List<Jugador>> getAllJugadores() {
        List<Jugador> jugadores = jugadorRepository.findAll();
        return ResponseEntity.ok(jugadores);
    }

    @CrossOrigin()
    @GetMapping("{id}")
    private ResponseEntity<Jugador> getJugadorById(@PathVariable Long id) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        return jugador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin()
    @PostMapping()
    private ResponseEntity<Jugador> createJugador(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorRepository.save(jugador));
    }

    @CrossOrigin()
    @PutMapping("{id}")
    private ResponseEntity<Jugador> editJugador(@PathVariable Long id, @RequestBody Jugador jugadorEditar) {

        Optional<Jugador> jugador = jugadorRepository.findById(id);
        if (jugador.isPresent()) {
            jugadorEditar.setId(Math.toIntExact(id));
            return ResponseEntity.ok(jugadorRepository.save(jugadorEditar));
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin()
    @DeleteMapping("{id}")
    private Boolean eliminarJugador(@PathVariable Long id){
        jugadorRepository.deleteById(id);
        return true;
    }
}
