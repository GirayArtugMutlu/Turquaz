package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingTransactionColumn implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.math.BigDecimal deptAmount;

    /** persistent field */
    private java.math.BigDecimal creditAmount;

    /** persistent field */
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
    private java.math.BigDecimal rowsDeptInBaseCurrency;

    /** persistent field */
    private java.math.BigDecimal rowsCreditInBaseCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingTransaction turqAccountingTransaction;

    /** full constructor */
    public TurqAccountingTransactionColumn(java.math.BigDecimal deptAmount, java.math.BigDecimal creditAmount, java.lang.String transactionDefinition, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.math.BigDecimal rowsDeptInBaseCurrency, java.math.BigDecimal rowsCreditInBaseCurrency, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, com.turquaz.engine.dal.TurqAccountingTransaction turqAccountingTransaction) {
        this.deptAmount = deptAmount;
        this.creditAmount = creditAmount;
        this.transactionDefinition = transactionDefinition;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.rowsDeptInBaseCurrency = rowsDeptInBaseCurrency;
        this.rowsCreditInBaseCurrency = rowsCreditInBaseCurrency;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqAccountingTransaction = turqAccountingTransaction;
    }

    /** default constructor */
    public TurqAccountingTransactionColumn() {
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

    public java.math.BigDecimal getRowsDeptInBaseCurrency() {
        return this.rowsDeptInBaseCurrency;
    }

    public void setRowsDeptInBaseCurrency(java.math.BigDecimal rowsDeptInBaseCurrency) {
        this.rowsDeptInBaseCurrency = rowsDeptInBaseCurrency;
    }

    public java.math.BigDecimal getRowsCreditInBaseCurrency() {
        return this.rowsCreditInBaseCurrency;
    }

    public void setRowsCreditInBaseCurrency(java.math.BigDecimal rowsCreditInBaseCurrency) {
        this.rowsCreditInBaseCurrency = rowsCreditInBaseCurrency;
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

    public com.turquaz.engine.dal.TurqAccountingTransaction getTurqAccountingTransaction() {
        return this.turqAccountingTransaction;
    }

    public void setTurqAccountingTransaction(com.turquaz.engine.dal.TurqAccountingTransaction turqAccountingTransaction) {
        this.turqAccountingTransaction = turqAccountingTransaction;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingTransactionColumn) ) return false;
        TurqAccountingTransactionColumn castOther = (TurqAccountingTransactionColumn) other;
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
