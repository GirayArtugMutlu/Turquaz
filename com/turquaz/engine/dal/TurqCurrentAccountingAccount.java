package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentAccountingAccount implements Serializable {

    /** identifier field */
    private java.lang.Integer currentAccountingAccountsId;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentAccountingType turqCurrentAccountingType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** full constructor */
    public TurqCurrentAccountingAccount(java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCurrentAccountingType turqCurrentAccountingType, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCurrentAccountingType = turqCurrentAccountingType;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqCurrentCard = turqCurrentCard;
    }

    /** default constructor */
    public TurqCurrentAccountingAccount() {
    }

    public java.lang.Integer getCurrentAccountingAccountsId() {
        return this.currentAccountingAccountsId;
    }

    public void setCurrentAccountingAccountsId(java.lang.Integer currentAccountingAccountsId) {
        this.currentAccountingAccountsId = currentAccountingAccountsId;
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

    public com.turquaz.engine.dal.TurqCurrentAccountingType getTurqCurrentAccountingType() {
        return this.turqCurrentAccountingType;
    }

    public void setTurqCurrentAccountingType(com.turquaz.engine.dal.TurqCurrentAccountingType turqCurrentAccountingType) {
        this.turqCurrentAccountingType = turqCurrentAccountingType;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentAccountingAccountsId", getCurrentAccountingAccountsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentAccountingAccount) ) return false;
        TurqCurrentAccountingAccount castOther = (TurqCurrentAccountingAccount) other;
        return new EqualsBuilder()
            .append(this.getCurrentAccountingAccountsId(), castOther.getCurrentAccountingAccountsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentAccountingAccountsId())
            .toHashCode();
    }

}
