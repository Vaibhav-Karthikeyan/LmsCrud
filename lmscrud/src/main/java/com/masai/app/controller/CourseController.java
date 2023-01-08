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

import com.masai.app.entity.Course;
import com.masai.app.entity.Syllabus;
import com.masai.app.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	CourseService ser;
	
	@GetMapping("/course")
	public ResponseEntity<?> allCourse() {
		List<Course> course = ser.allCourse();
		return new ResponseEntity<List<Course>>(course, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/course")
	public ResponseEntity<?> newCourse(@Valid @RequestBody Course course){
		ser.addCourse(course);
		return new ResponseEntity<Course>(course,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/course")
	public ResponseEntity<?> updateCourse(@Valid @RequestBody Course course){
		ser.updateCourse(course);
		return new ResponseEntity<Course>(course,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<?> findStudent(@Valid @PathVariable int id) {
		Course course = ser.findCourse(id);
		return new ResponseEntity<Course>(course, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/course/{id}/syllabus")
	public ResponseEntity<?> newSyllabus(@Valid @RequestBody Syllabus syllabus,@PathVariable int id){
		Course course=ser.addSyllabus(id, syllabus);
		return new ResponseEntity<Course>(course,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/course/{id}/syllabus")
	public ResponseEntity<?> getSyllabus(@PathVariable int id){
		Syllabus syllabus=ser.findSyllabus(id);
		return new ResponseEntity<Syllabus>(syllabus,HttpStatus.ACCEPTED);
	}
}
