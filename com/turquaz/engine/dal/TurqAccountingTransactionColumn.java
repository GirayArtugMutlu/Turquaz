package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingTransactionColumn implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingTransactionColumnsId;

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
    private int rowsCurrencyType;

    /** persistent field */
    private int rowsDeptInBaseCurrency;

    /** persistent field */
    private int rowsCreditInBaseCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingTransaction turqAccountingTransaction;

    /** full constructor */
    public TurqAccountingTransactionColumn(java.math.BigDecimal deptAmount, java.math.BigDecimal creditAmount, java.lang.String transactionDefinition, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, int rowsCurrencyType, int rowsDeptInBaseCurrency, int rowsCreditInBaseCurrency, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, com.turquaz.engine.dal.TurqAccountingTransaction turqAccountingTransaction) {
        this.deptAmount = deptAmount;
        this.creditAmount = creditAmount;
        this.transactionDefinition = transactionDefinition;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.rowsCurrencyType = rowsCurrencyType;
        this.rowsDeptInBaseCurrency = rowsDeptInBaseCurrency;
        this.rowsCreditInBaseCurrency = rowsCreditInBaseCurrency;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqAccountingTransaction = turqAccountingTransaction;
    }

    /** default constructor */
    public TurqAccountingTransactionColumn() {
    }

    public java.lang.Integer getAccountingTransactionColumnsId() {
        return this.accountingTransactionColumnsId;
    }

    public void setAccountingTransactionColumnsId(java.lang.Integer accountingTransactionColumnsId) {
        this.accountingTransactionColumnsId = accountingTransactionColumnsId;
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

    public int getRowsCurrencyType() {
        return this.rowsCurrencyType;
    }

    public void setRowsCurrencyType(int rowsCurrencyType) {
        this.rowsCurrencyType = rowsCurrencyType;
    }

    public int getRowsDeptInBaseCurrency() {
        return this.rowsDeptInBaseCurrency;
    }

    public void setRowsDeptInBaseCurrency(int rowsDeptInBaseCurrency) {
        this.rowsDeptInBaseCurrency = rowsDeptInBaseCurrency;
    }

    public int getRowsCreditInBaseCurrency() {
        return this.rowsCreditInBaseCurrency;
    }

    public void setRowsCreditInBaseCurrency(int rowsCreditInBaseCurrency) {
        this.rowsCreditInBaseCurrency = rowsCreditInBaseCurrency;
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
            .append("accountingTransactionColumnsId", getAccountingTransactionColumnsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingTransactionColumn) ) return false;
        TurqAccountingTransactionColumn castOther = (TurqAccountingTransactionColumn) other;
        return new EqualsBuilder()
            .append(this.getAccountingTransactionColumnsId(), castOther.getAccountingTransactionColumnsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccountingTransactionColumnsId())
            .toHashCode();
    }

}
