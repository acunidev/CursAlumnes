package com.vae.cursalumnes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity @Data
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String estudiantNom;
    private String estudiantCognom;
    @ManyToOne()
    private Curs curs;

}
