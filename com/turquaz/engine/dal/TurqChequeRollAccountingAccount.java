package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqChequeRollAccountingAccount implements Serializable {

    /** identifier field */
    private java.lang.Integer chequeRollsId;

    /** nullable persistent field */
    private com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount;

    /** full constructor */
    public TurqChequeRollAccountingAccount(java.lang.Integer chequeRollsId, com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.chequeRollsId = chequeRollsId;
        this.turqChequeRoll = turqChequeRoll;
        this.turqAccountingAccount = turqAccountingAccount;
    }

    /** default constructor */
    public TurqChequeRollAccountingAccount() {
    }

    /** minimal constructor */
    public TurqChequeRollAccountingAccount(java.lang.Integer chequeRollsId, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.chequeRollsId = chequeRollsId;
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public java.lang.Integer getChequeRollsId() {
        return this.chequeRollsId;
    }

    public void setChequeRollsId(java.lang.Integer chequeRollsId) {
        this.chequeRollsId = chequeRollsId;
    }

    public com.turquaz.engine.dal.TurqChequeRoll getTurqChequeRoll() {
        return this.turqChequeRoll;
    }

    public void setTurqChequeRoll(com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll) {
        this.turqChequeRoll = turqChequeRoll;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccount() {
        return this.turqAccountingAccount;
    }

    public void setTurqAccountingAccount(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccount) {
        this.turqAccountingAccount = turqAccountingAccount;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("chequeRollsId", getChequeRollsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqChequeRollAccountingAccount) ) return false;
        TurqChequeRollAccountingAccount castOther = (TurqChequeRollAccountingAccount) other;
        return new EqualsBuilder()
            .append(this.getChequeRollsId(), castOther.getChequeRollsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getChequeRollsId())
            .toHashCode();
    }

}
