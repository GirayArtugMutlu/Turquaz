package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingAccount implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingAccountsId;

    /** persistent field */
    private java.lang.String accountName;

    /** persistent field */
    private java.lang.String accountCode;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date updateDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByTopAccount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByParentAccount;

    /** persistent field */
    private Set turqAccountingAccountsByTopAccount;

    /** persistent field */
    private Set turqAccountingAccountsByParentAccount;

    /** persistent field */
    private Set turqInventoryCardsByAccountingAccountsIdSell;

    /** persistent field */
    private Set turqInventoryCardsByAccountingAccountsIdBuy;

    /** persistent field */
    private Set turqAccountingTransactionColumns;

    /** persistent field */
    private Set turqChequeTransactionTypes;

    /** persistent field */
    private Set turqBankCardsSecondaryAccounts;

    /** persistent field */
    private Set turqCurrentCards;

    /** persistent field */
    private Set turqTradebillTransactionTypes;

    /** persistent field */
    private Set turqBanksTransactions;

    /** full constructor */
    public TurqAccountingAccount(java.lang.String accountName, java.lang.String accountCode, java.util.Date creationDate, java.lang.String createdBy, java.util.Date updateDate, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCompany turqCompany, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByTopAccount, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByParentAccount, Set turqAccountingAccountsByTopAccount, Set turqAccountingAccountsByParentAccount, Set turqInventoryCardsByAccountingAccountsIdSell, Set turqInventoryCardsByAccountingAccountsIdBuy, Set turqAccountingTransactionColumns, Set turqChequeTransactionTypes, Set turqBankCardsSecondaryAccounts, Set turqCurrentCards, Set turqTradebillTransactionTypes, Set turqBanksTransactions) {
        this.accountName = accountName;
        this.accountCode = accountCode;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.turqCompany = turqCompany;
        this.turqAccountingAccountByTopAccount = turqAccountingAccountByTopAccount;
        this.turqAccountingAccountByParentAccount = turqAccountingAccountByParentAccount;
        this.turqAccountingAccountsByTopAccount = turqAccountingAccountsByTopAccount;
        this.turqAccountingAccountsByParentAccount = turqAccountingAccountsByParentAccount;
        this.turqInventoryCardsByAccountingAccountsIdSell = turqInventoryCardsByAccountingAccountsIdSell;
        this.turqInventoryCardsByAccountingAccountsIdBuy = turqInventoryCardsByAccountingAccountsIdBuy;
        this.turqAccountingTransactionColumns = turqAccountingTransactionColumns;
        this.turqChequeTransactionTypes = turqChequeTransactionTypes;
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
        this.turqCurrentCards = turqCurrentCards;
        this.turqTradebillTransactionTypes = turqTradebillTransactionTypes;
        this.turqBanksTransactions = turqBanksTransactions;
    }

    /** default constructor */
    public TurqAccountingAccount() {
    }

    public java.lang.Integer getAccountingAccountsId() {
        return this.accountingAccountsId;
    }

    public void setAccountingAccountsId(java.lang.Integer accountingAccountsId) {
        this.accountingAccountsId = accountingAccountsId;
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

    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public java.lang.String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(java.lang.String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
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

    public java.util.Set getTurqInventoryCardsByAccountingAccountsIdSell() {
        return this.turqInventoryCardsByAccountingAccountsIdSell;
    }

    public void setTurqInventoryCardsByAccountingAccountsIdSell(java.util.Set turqInventoryCardsByAccountingAccountsIdSell) {
        this.turqInventoryCardsByAccountingAccountsIdSell = turqInventoryCardsByAccountingAccountsIdSell;
    }

    public java.util.Set getTurqInventoryCardsByAccountingAccountsIdBuy() {
        return this.turqInventoryCardsByAccountingAccountsIdBuy;
    }

    public void setTurqInventoryCardsByAccountingAccountsIdBuy(java.util.Set turqInventoryCardsByAccountingAccountsIdBuy) {
        this.turqInventoryCardsByAccountingAccountsIdBuy = turqInventoryCardsByAccountingAccountsIdBuy;
    }

    public java.util.Set getTurqAccountingTransactionColumns() {
        return this.turqAccountingTransactionColumns;
    }

    public void setTurqAccountingTransactionColumns(java.util.Set turqAccountingTransactionColumns) {
        this.turqAccountingTransactionColumns = turqAccountingTransactionColumns;
    }

    public java.util.Set getTurqChequeTransactionTypes() {
        return this.turqChequeTransactionTypes;
    }

    public void setTurqChequeTransactionTypes(java.util.Set turqChequeTransactionTypes) {
        this.turqChequeTransactionTypes = turqChequeTransactionTypes;
    }

    public java.util.Set getTurqBankCardsSecondaryAccounts() {
        return this.turqBankCardsSecondaryAccounts;
    }

    public void setTurqBankCardsSecondaryAccounts(java.util.Set turqBankCardsSecondaryAccounts) {
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
    }

    public java.util.Set getTurqCurrentCards() {
        return this.turqCurrentCards;
    }

    public void setTurqCurrentCards(java.util.Set turqCurrentCards) {
        this.turqCurrentCards = turqCurrentCards;
    }

    public java.util.Set getTurqTradebillTransactionTypes() {
        return this.turqTradebillTransactionTypes;
    }

    public void setTurqTradebillTransactionTypes(java.util.Set turqTradebillTransactionTypes) {
        this.turqTradebillTransactionTypes = turqTradebillTransactionTypes;
    }

    public java.util.Set getTurqBanksTransactions() {
        return this.turqBanksTransactions;
    }

    public void setTurqBanksTransactions(java.util.Set turqBanksTransactions) {
        this.turqBanksTransactions = turqBanksTransactions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("accountingAccountsId", getAccountingAccountsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingAccount) ) return false;
        TurqAccountingAccount castOther = (TurqAccountingAccount) other;
        return new EqualsBuilder()
            .append(this.getAccountingAccountsId(), castOther.getAccountingAccountsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccountingAccountsId())
            .toHashCode();
    }

}
