package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBankSecondaryAccount implements Serializable {

    /** identifier field */
    private java.lang.Integer bankSecondaryAccountsId;

    /** persistent field */
    private java.lang.String accountName;

    /** persistent field */
    private java.lang.String accountCode;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private Set turqBankCardsSecondaryAccounts;

    /** full constructor */
    public TurqBankSecondaryAccount(java.lang.String accountName, java.lang.String accountCode, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, Set turqBankCardsSecondaryAccounts) {
        this.accountName = accountName;
        this.accountCode = accountCode;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
    }

    /** default constructor */
    public TurqBankSecondaryAccount() {
    }

    public java.lang.Integer getBankSecondaryAccountsId() {
        return this.bankSecondaryAccountsId;
    }

    public void setBankSecondaryAccountsId(java.lang.Integer bankSecondaryAccountsId) {
        this.bankSecondaryAccountsId = bankSecondaryAccountsId;
    }

    public java.lang.String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }

    public java.lang.String getAccountCode() {
        return this.accountCode;
    }

    public void setAccountCode(java.lang.String accountCode) {
        this.accountCode = accountCode;
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

    public java.util.Set getTurqBankCardsSecondaryAccounts() {
        return this.turqBankCardsSecondaryAccounts;
    }

    public void setTurqBankCardsSecondaryAccounts(java.util.Set turqBankCardsSecondaryAccounts) {
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("bankSecondaryAccountsId", getBankSecondaryAccountsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBankSecondaryAccount) ) return false;
        TurqBankSecondaryAccount castOther = (TurqBankSecondaryAccount) other;
        return new EqualsBuilder()
            .append(this.getBankSecondaryAccountsId(), castOther.getBankSecondaryAccountsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBankSecondaryAccountsId())
            .toHashCode();
    }

}
