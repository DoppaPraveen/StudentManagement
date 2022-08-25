package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.student.model.Student;
@Component
public interface IStudentService {
	
	Integer saveStudent (Student student);
	
	public List<Student>getAllStudents();
	
	Optional<Student>getStudent(Integer sId);
	
	
	public void deleteStudent (Integer sId);
	
	Student updateStudent(Student student, Integer sId);

	List<Student>getStudentByClass(Integer sClass);

}


