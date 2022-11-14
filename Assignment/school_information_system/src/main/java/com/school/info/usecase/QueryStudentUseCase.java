package com.school.info.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.school.info.model.Student;

public interface QueryStudentUseCase {
	
	public List<Student> getAllStudents();
	public Student addStudent(Student student);
    public List<Student> searchStudentByDob(String searchText);
	public List<Student> searchStudentByEmail(String searchText);
	public List<Student> searchStudentByMobileNumber(String searchText);
	public List<Student> searchStudent(String searchText);
	public Optional<Student> findById(int id);
	public Student updateStudent(Integer id, Student updatedStudent);
}
