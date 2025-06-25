package com.example.TechFlowspa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "geolocalizaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Geolocalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitud;

    @Column(nullable = false)
    private Double longitud;

    @Column(nullable = false)
    private String usuario;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @PrePersist
    public void prePersist() {
        this.fechaHora = LocalDateTime.now();
    }
}
