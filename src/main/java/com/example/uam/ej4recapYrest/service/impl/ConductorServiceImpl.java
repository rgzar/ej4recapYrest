package com.example.uam.ej4recapYrest.service.impl;

import com.example.uam.ej4recapYrest.entity.Conductor;
import com.example.uam.ej4recapYrest.repository.IConductorRespository;
import com.example.uam.ej4recapYrest.service.IConductorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements IConductorService {
    private final IConductorRespository conductorRepository;

    public ConductorServiceImpl(IConductorRespository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    @Override
    public List<Conductor> getAll() {
        return conductorRepository.findAll();
    }

    @Override
    public Optional<Conductor> getById(Long id) {
        return conductorRepository.findById(id);
    }

    @Override
    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public Conductor update(Long id, Conductor conductor) {
        if (conductorRepository.existsById(id)) {
            conductor.setId(id);
            return conductorRepository.save(conductor);
        }
        return null;
    }

    @Override
    public Conductor patch(Long id, Conductor conductor) {
        return conductorRepository.findById(id).map(existing -> {
            if (conductor.getNombre() != null) existing.setNombre(conductor.getNombre());
            if (conductor.getTelefono() != null) existing.setTelefono(conductor.getTelefono());
            if (conductor.getFechaNacimiento() != null) existing.setFechaNacimiento(conductor.getFechaNacimiento());
            return conductorRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        conductorRepository.deleteById(id);
    }
}
