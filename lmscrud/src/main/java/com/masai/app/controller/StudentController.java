package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.entity.Student;
import com.masai.app.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	StudentService ser;
	
	@GetMapping("/student")
	public ResponseEntity<?> allStudent() {
		List<Student> student = ser.allStudent();
		return new ResponseEntity<List<Student>>(student, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/student")
	public ResponseEntity<?> newStudent(@Valid @RequestBody Student student) {
		ser.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/student")
	public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student) {
		ser.updateStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> findStudent(@Valid @PathVariable int id) {
		Student student = ser.findStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
	}
}
