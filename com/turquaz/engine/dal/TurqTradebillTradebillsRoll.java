package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqTradebillTradebillsRoll implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqTradebillTradebill turqTradebillTradebill;

    /** persistent field */
    private com.turquaz.engine.dal.TurqTradebillRoll turqTradebillRoll;

    /** full constructor */
    public TurqTradebillTradebillsRoll(java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqTradebillTradebill turqTradebillTradebill, com.turquaz.engine.dal.TurqTradebillRoll turqTradebillRoll) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqTradebillTradebill = turqTradebillTradebill;
        this.turqTradebillRoll = turqTradebillRoll;
    }

    /** default constructor */
    public TurqTradebillTradebillsRoll() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
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

    public com.turquaz.engine.dal.TurqTradebillTradebill getTurqTradebillTradebill() {
        return this.turqTradebillTradebill;
    }

    public void setTurqTradebillTradebill(com.turquaz.engine.dal.TurqTradebillTradebill turqTradebillTradebill) {
        this.turqTradebillTradebill = turqTradebillTradebill;
    }

    public com.turquaz.engine.dal.TurqTradebillRoll getTurqTradebillRoll() {
        return this.turqTradebillRoll;
    }

    public void setTurqTradebillRoll(com.turquaz.engine.dal.TurqTradebillRoll turqTradebillRoll) {
        this.turqTradebillRoll = turqTradebillRoll;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqTradebillTradebillsRoll) ) return false;
        TurqTradebillTradebillsRoll castOther = (TurqTradebillTradebillsRoll) other;
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
