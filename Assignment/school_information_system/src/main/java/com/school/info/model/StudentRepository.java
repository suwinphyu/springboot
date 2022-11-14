package com.school.info.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{	
	
	@Query(value ="select s.* from student s where s.dob LIKE '%:searchText%'", nativeQuery = true )
	public List<Student> searchStudentByDob(String searchText);
	
	@Query(value ="select s.* from student s where s.email LIKE '%:searchText%'", nativeQuery = true )
	public List<Student> searchStudentByEmail(String searchText);
	
	@Query(value ="select s.* from student s where s.mobile_number LIKE '%:searchText%'", nativeQuery = true )
	public List<Student> searchStudentByMobileNumber(String searchText);
	
	@Query(value ="select s.* from student s where s.first_name LIKE '%:searchText%' OR s.last_name LIKE '%:searchText%' OR s.address LIKE '%:searchText%'", nativeQuery = true )
	public List<Student> searchStudent(String searchText);
	

}
