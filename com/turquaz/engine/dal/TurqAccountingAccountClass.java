package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingAccountClass implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingClassesId;

    /** persistent field */
    private java.lang.String accountingClassesName;

    /** persistent field */
    private java.lang.String accountingClassesDefinition;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private Set turqAccountingAccounts;

    /** full constructor */
    public TurqAccountingAccountClass(java.lang.Integer accountingClassesId, java.lang.String accountingClassesName, java.lang.String accountingClassesDefinition, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, Set turqAccountingAccounts) {
        this.accountingClassesId = accountingClassesId;
        this.accountingClassesName = accountingClassesName;
        this.accountingClassesDefinition = accountingClassesDefinition;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqAccountingAccounts = turqAccountingAccounts;
    }

    /** default constructor */
    public TurqAccountingAccountClass() {
    }

    public java.lang.Integer getAccountingClassesId() {
        return this.accountingClassesId;
    }

    public void setAccountingClassesId(java.lang.Integer accountingClassesId) {
        this.accountingClassesId = accountingClassesId;
    }

    public java.lang.String getAccountingClassesName() {
        return this.accountingClassesName;
    }

    public void setAccountingClassesName(java.lang.String accountingClassesName) {
        this.accountingClassesName = accountingClassesName;
    }

    public java.lang.String getAccountingClassesDefinition() {
        return this.accountingClassesDefinition;
    }

    public void setAccountingClassesDefinition(java.lang.String accountingClassesDefinition) {
        this.accountingClassesDefinition = accountingClassesDefinition;
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

    public java.util.Set getTurqAccountingAccounts() {
        return this.turqAccountingAccounts;
    }

    public void setTurqAccountingAccounts(java.util.Set turqAccountingAccounts) {
        this.turqAccountingAccounts = turqAccountingAccounts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("accountingClassesId", getAccountingClassesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingAccountClass) ) return false;
        TurqAccountingAccountClass castOther = (TurqAccountingAccountClass) other;
        return new EqualsBuilder()
            .append(this.getAccountingClassesId(), castOther.getAccountingClassesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccountingClassesId())
            .toHashCode();
    }

}
