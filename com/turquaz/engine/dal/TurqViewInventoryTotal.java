package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewInventoryTotal implements Serializable {

    /** identifier field */
    private int inventoryCardsId;

    /** identifier field */
    private java.math.BigDecimal totalAmountIn;

    /** identifier field */
    private java.math.BigDecimal totalPriceIn;

    /** identifier field */
    private java.math.BigDecimal totalAmountOut;

    /** identifier field */
    private java.math.BigDecimal totalPriceOut;

    /** full constructor */
    public TurqViewInventoryTotal(int inventoryCardsId, java.math.BigDecimal totalAmountIn, java.math.BigDecimal totalPriceIn, java.math.BigDecimal totalAmountOut, java.math.BigDecimal totalPriceOut) {
        this.inventoryCardsId = inventoryCardsId;
        this.totalAmountIn = totalAmountIn;
        this.totalPriceIn = totalPriceIn;
        this.totalAmountOut = totalAmountOut;
        this.totalPriceOut = totalPriceOut;
    }

    /** default constructor */
    public TurqViewInventoryTotal() {
    }

    public int getInventoryCardsId() {
        return this.inventoryCardsId;
    }

    public void setInventoryCardsId(int inventoryCardsId) {
        this.inventoryCardsId = inventoryCardsId;
    }

    public java.math.BigDecimal getTotalAmountIn() {
        return this.totalAmountIn;
    }

    public void setTotalAmountIn(java.math.BigDecimal totalAmountIn) {
        this.totalAmountIn = totalAmountIn;
    }

    public java.math.BigDecimal getTotalPriceIn() {
        return this.totalPriceIn;
    }

    public void setTotalPriceIn(java.math.BigDecimal totalPriceIn) {
        this.totalPriceIn = totalPriceIn;
    }

    public java.math.BigDecimal getTotalAmountOut() {
        return this.totalAmountOut;
    }

    public void setTotalAmountOut(java.math.BigDecimal totalAmountOut) {
        this.totalAmountOut = totalAmountOut;
    }

    public java.math.BigDecimal getTotalPriceOut() {
        return this.totalPriceOut;
    }

    public void setTotalPriceOut(java.math.BigDecimal totalPriceOut) {
        this.totalPriceOut = totalPriceOut;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryCardsId", getInventoryCardsId())
            .append("totalAmountIn", getTotalAmountIn())
            .append("totalPriceIn", getTotalPriceIn())
            .append("totalAmountOut", getTotalAmountOut())
            .append("totalPriceOut", getTotalPriceOut())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqViewInventoryTotal) ) return false;
        TurqViewInventoryTotal castOther = (TurqViewInventoryTotal) other;
        return new EqualsBuilder()
            .append(this.getInventoryCardsId(), castOther.getInventoryCardsId())
            .append(this.getTotalAmountIn(), castOther.getTotalAmountIn())
            .append(this.getTotalPriceIn(), castOther.getTotalPriceIn())
            .append(this.getTotalAmountOut(), castOther.getTotalAmountOut())
            .append(this.getTotalPriceOut(), castOther.getTotalPriceOut())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryCardsId())
            .append(getTotalAmountIn())
            .append(getTotalPriceIn())
            .append(getTotalAmountOut())
            .append(getTotalPriceOut())
            .toHashCode();
    }

}
