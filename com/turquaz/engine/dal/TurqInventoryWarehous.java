package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryWarehous implements Serializable {

    /** identifier field */
    private java.lang.Integer inventoryWarehousesId;

    /** persistent field */
    private java.lang.String warehousesName;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** nullable persistent field */
    private java.lang.String warehousesAddress;

    /** nullable persistent field */
    private java.lang.String warehousesDescription;

    /** nullable persistent field */
    private java.lang.String warehousesCity;

    /** nullable persistent field */
    private java.lang.String warehousesTelephone;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private Set turqInventoryTransactions;

    /** full constructor */
    public TurqInventoryWarehous(java.lang.String warehousesName, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.lang.String warehousesAddress, java.lang.String warehousesDescription, java.lang.String warehousesCity, java.lang.String warehousesTelephone, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqInventoryTransactions) {
        this.warehousesName = warehousesName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.warehousesAddress = warehousesAddress;
        this.warehousesDescription = warehousesDescription;
        this.warehousesCity = warehousesCity;
        this.warehousesTelephone = warehousesTelephone;
        this.turqCompany = turqCompany;
        this.turqInventoryTransactions = turqInventoryTransactions;
    }

    /** default constructor */
    public TurqInventoryWarehous() {
    }

    /** minimal constructor */
    public TurqInventoryWarehous(java.lang.String warehousesName, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqInventoryTransactions) {
        this.warehousesName = warehousesName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCompany = turqCompany;
        this.turqInventoryTransactions = turqInventoryTransactions;
    }

    public java.lang.Integer getInventoryWarehousesId() {
        return this.inventoryWarehousesId;
    }

    public void setInventoryWarehousesId(java.lang.Integer inventoryWarehousesId) {
        this.inventoryWarehousesId = inventoryWarehousesId;
    }

    public java.lang.String getWarehousesName() {
        return this.warehousesName;
    }

    public void setWarehousesName(java.lang.String warehousesName) {
        this.warehousesName = warehousesName;
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

    public java.lang.String getWarehousesAddress() {
        return this.warehousesAddress;
    }

    public void setWarehousesAddress(java.lang.String warehousesAddress) {
        this.warehousesAddress = warehousesAddress;
    }

    public java.lang.String getWarehousesDescription() {
        return this.warehousesDescription;
    }

    public void setWarehousesDescription(java.lang.String warehousesDescription) {
        this.warehousesDescription = warehousesDescription;
    }

    public java.lang.String getWarehousesCity() {
        return this.warehousesCity;
    }

    public void setWarehousesCity(java.lang.String warehousesCity) {
        this.warehousesCity = warehousesCity;
    }

    public java.lang.String getWarehousesTelephone() {
        return this.warehousesTelephone;
    }

    public void setWarehousesTelephone(java.lang.String warehousesTelephone) {
        this.warehousesTelephone = warehousesTelephone;
    }

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public java.util.Set getTurqInventoryTransactions() {
        return this.turqInventoryTransactions;
    }

    public void setTurqInventoryTransactions(java.util.Set turqInventoryTransactions) {
        this.turqInventoryTransactions = turqInventoryTransactions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryWarehousesId", getInventoryWarehousesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqInventoryWarehous) ) return false;
        TurqInventoryWarehous castOther = (TurqInventoryWarehous) other;
        return new EqualsBuilder()
            .append(this.getInventoryWarehousesId(), castOther.getInventoryWarehousesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryWarehousesId())
            .toHashCode();
    }

}
