package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBankCardsSecondaryAccount implements Serializable {

    /** identifier field */
    private java.lang.Integer bankCardsSecondaryAccountsId;

    /** nullable persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBankSecondaryAccount turqBankSecondaryAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksCard turqBanksCard;

    /** persistent field */
    private Set turqBanksTransactions;

    /** full constructor */
    public TurqBankCardsSecondaryAccount(java.util.Date creationDate, java.util.Date lastModified, java.lang.String createdBy, java.lang.String updatedBy, com.turquaz.engine.dal.TurqBankSecondaryAccount turqBankSecondaryAccount, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, com.turquaz.engine.dal.TurqBanksCard turqBanksCard, Set turqBanksTransactions) {
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.turqBankSecondaryAccount = turqBankSecondaryAccount;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqBanksCard = turqBanksCard;
        this.turqBanksTransactions = turqBanksTransactions;
    }

    /** default constructor */
    public TurqBankCardsSecondaryAccount() {
    }

    /** minimal constructor */
    public TurqBankCardsSecondaryAccount(java.util.Date lastModified, java.lang.String createdBy, java.lang.String updatedBy, com.turquaz.engine.dal.TurqBankSecondaryAccount turqBankSecondaryAccount, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, com.turquaz.engine.dal.TurqBanksCard turqBanksCard, Set turqBanksTransactions) {
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.turqBankSecondaryAccount = turqBankSecondaryAccount;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqBanksCard = turqBanksCard;
        this.turqBanksTransactions = turqBanksTransactions;
    }

    public java.lang.Integer getBankCardsSecondaryAccountsId() {
        return this.bankCardsSecondaryAccountsId;
    }

    public void setBankCardsSecondaryAccountsId(java.lang.Integer bankCardsSecondaryAccountsId) {
        this.bankCardsSecondaryAccountsId = bankCardsSecondaryAccountsId;
    }

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }

    public java.lang.String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(java.lang.String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public com.turquaz.engine.dal.TurqBankSecondaryAccount getTurqBankSecondaryAccount() {
        return this.turqBankSecondaryAccount;
    }

    public void setTurqBankSecondaryAccount(com.turquaz.engine.dal.TurqBankSecondaryAccount turqBankSecondaryAccount) {
        this.turqBankSecondaryAccount = turqBankSecondaryAccount;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public com.turquaz.engine.dal.TurqBanksCard getTurqBanksCard() {
        return this.turqBanksCard;
    }

    public void setTurqBanksCard(com.turquaz.engine.dal.TurqBanksCard turqBanksCard) {
        this.turqBanksCard = turqBanksCard;
    }

    public java.util.Set getTurqBanksTransactions() {
        return this.turqBanksTransactions;
    }

    public void setTurqBanksTransactions(java.util.Set turqBanksTransactions) {
        this.turqBanksTransactions = turqBanksTransactions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("bankCardsSecondaryAccountsId", getBankCardsSecondaryAccountsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBankCardsSecondaryAccount) ) return false;
        TurqBankCardsSecondaryAccount castOther = (TurqBankCardsSecondaryAccount) other;
        return new EqualsBuilder()
            .append(this.getBankCardsSecondaryAccountsId(), castOther.getBankCardsSecondaryAccountsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBankCardsSecondaryAccountsId())
            .toHashCode();
    }

}
