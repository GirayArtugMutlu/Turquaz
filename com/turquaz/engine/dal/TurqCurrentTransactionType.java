package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentTransactionType implements Serializable {

    /** identifier field */
    private java.lang.Integer currentTransactionTypesId;

    /** persistent field */
    private java.lang.String transactionTypeName;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** full constructor */
    public TurqCurrentTransactionType(java.lang.String transactionTypeName, java.lang.String createdBy, java.lang.String updatedBy, java.util.Date creationDate, java.util.Date lastModified, com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.transactionTypeName = transactionTypeName;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.turqCompany = turqCompany;
    }

    /** default constructor */
    public TurqCurrentTransactionType() {
    }

    public java.lang.Integer getCurrentTransactionTypesId() {
        return this.currentTransactionTypesId;
    }

    public void setCurrentTransactionTypesId(java.lang.Integer currentTransactionTypesId) {
        this.currentTransactionTypesId = currentTransactionTypesId;
    }

    public java.lang.String getTransactionTypeName() {
        return this.transactionTypeName;
    }

    public void setTransactionTypeName(java.lang.String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
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

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentTransactionTypesId", getCurrentTransactionTypesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentTransactionType) ) return false;
        TurqCurrentTransactionType castOther = (TurqCurrentTransactionType) other;
        return new EqualsBuilder()
            .append(this.getCurrentTransactionTypesId(), castOther.getCurrentTransactionTypesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentTransactionTypesId())
            .toHashCode();
    }

}
