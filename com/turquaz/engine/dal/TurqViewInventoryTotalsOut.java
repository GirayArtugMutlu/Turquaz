package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewInventoryTotalsOut implements Serializable {

    /** identifier field */
    private int inventoryCardsId;

    /** identifier field */
    private java.math.BigDecimal totalPriceOut;

    /** identifier field */
    private java.math.BigDecimal totalAmountOut;

    /** full constructor */
    public TurqViewInventoryTotalsOut(int inventoryCardsId, java.math.BigDecimal totalPriceOut, java.math.BigDecimal totalAmountOut) {
        this.inventoryCardsId = inventoryCardsId;
        this.totalPriceOut = totalPriceOut;
        this.totalAmountOut = totalAmountOut;
    }

    /** default constructor */
    public TurqViewInventoryTotalsOut() {
    }

    public int getInventoryCardsId() {
        return this.inventoryCardsId;
    }

    public void setInventoryCardsId(int inventoryCardsId) {
        this.inventoryCardsId = inventoryCardsId;
    }

    public java.math.BigDecimal getTotalPriceOut() {
        return this.totalPriceOut;
    }

    public void setTotalPriceOut(java.math.BigDecimal totalPriceOut) {
        this.totalPriceOut = totalPriceOut;
    }

    public java.math.BigDecimal getTotalAmountOut() {
        return this.totalAmountOut;
    }

    public void setTotalAmountOut(java.math.BigDecimal totalAmountOut) {
        this.totalAmountOut = totalAmountOut;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryCardsId", getInventoryCardsId())
            .append("totalPriceOut", getTotalPriceOut())
            .append("totalAmountOut", getTotalAmountOut())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqViewInventoryTotalsOut) ) return false;
        TurqViewInventoryTotalsOut castOther = (TurqViewInventoryTotalsOut) other;
        return new EqualsBuilder()
            .append(this.getInventoryCardsId(), castOther.getInventoryCardsId())
            .append(this.getTotalPriceOut(), castOther.getTotalPriceOut())
            .append(this.getTotalAmountOut(), castOther.getTotalAmountOut())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryCardsId())
            .append(getTotalPriceOut())
            .append(getTotalAmountOut())
            .toHashCode();
    }

}
