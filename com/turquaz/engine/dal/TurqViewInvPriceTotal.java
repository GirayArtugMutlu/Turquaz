package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewInvPriceTotal implements Serializable
{
	/** identifier field */
	private int engineSequencesId;
	/** identifier field */
	private java.math.BigDecimal totalprice;
	/** identifier field */
	private java.math.BigDecimal vatamount;
	/** identifier field */
	private java.math.BigDecimal specialvatamount;
	/** identifier field */
	private java.math.BigDecimal discountamount;

	/** full constructor */
	public TurqViewInvPriceTotal(int engineSequencesId, java.math.BigDecimal totalprice, java.math.BigDecimal vatamount,
			java.math.BigDecimal specialvatamount, java.math.BigDecimal discountamount)
	{
		this.engineSequencesId = engineSequencesId;
		this.totalprice = totalprice;
		this.vatamount = vatamount;
		this.specialvatamount = specialvatamount;
		this.discountamount = discountamount;
	}

	/** default constructor */
	public TurqViewInvPriceTotal()
	{
	}

	public int getEngineSequencesId()
	{
		return this.engineSequencesId;
	}

	public void setEngineSequencesId(int engineSequencesId)
	{
		this.engineSequencesId = engineSequencesId;
	}

	public java.math.BigDecimal getTotalprice()
	{
		return this.totalprice;
	}

	public void setTotalprice(java.math.BigDecimal totalprice)
	{
		this.totalprice = totalprice;
	}

	public java.math.BigDecimal getVatamount()
	{
		return this.vatamount;
	}

	public void setVatamount(java.math.BigDecimal vatamount)
	{
		this.vatamount = vatamount;
	}

	public java.math.BigDecimal getSpecialvatamount()
	{
		return this.specialvatamount;
	}

	public void setSpecialvatamount(java.math.BigDecimal specialvatamount)
	{
		this.specialvatamount = specialvatamount;
	}

	public java.math.BigDecimal getDiscountamount()
	{
		return this.discountamount;
	}

	public void setDiscountamount(java.math.BigDecimal discountamount)
	{
		this.discountamount = discountamount;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("engineSequencesId", getEngineSequencesId()).append("totalprice", getTotalprice())
				.append("vatamount", getVatamount()).append("specialvatamount", getSpecialvatamount()).append("discountamount",
						getDiscountamount()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqViewInvPriceTotal))
			return false;
		TurqViewInvPriceTotal castOther = (TurqViewInvPriceTotal) other;
		return new EqualsBuilder().append(this.getEngineSequencesId(), castOther.getEngineSequencesId()).append(this.getTotalprice(),
				castOther.getTotalprice()).append(this.getVatamount(), castOther.getVatamount()).append(this.getSpecialvatamount(),
				castOther.getSpecialvatamount()).append(this.getDiscountamount(), castOther.getDiscountamount()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getEngineSequencesId()).append(getTotalprice()).append(getVatamount()).append(
				getSpecialvatamount()).append(getDiscountamount()).toHashCode();
	}
}