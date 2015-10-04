package com.tfl.entity;

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
	private String jobDescription;
	@Persistent
	private int numberOfHours;
	@Persistent
	private String payableTo;
	
	private double finalAmount;
	@Persistent	
	private String billGeneratedBy;
	
	@Persistent
	private String billDate;
	
	@Persistent(defaultFetchGroup="true")
//	@Unowned
	private Contact contact;
	@Persistent(defaultFetchGroup="true")
//	@Unowned
	private Rates rate;
	
	
	
	
	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}
	/**
	 * @param jobDescription the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	/**
	 * @return the numberOfHours
	 */
	public int getNumberOfHours() {
		return numberOfHours;
	}
	/**
	 * @param numberOfHours the numberOfHours to set
	 */
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	/**
	 * @return the payableTo
	 */
	public String getPayableTo() {
		return payableTo;
	}
	/**
	 * @param payableTo the payableTo to set
	 */
	public void setPayableTo(String payableTo) {
		this.payableTo = payableTo;
	}
	/**
	 * @return the finalAmount
	 */
	public double getFinalAmount() {
		return finalAmount;
	}
	/**
	 * @param finalAmount the finalAmount to set
	 */
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	/**
	 * @return the billGeneratedBy
	 */
	public String getBillGeneratedBy() {
		return billGeneratedBy;
	}
	/**
	 * @param billGeneratedBy the billGeneratedBy to set
	 */
	public void setBillGeneratedBy(String billGeneratedBy) {
		this.billGeneratedBy = billGeneratedBy;
	}
	/**
	 * @return the billDate
	 */
	public String getBillDate() {
		return billDate;
	}
	/**
	 * @param billDate the billDate to set
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/**
	 * @return the rate
	 */
	public Rates getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(Rates rate) {
		this.rate = rate;
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
