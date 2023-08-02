package com.mehmood.studentportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mehmood.studentportal.model.Address;
import com.mehmood.studentportal.model.Student;
import com.mehmood.studentportal.repository.AddressRepository;
import com.mehmood.studentportal.repository.StudentRepository;

@SpringBootApplication
public class StudentportalApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
		studentRepository.deleteAllInBatch();
		addressRepository.deleteAllInBatch();

		// ====================================
		// Create Student instance
		Student student1 = new Student("Mehmood Ghaffar", 35, "male");
		Student student2 = new Student("Sohail Ahmed", 25, "male");

		// Create Address instance
		Address address1 = new Address("Muster str. 112", "Karlsruhe");
		Address address2 = new Address("Muster str. 100", "Berlin");

		// Set addresses for students
		student1.setAddress(address1);
		student2.setAddress(address2);

		List<Student> students = List.of(student1, student2);

		studentRepository.saveAll(students);
		System.out.println("Dummy students data seeded");
	}

}
