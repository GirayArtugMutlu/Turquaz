package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqChequeChequesRoll implements Serializable {

    /** identifier field */
    private java.lang.Integer chequeChequesRollsId;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll;

    /** persistent field */
    private com.turquaz.engine.dal.TurqChequeCheque turqChequeCheque;

    /** full constructor */
    public TurqChequeChequesRoll(java.lang.Integer chequeChequesRollsId, java.util.Date creationDate, java.util.Date lastModified, java.lang.String createdBy, java.lang.String updatedBy, com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll, com.turquaz.engine.dal.TurqChequeCheque turqChequeCheque) {
        this.chequeChequesRollsId = chequeChequesRollsId;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.turqChequeRoll = turqChequeRoll;
        this.turqChequeCheque = turqChequeCheque;
    }

    /** default constructor */
    public TurqChequeChequesRoll() {
    }

    public java.lang.Integer getChequeChequesRollsId() {
        return this.chequeChequesRollsId;
    }

    public void setChequeChequesRollsId(java.lang.Integer chequeChequesRollsId) {
        this.chequeChequesRollsId = chequeChequesRollsId;
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

    public com.turquaz.engine.dal.TurqChequeRoll getTurqChequeRoll() {
        return this.turqChequeRoll;
    }

    public void setTurqChequeRoll(com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll) {
        this.turqChequeRoll = turqChequeRoll;
    }

    public com.turquaz.engine.dal.TurqChequeCheque getTurqChequeCheque() {
        return this.turqChequeCheque;
    }

    public void setTurqChequeCheque(com.turquaz.engine.dal.TurqChequeCheque turqChequeCheque) {
        this.turqChequeCheque = turqChequeCheque;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("chequeChequesRollsId", getChequeChequesRollsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqChequeChequesRoll) ) return false;
        TurqChequeChequesRoll castOther = (TurqChequeChequesRoll) other;
        return new EqualsBuilder()
            .append(this.getChequeChequesRollsId(), castOther.getChequeChequesRollsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getChequeChequesRollsId())
            .toHashCode();
    }

}
