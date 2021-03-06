package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqGroupPermission implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private int groupPermissionsLevel;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date updateDate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqModuleComponent turqModuleComponent;

    /** persistent field */
    private com.turquaz.engine.dal.TurqGroup turqGroup;

    /** persistent field */
    private com.turquaz.engine.dal.TurqModule turqModule;

    /** full constructor */
    public TurqGroupPermission(int groupPermissionsLevel, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate, com.turquaz.engine.dal.TurqModuleComponent turqModuleComponent, com.turquaz.engine.dal.TurqGroup turqGroup, com.turquaz.engine.dal.TurqModule turqModule) {
        this.groupPermissionsLevel = groupPermissionsLevel;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
        this.turqModuleComponent = turqModuleComponent;
        this.turqGroup = turqGroup;
        this.turqModule = turqModule;
    }

    /** default constructor */
    public TurqGroupPermission() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public int getGroupPermissionsLevel() {
        return this.groupPermissionsLevel;
    }

    public void setGroupPermissionsLevel(int groupPermissionsLevel) {
        this.groupPermissionsLevel = groupPermissionsLevel;
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

    public com.turquaz.engine.dal.TurqModuleComponent getTurqModuleComponent() {
        return this.turqModuleComponent;
    }

    public void setTurqModuleComponent(com.turquaz.engine.dal.TurqModuleComponent turqModuleComponent) {
        this.turqModuleComponent = turqModuleComponent;
    }

    public com.turquaz.engine.dal.TurqGroup getTurqGroup() {
        return this.turqGroup;
    }

    public void setTurqGroup(com.turquaz.engine.dal.TurqGroup turqGroup) {
        this.turqGroup = turqGroup;
    }

    public com.turquaz.engine.dal.TurqModule getTurqModule() {
        return this.turqModule;
    }

    public void setTurqModule(com.turquaz.engine.dal.TurqModule turqModule) {
        this.turqModule = turqModule;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqGroupPermission) ) return false;
        TurqGroupPermission castOther = (TurqGroupPermission) other;
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
