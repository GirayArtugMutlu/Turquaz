package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBanksTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.math.BigDecimal deptAmount;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.math.BigDecimal creditAmount;

    /** persistent field */
    private java.math.BigDecimal deptAmountInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal creditAmountInForeignCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksTransactionBill turqBanksTransactionBill;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksCard turqBanksCard;

    /** full constructor */
    public TurqBanksTransaction(java.math.BigDecimal deptAmount, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.math.BigDecimal creditAmount, java.math.BigDecimal deptAmountInForeignCurrency, java.math.BigDecimal creditAmountInForeignCurrency, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqBanksTransactionBill turqBanksTransactionBill, com.turquaz.engine.dal.TurqBanksCard turqBanksCard) {
        this.deptAmount = deptAmount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.creditAmount = creditAmount;
        this.deptAmountInForeignCurrency = deptAmountInForeignCurrency;
        this.creditAmountInForeignCurrency = creditAmountInForeignCurrency;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqBanksTransactionBill = turqBanksTransactionBill;
        this.turqBanksCard = turqBanksCard;
    }

    /** default constructor */
    public TurqBanksTransaction() {
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

    public java.math.BigDecimal getCreditAmount() {
        return this.creditAmount;
    }

    public void setCreditAmount(java.math.BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
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

    public com.turquaz.engine.dal.TurqCurrencyExchangeRate getTurqCurrencyExchangeRate() {
        return this.turqCurrencyExchangeRate;
    }

    public void setTurqCurrencyExchangeRate(com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate) {
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
    }

    public com.turquaz.engine.dal.TurqBanksTransactionBill getTurqBanksTransactionBill() {
        return this.turqBanksTransactionBill;
    }

    public void setTurqBanksTransactionBill(com.turquaz.engine.dal.TurqBanksTransactionBill turqBanksTransactionBill) {
        this.turqBanksTransactionBill = turqBanksTransactionBill;
    }

    public com.turquaz.engine.dal.TurqBanksCard getTurqBanksCard() {
        return this.turqBanksCard;
    }

    public void setTurqBanksCard(com.turquaz.engine.dal.TurqBanksCard turqBanksCard) {
        this.turqBanksCard = turqBanksCard;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBanksTransaction) ) return false;
        TurqBanksTransaction castOther = (TurqBanksTransaction) other;
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
