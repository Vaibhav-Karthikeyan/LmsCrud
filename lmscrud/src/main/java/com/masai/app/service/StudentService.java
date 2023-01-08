package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.I_card;
import com.masai.app.entity.Student;
import com.masai.app.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {
	@Autowired
	StudentRepository rep;
	
	public Student addStudent(Student student) {
		return rep.save(student);
	}
	
	public List<Student> allStudent() {
		return rep.findAll();
	}
	
	public Student updateStudent(Student student) {
		return rep.save(student);
	}
	
	public Student findStudent(int id) {
		return rep.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public Student addI_card(int id,I_card card) {
		Student student=findStudent(id);
		student.setI_card(card);
		card.setStudent(student);
		return rep.save(student);
	}
	
}
