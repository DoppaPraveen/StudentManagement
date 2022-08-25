package com.student.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sId;
	private String firstName;
	private String lastName;
	private Integer sClass;
	private String sSubject;
	private Date date;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
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

	public Integer getsClass() {
		return sClass;
	}

	public void setsClass(Integer sClass) {
		this.sClass = sClass;
	}

	public String getsSubject() {
		return sSubject;
	}

	public void setsSubject(String sSubject) {
		this.sSubject = sSubject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student(Integer sId, String firstName, String lastName, Integer sClass, String sSubject, Date date) {
		super();
		this.sId = sId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sClass = sClass;
		this.sSubject = sSubject;
		this.date = date;
	}

	public Student() {
		super();
	}

}
