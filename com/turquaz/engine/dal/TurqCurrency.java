package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrency implements Serializable {

    /** identifier field */
    private java.lang.Integer currenciesId;

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
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private Set turqInventoryPrices;

    /** persistent field */
    private Set turqTradebillTradebills;

    /** persistent field */
    private Set turqChequeCheques;

    /** persistent field */
    private Set turqCurrentTransactions;

    /** full constructor */
    public TurqCurrency(java.lang.Integer currenciesId, java.lang.String currenciesName, java.lang.String currenciesAbbreviation, java.lang.String currenciesCountry, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqInventoryPrices, Set turqTradebillTradebills, Set turqChequeCheques, Set turqCurrentTransactions) {
        this.currenciesId = currenciesId;
        this.currenciesName = currenciesName;
        this.currenciesAbbreviation = currenciesAbbreviation;
        this.currenciesCountry = currenciesCountry;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCompany = turqCompany;
        this.turqInventoryPrices = turqInventoryPrices;
        this.turqTradebillTradebills = turqTradebillTradebills;
        this.turqChequeCheques = turqChequeCheques;
        this.turqCurrentTransactions = turqCurrentTransactions;
    }

    /** default constructor */
    public TurqCurrency() {
    }

    public java.lang.Integer getCurrenciesId() {
        return this.currenciesId;
    }

    public void setCurrenciesId(java.lang.Integer currenciesId) {
        this.currenciesId = currenciesId;
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

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
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

    public java.util.Set getTurqChequeCheques() {
        return this.turqChequeCheques;
    }

    public void setTurqChequeCheques(java.util.Set turqChequeCheques) {
        this.turqChequeCheques = turqChequeCheques;
    }

    public java.util.Set getTurqCurrentTransactions() {
        return this.turqCurrentTransactions;
    }

    public void setTurqCurrentTransactions(java.util.Set turqCurrentTransactions) {
        this.turqCurrentTransactions = turqCurrentTransactions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currenciesId", getCurrenciesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrency) ) return false;
        TurqCurrency castOther = (TurqCurrency) other;
        return new EqualsBuilder()
            .append(this.getCurrenciesId(), castOther.getCurrenciesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrenciesId())
            .toHashCode();
    }

}
