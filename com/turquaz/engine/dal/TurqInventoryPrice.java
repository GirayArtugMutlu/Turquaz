package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryPrice implements Serializable {

    /** identifier field */
    private java.lang.Integer inventoryPricesId;

    /** persistent field */
    private boolean pricesType;

    /** persistent field */
    private java.math.BigDecimal pricesAmount;

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
    private com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard;

    /** full constructor */
    public TurqInventoryPrice(boolean pricesType, java.math.BigDecimal pricesAmount, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCurrency turqCurrency, com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard) {
        this.pricesType = pricesType;
        this.pricesAmount = pricesAmount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCurrency = turqCurrency;
        this.turqInventoryCard = turqInventoryCard;
    }

    /** default constructor */
    public TurqInventoryPrice() {
    }

    public java.lang.Integer getInventoryPricesId() {
        return this.inventoryPricesId;
    }

    public void setInventoryPricesId(java.lang.Integer inventoryPricesId) {
        this.inventoryPricesId = inventoryPricesId;
    }

    public boolean isPricesType() {
        return this.pricesType;
    }

    public void setPricesType(boolean pricesType) {
        this.pricesType = pricesType;
    }

    public java.math.BigDecimal getPricesAmount() {
        return this.pricesAmount;
    }

    public void setPricesAmount(java.math.BigDecimal pricesAmount) {
        this.pricesAmount = pricesAmount;
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

    public com.turquaz.engine.dal.TurqInventoryCard getTurqInventoryCard() {
        return this.turqInventoryCard;
    }

    public void setTurqInventoryCard(com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard) {
        this.turqInventoryCard = turqInventoryCard;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryPricesId", getInventoryPricesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqInventoryPrice) ) return false;
        TurqInventoryPrice castOther = (TurqInventoryPrice) other;
        return new EqualsBuilder()
            .append(this.getInventoryPricesId(), castOther.getInventoryPricesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryPricesId())
            .toHashCode();
    }

}
