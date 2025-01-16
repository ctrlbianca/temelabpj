package com.example.LABORATOR11.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "evenimente")
public class Eveniment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denumire;
    private String locatie;
    private LocalDate data;
    private LocalTime timp;
    private double pretBilet;

}
