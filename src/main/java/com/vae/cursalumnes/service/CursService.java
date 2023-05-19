package com.vae.cursalumnes.service;

import com.vae.cursalumnes.Repository.CursRepository;
import com.vae.cursalumnes.exceptions.ResourceNotFoundException;
import com.vae.cursalumnes.model.Curs;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursService {

  @Autowired
  private CursRepository cursRepository;

  public List<Curs> getCurs() {
    return cursRepository.findAll();
  }

  public Curs getCursById(long id) {
    Optional<Curs> student = cursRepository.findById(id);
    return student.orElse(null);
  }

  public Curs saveCurs(Curs student) {
    return cursRepository.save(student);
  }

  public Curs updateCurs(Curs curs)
      throws ResourceNotFoundException {
    Optional<Curs> oldCurs = cursRepository
        .findById(curs.getCursid());
    if (oldCurs.isEmpty()) {
      throw new ResourceNotFoundException("Resource Not Found!!!!");
    } else {
      Curs cursUpdated = oldCurs.get();
      cursUpdated.setNom(curs.getNom());
      cursUpdated.setDescripcio(curs.getDescripcio());
      cursUpdated.setUrl(curs.getUrl());
      return cursRepository.save(cursUpdated);
    }
  }


}
