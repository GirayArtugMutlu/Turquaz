package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBanksTransactionType implements Serializable {

    /** identifier field */
    private java.lang.Integer bankTransactionTypesId;

    /** persistent field */
    private java.lang.String transactionTypeName;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private Set turqBanksTransactions;

    /** full constructor */
    public TurqBanksTransactionType(java.lang.String transactionTypeName, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, Set turqBanksTransactions) {
        this.transactionTypeName = transactionTypeName;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqBanksTransactions = turqBanksTransactions;
    }

    /** default constructor */
    public TurqBanksTransactionType() {
    }

    public java.lang.Integer getBankTransactionTypesId() {
        return this.bankTransactionTypesId;
    }

    public void setBankTransactionTypesId(java.lang.Integer bankTransactionTypesId) {
        this.bankTransactionTypesId = bankTransactionTypesId;
    }

    public java.lang.String getTransactionTypeName() {
        return this.transactionTypeName;
    }

    public void setTransactionTypeName(java.lang.String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
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

    public java.util.Set getTurqBanksTransactions() {
        return this.turqBanksTransactions;
    }

    public void setTurqBanksTransactions(java.util.Set turqBanksTransactions) {
        this.turqBanksTransactions = turqBanksTransactions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("bankTransactionTypesId", getBankTransactionTypesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBanksTransactionType) ) return false;
        TurqBanksTransactionType castOther = (TurqBanksTransactionType) other;
        return new EqualsBuilder()
            .append(this.getBankTransactionTypesId(), castOther.getBankTransactionTypesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBankTransactionTypesId())
            .toHashCode();
    }

}
