package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryTransaction implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.math.BigDecimal transactionsAmountIn;

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
    private java.math.BigDecimal transactionsTotalAmountOut;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.util.Date transactionsDate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryWarehous turqInventoryWarehous;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryTransactionType turqInventoryTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryUnit turqInventoryUnit;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard;

    /** full constructor */
    public TurqInventoryTransaction(java.math.BigDecimal transactionsAmountIn, java.math.BigDecimal transactionsUnitPrice, java.math.BigDecimal transactionsTotalPrice, java.math.BigDecimal transactionsDiscount, java.math.BigDecimal transactionsDiscountAmount, int transactionsVat, java.math.BigDecimal transactionsVatAmount, java.math.BigDecimal transactionsVatSpecialEach, java.math.BigDecimal transactionsVatSpecial, java.math.BigDecimal transactionsVatSpecialAmount, java.math.BigDecimal transactionsCumilativePrice, java.math.BigDecimal transactionsTotalAmountOut, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.util.Date transactionsDate, com.turquaz.engine.dal.TurqInventoryWarehous turqInventoryWarehous, com.turquaz.engine.dal.TurqInventoryTransactionType turqInventoryTransactionType, com.turquaz.engine.dal.TurqInventoryUnit turqInventoryUnit, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard) {
        this.transactionsAmountIn = transactionsAmountIn;
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
        this.transactionsTotalAmountOut = transactionsTotalAmountOut;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.transactionsDate = transactionsDate;
        this.turqInventoryWarehous = turqInventoryWarehous;
        this.turqInventoryTransactionType = turqInventoryTransactionType;
        this.turqInventoryUnit = turqInventoryUnit;
        this.turqEngineSequence = turqEngineSequence;
        this.turqInventoryCard = turqInventoryCard;
    }

    /** default constructor */
    public TurqInventoryTransaction() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.math.BigDecimal getTransactionsAmountIn() {
        return this.transactionsAmountIn;
    }

    public void setTransactionsAmountIn(java.math.BigDecimal transactionsAmountIn) {
        this.transactionsAmountIn = transactionsAmountIn;
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

    public java.math.BigDecimal getTransactionsTotalAmountOut() {
        return this.transactionsTotalAmountOut;
    }

    public void setTransactionsTotalAmountOut(java.math.BigDecimal transactionsTotalAmountOut) {
        this.transactionsTotalAmountOut = transactionsTotalAmountOut;
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

    public java.util.Date getTransactionsDate() {
        return this.transactionsDate;
    }

    public void setTransactionsDate(java.util.Date transactionsDate) {
        this.transactionsDate = transactionsDate;
    }

    public com.turquaz.engine.dal.TurqInventoryWarehous getTurqInventoryWarehous() {
        return this.turqInventoryWarehous;
    }

    public void setTurqInventoryWarehous(com.turquaz.engine.dal.TurqInventoryWarehous turqInventoryWarehous) {
        this.turqInventoryWarehous = turqInventoryWarehous;
    }

    public com.turquaz.engine.dal.TurqInventoryTransactionType getTurqInventoryTransactionType() {
        return this.turqInventoryTransactionType;
    }

    public void setTurqInventoryTransactionType(com.turquaz.engine.dal.TurqInventoryTransactionType turqInventoryTransactionType) {
        this.turqInventoryTransactionType = turqInventoryTransactionType;
    }

    public com.turquaz.engine.dal.TurqInventoryUnit getTurqInventoryUnit() {
        return this.turqInventoryUnit;
    }

    public void setTurqInventoryUnit(com.turquaz.engine.dal.TurqInventoryUnit turqInventoryUnit) {
        this.turqInventoryUnit = turqInventoryUnit;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
    }

    public com.turquaz.engine.dal.TurqInventoryCard getTurqInventoryCard() {
        return this.turqInventoryCard;
    }

    public void setTurqInventoryCard(com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard) {
        this.turqInventoryCard = turqInventoryCard;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqInventoryTransaction) ) return false;
        TurqInventoryTransaction castOther = (TurqInventoryTransaction) other;
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
