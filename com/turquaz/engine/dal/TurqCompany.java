package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCompany implements Serializable {

    /** identifier field */
    private java.lang.Integer companiesId;

    /** persistent field */
    private java.lang.String companyName;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date updateDate;

    /** persistent field */
    private Set turqAccountingAccounts;

    /** persistent field */
    private Set turqTradebillTradebills;

    /** persistent field */
    private Set turqChequeRolls;

    /** persistent field */
    private Set turqBanksCards;

    /** persistent field */
    private Set turqChequeCheques;

    /** persistent field */
    private Set turqInventoryGroups;

    /** persistent field */
    private Set turqOrderGroups;

    /** persistent field */
    private Set turqCurrencies;

    /** persistent field */
    private Set turqCurrentGroups;

    /** persistent field */
    private Set turqInventoryUnits;

    /** persistent field */
    private Set turqBills;

    /** persistent field */
    private Set turqInventoryCards;

    /** persistent field */
    private Set turqCurrentTransactionTypes;

    /** persistent field */
    private Set turqConsignments;

    /** persistent field */
    private Set turqCurrentCards;

    /** persistent field */
    private Set turqOrders;

    /** persistent field */
    private Set turqInventoryWarehouses;

    /** persistent field */
    private Set turqTradebillRolls;

    /** persistent field */
    private Set turqBankSecondaryAccounts;

    /** persistent field */
    private Set turqBillGroups;

    /** persistent field */
    private Set turqConsignmentGroups;

    /** full constructor */
    public TurqCompany(java.lang.String companyName, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate, Set turqAccountingAccounts, Set turqTradebillTradebills, Set turqChequeRolls, Set turqBanksCards, Set turqChequeCheques, Set turqInventoryGroups, Set turqOrderGroups, Set turqCurrencies, Set turqCurrentGroups, Set turqInventoryUnits, Set turqBills, Set turqInventoryCards, Set turqCurrentTransactionTypes, Set turqConsignments, Set turqCurrentCards, Set turqOrders, Set turqInventoryWarehouses, Set turqTradebillRolls, Set turqBankSecondaryAccounts, Set turqBillGroups, Set turqConsignmentGroups) {
        this.companyName = companyName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
        this.turqAccountingAccounts = turqAccountingAccounts;
        this.turqTradebillTradebills = turqTradebillTradebills;
        this.turqChequeRolls = turqChequeRolls;
        this.turqBanksCards = turqBanksCards;
        this.turqChequeCheques = turqChequeCheques;
        this.turqInventoryGroups = turqInventoryGroups;
        this.turqOrderGroups = turqOrderGroups;
        this.turqCurrencies = turqCurrencies;
        this.turqCurrentGroups = turqCurrentGroups;
        this.turqInventoryUnits = turqInventoryUnits;
        this.turqBills = turqBills;
        this.turqInventoryCards = turqInventoryCards;
        this.turqCurrentTransactionTypes = turqCurrentTransactionTypes;
        this.turqConsignments = turqConsignments;
        this.turqCurrentCards = turqCurrentCards;
        this.turqOrders = turqOrders;
        this.turqInventoryWarehouses = turqInventoryWarehouses;
        this.turqTradebillRolls = turqTradebillRolls;
        this.turqBankSecondaryAccounts = turqBankSecondaryAccounts;
        this.turqBillGroups = turqBillGroups;
        this.turqConsignmentGroups = turqConsignmentGroups;
    }

    /** default constructor */
    public TurqCompany() {
    }

    public java.lang.Integer getCompaniesId() {
        return this.companiesId;
    }

    public void setCompaniesId(java.lang.Integer companiesId) {
        this.companiesId = companiesId;
    }

    public java.lang.String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(java.lang.String companyName) {
        this.companyName = companyName;
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

    public java.util.Set getTurqAccountingAccounts() {
        return this.turqAccountingAccounts;
    }

    public void setTurqAccountingAccounts(java.util.Set turqAccountingAccounts) {
        this.turqAccountingAccounts = turqAccountingAccounts;
    }

    public java.util.Set getTurqTradebillTradebills() {
        return this.turqTradebillTradebills;
    }

    public void setTurqTradebillTradebills(java.util.Set turqTradebillTradebills) {
        this.turqTradebillTradebills = turqTradebillTradebills;
    }

    public java.util.Set getTurqChequeRolls() {
        return this.turqChequeRolls;
    }

    public void setTurqChequeRolls(java.util.Set turqChequeRolls) {
        this.turqChequeRolls = turqChequeRolls;
    }

    public java.util.Set getTurqBanksCards() {
        return this.turqBanksCards;
    }

    public void setTurqBanksCards(java.util.Set turqBanksCards) {
        this.turqBanksCards = turqBanksCards;
    }

    public java.util.Set getTurqChequeCheques() {
        return this.turqChequeCheques;
    }

    public void setTurqChequeCheques(java.util.Set turqChequeCheques) {
        this.turqChequeCheques = turqChequeCheques;
    }

    public java.util.Set getTurqInventoryGroups() {
        return this.turqInventoryGroups;
    }

    public void setTurqInventoryGroups(java.util.Set turqInventoryGroups) {
        this.turqInventoryGroups = turqInventoryGroups;
    }

    public java.util.Set getTurqOrderGroups() {
        return this.turqOrderGroups;
    }

    public void setTurqOrderGroups(java.util.Set turqOrderGroups) {
        this.turqOrderGroups = turqOrderGroups;
    }

    public java.util.Set getTurqCurrencies() {
        return this.turqCurrencies;
    }

    public void setTurqCurrencies(java.util.Set turqCurrencies) {
        this.turqCurrencies = turqCurrencies;
    }

    public java.util.Set getTurqCurrentGroups() {
        return this.turqCurrentGroups;
    }

    public void setTurqCurrentGroups(java.util.Set turqCurrentGroups) {
        this.turqCurrentGroups = turqCurrentGroups;
    }

    public java.util.Set getTurqInventoryUnits() {
        return this.turqInventoryUnits;
    }

    public void setTurqInventoryUnits(java.util.Set turqInventoryUnits) {
        this.turqInventoryUnits = turqInventoryUnits;
    }

    public java.util.Set getTurqBills() {
        return this.turqBills;
    }

    public void setTurqBills(java.util.Set turqBills) {
        this.turqBills = turqBills;
    }

    public java.util.Set getTurqInventoryCards() {
        return this.turqInventoryCards;
    }

    public void setTurqInventoryCards(java.util.Set turqInventoryCards) {
        this.turqInventoryCards = turqInventoryCards;
    }

    public java.util.Set getTurqCurrentTransactionTypes() {
        return this.turqCurrentTransactionTypes;
    }

    public void setTurqCurrentTransactionTypes(java.util.Set turqCurrentTransactionTypes) {
        this.turqCurrentTransactionTypes = turqCurrentTransactionTypes;
    }

    public java.util.Set getTurqConsignments() {
        return this.turqConsignments;
    }

    public void setTurqConsignments(java.util.Set turqConsignments) {
        this.turqConsignments = turqConsignments;
    }

    public java.util.Set getTurqCurrentCards() {
        return this.turqCurrentCards;
    }

    public void setTurqCurrentCards(java.util.Set turqCurrentCards) {
        this.turqCurrentCards = turqCurrentCards;
    }

    public java.util.Set getTurqOrders() {
        return this.turqOrders;
    }

    public void setTurqOrders(java.util.Set turqOrders) {
        this.turqOrders = turqOrders;
    }

    public java.util.Set getTurqInventoryWarehouses() {
        return this.turqInventoryWarehouses;
    }

    public void setTurqInventoryWarehouses(java.util.Set turqInventoryWarehouses) {
        this.turqInventoryWarehouses = turqInventoryWarehouses;
    }

    public java.util.Set getTurqTradebillRolls() {
        return this.turqTradebillRolls;
    }

    public void setTurqTradebillRolls(java.util.Set turqTradebillRolls) {
        this.turqTradebillRolls = turqTradebillRolls;
    }

    public java.util.Set getTurqBankSecondaryAccounts() {
        return this.turqBankSecondaryAccounts;
    }

    public void setTurqBankSecondaryAccounts(java.util.Set turqBankSecondaryAccounts) {
        this.turqBankSecondaryAccounts = turqBankSecondaryAccounts;
    }

    public java.util.Set getTurqBillGroups() {
        return this.turqBillGroups;
    }

    public void setTurqBillGroups(java.util.Set turqBillGroups) {
        this.turqBillGroups = turqBillGroups;
    }

    public java.util.Set getTurqConsignmentGroups() {
        return this.turqConsignmentGroups;
    }

    public void setTurqConsignmentGroups(java.util.Set turqConsignmentGroups) {
        this.turqConsignmentGroups = turqConsignmentGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("companiesId", getCompaniesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCompany) ) return false;
        TurqCompany castOther = (TurqCompany) other;
        return new EqualsBuilder()
            .append(this.getCompaniesId(), castOther.getCompaniesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCompaniesId())
            .toHashCode();
    }

}
