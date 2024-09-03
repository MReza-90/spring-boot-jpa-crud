package com.code2go.cruddemo;

import com.code2go.cruddemo.dao.StudentDAO;
import com.code2go.cruddemo.dao.StudentDAOImpl;
import com.code2go.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRows=studentDAO.deleteAl();
		System.out.println(numRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id=1;
		studentDAO.deleteStudent(id);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int id=1;
		Student theStudent=studentDAO.findById(id);
		theStudent.setFirstName("Raynold");
		studentDAO.update(theStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> students=studentDAO.findByLastName("cruise");

		for(Student theStudent: students){
			System.out.println(theStudent);
		}
	}

	private void queryForstudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> studentList=studentDAO.findAll();

		//display the list of  the students
		for( Student student: studentList){
			System.out.println(student);
		}

	}


	private void readStudent(StudentDAO studentDAO){

		//create a student object
		System.out.println("creating a new student...");
		Student tempstudent=new Student("Tom","Cruise","Tom.Cruise@tly.com");


		//save the student
		System.out.println("saving the student ... ");
		studentDAO.save(tempstudent);

		// display the id of the saved student
		int theId=tempstudent.getId();
		System.out.println("saved student id = "+ theId);

		//retrieve the student based on the id
		Student theStudent=studentDAO.findById(theId);

		//display the student
		System.out.println(theStudent);


	}
	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("creating a new student ...");
		Student tempStudent= new Student("John","Doe","john.doe@anonymous.com");

		//save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		System.out.println("saved student's id = "+tempStudent.getId());
	}
}
