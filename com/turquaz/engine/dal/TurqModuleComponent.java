package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqModuleComponent implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String componentsName;
	/** persistent field */
	private java.lang.String componentsDescription;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date updateDate;
	/** persistent field */
	private com.turquaz.engine.dal.TurqModule turqModule;
	/** persistent field */
	private Set turqUserPermissions;
	/** persistent field */
	private Set turqGroupPermissions;

	/** full constructor */
	public TurqModuleComponent(java.lang.String componentsName, java.lang.String componentsDescription, java.lang.String createdBy,
			java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate,
			com.turquaz.engine.dal.TurqModule turqModule, Set turqUserPermissions, Set turqGroupPermissions)
	{
		this.componentsName = componentsName;
		this.componentsDescription = componentsDescription;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.updateDate = updateDate;
		this.turqModule = turqModule;
		this.turqUserPermissions = turqUserPermissions;
		this.turqGroupPermissions = turqGroupPermissions;
	}

	/** default constructor */
	public TurqModuleComponent()
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

	public java.lang.String getComponentsName()
	{
		return this.componentsName;
	}

	public void setComponentsName(java.lang.String componentsName)
	{
		this.componentsName = componentsName;
	}

	public java.lang.String getComponentsDescription()
	{
		return this.componentsDescription;
	}

	public void setComponentsDescription(java.lang.String componentsDescription)
	{
		this.componentsDescription = componentsDescription;
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

	public java.util.Date getUpdateDate()
	{
		return this.updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public com.turquaz.engine.dal.TurqModule getTurqModule()
	{
		return this.turqModule;
	}

	public void setTurqModule(com.turquaz.engine.dal.TurqModule turqModule)
	{
		this.turqModule = turqModule;
	}

	public java.util.Set getTurqUserPermissions()
	{
		return this.turqUserPermissions;
	}

	public void setTurqUserPermissions(java.util.Set turqUserPermissions)
	{
		this.turqUserPermissions = turqUserPermissions;
	}

	public java.util.Set getTurqGroupPermissions()
	{
		return this.turqGroupPermissions;
	}

	public void setTurqGroupPermissions(java.util.Set turqGroupPermissions)
	{
		this.turqGroupPermissions = turqGroupPermissions;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqModuleComponent))
			return false;
		TurqModuleComponent castOther = (TurqModuleComponent) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}