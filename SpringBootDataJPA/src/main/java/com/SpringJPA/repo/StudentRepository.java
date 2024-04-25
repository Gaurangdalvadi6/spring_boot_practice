package com.SpringJPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringJPA.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
