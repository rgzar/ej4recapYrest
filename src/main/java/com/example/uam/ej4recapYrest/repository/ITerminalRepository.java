package com.example.uam.ej4recapYrest.repository;

import com.example.uam.ej4recapYrest.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITerminalRepository extends JpaRepository<Terminal, Long> {
    Terminal findTerminalByNumeroTerminal(Long numeroTerminal);
}
