package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqGroup implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String groupsName;
	/** persistent field */
	private java.lang.String groupsDescription;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date updateDate;
	/** persistent field */
	private Set turqUserGroups;
	/** persistent field */
	private Set turqGroupPermissions;

	/** full constructor */
	public TurqGroup(java.lang.String groupsName, java.lang.String groupsDescription, java.lang.String createdBy,
			java.util.Date creationDate, java.lang.String updatedBy, java.util.Date updateDate, Set turqUserGroups,
			Set turqGroupPermissions)
	{
		this.groupsName = groupsName;
		this.groupsDescription = groupsDescription;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.updateDate = updateDate;
		this.turqUserGroups = turqUserGroups;
		this.turqGroupPermissions = turqGroupPermissions;
	}

	/** default constructor */
	public TurqGroup()
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

	public java.lang.String getGroupsName()
	{
		return this.groupsName;
	}

	public void setGroupsName(java.lang.String groupsName)
	{
		this.groupsName = groupsName;
	}

	public java.lang.String getGroupsDescription()
	{
		return this.groupsDescription;
	}

	public void setGroupsDescription(java.lang.String groupsDescription)
	{
		this.groupsDescription = groupsDescription;
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

	public java.util.Set getTurqUserGroups()
	{
		return this.turqUserGroups;
	}

	public void setTurqUserGroups(java.util.Set turqUserGroups)
	{
		this.turqUserGroups = turqUserGroups;
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
		if (!(other instanceof TurqGroup))
			return false;
		TurqGroup castOther = (TurqGroup) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}