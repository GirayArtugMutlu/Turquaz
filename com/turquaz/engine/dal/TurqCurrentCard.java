package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentCard implements Serializable {

    /** identifier field */
    private java.lang.Integer currentCardsId;

    /** persistent field */
    private java.lang.String cardsCurrentCode;

    /** persistent field */
    private java.lang.String cardsName;

    /** persistent field */
    private java.lang.String cardsDefinition;

    /** persistent field */
    private java.lang.String cardsAddress;

    /** persistent field */
    private java.math.BigDecimal cardsDiscountRate;

    /** persistent field */
    private java.math.BigDecimal cardsDiscountPayment;

    /** persistent field */
    private java.math.BigDecimal cardsCreditLimit;

    /** persistent field */
    private java.math.BigDecimal cardsRiskLimit;

    /** persistent field */
    private java.lang.String cardsTaxDepartment;

    /** persistent field */
    private java.lang.String cardsTaxNumber;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingCodeIdCustomer;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingCodeIdSupplier;

    /** persistent field */
    private Set turqChequeRolls;

    /** persistent field */
    private Set turqCurrentContacts;

    /** persistent field */
    private Set turqConsignments;

    /** persistent field */
    private Set turqOrders;

    /** persistent field */
    private Set turqCurrentTransactions;

    /** persistent field */
    private Set turqTradebillRolls;

    /** persistent field */
    private Set turqCurrentCardsGroups;

    /** persistent field */
    private Set turqCurrentCardsPhones;

    /** persistent field */
    private Set turqBanksTransactions;

    /** persistent field */
    private Set turqBills;

    /** full constructor */
    public TurqCurrentCard(java.lang.String cardsCurrentCode, java.lang.String cardsName, java.lang.String cardsDefinition, java.lang.String cardsAddress, java.math.BigDecimal cardsDiscountRate, java.math.BigDecimal cardsDiscountPayment, java.math.BigDecimal cardsCreditLimit, java.math.BigDecimal cardsRiskLimit, java.lang.String cardsTaxDepartment, java.lang.String cardsTaxNumber, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCompany turqCompany, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingCodeIdCustomer, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingCodeIdSupplier, Set turqChequeRolls, Set turqCurrentContacts, Set turqConsignments, Set turqOrders, Set turqCurrentTransactions, Set turqTradebillRolls, Set turqCurrentCardsGroups, Set turqCurrentCardsPhones, Set turqBanksTransactions, Set turqBills) {
        this.cardsCurrentCode = cardsCurrentCode;
        this.cardsName = cardsName;
        this.cardsDefinition = cardsDefinition;
        this.cardsAddress = cardsAddress;
        this.cardsDiscountRate = cardsDiscountRate;
        this.cardsDiscountPayment = cardsDiscountPayment;
        this.cardsCreditLimit = cardsCreditLimit;
        this.cardsRiskLimit = cardsRiskLimit;
        this.cardsTaxDepartment = cardsTaxDepartment;
        this.cardsTaxNumber = cardsTaxNumber;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqCompany = turqCompany;
        this.turqAccountingAccountByAccountingCodeIdCustomer = turqAccountingAccountByAccountingCodeIdCustomer;
        this.turqAccountingAccountByAccountingCodeIdSupplier = turqAccountingAccountByAccountingCodeIdSupplier;
        this.turqChequeRolls = turqChequeRolls;
        this.turqCurrentContacts = turqCurrentContacts;
        this.turqConsignments = turqConsignments;
        this.turqOrders = turqOrders;
        this.turqCurrentTransactions = turqCurrentTransactions;
        this.turqTradebillRolls = turqTradebillRolls;
        this.turqCurrentCardsGroups = turqCurrentCardsGroups;
        this.turqCurrentCardsPhones = turqCurrentCardsPhones;
        this.turqBanksTransactions = turqBanksTransactions;
        this.turqBills = turqBills;
    }

    /** default constructor */
    public TurqCurrentCard() {
    }

    public java.lang.Integer getCurrentCardsId() {
        return this.currentCardsId;
    }

    public void setCurrentCardsId(java.lang.Integer currentCardsId) {
        this.currentCardsId = currentCardsId;
    }

    public java.lang.String getCardsCurrentCode() {
        return this.cardsCurrentCode;
    }

    public void setCardsCurrentCode(java.lang.String cardsCurrentCode) {
        this.cardsCurrentCode = cardsCurrentCode;
    }

    public java.lang.String getCardsName() {
        return this.cardsName;
    }

    public void setCardsName(java.lang.String cardsName) {
        this.cardsName = cardsName;
    }

    public java.lang.String getCardsDefinition() {
        return this.cardsDefinition;
    }

    public void setCardsDefinition(java.lang.String cardsDefinition) {
        this.cardsDefinition = cardsDefinition;
    }

    public java.lang.String getCardsAddress() {
        return this.cardsAddress;
    }

    public void setCardsAddress(java.lang.String cardsAddress) {
        this.cardsAddress = cardsAddress;
    }

    public java.math.BigDecimal getCardsDiscountRate() {
        return this.cardsDiscountRate;
    }

    public void setCardsDiscountRate(java.math.BigDecimal cardsDiscountRate) {
        this.cardsDiscountRate = cardsDiscountRate;
    }

    public java.math.BigDecimal getCardsDiscountPayment() {
        return this.cardsDiscountPayment;
    }

    public void setCardsDiscountPayment(java.math.BigDecimal cardsDiscountPayment) {
        this.cardsDiscountPayment = cardsDiscountPayment;
    }

    public java.math.BigDecimal getCardsCreditLimit() {
        return this.cardsCreditLimit;
    }

    public void setCardsCreditLimit(java.math.BigDecimal cardsCreditLimit) {
        this.cardsCreditLimit = cardsCreditLimit;
    }

    public java.math.BigDecimal getCardsRiskLimit() {
        return this.cardsRiskLimit;
    }

    public void setCardsRiskLimit(java.math.BigDecimal cardsRiskLimit) {
        this.cardsRiskLimit = cardsRiskLimit;
    }

    public java.lang.String getCardsTaxDepartment() {
        return this.cardsTaxDepartment;
    }

    public void setCardsTaxDepartment(java.lang.String cardsTaxDepartment) {
        this.cardsTaxDepartment = cardsTaxDepartment;
    }

    public java.lang.String getCardsTaxNumber() {
        return this.cardsTaxNumber;
    }

    public void setCardsTaxNumber(java.lang.String cardsTaxNumber) {
        this.cardsTaxNumber = cardsTaxNumber;
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

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByAccountingCodeIdCustomer() {
        return this.turqAccountingAccountByAccountingCodeIdCustomer;
    }

    public void setTurqAccountingAccountByAccountingCodeIdCustomer(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingCodeIdCustomer) {
        this.turqAccountingAccountByAccountingCodeIdCustomer = turqAccountingAccountByAccountingCodeIdCustomer;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByAccountingCodeIdSupplier() {
        return this.turqAccountingAccountByAccountingCodeIdSupplier;
    }

    public void setTurqAccountingAccountByAccountingCodeIdSupplier(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingCodeIdSupplier) {
        this.turqAccountingAccountByAccountingCodeIdSupplier = turqAccountingAccountByAccountingCodeIdSupplier;
    }

    public java.util.Set getTurqChequeRolls() {
        return this.turqChequeRolls;
    }

    public void setTurqChequeRolls(java.util.Set turqChequeRolls) {
        this.turqChequeRolls = turqChequeRolls;
    }

    public java.util.Set getTurqCurrentContacts() {
        return this.turqCurrentContacts;
    }

    public void setTurqCurrentContacts(java.util.Set turqCurrentContacts) {
        this.turqCurrentContacts = turqCurrentContacts;
    }

    public java.util.Set getTurqConsignments() {
        return this.turqConsignments;
    }

    public void setTurqConsignments(java.util.Set turqConsignments) {
        this.turqConsignments = turqConsignments;
    }

    public java.util.Set getTurqOrders() {
        return this.turqOrders;
    }

    public void setTurqOrders(java.util.Set turqOrders) {
        this.turqOrders = turqOrders;
    }

    public java.util.Set getTurqCurrentTransactions() {
        return this.turqCurrentTransactions;
    }

    public void setTurqCurrentTransactions(java.util.Set turqCurrentTransactions) {
        this.turqCurrentTransactions = turqCurrentTransactions;
    }

    public java.util.Set getTurqTradebillRolls() {
        return this.turqTradebillRolls;
    }

    public void setTurqTradebillRolls(java.util.Set turqTradebillRolls) {
        this.turqTradebillRolls = turqTradebillRolls;
    }

    public java.util.Set getTurqCurrentCardsGroups() {
        return this.turqCurrentCardsGroups;
    }

    public void setTurqCurrentCardsGroups(java.util.Set turqCurrentCardsGroups) {
        this.turqCurrentCardsGroups = turqCurrentCardsGroups;
    }

    public java.util.Set getTurqCurrentCardsPhones() {
        return this.turqCurrentCardsPhones;
    }

    public void setTurqCurrentCardsPhones(java.util.Set turqCurrentCardsPhones) {
        this.turqCurrentCardsPhones = turqCurrentCardsPhones;
    }

    public java.util.Set getTurqBanksTransactions() {
        return this.turqBanksTransactions;
    }

    public void setTurqBanksTransactions(java.util.Set turqBanksTransactions) {
        this.turqBanksTransactions = turqBanksTransactions;
    }

    public java.util.Set getTurqBills() {
        return this.turqBills;
    }

    public void setTurqBills(java.util.Set turqBills) {
        this.turqBills = turqBills;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentCardsId", getCurrentCardsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentCard) ) return false;
        TurqCurrentCard castOther = (TurqCurrentCard) other;
        return new EqualsBuilder()
            .append(this.getCurrentCardsId(), castOther.getCurrentCardsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentCardsId())
            .toHashCode();
    }

}
