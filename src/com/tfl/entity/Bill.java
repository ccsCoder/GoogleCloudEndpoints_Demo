/**
 * 
 */
package com.tfl.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author neo
 *
 */
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Bill {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private Long billID;
	@Persistent
	private Enrollments enrollments;
	/**
	 * @param billID
	 * @param enrollments
	 */
	public Bill(Long billID, Enrollments enrollments) {
		super();
		this.billID = billID;
		this.enrollments = enrollments;
	}
	/**
	 * @return the billID
	 */
	public Long getBillID() {
		return billID;
	}
	/**
	 * @param billID the billID to set
	 */
	public void setBillID(Long billID) {
		this.billID = billID;
	}
	/**
	 * @return the enrollments
	 */
	public Enrollments getEnrollments() {
		return enrollments;
	}
	/**
	 * @param enrollments the enrollments to set
	 */
	public void setEnrollments(Enrollments enrollments) {
		this.enrollments = enrollments;
	}
	
	
	

}
