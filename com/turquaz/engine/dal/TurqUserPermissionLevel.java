package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqUserPermissionLevel implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private int permissionLevel;

    /** persistent field */
    private java.lang.String permissionName;

    /** persistent field */
    private java.lang.String permissionDescription;

    /** persistent field */
    private Set turqUserPermissions;

    /** full constructor */
    public TurqUserPermissionLevel(java.lang.Integer id, int permissionLevel, java.lang.String permissionName, java.lang.String permissionDescription, Set turqUserPermissions) {
        this.id = id;
        this.permissionLevel = permissionLevel;
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
        this.turqUserPermissions = turqUserPermissions;
    }

    /** default constructor */
    public TurqUserPermissionLevel() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public int getPermissionLevel() {
        return this.permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public java.lang.String getPermissionName() {
        return this.permissionName;
    }

    public void setPermissionName(java.lang.String permissionName) {
        this.permissionName = permissionName;
    }

    public java.lang.String getPermissionDescription() {
        return this.permissionDescription;
    }

    public void setPermissionDescription(java.lang.String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    public java.util.Set getTurqUserPermissions() {
        return this.turqUserPermissions;
    }

    public void setTurqUserPermissions(java.util.Set turqUserPermissions) {
        this.turqUserPermissions = turqUserPermissions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqUserPermissionLevel) ) return false;
        TurqUserPermissionLevel castOther = (TurqUserPermissionLevel) other;
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
