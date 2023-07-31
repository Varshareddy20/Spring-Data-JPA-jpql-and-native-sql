package com.varsha.springprj.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.varsha.springprj.jpqlandnativesql.entities.Student;
import com.varsha.springprj.jpqlandnativesql.repose.StudentRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
class JpqlandnativesqlApplicationTests {
	
	@Autowired
	StudentRepository repository;
	
	@Test
	public void testStudentCreate() {
		Student student=new Student();
		student.setFirstName("Varsha");
		student.setLastName("Julakanti");
		student.setScore(90);
		repository.save(student);
		
		Student student2=new Student();
		student2.setFirstName("Jayaan");
		student2.setLastName("Amanaganti");
		student2.setScore(80);
		repository.save(student2);
		
		Student student3=new Student();
		student3.setFirstName("Arya");
		student3.setLastName("Gurram");
		student3.setScore(95);
		repository.save(student3);
			
	}
	
	@Test
	public void testFindAllStudents(){
		System.out.println(repository.findAllStudents());
		
	}
	
	@Test
	public void testFindAllStudentsPartial() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}
	
	@Test
	public void testFindAllStudentsByLastName() {
		System.out.println(repository.findAllStudentsByLastName("Julakanti"));
	}
	
	@Test
	public void testFindAllStudentsByScores() {
		System.out.println(repository.findStudentsForGivenScores(80,100));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteStudentsByFirstName() {
		repository.deleteStudentsByFirstName("Jayaan");
		
	}
}
