package com.masai.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String coursename; 
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Syllabus syllabus;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Teacher teacher;
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Student> student=new ArrayList<>();
}
