package com.school.info.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="student")
public class Student{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "FirstName cannot be null.")
	@NotEmpty(message = "FirstName should not empty.")
	@Column(name = "first_name")
	private String firstName;
	

	@NotEmpty(message = "LastName should not empty.")
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
//	@FutureOrPresent(message = "DOB should not current or future date.")
	private Date dob;
	
	@Column(name = "course")
	@NotEmpty(message = "Course should not empty.")
	private String course;
	
	@Column(name = "email")
	@Email(message = "Email should be valid.")
	private String email;
	
	@Column(name = "mobile_number")
	@Min(value = 8, message = "Mobile Number should be valid.")
	private String mobileNumber;
	
	@Size(min = 5, max = 100, message = "About Me must be between 5 and 100 characters.")
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private String status;	
	
	public Student() {
		super();
	}

	public Student(int id, String firstName, String lastName, Date dob, String course, String email,
			String mobileNumber, String address, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.course = course;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	


}
