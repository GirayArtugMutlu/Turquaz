package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer currentGroupsId;

    /** persistent field */
    private java.lang.String groupsName;

    /** persistent field */
    private java.lang.String groupsDescription;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private Set turqCurrentCardsGroups;

    /** full constructor */
    public TurqCurrentGroup(java.lang.Integer currentGroupsId, java.lang.String groupsName, java.lang.String groupsDescription, java.util.Date creationDate, java.util.Date lastModified, java.lang.String createdBy, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqCurrentCardsGroups) {
        this.currentGroupsId = currentGroupsId;
        this.groupsName = groupsName;
        this.groupsDescription = groupsDescription;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.turqCompany = turqCompany;
        this.turqCurrentCardsGroups = turqCurrentCardsGroups;
    }

    /** default constructor */
    public TurqCurrentGroup() {
    }

    public java.lang.Integer getCurrentGroupsId() {
        return this.currentGroupsId;
    }

    public void setCurrentGroupsId(java.lang.Integer currentGroupsId) {
        this.currentGroupsId = currentGroupsId;
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

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
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

    public java.util.Set getTurqCurrentCardsGroups() {
        return this.turqCurrentCardsGroups;
    }

    public void setTurqCurrentCardsGroups(java.util.Set turqCurrentCardsGroups) {
        this.turqCurrentCardsGroups = turqCurrentCardsGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentGroupsId", getCurrentGroupsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentGroup) ) return false;
        TurqCurrentGroup castOther = (TurqCurrentGroup) other;
        return new EqualsBuilder()
            .append(this.getCurrentGroupsId(), castOther.getCurrentGroupsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentGroupsId())
            .toHashCode();
    }

}
