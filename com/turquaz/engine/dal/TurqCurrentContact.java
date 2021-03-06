package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqCurrentContact implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.lang.String contactsName;

    /** persistent field */
    private java.lang.String contactAddress;

    /** persistent field */
    private java.lang.String contactsPhone1;

    /** persistent field */
    private java.lang.String contactsPhone2;

    /** persistent field */
    private java.lang.String contactsFaxNumber;

    /** persistent field */
    private java.lang.String contactsEmail;

    /** nullable persistent field */
    private java.lang.String contactsWebSite;

    /** persistent field */
    private java.lang.String createdBy;

    /** persistent field */
    private java.util.Date creationDate;

    /** persistent field */
    private java.lang.String updatedBy;

    /** persistent field */
    private java.util.Date lastModified;

    /** persistent field */
    private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;

    /** full constructor */
    public TurqCurrentContact(java.lang.String contactsName, java.lang.String contactAddress, java.lang.String contactsPhone1, java.lang.String contactsPhone2, java.lang.String contactsFaxNumber, java.lang.String contactsEmail, java.lang.String contactsWebSite, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.contactsName = contactsName;
        this.contactAddress = contactAddress;
        this.contactsPhone1 = contactsPhone1;
        this.contactsPhone2 = contactsPhone2;
        this.contactsFaxNumber = contactsFaxNumber;
        this.contactsEmail = contactsEmail;
        this.contactsWebSite = contactsWebSite;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCurrentCard = turqCurrentCard;
    }

    /** default constructor */
    public TurqCurrentContact() {
    }

    /** minimal constructor */
    public TurqCurrentContact(java.lang.String contactsName, java.lang.String contactAddress, java.lang.String contactsPhone1, java.lang.String contactsPhone2, java.lang.String contactsFaxNumber, java.lang.String contactsEmail, java.lang.String createdBy, java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard) {
        this.contactsName = contactsName;
        this.contactAddress = contactAddress;
        this.contactsPhone1 = contactsPhone1;
        this.contactsPhone2 = contactsPhone2;
        this.contactsFaxNumber = contactsFaxNumber;
        this.contactsEmail = contactsEmail;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.updatedBy = updatedBy;
        this.lastModified = lastModified;
        this.turqCurrentCard = turqCurrentCard;
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getContactsName() {
        return this.contactsName;
    }

    public void setContactsName(java.lang.String contactsName) {
        this.contactsName = contactsName;
    }

    public java.lang.String getContactAddress() {
        return this.contactAddress;
    }

    public void setContactAddress(java.lang.String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public java.lang.String getContactsPhone1() {
        return this.contactsPhone1;
    }

    public void setContactsPhone1(java.lang.String contactsPhone1) {
        this.contactsPhone1 = contactsPhone1;
    }

    public java.lang.String getContactsPhone2() {
        return this.contactsPhone2;
    }

    public void setContactsPhone2(java.lang.String contactsPhone2) {
        this.contactsPhone2 = contactsPhone2;
    }

    public java.lang.String getContactsFaxNumber() {
        return this.contactsFaxNumber;
    }

    public void setContactsFaxNumber(java.lang.String contactsFaxNumber) {
        this.contactsFaxNumber = contactsFaxNumber;
    }

    public java.lang.String getContactsEmail() {
        return this.contactsEmail;
    }

    public void setContactsEmail(java.lang.String contactsEmail) {
        this.contactsEmail = contactsEmail;
    }

    public java.lang.String getContactsWebSite() {
        return this.contactsWebSite;
    }

    public void setContactsWebSite(java.lang.String contactsWebSite) {
        this.contactsWebSite = contactsWebSite;
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
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqCurrentContact) ) return false;
        TurqCurrentContact castOther = (TurqCurrentContact) other;
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
