package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentCardsGroup implements Serializable {

    /** identifier field */
    private java.lang.Integer currentCardsGroupsId;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentGroup turqCurrentGroup;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** full constructor */
    public TurqCurrentCardsGroup(java.lang.Integer currentCardsGroupsId, java.util.Date creationDate, java.util.Date lastModified, java.lang.String createdBy, java.lang.String updatedBy, com.turquaz.engine.dal.TurqCurrentGroup turqCurrentGroup, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.currentCardsGroupsId = currentCardsGroupsId;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.turqCurrentGroup = turqCurrentGroup;
        this.turqCurrentCard = turqCurrentCard;
    }

    /** default constructor */
    public TurqCurrentCardsGroup() {
    }

    public java.lang.Integer getCurrentCardsGroupsId() {
        return this.currentCardsGroupsId;
    }

    public void setCurrentCardsGroupsId(java.lang.Integer currentCardsGroupsId) {
        this.currentCardsGroupsId = currentCardsGroupsId;
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

    public com.turquaz.engine.dal.TurqCurrentGroup getTurqCurrentGroup() {
        return this.turqCurrentGroup;
    }

    public void setTurqCurrentGroup(com.turquaz.engine.dal.TurqCurrentGroup turqCurrentGroup) {
        this.turqCurrentGroup = turqCurrentGroup;
    }

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentCardsGroupsId", getCurrentCardsGroupsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentCardsGroup) ) return false;
        TurqCurrentCardsGroup castOther = (TurqCurrentCardsGroup) other;
        return new EqualsBuilder()
            .append(this.getCurrentCardsGroupsId(), castOther.getCurrentCardsGroupsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentCardsGroupsId())
            .toHashCode();
    }

}
