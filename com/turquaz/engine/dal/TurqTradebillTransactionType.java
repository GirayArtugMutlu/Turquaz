package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqTradebillTransactionType implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.lang.String transactionTypesName;

    /** persistent field */
    private short transactionTypesParent;

    /** persistent field */
    private java.util.Date createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private Set turqTradebillRolls;

    /** full constructor */
    public TurqTradebillTransactionType(java.lang.String transactionTypesName, short transactionTypesParent, java.util.Date createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, Set turqTradebillRolls) {
        this.transactionTypesName = transactionTypesName;
        this.transactionTypesParent = transactionTypesParent;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqTradebillRolls = turqTradebillRolls;
    }

    /** default constructor */
    public TurqTradebillTransactionType() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getTransactionTypesName() {
        return this.transactionTypesName;
    }

    public void setTransactionTypesName(java.lang.String transactionTypesName) {
        this.transactionTypesName = transactionTypesName;
    }

    public short getTransactionTypesParent() {
        return this.transactionTypesParent;
    }

    public void setTransactionTypesParent(short transactionTypesParent) {
        this.transactionTypesParent = transactionTypesParent;
    }

    public java.util.Date getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.util.Date createdBy) {
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

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public java.util.Set getTurqTradebillRolls() {
        return this.turqTradebillRolls;
    }

    public void setTurqTradebillRolls(java.util.Set turqTradebillRolls) {
        this.turqTradebillRolls = turqTradebillRolls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqTradebillTransactionType) ) return false;
        TurqTradebillTransactionType castOther = (TurqTradebillTransactionType) other;
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
