package com.school.info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.info.constant.Status;
import com.school.info.model.Student;
import com.school.info.model.StudentRepository;
import com.school.info.usecase.QueryStudentUseCase;


@Service
public class StudentService implements QueryStudentUseCase{
	
	@Autowired
	StudentRepository studentRepository;
	
	

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
		
	}

	@Override
	public Student addStudent(Student student) {
		student.setStatus(Status.PENDING.toString());
		return studentRepository.save(student);
		
	}

	@Override
	public List<Student> searchStudentByDob(String searchText) {
		// TODO Auto-generated method stub
		return studentRepository.searchStudentByDob(searchText);
	}

	@Override
	public List<Student> searchStudentByEmail(String searchText) {
		// TODO Auto-generated method stub
		return studentRepository.searchStudentByEmail(searchText);
	}

	@Override
	public List<Student> searchStudentByMobileNumber(String searchText) {
		// TODO Auto-generated method stub
		return studentRepository.searchStudentByMobileNumber(searchText);
	}

	@Override
	public List<Student> searchStudent(String searchText) {
		// TODO Auto-generated method stub
		return studentRepository.searchStudent(searchText);
	}

	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}
	
	public Student updateStudent(Integer id, Student updatedStudent){
		Student student = studentRepository.findById(id)
				.orElseThrow();	

		student.setFirstName(updatedStudent.getFirstName());
		student.setLastName(updatedStudent.getLastName());
		student.setEmail(updatedStudent.getEmail());
		student.setDob(updatedStudent.getDob());
		student.setCourse(updatedStudent.getCourse());
		student.setMobileNumber(updatedStudent.getMobileNumber());
				
		Student _student = studentRepository.save(student);
		return _student;
	}
}
