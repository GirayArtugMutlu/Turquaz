package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryAccountingType implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String typeName;
	/** persistent field */
	private java.lang.String definition;
	/** persistent field */
	private Set turqInventoryAccountingAccounts;

	/** full constructor */
	public TurqInventoryAccountingType(java.lang.Integer id, java.lang.String typeName, java.lang.String definition,
			Set turqInventoryAccountingAccounts)
	{
		this.id = id;
		this.typeName = typeName;
		this.definition = definition;
		this.turqInventoryAccountingAccounts = turqInventoryAccountingAccounts;
	}

	/** default constructor */
	public TurqInventoryAccountingType()
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

	public java.lang.String getTypeName()
	{
		return this.typeName;
	}

	public void setTypeName(java.lang.String typeName)
	{
		this.typeName = typeName;
	}

	public java.lang.String getDefinition()
	{
		return this.definition;
	}

	public void setDefinition(java.lang.String definition)
	{
		this.definition = definition;
	}

	public java.util.Set getTurqInventoryAccountingAccounts()
	{
		return this.turqInventoryAccountingAccounts;
	}

	public void setTurqInventoryAccountingAccounts(java.util.Set turqInventoryAccountingAccounts)
	{
		this.turqInventoryAccountingAccounts = turqInventoryAccountingAccounts;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqInventoryAccountingType))
			return false;
		TurqInventoryAccountingType castOther = (TurqInventoryAccountingType) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}