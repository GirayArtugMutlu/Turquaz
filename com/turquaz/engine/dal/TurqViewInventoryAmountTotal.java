package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewInventoryAmountTotal implements Serializable
{
	/** identifier field */
	private int inventoryCardsId;
	/** identifier field */
	private java.math.BigDecimal transactionsAmountIn;
	/** identifier field */
	private java.math.BigDecimal transactionsTotalAmountOut;
	/** identifier field */
	private java.math.BigDecimal transactionsTotalAmountNow;

	/** full constructor */
	public TurqViewInventoryAmountTotal(int inventoryCardsId, java.math.BigDecimal transactionsAmountIn,
			java.math.BigDecimal transactionsTotalAmountOut, java.math.BigDecimal transactionsTotalAmountNow)
	{
		this.inventoryCardsId = inventoryCardsId;
		this.transactionsAmountIn = transactionsAmountIn;
		this.transactionsTotalAmountOut = transactionsTotalAmountOut;
		this.transactionsTotalAmountNow = transactionsTotalAmountNow;
	}

	/** default constructor */
	public TurqViewInventoryAmountTotal()
	{
	}

	public int getInventoryCardsId()
	{
		return this.inventoryCardsId;
	}

	public void setInventoryCardsId(int inventoryCardsId)
	{
		this.inventoryCardsId = inventoryCardsId;
	}

	public java.math.BigDecimal getTransactionsAmountIn()
	{
		return this.transactionsAmountIn;
	}

	public void setTransactionsAmountIn(java.math.BigDecimal transactionsAmountIn)
	{
		this.transactionsAmountIn = transactionsAmountIn;
	}

	public java.math.BigDecimal getTransactionsTotalAmountOut()
	{
		return this.transactionsTotalAmountOut;
	}

	public void setTransactionsTotalAmountOut(java.math.BigDecimal transactionsTotalAmountOut)
	{
		this.transactionsTotalAmountOut = transactionsTotalAmountOut;
	}

	public java.math.BigDecimal getTransactionsTotalAmountNow()
	{
		return this.transactionsTotalAmountNow;
	}

	public void setTransactionsTotalAmountNow(java.math.BigDecimal transactionsTotalAmountNow)
	{
		this.transactionsTotalAmountNow = transactionsTotalAmountNow;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("inventoryCardsId", getInventoryCardsId()).append("transactionsAmountIn",
				getTransactionsAmountIn()).append("transactionsTotalAmountOut", getTransactionsTotalAmountOut()).append(
				"transactionsTotalAmountNow", getTransactionsTotalAmountNow()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqViewInventoryAmountTotal))
			return false;
		TurqViewInventoryAmountTotal castOther = (TurqViewInventoryAmountTotal) other;
		return new EqualsBuilder().append(this.getInventoryCardsId(), castOther.getInventoryCardsId()).append(
				this.getTransactionsAmountIn(), castOther.getTransactionsAmountIn()).append(this.getTransactionsTotalAmountOut(),
				castOther.getTransactionsTotalAmountOut()).append(this.getTransactionsTotalAmountNow(),
				castOther.getTransactionsTotalAmountNow()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getInventoryCardsId()).append(getTransactionsAmountIn()).append(
				getTransactionsTotalAmountOut()).append(getTransactionsTotalAmountNow()).toHashCode();
	}
}