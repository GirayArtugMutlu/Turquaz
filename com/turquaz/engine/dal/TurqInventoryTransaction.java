package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer inventoryTransactionsId;

    /** persistent field */
    private long transactionsAmount;

    /** persistent field */
    private java.math.BigDecimal transactionsUnitPrice;

    /** persistent field */
    private java.math.BigDecimal transactionsTotalPrice;

    /** persistent field */
    private java.math.BigDecimal transactionsDiscount;

    /** persistent field */
    private java.math.BigDecimal transactionsDiscountAmount;

    /** persistent field */
    private int transactionsVat;

    /** persistent field */
    private java.math.BigDecimal transactionsVatAmount;

    /** persistent field */
    private java.math.BigDecimal transactionsVatSpecialEach;

    /** persistent field */
    private java.math.BigDecimal transactionsVatSpecial;

    /** persistent field */
    private java.math.BigDecimal transactionsVatSpecialAmount;

    /** persistent field */
    private java.math.BigDecimal transactionsCumilativePrice;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryWarehous turqInventoryWarehous;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryUnit turqInventoryUnit;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard;

    /** persistent field */
    private com.turquaz.engine.dal.TurqConsignment turqConsignment;

    /** full constructor */
    public TurqInventoryTransaction(java.lang.Integer inventoryTransactionsId, long transactionsAmount, java.math.BigDecimal transactionsUnitPrice, java.math.BigDecimal transactionsTotalPrice, java.math.BigDecimal transactionsDiscount, java.math.BigDecimal transactionsDiscountAmount, int transactionsVat, java.math.BigDecimal transactionsVatAmount, java.math.BigDecimal transactionsVatSpecialEach, java.math.BigDecimal transactionsVatSpecial, java.math.BigDecimal transactionsVatSpecialAmount, java.math.BigDecimal transactionsCumilativePrice, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqInventoryWarehous turqInventoryWarehous, com.turquaz.engine.dal.TurqInventoryUnit turqInventoryUnit, com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard, com.turquaz.engine.dal.TurqConsignment turqConsignment) {
        this.inventoryTransactionsId = inventoryTransactionsId;
        this.transactionsAmount = transactionsAmount;
        this.transactionsUnitPrice = transactionsUnitPrice;
        this.transactionsTotalPrice = transactionsTotalPrice;
        this.transactionsDiscount = transactionsDiscount;
        this.transactionsDiscountAmount = transactionsDiscountAmount;
        this.transactionsVat = transactionsVat;
        this.transactionsVatAmount = transactionsVatAmount;
        this.transactionsVatSpecialEach = transactionsVatSpecialEach;
        this.transactionsVatSpecial = transactionsVatSpecial;
        this.transactionsVatSpecialAmount = transactionsVatSpecialAmount;
        this.transactionsCumilativePrice = transactionsCumilativePrice;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqInventoryWarehous = turqInventoryWarehous;
        this.turqInventoryUnit = turqInventoryUnit;
        this.turqInventoryCard = turqInventoryCard;
        this.turqConsignment = turqConsignment;
    }

    /** default constructor */
    public TurqInventoryTransaction() {
    }

    public java.lang.Integer getInventoryTransactionsId() {
        return this.inventoryTransactionsId;
    }

    public void setInventoryTransactionsId(java.lang.Integer inventoryTransactionsId) {
        this.inventoryTransactionsId = inventoryTransactionsId;
    }

    public long getTransactionsAmount() {
        return this.transactionsAmount;
    }

    public void setTransactionsAmount(long transactionsAmount) {
        this.transactionsAmount = transactionsAmount;
    }

    public java.math.BigDecimal getTransactionsUnitPrice() {
        return this.transactionsUnitPrice;
    }

    public void setTransactionsUnitPrice(java.math.BigDecimal transactionsUnitPrice) {
        this.transactionsUnitPrice = transactionsUnitPrice;
    }

    public java.math.BigDecimal getTransactionsTotalPrice() {
        return this.transactionsTotalPrice;
    }

    public void setTransactionsTotalPrice(java.math.BigDecimal transactionsTotalPrice) {
        this.transactionsTotalPrice = transactionsTotalPrice;
    }

    public java.math.BigDecimal getTransactionsDiscount() {
        return this.transactionsDiscount;
    }

    public void setTransactionsDiscount(java.math.BigDecimal transactionsDiscount) {
        this.transactionsDiscount = transactionsDiscount;
    }

    public java.math.BigDecimal getTransactionsDiscountAmount() {
        return this.transactionsDiscountAmount;
    }

    public void setTransactionsDiscountAmount(java.math.BigDecimal transactionsDiscountAmount) {
        this.transactionsDiscountAmount = transactionsDiscountAmount;
    }

    public int getTransactionsVat() {
        return this.transactionsVat;
    }

    public void setTransactionsVat(int transactionsVat) {
        this.transactionsVat = transactionsVat;
    }

    public java.math.BigDecimal getTransactionsVatAmount() {
        return this.transactionsVatAmount;
    }

    public void setTransactionsVatAmount(java.math.BigDecimal transactionsVatAmount) {
        this.transactionsVatAmount = transactionsVatAmount;
    }

    public java.math.BigDecimal getTransactionsVatSpecialEach() {
        return this.transactionsVatSpecialEach;
    }

    public void setTransactionsVatSpecialEach(java.math.BigDecimal transactionsVatSpecialEach) {
        this.transactionsVatSpecialEach = transactionsVatSpecialEach;
    }

    public java.math.BigDecimal getTransactionsVatSpecial() {
        return this.transactionsVatSpecial;
    }

    public void setTransactionsVatSpecial(java.math.BigDecimal transactionsVatSpecial) {
        this.transactionsVatSpecial = transactionsVatSpecial;
    }

    public java.math.BigDecimal getTransactionsVatSpecialAmount() {
        return this.transactionsVatSpecialAmount;
    }

    public void setTransactionsVatSpecialAmount(java.math.BigDecimal transactionsVatSpecialAmount) {
        this.transactionsVatSpecialAmount = transactionsVatSpecialAmount;
    }

    public java.math.BigDecimal getTransactionsCumilativePrice() {
        return this.transactionsCumilativePrice;
    }

    public void setTransactionsCumilativePrice(java.math.BigDecimal transactionsCumilativePrice) {
        this.transactionsCumilativePrice = transactionsCumilativePrice;
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

    public com.turquaz.engine.dal.TurqInventoryWarehous getTurqInventoryWarehous() {
        return this.turqInventoryWarehous;
    }

    public void setTurqInventoryWarehous(com.turquaz.engine.dal.TurqInventoryWarehous turqInventoryWarehous) {
        this.turqInventoryWarehous = turqInventoryWarehous;
    }

    public com.turquaz.engine.dal.TurqInventoryUnit getTurqInventoryUnit() {
        return this.turqInventoryUnit;
    }

    public void setTurqInventoryUnit(com.turquaz.engine.dal.TurqInventoryUnit turqInventoryUnit) {
        this.turqInventoryUnit = turqInventoryUnit;
    }

    public com.turquaz.engine.dal.TurqInventoryCard getTurqInventoryCard() {
        return this.turqInventoryCard;
    }

    public void setTurqInventoryCard(com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard) {
        this.turqInventoryCard = turqInventoryCard;
    }

    public com.turquaz.engine.dal.TurqConsignment getTurqConsignment() {
        return this.turqConsignment;
    }

    public void setTurqConsignment(com.turquaz.engine.dal.TurqConsignment turqConsignment) {
        this.turqConsignment = turqConsignment;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("inventoryTransactionsId", getInventoryTransactionsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqInventoryTransaction) ) return false;
        TurqInventoryTransaction castOther = (TurqInventoryTransaction) other;
        return new EqualsBuilder()
            .append(this.getInventoryTransactionsId(), castOther.getInventoryTransactionsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getInventoryTransactionsId())
            .toHashCode();
    }

}