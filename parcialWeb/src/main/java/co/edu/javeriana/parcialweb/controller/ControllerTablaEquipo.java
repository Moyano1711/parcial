package co.edu.javeriana.parcialweb.controller;

import co.edu.javeriana.parcialweb.model.Equipo;
import co.edu.javeriana.parcialweb.model.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcialWeb/api/equipo/")
public class ControllerTablaEquipo {
    @Autowired
    EquipoRepository equipoRepository;

    @GetMapping()
    private ResponseEntity<List<Equipo>> getAllEquipos() {
        List<Equipo> equipos = equipoRepository.findAll();
        return ResponseEntity.ok(equipos);
    }

    @GetMapping("{id}")
    private ResponseEntity<Equipo> getEquipoById(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        return equipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    private ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
        return ResponseEntity.ok(equipoRepository.save(equipo));
    }

    @PutMapping("{id}")
    private ResponseEntity<Equipo> editEquipo(@PathVariable Long id, @RequestBody Equipo equipoEditar) {

        Optional<Equipo> equipo = equipoRepository.findById(id);
        if (equipo.isPresent()) {
            equipoEditar.setId(Math.toIntExact(id));
            return ResponseEntity.ok(equipoRepository.save(equipoEditar));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    private Boolean eliminarEquipo(@PathVariable Long id){
        equipoRepository.deleteById(id);
        return true;
    }
}
