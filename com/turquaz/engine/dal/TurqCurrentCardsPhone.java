package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentCardsPhone implements Serializable {

    /** identifier field */
    private java.lang.Integer currentCardsPhonesId;

    /** persistent field */
    private int phonesCountryCode;

    /** persistent field */
    private int phonesCityCode;

    /** persistent field */
    private int phonesNumber;

    /** persistent field */
    private java.lang.String phonesType;

    /** persistent field */
    private java.lang.String createdBy;

    /** nullable persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** full constructor */
    public TurqCurrentCardsPhone(int phonesCountryCode, int phonesCityCode, int phonesNumber, java.lang.String phonesType, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.phonesCountryCode = phonesCountryCode;
        this.phonesCityCode = phonesCityCode;
        this.phonesNumber = phonesNumber;
        this.phonesType = phonesType;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCurrentCard = turqCurrentCard;
    }

    /** default constructor */
    public TurqCurrentCardsPhone() {
    }

    /** minimal constructor */
    public TurqCurrentCardsPhone(int phonesCountryCode, int phonesCityCode, int phonesNumber, java.lang.String phonesType, java.lang.String createdBy, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.phonesCountryCode = phonesCountryCode;
        this.phonesCityCode = phonesCityCode;
        this.phonesNumber = phonesNumber;
        this.phonesType = phonesType;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCurrentCard = turqCurrentCard;
    }

    public java.lang.Integer getCurrentCardsPhonesId() {
        return this.currentCardsPhonesId;
    }

    public void setCurrentCardsPhonesId(java.lang.Integer currentCardsPhonesId) {
        this.currentCardsPhonesId = currentCardsPhonesId;
    }

    public int getPhonesCountryCode() {
        return this.phonesCountryCode;
    }

    public void setPhonesCountryCode(int phonesCountryCode) {
        this.phonesCountryCode = phonesCountryCode;
    }

    public int getPhonesCityCode() {
        return this.phonesCityCode;
    }

    public void setPhonesCityCode(int phonesCityCode) {
        this.phonesCityCode = phonesCityCode;
    }

    public int getPhonesNumber() {
        return this.phonesNumber;
    }

    public void setPhonesNumber(int phonesNumber) {
        this.phonesNumber = phonesNumber;
    }

    public java.lang.String getPhonesType() {
        return this.phonesType;
    }

    public void setPhonesType(java.lang.String phonesType) {
        this.phonesType = phonesType;
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

    public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard() {
        return this.turqCurrentCard;
    }

    public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.turqCurrentCard = turqCurrentCard;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("currentCardsPhonesId", getCurrentCardsPhonesId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentCardsPhone) ) return false;
        TurqCurrentCardsPhone castOther = (TurqCurrentCardsPhone) other;
        return new EqualsBuilder()
            .append(this.getCurrentCardsPhonesId(), castOther.getCurrentCardsPhonesId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCurrentCardsPhonesId())
            .toHashCode();
    }

}
