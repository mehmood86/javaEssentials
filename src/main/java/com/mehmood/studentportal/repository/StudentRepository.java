package com.mehmood.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmood.studentportal.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
