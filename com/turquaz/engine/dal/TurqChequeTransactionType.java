package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqChequeTransactionType implements Serializable {

    /** identifier field */
    private java.lang.Integer chequeTransactionTypesId;

    /** persistent field */
    private java.lang.String transactionTypsName;

    /** persistent field */
    private short transactionTypesParent;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private Set turqChequeRolls;

    /** full constructor */
    public TurqChequeTransactionType(java.lang.String transactionTypsName, short transactionTypesParent, java.util.Date creationDate, java.util.Date createdBy, java.util.Date lastModified, java.lang.String updatedBy, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, Set turqChequeRolls) {
        this.transactionTypsName = transactionTypsName;
        this.transactionTypesParent = transactionTypesParent;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqChequeRolls = turqChequeRolls;
    }

    /** default constructor */
    public TurqChequeTransactionType() {
    }

    public java.lang.Integer getChequeTransactionTypesId() {
        return this.chequeTransactionTypesId;
    }

    public void setChequeTransactionTypesId(java.lang.Integer chequeTransactionTypesId) {
        this.chequeTransactionTypesId = chequeTransactionTypesId;
    }

    public java.lang.String getTransactionTypsName() {
        return this.transactionTypsName;
    }

    public void setTransactionTypsName(java.lang.String transactionTypsName) {
        this.transactionTypsName = transactionTypsName;
    }

    public short getTransactionTypesParent() {
        return this.transactionTypesParent;
    }

    public void setTransactionTypesParent(short transactionTypesParent) {
        this.transactionTypesParent = transactionTypesParent;
    }

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public java.util.Date getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.util.Date createdBy) {
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

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public java.util.Set getTurqChequeRolls() {
        return this.turqChequeRolls;
    }

    public void setTurqChequeRolls(java.util.Set turqChequeRolls) {
        this.turqChequeRolls = turqChequeRolls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("chequeTransactionTypesId", getChequeTransactionTypesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqChequeTransactionType) ) return false;
        TurqChequeTransactionType castOther = (TurqChequeTransactionType) other;
        return new EqualsBuilder()
            .append(this.getChequeTransactionTypesId(), castOther.getChequeTransactionTypesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getChequeTransactionTypesId())
            .toHashCode();
    }

}
