package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqViewJoinTransTranscol implements Serializable
{
	/** identifier field */
	private java.math.BigDecimal deptAmount;
	/** identifier field */
	private java.math.BigDecimal creditAmount;
	/** identifier field */
	private int accountingAccountsId;
	/** identifier field */
	private int accountingTransactionColumnsId;
	/** identifier field */
	private int accountingTransactionsId;
	/** identifier field */
	private int accountingJournalId;
	/** identifier field */
	private int accountingTransactionTypesId;
	/** identifier field */
	private java.util.Date transactionsDate;
	/** identifier field */
	private int moduleId;
	/** identifier field */
	private java.lang.String transactionDocumentNo;
	/** identifier field */
	private int engineSequencesId;
	/** identifier field */
	private java.lang.String transactionDescription;
	/** identifier field */
	private java.lang.String createdBy;
	/** identifier field */
	private java.util.Date creationDate;
	/** identifier field */
	private java.lang.String updatedBy;
	/** identifier field */
	private java.util.Date lastModified;

	/** full constructor */
	public TurqViewJoinTransTranscol(java.math.BigDecimal deptAmount, java.math.BigDecimal creditAmount, int accountingAccountsId,
			int accountingTransactionColumnsId, int accountingTransactionsId, int accountingJournalId, int accountingTransactionTypesId,
			java.util.Date transactionsDate, int moduleId, java.lang.String transactionDocumentNo, int engineSequencesId,
			java.lang.String transactionDescription, java.lang.String createdBy, java.util.Date creationDate,
			java.lang.String updatedBy, java.util.Date lastModified)
	{
		this.deptAmount = deptAmount;
		this.creditAmount = creditAmount;
		this.accountingAccountsId = accountingAccountsId;
		this.accountingTransactionColumnsId = accountingTransactionColumnsId;
		this.accountingTransactionsId = accountingTransactionsId;
		this.accountingJournalId = accountingJournalId;
		this.accountingTransactionTypesId = accountingTransactionTypesId;
		this.transactionsDate = transactionsDate;
		this.moduleId = moduleId;
		this.transactionDocumentNo = transactionDocumentNo;
		this.engineSequencesId = engineSequencesId;
		this.transactionDescription = transactionDescription;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.lastModified = lastModified;
	}

	/** default constructor */
	public TurqViewJoinTransTranscol()
	{
	}

	public java.math.BigDecimal getDeptAmount()
	{
		return this.deptAmount;
	}

	public void setDeptAmount(java.math.BigDecimal deptAmount)
	{
		this.deptAmount = deptAmount;
	}

	public java.math.BigDecimal getCreditAmount()
	{
		return this.creditAmount;
	}

	public void setCreditAmount(java.math.BigDecimal creditAmount)
	{
		this.creditAmount = creditAmount;
	}

	public int getAccountingAccountsId()
	{
		return this.accountingAccountsId;
	}

	public void setAccountingAccountsId(int accountingAccountsId)
	{
		this.accountingAccountsId = accountingAccountsId;
	}

	public int getAccountingTransactionColumnsId()
	{
		return this.accountingTransactionColumnsId;
	}

	public void setAccountingTransactionColumnsId(int accountingTransactionColumnsId)
	{
		this.accountingTransactionColumnsId = accountingTransactionColumnsId;
	}

	public int getAccountingTransactionsId()
	{
		return this.accountingTransactionsId;
	}

	public void setAccountingTransactionsId(int accountingTransactionsId)
	{
		this.accountingTransactionsId = accountingTransactionsId;
	}

	public int getAccountingJournalId()
	{
		return this.accountingJournalId;
	}

	public void setAccountingJournalId(int accountingJournalId)
	{
		this.accountingJournalId = accountingJournalId;
	}

	public int getAccountingTransactionTypesId()
	{
		return this.accountingTransactionTypesId;
	}

	public void setAccountingTransactionTypesId(int accountingTransactionTypesId)
	{
		this.accountingTransactionTypesId = accountingTransactionTypesId;
	}

	public java.util.Date getTransactionsDate()
	{
		return this.transactionsDate;
	}

	public void setTransactionsDate(java.util.Date transactionsDate)
	{
		this.transactionsDate = transactionsDate;
	}

	public int getModuleId()
	{
		return this.moduleId;
	}

	public void setModuleId(int moduleId)
	{
		this.moduleId = moduleId;
	}

	public java.lang.String getTransactionDocumentNo()
	{
		return this.transactionDocumentNo;
	}

	public void setTransactionDocumentNo(java.lang.String transactionDocumentNo)
	{
		this.transactionDocumentNo = transactionDocumentNo;
	}

	public int getEngineSequencesId()
	{
		return this.engineSequencesId;
	}

	public void setEngineSequencesId(int engineSequencesId)
	{
		this.engineSequencesId = engineSequencesId;
	}

	public java.lang.String getTransactionDescription()
	{
		return this.transactionDescription;
	}

	public void setTransactionDescription(java.lang.String transactionDescription)
	{
		this.transactionDescription = transactionDescription;
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

	public String toString()
	{
		return new ToStringBuilder(this).append("deptAmount", getDeptAmount()).append("creditAmount", getCreditAmount()).append(
				"accountingAccountsId", getAccountingAccountsId()).append("accountingTransactionColumnsId",
				getAccountingTransactionColumnsId()).append("accountingTransactionsId", getAccountingTransactionsId()).append(
				"accountingJournalId", getAccountingJournalId()).append("accountingTransactionTypesId",
				getAccountingTransactionTypesId()).append("transactionsDate", getTransactionsDate()).append("moduleId", getModuleId())
				.append("transactionDocumentNo", getTransactionDocumentNo()).append("engineSequencesId", getEngineSequencesId())
				.append("transactionDescription", getTransactionDescription()).append("createdBy", getCreatedBy()).append(
						"creationDate", getCreationDate()).append("updatedBy", getUpdatedBy()).append("lastModified",
						getLastModified()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqViewJoinTransTranscol))
			return false;
		TurqViewJoinTransTranscol castOther = (TurqViewJoinTransTranscol) other;
		return new EqualsBuilder().append(this.getDeptAmount(), castOther.getDeptAmount()).append(this.getCreditAmount(),
				castOther.getCreditAmount()).append(this.getAccountingAccountsId(), castOther.getAccountingAccountsId()).append(
				this.getAccountingTransactionColumnsId(), castOther.getAccountingTransactionColumnsId()).append(
				this.getAccountingTransactionsId(), castOther.getAccountingTransactionsId()).append(this.getAccountingJournalId(),
				castOther.getAccountingJournalId()).append(this.getAccountingTransactionTypesId(),
				castOther.getAccountingTransactionTypesId()).append(this.getTransactionsDate(), castOther.getTransactionsDate())
				.append(this.getModuleId(), castOther.getModuleId()).append(this.getTransactionDocumentNo(),
						castOther.getTransactionDocumentNo()).append(this.getEngineSequencesId(), castOther.getEngineSequencesId())
				.append(this.getTransactionDescription(), castOther.getTransactionDescription()).append(this.getCreatedBy(),
						castOther.getCreatedBy()).append(this.getCreationDate(), castOther.getCreationDate()).append(
						this.getUpdatedBy(), castOther.getUpdatedBy()).append(this.getLastModified(), castOther.getLastModified())
				.isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getDeptAmount()).append(getCreditAmount()).append(getAccountingAccountsId()).append(
				getAccountingTransactionColumnsId()).append(getAccountingTransactionsId()).append(getAccountingJournalId()).append(
				getAccountingTransactionTypesId()).append(getTransactionsDate()).append(getModuleId()).append(
				getTransactionDocumentNo()).append(getEngineSequencesId()).append(getTransactionDescription()).append(getCreatedBy())
				.append(getCreationDate()).append(getUpdatedBy()).append(getLastModified()).toHashCode();
	}
}