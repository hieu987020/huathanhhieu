package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMutipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByFirstName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAll(studentDAO);
		};





	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Delete all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO){

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName(("John"));

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student " + myStudent);
	}
	private void queryForStudentsByFirstName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByFirstName("Than Dong");

		// display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student obj ... ");
		Student tempStudent = new Student("Thanh Hieu", "Nguyen", "hieu987020@gmail.com");
		// save the student
		System.out.println("Saved student");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generate id: " + theId);
		// retrieve student based on the id: primary key
		System.out.println("Retrieve student with id: " + theId);
		Student student = studentDAO.findById(theId);
		// display student
		System.out.println("Found the student: " + student);
	}

	private void createMutipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Than Dong", "Nguyen", "hieu987020@gmail.com");
		Student tempStudent2 = new Student("Chua Te", "Nguyen", "hieu987020@gmail.com");
		Student tempStudent3 = new Student("Hot Girl", "Nguyen", "hieu987020@gmail.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Thanh Hieu", "Nguyen", "hieu987020@gmail.com");
		// save the student object
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("Saved student. Generate id:" + tempStudent.getId());
	}
}















