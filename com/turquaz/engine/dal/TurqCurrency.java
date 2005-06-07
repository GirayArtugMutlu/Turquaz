package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrency implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.lang.String currenciesName;

    /** persistent field */
    private java.lang.String currenciesAbbreviation;

    /** persistent field */
    private java.lang.String currenciesCountry;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private boolean defaultCurrency;

    /** nullable persistent field */
    private boolean constant;

    /** persistent field */
    private Set turqInventoryPrices;

    /** persistent field */
    private Set turqTradebillTradebills;

    /** persistent field */
    private Set turqBanksCards;

    /** persistent field */
    private Set turqChequeCheques;

    /** persistent field */
    private Set turqCurrencyExchangeRatesByBaseCurrencyId;

    /** persistent field */
    private Set turqCurrencyExchangeRatesByExchangeCurrencyId;

    /** full constructor */
    public TurqCurrency(java.lang.String currenciesName, java.lang.String currenciesAbbreviation, java.lang.String currenciesCountry, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, boolean defaultCurrency, boolean constant, Set turqInventoryPrices, Set turqTradebillTradebills, Set turqBanksCards, Set turqChequeCheques, Set turqCurrencyExchangeRatesByBaseCurrencyId, Set turqCurrencyExchangeRatesByExchangeCurrencyId) {
        this.currenciesName = currenciesName;
        this.currenciesAbbreviation = currenciesAbbreviation;
        this.currenciesCountry = currenciesCountry;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.defaultCurrency = defaultCurrency;
        this.constant = constant;
        this.turqInventoryPrices = turqInventoryPrices;
        this.turqTradebillTradebills = turqTradebillTradebills;
        this.turqBanksCards = turqBanksCards;
        this.turqChequeCheques = turqChequeCheques;
        this.turqCurrencyExchangeRatesByBaseCurrencyId = turqCurrencyExchangeRatesByBaseCurrencyId;
        this.turqCurrencyExchangeRatesByExchangeCurrencyId = turqCurrencyExchangeRatesByExchangeCurrencyId;
    }

    /** default constructor */
    public TurqCurrency() {
    }

    /** minimal constructor */
    public TurqCurrency(java.lang.String currenciesName, java.lang.String currenciesAbbreviation, java.lang.String currenciesCountry, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, boolean defaultCurrency, Set turqInventoryPrices, Set turqTradebillTradebills, Set turqBanksCards, Set turqChequeCheques, Set turqCurrencyExchangeRatesByBaseCurrencyId, Set turqCurrencyExchangeRatesByExchangeCurrencyId) {
        this.currenciesName = currenciesName;
        this.currenciesAbbreviation = currenciesAbbreviation;
        this.currenciesCountry = currenciesCountry;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.defaultCurrency = defaultCurrency;
        this.turqInventoryPrices = turqInventoryPrices;
        this.turqTradebillTradebills = turqTradebillTradebills;
        this.turqBanksCards = turqBanksCards;
        this.turqChequeCheques = turqChequeCheques;
        this.turqCurrencyExchangeRatesByBaseCurrencyId = turqCurrencyExchangeRatesByBaseCurrencyId;
        this.turqCurrencyExchangeRatesByExchangeCurrencyId = turqCurrencyExchangeRatesByExchangeCurrencyId;
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getCurrenciesName() {
        return this.currenciesName;
    }

    public void setCurrenciesName(java.lang.String currenciesName) {
        this.currenciesName = currenciesName;
    }

    public java.lang.String getCurrenciesAbbreviation() {
        return this.currenciesAbbreviation;
    }

    public void setCurrenciesAbbreviation(java.lang.String currenciesAbbreviation) {
        this.currenciesAbbreviation = currenciesAbbreviation;
    }

    public java.lang.String getCurrenciesCountry() {
        return this.currenciesCountry;
    }

    public void setCurrenciesCountry(java.lang.String currenciesCountry) {
        this.currenciesCountry = currenciesCountry;
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

    public boolean isDefaultCurrency() {
        return this.defaultCurrency;
    }

    public void setDefaultCurrency(boolean defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public boolean isConstant() {
        return this.constant;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    public java.util.Set getTurqInventoryPrices() {
        return this.turqInventoryPrices;
    }

    public void setTurqInventoryPrices(java.util.Set turqInventoryPrices) {
        this.turqInventoryPrices = turqInventoryPrices;
    }

    public java.util.Set getTurqTradebillTradebills() {
        return this.turqTradebillTradebills;
    }

    public void setTurqTradebillTradebills(java.util.Set turqTradebillTradebills) {
        this.turqTradebillTradebills = turqTradebillTradebills;
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

    public java.util.Set getTurqCurrencyExchangeRatesByBaseCurrencyId() {
        return this.turqCurrencyExchangeRatesByBaseCurrencyId;
    }

    public void setTurqCurrencyExchangeRatesByBaseCurrencyId(java.util.Set turqCurrencyExchangeRatesByBaseCurrencyId) {
        this.turqCurrencyExchangeRatesByBaseCurrencyId = turqCurrencyExchangeRatesByBaseCurrencyId;
    }

    public java.util.Set getTurqCurrencyExchangeRatesByExchangeCurrencyId() {
        return this.turqCurrencyExchangeRatesByExchangeCurrencyId;
    }

    public void setTurqCurrencyExchangeRatesByExchangeCurrencyId(java.util.Set turqCurrencyExchangeRatesByExchangeCurrencyId) {
        this.turqCurrencyExchangeRatesByExchangeCurrencyId = turqCurrencyExchangeRatesByExchangeCurrencyId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrency) ) return false;
        TurqCurrency castOther = (TurqCurrency) other;
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
