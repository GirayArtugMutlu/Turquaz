package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqModule implements Serializable {

    /** identifier field */
    private java.lang.Integer modulesId;

    /** persistent field */
    private java.lang.String modulesName;

    /** persistent field */
    private java.lang.String moduleDescription;

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
    private Set turqAccountingTransactions;

    /** persistent field */
    private Set turqEngineSequences;

    /** persistent field */
    private Set turqModuleComponents;

    /** persistent field */
    private Set turqGroupPermissions;

    /** full constructor */
    public TurqModule(java.lang.String modulesName, java.lang.String moduleDescription, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate, Set turqUserPermissions, Set turqAccountingTransactions, Set turqEngineSequences, Set turqModuleComponents, Set turqGroupPermissions) {
        this.modulesName = modulesName;
        this.moduleDescription = moduleDescription;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
        this.turqUserPermissions = turqUserPermissions;
        this.turqAccountingTransactions = turqAccountingTransactions;
        this.turqEngineSequences = turqEngineSequences;
        this.turqModuleComponents = turqModuleComponents;
        this.turqGroupPermissions = turqGroupPermissions;
    }

    /** default constructor */
    public TurqModule() {
    }

    public java.lang.Integer getModulesId() {
        return this.modulesId;
    }

    public void setModulesId(java.lang.Integer modulesId) {
        this.modulesId = modulesId;
    }

    public java.lang.String getModulesName() {
        return this.modulesName;
    }

    public void setModulesName(java.lang.String modulesName) {
        this.modulesName = modulesName;
    }

    public java.lang.String getModuleDescription() {
        return this.moduleDescription;
    }

    public void setModuleDescription(java.lang.String moduleDescription) {
        this.moduleDescription = moduleDescription;
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

    public java.util.Set getTurqAccountingTransactions() {
        return this.turqAccountingTransactions;
    }

    public void setTurqAccountingTransactions(java.util.Set turqAccountingTransactions) {
        this.turqAccountingTransactions = turqAccountingTransactions;
    }

    public java.util.Set getTurqEngineSequences() {
        return this.turqEngineSequences;
    }

    public void setTurqEngineSequences(java.util.Set turqEngineSequences) {
        this.turqEngineSequences = turqEngineSequences;
    }

    public java.util.Set getTurqModuleComponents() {
        return this.turqModuleComponents;
    }

    public void setTurqModuleComponents(java.util.Set turqModuleComponents) {
        this.turqModuleComponents = turqModuleComponents;
    }

    public java.util.Set getTurqGroupPermissions() {
        return this.turqGroupPermissions;
    }

    public void setTurqGroupPermissions(java.util.Set turqGroupPermissions) {
        this.turqGroupPermissions = turqGroupPermissions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("modulesId", getModulesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqModule) ) return false;
        TurqModule castOther = (TurqModule) other;
        return new EqualsBuilder()
            .append(this.getModulesId(), castOther.getModulesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getModulesId())
            .toHashCode();
    }

}
