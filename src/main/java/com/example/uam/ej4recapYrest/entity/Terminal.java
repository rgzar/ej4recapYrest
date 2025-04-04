package com.example.uam.ej4recapYrest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "terminales")
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero_terminal")
    private long numeroTerminal;

    @Column(name = "localidad", nullable = false, length = 30)
    private String localidad;

    @Column(name = "direccion", nullable = false, length = 30)
    private String direccion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumeroTerminal() {
        return numeroTerminal;
    }

    public void setNumeroTerminal(long numeroTerminal) {
        this.numeroTerminal = numeroTerminal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
