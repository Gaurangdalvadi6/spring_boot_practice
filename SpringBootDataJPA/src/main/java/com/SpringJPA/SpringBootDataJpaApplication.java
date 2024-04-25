package com.SpringJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.SpringJPA.model.Student;
import com.SpringJPA.repo.StudentRepository;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaApplication.class, args);
		
		StudentRepository repo = context.getBean(StudentRepository.class);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);
		
//		s1.setRollNo(101);
//		s1.setName("java");
//		s1.setMarks(91);
//		
//		s2.setRollNo(102);
//		s2.setName("python");
//		s2.setMarks(75);
//		
//		s3.setRollNo(103);
//		s3.setName("csharp");
//		s3.setMarks(56);
//		
//		repo.save(s2);
//		repo.save(s3);
		
		System.out.println(repo.findAll());
		System.out.println(repo.findById(102));
	}

}
