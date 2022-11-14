package com.school.info.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.info.model.Student;
import com.school.info.usecase.QueryStudentUseCase;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class StudentController{
	
	@Autowired
	QueryStudentUseCase queryStudentUseCase;

	@GetMapping("/getStudents")
	public List<Student> getStudent() {
		return (List<Student>) queryStudentUseCase.getAllStudents();		
	}
	
	@PostMapping("/addStudent")
	public Student addStudent (@Validated @RequestBody Student student) {
		return queryStudentUseCase.addStudent(student);
	}
	
	@GetMapping("/search")
	public List<Student> searchStudent(@RequestParam("searchText") String searchText ) {
		return (List<Student>) queryStudentUseCase.searchStudent(searchText);		
	}
	
	
	@GetMapping
	public Student getById(int id) {
		Student _student = new Student();
		Optional<Student> student = queryStudentUseCase.findById(id);
		if( student.isPresent()) {
			 _student = student.get();			
		}
		return _student;		
	}
	
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){		
		return queryStudentUseCase.updateStudent(id, student);
		
	}
}
