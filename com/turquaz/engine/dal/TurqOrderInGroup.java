package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqOrderInGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer orderInGroupsId;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqOrder turqOrder;

    /** persistent field */
    private com.turquaz.engine.dal.TurqOrderGroup turqOrderGroup;

    /** full constructor */
    public TurqOrderInGroup(java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqOrder turqOrder, com.turquaz.engine.dal.TurqOrderGroup turqOrderGroup) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqOrder = turqOrder;
        this.turqOrderGroup = turqOrderGroup;
    }

    /** default constructor */
    public TurqOrderInGroup() {
    }

    public java.lang.Integer getOrderInGroupsId() {
        return this.orderInGroupsId;
    }

    public void setOrderInGroupsId(java.lang.Integer orderInGroupsId) {
        this.orderInGroupsId = orderInGroupsId;
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

    public com.turquaz.engine.dal.TurqOrder getTurqOrder() {
        return this.turqOrder;
    }

    public void setTurqOrder(com.turquaz.engine.dal.TurqOrder turqOrder) {
        this.turqOrder = turqOrder;
    }

    public com.turquaz.engine.dal.TurqOrderGroup getTurqOrderGroup() {
        return this.turqOrderGroup;
    }

    public void setTurqOrderGroup(com.turquaz.engine.dal.TurqOrderGroup turqOrderGroup) {
        this.turqOrderGroup = turqOrderGroup;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderInGroupsId", getOrderInGroupsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqOrderInGroup) ) return false;
        TurqOrderInGroup castOther = (TurqOrderInGroup) other;
        return new EqualsBuilder()
            .append(this.getOrderInGroupsId(), castOther.getOrderInGroupsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrderInGroupsId())
            .toHashCode();
    }

}
