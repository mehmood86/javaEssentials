package com.mehmood.studentportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmood.studentportal.Dtos.StudentDTO;
import com.mehmood.studentportal.model.Student;
import com.mehmood.studentportal.service.StudentService;

@RestController
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	//DTO | return only desired fields
	@GetMapping("/studentsFiltered")
	List<StudentDTO> getAllFiltered(){		
		return studentService.getAllStudentsHavingNamesOnly();
	}
	
	@RequestMapping("/studentsFiltered/{id}")
	StudentDTO getStudentDTOById(@PathVariable int id) {
		return studentService.getStudentHavingNameOnlyById(id);
	}
	
	//======================================
	
	// Return All fields of Entity
	@GetMapping("/students")
	List<Student> getAll(){		
		return studentService.getAllStudents();
	}
	
	@RequestMapping("/students/{id}")
	Student getStudentById(@PathVariable int id) {
		return studentService.findStudentById(id);
	}
}
