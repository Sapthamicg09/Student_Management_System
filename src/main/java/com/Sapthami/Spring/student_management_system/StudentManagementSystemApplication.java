package com.Sapthami.Spring.student_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Sapthami.Spring.student_management_system.entity.Student;
import com.Sapthami.Spring.student_management_system.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args)
	{
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepositoty;
	@Override
	public void run(String... args) throws Exception
	{
//		Student student1 = new Student("Ramesh" , "Fadatare" , "ramesh@gmail.com");
//		studentRepositoty.save(student1);
//		
//		Student student2 =  new Student("Sanjay" , "Jadav" , "sanjay@gmail.com");
//		studentRepositoty.save(student2);
//		
//		Student student3 =  new Student("tony" , "stark" , "tony@gmail.com");
//		studentRepositoty.save(student3);
		
	}

}
