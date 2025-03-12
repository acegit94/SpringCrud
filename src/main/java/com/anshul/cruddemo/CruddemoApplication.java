package com.anshul.cruddemo;

import com.anshul.cruddemo.dao.StudentDAO;
import com.anshul.cruddemo.dao.StudentDAOImpl;
import com.anshul.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//deleteStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};

	}

	private void readStudent(StudentDAO studentDAO) {
		//Get student by id
		System.out.printf("Fetching student with id %s", studentDAO.findById(3).toString());
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create student object
		System.out.println("Creating a student");
		Student student = new Student("John","Doe","johndoe@gmail.com");
		Student student2 = new Student("Jane","Day","janeday@gmail.com");
		Student student3 = new Student("Joe","Dane","joedane@gmail.com");

		//Save student object
		System.out.println("Saving a student");
		studentDAO.save(student);
		studentDAO.save(student2);
		studentDAO.save(student3);

		//Print student id
		System.out.printf("Saved student. Generated id: %d", student.getId());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//Accept user input for student id
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student Id");
		int studentId = scanner.nextInt();
		System.out.println();
		System.out.println("Deleting student");
		//Perform delete
		studentDAO.delete(studentId);

	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println(studentDAO.deleteAll());
	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> allStudents = studentDAO.findAll();

		for(Student student: allStudents){
			System.out.println(student);
		}

	}

	private void updateStudent(StudentDAO studentDAO){
		//Retrieve student by primary key id
		Student student = studentDAO.findById(15);

		//Set student name
		student.setFirstName("John");

		//Perform update
		studentDAO.update(student);

		//Display the updated student
		System.out.println(student);
	}


	private void queryStudentsByLastName(StudentDAO studentDAO){
		System.out.println(studentDAO.findByLastName("Day"));
	}



}
