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

    /** identifier field */
    private java.math.BigDecimal totalTransoverAmountIn;

    /** identifier field */
    private java.math.BigDecimal totalTransoverPriceIn;

    /** identifier field */
    private java.math.BigDecimal totalTransoverAmountOut;

    /** identifier field */
    private java.math.BigDecimal totalTransoverPriceOut;

    /** full constructor */
    public TurqViewInventoryTotal(int inventoryCardsId, java.math.BigDecimal totalAmountIn, java.math.BigDecimal totalPriceIn, java.math.BigDecimal totalAmountOut, java.math.BigDecimal totalPriceOut, java.math.BigDecimal totalTransoverAmountIn, java.math.BigDecimal totalTransoverPriceIn, java.math.BigDecimal totalTransoverAmountOut, java.math.BigDecimal totalTransoverPriceOut) {
        this.inventoryCardsId = inventoryCardsId;
        this.totalAmountIn = totalAmountIn;
        this.totalPriceIn = totalPriceIn;
        this.totalAmountOut = totalAmountOut;
        this.totalPriceOut = totalPriceOut;
        this.totalTransoverAmountIn = totalTransoverAmountIn;
        this.totalTransoverPriceIn = totalTransoverPriceIn;
        this.totalTransoverAmountOut = totalTransoverAmountOut;
        this.totalTransoverPriceOut = totalTransoverPriceOut;
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

    public java.math.BigDecimal getTotalTransoverAmountIn() {
        return this.totalTransoverAmountIn;
    }

    public void setTotalTransoverAmountIn(java.math.BigDecimal totalTransoverAmountIn) {
        this.totalTransoverAmountIn = totalTransoverAmountIn;
    }

    public java.math.BigDecimal getTotalTransoverPriceIn() {
        return this.totalTransoverPriceIn;
    }

    public void setTotalTransoverPriceIn(java.math.BigDecimal totalTransoverPriceIn) {
        this.totalTransoverPriceIn = totalTransoverPriceIn;
    }

    public java.math.BigDecimal getTotalTransoverAmountOut() {
        return this.totalTransoverAmountOut;
    }

    public void setTotalTransoverAmountOut(java.math.BigDecimal totalTransoverAmountOut) {
        this.totalTransoverAmountOut = totalTransoverAmountOut;
    }

    public java.math.BigDecimal getTotalTransoverPriceOut() {
        return this.totalTransoverPriceOut;
    }

    public void setTotalTransoverPriceOut(java.math.BigDecimal totalTransoverPriceOut) {
        this.totalTransoverPriceOut = totalTransoverPriceOut;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryCardsId", getInventoryCardsId())
            .append("totalAmountIn", getTotalAmountIn())
            .append("totalPriceIn", getTotalPriceIn())
            .append("totalAmountOut", getTotalAmountOut())
            .append("totalPriceOut", getTotalPriceOut())
            .append("totalTransoverAmountIn", getTotalTransoverAmountIn())
            .append("totalTransoverPriceIn", getTotalTransoverPriceIn())
            .append("totalTransoverAmountOut", getTotalTransoverAmountOut())
            .append("totalTransoverPriceOut", getTotalTransoverPriceOut())
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
            .append(this.getTotalTransoverAmountIn(), castOther.getTotalTransoverAmountIn())
            .append(this.getTotalTransoverPriceIn(), castOther.getTotalTransoverPriceIn())
            .append(this.getTotalTransoverAmountOut(), castOther.getTotalTransoverAmountOut())
            .append(this.getTotalTransoverPriceOut(), castOther.getTotalTransoverPriceOut())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryCardsId())
            .append(getTotalAmountIn())
            .append(getTotalPriceIn())
            .append(getTotalAmountOut())
            .append(getTotalPriceOut())
            .append(getTotalTransoverAmountIn())
            .append(getTotalTransoverPriceIn())
            .append(getTotalTransoverAmountOut())
            .append(getTotalTransoverPriceOut())
            .toHashCode();
    }

}
