package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBanksCard implements Serializable {

    /** identifier field */
    private java.lang.Integer banksCardsId;

    /** persistent field */
    private java.lang.String bankName;

    /** persistent field */
    private java.lang.String bankBranchName;

    /** persistent field */
    private java.lang.String bankAccountNo;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private Set turqChequeRolls;

    /** persistent field */
    private Set turqChequeCheques;

    /** persistent field */
    private Set turqBankCardsSecondaryAccounts;

    /** persistent field */
    private Set turqBanksTransactionBills;

    /** persistent field */
    private Set turqTradebillRolls;

    /** full constructor */
    public TurqBanksCard(java.lang.Integer banksCardsId, java.lang.String bankName, java.lang.String bankBranchName, java.lang.String bankAccountNo, java.lang.String createdBy, java.lang.String updatedBy, java.util.Date creationDate, java.util.Date lastModified, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqChequeRolls, Set turqChequeCheques, Set turqBankCardsSecondaryAccounts, Set turqBanksTransactionBills, Set turqTradebillRolls) {
        this.banksCardsId = banksCardsId;
        this.bankName = bankName;
        this.bankBranchName = bankBranchName;
        this.bankAccountNo = bankAccountNo;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.turqCompany = turqCompany;
        this.turqChequeRolls = turqChequeRolls;
        this.turqChequeCheques = turqChequeCheques;
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
        this.turqBanksTransactionBills = turqBanksTransactionBills;
        this.turqTradebillRolls = turqTradebillRolls;
    }

    /** default constructor */
    public TurqBanksCard() {
    }

    public java.lang.Integer getBanksCardsId() {
        return this.banksCardsId;
    }

    public void setBanksCardsId(java.lang.Integer banksCardsId) {
        this.banksCardsId = banksCardsId;
    }

    public java.lang.String getBankName() {
        return this.bankName;
    }

    public void setBankName(java.lang.String bankName) {
        this.bankName = bankName;
    }

    public java.lang.String getBankBranchName() {
        return this.bankBranchName;
    }

    public void setBankBranchName(java.lang.String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public java.lang.String getBankAccountNo() {
        return this.bankAccountNo;
    }

    public void setBankAccountNo(java.lang.String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
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

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public java.util.Set getTurqChequeRolls() {
        return this.turqChequeRolls;
    }

    public void setTurqChequeRolls(java.util.Set turqChequeRolls) {
        this.turqChequeRolls = turqChequeRolls;
    }

    public java.util.Set getTurqChequeCheques() {
        return this.turqChequeCheques;
    }

    public void setTurqChequeCheques(java.util.Set turqChequeCheques) {
        this.turqChequeCheques = turqChequeCheques;
    }

    public java.util.Set getTurqBankCardsSecondaryAccounts() {
        return this.turqBankCardsSecondaryAccounts;
    }

    public void setTurqBankCardsSecondaryAccounts(java.util.Set turqBankCardsSecondaryAccounts) {
        this.turqBankCardsSecondaryAccounts = turqBankCardsSecondaryAccounts;
    }

    public java.util.Set getTurqBanksTransactionBills() {
        return this.turqBanksTransactionBills;
    }

    public void setTurqBanksTransactionBills(java.util.Set turqBanksTransactionBills) {
        this.turqBanksTransactionBills = turqBanksTransactionBills;
    }

    public java.util.Set getTurqTradebillRolls() {
        return this.turqTradebillRolls;
    }

    public void setTurqTradebillRolls(java.util.Set turqTradebillRolls) {
        this.turqTradebillRolls = turqTradebillRolls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("banksCardsId", getBanksCardsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBanksCard) ) return false;
        TurqBanksCard castOther = (TurqBanksCard) other;
        return new EqualsBuilder()
            .append(this.getBanksCardsId(), castOther.getBanksCardsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBanksCardsId())
            .toHashCode();
    }

}