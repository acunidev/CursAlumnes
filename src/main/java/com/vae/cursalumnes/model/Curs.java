package com.vae.cursalumnes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table
public class Curs {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long cursid;
  
  private String nom;
  private String descripcio;
  private String url;

  @OneToMany(mappedBy = "curs")
  private List<Student> estudiants;
}
