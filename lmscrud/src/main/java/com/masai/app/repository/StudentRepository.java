package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.app.entity.I_card;
import com.masai.app.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	@Query("Select i_card from Student where id=?1")
	public I_card findI_card(int id);
}
