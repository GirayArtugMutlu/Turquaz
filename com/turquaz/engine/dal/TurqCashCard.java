package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCashCard implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String cashCardName;
	/** persistent field */
	private java.lang.String cashCardDefinition;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date lastModified;
	/** persistent field */
	private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;
	/** persistent field */
	private Set turqCashTransactionRows;

	/** full constructor */
	public TurqCashCard(java.lang.String cashCardName, java.lang.String cashCardDefinition, java.lang.String createdBy,
			java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified,
			com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount, Set turqCashTransactionRows)
	{
		this.cashCardName = cashCardName;
		this.cashCardDefinition = cashCardDefinition;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.lastModified = lastModified;
		this.turqAccountingAccount = turqAccountingAccount;
		this.turqCashTransactionRows = turqCashTransactionRows;
	}

	/** default constructor */
	public TurqCashCard()
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

	public java.lang.String getCashCardName()
	{
		return this.cashCardName;
	}

	public void setCashCardName(java.lang.String cashCardName)
	{
		this.cashCardName = cashCardName;
	}

	public java.lang.String getCashCardDefinition()
	{
		return this.cashCardDefinition;
	}

	public void setCashCardDefinition(java.lang.String cashCardDefinition)
	{
		this.cashCardDefinition = cashCardDefinition;
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

	public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount()
	{
		return this.turqAccountingAccount;
	}

	public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount)
	{
		this.turqAccountingAccount = turqAccountingAccount;
	}

	public java.util.Set getTurqCashTransactionRows()
	{
		return this.turqCashTransactionRows;
	}

	public void setTurqCashTransactionRows(java.util.Set turqCashTransactionRows)
	{
		this.turqCashTransactionRows = turqCashTransactionRows;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqCashCard))
			return false;
		TurqCashCard castOther = (TurqCashCard) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}