package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqChequeChequeInRoll implements Serializable {

    /** identifier field */
    private java.lang.Integer chequeChequesRollsId;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll;

    /** persistent field */
    private com.turquaz.engine.dal.TurqChequeCheque turqChequeCheque;

    /** full constructor */
    public TurqChequeChequeInRoll(java.lang.Integer chequeChequesRollsId, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqChequeRoll turqChequeRoll, com.turquaz.engine.dal.TurqChequeCheque turqChequeCheque) {
        this.chequeChequesRollsId = chequeChequesRollsId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqChequeRoll = turqChequeRoll;
        this.turqChequeCheque = turqChequeCheque;
    }

    /** default constructor */
    public TurqChequeChequeInRoll() {
    }

    public java.lang.Integer getChequeChequesRollsId() {
        return this.chequeChequesRollsId;
    }

    public void setChequeChequesRollsId(java.lang.Integer chequeChequesRollsId) {
        this.chequeChequesRollsId = chequeChequesRollsId;
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
        if ( !(other instanceof TurqChequeChequeInRoll) ) return false;
        TurqChequeChequeInRoll castOther = (TurqChequeChequeInRoll) other;
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
