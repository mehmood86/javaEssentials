package com.mehmood.studentportal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mehmood.studentportal.Dtos.StudentDTO;
import com.mehmood.studentportal.model.Student;
import com.mehmood.studentportal.repository.StudentRepository;

@Service
public class StudentService {
	// This service implementation is not yet in use

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student findStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void deleteBy(int id) {
		studentRepository.deleteById(id);
	}
	
	
	public List<StudentDTO> getAllStudentsHavingNamesOnly() {
		List<Student> students = studentRepository.findAll();
		return students.stream()
				.map(this::fromEntityToDTO)
				.collect(Collectors.toList());
	
	}
	
	public StudentDTO getStudentHavingNameOnlyById(int id) {
		Student student =  studentRepository.findById(id).orElse(null);
		return fromEntityToDTO(student);
		
	}
	
	// Helper method, converting Entity to DTO
	public StudentDTO fromEntityToDTO(Student student) {
		return new StudentDTO(student.getId(),student.getName());
	}
	
}
