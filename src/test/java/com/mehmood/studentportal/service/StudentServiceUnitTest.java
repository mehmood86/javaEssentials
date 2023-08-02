package com.mehmood.studentportal.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mehmood.studentportal.model.Student;
import com.mehmood.studentportal.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceUnitTest {

	@Mock
	private StudentRepository studentRepository;	
	private StudentService studentService;
	
	@BeforeEach
	void setUp() {
		studentService = new StudentService(studentRepository);
	}
	
	@Test
	void canGetAllStudents() {
		// when 
		studentService.getAllStudents();
		
		//then
		verify(studentRepository).findAll();
		
	}
	
	@Test
	void canGetAStudent() {
		studentService.findStudentById(1);
		verify(studentRepository).findById(1);
	}

	@Test
	void findAll_should_return_student_list() {
		// Given
		Student student = new Student("Mehmood Ghaffar", 35, "male");

		// when calling the mocked repository method
		when(studentRepository.findAll()).thenReturn(List.of(student));
		List<Student> students = this.studentService.getAllStudents();

		// Then
		Assertions.assertEquals(List.of(student), students);
		verify(this.studentRepository).findAll();
	}

	@Test
	void findAll_should_return_student_list1() {
		// Given
		Student student = new Student("Mehmood Ghaffar", 35, "male");

		// when calling the mocked repository method
		when(studentRepository.findAll()).thenReturn(List.of(student));
		List<Student> students = this.studentService.getAllStudents();

		// Then
		Assertions.assertEquals(List.of(student), students);
		verify(this.studentRepository).findAll();
	}

	@Test
	void count_the_number_of_records() {
		List listMock = mock(List.class);
		when(listMock.add("as")).thenReturn(false);

		boolean added = listMock.add("as");
		assertThat(added).isFalse();
	}

}
