package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryCard implements Serializable {

    /** identifier field */
    private java.lang.Integer inventoryCardsId;

    /** persistent field */
    private java.lang.String cardInventoryCode;

    /** persistent field */
    private java.lang.String cardSpecialCode;

    /** persistent field */
    private java.lang.String cardName;

    /** persistent field */
    private java.lang.String cardDefinition;

    /** persistent field */
    private int cardMinimumAmount;

    /** persistent field */
    private int cardMaximumAmount;

    /** persistent field */
    private int cardVat;

    /** persistent field */
    private int cardDiscount;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date updateDate;

    /** persistent field */
    private int cardSpecialVat;

    /** persistent field */
    private java.math.BigDecimal cardSpecialVatEach;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingAccountsIdSell;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingAccountsIdBuy;

    /** persistent field */
    private Set turqInventoryPrices;

    /** persistent field */
    private Set turqInventoryTransactions;

    /** persistent field */
    private Set turqInventoryCardGroups;

    /** persistent field */
    private Set turqInventoryCardUnits;

    /** full constructor */
    public TurqInventoryCard(java.lang.String cardInventoryCode, java.lang.String cardSpecialCode, java.lang.String cardName, java.lang.String cardDefinition, int cardMinimumAmount, int cardMaximumAmount, int cardVat, int cardDiscount, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate, int cardSpecialVat, java.math.BigDecimal cardSpecialVatEach, com.turquaz.engine.dal.TurqCompany turqCompany, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingAccountsIdSell, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingAccountsIdBuy, Set turqInventoryPrices, Set turqInventoryTransactions, Set turqInventoryCardGroups, Set turqInventoryCardUnits) {
        this.cardInventoryCode = cardInventoryCode;
        this.cardSpecialCode = cardSpecialCode;
        this.cardName = cardName;
        this.cardDefinition = cardDefinition;
        this.cardMinimumAmount = cardMinimumAmount;
        this.cardMaximumAmount = cardMaximumAmount;
        this.cardVat = cardVat;
        this.cardDiscount = cardDiscount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
        this.cardSpecialVat = cardSpecialVat;
        this.cardSpecialVatEach = cardSpecialVatEach;
        this.turqCompany = turqCompany;
        this.turqAccountingAccountByAccountingAccountsIdSell = turqAccountingAccountByAccountingAccountsIdSell;
        this.turqAccountingAccountByAccountingAccountsIdBuy = turqAccountingAccountByAccountingAccountsIdBuy;
        this.turqInventoryPrices = turqInventoryPrices;
        this.turqInventoryTransactions = turqInventoryTransactions;
        this.turqInventoryCardGroups = turqInventoryCardGroups;
        this.turqInventoryCardUnits = turqInventoryCardUnits;
    }

    /** default constructor */
    public TurqInventoryCard() {
    }

    public java.lang.Integer getInventoryCardsId() {
        return this.inventoryCardsId;
    }

    public void setInventoryCardsId(java.lang.Integer inventoryCardsId) {
        this.inventoryCardsId = inventoryCardsId;
    }

    public java.lang.String getCardInventoryCode() {
        return this.cardInventoryCode;
    }

    public void setCardInventoryCode(java.lang.String cardInventoryCode) {
        this.cardInventoryCode = cardInventoryCode;
    }

    public java.lang.String getCardSpecialCode() {
        return this.cardSpecialCode;
    }

    public void setCardSpecialCode(java.lang.String cardSpecialCode) {
        this.cardSpecialCode = cardSpecialCode;
    }

    public java.lang.String getCardName() {
        return this.cardName;
    }

    public void setCardName(java.lang.String cardName) {
        this.cardName = cardName;
    }

    public java.lang.String getCardDefinition() {
        return this.cardDefinition;
    }

    public void setCardDefinition(java.lang.String cardDefinition) {
        this.cardDefinition = cardDefinition;
    }

    public int getCardMinimumAmount() {
        return this.cardMinimumAmount;
    }

    public void setCardMinimumAmount(int cardMinimumAmount) {
        this.cardMinimumAmount = cardMinimumAmount;
    }

    public int getCardMaximumAmount() {
        return this.cardMaximumAmount;
    }

    public void setCardMaximumAmount(int cardMaximumAmount) {
        this.cardMaximumAmount = cardMaximumAmount;
    }

    public int getCardVat() {
        return this.cardVat;
    }

    public void setCardVat(int cardVat) {
        this.cardVat = cardVat;
    }

    public int getCardDiscount() {
        return this.cardDiscount;
    }

    public void setCardDiscount(int cardDiscount) {
        this.cardDiscount = cardDiscount;
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

    public int getCardSpecialVat() {
        return this.cardSpecialVat;
    }

    public void setCardSpecialVat(int cardSpecialVat) {
        this.cardSpecialVat = cardSpecialVat;
    }

    public java.math.BigDecimal getCardSpecialVatEach() {
        return this.cardSpecialVatEach;
    }

    public void setCardSpecialVatEach(java.math.BigDecimal cardSpecialVatEach) {
        this.cardSpecialVatEach = cardSpecialVatEach;
    }

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByAccountingAccountsIdSell() {
        return this.turqAccountingAccountByAccountingAccountsIdSell;
    }

    public void setTurqAccountingAccountByAccountingAccountsIdSell(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingAccountsIdSell) {
        this.turqAccountingAccountByAccountingAccountsIdSell = turqAccountingAccountByAccountingAccountsIdSell;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByAccountingAccountsIdBuy() {
        return this.turqAccountingAccountByAccountingAccountsIdBuy;
    }

    public void setTurqAccountingAccountByAccountingAccountsIdBuy(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountingAccountsIdBuy) {
        this.turqAccountingAccountByAccountingAccountsIdBuy = turqAccountingAccountByAccountingAccountsIdBuy;
    }

    public java.util.Set getTurqInventoryPrices() {
        return this.turqInventoryPrices;
    }

    public void setTurqInventoryPrices(java.util.Set turqInventoryPrices) {
        this.turqInventoryPrices = turqInventoryPrices;
    }

    public java.util.Set getTurqInventoryTransactions() {
        return this.turqInventoryTransactions;
    }

    public void setTurqInventoryTransactions(java.util.Set turqInventoryTransactions) {
        this.turqInventoryTransactions = turqInventoryTransactions;
    }

    public java.util.Set getTurqInventoryCardGroups() {
        return this.turqInventoryCardGroups;
    }

    public void setTurqInventoryCardGroups(java.util.Set turqInventoryCardGroups) {
        this.turqInventoryCardGroups = turqInventoryCardGroups;
    }

    public java.util.Set getTurqInventoryCardUnits() {
        return this.turqInventoryCardUnits;
    }

    public void setTurqInventoryCardUnits(java.util.Set turqInventoryCardUnits) {
        this.turqInventoryCardUnits = turqInventoryCardUnits;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryCardsId", getInventoryCardsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqInventoryCard) ) return false;
        TurqInventoryCard castOther = (TurqInventoryCard) other;
        return new EqualsBuilder()
            .append(this.getInventoryCardsId(), castOther.getInventoryCardsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryCardsId())
            .toHashCode();
    }

}
