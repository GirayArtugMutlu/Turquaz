package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBanksTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer bankTransactionsId;

    /** persistent field */
    private java.math.BigDecimal transactionAmount;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksTransactionBill turqBanksTransactionBill;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBankCardsSecondaryAccount turqBankCardsSecondaryAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksTransactionType turqBanksTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** full constructor */
    public TurqBanksTransaction(java.lang.Integer bankTransactionsId, java.math.BigDecimal transactionAmount, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, com.turquaz.engine.dal.TurqBanksTransactionBill turqBanksTransactionBill, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, com.turquaz.engine.dal.TurqBankCardsSecondaryAccount turqBankCardsSecondaryAccount, com.turquaz.engine.dal.TurqBanksTransactionType turqBanksTransactionType, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.bankTransactionsId = bankTransactionsId;
        this.transactionAmount = transactionAmount;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqBanksTransactionBill = turqBanksTransactionBill;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqBankCardsSecondaryAccount = turqBankCardsSecondaryAccount;
        this.turqBanksTransactionType = turqBanksTransactionType;
        this.turqCurrentCard = turqCurrentCard;
    }

    /** default constructor */
    public TurqBanksTransaction() {
    }

    public java.lang.Integer getBankTransactionsId() {
        return this.bankTransactionsId;
    }

    public void setBankTransactionsId(java.lang.Integer bankTransactionsId) {
        this.bankTransactionsId = bankTransactionsId;
    }

    public java.math.BigDecimal getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setTransactionAmount(java.math.BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
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

    public com.turquaz.engine.dal.TurqBanksTransactionBill getTurqBanksTransactionBill() {
        return this.turqBanksTransactionBill;
    }

    public void setTurqBanksTransactionBill(com.turquaz.engine.dal.TurqBanksTransactionBill turqBanksTransactionBill) {
        this.turqBanksTransactionBill = turqBanksTransactionBill;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public com.turquaz.engine.dal.TurqBankCardsSecondaryAccount getTurqBankCardsSecondaryAccount() {
        return this.turqBankCardsSecondaryAccount;
    }

    public void setTurqBankCardsSecondaryAccount(com.turquaz.engine.dal.TurqBankCardsSecondaryAccount turqBankCardsSecondaryAccount) {
        this.turqBankCardsSecondaryAccount = turqBankCardsSecondaryAccount;
    }

    public com.turquaz.engine.dal.TurqBanksTransactionType getTurqBanksTransactionType() {
        return this.turqBanksTransactionType;
    }

    public void setTurqBanksTransactionType(com.turquaz.engine.dal.TurqBanksTransactionType turqBanksTransactionType) {
        this.turqBanksTransactionType = turqBanksTransactionType;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("bankTransactionsId", getBankTransactionsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBanksTransaction) ) return false;
        TurqBanksTransaction castOther = (TurqBanksTransaction) other;
        return new EqualsBuilder()
            .append(this.getBankTransactionsId(), castOther.getBankTransactionsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBankTransactionsId())
            .toHashCode();
    }

}
