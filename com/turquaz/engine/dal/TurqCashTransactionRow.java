package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCashTransactionRow implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.math.BigDecimal deptAmount;

    /** persistent field */
    private java.math.BigDecimal creditAmount;

    /** nullable persistent field */
    private java.lang.String transactionDefinition;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.math.BigDecimal deptAmountInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal creditAmountInForeignCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCashTransaction turqCashTransaction;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCashCard turqCashCard;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** full constructor */
    public TurqCashTransactionRow(java.math.BigDecimal deptAmount, java.math.BigDecimal creditAmount, java.lang.String transactionDefinition, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.math.BigDecimal deptAmountInForeignCurrency, java.math.BigDecimal creditAmountInForeignCurrency, com.turquaz.engine.dal.TurqCashTransaction turqCashTransaction, com.turquaz.engine.dal.TurqCashCard turqCashCard, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.deptAmount = deptAmount;
        this.creditAmount = creditAmount;
        this.transactionDefinition = transactionDefinition;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.deptAmountInForeignCurrency = deptAmountInForeignCurrency;
        this.creditAmountInForeignCurrency = creditAmountInForeignCurrency;
        this.turqCashTransaction = turqCashTransaction;
        this.turqCashCard = turqCashCard;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqAccountingAccount = turqAccountingAccount;
    }

    /** default constructor */
    public TurqCashTransactionRow() {
    }

    /** minimal constructor */
    public TurqCashTransactionRow(java.math.BigDecimal deptAmount, java.math.BigDecimal creditAmount, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.math.BigDecimal deptAmountInForeignCurrency, java.math.BigDecimal creditAmountInForeignCurrency, com.turquaz.engine.dal.TurqCashTransaction turqCashTransaction, com.turquaz.engine.dal.TurqCashCard turqCashCard, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.deptAmount = deptAmount;
        this.creditAmount = creditAmount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.deptAmountInForeignCurrency = deptAmountInForeignCurrency;
        this.creditAmountInForeignCurrency = creditAmountInForeignCurrency;
        this.turqCashTransaction = turqCashTransaction;
        this.turqCashCard = turqCashCard;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
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

    public java.lang.String getTransactionDefinition() {
        return this.transactionDefinition;
    }

    public void setTransactionDefinition(java.lang.String transactionDefinition) {
        this.transactionDefinition = transactionDefinition;
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

    public java.math.BigDecimal getDeptAmountInForeignCurrency() {
        return this.deptAmountInForeignCurrency;
    }

    public void setDeptAmountInForeignCurrency(java.math.BigDecimal deptAmountInForeignCurrency) {
        this.deptAmountInForeignCurrency = deptAmountInForeignCurrency;
    }

    public java.math.BigDecimal getCreditAmountInForeignCurrency() {
        return this.creditAmountInForeignCurrency;
    }

    public void setCreditAmountInForeignCurrency(java.math.BigDecimal creditAmountInForeignCurrency) {
        this.creditAmountInForeignCurrency = creditAmountInForeignCurrency;
    }

    public com.turquaz.engine.dal.TurqCashTransaction getTurqCashTransaction() {
        return this.turqCashTransaction;
    }

    public void setTurqCashTransaction(com.turquaz.engine.dal.TurqCashTransaction turqCashTransaction) {
        this.turqCashTransaction = turqCashTransaction;
    }

    public com.turquaz.engine.dal.TurqCashCard getTurqCashCard() {
        return this.turqCashCard;
    }

    public void setTurqCashCard(com.turquaz.engine.dal.TurqCashCard turqCashCard) {
        this.turqCashCard = turqCashCard;
    }

    public com.turquaz.engine.dal.TurqCurrencyExchangeRate getTurqCurrencyExchangeRate() {
        return this.turqCurrencyExchangeRate;
    }

    public void setTurqCurrencyExchangeRate(com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate) {
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCashTransactionRow) ) return false;
        TurqCashTransactionRow castOther = (TurqCashTransactionRow) other;
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
