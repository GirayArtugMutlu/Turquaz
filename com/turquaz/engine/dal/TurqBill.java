package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBill implements Serializable {

    /** identifier field */
    private java.lang.Integer billsId;

    /** persistent field */
    private int billsType;

    /** persistent field */
    private java.lang.String billDocumentNo;

    /** persistent field */
    private java.util.Date billsDate;

    /** persistent field */
    private java.lang.String billsDefinition;

    /** persistent field */
    private short billsPrinted;

    /** persistent field */
    private int billsDiscountRate;

    /** persistent field */
    private java.math.BigDecimal billsDiscountAmount;

    /** persistent field */
    private java.math.BigDecimal billsCharges;

    /** persistent field */
    private int billsVat;

    /** persistent field */
    private java.math.BigDecimal billsVatAmount;

    /** persistent field */
    private java.math.BigDecimal billsTotalAmount;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqBillInGroups;

    /** persistent field */
    private Set turqConsignments;

    /** persistent field */
    private Set turqOrders;

    /** full constructor */
    public TurqBill(java.lang.Integer billsId, int billsType, java.lang.String billDocumentNo, java.util.Date billsDate, java.lang.String billsDefinition, short billsPrinted, int billsDiscountRate, java.math.BigDecimal billsDiscountAmount, java.math.BigDecimal billsCharges, int billsVat, java.math.BigDecimal billsVatAmount, java.math.BigDecimal billsTotalAmount, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCompany turqCompany, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqBillInGroups, Set turqConsignments, Set turqOrders) {
        this.billsId = billsId;
        this.billsType = billsType;
        this.billDocumentNo = billDocumentNo;
        this.billsDate = billsDate;
        this.billsDefinition = billsDefinition;
        this.billsPrinted = billsPrinted;
        this.billsDiscountRate = billsDiscountRate;
        this.billsDiscountAmount = billsDiscountAmount;
        this.billsCharges = billsCharges;
        this.billsVat = billsVat;
        this.billsVatAmount = billsVatAmount;
        this.billsTotalAmount = billsTotalAmount;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqCompany = turqCompany;
        this.turqCurrentCard = turqCurrentCard;
        this.turqBillInGroups = turqBillInGroups;
        this.turqConsignments = turqConsignments;
        this.turqOrders = turqOrders;
    }

    /** default constructor */
    public TurqBill() {
    }

    public java.lang.Integer getBillsId() {
        return this.billsId;
    }

    public void setBillsId(java.lang.Integer billsId) {
        this.billsId = billsId;
    }

    public int getBillsType() {
        return this.billsType;
    }

    public void setBillsType(int billsType) {
        this.billsType = billsType;
    }

    public java.lang.String getBillDocumentNo() {
        return this.billDocumentNo;
    }

    public void setBillDocumentNo(java.lang.String billDocumentNo) {
        this.billDocumentNo = billDocumentNo;
    }

    public java.util.Date getBillsDate() {
        return this.billsDate;
    }

    public void setBillsDate(java.util.Date billsDate) {
        this.billsDate = billsDate;
    }

    public java.lang.String getBillsDefinition() {
        return this.billsDefinition;
    }

    public void setBillsDefinition(java.lang.String billsDefinition) {
        this.billsDefinition = billsDefinition;
    }

    public short getBillsPrinted() {
        return this.billsPrinted;
    }

    public void setBillsPrinted(short billsPrinted) {
        this.billsPrinted = billsPrinted;
    }

    public int getBillsDiscountRate() {
        return this.billsDiscountRate;
    }

    public void setBillsDiscountRate(int billsDiscountRate) {
        this.billsDiscountRate = billsDiscountRate;
    }

    public java.math.BigDecimal getBillsDiscountAmount() {
        return this.billsDiscountAmount;
    }

    public void setBillsDiscountAmount(java.math.BigDecimal billsDiscountAmount) {
        this.billsDiscountAmount = billsDiscountAmount;
    }

    public java.math.BigDecimal getBillsCharges() {
        return this.billsCharges;
    }

    public void setBillsCharges(java.math.BigDecimal billsCharges) {
        this.billsCharges = billsCharges;
    }

    public int getBillsVat() {
        return this.billsVat;
    }

    public void setBillsVat(int billsVat) {
        this.billsVat = billsVat;
    }

    public java.math.BigDecimal getBillsVatAmount() {
        return this.billsVatAmount;
    }

    public void setBillsVatAmount(java.math.BigDecimal billsVatAmount) {
        this.billsVatAmount = billsVatAmount;
    }

    public java.math.BigDecimal getBillsTotalAmount() {
        return this.billsTotalAmount;
    }

    public void setBillsTotalAmount(java.math.BigDecimal billsTotalAmount) {
        this.billsTotalAmount = billsTotalAmount;
    }

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public java.lang.String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(java.lang.String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public java.util.Set getTurqBillInGroups() {
        return this.turqBillInGroups;
    }

    public void setTurqBillInGroups(java.util.Set turqBillInGroups) {
        this.turqBillInGroups = turqBillInGroups;
    }

    public java.util.Set getTurqConsignments() {
        return this.turqConsignments;
    }

    public void setTurqConsignments(java.util.Set turqConsignments) {
        this.turqConsignments = turqConsignments;
    }

    public java.util.Set getTurqOrders() {
        return this.turqOrders;
    }

    public void setTurqOrders(java.util.Set turqOrders) {
        this.turqOrders = turqOrders;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("billsId", getBillsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBill) ) return false;
        TurqBill castOther = (TurqBill) other;
        return new EqualsBuilder()
            .append(this.getBillsId(), castOther.getBillsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBillsId())
            .toHashCode();
    }

}
