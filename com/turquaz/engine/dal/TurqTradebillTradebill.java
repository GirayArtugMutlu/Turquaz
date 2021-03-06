package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqTradebillTradebill implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.lang.String tradebillsPortfolioNo;

    /** persistent field */
    private java.util.Date tradebillDueDate;

    /** persistent field */
    private java.lang.String tradebillDebtor;

    /** persistent field */
    private java.lang.String tradebillGuarantor;

    /** persistent field */
    private java.lang.String tradebillPaymentPlace;

    /** persistent field */
    private int tradebillValueDate;

    /** persistent field */
    private java.math.BigDecimal tradebillAmount;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrency turqCurrency;

    /** persistent field */
    private Set turqTradebillTradebillsRolls;

    /** full constructor */
    public TurqTradebillTradebill(java.lang.String tradebillsPortfolioNo, java.util.Date tradebillDueDate, java.lang.String tradebillDebtor, java.lang.String tradebillGuarantor, java.lang.String tradebillPaymentPlace, int tradebillValueDate, java.math.BigDecimal tradebillAmount, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCurrency turqCurrency, Set turqTradebillTradebillsRolls) {
        this.tradebillsPortfolioNo = tradebillsPortfolioNo;
        this.tradebillDueDate = tradebillDueDate;
        this.tradebillDebtor = tradebillDebtor;
        this.tradebillGuarantor = tradebillGuarantor;
        this.tradebillPaymentPlace = tradebillPaymentPlace;
        this.tradebillValueDate = tradebillValueDate;
        this.tradebillAmount = tradebillAmount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCurrency = turqCurrency;
        this.turqTradebillTradebillsRolls = turqTradebillTradebillsRolls;
    }

    /** default constructor */
    public TurqTradebillTradebill() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getTradebillsPortfolioNo() {
        return this.tradebillsPortfolioNo;
    }

    public void setTradebillsPortfolioNo(java.lang.String tradebillsPortfolioNo) {
        this.tradebillsPortfolioNo = tradebillsPortfolioNo;
    }

    public java.util.Date getTradebillDueDate() {
        return this.tradebillDueDate;
    }

    public void setTradebillDueDate(java.util.Date tradebillDueDate) {
        this.tradebillDueDate = tradebillDueDate;
    }

    public java.lang.String getTradebillDebtor() {
        return this.tradebillDebtor;
    }

    public void setTradebillDebtor(java.lang.String tradebillDebtor) {
        this.tradebillDebtor = tradebillDebtor;
    }

    public java.lang.String getTradebillGuarantor() {
        return this.tradebillGuarantor;
    }

    public void setTradebillGuarantor(java.lang.String tradebillGuarantor) {
        this.tradebillGuarantor = tradebillGuarantor;
    }

    public java.lang.String getTradebillPaymentPlace() {
        return this.tradebillPaymentPlace;
    }

    public void setTradebillPaymentPlace(java.lang.String tradebillPaymentPlace) {
        this.tradebillPaymentPlace = tradebillPaymentPlace;
    }

    public int getTradebillValueDate() {
        return this.tradebillValueDate;
    }

    public void setTradebillValueDate(int tradebillValueDate) {
        this.tradebillValueDate = tradebillValueDate;
    }

    public java.math.BigDecimal getTradebillAmount() {
        return this.tradebillAmount;
    }

    public void setTradebillAmount(java.math.BigDecimal tradebillAmount) {
        this.tradebillAmount = tradebillAmount;
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

    public com.turquaz.engine.dal.TurqCurrency getTurqCurrency() {
        return this.turqCurrency;
    }

    public void setTurqCurrency(com.turquaz.engine.dal.TurqCurrency turqCurrency) {
        this.turqCurrency = turqCurrency;
    }

    public java.util.Set getTurqTradebillTradebillsRolls() {
        return this.turqTradebillTradebillsRolls;
    }

    public void setTurqTradebillTradebillsRolls(java.util.Set turqTradebillTradebillsRolls) {
        this.turqTradebillTradebillsRolls = turqTradebillTradebillsRolls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqTradebillTradebill) ) return false;
        TurqTradebillTradebill castOther = (TurqTradebillTradebill) other;
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
