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
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** persistent field */
    private Set turqAccountingAccounts;

    /** persistent field */
    private Set turqInventoryCardsByAccountingAccountsIdSell;

    /** persistent field */
    private Set turqInventoryCardsByAccountingAccountsIdBuy;

    /** persistent field */
    private Set turqAccountingTransactionsByAccountIdDeptor;

    /** persistent field */
    private Set turqAccountingTransactionsByAccountIdCreditor;

    /** persistent field */
    private Set turqChequeTransactionTypes;

    /** persistent field */
    private Set turqBankCardsSecondaryAccounts;

    /** persistent field */
    private Set turqCurrentCardsByAccountingCodeIdCustomer;

    /** persistent field */
    private Set turqCurrentCardsByAccountingCodeIdSupplier;

    /** persistent field */
    private Set turqTradebillTransactionTypes;

    /** persistent field */
    private Set turqBanksTransactions;

    /** full constructor */
    public TurqAccountingAccount(java.lang.String accountName, java.lang.String accountCode, java.util.Date creationDate, java.lang.String createdBy, java.util.Date updateDate, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCompany turqCompany, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, Set turqAccountingAccounts, Set turqInventoryCardsByAccountingAccountsIdSell, Set turqInventoryCardsByAccountingAccountsIdBuy, Set turqAccountingTransactionsByAccountIdDeptor, Set turqAccountingTransactionsByAccountIdCreditor, Set turqChequeTransactionTypes, Set turqBankCardsSecondaryAccounts, Set turqCurrentCardsByAccountingCodeIdCustomer, Set turqCurrentCardsByAccountingCodeIdSupplier, Set turqTradebillTransactionTypes, Set turqBanksTransactions) {
        this.accountName = accountName;
        this.accountCode = accountCode;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.turqCompany = turqCompany;
        this.turqAccountingAccount = turqAccountingAccount;
        this.turqAccountingAccounts = turqAccountingAccounts;
        this.turqInventoryCardsByAccountingAccountsIdSell = turqInventoryCardsByAccountingAccountsIdSell;
        this.turqInventoryCardsByAccountingAccountsIdBuy = turqInventoryCardsByAccountingAccountsIdBuy;
        this.turqAccountingTransactionsByAccountIdDeptor = turqAccountingTransactionsByAccountIdDeptor;
        this.turqAccountingTransactionsByAccountIdCreditor = turqAccountingTransactionsByAccountIdCreditor;
        this.turqChequeTransactionTypes = turqChequeTransactionTypes;
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
        this.turqCurrentCardsByAccountingCodeIdCustomer = turqCurrentCardsByAccountingCodeIdCustomer;
        this.turqCurrentCardsByAccountingCodeIdSupplier = turqCurrentCardsByAccountingCodeIdSupplier;
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

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public java.util.Set getTurqAccountingAccounts() {
        return this.turqAccountingAccounts;
    }

    public void setTurqAccountingAccounts(java.util.Set turqAccountingAccounts) {
        this.turqAccountingAccounts = turqAccountingAccounts;
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

    public java.util.Set getTurqAccountingTransactionsByAccountIdDeptor() {
        return this.turqAccountingTransactionsByAccountIdDeptor;
    }

    public void setTurqAccountingTransactionsByAccountIdDeptor(java.util.Set turqAccountingTransactionsByAccountIdDeptor) {
        this.turqAccountingTransactionsByAccountIdDeptor = turqAccountingTransactionsByAccountIdDeptor;
    }

    public java.util.Set getTurqAccountingTransactionsByAccountIdCreditor() {
        return this.turqAccountingTransactionsByAccountIdCreditor;
    }

    public void setTurqAccountingTransactionsByAccountIdCreditor(java.util.Set turqAccountingTransactionsByAccountIdCreditor) {
        this.turqAccountingTransactionsByAccountIdCreditor = turqAccountingTransactionsByAccountIdCreditor;
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

    public java.util.Set getTurqCurrentCardsByAccountingCodeIdCustomer() {
        return this.turqCurrentCardsByAccountingCodeIdCustomer;
    }

    public void setTurqCurrentCardsByAccountingCodeIdCustomer(java.util.Set turqCurrentCardsByAccountingCodeIdCustomer) {
        this.turqCurrentCardsByAccountingCodeIdCustomer = turqCurrentCardsByAccountingCodeIdCustomer;
    }

    public java.util.Set getTurqCurrentCardsByAccountingCodeIdSupplier() {
        return this.turqCurrentCardsByAccountingCodeIdSupplier;
    }

    public void setTurqCurrentCardsByAccountingCodeIdSupplier(java.util.Set turqCurrentCardsByAccountingCodeIdSupplier) {
        this.turqCurrentCardsByAccountingCodeIdSupplier = turqCurrentCardsByAccountingCodeIdSupplier;
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
