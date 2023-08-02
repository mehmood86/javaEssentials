package com.mehmood.studentportal.repository;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mehmood.studentportal.model.Student;
import com.mehmood.studentportal.service.StudentService;

@ExtendWith(MockitoExtension.class)
class StudentRepositoryTest {

	@Mock
	StudentRepository studentRepository;

	@InjectMocks
	private StudentService studentService;

	// For now, it will work without beforeEach block also
	@BeforeEach
	void setup() {
		this.studentService = new StudentService(studentRepository);
	}

	@Test
	void findAll() {
		studentService.getAllStudents();
		verify(studentRepository).findAll();
	}
	
	@Test
	void findByID() {
		studentService.findStudentById(1);
		verify(studentRepository).findById(1);
	}
	
	@Test
	void countTest() {
		Student student = new Student("Mehmood Ghaffar", 30, "male");
		studentService.save(student);
		verify(studentService.save(student));	
		
	}
	
	

}
