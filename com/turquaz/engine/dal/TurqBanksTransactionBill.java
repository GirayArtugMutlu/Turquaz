package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBanksTransactionBill implements Serializable {

    /** identifier field */
    private java.lang.Integer banksTransactionBillsId;

    /** persistent field */
    private java.util.Date transactionBillDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String transactionBillDefinition;

    /** persistent field */
    private java.lang.String transactionBillNo;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksTransactionType turqBanksTransactionType;

    /** persistent field */
    private Set turqBanksTransactions;

    /** full constructor */
    public TurqBanksTransactionBill(java.util.Date transactionBillDate, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.lang.String transactionBillDefinition, java.lang.String transactionBillNo, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, com.turquaz.engine.dal.TurqBanksTransactionType turqBanksTransactionType, Set turqBanksTransactions) {
        this.transactionBillDate = transactionBillDate;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.transactionBillDefinition = transactionBillDefinition;
        this.transactionBillNo = transactionBillNo;
        this.turqEngineSequence = turqEngineSequence;
        this.turqBanksTransactionType = turqBanksTransactionType;
        this.turqBanksTransactions = turqBanksTransactions;
    }

    /** default constructor */
    public TurqBanksTransactionBill() {
    }

    public java.lang.Integer getBanksTransactionBillsId() {
        return this.banksTransactionBillsId;
    }

    public void setBanksTransactionBillsId(java.lang.Integer banksTransactionBillsId) {
        this.banksTransactionBillsId = banksTransactionBillsId;
    }

    public java.util.Date getTransactionBillDate() {
        return this.transactionBillDate;
    }

    public void setTransactionBillDate(java.util.Date transactionBillDate) {
        this.transactionBillDate = transactionBillDate;
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

    public java.lang.String getTransactionBillDefinition() {
        return this.transactionBillDefinition;
    }

    public void setTransactionBillDefinition(java.lang.String transactionBillDefinition) {
        this.transactionBillDefinition = transactionBillDefinition;
    }

    public java.lang.String getTransactionBillNo() {
        return this.transactionBillNo;
    }

    public void setTransactionBillNo(java.lang.String transactionBillNo) {
        this.transactionBillNo = transactionBillNo;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
    }

    public com.turquaz.engine.dal.TurqBanksTransactionType getTurqBanksTransactionType() {
        return this.turqBanksTransactionType;
    }

    public void setTurqBanksTransactionType(com.turquaz.engine.dal.TurqBanksTransactionType turqBanksTransactionType) {
        this.turqBanksTransactionType = turqBanksTransactionType;
    }

    public java.util.Set getTurqBanksTransactions() {
        return this.turqBanksTransactions;
    }

    public void setTurqBanksTransactions(java.util.Set turqBanksTransactions) {
        this.turqBanksTransactions = turqBanksTransactions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("banksTransactionBillsId", getBanksTransactionBillsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBanksTransactionBill) ) return false;
        TurqBanksTransactionBill castOther = (TurqBanksTransactionBill) other;
        return new EqualsBuilder()
            .append(this.getBanksTransactionBillsId(), castOther.getBanksTransactionBillsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBanksTransactionBillsId())
            .toHashCode();
    }

}
