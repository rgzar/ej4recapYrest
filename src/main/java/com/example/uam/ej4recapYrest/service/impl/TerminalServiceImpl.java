package com.example.uam.ej4recapYrest.service.impl;

import com.example.uam.ej4recapYrest.entity.Terminal;
import com.example.uam.ej4recapYrest.repository.ITerminalRepository;
import com.example.uam.ej4recapYrest.service.ITerminalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalServiceImpl implements ITerminalService {
    private final ITerminalRepository terminalRepository;

    public TerminalServiceImpl(ITerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    @Override
    public List<Terminal> getAll() {
        return terminalRepository.findAll();
    }

    @Override
    public Optional<Terminal> getById(Long id) {
        return terminalRepository.findById(id);
    }

    @Override
    public Terminal save(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    @Override
    public Terminal update(Long id, Terminal terminal) {
        if (terminalRepository.existsById(id)) {
            terminal.setId(id);
            return terminalRepository.save(terminal);
        }
        return null;
    }

    @Override
    public Terminal patch(Long id, Terminal terminal) {
        return terminalRepository.findById(id).map(existing -> {
            if (terminal.getLocalidad() != null) existing.setLocalidad(terminal.getLocalidad());
            if (terminal.getDireccion() != null) existing.setDireccion(terminal.getDireccion());
            return terminalRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        terminalRepository.deleteById(id);
    }
}
