package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCashTransactionType implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String cashTransationTypeName;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date lastModified;
	/** persistent field */
	private Set turqCashTransactions;

	/** full constructor */
	public TurqCashTransactionType(java.lang.String cashTransationTypeName, java.lang.String createdBy, java.util.Date creationDate,
			java.lang.String updatedBy, java.util.Date lastModified, Set turqCashTransactions)
	{
		this.cashTransationTypeName = cashTransationTypeName;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.lastModified = lastModified;
		this.turqCashTransactions = turqCashTransactions;
	}

	/** default constructor */
	public TurqCashTransactionType()
	{
	}

	public java.lang.Integer getId()
	{
		return this.id;
	}

	public void setId(java.lang.Integer id)
	{
		this.id = id;
	}

	public java.lang.String getCashTransationTypeName()
	{
		return this.cashTransationTypeName;
	}

	public void setCashTransationTypeName(java.lang.String cashTransationTypeName)
	{
		this.cashTransationTypeName = cashTransationTypeName;
	}

	public java.lang.String getCreatedBy()
	{
		return this.createdBy;
	}

	public void setCreatedBy(java.lang.String createdBy)
	{
		this.createdBy = createdBy;
	}

	public java.util.Date getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(java.util.Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public java.lang.String getUpdatedBy()
	{
		return this.updatedBy;
	}

	public void setUpdatedBy(java.lang.String updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	public java.util.Date getLastModified()
	{
		return this.lastModified;
	}

	public void setLastModified(java.util.Date lastModified)
	{
		this.lastModified = lastModified;
	}

	public java.util.Set getTurqCashTransactions()
	{
		return this.turqCashTransactions;
	}

	public void setTurqCashTransactions(java.util.Set turqCashTransactions)
	{
		this.turqCashTransactions = turqCashTransactions;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqCashTransactionType))
			return false;
		TurqCashTransactionType castOther = (TurqCashTransactionType) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}