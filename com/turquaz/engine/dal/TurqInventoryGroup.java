package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.lang.String groupsName;

    /** persistent field */
    private java.lang.String groupsDescription;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryGroup turqInventoryGroup;

    /** persistent field */
    private Set turqInventoryGroups;

    /** persistent field */
    private Set turqInventoryCardGroups;

    /** full constructor */
    public TurqInventoryGroup(java.lang.String groupsName, java.lang.String groupsDescription, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqInventoryGroup turqInventoryGroup, Set turqInventoryGroups, Set turqInventoryCardGroups) {
        this.groupsName = groupsName;
        this.groupsDescription = groupsDescription;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqInventoryGroup = turqInventoryGroup;
        this.turqInventoryGroups = turqInventoryGroups;
        this.turqInventoryCardGroups = turqInventoryCardGroups;
    }

    /** default constructor */
    public TurqInventoryGroup() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
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

    public com.turquaz.engine.dal.TurqInventoryGroup getTurqInventoryGroup() {
        return this.turqInventoryGroup;
    }

    public void setTurqInventoryGroup(com.turquaz.engine.dal.TurqInventoryGroup turqInventoryGroup) {
        this.turqInventoryGroup = turqInventoryGroup;
    }

    public java.util.Set getTurqInventoryGroups() {
        return this.turqInventoryGroups;
    }

    public void setTurqInventoryGroups(java.util.Set turqInventoryGroups) {
        this.turqInventoryGroups = turqInventoryGroups;
    }

    public java.util.Set getTurqInventoryCardGroups() {
        return this.turqInventoryCardGroups;
    }

    public void setTurqInventoryCardGroups(java.util.Set turqInventoryCardGroups) {
        this.turqInventoryCardGroups = turqInventoryCardGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqInventoryGroup) ) return false;
        TurqInventoryGroup castOther = (TurqInventoryGroup) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
