package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqUserGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer userGroupId;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date updateDate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqGroup turqGroup;

    /** persistent field */
    private com.turquaz.engine.dal.TurqUser turqUser;

    /** full constructor */
    public TurqUserGroup(java.lang.Integer userGroupId, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate, com.turquaz.engine.dal.TurqGroup turqGroup, com.turquaz.engine.dal.TurqUser turqUser) {
        this.userGroupId = userGroupId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
        this.turqGroup = turqGroup;
        this.turqUser = turqUser;
    }

    /** default constructor */
    public TurqUserGroup() {
    }

    public java.lang.Integer getUserGroupId() {
        return this.userGroupId;
    }

    public void setUserGroupId(java.lang.Integer userGroupId) {
        this.userGroupId = userGroupId;
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

    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public com.turquaz.engine.dal.TurqGroup getTurqGroup() {
        return this.turqGroup;
    }

    public void setTurqGroup(com.turquaz.engine.dal.TurqGroup turqGroup) {
        this.turqGroup = turqGroup;
    }

    public com.turquaz.engine.dal.TurqUser getTurqUser() {
        return this.turqUser;
    }

    public void setTurqUser(com.turquaz.engine.dal.TurqUser turqUser) {
        this.turqUser = turqUser;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("userGroupId", getUserGroupId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqUserGroup) ) return false;
        TurqUserGroup castOther = (TurqUserGroup) other;
        return new EqualsBuilder()
            .append(this.getUserGroupId(), castOther.getUserGroupId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getUserGroupId())
            .toHashCode();
    }

}
