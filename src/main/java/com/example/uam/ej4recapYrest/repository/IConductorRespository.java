package com.example.uam.ej4recapYrest.repository;

import com.example.uam.ej4recapYrest.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConductorRespository extends JpaRepository<Conductor, Long> {
    Conductor findConductorByNumeroLicencia(String numeroLicencia);
}
