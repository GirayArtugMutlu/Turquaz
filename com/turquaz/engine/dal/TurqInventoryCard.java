package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqInventoryCard implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private java.lang.String cardInventoryCode;
	/** persistent field */
	private java.lang.String cardName;
	/** persistent field */
	private java.lang.String cardDefinition;
	/** persistent field */
	private int cardMinimumAmount;
	/** persistent field */
	private int cardMaximumAmount;
	/** persistent field */
	private int cardVat;
	/** persistent field */
	private int cardDiscount;
	/** persistent field */
	private int cardSpecialVat;
	/** persistent field */
	private java.math.BigDecimal cardSpecialVatEach;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date updateDate;
	/** persistent field */
	private boolean specVatForEach;
	/** persistent field */
	private Set turqInventoryPrices;
	/** persistent field */
	private Set turqInventoryTransactions;
	/** persistent field */
	private Set turqInventoryAccountingAccounts;
	/** persistent field */
	private Set turqInventoryCardGroups;
	/** persistent field */
	private Set turqInventoryCardUnits;

	/** full constructor */
	public TurqInventoryCard(java.lang.String cardInventoryCode, java.lang.String cardName, java.lang.String cardDefinition,
			int cardMinimumAmount, int cardMaximumAmount, int cardVat, int cardDiscount, int cardSpecialVat,
			java.math.BigDecimal cardSpecialVatEach, java.lang.String createdBy, java.util.Date creationDate,
			java.lang.String updatedBy, java.util.Date updateDate, boolean specVatForEach, Set turqInventoryPrices,
			Set turqInventoryTransactions, Set turqInventoryAccountingAccounts, Set turqInventoryCardGroups, Set turqInventoryCardUnits)
	{
		this.cardInventoryCode = cardInventoryCode;
		this.cardName = cardName;
		this.cardDefinition = cardDefinition;
		this.cardMinimumAmount = cardMinimumAmount;
		this.cardMaximumAmount = cardMaximumAmount;
		this.cardVat = cardVat;
		this.cardDiscount = cardDiscount;
		this.cardSpecialVat = cardSpecialVat;
		this.cardSpecialVatEach = cardSpecialVatEach;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.updateDate = updateDate;
		this.specVatForEach = specVatForEach;
		this.turqInventoryPrices = turqInventoryPrices;
		this.turqInventoryTransactions = turqInventoryTransactions;
		this.turqInventoryAccountingAccounts = turqInventoryAccountingAccounts;
		this.turqInventoryCardGroups = turqInventoryCardGroups;
		this.turqInventoryCardUnits = turqInventoryCardUnits;
	}

	/** default constructor */
	public TurqInventoryCard()
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

	public java.lang.String getCardInventoryCode()
	{
		return this.cardInventoryCode;
	}

	public void setCardInventoryCode(java.lang.String cardInventoryCode)
	{
		this.cardInventoryCode = cardInventoryCode;
	}

	public java.lang.String getCardName()
	{
		return this.cardName;
	}

	public void setCardName(java.lang.String cardName)
	{
		this.cardName = cardName;
	}

	public java.lang.String getCardDefinition()
	{
		return this.cardDefinition;
	}

	public void setCardDefinition(java.lang.String cardDefinition)
	{
		this.cardDefinition = cardDefinition;
	}

	public int getCardMinimumAmount()
	{
		return this.cardMinimumAmount;
	}

	public void setCardMinimumAmount(int cardMinimumAmount)
	{
		this.cardMinimumAmount = cardMinimumAmount;
	}

	public int getCardMaximumAmount()
	{
		return this.cardMaximumAmount;
	}

	public void setCardMaximumAmount(int cardMaximumAmount)
	{
		this.cardMaximumAmount = cardMaximumAmount;
	}

	public int getCardVat()
	{
		return this.cardVat;
	}

	public void setCardVat(int cardVat)
	{
		this.cardVat = cardVat;
	}

	public int getCardDiscount()
	{
		return this.cardDiscount;
	}

	public void setCardDiscount(int cardDiscount)
	{
		this.cardDiscount = cardDiscount;
	}

	public int getCardSpecialVat()
	{
		return this.cardSpecialVat;
	}

	public void setCardSpecialVat(int cardSpecialVat)
	{
		this.cardSpecialVat = cardSpecialVat;
	}

	public java.math.BigDecimal getCardSpecialVatEach()
	{
		return this.cardSpecialVatEach;
	}

	public void setCardSpecialVatEach(java.math.BigDecimal cardSpecialVatEach)
	{
		this.cardSpecialVatEach = cardSpecialVatEach;
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

	public boolean isSpecVatForEach()
	{
		return this.specVatForEach;
	}

	public void setSpecVatForEach(boolean specVatForEach)
	{
		this.specVatForEach = specVatForEach;
	}

	public java.util.Set getTurqInventoryPrices()
	{
		return this.turqInventoryPrices;
	}

	public void setTurqInventoryPrices(java.util.Set turqInventoryPrices)
	{
		this.turqInventoryPrices = turqInventoryPrices;
	}

	public java.util.Set getTurqInventoryTransactions()
	{
		return this.turqInventoryTransactions;
	}

	public void setTurqInventoryTransactions(java.util.Set turqInventoryTransactions)
	{
		this.turqInventoryTransactions = turqInventoryTransactions;
	}

	public java.util.Set getTurqInventoryAccountingAccounts()
	{
		return this.turqInventoryAccountingAccounts;
	}

	public void setTurqInventoryAccountingAccounts(java.util.Set turqInventoryAccountingAccounts)
	{
		this.turqInventoryAccountingAccounts = turqInventoryAccountingAccounts;
	}

	public java.util.Set getTurqInventoryCardGroups()
	{
		return this.turqInventoryCardGroups;
	}

	public void setTurqInventoryCardGroups(java.util.Set turqInventoryCardGroups)
	{
		this.turqInventoryCardGroups = turqInventoryCardGroups;
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
		if (!(other instanceof TurqInventoryCard))
			return false;
		TurqInventoryCard castOther = (TurqInventoryCard) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}