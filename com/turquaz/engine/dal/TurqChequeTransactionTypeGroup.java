package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqChequeTransactionTypeGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** nullable persistent field */
    private java.lang.String groupName;

    /** nullable persistent field */
    private java.lang.String definition;

    /** persistent field */
    private Set turqChequeTransactionTypes;

    /** full constructor */
    public TurqChequeTransactionTypeGroup(java.lang.String groupName, java.lang.String definition, Set turqChequeTransactionTypes) {
        this.groupName = groupName;
        this.definition = definition;
        this.turqChequeTransactionTypes = turqChequeTransactionTypes;
    }

    /** default constructor */
    public TurqChequeTransactionTypeGroup() {
    }

    /** minimal constructor */
    public TurqChequeTransactionTypeGroup(Set turqChequeTransactionTypes) {
        this.turqChequeTransactionTypes = turqChequeTransactionTypes;
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(java.lang.String groupName) {
        this.groupName = groupName;
    }

    public java.lang.String getDefinition() {
        return this.definition;
    }

    public void setDefinition(java.lang.String definition) {
        this.definition = definition;
    }

    public java.util.Set getTurqChequeTransactionTypes() {
        return this.turqChequeTransactionTypes;
    }

    public void setTurqChequeTransactionTypes(java.util.Set turqChequeTransactionTypes) {
        this.turqChequeTransactionTypes = turqChequeTransactionTypes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqChequeTransactionTypeGroup) ) return false;
        TurqChequeTransactionTypeGroup castOther = (TurqChequeTransactionTypeGroup) other;
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
