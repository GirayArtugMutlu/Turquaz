package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqBillInEngineSequence implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence;

    /** persistent field */
    private com.turquaz.engine.dal.TurqBill turqBill;

    /** full constructor */
    public TurqBillInEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence, com.turquaz.engine.dal.TurqBill turqBill) {
        this.turqEngineSequence = turqEngineSequence;
        this.turqBill = turqBill;
    }

    /** default constructor */
    public TurqBillInEngineSequence() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public com.turquaz.engine.dal.TurqEngineSequence getTurqEngineSequence() {
        return this.turqEngineSequence;
    }

    public void setTurqEngineSequence(com.turquaz.engine.dal.TurqEngineSequence turqEngineSequence) {
        this.turqEngineSequence = turqEngineSequence;
    }

    public com.turquaz.engine.dal.TurqBill getTurqBill() {
        return this.turqBill;
    }

    public void setTurqBill(com.turquaz.engine.dal.TurqBill turqBill) {
        this.turqBill = turqBill;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqBillInEngineSequence) ) return false;
        TurqBillInEngineSequence castOther = (TurqBillInEngineSequence) other;
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
