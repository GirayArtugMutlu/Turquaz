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
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCompany turqCompany;

    /** persistent field */
    private com.turquaz.engine.dal.TurqChequeTransactionType turqChequeTransactionType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksCard turqBanksCard;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private Set turqChequeChequesRolls;

    /** full constructor */
    public TurqChequeRoll(java.lang.Integer chequeRollsId, java.util.Date chequeRollsDate, java.util.Date creationDate, java.util.Date lastModified, java.lang.String createdBy, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCompany turqCompany, com.turquaz.engine.dal.TurqChequeTransactionType turqChequeTransactionType, com.turquaz.engine.dal.TurqBanksCard turqBanksCard, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqChequeChequesRolls) {
        this.chequeRollsId = chequeRollsId;
        this.chequeRollsDate = chequeRollsDate;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.turqCompany = turqCompany;
        this.turqChequeTransactionType = turqChequeTransactionType;
        this.turqBanksCard = turqBanksCard;
        this.turqCurrentCard = turqCurrentCard;
        this.turqChequeChequesRolls = turqChequeChequesRolls;
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

    public java.util.Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(java.util.Date lastModified) {
        this.lastModified = lastModified;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }

    public java.lang.String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(java.lang.String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public com.turquaz.engine.dal.TurqCompany getTurqCompany() {
        return this.turqCompany;
    }

    public void setTurqCompany(com.turquaz.engine.dal.TurqCompany turqCompany) {
        this.turqCompany = turqCompany;
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

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public java.util.Set getTurqChequeChequesRolls() {
        return this.turqChequeChequesRolls;
    }

    public void setTurqChequeChequesRolls(java.util.Set turqChequeChequesRolls) {
        this.turqChequeChequesRolls = turqChequeChequesRolls;
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
