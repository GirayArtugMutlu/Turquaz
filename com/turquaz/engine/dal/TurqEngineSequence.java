package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqEngineSequence implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private com.turquaz.engine.dal.TurqModule turqModule;

    /** persistent field */
    private Set turqChequeRolls;

    /** persistent field */
    private Set turqAccountingTransactions;

    /** persistent field */
    private Set turqCashTransactions;

    /** persistent field */
    private Set turqInventoryTransactions;

    /** persistent field */
    private Set turqConsignments;

    /** persistent field */
    private Set turqCurrentTransactions;

    /** persistent field */
    private Set turqBanksTransactionBills;

    /** persistent field */
    private Set turqBillInEngineSequences;

    /** persistent field */
    private Set turqBills;

    /** full constructor */
    public TurqEngineSequence(com.turquaz.engine.dal.TurqModule turqModule, Set turqChequeRolls, Set turqAccountingTransactions, Set turqCashTransactions, Set turqInventoryTransactions, Set turqConsignments, Set turqCurrentTransactions, Set turqBanksTransactionBills, Set turqBillInEngineSequences, Set turqBills) {
        this.turqModule = turqModule;
        this.turqChequeRolls = turqChequeRolls;
        this.turqAccountingTransactions = turqAccountingTransactions;
        this.turqCashTransactions = turqCashTransactions;
        this.turqInventoryTransactions = turqInventoryTransactions;
        this.turqConsignments = turqConsignments;
        this.turqCurrentTransactions = turqCurrentTransactions;
        this.turqBanksTransactionBills = turqBanksTransactionBills;
        this.turqBillInEngineSequences = turqBillInEngineSequences;
        this.turqBills = turqBills;
    }

    /** default constructor */
    public TurqEngineSequence() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public com.turquaz.engine.dal.TurqModule getTurqModule() {
        return this.turqModule;
    }

    public void setTurqModule(com.turquaz.engine.dal.TurqModule turqModule) {
        this.turqModule = turqModule;
    }

    public java.util.Set getTurqChequeRolls() {
        return this.turqChequeRolls;
    }

    public void setTurqChequeRolls(java.util.Set turqChequeRolls) {
        this.turqChequeRolls = turqChequeRolls;
    }

    public java.util.Set getTurqAccountingTransactions() {
        return this.turqAccountingTransactions;
    }

    public void setTurqAccountingTransactions(java.util.Set turqAccountingTransactions) {
        this.turqAccountingTransactions = turqAccountingTransactions;
    }

    public java.util.Set getTurqCashTransactions() {
        return this.turqCashTransactions;
    }

    public void setTurqCashTransactions(java.util.Set turqCashTransactions) {
        this.turqCashTransactions = turqCashTransactions;
    }

    public java.util.Set getTurqInventoryTransactions() {
        return this.turqInventoryTransactions;
    }

    public void setTurqInventoryTransactions(java.util.Set turqInventoryTransactions) {
        this.turqInventoryTransactions = turqInventoryTransactions;
    }

    public java.util.Set getTurqConsignments() {
        return this.turqConsignments;
    }

    public void setTurqConsignments(java.util.Set turqConsignments) {
        this.turqConsignments = turqConsignments;
    }

    public java.util.Set getTurqCurrentTransactions() {
        return this.turqCurrentTransactions;
    }

    public void setTurqCurrentTransactions(java.util.Set turqCurrentTransactions) {
        this.turqCurrentTransactions = turqCurrentTransactions;
    }

    public java.util.Set getTurqBanksTransactionBills() {
        return this.turqBanksTransactionBills;
    }

    public void setTurqBanksTransactionBills(java.util.Set turqBanksTransactionBills) {
        this.turqBanksTransactionBills = turqBanksTransactionBills;
    }

    public java.util.Set getTurqBillInEngineSequences() {
        return this.turqBillInEngineSequences;
    }

    public void setTurqBillInEngineSequences(java.util.Set turqBillInEngineSequences) {
        this.turqBillInEngineSequences = turqBillInEngineSequences;
    }

    public java.util.Set getTurqBills() {
        return this.turqBills;
    }

    public void setTurqBills(java.util.Set turqBills) {
        this.turqBills = turqBills;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqEngineSequence) ) return false;
        TurqEngineSequence castOther = (TurqEngineSequence) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
