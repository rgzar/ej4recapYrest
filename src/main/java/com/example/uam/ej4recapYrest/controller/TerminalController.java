package com.example.uam.ej4recapYrest.controller;

import com.example.uam.ej4recapYrest.entity.Terminal;
import com.example.uam.ej4recapYrest.service.ITerminalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class TerminalController {
    private final ITerminalService terminalService;

    public TerminalController(ITerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @GetMapping("/terminal")
    public ResponseEntity<List<Terminal>> getAll() {
        List<Terminal> terminales = terminalService.getAll();
        return new ResponseEntity<>(terminales, HttpStatus.OK);
    }

    @GetMapping("/terminal/{id}")
    public ResponseEntity<Terminal> getById(@PathVariable Long id) {
        return terminalService.getById(id)
                .map(terminal -> new ResponseEntity<>(terminal, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/terminal")
    public ResponseEntity<Terminal> create(@RequestBody Terminal terminal) {
        Terminal nuevaTerminal = terminalService.save(terminal);
        return new ResponseEntity<>(nuevaTerminal, HttpStatus.CREATED);
    }

    @PutMapping("/terminal/{id}")
    public ResponseEntity<Terminal> update(@PathVariable Long id, @RequestBody Terminal terminal) {
        Terminal updatedTerminal = terminalService.update(id, terminal);
        return new ResponseEntity<>(updatedTerminal, HttpStatus.OK);
    }

    @DeleteMapping("/terminal/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        terminalService.delete(id);
        return new ResponseEntity<>("La terminal ha sido eliminada", HttpStatus.NO_CONTENT);
    }
}