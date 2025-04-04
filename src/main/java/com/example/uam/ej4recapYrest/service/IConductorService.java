package com.example.uam.ej4recapYrest.service;

import com.example.uam.ej4recapYrest.entity.Conductor;

import java.util.List;
import java.util.Optional;

public interface IConductorService {
    List<Conductor> getAll();
    Optional<Conductor> getById(Long id);
    Conductor save(Conductor conductor);
    Conductor update(Long id, Conductor conductor);
    Conductor patch(Long id, Conductor conductor);
    void delete(Long id);
}
