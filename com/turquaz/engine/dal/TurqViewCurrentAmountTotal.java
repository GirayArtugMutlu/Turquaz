package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewCurrentAmountTotal implements Serializable {

    /** identifier field */
    private int currentCardsId;

    /** identifier field */
    private java.math.BigDecimal transactionsTotalDept;

    /** identifier field */
    private java.math.BigDecimal transactionsTotalCredit;

    /** identifier field */
    private java.math.BigDecimal transactionsTotalAmountNow;

    /** full constructor */
    public TurqViewCurrentAmountTotal(int currentCardsId, java.math.BigDecimal transactionsTotalDept, java.math.BigDecimal transactionsTotalCredit, java.math.BigDecimal transactionsTotalAmountNow) {
        this.currentCardsId = currentCardsId;
        this.transactionsTotalDept = transactionsTotalDept;
        this.transactionsTotalCredit = transactionsTotalCredit;
        this.transactionsTotalAmountNow = transactionsTotalAmountNow;
    }

    /** default constructor */
    public TurqViewCurrentAmountTotal() {
    }

    public int getCurrentCardsId() {
        return this.currentCardsId;
    }

    public void setCurrentCardsId(int currentCardsId) {
        this.currentCardsId = currentCardsId;
    }

    public java.math.BigDecimal getTransactionsTotalDept() {
        return this.transactionsTotalDept;
    }

    public void setTransactionsTotalDept(java.math.BigDecimal transactionsTotalDept) {
        this.transactionsTotalDept = transactionsTotalDept;
    }

    public java.math.BigDecimal getTransactionsTotalCredit() {
        return this.transactionsTotalCredit;
    }

    public void setTransactionsTotalCredit(java.math.BigDecimal transactionsTotalCredit) {
        this.transactionsTotalCredit = transactionsTotalCredit;
    }

    public java.math.BigDecimal getTransactionsTotalAmountNow() {
        return this.transactionsTotalAmountNow;
    }

    public void setTransactionsTotalAmountNow(java.math.BigDecimal transactionsTotalAmountNow) {
        this.transactionsTotalAmountNow = transactionsTotalAmountNow;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentCardsId", getCurrentCardsId())
            .append("transactionsTotalDept", getTransactionsTotalDept())
            .append("transactionsTotalCredit", getTransactionsTotalCredit())
            .append("transactionsTotalAmountNow", getTransactionsTotalAmountNow())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqViewCurrentAmountTotal) ) return false;
        TurqViewCurrentAmountTotal castOther = (TurqViewCurrentAmountTotal) other;
        return new EqualsBuilder()
            .append(this.getCurrentCardsId(), castOther.getCurrentCardsId())
            .append(this.getTransactionsTotalDept(), castOther.getTransactionsTotalDept())
            .append(this.getTransactionsTotalCredit(), castOther.getTransactionsTotalCredit())
            .append(this.getTransactionsTotalAmountNow(), castOther.getTransactionsTotalAmountNow())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentCardsId())
            .append(getTransactionsTotalDept())
            .append(getTransactionsTotalCredit())
            .append(getTransactionsTotalAmountNow())
            .toHashCode();
    }

}
