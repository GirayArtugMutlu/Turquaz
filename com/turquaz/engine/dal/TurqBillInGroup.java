package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBillInGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer billInGroupsId;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBillGroup turqBillGroup;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBill turqBill;

    /** full constructor */
    public TurqBillInGroup(java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, com.turquaz.engine.dal.TurqBillGroup turqBillGroup, com.turquaz.engine.dal.TurqBill turqBill) {
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqBillGroup = turqBillGroup;
        this.turqBill = turqBill;
    }

    /** default constructor */
    public TurqBillInGroup() {
    }

    public java.lang.Integer getBillInGroupsId() {
        return this.billInGroupsId;
    }

    public void setBillInGroupsId(java.lang.Integer billInGroupsId) {
        this.billInGroupsId = billInGroupsId;
    }

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public java.lang.String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(java.lang.String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public com.turquaz.engine.dal.TurqBillGroup getTurqBillGroup() {
        return this.turqBillGroup;
    }

    public void setTurqBillGroup(com.turquaz.engine.dal.TurqBillGroup turqBillGroup) {
        this.turqBillGroup = turqBillGroup;
    }

    public com.turquaz.engine.dal.TurqBill getTurqBill() {
        return this.turqBill;
    }

    public void setTurqBill(com.turquaz.engine.dal.TurqBill turqBill) {
        this.turqBill = turqBill;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("billInGroupsId", getBillInGroupsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBillInGroup) ) return false;
        TurqBillInGroup castOther = (TurqBillInGroup) other;
        return new EqualsBuilder()
            .append(this.getBillInGroupsId(), castOther.getBillInGroupsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBillInGroupsId())
            .toHashCode();
    }

}
