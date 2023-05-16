package com.vae.cursalumnes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long studentId;
  private String estudiantNom;
  private String estudiantCognom;
  
  @ManyToOne()
  private Curs curs;

}
