package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqConsignmentGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer consignmentGroupsId;

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
    private Set turqConsignmentsInGroups;

    /** full constructor */
    public TurqConsignmentGroup(java.lang.Integer consignmentGroupsId, java.lang.String groupsName, java.lang.String groupsDescription, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqConsignmentsInGroups) {
        this.consignmentGroupsId = consignmentGroupsId;
        this.groupsName = groupsName;
        this.groupsDescription = groupsDescription;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqCompany = turqCompany;
        this.turqConsignmentsInGroups = turqConsignmentsInGroups;
    }

    /** default constructor */
    public TurqConsignmentGroup() {
    }

    public java.lang.Integer getConsignmentGroupsId() {
        return this.consignmentGroupsId;
    }

    public void setConsignmentGroupsId(java.lang.Integer consignmentGroupsId) {
        this.consignmentGroupsId = consignmentGroupsId;
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

    public java.util.Set getTurqConsignmentsInGroups() {
        return this.turqConsignmentsInGroups;
    }

    public void setTurqConsignmentsInGroups(java.util.Set turqConsignmentsInGroups) {
        this.turqConsignmentsInGroups = turqConsignmentsInGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("consignmentGroupsId", getConsignmentGroupsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqConsignmentGroup) ) return false;
        TurqConsignmentGroup castOther = (TurqConsignmentGroup) other;
        return new EqualsBuilder()
            .append(this.getConsignmentGroupsId(), castOther.getConsignmentGroupsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getConsignmentGroupsId())
            .toHashCode();
    }

}
