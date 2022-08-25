package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Integer saveStudent(Student student) {
		Student saveStudent = studentRepository.save(student);
		return saveStudent.getsId();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudent(Integer sId) {
		return studentRepository.findById(sId);
	}


	@Override
	public void deleteStudent(Integer sId) {
		studentRepository.deleteById(sId);
	}

	@Override
	public Student updateStudent(Student student, Integer sId) {
		Student existingStudent = studentRepository.findById(sId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "sId", sId));

		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setsClass(student.getsClass());
		existingStudent.setsSubject(student.getsSubject());
		existingStudent.setDate(student.getDate());

		studentRepository.save(existingStudent);

		return existingStudent;

	}

	@Override
	public List<Student> getStudentByClass(Integer sClass) {
		
		return studentRepository.getStudentByClass(sClass);
	}


//
////	

}