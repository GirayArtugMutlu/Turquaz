package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqEngineSequence implements Serializable {

    /** identifier field */
    private java.lang.Integer engineSequencesId;

    /** persistent field */
    private Set turqAccountingTransactions;

    /** persistent field */
    private Set turqCurrentTransactions;

    /** persistent field */
    private Set turqBills;

    /** full constructor */
    public TurqEngineSequence(Set turqAccountingTransactions, Set turqCurrentTransactions, Set turqBills) {
        this.turqAccountingTransactions = turqAccountingTransactions;
        this.turqCurrentTransactions = turqCurrentTransactions;
        this.turqBills = turqBills;
    }

    /** default constructor */
    public TurqEngineSequence() {
    }

    public java.lang.Integer getEngineSequencesId() {
        return this.engineSequencesId;
    }

    public void setEngineSequencesId(java.lang.Integer engineSequencesId) {
        this.engineSequencesId = engineSequencesId;
    }

    public java.util.Set getTurqAccountingTransactions() {
        return this.turqAccountingTransactions;
    }

    public void setTurqAccountingTransactions(java.util.Set turqAccountingTransactions) {
        this.turqAccountingTransactions = turqAccountingTransactions;
    }

    public java.util.Set getTurqCurrentTransactions() {
        return this.turqCurrentTransactions;
    }

    public void setTurqCurrentTransactions(java.util.Set turqCurrentTransactions) {
        this.turqCurrentTransactions = turqCurrentTransactions;
    }

    public java.util.Set getTurqBills() {
        return this.turqBills;
    }

    public void setTurqBills(java.util.Set turqBills) {
        this.turqBills = turqBills;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("engineSequencesId", getEngineSequencesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqEngineSequence) ) return false;
        TurqEngineSequence castOther = (TurqEngineSequence) other;
        return new EqualsBuilder()
            .append(this.getEngineSequencesId(), castOther.getEngineSequencesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEngineSequencesId())
            .toHashCode();
    }

}
