package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqUser implements Serializable {

    /** identifier field */
    private java.lang.Integer usersId;

    /** persistent field */
    private java.lang.String username;

    /** persistent field */
    private java.lang.String usersPassword;

    /** persistent field */
    private java.lang.String usersRealName;

    /** persistent field */
    private java.lang.String usersDescription;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date updateDate;

    /** persistent field */
    private Set turqUserPermissions;

    /** persistent field */
    private Set turqUserGroups;

    /** full constructor */
    public TurqUser(java.lang.Integer usersId, java.lang.String username, java.lang.String usersPassword, java.lang.String usersRealName, java.lang.String usersDescription, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate, Set turqUserPermissions, Set turqUserGroups) {
        this.usersId = usersId;
        this.username = username;
        this.usersPassword = usersPassword;
        this.usersRealName = usersRealName;
        this.usersDescription = usersDescription;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
        this.turqUserPermissions = turqUserPermissions;
        this.turqUserGroups = turqUserGroups;
    }

    /** default constructor */
    public TurqUser() {
    }

    public java.lang.Integer getUsersId() {
        return this.usersId;
    }

    public void setUsersId(java.lang.Integer usersId) {
        this.usersId = usersId;
    }

    public java.lang.String getUsername() {
        return this.username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getUsersPassword() {
        return this.usersPassword;
    }

    public void setUsersPassword(java.lang.String usersPassword) {
        this.usersPassword = usersPassword;
    }

    public java.lang.String getUsersRealName() {
        return this.usersRealName;
    }

    public void setUsersRealName(java.lang.String usersRealName) {
        this.usersRealName = usersRealName;
    }

    public java.lang.String getUsersDescription() {
        return this.usersDescription;
    }

    public void setUsersDescription(java.lang.String usersDescription) {
        this.usersDescription = usersDescription;
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

    public java.util.Set getTurqUserPermissions() {
        return this.turqUserPermissions;
    }

    public void setTurqUserPermissions(java.util.Set turqUserPermissions) {
        this.turqUserPermissions = turqUserPermissions;
    }

    public java.util.Set getTurqUserGroups() {
        return this.turqUserGroups;
    }

    public void setTurqUserGroups(java.util.Set turqUserGroups) {
        this.turqUserGroups = turqUserGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("usersId", getUsersId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqUser) ) return false;
        TurqUser castOther = (TurqUser) other;
        return new EqualsBuilder()
            .append(this.getUsersId(), castOther.getUsersId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getUsersId())
            .toHashCode();
    }

}
