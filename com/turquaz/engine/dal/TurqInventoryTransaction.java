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
    private java.math.BigDecimal amountIn;

    /** persistent field */
    private java.math.BigDecimal unitPrice;

    /** persistent field */
    private java.math.BigDecimal totalPrice;

    /** persistent field */
    private java.math.BigDecimal discountRate;

    /** persistent field */
    private java.math.BigDecimal discountAmount;

    /** persistent field */
    private java.math.BigDecimal vatAmount;

    /** persistent field */
    private java.math.BigDecimal vatSpecialUnitPrice;

    /** persistent field */
    private java.math.BigDecimal vatSpecialRate;

    /** persistent field */
    private java.math.BigDecimal vatSpecialAmount;

    /** persistent field */
    private java.math.BigDecimal cumilativePrice;

    /** persistent field */
    private java.math.BigDecimal amountOut;

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
    private java.lang.String documentNo;

    /** persistent field */
    private java.lang.String definition;

    /** persistent field */
    private java.math.BigDecimal vatRate;

    /** persistent field */
    private java.math.BigDecimal unitPriceInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal totalPriceInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal discountAmountInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal vatAmountInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal vatSpecialUnitPriceInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal vatSpecialAmountInForeignCurrency;

    /** persistent field */
    private java.math.BigDecimal cumilativePriceInForeignCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryWarehous turqInventoryWarehous;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryTransactionType turqInventoryTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryUnit turqInventoryUnit;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** full constructor */
    public TurqInventoryTransaction(java.math.BigDecimal amountIn, java.math.BigDecimal unitPrice, java.math.BigDecimal totalPrice, java.math.BigDecimal discountRate, java.math.BigDecimal discountAmount, java.math.BigDecimal vatAmount, java.math.BigDecimal vatSpecialUnitPrice, java.math.BigDecimal vatSpecialRate, java.math.BigDecimal vatSpecialAmount, java.math.BigDecimal cumilativePrice, java.math.BigDecimal amountOut, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.util.Date transactionsDate, java.lang.String documentNo, java.lang.String definition, java.math.BigDecimal vatRate, java.math.BigDecimal unitPriceInForeignCurrency, java.math.BigDecimal totalPriceInForeignCurrency, java.math.BigDecimal discountAmountInForeignCurrency, java.math.BigDecimal vatAmountInForeignCurrency, java.math.BigDecimal vatSpecialUnitPriceInForeignCurrency, java.math.BigDecimal vatSpecialAmountInForeignCurrency, java.math.BigDecimal cumilativePriceInForeignCurrency, com.turquaz.engine.dal.TurqInventoryWarehous turqInventoryWarehous, com.turquaz.engine.dal.TurqInventoryTransactionType turqInventoryTransactionType, com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate, com.turquaz.engine.dal.TurqInventoryUnit turqInventoryUnit, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, com.turquaz.engine.dal.TurqInventoryCard turqInventoryCard, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.amountIn = amountIn;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
        this.vatAmount = vatAmount;
        this.vatSpecialUnitPrice = vatSpecialUnitPrice;
        this.vatSpecialRate = vatSpecialRate;
        this.vatSpecialAmount = vatSpecialAmount;
        this.cumilativePrice = cumilativePrice;
        this.amountOut = amountOut;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.transactionsDate = transactionsDate;
        this.documentNo = documentNo;
        this.definition = definition;
        this.vatRate = vatRate;
        this.unitPriceInForeignCurrency = unitPriceInForeignCurrency;
        this.totalPriceInForeignCurrency = totalPriceInForeignCurrency;
        this.discountAmountInForeignCurrency = discountAmountInForeignCurrency;
        this.vatAmountInForeignCurrency = vatAmountInForeignCurrency;
        this.vatSpecialUnitPriceInForeignCurrency = vatSpecialUnitPriceInForeignCurrency;
        this.vatSpecialAmountInForeignCurrency = vatSpecialAmountInForeignCurrency;
        this.cumilativePriceInForeignCurrency = cumilativePriceInForeignCurrency;
        this.turqInventoryWarehous = turqInventoryWarehous;
        this.turqInventoryTransactionType = turqInventoryTransactionType;
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
        this.turqInventoryUnit = turqInventoryUnit;
        this.turqEngineSequence = turqEngineSequence;
        this.turqInventoryCard = turqInventoryCard;
        this.turqCurrentCard = turqCurrentCard;
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

    public java.math.BigDecimal getAmountIn() {
        return this.amountIn;
    }

    public void setAmountIn(java.math.BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    public java.math.BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(java.math.BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public java.math.BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(java.math.BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public java.math.BigDecimal getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(java.math.BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public java.math.BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }

    public void setDiscountAmount(java.math.BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public java.math.BigDecimal getVatAmount() {
        return this.vatAmount;
    }

    public void setVatAmount(java.math.BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }

    public java.math.BigDecimal getVatSpecialUnitPrice() {
        return this.vatSpecialUnitPrice;
    }

    public void setVatSpecialUnitPrice(java.math.BigDecimal vatSpecialUnitPrice) {
        this.vatSpecialUnitPrice = vatSpecialUnitPrice;
    }

    public java.math.BigDecimal getVatSpecialRate() {
        return this.vatSpecialRate;
    }

    public void setVatSpecialRate(java.math.BigDecimal vatSpecialRate) {
        this.vatSpecialRate = vatSpecialRate;
    }

    public java.math.BigDecimal getVatSpecialAmount() {
        return this.vatSpecialAmount;
    }

    public void setVatSpecialAmount(java.math.BigDecimal vatSpecialAmount) {
        this.vatSpecialAmount = vatSpecialAmount;
    }

    public java.math.BigDecimal getCumilativePrice() {
        return this.cumilativePrice;
    }

    public void setCumilativePrice(java.math.BigDecimal cumilativePrice) {
        this.cumilativePrice = cumilativePrice;
    }

    public java.math.BigDecimal getAmountOut() {
        return this.amountOut;
    }

    public void setAmountOut(java.math.BigDecimal amountOut) {
        this.amountOut = amountOut;
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

    public java.lang.String getDocumentNo() {
        return this.documentNo;
    }

    public void setDocumentNo(java.lang.String documentNo) {
        this.documentNo = documentNo;
    }

    public java.lang.String getDefinition() {
        return this.definition;
    }

    public void setDefinition(java.lang.String definition) {
        this.definition = definition;
    }

    public java.math.BigDecimal getVatRate() {
        return this.vatRate;
    }

    public void setVatRate(java.math.BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    public java.math.BigDecimal getUnitPriceInForeignCurrency() {
        return this.unitPriceInForeignCurrency;
    }

    public void setUnitPriceInForeignCurrency(java.math.BigDecimal unitPriceInForeignCurrency) {
        this.unitPriceInForeignCurrency = unitPriceInForeignCurrency;
    }

    public java.math.BigDecimal getTotalPriceInForeignCurrency() {
        return this.totalPriceInForeignCurrency;
    }

    public void setTotalPriceInForeignCurrency(java.math.BigDecimal totalPriceInForeignCurrency) {
        this.totalPriceInForeignCurrency = totalPriceInForeignCurrency;
    }

    public java.math.BigDecimal getDiscountAmountInForeignCurrency() {
        return this.discountAmountInForeignCurrency;
    }

    public void setDiscountAmountInForeignCurrency(java.math.BigDecimal discountAmountInForeignCurrency) {
        this.discountAmountInForeignCurrency = discountAmountInForeignCurrency;
    }

    public java.math.BigDecimal getVatAmountInForeignCurrency() {
        return this.vatAmountInForeignCurrency;
    }

    public void setVatAmountInForeignCurrency(java.math.BigDecimal vatAmountInForeignCurrency) {
        this.vatAmountInForeignCurrency = vatAmountInForeignCurrency;
    }

    public java.math.BigDecimal getVatSpecialUnitPriceInForeignCurrency() {
        return this.vatSpecialUnitPriceInForeignCurrency;
    }

    public void setVatSpecialUnitPriceInForeignCurrency(java.math.BigDecimal vatSpecialUnitPriceInForeignCurrency) {
        this.vatSpecialUnitPriceInForeignCurrency = vatSpecialUnitPriceInForeignCurrency;
    }

    public java.math.BigDecimal getVatSpecialAmountInForeignCurrency() {
        return this.vatSpecialAmountInForeignCurrency;
    }

    public void setVatSpecialAmountInForeignCurrency(java.math.BigDecimal vatSpecialAmountInForeignCurrency) {
        this.vatSpecialAmountInForeignCurrency = vatSpecialAmountInForeignCurrency;
    }

    public java.math.BigDecimal getCumilativePriceInForeignCurrency() {
        return this.cumilativePriceInForeignCurrency;
    }

    public void setCumilativePriceInForeignCurrency(java.math.BigDecimal cumilativePriceInForeignCurrency) {
        this.cumilativePriceInForeignCurrency = cumilativePriceInForeignCurrency;
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

    public com.turquaz.engine.dal.TurqCurrencyExchangeRate getTurqCurrencyExchangeRate() {
        return this.turqCurrencyExchangeRate;
    }

    public void setTurqCurrencyExchangeRate(com.turquaz.engine.dal.TurqCurrencyExchangeRate turqCurrencyExchangeRate) {
        this.turqCurrencyExchangeRate = turqCurrencyExchangeRate;
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

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
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
