package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingTransactionsId;

    /** persistent field */
    private java.util.Date transactionsDate;

    /** persistent field */
    private java.lang.String transactionDocumentNo;

    /** persistent field */
    private java.lang.String transactionDescription;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingJournal turqAccountingJournal;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrency turqCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingTransactionType turqAccountingTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqModule turqModule;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private Set turqAccountingTransactionColumns;

    /** full constructor */
    public TurqAccountingTransaction(java.util.Date transactionsDate, java.lang.String transactionDocumentNo, java.lang.String transactionDescription, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqAccountingJournal turqAccountingJournal, com.turquaz.engine.dal.TurqCurrency turqCurrency, com.turquaz.engine.dal.TurqAccountingTransactionType turqAccountingTransactionType, com.turquaz.engine.dal.TurqModule turqModule, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, Set turqAccountingTransactionColumns) {
        this.transactionsDate = transactionsDate;
        this.transactionDocumentNo = transactionDocumentNo;
        this.transactionDescription = transactionDescription;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqAccountingJournal = turqAccountingJournal;
        this.turqCurrency = turqCurrency;
        this.turqAccountingTransactionType = turqAccountingTransactionType;
        this.turqModule = turqModule;
        this.turqEngineSequence = turqEngineSequence;
        this.turqAccountingTransactionColumns = turqAccountingTransactionColumns;
    }

    /** default constructor */
    public TurqAccountingTransaction() {
    }

    public java.lang.Integer getAccountingTransactionsId() {
        return this.accountingTransactionsId;
    }

    public void setAccountingTransactionsId(java.lang.Integer accountingTransactionsId) {
        this.accountingTransactionsId = accountingTransactionsId;
    }

    public java.util.Date getTransactionsDate() {
        return this.transactionsDate;
    }

    public void setTransactionsDate(java.util.Date transactionsDate) {
        this.transactionsDate = transactionsDate;
    }

    public java.lang.String getTransactionDocumentNo() {
        return this.transactionDocumentNo;
    }

    public void setTransactionDocumentNo(java.lang.String transactionDocumentNo) {
        this.transactionDocumentNo = transactionDocumentNo;
    }

    public java.lang.String getTransactionDescription() {
        return this.transactionDescription;
    }

    public void setTransactionDescription(java.lang.String transactionDescription) {
        this.transactionDescription = transactionDescription;
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

    public com.turquaz.engine.dal.TurqAccountingJournal getTurqAccountingJournal() {
        return this.turqAccountingJournal;
    }

    public void setTurqAccountingJournal(com.turquaz.engine.dal.TurqAccountingJournal turqAccountingJournal) {
        this.turqAccountingJournal = turqAccountingJournal;
    }

    public com.turquaz.engine.dal.TurqCurrency getTurqCurrency() {
        return this.turqCurrency;
    }

    public void setTurqCurrency(com.turquaz.engine.dal.TurqCurrency turqCurrency) {
        this.turqCurrency = turqCurrency;
    }

    public com.turquaz.engine.dal.TurqAccountingTransactionType getTurqAccountingTransactionType() {
        return this.turqAccountingTransactionType;
    }

    public void setTurqAccountingTransactionType(com.turquaz.engine.dal.TurqAccountingTransactionType turqAccountingTransactionType) {
        this.turqAccountingTransactionType = turqAccountingTransactionType;
    }

    public com.turquaz.engine.dal.TurqModule getTurqModule() {
        return this.turqModule;
    }

    public void setTurqModule(com.turquaz.engine.dal.TurqModule turqModule) {
        this.turqModule = turqModule;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
    }

    public java.util.Set getTurqAccountingTransactionColumns() {
        return this.turqAccountingTransactionColumns;
    }

    public void setTurqAccountingTransactionColumns(java.util.Set turqAccountingTransactionColumns) {
        this.turqAccountingTransactionColumns = turqAccountingTransactionColumns;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("accountingTransactionsId", getAccountingTransactionsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingTransaction) ) return false;
        TurqAccountingTransaction castOther = (TurqAccountingTransaction) other;
        return new EqualsBuilder()
            .append(this.getAccountingTransactionsId(), castOther.getAccountingTransactionsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccountingTransactionsId())
            .toHashCode();
    }

}
