package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewAccTotal implements Serializable
{
	/** identifier field */
	private int accountingAccountsId;
	/** identifier field */
	private java.math.BigDecimal totalcreditamount;
	/** identifier field */
	private java.math.BigDecimal totaldeptamount;

	/** full constructor */
	public TurqViewAccTotal(int accountingAccountsId, java.math.BigDecimal totalcreditamount, java.math.BigDecimal totaldeptamount)
	{
		this.accountingAccountsId = accountingAccountsId;
		this.totalcreditamount = totalcreditamount;
		this.totaldeptamount = totaldeptamount;
	}

	/** default constructor */
	public TurqViewAccTotal()
	{
	}

	public int getAccountingAccountsId()
	{
		return this.accountingAccountsId;
	}

	public void setAccountingAccountsId(int accountingAccountsId)
	{
		this.accountingAccountsId = accountingAccountsId;
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
		return new ToStringBuilder(this).append("accountingAccountsId", getAccountingAccountsId()).append("totalcreditamount",
				getTotalcreditamount()).append("totaldeptamount", getTotaldeptamount()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqViewAccTotal))
			return false;
		TurqViewAccTotal castOther = (TurqViewAccTotal) other;
		return new EqualsBuilder().append(this.getAccountingAccountsId(), castOther.getAccountingAccountsId()).append(
				this.getTotalcreditamount(), castOther.getTotalcreditamount()).append(this.getTotaldeptamount(),
				castOther.getTotaldeptamount()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getAccountingAccountsId()).append(getTotalcreditamount()).append(getTotaldeptamount())
				.toHashCode();
	}
}