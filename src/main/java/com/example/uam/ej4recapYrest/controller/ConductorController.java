package com.example.uam.ej4recapYrest.controller;

import com.example.uam.ej4recapYrest.entity.Conductor;
import com.example.uam.ej4recapYrest.service.IConductorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConductorController {

    private final IConductorService conductorService;

    public ConductorController(IConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @GetMapping("/conductor")
    public ResponseEntity<List<Conductor>> getAll() {
        List<Conductor> conductores = conductorService.getAll();
        return new ResponseEntity<>(conductores, HttpStatus.OK);
    }

    @GetMapping("/conductor/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) {
        return conductorService.getById(id)
                .map(conductor -> new ResponseEntity<>("Conductor encontrado", HttpStatus.OK))
                .orElse(new ResponseEntity<>("Conductor no encontrado", HttpStatus.NOT_FOUND));
    }

    @PostMapping("/conductor")
    public ResponseEntity<String> create(@RequestBody Conductor conductor) {
        conductorService.save(conductor);
        return new ResponseEntity<>("Conductor creado con éxito", HttpStatus.CREATED);
    }

    @PutMapping("/conductor/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Conductor conductor) {
        conductorService.update(id, conductor);
        return new ResponseEntity<>("Conductor actualizado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/conductor/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        conductorService.delete(id);
        return new ResponseEntity<>("El conductor ha sido eliminado", HttpStatus.NO_CONTENT);
    }
}

