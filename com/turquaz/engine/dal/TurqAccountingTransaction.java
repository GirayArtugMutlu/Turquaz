package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingTransactionsId;

    /** persistent field */
    private java.math.BigDecimal transactionsDeptAmount;

    /** persistent field */
    private java.math.BigDecimal transactionsCreditAmount;

    /** persistent field */
    private java.util.Date transactionsDate;

    /** persistent field */
    private java.lang.String transactionDocumentNo;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingJournal turqAccountingJournal;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingTransactionType turqAccountingTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqModule turqModule;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdDeptor;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdCreditor;

    /** full constructor */
    public TurqAccountingTransaction(java.lang.Integer accountingTransactionsId, java.math.BigDecimal transactionsDeptAmount, java.math.BigDecimal transactionsCreditAmount, java.util.Date transactionsDate, java.lang.String transactionDocumentNo, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, com.turquaz.engine.dal.TurqAccountingJournal turqAccountingJournal, com.turquaz.engine.dal.TurqAccountingTransactionType turqAccountingTransactionType, com.turquaz.engine.dal.TurqModule turqModule, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdDeptor, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdCreditor) {
        this.accountingTransactionsId = accountingTransactionsId;
        this.transactionsDeptAmount = transactionsDeptAmount;
        this.transactionsCreditAmount = transactionsCreditAmount;
        this.transactionsDate = transactionsDate;
        this.transactionDocumentNo = transactionDocumentNo;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqAccountingJournal = turqAccountingJournal;
        this.turqAccountingTransactionType = turqAccountingTransactionType;
        this.turqModule = turqModule;
        this.turqAccountingAccountByAccountIdDeptor = turqAccountingAccountByAccountIdDeptor;
        this.turqAccountingAccountByAccountIdCreditor = turqAccountingAccountByAccountIdCreditor;
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

    public java.math.BigDecimal getTransactionsDeptAmount() {
        return this.transactionsDeptAmount;
    }

    public void setTransactionsDeptAmount(java.math.BigDecimal transactionsDeptAmount) {
        this.transactionsDeptAmount = transactionsDeptAmount;
    }

    public java.math.BigDecimal getTransactionsCreditAmount() {
        return this.transactionsCreditAmount;
    }

    public void setTransactionsCreditAmount(java.math.BigDecimal transactionsCreditAmount) {
        this.transactionsCreditAmount = transactionsCreditAmount;
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

    public com.turquaz.engine.dal.TurqAccountingJournal getTurqAccountingJournal() {
        return this.turqAccountingJournal;
    }

    public void setTurqAccountingJournal(com.turquaz.engine.dal.TurqAccountingJournal turqAccountingJournal) {
        this.turqAccountingJournal = turqAccountingJournal;
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

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByAccountIdDeptor() {
        return this.turqAccountingAccountByAccountIdDeptor;
    }

    public void setTurqAccountingAccountByAccountIdDeptor(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdDeptor) {
        this.turqAccountingAccountByAccountIdDeptor = turqAccountingAccountByAccountIdDeptor;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByAccountIdCreditor() {
        return this.turqAccountingAccountByAccountIdCreditor;
    }

    public void setTurqAccountingAccountByAccountIdCreditor(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdCreditor) {
        this.turqAccountingAccountByAccountIdCreditor = turqAccountingAccountByAccountIdCreditor;
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
