package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqTradebillRoll implements Serializable {

    /** identifier field */
    private java.lang.Integer tradebillRollsId;

    /** persistent field */
    private java.util.Date tradebillRollsDate;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksCard turqBanksCard;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** persistent field */
    private com.turquaz.engine.dal.TurqTradebillTransactionType turqTradebillTransactionType;

    /** persistent field */
    private Set turqTradebillTradebillsRolls;

    /** full constructor */
    public TurqTradebillRoll(java.util.Date tradebillRollsDate, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqBanksCard turqBanksCard, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, com.turquaz.engine.dal.TurqTradebillTransactionType turqTradebillTransactionType, Set turqTradebillTradebillsRolls) {
        this.tradebillRollsDate = tradebillRollsDate;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqBanksCard = turqBanksCard;
        this.turqCurrentCard = turqCurrentCard;
        this.turqTradebillTransactionType = turqTradebillTransactionType;
        this.turqTradebillTradebillsRolls = turqTradebillTradebillsRolls;
    }

    /** default constructor */
    public TurqTradebillRoll() {
    }

    public java.lang.Integer getTradebillRollsId() {
        return this.tradebillRollsId;
    }

    public void setTradebillRollsId(java.lang.Integer tradebillRollsId) {
        this.tradebillRollsId = tradebillRollsId;
    }

    public java.util.Date getTradebillRollsDate() {
        return this.tradebillRollsDate;
    }

    public void setTradebillRollsDate(java.util.Date tradebillRollsDate) {
        this.tradebillRollsDate = tradebillRollsDate;
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

    public com.turquaz.engine.dal.TurqTradebillTransactionType getTurqTradebillTransactionType() {
        return this.turqTradebillTransactionType;
    }

    public void setTurqTradebillTransactionType(com.turquaz.engine.dal.TurqTradebillTransactionType turqTradebillTransactionType) {
        this.turqTradebillTransactionType = turqTradebillTransactionType;
    }

    public java.util.Set getTurqTradebillTradebillsRolls() {
        return this.turqTradebillTradebillsRolls;
    }

    public void setTurqTradebillTradebillsRolls(java.util.Set turqTradebillTradebillsRolls) {
        this.turqTradebillTradebillsRolls = turqTradebillTradebillsRolls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("tradebillRollsId", getTradebillRollsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqTradebillRoll) ) return false;
        TurqTradebillRoll castOther = (TurqTradebillRoll) other;
        return new EqualsBuilder()
            .append(this.getTradebillRollsId(), castOther.getTradebillRollsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTradebillRollsId())
            .toHashCode();
    }

}
