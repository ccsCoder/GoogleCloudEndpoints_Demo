package com.tfl.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Student {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String name;
	@Persistent
	private int age;
	@Persistent
	private String lastQualification;
	
	
	
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the lastQualification
	 */
	public String getLastQualification() {
		return lastQualification;
	}
	/**
	 * @param lastQualification the lastQualification to set
	 */
	public void setLastQualification(String lastQualification) {
		this.lastQualification = lastQualification;
	}
	
	
	
	
}
