package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewChequeStatus implements Serializable
{
	/** identifier field */
	private int chequeChequesId;
	/** identifier field */
	private java.lang.String chequesPortfolioNo;
	/** identifier field */
	private java.lang.String chequesNo;
	/** identifier field */
	private int banksId;
	/** identifier field */
	private java.util.Date chequesDueDate;
	/** identifier field */
	private java.lang.String chequesDebtor;
	/** identifier field */
	private java.lang.String chequesPaymentPlace;
	/** identifier field */
	private java.util.Date chequesValueDate;
	/** identifier field */
	private java.math.BigDecimal chequesAmount;
	/** identifier field */
	private int currenciesId;
	/** identifier field */
	private int chequeTransactionTypesId;
	/** identifier field */
	private java.lang.String transactionTypsName;
	/** identifier field */
	private short transactionTypesParent;
	/** identifier field */
	private int chequeRollsId;
	/** identifier field */
	private java.util.Date chequeRollsDate;
	/** identifier field */
	private int engineSequencesId;
	/** identifier field */
	private java.lang.String chequeRollNo;
	/** identifier field */
	private int currentCardsId;
	/** identifier field */
	private int banksCardsId;

	/** full constructor */
	public TurqViewChequeStatus(int chequeChequesId, java.lang.String chequesPortfolioNo, java.lang.String chequesNo, int banksId,
			java.util.Date chequesDueDate, java.lang.String chequesDebtor, java.lang.String chequesPaymentPlace,
			java.util.Date chequesValueDate, java.math.BigDecimal chequesAmount, int currenciesId, int chequeTransactionTypesId,
			java.lang.String transactionTypsName, short transactionTypesParent, int chequeRollsId, java.util.Date chequeRollsDate,
			int engineSequencesId, java.lang.String chequeRollNo, int currentCardsId, int banksCardsId)
	{
		this.chequeChequesId = chequeChequesId;
		this.chequesPortfolioNo = chequesPortfolioNo;
		this.chequesNo = chequesNo;
		this.banksId = banksId;
		this.chequesDueDate = chequesDueDate;
		this.chequesDebtor = chequesDebtor;
		this.chequesPaymentPlace = chequesPaymentPlace;
		this.chequesValueDate = chequesValueDate;
		this.chequesAmount = chequesAmount;
		this.currenciesId = currenciesId;
		this.chequeTransactionTypesId = chequeTransactionTypesId;
		this.transactionTypsName = transactionTypsName;
		this.transactionTypesParent = transactionTypesParent;
		this.chequeRollsId = chequeRollsId;
		this.chequeRollsDate = chequeRollsDate;
		this.engineSequencesId = engineSequencesId;
		this.chequeRollNo = chequeRollNo;
		this.currentCardsId = currentCardsId;
		this.banksCardsId = banksCardsId;
	}

	/** default constructor */
	public TurqViewChequeStatus()
	{
	}

	public int getChequeChequesId()
	{
		return this.chequeChequesId;
	}

	public void setChequeChequesId(int chequeChequesId)
	{
		this.chequeChequesId = chequeChequesId;
	}

	public java.lang.String getChequesPortfolioNo()
	{
		return this.chequesPortfolioNo;
	}

	public void setChequesPortfolioNo(java.lang.String chequesPortfolioNo)
	{
		this.chequesPortfolioNo = chequesPortfolioNo;
	}

	public java.lang.String getChequesNo()
	{
		return this.chequesNo;
	}

	public void setChequesNo(java.lang.String chequesNo)
	{
		this.chequesNo = chequesNo;
	}

	public int getBanksId()
	{
		return this.banksId;
	}

	public void setBanksId(int banksId)
	{
		this.banksId = banksId;
	}

	public java.util.Date getChequesDueDate()
	{
		return this.chequesDueDate;
	}

	public void setChequesDueDate(java.util.Date chequesDueDate)
	{
		this.chequesDueDate = chequesDueDate;
	}

	public java.lang.String getChequesDebtor()
	{
		return this.chequesDebtor;
	}

	public void setChequesDebtor(java.lang.String chequesDebtor)
	{
		this.chequesDebtor = chequesDebtor;
	}

	public java.lang.String getChequesPaymentPlace()
	{
		return this.chequesPaymentPlace;
	}

	public void setChequesPaymentPlace(java.lang.String chequesPaymentPlace)
	{
		this.chequesPaymentPlace = chequesPaymentPlace;
	}

	public java.util.Date getChequesValueDate()
	{
		return this.chequesValueDate;
	}

	public void setChequesValueDate(java.util.Date chequesValueDate)
	{
		this.chequesValueDate = chequesValueDate;
	}

	public java.math.BigDecimal getChequesAmount()
	{
		return this.chequesAmount;
	}

	public void setChequesAmount(java.math.BigDecimal chequesAmount)
	{
		this.chequesAmount = chequesAmount;
	}

	public int getCurrenciesId()
	{
		return this.currenciesId;
	}

	public void setCurrenciesId(int currenciesId)
	{
		this.currenciesId = currenciesId;
	}

	public int getChequeTransactionTypesId()
	{
		return this.chequeTransactionTypesId;
	}

	public void setChequeTransactionTypesId(int chequeTransactionTypesId)
	{
		this.chequeTransactionTypesId = chequeTransactionTypesId;
	}

	public java.lang.String getTransactionTypsName()
	{
		return this.transactionTypsName;
	}

	public void setTransactionTypsName(java.lang.String transactionTypsName)
	{
		this.transactionTypsName = transactionTypsName;
	}

	public short getTransactionTypesParent()
	{
		return this.transactionTypesParent;
	}

	public void setTransactionTypesParent(short transactionTypesParent)
	{
		this.transactionTypesParent = transactionTypesParent;
	}

	public int getChequeRollsId()
	{
		return this.chequeRollsId;
	}

	public void setChequeRollsId(int chequeRollsId)
	{
		this.chequeRollsId = chequeRollsId;
	}

	public java.util.Date getChequeRollsDate()
	{
		return this.chequeRollsDate;
	}

	public void setChequeRollsDate(java.util.Date chequeRollsDate)
	{
		this.chequeRollsDate = chequeRollsDate;
	}

	public int getEngineSequencesId()
	{
		return this.engineSequencesId;
	}

	public void setEngineSequencesId(int engineSequencesId)
	{
		this.engineSequencesId = engineSequencesId;
	}

	public java.lang.String getChequeRollNo()
	{
		return this.chequeRollNo;
	}

	public void setChequeRollNo(java.lang.String chequeRollNo)
	{
		this.chequeRollNo = chequeRollNo;
	}

	public int getCurrentCardsId()
	{
		return this.currentCardsId;
	}

	public void setCurrentCardsId(int currentCardsId)
	{
		this.currentCardsId = currentCardsId;
	}

	public int getBanksCardsId()
	{
		return this.banksCardsId;
	}

	public void setBanksCardsId(int banksCardsId)
	{
		this.banksCardsId = banksCardsId;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("chequeChequesId", getChequeChequesId()).append("chequesPortfolioNo",
				getChequesPortfolioNo()).append("chequesNo", getChequesNo()).append("banksId", getBanksId()).append("chequesDueDate",
				getChequesDueDate()).append("chequesDebtor", getChequesDebtor())
				.append("chequesPaymentPlace", getChequesPaymentPlace()).append("chequesValueDate", getChequesValueDate()).append(
						"chequesAmount", getChequesAmount()).append("currenciesId", getCurrenciesId()).append(
						"chequeTransactionTypesId", getChequeTransactionTypesId()).append("transactionTypsName",
						getTransactionTypsName()).append("transactionTypesParent", getTransactionTypesParent()).append(
						"chequeRollsId", getChequeRollsId()).append("chequeRollsDate", getChequeRollsDate()).append(
						"engineSequencesId", getEngineSequencesId()).append("chequeRollNo", getChequeRollNo()).append(
						"currentCardsId", getCurrentCardsId()).append("banksCardsId", getBanksCardsId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqViewChequeStatus))
			return false;
		TurqViewChequeStatus castOther = (TurqViewChequeStatus) other;
		return new EqualsBuilder().append(this.getChequeChequesId(), castOther.getChequeChequesId()).append(this.getChequesPortfolioNo(),
				castOther.getChequesPortfolioNo()).append(this.getChequesNo(), castOther.getChequesNo()).append(this.getBanksId(),
				castOther.getBanksId()).append(this.getChequesDueDate(), castOther.getChequesDueDate()).append(this.getChequesDebtor(),
				castOther.getChequesDebtor()).append(this.getChequesPaymentPlace(), castOther.getChequesPaymentPlace()).append(
				this.getChequesValueDate(), castOther.getChequesValueDate()).append(this.getChequesAmount(),
				castOther.getChequesAmount()).append(this.getCurrenciesId(), castOther.getCurrenciesId()).append(
				this.getChequeTransactionTypesId(), castOther.getChequeTransactionTypesId()).append(this.getTransactionTypsName(),
				castOther.getTransactionTypsName()).append(this.getTransactionTypesParent(), castOther.getTransactionTypesParent())
				.append(this.getChequeRollsId(), castOther.getChequeRollsId()).append(this.getChequeRollsDate(),
						castOther.getChequeRollsDate()).append(this.getEngineSequencesId(), castOther.getEngineSequencesId()).append(
						this.getChequeRollNo(), castOther.getChequeRollNo()).append(this.getCurrentCardsId(),
						castOther.getCurrentCardsId()).append(this.getBanksCardsId(), castOther.getBanksCardsId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getChequeChequesId()).append(getChequesPortfolioNo()).append(getChequesNo()).append(
				getBanksId()).append(getChequesDueDate()).append(getChequesDebtor()).append(getChequesPaymentPlace()).append(
				getChequesValueDate()).append(getChequesAmount()).append(getCurrenciesId()).append(getChequeTransactionTypesId())
				.append(getTransactionTypsName()).append(getTransactionTypesParent()).append(getChequeRollsId()).append(
						getChequeRollsDate()).append(getEngineSequencesId()).append(getChequeRollNo()).append(getCurrentCardsId())
				.append(getBanksCardsId()).toHashCode();
	}
}