package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCashTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer cashTransactionsId;

    /** persistent field */
    private java.math.BigDecimal deptAmount;

    /** persistent field */
    private java.math.BigDecimal creditAmount;

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
    private com.turquaz.engine.dal.TurqCashCard turqCashCard;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCashTransactionType turqCashTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** full constructor */
    public TurqCashTransaction(java.math.BigDecimal deptAmount, java.math.BigDecimal creditAmount, java.util.Date transactionDate, java.lang.String transactionDefinition, java.lang.String documentNo, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCashCard turqCashCard, com.turquaz.engine.dal.TurqCashTransactionType turqCashTransactionType, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.deptAmount = deptAmount;
        this.creditAmount = creditAmount;
        this.transactionDate = transactionDate;
        this.transactionDefinition = transactionDefinition;
        this.documentNo = documentNo;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCashCard = turqCashCard;
        this.turqCashTransactionType = turqCashTransactionType;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqEngineSequence = turqEngineSequence;
    }

    /** default constructor */
    public TurqCashTransaction() {
    }

    /** minimal constructor */
    public TurqCashTransaction(java.math.BigDecimal deptAmount, java.math.BigDecimal creditAmount, java.util.Date transactionDate, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCashCard turqCashCard, com.turquaz.engine.dal.TurqCashTransactionType turqCashTransactionType, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.deptAmount = deptAmount;
        this.creditAmount = creditAmount;
        this.transactionDate = transactionDate;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCashCard = turqCashCard;
        this.turqCashTransactionType = turqCashTransactionType;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqEngineSequence = turqEngineSequence;
    }

    public java.lang.Integer getCashTransactionsId() {
        return this.cashTransactionsId;
    }

    public void setCashTransactionsId(java.lang.Integer cashTransactionsId) {
        this.cashTransactionsId = cashTransactionsId;
    }

    public java.math.BigDecimal getDeptAmount() {
        return this.deptAmount;
    }

    public void setDeptAmount(java.math.BigDecimal deptAmount) {
        this.deptAmount = deptAmount;
    }

    public java.math.BigDecimal getCreditAmount() {
        return this.creditAmount;
    }

    public void setCreditAmount(java.math.BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
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

    public com.turquaz.engine.dal.TurqCashCard getTurqCashCard() {
        return this.turqCashCard;
    }

    public void setTurqCashCard(com.turquaz.engine.dal.TurqCashCard turqCashCard) {
        this.turqCashCard = turqCashCard;
    }

    public com.turquaz.engine.dal.TurqCashTransactionType getTurqCashTransactionType() {
        return this.turqCashTransactionType;
    }

    public void setTurqCashTransactionType(com.turquaz.engine.dal.TurqCashTransactionType turqCashTransactionType) {
        this.turqCashTransactionType = turqCashTransactionType;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cashTransactionsId", getCashTransactionsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCashTransaction) ) return false;
        TurqCashTransaction castOther = (TurqCashTransaction) other;
        return new EqualsBuilder()
            .append(this.getCashTransactionsId(), castOther.getCashTransactionsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCashTransactionsId())
            .toHashCode();
    }

}
