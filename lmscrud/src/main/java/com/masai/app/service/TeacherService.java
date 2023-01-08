package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.Teacher;
import com.masai.app.repository.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository rep;
	
	public Teacher addTeacher(Teacher teacher) {
		return rep.save(teacher);
	}

	
	public List<Teacher> allTeacher() {
		return rep.findAll();
	}
	
	public Teacher updateTeacher(Teacher teacher) {
		return rep.save(teacher);
	}
	
	public Teacher findTeacher(int id) {
		return rep.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
}
