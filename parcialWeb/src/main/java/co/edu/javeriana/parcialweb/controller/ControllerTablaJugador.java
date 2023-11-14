package co.edu.javeriana.parcialweb.controller;


import co.edu.javeriana.parcialweb.model.Jugador;
import co.edu.javeriana.parcialweb.model.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcialWeb/api/jugador/")
public class ControllerTablaJugador {
    @Autowired
    JugadorRepository jugadorRepository;

    @GetMapping()
    private ResponseEntity<List<Jugador>> getAllJugadores() {
        List<Jugador> jugadores = jugadorRepository.findAll();
        return ResponseEntity.ok(jugadores);
    }

    @GetMapping("{id}")
    private ResponseEntity<Jugador> getJugadorById(@PathVariable Long id) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        return jugador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    private ResponseEntity<Jugador> createJugador(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorRepository.save(jugador));
    }

    @PutMapping("{id}")
    private ResponseEntity<Jugador> editJugador(@PathVariable Long id, @RequestBody Jugador jugadorEditar) {

        Optional<Jugador> jugador = jugadorRepository.findById(id);
        if (jugador.isPresent()) {
            jugadorEditar.setId(id);
            return ResponseEntity.ok(jugadorRepository.save(jugadorEditar));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    private Boolean eliminarJugador(@PathVariable Long id){
        jugadorRepository.deleteById(id);
        return true;
    }
}
