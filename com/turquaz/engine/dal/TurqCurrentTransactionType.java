package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentTransactionType implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String transactionTypeName;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date lastModified;
	/** persistent field */
	private Set turqCurrentTransactions;

	/** full constructor */
	public TurqCurrentTransactionType(java.lang.String transactionTypeName, java.lang.String createdBy, java.util.Date creationDate,
			java.lang.String updatedBy, java.util.Date lastModified, Set turqCurrentTransactions)
	{
		this.transactionTypeName = transactionTypeName;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.lastModified = lastModified;
		this.turqCurrentTransactions = turqCurrentTransactions;
	}

	/** default constructor */
	public TurqCurrentTransactionType()
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

	public java.lang.String getTransactionTypeName()
	{
		return this.transactionTypeName;
	}

	public void setTransactionTypeName(java.lang.String transactionTypeName)
	{
		this.transactionTypeName = transactionTypeName;
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

	public java.util.Set getTurqCurrentTransactions()
	{
		return this.turqCurrentTransactions;
	}

	public void setTurqCurrentTransactions(java.util.Set turqCurrentTransactions)
	{
		this.turqCurrentTransactions = turqCurrentTransactions;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqCurrentTransactionType))
			return false;
		TurqCurrentTransactionType castOther = (TurqCurrentTransactionType) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}