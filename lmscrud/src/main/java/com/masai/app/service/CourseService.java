package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.Course;
import com.masai.app.entity.Student;
import com.masai.app.entity.Syllabus;
import com.masai.app.entity.Teacher;
import com.masai.app.repository.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
	@Autowired
	CourseRepository rep;
	
	public Course addCourse(Course course) {
		return rep.save(course);
	}
	
	public List<Course> allCourse() {
		return rep.findAll();
	}
	
	public Course updateCourse(Course course) {
		return rep.save(course);
	}
	
	public Course findCourse(int id) {
		return rep.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	public Course addStudent(int id,Student student) {
		Course course=findCourse(id);
		course.getStudent().add(student);
		student.getCourse().add(course);
		return rep.save(course);
	}
	public Course addTeacher(int id,Teacher teacher) {
		Course course=findCourse(id);
		course.setTeacher(teacher);
		teacher.getCourse().add(course);
		return rep.save(course);
	}
	public Course addSyllabus(int id,Syllabus syllabus) {
		Course course=findCourse(id);
		course.setSyllabus(syllabus);
		syllabus.setCourse(course);
		return rep.save(course);
	}
	
	public List<Student> findStudent(int id) {
		return rep.findStudents(id);
	}
	public Teacher findTeacher(int id) {
		return rep.findTeacher(id);
	}
	public Syllabus findSyllabus(int id) {
		return rep.findSyllabus(id);
	}
}
