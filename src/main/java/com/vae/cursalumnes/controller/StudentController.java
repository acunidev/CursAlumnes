package com.vae.cursalumnes.controller;

import com.vae.cursalumnes.model.Student;
import com.vae.cursalumnes.service.StudentService;
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

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("students")
  public String getStudents(Model model) {
    model.addAttribute("students", studentService.getStudents());
    return "student-list";
  }

  @PostMapping("students/afegir")
  public String addStudent(@ModelAttribute @Valid Student student, Errors errors) {
    if (errors.hasErrors()) {
      return "formularis";
    }
    studentService.saveStudent(student);
    return "redirect:/alumnes/students";
  }

}
