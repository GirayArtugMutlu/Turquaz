package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingAccount implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

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
    private java.util.Date updateDate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccountClass turqAccountingAccountClass;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccountType turqAccountingAccountType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByTopAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByParentAccount;

    /** persistent field */
    private Set turqAccountingAccountsByTopAccount;

    /** persistent field */
    private Set turqAccountingAccountsByParentAccount;

    /** persistent field */
    private Set turqBankAccountingAccounts;

    /** persistent field */
    private Set turqAccountingTransactionColumns;

    /** persistent field */
    private Set turqInventoryAccountingAccounts;

    /** persistent field */
    private Set turqBankCardsSecondaryAccounts;

    /** persistent field */
    private Set turqChequeRollAccountingAccounts;

    /** persistent field */
    private Set turqTradebillTransactionTypes;

    /** persistent field */
    private Set turqCashTransactionRows;

    /** persistent field */
    private Set turqCashCards;

    /** persistent field */
    private Set turqCurrentAccountingAccounts;

    /** full constructor */
    public TurqAccountingAccount(java.lang.String accountName, java.lang.String accountCode, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate, com.turquaz.engine.dal.TurqAccountingAccountClass turqAccountingAccountClass, com.turquaz.engine.dal.TurqAccountingAccountType turqAccountingAccountType, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByTopAccount, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByParentAccount, Set turqAccountingAccountsByTopAccount, Set turqAccountingAccountsByParentAccount, Set turqBankAccountingAccounts, Set turqAccountingTransactionColumns, Set turqInventoryAccountingAccounts, Set turqBankCardsSecondaryAccounts, Set turqChequeRollAccountingAccounts, Set turqTradebillTransactionTypes, Set turqCashTransactionRows, Set turqCashCards, Set turqCurrentAccountingAccounts) {
        this.accountName = accountName;
        this.accountCode = accountCode;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
        this.turqAccountingAccountClass = turqAccountingAccountClass;
        this.turqAccountingAccountType = turqAccountingAccountType;
        this.turqAccountingAccountByTopAccount = turqAccountingAccountByTopAccount;
        this.turqAccountingAccountByParentAccount = turqAccountingAccountByParentAccount;
        this.turqAccountingAccountsByTopAccount = turqAccountingAccountsByTopAccount;
        this.turqAccountingAccountsByParentAccount = turqAccountingAccountsByParentAccount;
        this.turqBankAccountingAccounts = turqBankAccountingAccounts;
        this.turqAccountingTransactionColumns = turqAccountingTransactionColumns;
        this.turqInventoryAccountingAccounts = turqInventoryAccountingAccounts;
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
        this.turqChequeRollAccountingAccounts = turqChequeRollAccountingAccounts;
        this.turqTradebillTransactionTypes = turqTradebillTransactionTypes;
        this.turqCashTransactionRows = turqCashTransactionRows;
        this.turqCashCards = turqCashCards;
        this.turqCurrentAccountingAccounts = turqCurrentAccountingAccounts;
    }

    /** default constructor */
    public TurqAccountingAccount() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
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

    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public com.turquaz.engine.dal.TurqAccountingAccountClass getTurqAccountingAccountClass() {
        return this.turqAccountingAccountClass;
    }

    public void setTurqAccountingAccountClass(com.turquaz.engine.dal.TurqAccountingAccountClass turqAccountingAccountClass) {
        this.turqAccountingAccountClass = turqAccountingAccountClass;
    }

    public com.turquaz.engine.dal.TurqAccountingAccountType getTurqAccountingAccountType() {
        return this.turqAccountingAccountType;
    }

    public void setTurqAccountingAccountType(com.turquaz.engine.dal.TurqAccountingAccountType turqAccountingAccountType) {
        this.turqAccountingAccountType = turqAccountingAccountType;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByTopAccount() {
        return this.turqAccountingAccountByTopAccount;
    }

    public void setTurqAccountingAccountByTopAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByTopAccount) {
        this.turqAccountingAccountByTopAccount = turqAccountingAccountByTopAccount;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByParentAccount() {
        return this.turqAccountingAccountByParentAccount;
    }

    public void setTurqAccountingAccountByParentAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByParentAccount) {
        this.turqAccountingAccountByParentAccount = turqAccountingAccountByParentAccount;
    }

    public java.util.Set getTurqAccountingAccountsByTopAccount() {
        return this.turqAccountingAccountsByTopAccount;
    }

    public void setTurqAccountingAccountsByTopAccount(java.util.Set turqAccountingAccountsByTopAccount) {
        this.turqAccountingAccountsByTopAccount = turqAccountingAccountsByTopAccount;
    }

    public java.util.Set getTurqAccountingAccountsByParentAccount() {
        return this.turqAccountingAccountsByParentAccount;
    }

    public void setTurqAccountingAccountsByParentAccount(java.util.Set turqAccountingAccountsByParentAccount) {
        this.turqAccountingAccountsByParentAccount = turqAccountingAccountsByParentAccount;
    }

    public java.util.Set getTurqBankAccountingAccounts() {
        return this.turqBankAccountingAccounts;
    }

    public void setTurqBankAccountingAccounts(java.util.Set turqBankAccountingAccounts) {
        this.turqBankAccountingAccounts = turqBankAccountingAccounts;
    }

    public java.util.Set getTurqAccountingTransactionColumns() {
        return this.turqAccountingTransactionColumns;
    }

    public void setTurqAccountingTransactionColumns(java.util.Set turqAccountingTransactionColumns) {
        this.turqAccountingTransactionColumns = turqAccountingTransactionColumns;
    }

    public java.util.Set getTurqInventoryAccountingAccounts() {
        return this.turqInventoryAccountingAccounts;
    }

    public void setTurqInventoryAccountingAccounts(java.util.Set turqInventoryAccountingAccounts) {
        this.turqInventoryAccountingAccounts = turqInventoryAccountingAccounts;
    }

    public java.util.Set getTurqBankCardsSecondaryAccounts() {
        return this.turqBankCardsSecondaryAccounts;
    }

    public void setTurqBankCardsSecondaryAccounts(java.util.Set turqBankCardsSecondaryAccounts) {
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
    }

    public java.util.Set getTurqChequeRollAccountingAccounts() {
        return this.turqChequeRollAccountingAccounts;
    }

    public void setTurqChequeRollAccountingAccounts(java.util.Set turqChequeRollAccountingAccounts) {
        this.turqChequeRollAccountingAccounts = turqChequeRollAccountingAccounts;
    }

    public java.util.Set getTurqTradebillTransactionTypes() {
        return this.turqTradebillTransactionTypes;
    }

    public void setTurqTradebillTransactionTypes(java.util.Set turqTradebillTransactionTypes) {
        this.turqTradebillTransactionTypes = turqTradebillTransactionTypes;
    }

    public java.util.Set getTurqCashTransactionRows() {
        return this.turqCashTransactionRows;
    }

    public void setTurqCashTransactionRows(java.util.Set turqCashTransactionRows) {
        this.turqCashTransactionRows = turqCashTransactionRows;
    }

    public java.util.Set getTurqCashCards() {
        return this.turqCashCards;
    }

    public void setTurqCashCards(java.util.Set turqCashCards) {
        this.turqCashCards = turqCashCards;
    }

    public java.util.Set getTurqCurrentAccountingAccounts() {
        return this.turqCurrentAccountingAccounts;
    }

    public void setTurqCurrentAccountingAccounts(java.util.Set turqCurrentAccountingAccounts) {
        this.turqCurrentAccountingAccounts = turqCurrentAccountingAccounts;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingAccount) ) return false;
        TurqAccountingAccount castOther = (TurqAccountingAccount) other;
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
