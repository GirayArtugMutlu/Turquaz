package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqConsignmentsInGroup implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date lastModified;
	/** persistent field */
	private com.turquaz.engine.dal.TurqConsignmentGroup turqConsignmentGroup;
	/** persistent field */
	private com.turquaz.engine.dal.TurqConsignment turqConsignment;

	/** full constructor */
	public TurqConsignmentsInGroup(java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy,
			java.util.Date lastModified, com.turquaz.engine.dal.TurqConsignmentGroup turqConsignmentGroup,
			com.turquaz.engine.dal.TurqConsignment turqConsignment)
	{
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.lastModified = lastModified;
		this.turqConsignmentGroup = turqConsignmentGroup;
		this.turqConsignment = turqConsignment;
	}

	/** default constructor */
	public TurqConsignmentsInGroup()
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

	public com.turquaz.engine.dal.TurqConsignmentGroup getTurqConsignmentGroup()
	{
		return this.turqConsignmentGroup;
	}

	public void setTurqConsignmentGroup(com.turquaz.engine.dal.TurqConsignmentGroup turqConsignmentGroup)
	{
		this.turqConsignmentGroup = turqConsignmentGroup;
	}

	public com.turquaz.engine.dal.TurqConsignment getTurqConsignment()
	{
		return this.turqConsignment;
	}

	public void setTurqConsignment(com.turquaz.engine.dal.TurqConsignment turqConsignment)
	{
		this.turqConsignment = turqConsignment;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqConsignmentsInGroup))
			return false;
		TurqConsignmentsInGroup castOther = (TurqConsignmentsInGroup) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}