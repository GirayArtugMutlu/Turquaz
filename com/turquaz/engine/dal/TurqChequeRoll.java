package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqChequeRoll implements Serializable {

    /** identifier field */
    private java.lang.Integer chequeRollsId;

    /** persistent field */
    private java.util.Date chequeRollsDate;

    /** persistent field */
    private java.lang.String chequeRollNo;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqChequeTransactionType turqChequeTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksCard turqBanksCard;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqChequeChequeInRolls;

    /** full constructor */
    public TurqChequeRoll(java.util.Date chequeRollsDate, java.lang.String chequeRollNo, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqChequeTransactionType turqChequeTransactionType, com.turquaz.engine.dal.TurqBanksCard turqBanksCard, com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqChequeChequeInRolls) {
        this.chequeRollsDate = chequeRollsDate;
        this.chequeRollNo = chequeRollNo;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqChequeTransactionType = turqChequeTransactionType;
        this.turqBanksCard = turqBanksCard;
        this.turqEngineSequence = turqEngineSequence;
        this.turqCurrentCard = turqCurrentCard;
        this.turqChequeChequeInRolls = turqChequeChequeInRolls;
    }

    /** default constructor */
    public TurqChequeRoll() {
    }

    public java.lang.Integer getChequeRollsId() {
        return this.chequeRollsId;
    }

    public void setChequeRollsId(java.lang.Integer chequeRollsId) {
        this.chequeRollsId = chequeRollsId;
    }

    public java.util.Date getChequeRollsDate() {
        return this.chequeRollsDate;
    }

    public void setChequeRollsDate(java.util.Date chequeRollsDate) {
        this.chequeRollsDate = chequeRollsDate;
    }

    public java.lang.String getChequeRollNo() {
        return this.chequeRollNo;
    }

    public void setChequeRollNo(java.lang.String chequeRollNo) {
        this.chequeRollNo = chequeRollNo;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public java.lang.String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(java.lang.String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public com.turquaz.engine.dal.TurqChequeTransactionType getTurqChequeTransactionType() {
        return this.turqChequeTransactionType;
    }

    public void setTurqChequeTransactionType(com.turquaz.engine.dal.TurqChequeTransactionType turqChequeTransactionType) {
        this.turqChequeTransactionType = turqChequeTransactionType;
    }

    public com.turquaz.engine.dal.TurqBanksCard getTurqBanksCard() {
        return this.turqBanksCard;
    }

    public void setTurqBanksCard(com.turquaz.engine.dal.TurqBanksCard turqBanksCard) {
        this.turqBanksCard = turqBanksCard;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public java.util.Set getTurqChequeChequeInRolls() {
        return this.turqChequeChequeInRolls;
    }

    public void setTurqChequeChequeInRolls(java.util.Set turqChequeChequeInRolls) {
        this.turqChequeChequeInRolls = turqChequeChequeInRolls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("chequeRollsId", getChequeRollsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqChequeRoll) ) return false;
        TurqChequeRoll castOther = (TurqChequeRoll) other;
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
