package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCompany implements Serializable {

    /** identifier field */
    private java.lang.Integer companiesId;

    /** persistent field */
    private java.lang.String companyName;

    /** persistent field */
    private java.lang.String companyAddress;

    /** persistent field */
    private java.lang.String companyTelephone;

    /** persistent field */
    private java.lang.String companyFax;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date updateDate;

    /** full constructor */
    public TurqCompany(java.lang.String companyName, java.lang.String companyAddress, java.lang.String companyTelephone, java.lang.String companyFax, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyTelephone = companyTelephone;
        this.companyFax = companyFax;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
    }

    /** default constructor */
    public TurqCompany() {
    }

    public java.lang.Integer getCompaniesId() {
        return this.companiesId;
    }

    public void setCompaniesId(java.lang.Integer companiesId) {
        this.companiesId = companiesId;
    }

    public java.lang.String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(java.lang.String companyName) {
        this.companyName = companyName;
    }

    public java.lang.String getCompanyAddress() {
        return this.companyAddress;
    }

    public void setCompanyAddress(java.lang.String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public java.lang.String getCompanyTelephone() {
        return this.companyTelephone;
    }

    public void setCompanyTelephone(java.lang.String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public java.lang.String getCompanyFax() {
        return this.companyFax;
    }

    public void setCompanyFax(java.lang.String companyFax) {
        this.companyFax = companyFax;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("companiesId", getCompaniesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCompany) ) return false;
        TurqCompany castOther = (TurqCompany) other;
        return new EqualsBuilder()
            .append(this.getCompaniesId(), castOther.getCompaniesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCompaniesId())
            .toHashCode();
    }

}
