package com.tfl.entity;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Bill {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private List<Enrollment> enrollments;
	/**
	 * @return the enrollments
	 */
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	/**
	 * @param enrollments the enrollments to set
	 */
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
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
