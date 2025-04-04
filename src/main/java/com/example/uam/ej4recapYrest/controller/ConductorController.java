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
    public ResponseEntity<Conductor> getById(@PathVariable Long id) {
        return conductorService.getById(id)
                .map(conductor -> new ResponseEntity<>(conductor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/conductor")
    public ResponseEntity<Conductor> create(@RequestBody Conductor conductor) {
        Conductor nuevoConductor = conductorService.save(conductor);
        return new ResponseEntity<>(nuevoConductor, HttpStatus.CREATED);
    }

    @PutMapping("/conductor/{id}")
    public ResponseEntity<Conductor> update(@PathVariable Long id, @RequestBody Conductor conductor) {
        Conductor updatedConductor = conductorService.update(id, conductor);
        return new ResponseEntity<>(updatedConductor, HttpStatus.OK);
    }

    @DeleteMapping("/conductor/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        conductorService.delete(id);
        return new ResponseEntity<>("El conductor ha sido eliminado", HttpStatus.NO_CONTENT);
    }
}

