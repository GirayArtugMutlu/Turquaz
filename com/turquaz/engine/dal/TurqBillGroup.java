package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBillGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer billGroupsId;

    /** persistent field */
    private java.lang.String groupsName;

    /** persistent field */
    private java.lang.String groupDescription;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private Set turqBillInGroups;

    /** full constructor */
    public TurqBillGroup(java.lang.String groupsName, java.lang.String groupDescription, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqBillInGroups) {
        this.groupsName = groupsName;
        this.groupDescription = groupDescription;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCompany = turqCompany;
        this.turqBillInGroups = turqBillInGroups;
    }

    /** default constructor */
    public TurqBillGroup() {
    }

    public java.lang.Integer getBillGroupsId() {
        return this.billGroupsId;
    }

    public void setBillGroupsId(java.lang.Integer billGroupsId) {
        this.billGroupsId = billGroupsId;
    }

    public java.lang.String getGroupsName() {
        return this.groupsName;
    }

    public void setGroupsName(java.lang.String groupsName) {
        this.groupsName = groupsName;
    }

    public java.lang.String getGroupDescription() {
        return this.groupDescription;
    }

    public void setGroupDescription(java.lang.String groupDescription) {
        this.groupDescription = groupDescription;
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

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public java.util.Set getTurqBillInGroups() {
        return this.turqBillInGroups;
    }

    public void setTurqBillInGroups(java.util.Set turqBillInGroups) {
        this.turqBillInGroups = turqBillInGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("billGroupsId", getBillGroupsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBillGroup) ) return false;
        TurqBillGroup castOther = (TurqBillGroup) other;
        return new EqualsBuilder()
            .append(this.getBillGroupsId(), castOther.getBillGroupsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBillGroupsId())
            .toHashCode();
    }

}
