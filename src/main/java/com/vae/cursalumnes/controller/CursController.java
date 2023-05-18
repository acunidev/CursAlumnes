package com.vae.cursalumnes.controller;

import com.vae.cursalumnes.Repository.CursRepository;
import com.vae.cursalumnes.model.Curs;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class CursController {
  final CursRepository cursRepository;

  public CursController(CursRepository cursRepository) {
    this.cursRepository = cursRepository;
  }

  @GetMapping("cursos")
  public String getFirms(Model model) {
    model.addAttribute("cursos", cursRepository.findAll());
    return "curs-list";
  }

  @GetMapping("add")
  public String mostrarFormulariEmpresa(Model model) {
    Curs curs = new Curs();
    model.addAttribute("curs", curs);
    return "formularis";
  }

  @PostMapping("firm/registration")
  public String altaEmpresa(@Valid Curs curs, Errors errors) {
    if (errors.hasErrors()) {
      return "add-course";
    }
    cursRepository.save(curs);
    return "redirect:/api/cursos";
  }
}
