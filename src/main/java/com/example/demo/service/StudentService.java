package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo repository;
	public Optional<Student> getStudent( long id) {
		return repository.findById(id);
	}
	public Student addStudent(Student student) {
		repository.save(student);
		return student;
	}
	public List<Student> getStudentByName(String name)
	{
		return repository.findByname(name);
	}
	public List<Student>getStudentByPercentage(int percentage)
	{
		return repository.findBypercentage(percentage);
		
	}
	public List<Student> getStudentsByNameAndCollege(String name,String college){
		return repository.searchByNameAndCollege(name, college);
	}
	public String updatePerBasedOnName(int p,String s)
	{
		String str=null;
		int i=repository.updatePercentageByName(p,s);
		if(i==1)
		{
			str="Successfully Upadted";
		}
		else
		{
			str="Sorry! could not update";
		}
		return str;
	}

}



