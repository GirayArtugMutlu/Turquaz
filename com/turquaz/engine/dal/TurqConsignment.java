package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqConsignment implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.util.Date consignmentsDate;

    /** persistent field */
    private java.lang.String consignmentsDefinition;

    /** persistent field */
    private int consignmentsType;

    /** persistent field */
    private boolean consignmentsPrinted;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String consignmentDocumentNo;

    /** persistent field */
    private java.lang.String billDocumentNo;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqConsignmentsInGroups;

    /** full constructor */
    public TurqConsignment(java.util.Date consignmentsDate, java.lang.String consignmentsDefinition, int consignmentsType, boolean consignmentsPrinted, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.lang.String consignmentDocumentNo, java.lang.String billDocumentNo, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqConsignmentsInGroups) {
        this.consignmentsDate = consignmentsDate;
        this.consignmentsDefinition = consignmentsDefinition;
        this.consignmentsType = consignmentsType;
        this.consignmentsPrinted = consignmentsPrinted;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.consignmentDocumentNo = consignmentDocumentNo;
        this.billDocumentNo = billDocumentNo;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqEngineSequence = turqEngineSequence;
        this.turqCurrentCard = turqCurrentCard;
        this.turqConsignmentsInGroups = turqConsignmentsInGroups;
    }

    /** default constructor */
    public TurqConsignment() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
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

    public java.lang.String getConsignmentDocumentNo() {
        return this.consignmentDocumentNo;
    }

    public void setConsignmentDocumentNo(java.lang.String consignmentDocumentNo) {
        this.consignmentDocumentNo = consignmentDocumentNo;
    }

    public java.lang.String getBillDocumentNo() {
        return this.billDocumentNo;
    }

    public void setBillDocumentNo(java.lang.String billDocumentNo) {
        this.billDocumentNo = billDocumentNo;
    }

    public com.turquaz.engine.dal.TurqCurrencyExchangeRate getTurqCurrencyExchangeRate() {
        return this.turqCurrencyExchangeRate;
    }

    public void setTurqCurrencyExchangeRate(com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate) {
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public java.util.Set getTurqConsignmentsInGroups() {
        return this.turqConsignmentsInGroups;
    }

    public void setTurqConsignmentsInGroups(java.util.Set turqConsignmentsInGroups) {
        this.turqConsignmentsInGroups = turqConsignmentsInGroups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqConsignment) ) return false;
        TurqConsignment castOther = (TurqConsignment) other;
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
