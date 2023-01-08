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

import com.masai.app.entity.Teacher;
import com.masai.app.service.TeacherService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class TeacherController {
	
	@Autowired
	TeacherService ser;
	
	@GetMapping("/teacher")
	public ResponseEntity<?> allTeacher() {
		List<Teacher> teacher = ser.allTeacher();
		return new ResponseEntity<List<Teacher>>(teacher, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/teacher")
	public ResponseEntity<?> newTeacher(@Valid @RequestBody Teacher teacher){
		ser.addTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/teacher")
	public ResponseEntity<?> updateTeacher(@Valid @RequestBody Teacher teacher){
		ser.updateTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/teacher/{id}")
	public ResponseEntity<?> allTeacher(@PathVariable int id) {
		Teacher teacher = ser.findTeacher(id);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.ACCEPTED);
	}
}
