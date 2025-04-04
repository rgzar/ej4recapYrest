package com.example.uam.ej4recapYrest.service;

import com.example.uam.ej4recapYrest.entity.Terminal;

import java.util.List;
import java.util.Optional;

public interface ITerminalService {
    List<Terminal> getAll();
    Optional<Terminal> getById(Long id);
    Terminal save(Terminal terminal);
    Terminal update(Long id, Terminal terminal);
    Terminal patch(Long id, Terminal terminal);
    void delete(Long id);
}
