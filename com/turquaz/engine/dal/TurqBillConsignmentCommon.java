package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBillConsignmentCommon implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.math.BigDecimal discountAmount;

    /** persistent field */
    private java.math.BigDecimal vatAmount;

    /** persistent field */
    private java.math.BigDecimal charges;

    /** persistent field */
    private java.math.BigDecimal totalAmount;

    /** persistent field */
    private java.math.BigDecimal specialVatAmount;

    /** persistent field */
    private java.lang.String billDocumentNo;

    /** persistent field */
    private java.lang.String consignmentDocumentNo;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private int discountRate;

    /** persistent field */
    private java.math.BigDecimal discountAmountInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal vatAmountInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal chargesInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal totalAmountInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal specialVatAmountInForeignCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqConsignments;

    /** persistent field */
    private Set turqBills;

    /** full constructor */
    public TurqBillConsignmentCommon(java.math.BigDecimal discountAmount, java.math.BigDecimal vatAmount, java.math.BigDecimal charges, java.math.BigDecimal totalAmount, java.math.BigDecimal specialVatAmount, java.lang.String billDocumentNo, java.lang.String consignmentDocumentNo, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, int discountRate, java.math.BigDecimal discountAmountInForeignCurrency, java.math.BigDecimal vatAmountInForeignCurrency, java.math.BigDecimal chargesInForeignCurrency, java.math.BigDecimal totalAmountInForeignCurrency, java.math.BigDecimal specialVatAmountInForeignCurrency, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqConsignments, Set turqBills) {
        this.discountAmount = discountAmount;
        this.vatAmount = vatAmount;
        this.charges = charges;
        this.totalAmount = totalAmount;
        this.specialVatAmount = specialVatAmount;
        this.billDocumentNo = billDocumentNo;
        this.consignmentDocumentNo = consignmentDocumentNo;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.discountRate = discountRate;
        this.discountAmountInForeignCurrency = discountAmountInForeignCurrency;
        this.vatAmountInForeignCurrency = vatAmountInForeignCurrency;
        this.chargesInForeignCurrency = chargesInForeignCurrency;
        this.totalAmountInForeignCurrency = totalAmountInForeignCurrency;
        this.specialVatAmountInForeignCurrency = specialVatAmountInForeignCurrency;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqCurrentCard = turqCurrentCard;
        this.turqConsignments = turqConsignments;
        this.turqBills = turqBills;
    }

    /** default constructor */
    public TurqBillConsignmentCommon() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.math.BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }

    public void setDiscountAmount(java.math.BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public java.math.BigDecimal getVatAmount() {
        return this.vatAmount;
    }

    public void setVatAmount(java.math.BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }

    public java.math.BigDecimal getCharges() {
        return this.charges;
    }

    public void setCharges(java.math.BigDecimal charges) {
        this.charges = charges;
    }

    public java.math.BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(java.math.BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public java.math.BigDecimal getSpecialVatAmount() {
        return this.specialVatAmount;
    }

    public void setSpecialVatAmount(java.math.BigDecimal specialVatAmount) {
        this.specialVatAmount = specialVatAmount;
    }

    public java.lang.String getBillDocumentNo() {
        return this.billDocumentNo;
    }

    public void setBillDocumentNo(java.lang.String billDocumentNo) {
        this.billDocumentNo = billDocumentNo;
    }

    public java.lang.String getConsignmentDocumentNo() {
        return this.consignmentDocumentNo;
    }

    public void setConsignmentDocumentNo(java.lang.String consignmentDocumentNo) {
        this.consignmentDocumentNo = consignmentDocumentNo;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public java.lang.String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(java.lang.String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public java.math.BigDecimal getDiscountAmountInForeignCurrency() {
        return this.discountAmountInForeignCurrency;
    }

    public void setDiscountAmountInForeignCurrency(java.math.BigDecimal discountAmountInForeignCurrency) {
        this.discountAmountInForeignCurrency = discountAmountInForeignCurrency;
    }

    public java.math.BigDecimal getVatAmountInForeignCurrency() {
        return this.vatAmountInForeignCurrency;
    }

    public void setVatAmountInForeignCurrency(java.math.BigDecimal vatAmountInForeignCurrency) {
        this.vatAmountInForeignCurrency = vatAmountInForeignCurrency;
    }

    public java.math.BigDecimal getChargesInForeignCurrency() {
        return this.chargesInForeignCurrency;
    }

    public void setChargesInForeignCurrency(java.math.BigDecimal chargesInForeignCurrency) {
        this.chargesInForeignCurrency = chargesInForeignCurrency;
    }

    public java.math.BigDecimal getTotalAmountInForeignCurrency() {
        return this.totalAmountInForeignCurrency;
    }

    public void setTotalAmountInForeignCurrency(java.math.BigDecimal totalAmountInForeignCurrency) {
        this.totalAmountInForeignCurrency = totalAmountInForeignCurrency;
    }

    public java.math.BigDecimal getSpecialVatAmountInForeignCurrency() {
        return this.specialVatAmountInForeignCurrency;
    }

    public void setSpecialVatAmountInForeignCurrency(java.math.BigDecimal specialVatAmountInForeignCurrency) {
        this.specialVatAmountInForeignCurrency = specialVatAmountInForeignCurrency;
    }

    public com.turquaz.engine.dal.TurqCurrencyExchangeRate getTurqCurrencyExchangeRate() {
        return this.turqCurrencyExchangeRate;
    }

    public void setTurqCurrencyExchangeRate(com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate) {
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public java.util.Set getTurqConsignments() {
        return this.turqConsignments;
    }

    public void setTurqConsignments(java.util.Set turqConsignments) {
        this.turqConsignments = turqConsignments;
    }

    public java.util.Set getTurqBills() {
        return this.turqBills;
    }

    public void setTurqBills(java.util.Set turqBills) {
        this.turqBills = turqBills;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBillConsignmentCommon) ) return false;
        TurqBillConsignmentCommon castOther = (TurqBillConsignmentCommon) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
