package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingJournal implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingJournalId;

    /** persistent field */
    private java.util.Date journalDate;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private Set turqAccountingTransactions;

    /** full constructor */
    public TurqAccountingJournal(java.util.Date journalDate, java.util.Date creationDate, java.lang.String createdBy, java.util.Date lastModified, java.lang.String updatedBy, Set turqAccountingTransactions) {
        this.journalDate = journalDate;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.updatedBy = updatedBy;
        this.turqAccountingTransactions = turqAccountingTransactions;
    }

    /** default constructor */
    public TurqAccountingJournal() {
    }

    public java.lang.Integer getAccountingJournalId() {
        return this.accountingJournalId;
    }

    public void setAccountingJournalId(java.lang.Integer accountingJournalId) {
        this.accountingJournalId = accountingJournalId;
    }

    public java.util.Date getJournalDate() {
        return this.journalDate;
    }

    public void setJournalDate(java.util.Date journalDate) {
        this.journalDate = journalDate;
    }

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public java.lang.String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(java.lang.String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public java.util.Set getTurqAccountingTransactions() {
        return this.turqAccountingTransactions;
    }

    public void setTurqAccountingTransactions(java.util.Set turqAccountingTransactions) {
        this.turqAccountingTransactions = turqAccountingTransactions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("accountingJournalId", getAccountingJournalId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingJournal) ) return false;
        TurqAccountingJournal castOther = (TurqAccountingJournal) other;
        return new EqualsBuilder()
            .append(this.getAccountingJournalId(), castOther.getAccountingJournalId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccountingJournalId())
            .toHashCode();
    }

}
