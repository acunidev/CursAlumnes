package com.vae.cursalumnes.Repository;

import com.vae.cursalumnes.model.Curs;
import com.vae.cursalumnes.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}