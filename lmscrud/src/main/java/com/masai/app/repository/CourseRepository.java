package com.masai.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.app.entity.Course;
import com.masai.app.entity.Student;
import com.masai.app.entity.Teacher;
import com.masai.app.entity.Syllabus;

public interface CourseRepository extends JpaRepository<Course,Integer> {
	
	@Query("Select student from Course where id=?1")
	public List<Student> findStudents(int id);
	
	@Query("Select teacher from Course where id=?1")
	public Teacher findTeacher(int id);
	
	@Query("Select syllabus from Course where id=?1")
	public Syllabus findSyllabus(int id);
}
