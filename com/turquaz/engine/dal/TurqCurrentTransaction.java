package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.util.Date transactionsDate;

    /** persistent field */
    private java.lang.String transactionsDocumentNo;

    /** persistent field */
    private java.math.BigDecimal transactionsTotalCredit;

    /** persistent field */
    private java.math.BigDecimal transactionsTotalDiscount;

    /** persistent field */
    private java.math.BigDecimal transactionsTotalDept;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String transactionsDefinition;

    /** persistent field */
    private java.math.BigDecimal totalCreditInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal totalDeptInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal totalDiscountInForeignCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentTransactionType turqCurrentTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqCurrentTransactionBillsByCurrentTransactionsIdOpen;

    /** persistent field */
    private Set turqCurrentTransactionBillsByCurrentTransactionsIdClose;

    /** full constructor */
    public TurqCurrentTransaction(java.util.Date transactionsDate, java.lang.String transactionsDocumentNo, java.math.BigDecimal transactionsTotalCredit, java.math.BigDecimal transactionsTotalDiscount, java.math.BigDecimal transactionsTotalDept, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.lang.String transactionsDefinition, java.math.BigDecimal totalCreditInForeignCurrency, java.math.BigDecimal totalDeptInForeignCurrency, java.math.BigDecimal totalDiscountInForeignCurrency, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqCurrentTransactionType turqCurrentTransactionType, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqCurrentTransactionBillsByCurrentTransactionsIdOpen, Set turqCurrentTransactionBillsByCurrentTransactionsIdClose) {
        this.transactionsDate = transactionsDate;
        this.transactionsDocumentNo = transactionsDocumentNo;
        this.transactionsTotalCredit = transactionsTotalCredit;
        this.transactionsTotalDiscount = transactionsTotalDiscount;
        this.transactionsTotalDept = transactionsTotalDept;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.transactionsDefinition = transactionsDefinition;
        this.totalCreditInForeignCurrency = totalCreditInForeignCurrency;
        this.totalDeptInForeignCurrency = totalDeptInForeignCurrency;
        this.totalDiscountInForeignCurrency = totalDiscountInForeignCurrency;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqCurrentTransactionType = turqCurrentTransactionType;
        this.turqEngineSequence = turqEngineSequence;
        this.turqCurrentCard = turqCurrentCard;
        this.turqCurrentTransactionBillsByCurrentTransactionsIdOpen = turqCurrentTransactionBillsByCurrentTransactionsIdOpen;
        this.turqCurrentTransactionBillsByCurrentTransactionsIdClose = turqCurrentTransactionBillsByCurrentTransactionsIdClose;
    }

    /** default constructor */
    public TurqCurrentTransaction() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.util.Date getTransactionsDate() {
        return this.transactionsDate;
    }

    public void setTransactionsDate(java.util.Date transactionsDate) {
        this.transactionsDate = transactionsDate;
    }

    public java.lang.String getTransactionsDocumentNo() {
        return this.transactionsDocumentNo;
    }

    public void setTransactionsDocumentNo(java.lang.String transactionsDocumentNo) {
        this.transactionsDocumentNo = transactionsDocumentNo;
    }

    public java.math.BigDecimal getTransactionsTotalCredit() {
        return this.transactionsTotalCredit;
    }

    public void setTransactionsTotalCredit(java.math.BigDecimal transactionsTotalCredit) {
        this.transactionsTotalCredit = transactionsTotalCredit;
    }

    public java.math.BigDecimal getTransactionsTotalDiscount() {
        return this.transactionsTotalDiscount;
    }

    public void setTransactionsTotalDiscount(java.math.BigDecimal transactionsTotalDiscount) {
        this.transactionsTotalDiscount = transactionsTotalDiscount;
    }

    public java.math.BigDecimal getTransactionsTotalDept() {
        return this.transactionsTotalDept;
    }

    public void setTransactionsTotalDept(java.math.BigDecimal transactionsTotalDept) {
        this.transactionsTotalDept = transactionsTotalDept;
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

    public java.lang.String getTransactionsDefinition() {
        return this.transactionsDefinition;
    }

    public void setTransactionsDefinition(java.lang.String transactionsDefinition) {
        this.transactionsDefinition = transactionsDefinition;
    }

    public java.math.BigDecimal getTotalCreditInForeignCurrency() {
        return this.totalCreditInForeignCurrency;
    }

    public void setTotalCreditInForeignCurrency(java.math.BigDecimal totalCreditInForeignCurrency) {
        this.totalCreditInForeignCurrency = totalCreditInForeignCurrency;
    }

    public java.math.BigDecimal getTotalDeptInForeignCurrency() {
        return this.totalDeptInForeignCurrency;
    }

    public void setTotalDeptInForeignCurrency(java.math.BigDecimal totalDeptInForeignCurrency) {
        this.totalDeptInForeignCurrency = totalDeptInForeignCurrency;
    }

    public java.math.BigDecimal getTotalDiscountInForeignCurrency() {
        return this.totalDiscountInForeignCurrency;
    }

    public void setTotalDiscountInForeignCurrency(java.math.BigDecimal totalDiscountInForeignCurrency) {
        this.totalDiscountInForeignCurrency = totalDiscountInForeignCurrency;
    }

    public com.turquaz.engine.dal.TurqCurrencyExchangeRate getTurqCurrencyExchangeRate() {
        return this.turqCurrencyExchangeRate;
    }

    public void setTurqCurrencyExchangeRate(com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate) {
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
    }

    public com.turquaz.engine.dal.TurqCurrentTransactionType getTurqCurrentTransactionType() {
        return this.turqCurrentTransactionType;
    }

    public void setTurqCurrentTransactionType(com.turquaz.engine.dal.TurqCurrentTransactionType turqCurrentTransactionType) {
        this.turqCurrentTransactionType = turqCurrentTransactionType;
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

    public java.util.Set getTurqCurrentTransactionBillsByCurrentTransactionsIdOpen() {
        return this.turqCurrentTransactionBillsByCurrentTransactionsIdOpen;
    }

    public void setTurqCurrentTransactionBillsByCurrentTransactionsIdOpen(java.util.Set turqCurrentTransactionBillsByCurrentTransactionsIdOpen) {
        this.turqCurrentTransactionBillsByCurrentTransactionsIdOpen = turqCurrentTransactionBillsByCurrentTransactionsIdOpen;
    }

    public java.util.Set getTurqCurrentTransactionBillsByCurrentTransactionsIdClose() {
        return this.turqCurrentTransactionBillsByCurrentTransactionsIdClose;
    }

    public void setTurqCurrentTransactionBillsByCurrentTransactionsIdClose(java.util.Set turqCurrentTransactionBillsByCurrentTransactionsIdClose) {
        this.turqCurrentTransactionBillsByCurrentTransactionsIdClose = turqCurrentTransactionBillsByCurrentTransactionsIdClose;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentTransaction) ) return false;
        TurqCurrentTransaction castOther = (TurqCurrentTransaction) other;
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
