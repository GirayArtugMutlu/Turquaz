package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewInventoryTotalsIn implements Serializable {

    /** identifier field */
    private int inventoryCardsId;

    /** identifier field */
    private java.math.BigDecimal totalPriceIn;

    /** identifier field */
    private java.math.BigDecimal totalAmountIn;

    /** full constructor */
    public TurqViewInventoryTotalsIn(int inventoryCardsId, java.math.BigDecimal totalPriceIn, java.math.BigDecimal totalAmountIn) {
        this.inventoryCardsId = inventoryCardsId;
        this.totalPriceIn = totalPriceIn;
        this.totalAmountIn = totalAmountIn;
    }

    /** default constructor */
    public TurqViewInventoryTotalsIn() {
    }

    public int getInventoryCardsId() {
        return this.inventoryCardsId;
    }

    public void setInventoryCardsId(int inventoryCardsId) {
        this.inventoryCardsId = inventoryCardsId;
    }

    public java.math.BigDecimal getTotalPriceIn() {
        return this.totalPriceIn;
    }

    public void setTotalPriceIn(java.math.BigDecimal totalPriceIn) {
        this.totalPriceIn = totalPriceIn;
    }

    public java.math.BigDecimal getTotalAmountIn() {
        return this.totalAmountIn;
    }

    public void setTotalAmountIn(java.math.BigDecimal totalAmountIn) {
        this.totalAmountIn = totalAmountIn;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryCardsId", getInventoryCardsId())
            .append("totalPriceIn", getTotalPriceIn())
            .append("totalAmountIn", getTotalAmountIn())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqViewInventoryTotalsIn) ) return false;
        TurqViewInventoryTotalsIn castOther = (TurqViewInventoryTotalsIn) other;
        return new EqualsBuilder()
            .append(this.getInventoryCardsId(), castOther.getInventoryCardsId())
            .append(this.getTotalPriceIn(), castOther.getTotalPriceIn())
            .append(this.getTotalAmountIn(), castOther.getTotalAmountIn())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryCardsId())
            .append(getTotalPriceIn())
            .append(getTotalAmountIn())
            .toHashCode();
    }

}
