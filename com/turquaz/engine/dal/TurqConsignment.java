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
    private java.lang.String consignmentsBillDocumentNo;

    /** persistent field */
    private java.util.Date consignmentsDate;

    /** persistent field */
    private java.lang.String consignmentsDefinition;

    /** persistent field */
    private int condignmentsDiscountRate;

    /** persistent field */
    private int consignmentsVat;

    /** persistent field */
    private java.math.BigDecimal consignmentsDiscountAmount;

    /** persistent field */
    private java.math.BigDecimal consignmentsCharges;

    /** persistent field */
    private java.math.BigDecimal consignmentsVatAmount;

    /** persistent field */
    private java.math.BigDecimal consignmentsTotalAmount;

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
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBill turqBill;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqInventoryTransactions;

    /** persistent field */
    private Set turqConsignmentsInGroups;

    /** full constructor */
    public TurqConsignment(java.lang.String consignmentsBillDocumentNo, java.util.Date consignmentsDate, java.lang.String consignmentsDefinition, int condignmentsDiscountRate, int consignmentsVat, java.math.BigDecimal consignmentsDiscountAmount, java.math.BigDecimal consignmentsCharges, java.math.BigDecimal consignmentsVatAmount, java.math.BigDecimal consignmentsTotalAmount, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, int consignmentsType, boolean consignmentsPrinted, java.lang.String consignmentsDocumentNo, com.turquaz.engine.dal.TurqCompany turqCompany, com.turquaz.engine.dal.TurqBill turqBill, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqInventoryTransactions, Set turqConsignmentsInGroups) {
        this.consignmentsBillDocumentNo = consignmentsBillDocumentNo;
        this.consignmentsDate = consignmentsDate;
        this.consignmentsDefinition = consignmentsDefinition;
        this.condignmentsDiscountRate = condignmentsDiscountRate;
        this.consignmentsVat = consignmentsVat;
        this.consignmentsDiscountAmount = consignmentsDiscountAmount;
        this.consignmentsCharges = consignmentsCharges;
        this.consignmentsVatAmount = consignmentsVatAmount;
        this.consignmentsTotalAmount = consignmentsTotalAmount;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.consignmentsType = consignmentsType;
        this.consignmentsPrinted = consignmentsPrinted;
        this.consignmentsDocumentNo = consignmentsDocumentNo;
        this.turqCompany = turqCompany;
        this.turqBill = turqBill;
        this.turqCurrentCard = turqCurrentCard;
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

    public java.lang.String getConsignmentsBillDocumentNo() {
        return this.consignmentsBillDocumentNo;
    }

    public void setConsignmentsBillDocumentNo(java.lang.String consignmentsBillDocumentNo) {
        this.consignmentsBillDocumentNo = consignmentsBillDocumentNo;
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

    public int getCondignmentsDiscountRate() {
        return this.condignmentsDiscountRate;
    }

    public void setCondignmentsDiscountRate(int condignmentsDiscountRate) {
        this.condignmentsDiscountRate = condignmentsDiscountRate;
    }

    public int getConsignmentsVat() {
        return this.consignmentsVat;
    }

    public void setConsignmentsVat(int consignmentsVat) {
        this.consignmentsVat = consignmentsVat;
    }

    public java.math.BigDecimal getConsignmentsDiscountAmount() {
        return this.consignmentsDiscountAmount;
    }

    public void setConsignmentsDiscountAmount(java.math.BigDecimal consignmentsDiscountAmount) {
        this.consignmentsDiscountAmount = consignmentsDiscountAmount;
    }

    public java.math.BigDecimal getConsignmentsCharges() {
        return this.consignmentsCharges;
    }

    public void setConsignmentsCharges(java.math.BigDecimal consignmentsCharges) {
        this.consignmentsCharges = consignmentsCharges;
    }

    public java.math.BigDecimal getConsignmentsVatAmount() {
        return this.consignmentsVatAmount;
    }

    public void setConsignmentsVatAmount(java.math.BigDecimal consignmentsVatAmount) {
        this.consignmentsVatAmount = consignmentsVatAmount;
    }

    public java.math.BigDecimal getConsignmentsTotalAmount() {
        return this.consignmentsTotalAmount;
    }

    public void setConsignmentsTotalAmount(java.math.BigDecimal consignmentsTotalAmount) {
        this.consignmentsTotalAmount = consignmentsTotalAmount;
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

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
    }

    public com.turquaz.engine.dal.TurqBill getTurqBill() {
        return this.turqBill;
    }

    public void setTurqBill(com.turquaz.engine.dal.TurqBill turqBill) {
        this.turqBill = turqBill;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
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
