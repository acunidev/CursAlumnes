package com.vae.cursalumnes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity @Data
public class Curs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cursid;
    private String titolCurs;
    private String desCurs;
    private String urlCurs;
    @OneToMany(mappedBy = "curs")
    private List<Student> estudiants;
}
