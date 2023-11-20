package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Student;

import jakarta.transaction.Transactional;

public interface StudentRepo extends JpaRepository<Student,Long> 
{

	List<Student>findByname(String str);
	List<Student>findBypercentage(int p);
	@Query("select u from Student u where u.name=?1 and u.percentage=?2")
	List<Student> searchByNameAndCollege(String s1,String s2);
	
	
	@Modifying
	@Transactional
	@Query(value="select u from Student u where u.name=?1 and u.percentage=?2")
	public int updatePercentageByName(int percentage,String name);
	

	}

