package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrencyExchangeRate implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.util.Date exhangeRatesDate;

    /** persistent field */
    private java.math.BigDecimal exchangeRatio;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrency turqCurrencyByBaseCurrencyId;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrency turqCurrencyByExchangeCurrencyId;

    /** full constructor */
    public TurqCurrencyExchangeRate(java.util.Date exhangeRatesDate, java.math.BigDecimal exchangeRatio, com.turquaz.engine.dal.TurqCurrency turqCurrencyByBaseCurrencyId, com.turquaz.engine.dal.TurqCurrency turqCurrencyByExchangeCurrencyId) {
        this.exhangeRatesDate = exhangeRatesDate;
        this.exchangeRatio = exchangeRatio;
        this.turqCurrencyByBaseCurrencyId = turqCurrencyByBaseCurrencyId;
        this.turqCurrencyByExchangeCurrencyId = turqCurrencyByExchangeCurrencyId;
    }

    /** default constructor */
    public TurqCurrencyExchangeRate() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.util.Date getExhangeRatesDate() {
        return this.exhangeRatesDate;
    }

    public void setExhangeRatesDate(java.util.Date exhangeRatesDate) {
        this.exhangeRatesDate = exhangeRatesDate;
    }

    public java.math.BigDecimal getExchangeRatio() {
        return this.exchangeRatio;
    }

    public void setExchangeRatio(java.math.BigDecimal exchangeRatio) {
        this.exchangeRatio = exchangeRatio;
    }

    public com.turquaz.engine.dal.TurqCurrency getTurqCurrencyByBaseCurrencyId() {
        return this.turqCurrencyByBaseCurrencyId;
    }

    public void setTurqCurrencyByBaseCurrencyId(com.turquaz.engine.dal.TurqCurrency turqCurrencyByBaseCurrencyId) {
        this.turqCurrencyByBaseCurrencyId = turqCurrencyByBaseCurrencyId;
    }

    public com.turquaz.engine.dal.TurqCurrency getTurqCurrencyByExchangeCurrencyId() {
        return this.turqCurrencyByExchangeCurrencyId;
    }

    public void setTurqCurrencyByExchangeCurrencyId(com.turquaz.engine.dal.TurqCurrency turqCurrencyByExchangeCurrencyId) {
        this.turqCurrencyByExchangeCurrencyId = turqCurrencyByExchangeCurrencyId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrencyExchangeRate) ) return false;
        TurqCurrencyExchangeRate castOther = (TurqCurrencyExchangeRate) other;
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
