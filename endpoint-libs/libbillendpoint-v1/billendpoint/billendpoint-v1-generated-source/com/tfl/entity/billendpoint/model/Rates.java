/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-08-03 17:34:38 UTC)
 * on 2015-10-04 at 04:45:11 UTC 
 * Modify at your own risk.
 */

package com.tfl.entity.billendpoint.model;

/**
 * Model definition for Rates.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the billendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Rates extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double conversionRate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String customerCurrencyCode;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double hourlyRate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String nativeCurrencyCode;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String rateType;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double taxPercentage;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getConversionRate() {
    return conversionRate;
  }

  /**
   * @param conversionRate conversionRate or {@code null} for none
   */
  public Rates setConversionRate(java.lang.Double conversionRate) {
    this.conversionRate = conversionRate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCustomerCurrencyCode() {
    return customerCurrencyCode;
  }

  /**
   * @param customerCurrencyCode customerCurrencyCode or {@code null} for none
   */
  public Rates setCustomerCurrencyCode(java.lang.String customerCurrencyCode) {
    this.customerCurrencyCode = customerCurrencyCode;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getHourlyRate() {
    return hourlyRate;
  }

  /**
   * @param hourlyRate hourlyRate or {@code null} for none
   */
  public Rates setHourlyRate(java.lang.Double hourlyRate) {
    this.hourlyRate = hourlyRate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getNativeCurrencyCode() {
    return nativeCurrencyCode;
  }

  /**
   * @param nativeCurrencyCode nativeCurrencyCode or {@code null} for none
   */
  public Rates setNativeCurrencyCode(java.lang.String nativeCurrencyCode) {
    this.nativeCurrencyCode = nativeCurrencyCode;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getRateType() {
    return rateType;
  }

  /**
   * @param rateType rateType or {@code null} for none
   */
  public Rates setRateType(java.lang.String rateType) {
    this.rateType = rateType;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getTaxPercentage() {
    return taxPercentage;
  }

  /**
   * @param taxPercentage taxPercentage or {@code null} for none
   */
  public Rates setTaxPercentage(java.lang.Double taxPercentage) {
    this.taxPercentage = taxPercentage;
    return this;
  }

  @Override
  public Rates set(String fieldName, Object value) {
    return (Rates) super.set(fieldName, value);
  }

  @Override
  public Rates clone() {
    return (Rates) super.clone();
  }

}