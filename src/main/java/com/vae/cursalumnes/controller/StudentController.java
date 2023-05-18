package com.vae.cursalumnes.controller;

import com.vae.cursalumnes.Repository.StudentRepository;
import com.vae.cursalumnes.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("api")
public class StudentController {

  final StudentRepository studentRepository;

  public StudentController(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @GetMapping("estudiants")
  public String getStudents(Model model) {
    model.addAttribute("students", studentRepository.findAll());
    return "student-list";
  }

  @GetMapping("add")
  public String mostrarFormulariProjecte(Model model) {
    Student student = new Student();
    model.addAttribute("student", student);
    return "formularis";
  }

  @PostMapping("students/registration")
  public String altaProjecte(@Valid Student student, Errors errors) {
    if (errors.hasErrors()) {
      return "formularis";
    }
    studentRepository.save(student);
    return "redirect:/api/estudiants";
  }
}
