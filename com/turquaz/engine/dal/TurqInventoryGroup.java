package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer inventoryGroupsId;

    /** persistent field */
    private java.lang.String groupsName;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String groupsDescription;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private Set turqInventoryCardGroups;

    /** full constructor */
    public TurqInventoryGroup(java.lang.String groupsName, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.lang.String groupsDescription, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqInventoryCardGroups) {
        this.groupsName = groupsName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.groupsDescription = groupsDescription;
        this.turqCompany = turqCompany;
        this.turqInventoryCardGroups = turqInventoryCardGroups;
    }

    /** default constructor */
    public TurqInventoryGroup() {
    }

    public java.lang.Integer getInventoryGroupsId() {
        return this.inventoryGroupsId;
    }

    public void setInventoryGroupsId(java.lang.Integer inventoryGroupsId) {
        this.inventoryGroupsId = inventoryGroupsId;
    }

    public java.lang.String getGroupsName() {
        return this.groupsName;
    }

    public void setGroupsName(java.lang.String groupsName) {
        this.groupsName = groupsName;
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

    public java.lang.String getGroupsDescription() {
        return this.groupsDescription;
    }

    public void setGroupsDescription(java.lang.String groupsDescription) {
        this.groupsDescription = groupsDescription;
    }

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public java.util.Set getTurqInventoryCardGroups() {
        return this.turqInventoryCardGroups;
    }

    public void setTurqInventoryCardGroups(java.util.Set turqInventoryCardGroups) {
        this.turqInventoryCardGroups = turqInventoryCardGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryGroupsId", getInventoryGroupsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqInventoryGroup) ) return false;
        TurqInventoryGroup castOther = (TurqInventoryGroup) other;
        return new EqualsBuilder()
            .append(this.getInventoryGroupsId(), castOther.getInventoryGroupsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryGroupsId())
            .toHashCode();
    }

}
