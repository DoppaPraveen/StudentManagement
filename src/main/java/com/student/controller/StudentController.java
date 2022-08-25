package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.IStudentService;

@RestController
public class StudentController {

	
	@Autowired
	IStudentService studentService;

	@PostMapping("/saveStudent")
	Integer createStudent(@RequestBody Student student) {

		Integer eId = studentService.saveStudent(student);
		System.out.println(eId);
		return eId;

	}

	@GetMapping("/allStudents")
	public List<Student> getStudents() {
		return studentService.getAllStudents();

	}

	@GetMapping("/getStudent/{sId}")
	public Optional<Student> getStudent(@PathVariable Integer sId) {
		Optional<Student> student = studentService.getStudent(sId);
		return student;
	}

	@DeleteMapping("/student/{sId}")

	public ResponseEntity<Student> deleteStudent(@PathVariable("sId") Integer sId) {
		System.out.println(sId);
		ResponseEntity<Student> responseEntity = new ResponseEntity<Student>(HttpStatus.OK);
		try {

			studentService.deleteStudent(sId);

		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

		}
		return responseEntity;

	}

	@PutMapping("/update/{sId}")
	public ResponseEntity<Student> updateStudent(@PathVariable("sId") Integer sId, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, sId), HttpStatus.OK);

	}
//
	@GetMapping("/getStudentbyClass/{sClass}")
	public List<Student>getStudentClass(@PathVariable Integer sClass){
		List<Student>student=studentService.getStudentByClass(sClass);
		return student;


}}


