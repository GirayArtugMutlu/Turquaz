package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentTransactionBill implements Serializable {

    /** identifier field */
    private java.lang.Integer currentTransactionBillId;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentTransaction turqCurrentTransactionByCurrentTransactionsIdOpen;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentTransaction turqCurrentTransactionByCurrentTransactionsIdClose;

    /** full constructor */
    public TurqCurrentTransactionBill(java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCurrentTransaction turqCurrentTransactionByCurrentTransactionsIdOpen, com.turquaz.engine.dal.TurqCurrentTransaction turqCurrentTransactionByCurrentTransactionsIdClose) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCurrentTransactionByCurrentTransactionsIdOpen = turqCurrentTransactionByCurrentTransactionsIdOpen;
        this.turqCurrentTransactionByCurrentTransactionsIdClose = turqCurrentTransactionByCurrentTransactionsIdClose;
    }

    /** default constructor */
    public TurqCurrentTransactionBill() {
    }

    public java.lang.Integer getCurrentTransactionBillId() {
        return this.currentTransactionBillId;
    }

    public void setCurrentTransactionBillId(java.lang.Integer currentTransactionBillId) {
        this.currentTransactionBillId = currentTransactionBillId;
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

    public com.turquaz.engine.dal.TurqCurrentTransaction getTurqCurrentTransactionByCurrentTransactionsIdOpen() {
        return this.turqCurrentTransactionByCurrentTransactionsIdOpen;
    }

    public void setTurqCurrentTransactionByCurrentTransactionsIdOpen(com.turquaz.engine.dal.TurqCurrentTransaction turqCurrentTransactionByCurrentTransactionsIdOpen) {
        this.turqCurrentTransactionByCurrentTransactionsIdOpen = turqCurrentTransactionByCurrentTransactionsIdOpen;
    }

    public com.turquaz.engine.dal.TurqCurrentTransaction getTurqCurrentTransactionByCurrentTransactionsIdClose() {
        return this.turqCurrentTransactionByCurrentTransactionsIdClose;
    }

    public void setTurqCurrentTransactionByCurrentTransactionsIdClose(com.turquaz.engine.dal.TurqCurrentTransaction turqCurrentTransactionByCurrentTransactionsIdClose) {
        this.turqCurrentTransactionByCurrentTransactionsIdClose = turqCurrentTransactionByCurrentTransactionsIdClose;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentTransactionBillId", getCurrentTransactionBillId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentTransactionBill) ) return false;
        TurqCurrentTransactionBill castOther = (TurqCurrentTransactionBill) other;
        return new EqualsBuilder()
            .append(this.getCurrentTransactionBillId(), castOther.getCurrentTransactionBillId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentTransactionBillId())
            .toHashCode();
    }

}
