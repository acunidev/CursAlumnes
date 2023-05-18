package com.vae.cursalumnes.controller;

import com.vae.cursalumnes.Repository.StudentRepository;
import com.vae.cursalumnes.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("alumnes")
public class StudentController {

  @Autowired
  StudentRepository studentRepository;

  @GetMapping("students")
  public String getStudents(Model model) {
    model.addAttribute("students", studentRepository.findAll());
    return "student-list";
  }

  @PostMapping("students/afegir")
  public String addStudent(@ModelAttribute @Valid Student student, Errors errors) {
    if (errors.hasErrors()) {
      return "formularis";
    }
    studentRepository.save(student);
    return "redirect:/alumnes/students";
  }

}
