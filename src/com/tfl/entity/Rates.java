package com.tfl.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Rates {
//	@PrimaryKey
//	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
//	private Key key;
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String rateType;
	
	@Persistent
	private String customerCurrencyCode;
	
	@Persistent
	private String nativeCurrencyCode;
	
	@Persistent
	private double hourlyRate;
	
	@Persistent
	private double taxPercentage;
	
	@Persistent
	private double conversionRate;

	/**
	 * @return the rateType
	 */
	public String getRateType() {
		return rateType;
	}

	/**
	 * @param rateType the rateType to set
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	/**
	 * @return the customerCurrencyCode
	 */
	public String getCustomerCurrencyCode() {
		return customerCurrencyCode;
	}

	/**
	 * @param customerCurrencyCode the customerCurrencyCode to set
	 */
	public void setCustomerCurrencyCode(String customerCurrencyCode) {
		this.customerCurrencyCode = customerCurrencyCode;
	}

	/**
	 * @return the nativeCurrencyCode
	 */
	public String getNativeCurrencyCode() {
		return nativeCurrencyCode;
	}

	/**
	 * @param nativeCurrencyCode the nativeCurrencyCode to set
	 */
	public void setNativeCurrencyCode(String nativeCurrencyCode) {
		this.nativeCurrencyCode = nativeCurrencyCode;
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * @return the taxPercentage
	 */
	public double getTaxPercentage() {
		return taxPercentage;
	}

	/**
	 * @param taxPercentage the taxPercentage to set
	 */
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	/**
	 * @return the conversionRate
	 */
	public double getConversionRate() {
		return conversionRate;
	}

	/**
	 * @param conversionRate the conversionRate to set
	 */
	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((rateType == null) ? 0 : rateType.hashCode());
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
		if (!(obj instanceof Rates))
			return false;
		Rates other = (Rates) obj;
		if (rateType == null) {
			if (other.rateType != null)
				return false;
		} else if (!rateType.equals(other.rateType))
			return false;
		return true;
	}
	
		
	
	

}
