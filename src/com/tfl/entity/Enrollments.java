package com.tfl.entity;

import java.util.List;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Enrollments {
	@ForeignKey()
	@Persistent
	private Student student;
	@Persistent
	private List<Course> courses;
	
	public Enrollments(Student student, List<Course> courses) {
		super();
		this.student = student;
		this.courses = courses;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
