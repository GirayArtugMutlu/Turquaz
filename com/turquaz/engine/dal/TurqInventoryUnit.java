package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryUnit implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String unitsName;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date lastModified;
	/** persistent field */
	private Set turqInventoryTransactions;
	/** persistent field */
	private Set turqInventoryCardUnits;

	/** full constructor */
	public TurqInventoryUnit(java.lang.String unitsName, java.lang.String createdBy, java.util.Date creationDate,
			java.lang.String updatedBy, java.util.Date lastModified, Set turqInventoryTransactions, Set turqInventoryCardUnits)
	{
		this.unitsName = unitsName;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.lastModified = lastModified;
		this.turqInventoryTransactions = turqInventoryTransactions;
		this.turqInventoryCardUnits = turqInventoryCardUnits;
	}

	/** default constructor */
	public TurqInventoryUnit()
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

	public java.lang.String getUnitsName()
	{
		return this.unitsName;
	}

	public void setUnitsName(java.lang.String unitsName)
	{
		this.unitsName = unitsName;
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

	public java.util.Set getTurqInventoryTransactions()
	{
		return this.turqInventoryTransactions;
	}

	public void setTurqInventoryTransactions(java.util.Set turqInventoryTransactions)
	{
		this.turqInventoryTransactions = turqInventoryTransactions;
	}

	public java.util.Set getTurqInventoryCardUnits()
	{
		return this.turqInventoryCardUnits;
	}

	public void setTurqInventoryCardUnits(java.util.Set turqInventoryCardUnits)
	{
		this.turqInventoryCardUnits = turqInventoryCardUnits;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqInventoryUnit))
			return false;
		TurqInventoryUnit castOther = (TurqInventoryUnit) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}