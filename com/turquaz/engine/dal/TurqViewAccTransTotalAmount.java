package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewAccTransTotalAmount implements Serializable
{
	/** identifier field */
	private int accountingTransactionsId;
	/** identifier field */
	private java.math.BigDecimal totalcreditamount;
	/** identifier field */
	private java.math.BigDecimal totaldeptamount;

	/** full constructor */
	public TurqViewAccTransTotalAmount(int accountingTransactionsId, java.math.BigDecimal totalcreditamount,
			java.math.BigDecimal totaldeptamount)
	{
		this.accountingTransactionsId = accountingTransactionsId;
		this.totalcreditamount = totalcreditamount;
		this.totaldeptamount = totaldeptamount;
	}

	/** default constructor */
	public TurqViewAccTransTotalAmount()
	{
	}

	public int getAccountingTransactionsId()
	{
		return this.accountingTransactionsId;
	}

	public void setAccountingTransactionsId(int accountingTransactionsId)
	{
		this.accountingTransactionsId = accountingTransactionsId;
	}

	public java.math.BigDecimal getTotalcreditamount()
	{
		return this.totalcreditamount;
	}

	public void setTotalcreditamount(java.math.BigDecimal totalcreditamount)
	{
		this.totalcreditamount = totalcreditamount;
	}

	public java.math.BigDecimal getTotaldeptamount()
	{
		return this.totaldeptamount;
	}

	public void setTotaldeptamount(java.math.BigDecimal totaldeptamount)
	{
		this.totaldeptamount = totaldeptamount;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("accountingTransactionsId", getAccountingTransactionsId()).append("totalcreditamount",
				getTotalcreditamount()).append("totaldeptamount", getTotaldeptamount()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqViewAccTransTotalAmount))
			return false;
		TurqViewAccTransTotalAmount castOther = (TurqViewAccTransTotalAmount) other;
		return new EqualsBuilder().append(this.getAccountingTransactionsId(), castOther.getAccountingTransactionsId()).append(
				this.getTotalcreditamount(), castOther.getTotalcreditamount()).append(this.getTotaldeptamount(),
				castOther.getTotaldeptamount()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getAccountingTransactionsId()).append(getTotalcreditamount()).append(getTotaldeptamount())
				.toHashCode();
	}
}