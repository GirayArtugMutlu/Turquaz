package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer currentTransactionsId;

    /** persistent field */
    private java.util.Date transactionsDate;

    /** persistent field */
    private java.lang.String transactionsDocumentNo;

    /** persistent field */
    private int currentTransactionTypesId;

    /** persistent field */
    private java.math.BigDecimal transactionsTotalCredit;

    /** persistent field */
    private java.math.BigDecimal transactionsTotalDiscount;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.math.BigDecimal transactionsTotalDept;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrency turqCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqCurrentTransactionBillsByCurrentTransactionsIdClose;

    /** persistent field */
    private Set turqCurrentTransactionBillsByCurrentTransactionsIdOpen;

    /** full constructor */
    public TurqCurrentTransaction(java.util.Date transactionsDate, java.lang.String transactionsDocumentNo, int currentTransactionTypesId, java.math.BigDecimal transactionsTotalCredit, java.math.BigDecimal transactionsTotalDiscount, java.util.Date creationDate, java.util.Date lastModified, java.lang.String updatedBy, java.lang.String createdBy, java.math.BigDecimal transactionsTotalDept, com.turquaz.engine.dal.TurqCurrency turqCurrency, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqCurrentTransactionBillsByCurrentTransactionsIdClose, Set turqCurrentTransactionBillsByCurrentTransactionsIdOpen) {
        this.transactionsDate = transactionsDate;
        this.transactionsDocumentNo = transactionsDocumentNo;
        this.currentTransactionTypesId = currentTransactionTypesId;
        this.transactionsTotalCredit = transactionsTotalCredit;
        this.transactionsTotalDiscount = transactionsTotalDiscount;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.createdBy = createdBy;
        this.transactionsTotalDept = transactionsTotalDept;
        this.turqCurrency = turqCurrency;
        this.turqCurrentCard = turqCurrentCard;
        this.turqCurrentTransactionBillsByCurrentTransactionsIdClose = turqCurrentTransactionBillsByCurrentTransactionsIdClose;
        this.turqCurrentTransactionBillsByCurrentTransactionsIdOpen = turqCurrentTransactionBillsByCurrentTransactionsIdOpen;
    }

    /** default constructor */
    public TurqCurrentTransaction() {
    }

    public java.lang.Integer getCurrentTransactionsId() {
        return this.currentTransactionsId;
    }

    public void setCurrentTransactionsId(java.lang.Integer currentTransactionsId) {
        this.currentTransactionsId = currentTransactionsId;
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

    public int getCurrentTransactionTypesId() {
        return this.currentTransactionTypesId;
    }

    public void setCurrentTransactionTypesId(int currentTransactionTypesId) {
        this.currentTransactionTypesId = currentTransactionTypesId;
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

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
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

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }

    public java.math.BigDecimal getTransactionsTotalDept() {
        return this.transactionsTotalDept;
    }

    public void setTransactionsTotalDept(java.math.BigDecimal transactionsTotalDept) {
        this.transactionsTotalDept = transactionsTotalDept;
    }

    public com.turquaz.engine.dal.TurqCurrency getTurqCurrency() {
        return this.turqCurrency;
    }

    public void setTurqCurrency(com.turquaz.engine.dal.TurqCurrency turqCurrency) {
        this.turqCurrency = turqCurrency;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public java.util.Set getTurqCurrentTransactionBillsByCurrentTransactionsIdClose() {
        return this.turqCurrentTransactionBillsByCurrentTransactionsIdClose;
    }

    public void setTurqCurrentTransactionBillsByCurrentTransactionsIdClose(java.util.Set turqCurrentTransactionBillsByCurrentTransactionsIdClose) {
        this.turqCurrentTransactionBillsByCurrentTransactionsIdClose = turqCurrentTransactionBillsByCurrentTransactionsIdClose;
    }

    public java.util.Set getTurqCurrentTransactionBillsByCurrentTransactionsIdOpen() {
        return this.turqCurrentTransactionBillsByCurrentTransactionsIdOpen;
    }

    public void setTurqCurrentTransactionBillsByCurrentTransactionsIdOpen(java.util.Set turqCurrentTransactionBillsByCurrentTransactionsIdOpen) {
        this.turqCurrentTransactionBillsByCurrentTransactionsIdOpen = turqCurrentTransactionBillsByCurrentTransactionsIdOpen;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentTransactionsId", getCurrentTransactionsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentTransaction) ) return false;
        TurqCurrentTransaction castOther = (TurqCurrentTransaction) other;
        return new EqualsBuilder()
            .append(this.getCurrentTransactionsId(), castOther.getCurrentTransactionsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentTransactionsId())
            .toHashCode();
    }

}
