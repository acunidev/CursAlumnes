package com.vae.cursalumnes.controller;

import com.vae.cursalumnes.Repository.CursRepository;
import com.vae.cursalumnes.Repository.StudentRepository;
import com.vae.cursalumnes.model.Curs;
import com.vae.cursalumnes.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class FormsController {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  CursRepository cursRepository;

  @GetMapping("registerForm")
  public String mostrarFormulariProjecte(Model model) {
    model.addAttribute("curs", new Curs());
    final Student attributeValue = new Student();
    model.addAttribute("student", attributeValue);
    model.addAttribute("cursosList", cursRepository.findAll());

    return "formularis";
  }

}
