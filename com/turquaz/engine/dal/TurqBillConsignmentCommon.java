package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBillConsignmentCommon implements Serializable {

    /** identifier field */
    private java.lang.Integer billConsignmentCommonId;

    /** persistent field */
    private int discountRate;

    /** persistent field */
    private java.math.BigDecimal discountAmount;

    /** persistent field */
    private java.math.BigDecimal vatAmount;

    /** persistent field */
    private java.math.BigDecimal charges;

    /** persistent field */
    private java.math.BigDecimal totalAmount;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.math.BigDecimal specialVatAmount;

    /** persistent field */
    private java.lang.String billDocumentNo;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqConsignments;

    /** persistent field */
    private Set turqBills;

    /** full constructor */
    public TurqBillConsignmentCommon(int discountRate, java.math.BigDecimal discountAmount, java.math.BigDecimal vatAmount, java.math.BigDecimal charges, java.math.BigDecimal totalAmount, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.math.BigDecimal specialVatAmount, java.lang.String billDocumentNo, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqConsignments, Set turqBills) {
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
        this.vatAmount = vatAmount;
        this.charges = charges;
        this.totalAmount = totalAmount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.specialVatAmount = specialVatAmount;
        this.billDocumentNo = billDocumentNo;
        this.turqCurrentCard = turqCurrentCard;
        this.turqConsignments = turqConsignments;
        this.turqBills = turqBills;
    }

    /** default constructor */
    public TurqBillConsignmentCommon() {
    }

    public java.lang.Integer getBillConsignmentCommonId() {
        return this.billConsignmentCommonId;
    }

    public void setBillConsignmentCommonId(java.lang.Integer billConsignmentCommonId) {
        this.billConsignmentCommonId = billConsignmentCommonId;
    }

    public int getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
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
            .append("billConsignmentCommonId", getBillConsignmentCommonId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBillConsignmentCommon) ) return false;
        TurqBillConsignmentCommon castOther = (TurqBillConsignmentCommon) other;
        return new EqualsBuilder()
            .append(this.getBillConsignmentCommonId(), castOther.getBillConsignmentCommonId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBillConsignmentCommonId())
            .toHashCode();
    }

}
