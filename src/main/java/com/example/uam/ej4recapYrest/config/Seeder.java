package com.example.uam.ej4recapYrest.config;

import com.example.uam.ej4recapYrest.entity.Conductor;
import com.example.uam.ej4recapYrest.entity.Terminal;
import com.example.uam.ej4recapYrest.repository.IConductorRespository;
import com.example.uam.ej4recapYrest.repository.ITerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Seeder implements CommandLineRunner {
    private ITerminalRepository terminalRepository;
    private IConductorRespository conductorRespository;

    @Autowired
    public Seeder(ITerminalRepository terminalRepository, IConductorRespository conductorRepository) {
        this.terminalRepository = terminalRepository;
        this.conductorRespository = conductorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Terminal t1 = new Terminal();
        Conductor c1 = new Conductor();

        t1.setNumeroTerminal(101);
        t1.setLocalidad("CDMX");
        t1.setDireccion("Sur");

        Terminal terminalExistente = terminalRepository.findTerminalByNumeroTerminal(t1.getNumeroTerminal());
        if (terminalExistente == null) {
            terminalRepository.save(t1);
        } else {
            System.out.println("Numero de terminal repetido...");
        }

        c1.setNumeroLicencia("512");
        c1.setNombre("Pedro");
        c1.setTelefono("1234567890");
        c1.setFechaNacimiento(LocalDate.of(2000, 04, 3));
        c1.setTerminal(t1);

        Conductor conductorExistente = conductorRespository.findConductorByNumeroLicencia(c1.getNumeroLicencia());
        if (conductorExistente == null) {
            conductorRespository.save(c1);
        } else {
            System.out.println("Numero de licencia repetido...");
        }
    }
}
