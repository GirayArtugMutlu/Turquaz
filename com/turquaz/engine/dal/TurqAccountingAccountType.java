package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingAccountType implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingTypesId;

    /** persistent field */
    private java.lang.String accountingTypesName;

    /** persistent field */
    private java.lang.String accountingTypesDefinition;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** full constructor */
    public TurqAccountingAccountType(java.lang.Integer accountingTypesId, java.lang.String accountingTypesName, java.lang.String accountingTypesDefinition, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified) {
        this.accountingTypesId = accountingTypesId;
        this.accountingTypesName = accountingTypesName;
        this.accountingTypesDefinition = accountingTypesDefinition;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
    }

    /** default constructor */
    public TurqAccountingAccountType() {
    }

    public java.lang.Integer getAccountingTypesId() {
        return this.accountingTypesId;
    }

    public void setAccountingTypesId(java.lang.Integer accountingTypesId) {
        this.accountingTypesId = accountingTypesId;
    }

    public java.lang.String getAccountingTypesName() {
        return this.accountingTypesName;
    }

    public void setAccountingTypesName(java.lang.String accountingTypesName) {
        this.accountingTypesName = accountingTypesName;
    }

    public java.lang.String getAccountingTypesDefinition() {
        return this.accountingTypesDefinition;
    }

    public void setAccountingTypesDefinition(java.lang.String accountingTypesDefinition) {
        this.accountingTypesDefinition = accountingTypesDefinition;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("accountingTypesId", getAccountingTypesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingAccountType) ) return false;
        TurqAccountingAccountType castOther = (TurqAccountingAccountType) other;
        return new EqualsBuilder()
            .append(this.getAccountingTypesId(), castOther.getAccountingTypesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccountingTypesId())
            .toHashCode();
    }

}
