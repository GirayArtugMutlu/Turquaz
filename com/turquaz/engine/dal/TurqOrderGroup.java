package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqOrderGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer orderGroupsId;

    /** persistent field */
    private java.lang.String groupsName;

    /** persistent field */
    private java.lang.String groupsDescription;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private Set turqOrderInGroups;

    /** full constructor */
    public TurqOrderGroup(java.lang.Integer orderGroupsId, java.lang.String groupsName, java.lang.String groupsDescription, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqOrderInGroups) {
        this.orderGroupsId = orderGroupsId;
        this.groupsName = groupsName;
        this.groupsDescription = groupsDescription;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqCompany = turqCompany;
        this.turqOrderInGroups = turqOrderInGroups;
    }

    /** default constructor */
    public TurqOrderGroup() {
    }

    public java.lang.Integer getOrderGroupsId() {
        return this.orderGroupsId;
    }

    public void setOrderGroupsId(java.lang.Integer orderGroupsId) {
        this.orderGroupsId = orderGroupsId;
    }

    public java.lang.String getGroupsName() {
        return this.groupsName;
    }

    public void setGroupsName(java.lang.String groupsName) {
        this.groupsName = groupsName;
    }

    public java.lang.String getGroupsDescription() {
        return this.groupsDescription;
    }

    public void setGroupsDescription(java.lang.String groupsDescription) {
        this.groupsDescription = groupsDescription;
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

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public java.util.Set getTurqOrderInGroups() {
        return this.turqOrderInGroups;
    }

    public void setTurqOrderInGroups(java.util.Set turqOrderInGroups) {
        this.turqOrderInGroups = turqOrderInGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderGroupsId", getOrderGroupsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqOrderGroup) ) return false;
        TurqOrderGroup castOther = (TurqOrderGroup) other;
        return new EqualsBuilder()
            .append(this.getOrderGroupsId(), castOther.getOrderGroupsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrderGroupsId())
            .toHashCode();
    }

}