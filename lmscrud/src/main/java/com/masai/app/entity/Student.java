package com.masai.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","course"})
public class Student {
	@Id
	@GeneratedValue
	private int id;
	@Pattern(regexp="^[A-Z][a-z]*",message = "{firstName.invalid}")
	private String name;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="student")
	private I_card i_card;
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="student")
	private List<Course> course=new ArrayList<>();
}