package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingTransactionType implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingTransactionTypesId;

    /** persistent field */
    private java.lang.String typesName;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private Set turqAccountingTransactions;

    /** full constructor */
    public TurqAccountingTransactionType(java.lang.Integer accountingTransactionTypesId, java.lang.String typesName, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, Set turqAccountingTransactions) {
        this.accountingTransactionTypesId = accountingTransactionTypesId;
        this.typesName = typesName;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqAccountingTransactions = turqAccountingTransactions;
    }

    /** default constructor */
    public TurqAccountingTransactionType() {
    }

    public java.lang.Integer getAccountingTransactionTypesId() {
        return this.accountingTransactionTypesId;
    }

    public void setAccountingTransactionTypesId(java.lang.Integer accountingTransactionTypesId) {
        this.accountingTransactionTypesId = accountingTransactionTypesId;
    }

    public java.lang.String getTypesName() {
        return this.typesName;
    }

    public void setTypesName(java.lang.String typesName) {
        this.typesName = typesName;
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

    public java.util.Set getTurqAccountingTransactions() {
        return this.turqAccountingTransactions;
    }

    public void setTurqAccountingTransactions(java.util.Set turqAccountingTransactions) {
        this.turqAccountingTransactions = turqAccountingTransactions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("accountingTransactionTypesId", getAccountingTransactionTypesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingTransactionType) ) return false;
        TurqAccountingTransactionType castOther = (TurqAccountingTransactionType) other;
        return new EqualsBuilder()
            .append(this.getAccountingTransactionTypesId(), castOther.getAccountingTransactionTypesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccountingTransactionTypesId())
            .toHashCode();
    }

}