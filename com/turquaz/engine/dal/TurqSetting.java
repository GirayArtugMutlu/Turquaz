package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqSetting implements Serializable {

    /** identifier field */
    private java.lang.String databaseVersion;

    /** full constructor */
    public TurqSetting(java.lang.String databaseVersion) {
        this.databaseVersion = databaseVersion;
    }

    /** default constructor */
    public TurqSetting() {
    }

    public java.lang.String getDatabaseVersion() {
        return this.databaseVersion;
    }

    public void setDatabaseVersion(java.lang.String databaseVersion) {
        this.databaseVersion = databaseVersion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("databaseVersion", getDatabaseVersion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqSetting) ) return false;
        TurqSetting castOther = (TurqSetting) other;
        return new EqualsBuilder()
            .append(this.getDatabaseVersion(), castOther.getDatabaseVersion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDatabaseVersion())
            .toHashCode();
    }

}
