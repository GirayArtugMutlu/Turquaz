package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqChequeCheque implements Serializable {

    /** identifier field */
    private java.lang.Integer chequeChequesId;

    /** persistent field */
    private java.lang.String chequesPortfolioNo;

    /** persistent field */
    private java.lang.String chequesNo;

    /** persistent field */
    private java.util.Date chequesDueDate;

    /** persistent field */
    private java.lang.String chequesDebtor;

    /** nullable persistent field */
    private java.lang.String chequesPaymentPlace;

    /** persistent field */
    private java.util.Date chequesValueDate;

    /** persistent field */
    private java.math.BigDecimal chequesAmount;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String bankName;

    /** persistent field */
    private java.lang.String bankBranchName;

    /** nullable persistent field */
    private int chequesType;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrency turqCurrency;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBanksCard turqBanksCard;

    /** persistent field */
    private Set turqChequeChequeInRolls;

    /** full constructor */
    public TurqChequeCheque(java.lang.String chequesPortfolioNo, java.lang.String chequesNo, java.util.Date chequesDueDate, java.lang.String chequesDebtor, java.lang.String chequesPaymentPlace, java.util.Date chequesValueDate, java.math.BigDecimal chequesAmount, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.lang.String bankName, java.lang.String bankBranchName, int chequesType, com.turquaz.engine.dal.TurqCurrency turqCurrency, com.turquaz.engine.dal.TurqBanksCard turqBanksCard, Set turqChequeChequeInRolls) {
        this.chequesPortfolioNo = chequesPortfolioNo;
        this.chequesNo = chequesNo;
        this.chequesDueDate = chequesDueDate;
        this.chequesDebtor = chequesDebtor;
        this.chequesPaymentPlace = chequesPaymentPlace;
        this.chequesValueDate = chequesValueDate;
        this.chequesAmount = chequesAmount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.bankName = bankName;
        this.bankBranchName = bankBranchName;
        this.chequesType = chequesType;
        this.turqCurrency = turqCurrency;
        this.turqBanksCard = turqBanksCard;
        this.turqChequeChequeInRolls = turqChequeChequeInRolls;
    }

    /** default constructor */
    public TurqChequeCheque() {
    }

    /** minimal constructor */
    public TurqChequeCheque(java.lang.String chequesPortfolioNo, java.lang.String chequesNo, java.util.Date chequesDueDate, java.lang.String chequesDebtor, java.util.Date chequesValueDate, java.math.BigDecimal chequesAmount, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, java.lang.String bankName, java.lang.String bankBranchName, com.turquaz.engine.dal.TurqCurrency turqCurrency, com.turquaz.engine.dal.TurqBanksCard turqBanksCard, Set turqChequeChequeInRolls) {
        this.chequesPortfolioNo = chequesPortfolioNo;
        this.chequesNo = chequesNo;
        this.chequesDueDate = chequesDueDate;
        this.chequesDebtor = chequesDebtor;
        this.chequesValueDate = chequesValueDate;
        this.chequesAmount = chequesAmount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.bankName = bankName;
        this.bankBranchName = bankBranchName;
        this.turqCurrency = turqCurrency;
        this.turqBanksCard = turqBanksCard;
        this.turqChequeChequeInRolls = turqChequeChequeInRolls;
    }

    public java.lang.Integer getChequeChequesId() {
        return this.chequeChequesId;
    }

    public void setChequeChequesId(java.lang.Integer chequeChequesId) {
        this.chequeChequesId = chequeChequesId;
    }

    public java.lang.String getChequesPortfolioNo() {
        return this.chequesPortfolioNo;
    }

    public void setChequesPortfolioNo(java.lang.String chequesPortfolioNo) {
        this.chequesPortfolioNo = chequesPortfolioNo;
    }

    public java.lang.String getChequesNo() {
        return this.chequesNo;
    }

    public void setChequesNo(java.lang.String chequesNo) {
        this.chequesNo = chequesNo;
    }

    public java.util.Date getChequesDueDate() {
        return this.chequesDueDate;
    }

    public void setChequesDueDate(java.util.Date chequesDueDate) {
        this.chequesDueDate = chequesDueDate;
    }

    public java.lang.String getChequesDebtor() {
        return this.chequesDebtor;
    }

    public void setChequesDebtor(java.lang.String chequesDebtor) {
        this.chequesDebtor = chequesDebtor;
    }

    public java.lang.String getChequesPaymentPlace() {
        return this.chequesPaymentPlace;
    }

    public void setChequesPaymentPlace(java.lang.String chequesPaymentPlace) {
        this.chequesPaymentPlace = chequesPaymentPlace;
    }

    public java.util.Date getChequesValueDate() {
        return this.chequesValueDate;
    }

    public void setChequesValueDate(java.util.Date chequesValueDate) {
        this.chequesValueDate = chequesValueDate;
    }

    public java.math.BigDecimal getChequesAmount() {
        return this.chequesAmount;
    }

    public void setChequesAmount(java.math.BigDecimal chequesAmount) {
        this.chequesAmount = chequesAmount;
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

    public java.lang.String getBankName() {
        return this.bankName;
    }

    public void setBankName(java.lang.String bankName) {
        this.bankName = bankName;
    }

    public java.lang.String getBankBranchName() {
        return this.bankBranchName;
    }

    public void setBankBranchName(java.lang.String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public int getChequesType() {
        return this.chequesType;
    }

    public void setChequesType(int chequesType) {
        this.chequesType = chequesType;
    }

    public com.turquaz.engine.dal.TurqCurrency getTurqCurrency() {
        return this.turqCurrency;
    }

    public void setTurqCurrency(com.turquaz.engine.dal.TurqCurrency turqCurrency) {
        this.turqCurrency = turqCurrency;
    }

    public com.turquaz.engine.dal.TurqBanksCard getTurqBanksCard() {
        return this.turqBanksCard;
    }

    public void setTurqBanksCard(com.turquaz.engine.dal.TurqBanksCard turqBanksCard) {
        this.turqBanksCard = turqBanksCard;
    }

    public java.util.Set getTurqChequeChequeInRolls() {
        return this.turqChequeChequeInRolls;
    }

    public void setTurqChequeChequeInRolls(java.util.Set turqChequeChequeInRolls) {
        this.turqChequeChequeInRolls = turqChequeChequeInRolls;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("chequeChequesId", getChequeChequesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqChequeCheque) ) return false;
        TurqChequeCheque castOther = (TurqChequeCheque) other;
        return new EqualsBuilder()
            .append(this.getChequeChequesId(), castOther.getChequeChequesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getChequeChequesId())
            .toHashCode();
    }

}
