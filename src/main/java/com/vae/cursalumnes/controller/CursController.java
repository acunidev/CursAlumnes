package com.vae.cursalumnes.controller;

import com.vae.cursalumnes.Repository.CursRepository;
import com.vae.cursalumnes.model.Curs;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("moduls")
public class CursController {

  @Autowired
  CursRepository cursRepository;

  @GetMapping("cursos")
  public String getCursos(Model model) {
    model.addAttribute("cursos", cursRepository.findAll());
    return "curs-list";
  }

  @PostMapping("cursos/add")
  public String addCurso(@Valid Curs curs, Errors errors) {
    if (errors.hasErrors()) {
      return "formularis";
    }
    cursRepository.save(curs);

    return "redirect:/moduls/cursos";
  }
}
