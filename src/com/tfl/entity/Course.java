package com.tfl.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Course {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String courseName;
	@Persistent
	private String shortCode;
	@Persistent
	private String description;
	@Persistent
	private double ratePerHour;
	@Persistent
	private int durationInHours;
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the shortCode
	 */
	public String getShortCode() {
		return shortCode;
	}
	/**
	 * @param shortCode the shortCode to set
	 */
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the ratePerHour
	 */
	public double getRatePerHour() {
		return ratePerHour;
	}
	/**
	 * @param ratePerHour the ratePerHour to set
	 */
	public void setRatePerHour(double ratePerHour) {
		this.ratePerHour = ratePerHour;
	}
	/**
	 * @return the durationInHours
	 */
	public int getDurationInHours() {
		return durationInHours;
	}
	/**
	 * @param durationInHours the durationInHours to set
	 */
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	/**
	 * @return the key
	 */
	Key getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	void setKey(Key key) {
		this.key = key;
	}
	
	
	
	
	
	

}
