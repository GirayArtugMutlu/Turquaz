package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqConsignment implements Serializable {

    /** identifier field */
    private java.lang.Integer consignmentsId;

    /** persistent field */
    private java.util.Date consignmentsDate;

    /** persistent field */
    private java.lang.String consignmentsDefinition;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private int consignmentsType;

    /** persistent field */
    private boolean consignmentsPrinted;

    /** persistent field */
    private java.lang.String consignmentsDocumentNo;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBillConsignmentCommon turqBillConsignmentCommon;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private Set turqInventoryTransactions;

    /** persistent field */
    private Set turqConsignmentsInGroups;

    /** full constructor */
    public TurqConsignment(java.util.Date consignmentsDate, java.lang.String consignmentsDefinition, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, int consignmentsType, boolean consignmentsPrinted, java.lang.String consignmentsDocumentNo, com.turquaz.engine.dal.TurqBillConsignmentCommon turqBillConsignmentCommon, com.turquaz.engine.dal.TurqCompany turqCompany, Set turqInventoryTransactions, Set turqConsignmentsInGroups) {
        this.consignmentsDate = consignmentsDate;
        this.consignmentsDefinition = consignmentsDefinition;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.consignmentsType = consignmentsType;
        this.consignmentsPrinted = consignmentsPrinted;
        this.consignmentsDocumentNo = consignmentsDocumentNo;
        this.turqBillConsignmentCommon = turqBillConsignmentCommon;
        this.turqCompany = turqCompany;
        this.turqInventoryTransactions = turqInventoryTransactions;
        this.turqConsignmentsInGroups = turqConsignmentsInGroups;
    }

    /** default constructor */
    public TurqConsignment() {
    }

    public java.lang.Integer getConsignmentsId() {
        return this.consignmentsId;
    }

    public void setConsignmentsId(java.lang.Integer consignmentsId) {
        this.consignmentsId = consignmentsId;
    }

    public java.util.Date getConsignmentsDate() {
        return this.consignmentsDate;
    }

    public void setConsignmentsDate(java.util.Date consignmentsDate) {
        this.consignmentsDate = consignmentsDate;
    }

    public java.lang.String getConsignmentsDefinition() {
        return this.consignmentsDefinition;
    }

    public void setConsignmentsDefinition(java.lang.String consignmentsDefinition) {
        this.consignmentsDefinition = consignmentsDefinition;
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

    public int getConsignmentsType() {
        return this.consignmentsType;
    }

    public void setConsignmentsType(int consignmentsType) {
        this.consignmentsType = consignmentsType;
    }

    public boolean isConsignmentsPrinted() {
        return this.consignmentsPrinted;
    }

    public void setConsignmentsPrinted(boolean consignmentsPrinted) {
        this.consignmentsPrinted = consignmentsPrinted;
    }

    public java.lang.String getConsignmentsDocumentNo() {
        return this.consignmentsDocumentNo;
    }

    public void setConsignmentsDocumentNo(java.lang.String consignmentsDocumentNo) {
        this.consignmentsDocumentNo = consignmentsDocumentNo;
    }

    public com.turquaz.engine.dal.TurqBillConsignmentCommon getTurqBillConsignmentCommon() {
        return this.turqBillConsignmentCommon;
    }

    public void setTurqBillConsignmentCommon(com.turquaz.engine.dal.TurqBillConsignmentCommon turqBillConsignmentCommon) {
        this.turqBillConsignmentCommon = turqBillConsignmentCommon;
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

    public java.util.Set getTurqConsignmentsInGroups() {
        return this.turqConsignmentsInGroups;
    }

    public void setTurqConsignmentsInGroups(java.util.Set turqConsignmentsInGroups) {
        this.turqConsignmentsInGroups = turqConsignmentsInGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("consignmentsId", getConsignmentsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqConsignment) ) return false;
        TurqConsignment castOther = (TurqConsignment) other;
        return new EqualsBuilder()
            .append(this.getConsignmentsId(), castOther.getConsignmentsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getConsignmentsId())
            .toHashCode();
    }

}
