package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ViewInventoryLevel implements Serializable {

    /** identifier field */
    private int inventoryCardsId;

    /** identifier field */
    private java.math.BigDecimal amount;

    /** full constructor */
    public ViewInventoryLevel(int inventoryCardsId, java.math.BigDecimal amount) {
        this.inventoryCardsId = inventoryCardsId;
        this.amount = amount;
    }

    /** default constructor */
    public ViewInventoryLevel() {
    }

    public int getInventoryCardsId() {
        return this.inventoryCardsId;
    }

    public void setInventoryCardsId(int inventoryCardsId) {
        this.inventoryCardsId = inventoryCardsId;
    }

    public java.math.BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryCardsId", getInventoryCardsId())
            .append("amount", getAmount())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ViewInventoryLevel) ) return false;
        ViewInventoryLevel castOther = (ViewInventoryLevel) other;
        return new EqualsBuilder()
            .append(this.getInventoryCardsId(), castOther.getInventoryCardsId())
            .append(this.getAmount(), castOther.getAmount())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryCardsId())
            .append(getAmount())
            .toHashCode();
    }

}
