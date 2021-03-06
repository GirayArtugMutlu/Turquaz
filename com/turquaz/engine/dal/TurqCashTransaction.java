package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCashTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.util.Date transactionDate;

    /** nullable persistent field */
    private java.lang.String transactionDefinition;

    /** nullable persistent field */
    private java.lang.String documentNo;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCashTransactionType turqCashTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private Set turqCashTransactionRows;

    /** full constructor */
    public TurqCashTransaction(java.util.Date transactionDate, java.lang.String transactionDefinition, java.lang.String documentNo, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCashTransactionType turqCashTransactionType, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, Set turqCashTransactionRows) {
        this.transactionDate = transactionDate;
        this.transactionDefinition = transactionDefinition;
        this.documentNo = documentNo;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCashTransactionType = turqCashTransactionType;
        this.turqEngineSequence = turqEngineSequence;
        this.turqCashTransactionRows = turqCashTransactionRows;
    }

    /** default constructor */
    public TurqCashTransaction() {
    }

    /** minimal constructor */
    public TurqCashTransaction(java.util.Date transactionDate, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCashTransactionType turqCashTransactionType, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, Set turqCashTransactionRows) {
        this.transactionDate = transactionDate;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCashTransactionType = turqCashTransactionType;
        this.turqEngineSequence = turqEngineSequence;
        this.turqCashTransactionRows = turqCashTransactionRows;
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.util.Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(java.util.Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public java.lang.String getTransactionDefinition() {
        return this.transactionDefinition;
    }

    public void setTransactionDefinition(java.lang.String transactionDefinition) {
        this.transactionDefinition = transactionDefinition;
    }

    public java.lang.String getDocumentNo() {
        return this.documentNo;
    }

    public void setDocumentNo(java.lang.String documentNo) {
        this.documentNo = documentNo;
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

    public com.turquaz.engine.dal.TurqCashTransactionType getTurqCashTransactionType() {
        return this.turqCashTransactionType;
    }

    public void setTurqCashTransactionType(com.turquaz.engine.dal.TurqCashTransactionType turqCashTransactionType) {
        this.turqCashTransactionType = turqCashTransactionType;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
    }

    public java.util.Set getTurqCashTransactionRows() {
        return this.turqCashTransactionRows;
    }

    public void setTurqCashTransactionRows(java.util.Set turqCashTransactionRows) {
        this.turqCashTransactionRows = turqCashTransactionRows;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCashTransaction) ) return false;
        TurqCashTransaction castOther = (TurqCashTransaction) other;
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
