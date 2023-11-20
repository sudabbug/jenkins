package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
 
	@Autowired
	StudentService service;
	
	@GetMapping("/getStudents/{id}")
	public Optional<Student> getStudentDetails(@PathVariable long id) {
		return service.getStudent(id);
	}
	
	@PostMapping("/savestudent")
	public Student  saveStudentDetails(@RequestBody Student s) 
	{
		try 
		{
			service.addStudent(s);
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	
	@GetMapping("/get-students/name/{name}")
	public List<Student> getStudents(@PathVariable String name){
		return service.getStudentByName(name);
	}
	@GetMapping("/get-students/percentage/{percentage}")
	public List<Student> getStudentsPercentage(@PathVariable int percentage){
		return service.getStudentByPercentage(percentage);
	}
	@GetMapping("/get-students/name-college/{name}/{college}")
	public List<Student> getStudentsNameCollege(@PathVariable String name,@PathVariable String college){
		return service.getStudentsByNameAndCollege(name,college);
	}
}