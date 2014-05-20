package com.tfl.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Course {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Long courseID;
	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}
	/**
	 * @param courseID
	 * @param courseName
	 * @param duration
	 * @param cost
	 */
	public Course(Long courseID, String courseName, int duration, double cost) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.duration = duration;
		this.cost = cost;
	}
	@Persistent
	String courseName;
	@Persistent
	int duration;
	@Persistent
	double cost;
	
	
	
	/**
	 * @return the courseID
	 */
	public Long getCourseID() {
		return courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + duration;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (duration != other.duration)
			return false;
		return true;
	}
	
	
}
