package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBill implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private int billsType;

    /** persistent field */
    private java.util.Date billsDate;

    /** persistent field */
    private java.lang.String billsDefinition;

    /** persistent field */
    private boolean billsPrinted;

    /** persistent field */
    private boolean isOpen;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.util.Date dueDate;

    /** persistent field */
    private java.lang.String billDocumentNo;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqBillInGroups;

    /** persistent field */
    private Set turqOrders;

    /** persistent field */
    private Set turqBillInEngineSequences;

    /** full constructor */
    public TurqBill(int billsType, java.util.Date billsDate, java.lang.String billsDefinition, boolean billsPrinted, boolean isOpen, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.util.Date dueDate, java.lang.String billDocumentNo, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqBillInGroups, Set turqOrders, Set turqBillInEngineSequences) {
        this.billsType = billsType;
        this.billsDate = billsDate;
        this.billsDefinition = billsDefinition;
        this.billsPrinted = billsPrinted;
        this.isOpen = isOpen;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.dueDate = dueDate;
        this.billDocumentNo = billDocumentNo;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqEngineSequence = turqEngineSequence;
        this.turqCurrentCard = turqCurrentCard;
        this.turqBillInGroups = turqBillInGroups;
        this.turqOrders = turqOrders;
        this.turqBillInEngineSequences = turqBillInEngineSequences;
    }

    /** default constructor */
    public TurqBill() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public int getBillsType() {
        return this.billsType;
    }

    public void setBillsType(int billsType) {
        this.billsType = billsType;
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

    public boolean isBillsPrinted() {
        return this.billsPrinted;
    }

    public void setBillsPrinted(boolean billsPrinted) {
        this.billsPrinted = billsPrinted;
    }

    public boolean isIsOpen() {
        return this.isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
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

    public java.util.Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(java.util.Date dueDate) {
        this.dueDate = dueDate;
    }

    public java.lang.String getBillDocumentNo() {
        return this.billDocumentNo;
    }

    public void setBillDocumentNo(java.lang.String billDocumentNo) {
        this.billDocumentNo = billDocumentNo;
    }

    public com.turquaz.engine.dal.TurqCurrencyExchangeRate getTurqCurrencyExchangeRate() {
        return this.turqCurrencyExchangeRate;
    }

    public void setTurqCurrencyExchangeRate(com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate) {
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
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

    public java.util.Set getTurqOrders() {
        return this.turqOrders;
    }

    public void setTurqOrders(java.util.Set turqOrders) {
        this.turqOrders = turqOrders;
    }

    public java.util.Set getTurqBillInEngineSequences() {
        return this.turqBillInEngineSequences;
    }

    public void setTurqBillInEngineSequences(java.util.Set turqBillInEngineSequences) {
        this.turqBillInEngineSequences = turqBillInEngineSequences;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBill) ) return false;
        TurqBill castOther = (TurqBill) other;
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
