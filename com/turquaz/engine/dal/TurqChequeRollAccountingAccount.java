package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqChequeRollAccountingAccount implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** nullable persistent field */
	private com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll;
	/** persistent field */
	private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

	/** full constructor */
	public TurqChequeRollAccountingAccount(java.lang.Integer id, com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll,
			com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount)
	{
		this.id = id;
		this.turqChequeRoll = turqChequeRoll;
		this.turqAccountingAccount = turqAccountingAccount;
	}

	/** default constructor */
	public TurqChequeRollAccountingAccount()
	{
	}

	/** minimal constructor */
	public TurqChequeRollAccountingAccount(java.lang.Integer id, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount)
	{
		this.id = id;
		this.turqAccountingAccount = turqAccountingAccount;
	}

	public java.lang.Integer getId()
	{
		return this.id;
	}

	public void setId(java.lang.Integer id)
	{
		this.id = id;
	}

	public com.turquaz.engine.dal.TurqChequeRoll getTurqChequeRoll()
	{
		return this.turqChequeRoll;
	}

	public void setTurqChequeRoll(com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll)
	{
		this.turqChequeRoll = turqChequeRoll;
	}

	public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount()
	{
		return this.turqAccountingAccount;
	}

	public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount)
	{
		this.turqAccountingAccount = turqAccountingAccount;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqChequeRollAccountingAccount))
			return false;
		TurqChequeRollAccountingAccount castOther = (TurqChequeRollAccountingAccount) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}