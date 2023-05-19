package com.vae.cursalumnes.service;

import com.vae.cursalumnes.Repository.StudentRepository;
import com.vae.cursalumnes.exceptions.ResourceNotFoundException;
import com.vae.cursalumnes.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public Student getStudentsById(long id) {
    Optional<Student> student = studentRepository.findById(id);
    return student.orElse(null);
  }

  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  public Student updateStudent(Student student)
      throws ResourceNotFoundException {
    Optional<Student> oldStudent = studentRepository
        .findById(student.getStudentId());
    if (oldStudent.isEmpty()) {
      throw new ResourceNotFoundException("Resource Not Found!!!!");
    } else {
      Student studentToUpdate = oldStudent.get();
      studentToUpdate.setNom(student.getNom());
      studentToUpdate.setCognom(student.getNom());
      return studentRepository.save(studentToUpdate);
    }
  }


}
